package com.example.thymeleaf.Controller;


import com.example.thymeleaf.DTO.Customerdto;
import com.example.thymeleaf.DTO.DateRange;
import com.example.thymeleaf.Entity.Customer;

import com.example.thymeleaf.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;


@Controller
@RequestMapping("/api/v1")
public class CustomerController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/home")
    public String findAll(Model model){



        model.addAttribute("customers",customerService.findAllCustomers());
        model.addAttribute("DateRange",new DateRange());
        return "home";
    }
    public Customer findById(@PathVariable Long id){

        return customerService.findCustomerById(id).get();
    }

    @GetMapping("/addCustomer")
    public String productGet(Model model){

     model.addAttribute("dto",new Customer());
    model.addAttribute("customers",customerService.findAllCustomers());
     return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute ("dto")Customerdto dto ,Model model ){

        Customer c=new Customer();
        c.setId(dto.getId());
        c.setFirstName(dto.getFirstName());
        c.setLastName(dto.getLastName());
        c.setEmail(dto.getEmail());
        c.setPrice(dto.getPrice());
        c.setDate(dto.getDate());
        customerService.addCustomer(c);


        return "redirect:/api/v1/home";
    }

    @GetMapping("/update/{id}")      //("/update/{id}")
    public  String updateCustomer(@PathVariable Long id ,Model model){


        Customer c=customerService.findCustomerById(id).get();
        Customerdto dto=new Customerdto();
        dto.setId(c.getId());
        dto.setFirstName(c.getFirstName());
        dto.setLastName(c.getLastName());
        dto.setEmail(c.getEmail());
        dto.setPrice(c.getPrice());
        dto.setDate(c.getDate());

        model.addAttribute("customers",customerService.findAllCustomers());
        model.addAttribute("dto" ,dto);

        return "addCustomer";

    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id){

        customerService.deleteCustomerById(id);
        return "redirect:/api/v1/home";
    }

    @PostMapping("/GetCustomer")
    public String getCustomerByDate( Model model, @ModelAttribute DateRange dateRange) {



        System.out.println(dateRange.getStartDate());


        List<Customer> c=customerService.getCustomerByDate(dateRange.getStartDate(),dateRange.getEndDate());

        model.addAttribute("customers",c);
        model.addAttribute("DateRange",new DateRange());
        return "home";

    }





}
