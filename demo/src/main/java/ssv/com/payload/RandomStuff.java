package ssv.com.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import ssv.com.user.User;

@Data
@AllArgsConstructor
public class RandomStuff {
    private User user;
    private String jwt;
}