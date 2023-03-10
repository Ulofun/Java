package tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class Task {

  //1. Задать одномерный массив и найти в нем минимальный и максимальный элементы
  public void task1() {
    int[] arr = new int[8];
    int arrlength = arr.length;

    for (int i = 0; i < arrlength; i++) {
      arr[i] = i;
    }

    int min = arr[0];
    int max = arr[0];

    for (int i : arr) {
      if (i < min) {
        min = i;
      }
      if (i > max) {
        max = i;
      }
    }
    System.out.println("Min value: " + min + " " + "Max value: " + max);
  }

  //Дан массив nums = [3,2,2,3] и число val = 3.
  //Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
  //Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.
  //.
  public void task2() {
    int[] nums = {3, 2, 2, 3};
    int val = 3;
    int numsLength = nums.length - 1;

    for (int i = 0; i < numsLength; i++) {
      if (nums[i] == val) {
        int nextInt = nums[i + 1];
        int currentInt = nums[i];

        nums[i] = nextInt;
        nums[i + 1] = currentInt;
      }
    }

    System.out.println(nums[0] + " " + nums[1] + " " + nums[2] + " " + nums[3]);
  }

  //В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида:
  //"Доброе утро, <Имя>!", если время от 05:00 до 11:59
  //"Добрый день, <Имя>!", если время от 12:00 до 17:59;
  //"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
  //"Доброй ночи, <Имя>!", если время от 23:00 до 4:59
  public void task3() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter username");
    String username = String.valueOf(br.readLine());

    LocalTime now = LocalTime.now();
    int hour = now.getHour();

    if(hour>=5 && hour<12){
      System.out.println("Доброе утро, "+username);
    }
    else if(hour>=12 && hour<18){
      System.out.println("Добрый день, "+username);
    }
    else if(hour>=18 && hour<23){
      System.out.println("Добрый вечер, "+username);
    }
    else{
      System.out.println("Доброй ночи, "+username);
    }
  }

}
