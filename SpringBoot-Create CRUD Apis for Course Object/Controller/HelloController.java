package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.entities.Course;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*")
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
    private List<Course> coursesList = new ArrayList<>();
    private int idCounter = 1;

   /* @GetMapping("fillData")
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

*/

    @PostMapping("create")
    public String createCourses(@RequestBody Course requestObj) {
        requestObj.setId(idCounter);
        requestObj.setCreatedDate(new Date());
        requestObj.setIsActive(true);

        coursesList.add(requestObj);


        return "Course created with ID: " + idCounter++;
    }


    @GetMapping("getAll")
    public List<Course> getAllCourses() {
        List<Course> responseList = new ArrayList<>();
        for (Course course : coursesList) {
            if (course.getIsActive()) {
                responseList.add(course);
            }
        }
        return responseList;
    }


    @GetMapping("getById/{id}")
    public Course getCourses(@PathVariable int id) {
        for (Course course : coursesList) {
            if (course.getId() == id && course.getIsActive()) {
                return course;
            }
        }
        return Course.builder().build();
    }


    @PutMapping("update")
    public String updateCourse(@RequestBody Course updateObjFromUser) {
        if (updateObjFromUser != null && updateObjFromUser.getId() > 0) {
            Course existingCourseToUpdate = findCourseById(updateObjFromUser.getId());
            coursesList.remove(existingCourseToUpdate);
            existingCourseToUpdate.setName(updateObjFromUser.getName());
            existingCourseToUpdate.setCreditHours(updateObjFromUser.getCreditHours());
            existingCourseToUpdate.setInstructorName(updateObjFromUser.getInstructorName());
            existingCourseToUpdate.setUpdatedDate(new Date());

            coursesList.add(existingCourseToUpdate);

            return "Course updated successfully";
        }
        return "Course not found";
    }


    @DeleteMapping("delete/{id}")

    public String deleteCourse(@PathVariable int id) {

        Course existingCourseToUpdate = findCourseById(id);

        if (existingCourseToUpdate.getId() > 0) {
            coursesList.remove(existingCourseToUpdate);

            existingCourseToUpdate.setIsActive(false);
            existingCourseToUpdate.setUpdatedDate(new Date());

            coursesList.add(existingCourseToUpdate);

            return "Course deleted successfully";
        } else {
            return "Invalid id";
        }

    }


    public Course findCourseById(int id) {
        for (Course course : coursesList) {
            if (course.getId() == id) {
                return course;
            }
        }
        return Course.builder().id(-1).build();
    }


}
