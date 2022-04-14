package mr.gk2ms.chatapp.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.UserTokenEntity;

@Repository
public interface UserTokenRepository extends CrudRepository<UserTokenEntity, UUID> {

	@Query("SELECT utk FROM UserTokenEntity utk WHERE refreshToken = :refreshToken")
	Optional<UserTokenEntity> findByRefreshToken(@Param("refreshToken") String refreshToken);

	@Query("DELETE FROM UserTokenEntity WHERE userId = :userId")
	Optional<UserTokenEntity> deleteByUserId(@Param("userId") UUID userId);

	@Query("DELETE FROM UserTokenEntity WHERE refreshToken = :refreshToken")
	Optional<UserTokenEntity> deleteByRefreshToken(@Param("refreshToken") String refreshToken);
}
