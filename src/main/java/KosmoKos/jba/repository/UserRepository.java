package KosmoKos.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import KosmoKos.jba.entity.User;



public interface UserRepository extends JpaRepository<User, Integer>{

}
