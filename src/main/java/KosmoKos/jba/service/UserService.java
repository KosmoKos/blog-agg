package KosmoKos.jba.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import KosmoKos.jba.entity.Blog;
import KosmoKos.jba.entity.Item;
import KosmoKos.jba.entity.User;
import KosmoKos.jba.repository.BlogRepository;
import KosmoKos.jba.repository.ItemRepository;
import KosmoKos.jba.repository.UserRepository;

@Transactional
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}


	public User findOne(int id) {
		
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(int id) {
		User user = findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			List<Item> items = itemRepository.findByBlog(blog);
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}


	
}
