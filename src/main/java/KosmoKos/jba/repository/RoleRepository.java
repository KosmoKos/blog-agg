package KosmoKos.jba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import KosmoKos.jba.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	 Role findByName(String name);

}
