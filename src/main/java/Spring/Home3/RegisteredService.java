package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
public class RegisteredService {
    private final UserService userService;
    private final RepositoryUsers users;


    @Autowired
    public RegisteredService(UserService userService,RepositoryUsers repo) {
        this.users = repo;
        this.userService = userService;
    }

    // Кустарный метод для  проверки валидности данных
    public User registerNewUser(String name, int age, String email,String password) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age <= 0) {
            throw new IllegalArgumentException("Возраст должен быть больше нуля");
        }
        if (email == null || !email.contains("@")) { // Простая проверка email
            throw new IllegalArgumentException("Некорректный адрес электронной почты");
        }
        User newUser = userService.createUser(name, age, email,password);
        users.addUser(newUser);
        return newUser;
    }
}

