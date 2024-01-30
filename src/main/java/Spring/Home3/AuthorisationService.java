package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorisationService {

     private final RepositoryUsers repositoryUsers;
    private final NotificationService notificationService;
    @Autowired
    public AuthorisationService(RepositoryUsers repositoryUsers,NotificationService notificationService) {
            this.notificationService = notificationService;
            this.repositoryUsers = repositoryUsers;
    }

    public boolean getAcces(String name, String email, String password) {
        System.out.println(name + " " + email + " " + password);
        System.out.println(repositoryUsers.checkUser(name,email,password));
         return  repositoryUsers.checkUser(name,password,email);
    }

    public String successfulLogin(String name, String email) {

        return "Вы успешно зашли под логином " + name + " ваша почта: " + email;
    }
}
