package mr.gk2ms.chatapp.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.GroupMessageEntity;

@Repository
public interface GroupMessageRepository extends JpaRepository<GroupMessageEntity, UUID> {

}
