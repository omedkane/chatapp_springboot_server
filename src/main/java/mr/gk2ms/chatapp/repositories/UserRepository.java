package mr.gk2ms.chatapp.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mr.gk2ms.chatapp.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

	@Query("SELECT u from UserEntity u WHERE u.email = :email")
	public Optional<UserEntity> findByEmail(@Param("email") String email);

	@Query("SELECT u FROM UserEntity u WHERE u.email IN :emails")
	public List<UserEntity> findAllByEmail(@Param("emails") List<String> emails);
}
