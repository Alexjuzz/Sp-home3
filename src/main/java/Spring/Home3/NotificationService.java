package Spring.Home3;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void notifyUser(User user){
        System.out.println("A new user has been created: " + user.getName());

    }
    public void badnotifyUser(User user){
        System.out.println("Cannot create user, User already created  " + user.getName() );
    }


}
