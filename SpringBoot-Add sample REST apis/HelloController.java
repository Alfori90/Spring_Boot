package com.codeline.SpringBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello(){
//        return "hello";
//    }

    @GetMapping("/hello")
    public String name(@RequestParam String name){
        if (name == null || name.isEmpty()){
            return "Hello Guest " ;
        }
        return "Hello " + name;
    }


    @GetMapping("/sum")
    public int sum(@RequestParam int a,@RequestParam int b){
        return  a+b;
    }

    @GetMapping("/info")
    public Info getInfo(){
        return new Info("Huria","Busher", "Arabic");
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/upper")
    public String upperCase(@RequestParam String text){
        return text.toUpperCase();
    }

    @GetMapping("/random")
    public int random(){
        return (int) Math.random()*100+1;
    }
}
