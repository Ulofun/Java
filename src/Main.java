
import secondsemhomework.TaskOneHomeWork;
import secondsemhomework.TaskTwoHomeWork;
import sem2practic.Sbpractic;
import sem2practic.Task1;
import tasks.Task;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    // Task task = new Task();
    // Task1 taskSm = new Task1();
    TaskOneHomeWork hw1 = new TaskOneHomeWork();
    TaskTwoHomeWork fourthTask = new TaskTwoHomeWork();


//    task.task1();
//    task.task2();
//    task.task3();
    //   taskSm.tasksem1(10, 'x', 'y');
    hw1.task1hw("ШАЛАШ");
    fourthTask.writer();
  }
}