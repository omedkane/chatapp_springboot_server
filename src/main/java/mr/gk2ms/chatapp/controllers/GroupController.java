package mr.gk2ms.chatapp.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.gk2ms.chatapp.entities.GroupEntity;
import mr.gk2ms.chatapp.entities.UserEntity;
import mr.gk2ms.chatapp.services.GroupService;
import mr.gk2ms.chatapp.services.UserService;
import mr.gk2ms.chatapp.utilities.classes.QuickResponses;
import mr.gk2ms.chatapp_spring_server.model.Group;
import mr.gk2ms.chatapp_spring_server.model.GroupUpdateRequest;
import mr.gk2ms.chatapp_spring_server.model.UpdateGroupMembersRequest;
import mr.gk2ms.chatapp_spring_server.model.User;
import mr.gk2ms.chatapp_spring_server.model.UpdateGroupMembersRequest.OperationEnum;

@RestController
@RequestMapping("/groups")
public class GroupController {
	private GroupService service;
	private UserService userService;

	public GroupController(GroupService service, UserService userService) {
		this.service = service;
		this.userService = userService;
	}

	@PostMapping
	public ResponseEntity<Group> create(@RequestBody GroupUpdateRequest creationRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createGroup(creationRequest));
	}

	@GetMapping("/{groupId}")
	public ResponseEntity<Group> read(@PathVariable("groupId") String groupId) {
		UserEntity user = userService.getCurrentUser();

		System.out.println(user.getEmail());

		GroupEntity group = service.findGroupByIdAndMember(groupId, user);
		return ResponseEntity.ok(service.toModel(group));
	}

	@PutMapping("/{groupId}")
	public
		ResponseEntity<Object>
		updateGroup(@PathVariable("groupId") String groupId, @RequestBody GroupUpdateRequest request) {
		System.out.println("Got here at least !");
		return ResponseEntity
			.ok(
				QuickResponses
					.message("Group's information successfully modified !", service.updateGroup(groupId, request))
			);
	}

	@DeleteMapping("/{groupId}")
	public ResponseEntity<Object> delete(@PathVariable("groupId") String groupId) {
		service.removeGroupById(groupId);
		return ResponseEntity.ok(QuickResponses.message("Group successfully removed"));
	}

	@PutMapping("/{groupId}/members")
	public
		ResponseEntity<Object>
		addMembers(@PathVariable("groupId") String groupId, @RequestBody UpdateGroupMembersRequest request) {
		OperationEnum operation = request.getOperation();
		List<User> targetMembers = request.getTargetMembers();

		switch (operation) {
		case ADD:
			// <-
			service.addGroupMembers(groupId, targetMembers);
			return ResponseEntity.ok(QuickResponses.message("Members successfully added !"));

		// ->
		case REMOVE:
			service.removeGroupMembers(groupId, targetMembers);
			return ResponseEntity.ok(QuickResponses.message("Members successfully removed !"));
		case ADMINISTRATION:
			service.updateAdministrators(groupId, targetMembers);
			return ResponseEntity.ok(QuickResponses.message("Group administrators successfully updated"));
		default:
			return ResponseEntity.badRequest().build();
		}

	}
}
