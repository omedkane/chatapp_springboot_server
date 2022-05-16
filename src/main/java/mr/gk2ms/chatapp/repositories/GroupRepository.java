package mr.gk2ms.chatapp.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.GroupEntity;
import mr.gk2ms.chatapp.entities.UserEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {

	@Query("SELECT g FROM GroupEntity g WHERE g.id = :groupId AND :user MEMBER OF g.members")
	Optional<GroupEntity> findByGroupIdAndMember(@Param("groupId") UUID groupId, @Param("user") UserEntity user);

	@Query("SELECT g FROM GroupEntity g WHERE g.id = :groupId AND (:admin MEMBER OF g.administrators OR g.creator = :admin)")
	Optional<GroupEntity> findByGroupIdAndAdmin(@Param("groupId") UUID groupId, @Param("admin") UserEntity admin);
}
