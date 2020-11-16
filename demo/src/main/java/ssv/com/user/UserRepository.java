package ssv.com.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ssv.com.dto.ChangePassDto;
import ssv.com.payload.LoginRequest;

@Repository
public class UserRepository {
	@Autowired
	private UserMapper userMapper;
	public List<User> getAll() {
		return userMapper.getAll();
	}
	public User findByUsername(String username) {
		return userMapper.findByUsername(username);
	}
	public User loadUserById(Long userId) {
		return userMapper.loadUserById(userId);
	}
	public void signUp(LoginRequest loginRequest) {
		userMapper.signUp(loginRequest);
	}
	public void changePassWord(ChangePassDto changePassDto) {
		userMapper.changePassWord(changePassDto);
		
	}

}
