package mr.gk2ms.chatapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.GroupEntity;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, UUID> {

}
