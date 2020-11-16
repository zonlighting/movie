package ssv.com.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ssv.com.dto.ChangePassDto;
import ssv.com.jwt.JwtTokenProvider;
import ssv.com.payload.LoginRequest;
import ssv.com.payload.LoginResponse;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private RedisTemplate<String, String> template;

	@PostMapping("/login")
	public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		// Nếu không xảy ra exception tức là thông tin hợp lệ
		// Set thông tin authentication vào Security Context
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Trả về jwt cho người dùng.
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		template.opsForList().rightPushAll(loginRequest.getUsername(), jwt);
		return new LoginResponse(jwt);
	}

	// Api /api/random yêu cầu phải xác thực mới có thể request
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/random")
	public String randomStuff(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		token = token.replace("Bearer ", "");
		Long jwt = tokenProvider.getUserIdFromJWT(token);
		User user = userService.findById(jwt);
		ArrayList<String> list = (ArrayList<String>) template.opsForList().range(user.getUsername(), 0, -1);
		for (String string : list) {
			if (string.equals(token)) {
				return "yes";
			}
		}
		return "No";
	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<User>> getAll() {
		return new ResponseEntity<List<User>>(userService.getAll(), HttpStatus.OK);
	}

	@PostMapping(value = "/signUp")
	public ResponseEntity<String> signUp(@RequestBody LoginRequest loginRequest) {
		userService.signUp(loginRequest);
		return new ResponseEntity<String>("thành công ", HttpStatus.OK);
	}

	@PostMapping(value = "/changePassWord")
	public ResponseEntity<String> changePassWord(@RequestBody ChangePassDto changePassDto) {
		User user = userService.findByUserName(changePassDto.getUserName());
		if (user == null) {
			return new ResponseEntity<String>("Tài khoản không tồn tại", HttpStatus.OK);
		} else {
			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(changePassDto.getUserName(),
								changePassDto.getPassWord()));
				System.out.println(authentication);

			} catch (Exception e) {
				return new ResponseEntity<String>("Sai mật khẩu", HttpStatus.OK);
			}
			template.delete(user.getUsername());
			userService.changePassWord(changePassDto);
			return new ResponseEntity<String>("Đổi mật khẩu thành công", HttpStatus.OK);

		}
	}

}