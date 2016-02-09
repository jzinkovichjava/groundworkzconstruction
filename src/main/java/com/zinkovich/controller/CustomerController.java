package com.zinkovich.controller;

import java.util.List;

import com.zinkovich.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import com.zinkovich.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;  //Service which will do all data retrieval/manipulation work


    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView getCustomerScreen () {
        ModelAndView mv = new ModelAndView();
        mv.addObject("customer", new Customer());
        mv.addObject("listOfCustomers", customerService.findAllCustomers());
        mv.setViewName("customer");
        return mv;
    }



//    //-------------------Retrieve Single User--------------------------------------------------------
//
//    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
//        System.out.println("Fetching User with id " + id);
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<User>(user, HttpStatus.OK);
//    }



    //-------------------Create a User--------------------------------------------------------

    @RequestMapping(value = "/customer/new", method = RequestMethod.POST)
    public String createUser(@RequestBody Customer customer) {
        System.out.println("Creating User " + customer.getFirstName() + customer.getLastName());

//        if (userService.isUserExist(user)) {
//            System.out.println("A User with name " + user.getUsername() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }



    //------------------- Update a User --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Updating Customer " + id);

//        Customer currentUser = customerService.findById(id);
//
//        if (currentUser==null) {
//            System.out.println("User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        currentUser.setUsername(user.getUsername());
//        currentUser.setAddress(user.getAddress());
//        currentUser.setEmail(user.getEmail());

        customerService.updateCustomer(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }



//    //------------------- Delete a User --------------------------------------------------------
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
//        System.out.println("Fetching & Deleting User with id " + id);
//
//        User user = userService.findById(id);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id " + id + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
//
//        userService.deleteUserById(id);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }



//    //------------------- Delete All Users --------------------------------------------------------
//
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
//
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }

}