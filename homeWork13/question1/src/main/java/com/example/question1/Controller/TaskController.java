package com.example.question1.Controller;

import com.example.question1.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RequestMapping("api/v1/task")
@RestController
public class TaskController {

ArrayList<Task> tasks=new ArrayList<>();
@GetMapping("/display-task")

public ArrayList displayTasks(){
    return tasks;



}

// I assume that we get the title from the path of the url
@GetMapping("/search-task/{title}")
public String searchByTitle(@PathVariable String title){
    for (Task task : tasks){
        if (task.getTitle().equalsIgnoreCase(title)){
           return task.toString();
        }

    }
return "not found";
}




@PostMapping("/add")
public String addTask(@RequestBody Task task){
    tasks.add(task);
    return "task added";

}

@PutMapping("/update-task/{index}")
public String updateTask(@PathVariable int index ,@RequestBody Task task){
    tasks.set(index,task);

    return "Taske updated";

}
// if we use this method on not done it will give done if we use it on done or any other string it will give not done
@PutMapping("/change-task/{index}")
public String changeStatus(@PathVariable int index){

    if (tasks.get(index).getStatus().equalsIgnoreCase("not done")){

        tasks.get(index).setStatus("done");}else {
        tasks.get(index).setStatus("not done");

    }
    return "status has been changed";

}


@DeleteMapping("/delte-task/{index}")
public String deleteTask(@PathVariable int index){

    tasks.remove(index);
    return "task deleted";


}









}
