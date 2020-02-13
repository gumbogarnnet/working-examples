/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.online.bank.online.bank.controller;

import com.online.bank.online.bank.dao.AppointmentsDao;
import com.online.bank.online.bank.dao.HistoryDao;
import com.online.bank.online.bank.dao.PrimaryAccountDao;
import com.online.bank.online.bank.dao.SavingsDao;
import com.online.bank.online.bank.dao.UserDao;
import com.online.bank.online.bank.dto.DepositDto;
import com.online.bank.online.bank.model.Appointments;
import com.online.bank.online.bank.model.History;
import com.online.bank.online.bank.model.PrimaryAccount;
import com.online.bank.online.bank.model.Savings;
import com.online.bank.online.bank.model.User;
import com.online.bank.online.bank.model.UserView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gumbo
 */
@Controller
@Slf4j
public class controller {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    UserDao userDao;
    @Autowired
    PrimaryAccountDao primaryAccountDao;
    @Autowired
    SavingsDao savingsDao;
    @Autowired
    HistoryDao historyDao;
@Autowired
AppointmentsDao appointmentsDao;

    @RequestMapping("/")
    public String home(Model model, Principal principal) {

        User user = new User();
        Savings savings = new Savings();
        PrimaryAccount primaryAccount = new PrimaryAccount();

        String email = principal.getName();
        savings = savingsDao.findByEmail(email);
        primaryAccount = primaryAccountDao.findByEmail(email);
        log.info("savings" + savings);
        log.info("primary" + primaryAccount);

        model.addAttribute("currentuser", email);
        model.addAttribute("savings", savings.getBalance());
        model.addAttribute("primary", primaryAccount.getBalance());

        return "home";

    }

    @RequestMapping("/home")

    public String homepage(Model model, Principal principal) {
        User user = new User();
        Savings savings = new Savings();
        PrimaryAccount primaryAccount = new PrimaryAccount();

        String email = principal.getName();
        savings = savingsDao.findByEmail(email);
        primaryAccount = primaryAccountDao.findByEmail(email);

        model.addAttribute("currentuser", email);
        model.addAttribute("savings", savings.getBalance());
        model.addAttribute("primaryAccount", primaryAccount.getBalance());

        return "home";

    }

    @RequestMapping("/deposit")
    public String deposit(Model model) {
        DepositDto depositDto = new DepositDto();
        model.addAttribute("deposit", depositDto);
        return "deposit";

    }

    @RequestMapping("/withdraw")
    public String withdraw(Model model) {
        DepositDto depositDto = new DepositDto();
        model.addAttribute("withdraw", depositDto);
        return "withdraw";

    }

    @RequestMapping("/appointments")
    public String appointments(Model model) {
        Appointments appointments = new Appointments();
        model.addAttribute("appointments", appointments);
        return "appointments";

    }

    @RequestMapping("/login")
    public String login() {

        return "login";

    }

    @RequestMapping("/addrecipient")
    public String addrecipient(Model model, Principal principal) {
        List<UserView> savings = new ArrayList<>();
        savings = savingsDao.findAllviewexp(principal.getName());
        model.addAttribute("savings", savings);
        return "addrecipient";

    }

    @RequestMapping("/internal")
    public String internal(Model model) {
        DepositDto depositDto = new DepositDto();
        model.addAttribute("internal", depositDto);
        return "internal";

    }

    @RequestMapping("/external")
    public String external(Model model, Principal principal) {
        DepositDto depositDto = new DepositDto();
        model.addAttribute("external", depositDto);
        List<Savings> savings = new ArrayList<>();
        savings = savingsDao.findAllexp(principal.getName());
        model.addAttribute("savings", savings);
        return "external";

    }

    @RequestMapping("/primary")
    public String primary(Model model, Principal principal) {
        User user = new User();
        List<History> history = new ArrayList<>();

        PrimaryAccount primaryAccount = new PrimaryAccount();
        String email = principal.getName();
        primaryAccount = primaryAccountDao.findByEmail(email);
        history = historyDao.getprimary(email);
        model.addAttribute("history", history);
        model.addAttribute("primaryAccount", primaryAccount.getBalance());
        return "primary";

    }

    @RequestMapping("/savings")
    public String savings(Model model, Principal principal) {
        User user = new User();
        List<History> history = new ArrayList<>();

        Savings savings = new Savings();
        String email = principal.getName();
        savings = savingsDao.findByEmail(email);
        history = historyDao.getSavings(email);
        model.addAttribute("history", history);
        model.addAttribute("savings", savings.getBalance());
        return "savings";

    }

    @RequestMapping("/register")
    public String registerUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }
    
    @RequestMapping("/profile")
    public String profile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userDao.findByEmail(email);
        model.addAttribute("user", user);
        
        Savings savings = savingsDao.findByEmail(email);
        PrimaryAccount primaryAccount = primaryAccountDao.findByEmail(email);

        model.addAttribute("currentuser", email);
        model.addAttribute("savings", savings.getBalance());
        model.addAttribute("primaryAccount", primaryAccount.getBalance());
        return "profile";
    }

    @PostMapping("/updateuser")
    public String editAccount(@ModelAttribute("user") User user) {
       
        
        userDao.edit(user);
        
        return "redirect:/profile";
    }
    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus("enabled");
        userDao.save(user);

        int savingsNumber = (int) (Math.random() * ((9999999 - 1000000) + 1)) + 1000000;
        savingsDao.save(savingsNumber, user.getEmail());

        primaryAccountDao.save(savingsNumber, user.getEmail());
        return "redirect:/";
    }

    @PostMapping("/deposit")
    public String deposit(@ModelAttribute("deposit") DepositDto depositDto, Principal principal) {

        String account = depositDto.getAccountType();
        Integer amount = depositDto.getAmount();
        String email = principal.getName();

        if ("savings".equals(account)) {
            savingsDao.deposit(amount, email, account);
            Savings savings = new Savings();
            savings = savingsDao.findByEmail(email);
            Integer balance = savings.getBalance();
            String type = "deposit";
            historyDao.save(amount, email, account, balance, type);
        }
        if ("primary".equals(account)) {
            primaryAccountDao.deposit(amount, email, account);
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount = primaryAccountDao.findByEmail(email);
            Integer balance = primaryAccount.getBalance();
            String type = "deposit";
            historyDao.save(amount, email, account, balance, type);
        }

        return "redirect:/";
    }

    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("withdraw") DepositDto depositDto, Principal principal) {

        String account = depositDto.getAccountType();
        Integer amount = depositDto.getAmount();
        String email = principal.getName();

        if ("savings".equals(account)) {
            savingsDao.withdraw(amount, email, account);
            Savings savings = new Savings();
            savings = savingsDao.findByEmail(email);
            Integer balance = savings.getBalance();
            String type = "withdraw";
            historyDao.save(amount, email, account, balance, type);
        }
        if ("primary".equals(account)) {
            primaryAccountDao.withdraw(amount, email, account);
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount = primaryAccountDao.findByEmail(email);
            Integer balance = primaryAccount.getBalance();
            String type = "withdraw";
            historyDao.save(amount, email, account, balance, type);
        }

        return "redirect:/";
    }

    @PostMapping("/external")
    public String external(@ModelAttribute("external") DepositDto depositDto, Principal principal) {

        String account = depositDto.getAccountType();
        Integer amount = depositDto.getAmount();
        Integer accountNumber = depositDto.getAccountNumber();
        String email = principal.getName();

        if ("primary".equals(account)) {

            primaryAccountDao.withdraw(amount, email, account);
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount = primaryAccountDao.findByEmail(email);
            Integer balance1 = primaryAccount.getBalance();
            String type = "withdraw";
            historyDao.save(amount, email, account, balance1, type);

            Savings savings = new Savings();
            savings = savingsDao.findByAccountNumber(accountNumber);
            String email1 = savings.getEmail();
            savingsDao.deposit(amount, email1, account);
            Savings savings1 = new Savings();
            savings1 = savingsDao.findByAccountNumber(accountNumber);
            Integer balance = savings1.getBalance();
            String type1 = "deposit";
            String account1 = "savings";
            historyDao.save(amount, email1, account1, balance, type1);

        }
        if ("savings".equals(account)) {
            savingsDao.withdraw(amount, email, account);
            Savings savings = new Savings();
            savings = savingsDao.findByEmail(email);
            Integer balance1 = savings.getBalance();
            String type1 = "withdraw";
            historyDao.save(amount, email, account, balance1, type1);

            Savings savings1 = new Savings();
            savings1 = savingsDao.findByAccountNumber(accountNumber);
            String email1 = savings1.getEmail();
            savingsDao.deposit(amount, email1, account);
            Savings savings2 = new Savings();
            savings2 = savingsDao.findByAccountNumber(accountNumber);
            Integer balance = savings2.getBalance();
            String type2 = "deposit";
            String account1 = "savings";
            historyDao.save(amount, email1, account1, balance, type2);

        }

        return "redirect:/";
    }

    @PostMapping("/internal")
    public String internal(@ModelAttribute("internal") DepositDto depositDto, Principal principal) {

        String account = depositDto.getAccountType();
        Integer amount = depositDto.getAmount();
        String email = principal.getName();

        if ("savings".equals(account)) {

            savingsDao.deposit(amount, email, account);
            Savings savings = new Savings();
            savings = savingsDao.findByEmail(email);
            Integer balance = savings.getBalance();
            String type = "deposit";
            historyDao.save(amount, email, account, balance, type);

            primaryAccountDao.withdraw(amount, email, account);
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount = primaryAccountDao.findByEmail(email);
            Integer balance1 = primaryAccount.getBalance();
            String type1 = "withdraw";
            String account1 = "primary";
            historyDao.save(amount, email, account1, balance1, type1);
        }
        if ("primary".equals(account)) {
            primaryAccountDao.deposit(amount, email, account);
            PrimaryAccount primaryAccount = new PrimaryAccount();
            primaryAccount = primaryAccountDao.findByEmail(email);
            Integer balance = primaryAccount.getBalance();
            String type = "deposit";
            historyDao.save(amount, email, account, balance, type);

            savingsDao.withdraw(amount, email, account);
            Savings savings = new Savings();
            savings = savingsDao.findByEmail(email);
            Integer balance1 = savings.getBalance();
            String type1 = "withdraw";
            String account1 = "savings";
            historyDao.save(amount, email, account1, balance1, type1);
        }

        return "redirect:/";
    }
    
    @PostMapping("/appointments")
    public String appointments(@ModelAttribute("appointments") Appointments appointments, Principal principal) {
        Date appointmentDate = new Date();
        String description = appointments.getDescription();
        String email = principal.getName();
        appointmentDate =  appointments.getAppointmentDate();
        String status =appointments.getStatus();
        String location = appointments.getLocation();
        
        appointmentsDao.save(description, email, appointmentDate, status, location);
        return "redirect:/";
                
    }

    @GetMapping("/all")
    @ResponseBody
    public Integer findall() {
        int x = (int) (Math.random() * ((9999999 - 1000000) + 1)) + 1000000;
        return x;
    }

}
