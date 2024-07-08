package net.majid.accountservice.web;

import net.majid.accountservice.entities.BankAccount;
import net.majid.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository accountRepository;

    public AccountRestController(BankAccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        return accountRepository.findById(id).get();
    }



}
