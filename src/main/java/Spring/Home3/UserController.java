package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reg")
public class UserController {
    private final RegisteredService registeredService;

    @Autowired

    public UserController(RegisteredService registeredService) {
        this.registeredService = registeredService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody String password,@RequestParam String name, @RequestParam int age, @RequestParam String email ) {
        return new ResponseEntity<>(registeredService.registerNewUser(name, age, email,password), HttpStatus.CREATED);
    }
}
