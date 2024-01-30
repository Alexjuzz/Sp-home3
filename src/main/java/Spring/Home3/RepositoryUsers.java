package Spring.Home3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class RepositoryUsers {
    private final NotificationService notificationService;
    private List<User> users = new ArrayList<>();

    @Autowired
    public RepositoryUsers(NotificationService notificationService) {
        this.notificationService = notificationService;
    }




    public boolean addUser(User user) {
        synchronized (users) {
            if (user != null && checkAlreadyFind(user)) {
                users.add(user);
                notificationService.notifyUser(user);
                return true;
            }
            notificationService.badnotifyUser(user);
            return false;
        }
    }

    private boolean checkAlreadyFind(User user) {
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) || u.getName().equals(user.getName()))
                return false;
        }

        return true;
    }

    public boolean checkUser(String name, String email, String password) {
        return users.stream().anyMatch(u -> u.getName().equals(name) && u.getEmail().equals(email) && u.getPassword().equals(password));
    }

}


