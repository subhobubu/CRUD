package user.example.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import user.example.user.model.UserModel;

@EnableJpaRepositories
public interface UserDao extends JpaRepository<UserModel, Long>{

	
}
