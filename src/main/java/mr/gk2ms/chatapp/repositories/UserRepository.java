package mr.gk2ms.chatapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("SELECT u from UserEntity u WHERE u.email = :email")
	public Optional<UserEntity> findByEmail(@Param("email") String email);
}
