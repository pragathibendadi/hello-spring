package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
//@RequestMapping("hello")
public class HelloController {
    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {//index handler
        String name = request.getParameter("name");
        if (name == null) {
            name = "world";
        }
        return "Hello " + name;
    }
    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(Model model) {
        ArrayList<String> languages =new ArrayList<>();

        languages.add("English");
        languages.add("Spanish");
        languages.add("French");
        languages.add("Italian");
        languages.add("Telugu");
        languages.add("German");
        languages.add("Japanese");
        languages.add("Chinese");
//        String html = "<form method='post'>" +
//                "<input type='text' name='name' />" +
//                "<input type='submit' value='Greet Me!!'" +
//                "</form>";
        model.addAttribute("languages", languages);
        return "hello";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");
       // return "Hello " + name;
        // init a temp variable to store the final language value
        String greeting;
        // set the language value based off of what was passed on the request
        switch (language) {
            case "English":
                greeting = "Hello";
                break;
            case "Spanish":
                greeting = "Hola";
                break;
            case "French":
                greeting = "Bonjour";
                break;
            case "Italian":
                greeting = "Ciao";
                break;
            case "German":
                greeting = "Hallo";
                break;
            case "Telugu":
                greeting = "Namaste";
                break;
            case "Japanese":
                greeting = "Konichiwa";
                break;
            case "Chinese":
                greeting = "Ni hao";
                break;
            default:
                greeting = "Hello, Ni hao, Namaste";

        }
        // return correct response
        return  greeting + " " + name;
    }

    @RequestMapping(value = "/hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
}
}