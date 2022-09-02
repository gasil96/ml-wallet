package com.ml.wallet.services;

import com.ml.wallet.Utils;
import com.ml.wallet.dtos.UserDTO;
import com.ml.wallet.entities.User;
import com.ml.wallet.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	public void create(UserDTO userDTO) {
		log.info("UserServiceImpl.create - Input - user.email: {} ", userDTO.getEmail());
		User user = mapper.map(userDTO, User.class);

		userRepository.save(user);
		log.debug("UserServiceImpl.create - End - user: {}", userDTO);
	}

	@Override
	public void update(UserDTO userDTO) {
		log.info("UserServiceImpl.update - Input - user.email: {} ", userDTO.getEmail());
		User user = mapper.map(userDTO, User.class);

		userRepository.save(user);
		log.debug("UserServiceImpl.update - End - user: {}", userDTO);
	}

	@Override
	public void delete(UserDTO userDTO) {
		log.info("UserServiceImpl.delete - Input - user.email: {} ", userDTO.getEmail());
		User user = mapper.map(userDTO, User.class);

		userRepository.delete(user);
		log.debug("UserServiceImpl.delete - End - user: {}", userDTO);
	}

	@Override
	public Page<UserDTO> listAll(Pageable pageable) {
		log.info("UserServiceImpl.listAll - Input - pageSize: {} ", pageable.getPageSize());

		Page<User> entities = userRepository.findAll(pageable);
		Page<UserDTO> userDTO = Utils.mapEntityPageIntoDtoPage(entities, UserDTO.class);

		log.debug("UserServiceImpl.listAll - End - listSize: {} ", userDTO.getContent().size());
		return userDTO;
	}

}
