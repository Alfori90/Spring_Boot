package com.codeline.SpringBoot.Controller;

import com.codeline.SpringBoot.RequestObject.MarkCreateRequest;
import com.codeline.SpringBoot.Entities.Mark;
import com.codeline.SpringBoot.Services.MarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("Mark")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping("/create")
    public Mark createMark(@RequestBody MarkCreateRequest requestObj) throws Exception {
        MarkCreateRequest.validCreateMarkRequest(requestObj);
        Mark mark = markService.saveMark(requestObj);
        return mark;
    }

    @GetMapping("/getAll")
    public List<Mark> getAllMark(){
        List<Mark> marks= markService.getAllMark();
        return marks;
    }

    @GetMapping("/getById/{id}")
    public Mark getMarkById(@PathVariable int id) throws Exception{
        return markService.getMarkById(id);
    }

    @PutMapping("/update")
    public Mark updateMark(@RequestBody Mark updateObjFromUser) throws Exception{
        return markService.updateMark(updateObjFromUser);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMark(@PathVariable int id) throws Exception{
            markService.deleteMark(id);
             return "Success";
    }
}
