package KosmoKos.jba.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KosmoKos.jba.repository.BlogRepository;
import KosmoKos.jba.repository.ItemRepository;
import KosmoKos.jba.repository.RoleRepository;
import KosmoKos.jba.repository.UserRepository;

@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired 
	private ItemRepository itemRepository;
	
	@PostConstruct
	
	
	

}
