package com.demobiggrin.Practice.controller;

import com.demobiggrin.Practice.model.Student;
import com.demobiggrin.Practice.requests.MyRequest;
import com.demobiggrin.Practice.response.MyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    int i=10000;
    private int id=1;

    ArrayList<Student> list=new ArrayList<>();

    @GetMapping("/home")
    public String first() {
        return "Hello Java";
    }

    @PostMapping("/data")
    public MyResponse myData(@RequestBody MyRequest myRequest) {
        MyResponse myResponse= requestToResponse(myRequest);
        return myResponse;
    }

    private MyResponse requestToResponse(MyRequest myRequest){
        MyResponse myResponse=new MyResponse();
        myResponse.setId(id);
        myResponse.setComment(myRequest.getName() + " " + myRequest.getRoll());
        id++;
        return myResponse;

    }

    @GetMapping("/dispStudent")
    public ArrayList<Student> dispStudent(){
        System.out.println("Showing all student");
        return list;
    }

    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){


        i++;
        list.add(student);
        list.get(list.size()-1).setId(i);
        //System.out.println("local "+i);
        //System.out.println(list.get(list.size()-1).getId());

        return student;
    }

}
