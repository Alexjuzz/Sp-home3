package Spring.Home3;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DataProcessingController {
    private final DataProcessingService dataProcessingService;
    private final AuthorisationService authorisationService;

    public DataProcessingController(DataProcessingService dataProcessingService,AuthorisationService authorisationService) {
        this.dataProcessingService = dataProcessingService;
        this.authorisationService = authorisationService;
    }

    //region методы с лекции
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        String response = this.dataProcessingService.getGreeting();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/sort", method = RequestMethod.POST)
    public ResponseEntity<List<User>> sortUsers(@RequestBody List<User> users) {
        return  new ResponseEntity<>(dataProcessingService.sortUsersByAge(users), HttpStatus.OK);
    }
    @RequestMapping(value = "/filter/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> filterByAge(@PathVariable("age") Integer age, @RequestBody List<User> users){
        return new ResponseEntity<>(dataProcessingService.filterUsersByAge(users,age),HttpStatus.OK);
    }
    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public ResponseEntity<Double> calc(@RequestBody List<User> users){
        return new ResponseEntity<>(dataProcessingService.calculateAverageAge(users),HttpStatus.OK);
    }
    //endregion

    //region метода для работы с авторизацией.  **  Не разобрался как отобразить строку в браузере.
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<String> authorisationUser(@RequestParam String name,@RequestParam String email, @RequestParam String password){
       if(authorisationService.getAcces(name,email,password)){
           String response = authorisationService.successfulLogin(name,email);
           return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
       }else
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    //endregion
}
