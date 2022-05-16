package mr.gk2ms.chatapp.services;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import mr.gk2ms.chatapp.entities.GroupEntity;
import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.exceptions.InvalidRequestException;
import mr.gk2ms.chatapp.exceptions.ResourceNotFoundException;
import mr.gk2ms.chatapp.miscellaneous.utilities.ListOperation;
import mr.gk2ms.chatapp.repositories.GroupRepository;
import mr.gk2ms.chatapp.utilities.helpers.CollectionHelper;
import mr.gk2ms.chatapp_spring_server.model.Group;
import mr.gk2ms.chatapp_spring_server.model.GroupUpdateRequest;
import mr.gk2ms.chatapp_spring_server.model.User;

@Service
public class GroupService extends BaseService<GroupEntity, Group> {
	private GroupRepository repository;
	private UserService userService;

	public GroupService(GroupRepository repository, UserService userService) {
		this.repository = repository;
		this.userService = userService;
	}

	public Group createGroup(GroupUpdateRequest request) {
		UserEntity currentUser = userService.getCurrentUser();
		Set<UserEntity> admins = Set.of(currentUser);
		Set<UserEntity> members = Set.of(currentUser);

		GroupEntity group = new GroupEntity()
			.name(request.getName())
			.creator(currentUser)
			.administrators(admins)
			.members(members)
			.dateCreated(Timestamp.from(Instant.now()));

		group = repository.save(group);

		return toModel(group);
	}

	public GroupEntity findGroupByIdAndAdmin(String groupId, UserEntity admin) {

		return repository.findByGroupIdAndAdmin(UUID.fromString(groupId), admin).orElseThrow(() -> {
			throw new ResourceNotFoundException("Group doesn't exist or not available to user");
		});
	}

	public GroupEntity findGroupByIdAndMember(String groupId, UserEntity user) {

		return repository.findByGroupIdAndMember(UUID.fromString(groupId), user).orElseThrow(() -> {
			throw new ResourceNotFoundException("Group doesn't exist or not available to user");
		});
	}

	public void removeGroupById(String groupId) {
		repository.findById(UUID.fromString(groupId)).ifPresentOrElse(repository::delete, () -> {
			throw new ResourceNotFoundException("Group doesn't exist");
		});
	}

	public void addGroupMembers(String groupId, List<User> membersToAdd) {
		UserEntity currentUser = userService.getCurrentUser();
		List<String> emails = StreamSupport
			.stream(membersToAdd.spliterator(), false)
			.map(member -> member.getEmail())
			.toList();

		GroupEntity group = findGroupByIdAndAdmin(groupId, currentUser);

		ListOperation<UserEntity> operation = new ListOperation<UserEntity>(emails.size());

		List<UserEntity> newMembers = StreamSupport
			.stream(userService.findAllUsersByEmail(emails).spliterator(), false)
			.map(member -> {
				operation.addSuccessful(member);
				return member;
			})
			.toList();

		if (operation.isSuccessful()) {
			Set<UserEntity> groupMembers = group.getMembers();
			System.out.println("Current number of members :" + groupMembers.size());

			for (UserEntity newMember : newMembers) {
				groupMembers.add(newMember);
			}

			repository.save(group.members(new HashSet<UserEntity>(groupMembers)));

		} else {
			throw new InvalidRequestException("Some members are not registered, operation aborted.");
		}
	}

	public void removeGroupMembers(String groupId, List<User> membersToRemove) {
		UserEntity currentUser = userService.getCurrentUser();
		List<String> emails = membersToRemove.stream().map(member -> member.getEmail()).toList();

		GroupEntity group = findGroupByIdAndAdmin(groupId, currentUser);

		ListOperation<UserEntity> operation = new ListOperation<UserEntity>(emails.size());

		userService.findAllUsersByEmail(emails).forEach(member -> {
			operation.addSuccessful(member);
		});

		if (operation.isSuccessful()) {
			Set<UserEntity> groupMembers = group.getMembers();

			groupMembers.removeIf(_member -> {
				return emails.contains(_member.getEmail());
			});

			repository.save(group.members(groupMembers));
		} else {
			throw new ResourceNotFoundException("Some members are not registered, operation aborted");
		}

	}

	public Group updateAdministrators(String groupId, List<User> targetMembers) {
		UserEntity currentUser = userService.getCurrentUser();
		List<String> emails = targetMembers.stream().map(member -> member.getEmail()).toList();

		ListOperation<UserEntity> operation = new ListOperation<UserEntity>(emails.size());

		GroupEntity group = findGroupByIdAndAdmin(groupId, currentUser);

		Set<UserEntity> members = group.getMembers();

		emails.forEach(email -> {
			CollectionHelper
				.firstWhere(members, elem -> elem.getEmail().equals(email))
				.ifPresent(operation::addSuccessful);
		});

		if (operation.isSuccessful()) {
			Set<UserEntity> newListOfMembers = new HashSet<UserEntity>(operation.getSuccessfulOnes());
			return toModel(repository.save(group.administrators(newListOfMembers)));
		} else {
			throw new ResourceNotFoundException("Some members are not registered, operation aborted");
		}
	}

	public Group updateGroup(String groupId, GroupUpdateRequest request) {
		UserEntity currentUser = userService.getCurrentUser();

		GroupEntity group = findGroupByIdAndMember(groupId, currentUser);

		group.setName(request.getName());

		return toModel(repository.save(group));
	}

	@Override
	public Group toModel(GroupEntity entity) {
		return new Group()
			.id(entity.getId().toString())
			.name(entity.getName())
			.creator(userService.toModel(entity.getCreator()))
			.members(userService.toModelAll(entity.getMembers()))
			.administrators(userService.toModelAll(entity.getAdministrators()));
	}
}
