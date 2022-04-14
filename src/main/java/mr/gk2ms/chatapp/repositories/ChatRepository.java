package mr.gk2ms.chatapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

}
