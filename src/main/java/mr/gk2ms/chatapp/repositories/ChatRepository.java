package mr.gk2ms.chatapp.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.ChatEntity;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, UUID> {

	// @Query(
	// "SELECT c.* FROM ChatEntity c WHERE c.recipientA = :userId OR c.recipientB =
	// :userId "
	// + "LIMIT :limit OFFSET :offset"
	// )
	// public
	// Optional<List<ChatEntity>>
	// getAllChatsByUserId(@Param("userId") UUID userId, @Param("limit") UUID limit,
	// @Param("offset") UUID offset);

	@Query(
		value = "SELECT * FROM chats WHERE recipient_a = :userId OR recipient_b = :userId",
		countQuery = "SELECT COUNT(*) FROM chats WHERE recipient_a = :userId OR recipient_b = :userId",
		nativeQuery = true
	)
	public Page<ChatEntity> getAllChatsByUserId(@Param("userId") UUID userId, Pageable pageable);

	@Query(
		"SELECT c FROM ChatEntity c WHERE "
			+ "(c.recipientA = :recipient1 AND c.recipientB = :recipient2) OR c.recipientA = :recipient2 AND c.recipientB = :recipient1"
	)
	public
		Optional<ChatEntity>
		getChatByRecipients(@Param("recipient1") UUID recipient1, @Param("recipient2") UUID recipient2);
}
