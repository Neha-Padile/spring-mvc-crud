package com.springmvccrud.controller;

import com.springmvccrud.dao.UserDao;
import com.springmvccrud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/addPage")
    public String goToAddUser(){
        return "userform";
    }

    @GetMapping("/getalluser")
    public ModelAndView getAllUsers(){
        List<User> users=userDao.getAllUser();
        System.out.println("----All User details----"+users);
        //model.addAttribute("listUser",users);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", users);  // Set the model attribute
        modelAndView.setViewName("userlist");
        System.out.println("Page return");
        return modelAndView;
    }

    @PostMapping("/insert")
    public String saveUser(@ModelAttribute User user) {
        userDao.saveUser(user);
        return "redirect:/getalluser";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam int id){
        userDao.deleteUser(id);
        System.out.println("------User Deleted Successfully----");
        return "redirect:/getalluser";
    }

    @RequestMapping(value = "/editUser")
    public String editUser(@RequestParam int id,Model model){
        User user=userDao.editUser(id);
        System.out.println("------User Deleted Successfully----");
        model.addAttribute("user",user);
        return "userform";
    }

    @RequestMapping(value = "/update")
    public String updateUser(@RequestParam int id,@ModelAttribute User user){
        userDao.updateUser(user);
        System.out.println("------User Updated Successfully----");
        return "redirect:/getalluser";
    }

}
