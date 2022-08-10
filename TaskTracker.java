package com.example.week2day4ex2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TaskTracker {
    ArrayList<Info> user = new ArrayList<Info>();
    @PostMapping ("/task")
    public Response addTask (@RequestBody Info task ){
        user.add(task);
        return new Response("Task added");
    }
    @GetMapping ("/task")
    public ArrayList<Info> getTasks(){
        return user;
    }
    @PutMapping ("/task/{index}")
    public Response putTask(@PathVariable int index,@RequestBody Info task){
        user.set(index,task);
        return new Response("Task has been updated");
    }
    @DeleteMapping ("/task/{index}")
    public Response deleteTask(@PathVariable int index){
        user.remove(index);
        return new Response("task has been deleted");
    }
    @PutMapping("/tasks/status/{index}")
    public Response status(@PathVariable Integer index , @RequestBody String status ){
        user.get(index).setStatus(status);
        return new Response("Status has been updated");
    }
    @GetMapping("/tasks/search")
    public Response search(@RequestBody String title){
        for (Integer i = 0; i < user.size(); i++) {
            if(user.get(i).getTitle().equals(title)){
                return new Response(user.get(i).toString());
            }
        }
        return new Response("Task was not found!");
    }
}


