package KosmoKos.jba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import KosmoKos.jba.entity.Blog;
import KosmoKos.jba.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	List<Blog> findByUser(User user);
}
