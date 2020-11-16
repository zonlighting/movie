package ssv.com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ssv.com.dto.ChangePassDto;
import ssv.com.payload.LoginRequest;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Kiểm tra xem user có tồn tại trong database không?
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomUserDetails(user);
	}

	public UserDetails loadUserById(Long userId) {
		User user= userRepository.loadUserById(userId);
		return new CustomUserDetails(user);
		
	}

	public void signUp(LoginRequest loginRequest) {
		loginRequest.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
		userRepository.signUp(loginRequest);

	}

	public User findById(Long jwt) {
		return userRepository.loadUserById(jwt);
		
	}

	public User findByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}

	public void changePassWord(ChangePassDto changePassDto) {
		changePassDto.setNewPassWord(passwordEncoder.encode(changePassDto.getNewPassWord()));
		userRepository.changePassWord(changePassDto);
	}

}
