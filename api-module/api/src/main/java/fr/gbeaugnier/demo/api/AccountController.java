package fr.gbeaugnier.demo.api;

import fr.gbeaugnier.demo.adapter.AccountApiAdapter;
import fr.gbeaugnier.demo.payload.AccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountApiAdapter accountAdapter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createAccount(@RequestParam("accountId") String accountId) {
        accountAdapter.createAccount(accountId);
        log.info("Created account {}", accountId);
    }

    @PutMapping("deposit")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deposit(@RequestBody AccountRequest request) {
        accountAdapter.deposit(request);
        log.info("Deposited account {}", request);
    }

    @PutMapping("withdraw")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void withdraw(@RequestBody AccountRequest request) {
        accountAdapter.withdraw(request);
        log.info("Withdrawn account {}", request);
    }

}
