package books;

//import application.models.User;
//import application.repositories.UserRepository;
//import application.services.Account.AccountServiceImpl;
//import application.services.User.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
//    private UserServiceImpl userService;
//    private AccountServiceImpl accountService;
//    private UserRepository userRepository;

//    @Autowired
//    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService, UserRepository userRepository) {
//        this.userService = userService;
//        this.accountService = accountService;
//        this.userRepository = userRepository;
//    }

    @Override
    public void run(String... strings) throws Exception {
//        User user  = new User();
//        user.setAge(20);
//        user.setUsername("Stamat2");
//
//        Account account = new Account();
//        account.setBalance(new BigDecimal(200));
//        account.setUser(user);
//
////        List<Account> accounts = user.getAccounts();
////        accounts.add(acc);
////        user.setAccounts(accounts);
//        user.setAccounts(Collections.singletonList(account));

      //  this.userService.registerUser(user);

//        User user = userRepository.findOne(3L);
//        System.out.println(user.getUsername());
//
//       // this.accountService.transferMoney(new BigDecimal(-100), 1L);
//        this.accountService.transferMoney(new BigDecimal(2000), 1L);
//
//        this.accountService.withdrawMoney(new BigDecimal(600), 1L);
    }
}
