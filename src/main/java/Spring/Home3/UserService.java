package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
      public User createUser(String name, int age, String email,String password) {
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }
}
