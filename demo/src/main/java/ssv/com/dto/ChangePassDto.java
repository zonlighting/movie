package ssv.com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePassDto {
	private String userName;
	private String passWord;
	private String newPassWord;
}
