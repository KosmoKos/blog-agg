package KosmoKos.jba.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import KosmoKos.jba.entity.Item;
import KosmoKos.jba.entity.Blog;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog, Pageable pageable);

	Item findByBlogAndLink(Blog blog, String link);

	
}
