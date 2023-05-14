package com.example.homework11.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("GET")
public class welcomeController {

@GetMapping(path = "/name")
    public String getName(){

        return "“My name is Saud ”";
    }
@GetMapping("/age")
    public String getAge(){

        return "“My age is 24”";
    }
    @GetMapping("/check/status")
public String everyThing(){

        return "“Everything OK”";
}
@GetMapping("/health")
public String serverHealth(){
      return "“Server health is up and running”";
}


}
