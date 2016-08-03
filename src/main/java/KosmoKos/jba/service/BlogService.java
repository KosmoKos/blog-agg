package KosmoKos.jba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KosmoKos.jba.entity.Blog;
import KosmoKos.jba.entity.User;
import KosmoKos.jba.repository.BlogRepository;
import KosmoKos.jba.repository.UserRepository;

@Service
public class BlogService {

		@Autowired
		private BlogRepository blogRepository;
		
		@Autowired
		private UserRepository userRepository;
		
	public void save(Blog blog, String name) {
		User user =  userRepository.findByName(name);
		blog.setUser(user);
		blogRepository.save(blog);
						
	}

	public void delete(int id) {
		blogRepository.delete(id);
		
	}
	
}

