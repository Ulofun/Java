package sixsemhomework;

import java.util.ArrayList;
import java.util.Scanner;

public class Methods {

  public static void producerFind(ArrayList<Notebook> book) {
    String msg = "Введите производителя: \n";
    String inputValue = enterFromUser(msg);
    int count = 0;
    for (Notebook item : book) {
      String producer = item.getProducer();
      if (producer.equals(inputValue)) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Производитель \"%s\" не найден.%n", inputValue);
    }
  }

  public static void memoryFind(ArrayList<Notebook> book) {
    String msg = "Введите минимальный объём оперативной памяти: \n";
    double inputValue = checkDouble(msg);
    int count = 0;
    for (Notebook item : book) {
      double memory = item.getMemory();
      if (memory >= inputValue) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Ноутбуков с оперативной памятью \"%s\" не найдено.%n", inputValue);
    }
  }

  public static void hardDiskFind(ArrayList<Notebook> book) {
    String msg = "Введите минимальный объём жёсткого диска: \n";
    double inputValue = checkDouble(msg);
    int count = 0;
    for (Notebook item : book) {
      double hardDisk = item.getHardDisk();
      if (hardDisk >= inputValue) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Ноутбуков с размером жётского диска \"%s\" не найдено.%n", inputValue);
    }
  }

  public static void colorFind(ArrayList<Notebook> book) {
    String msg = "Введите цвет: \n ";
    String inputValue = enterFromUser(msg);
    int count = 0;
    for (Notebook item : book) {
      String color = item.getColor();
      if (color.equals(inputValue)) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("\"%s\" цвет не найден.%n", inputValue);
    }
  }

  public static void diagonalFind(ArrayList<Notebook> book) {
    String msg = "Введите минимальный размер диагонали экрана в дюймах: \n";
    double inputValue = checkDouble(msg);
    int count = 0;
    for (Notebook item : book) {
      double diagonal = item.getMemory();
      if (diagonal >= inputValue) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Ноутбуков с диагональю экрана \"%s\" не найдено.%n", inputValue);
    }
  }

  public static void allParametersFind(ArrayList<Notebook> book) {
    String msg1 = "Введите производителя: \n";
    String inputValue1 = enterFromUser(msg1);

    String msg2 = "Введите минимальный объём оперативной памяти: \n";
    double inputValue2 = checkDouble(msg2);

    String msg3 = "Введите минимальный объём жёсткого диска: \n";
    double inputValue3 = checkDouble(msg3);

    String msg4 = "Введите цвет: \n ";
    String inputValue4 = enterFromUser(msg4);

    String msg5 = "Введите минимальный размер диагонали экрана в дюймах: \n";
    double inputValue5 = checkDouble(msg5);

    int count = 0;
    for (Notebook item : book) {
      String producer = item.getProducer();
      double memory = item.getMemory();
      double hardDisk = item.getHardDisk();
      String color = item.getColor();
      double diagonal = item.getMemory();

      if (producer.equals(inputValue1)
          && memory >= inputValue2
          && hardDisk >= inputValue3
          && color.equals(inputValue4)
          && diagonal >= inputValue5) {
        item.printNoteBooks();
        count++;
      }
    }
    if (count == 0) {
      System.out.println("Подходящего ноутбука не найдено.%n");
    }
  }

  public static void printAllNoteBooks(ArrayList<Notebook> book) {
    for (Notebook item : book) {
      item.printNoteBooks();
    }
  }

  private static String enterFromUser(String text) {
    Scanner in = new Scanner(System.in);
    System.out.printf(text);
    String data = in.nextLine();
    while (data.isBlank()) {
      System.out.printf("Строка не должна быть пустой. Попробуйте ещё раз!%n");
      System.out.println(text);
      data = in.nextLine();
    }
    return data;
  }

  private static double checkDouble(String text) {
    double doubleinputValue;
    while (true) {
      String inputValue = enterFromUser(text);
      try {
        doubleinputValue = Double.parseDouble(inputValue);
        break;
      } catch (NumberFormatException ex) {
        System.out.printf("Ошибка ввода данных, попробуйте ещё раз!%n");
      }
    }
    return doubleinputValue;
  }
}