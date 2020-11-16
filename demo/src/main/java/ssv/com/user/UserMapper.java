package ssv.com.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import ssv.com.dto.ChangePassDto;
import ssv.com.payload.LoginRequest;

@Mapper
public interface UserMapper {

	List<User> getAll();

	User findByUsername(String username);

	User loadUserById(Long userId);

	void signUp(@Param("loginRequest")LoginRequest loginRequest);

	void changePassWord(@Param("changePassDto")ChangePassDto changePassDto);
	
}
