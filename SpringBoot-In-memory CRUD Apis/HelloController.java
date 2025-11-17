package com.codeline.SpringBoot;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
//    @GetMapping("/hello")
//    public String sayHello(){
//        return "hello";
//    }

    /*@GetMapping("/hello")
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

     */

    private Map<Integer, String> courses = new HashMap<>();
    private int idCounter = 1;


    @GetMapping("fillData")
    public String addSampleData() {
        createCourses("Arabic");
        createCourses("Math");
        createCourses("Physics");
        createCourses("English");
        createCourses("History");
        createCourses("Science");
        createCourses("Art");

        return "Completed";
    }


    @PostMapping("create")
    public String createCourses(@RequestParam String name) {
        courses.put(idCounter, name);
        return "Courses created with ID: " + idCounter++;
    }

    @GetMapping("getAll")
    public Map<Integer, String> getAllCourses() {
        return courses;
    }

    @GetMapping("getById/{id}")
    public String getCourses(@PathVariable int id) {
        return courses.getOrDefault(id, "Student not found");
    }

    @PutMapping("update/{id}&{name}")
    public String updateCourses(@PathVariable int id ,@PathVariable String name) {
        if (courses.containsKey(id)) {
            courses.put(id,name);
            return "Courses updated successfully";
        }
        return "Courses not found";
    }

    @DeleteMapping("delete/{id}")
    public String deleteCourses(@PathVariable int id) {
        if (courses.remove(id) != null) {
            return "Courses deleted successfully";
        }
        return "Courses not found";
    }





}
