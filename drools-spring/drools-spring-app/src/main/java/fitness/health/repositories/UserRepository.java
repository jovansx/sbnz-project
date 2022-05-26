package fitness.health.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fitness.health.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
