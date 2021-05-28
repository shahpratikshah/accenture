package com.shah.boothazelcast.controller;

import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.PredicateBuilder;
import com.hazelcast.query.Predicates;
import com.shah.boothazelcast.entity.UserAccount;
import com.shah.boothazelcast.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private Map<String, UserAccount> accountMap;

    @GetMapping("/get/{accountNumber}")
    public UserAccount getUser(@PathVariable("accountNumber") String accountNumber){
        UserAccount userAccount = accountMap.get(accountNumber);
        UserAccount account;
        if(userAccount!=null)
            return userAccount;
        else
            account = userService.getUser(accountNumber);

        accountMap.put(account.getAccountNumber(), account);
        return account;


    }

    @PostMapping("/add")
    public Long createUser(@RequestBody UserAccount userAccount){
        accountMap.put(userAccount.getAccountNumber(),userAccount);
        return userService.createUser(userAccount);
    }

    @PutMapping("/update")
    public UserAccount updateUser(@RequestBody UserAccount userAccount){
        UserAccount account = userService.updateUser(userAccount);
        accountMap.put(account.getAccountNumber(), account);
        return account;
    }

    @GetMapping("/tot-balance")
    public int totalBalance(){
        return
                accountMap
                        .values()
                        .stream()
                        .mapToInt(UserAccount::returnInt)
                        .sum();
    }


    @DeleteMapping("/{accountNumber}")
    public UserAccount deleteUser(@PathVariable("accountNumber") String accountNumber){
        accountMap.remove(accountNumber);
        return userService.deleteByAccountNumber(accountNumber);
    }

    @GetMapping("/bal-above/{thresholdBalance}")
    public Collection<UserAccount>balanceAbove(@PathVariable(name = "thresholdBalance") int thresholdBalance){

        IMap<String, UserAccount> map = (IMap<String, UserAccount>) accountMap;

        PredicateBuilder.EntryObject e = Predicates.newPredicateBuilder().getEntryObject();
        Predicate predicate = e.get("balance").greaterEqual(thresholdBalance);
        Collection<UserAccount> accounts = map.values(predicate);
        return accounts;
    }



}
