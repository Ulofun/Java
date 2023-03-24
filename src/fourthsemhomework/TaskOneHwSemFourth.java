package fourthsemhomework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskOneHwSemFourth {
  public static void main(String[] args) {
        /*1. Реализовать консольное приложение, которое:
        Принимает от пользователя и “запоминает” строки.
        Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
        Если введено revert, удаляет предыдущую введенную строку из памяти.*/
    takeStringPrintList();
  }

  private static void takeStringPrintList() {
    Scanner in = new Scanner(System.in);
    LinkedList<String> wordsList = new LinkedList<>();
    while (true) {
      System.out.println();
      System.out.print("Введите строку: ");
      String inputString = in.nextLine();

      if (inputString.isBlank()) {
        System.out.println("Строка не должна быть пустой");

      } else if (inputString.equalsIgnoreCase("stop")) {
        System.out.println("Программа остановлена");
        break;

      } else if (inputString.equalsIgnoreCase("print")) {
        if (wordsList.isEmpty()) {
          System.out.println("В списке нет данных для вывода");
        } else {
          printAllValues(wordsList);
        }

      } else if (inputString.equalsIgnoreCase("revert")) {
        if (wordsList.isEmpty()) {
          System.out.println("В списке нет данных для удаления");
        } else {
          deleteLastValue(wordsList);
        }

      } else {
        wordsList.addFirst(inputString);
        printAddMessage(inputString);
      }
    }

  }

  private static void printAllValues(LinkedList<String> list) {
    System.out.println(list);
  }

  private static void printAddMessage(String word) {
    System.out.printf("Слово \"%s\" добавлено %n", word);
  }

  private static void deleteLastValue(LinkedList<String> list) {
    System.out.printf("Удалили слово \"%s\" %n", list.removeFirst());
  }

}
