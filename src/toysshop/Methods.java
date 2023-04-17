package toysshop;

package toysshop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Methods {

  public static void printListGifts(ArrayList<String> listOfGifts) {
    if (listOfGifts.size() == 0) {
      System.out.println("Вы не разыграли ни одной игрушки!");
    } else {
      for (int i = 0; i < listOfGifts.size(); i++) {
        String temp = String.valueOf(i + 1);
        System.out.printf("Подарок %s -> игрушка %s%n", temp, listOfGifts.get(i));
        writeStringIntoFile("Подарок " + temp + " -> игрушка " + listOfGifts.get(i), true);
      }
      System.exit(0);
    }
  }

  public static void writeStringIntoFile(String str, boolean flag) {
    try (FileWriter fw = new FileWriter("src/main/java/toysShop/Raffle.txt", flag)) {
      fw.write(str);
      fw.append('\n');
      fw.flush();
    } catch (IOException ex) {
      System.out.println("Запись в файл не удалась!");
    }
  }

  public static ArrayList<String> getListForRaffle(ArrayList<Toys> allToys) {
    ArrayList<String> allToysForRaffle = new ArrayList<>();
    for (Toys item : allToys) {
      String toyName = item.getName();
      int toyAmount = item.getWeight();
      for (int i = 0; i < toyAmount; i++) {
        allToysForRaffle.add(toyName);
      }
    }
    return allToysForRaffle;
  }

  public static void changeAmountToys(ArrayList<Toys> allToys) {
    System.out.printf("%nВведите название игрушки, количество которой хотите изменить: %n");
    String toyName = nameFromUser();
    int count = 0;
    for (Toys item : allToys) {
      if (item.getName().equalsIgnoreCase(toyName)) {
        int amountToy = amountFromUser();
        item.setWeight(amountToy);
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Такой игрушки не найдено%n");
    }
  }

  public static void printAll(ArrayList<Toys> allToys) {
    System.out.printf("%nСписок игрушек для розыгрыша:%n");
    for (Toys item : allToys) {
      item.printInfo();
    }
  }

  public static void changeNameToy(ArrayList<Toys> allToys) {
    System.out.printf("Введите название игрушки, которое хотите изменить: %n");
    String toyName = nameFromUser();
    int count = 0;
    for (Toys item : allToys) {
      if (item.getName().equalsIgnoreCase(toyName)) {
        System.out.printf("Введите новое название игрушки: %n");
        String toyNewName = nameFromUser();
        item.setName(toyNewName);
        count++;
      }
    }
    if (count == 0) {
      System.out.printf("Такой игрушки не найдено%n");
    }
  }

//    private static void deleteToy(ArrayList<Toys> allToys) {
//        System.out.println("Список игрушек для розыгрыша: ");
//        for (Toys item:allToys) {
//            item.printInfo();
//        }
//        String toyName = nameFromUser();
//        for (int i = 0; i < allToys.size() ; i++) {
//            if (allToys.get(i).getName().equals(toyName)) {
//                allToys.remove(i);
//            }
//        }
//        System.out.println("Список игрушек для розыгрыша: ");
//        for (Toys item:allToys) {
//            item.printInfo();
//        }
//    }

  public static void startRaffle(ArrayList<String> allToysForRaffle, ArrayList<String> listOfGifts) {
    if (allToysForRaffle.size() == 0) {
      System.out.println("Все игрушки разыграны! Перейдите к печати списка");
    } else {
      Random random = new Random();
      String gift = allToysForRaffle.remove(random.nextInt(allToysForRaffle.size()));
      listOfGifts.add(gift);
      System.out.printf("В этом туре выпала %s%n", gift);
      System.out.println("Список разыгранных игрушек на данный момент:");
      for (String item : listOfGifts) {
        System.out.println(item);
      }
    }
  }

  public static ArrayList<Toys> getListAllToys() {
    ArrayList<Toys> allToys = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.printf("Сколько видов игрушек вы хотите разыграть? Введите цифру: %n");
      String numToysTypes = in.nextLine();
      try {
        int numberToysTypes = Integer.parseInt(numToysTypes);
        if (numberToysTypes > 0) {
          for (int i = 0; i < numberToysTypes; i++) {
            inputNewToy(allToys);
          }
          break;
        } else {
          System.out.printf("%nВы ввели некорректное число.%n");
        }
      } catch (NumberFormatException e) {
        System.out.printf("%nВы ввели некорректные данные.%n");
      }
    }
    return allToys;
  }

  public static void inputNewToy(ArrayList<Toys> allToys) {
    System.out.printf("%nВведите название новой игрушки: %n");
    String toyName = nameFromUser();
    int toyAmount = amountFromUser();
    Toys toy = new Toys(allToys.size()+1, toyName, toyAmount);
    allToys.add(toy);
  }


  private static int amountFromUser() {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.printf("%nВведите количество игрушек: %n");
      String amount = in.nextLine();
      try {
        int amountToys = Integer.parseInt(amount);
        if (amountToys > 0) {
          return amountToys;
        } else {
          System.out.printf("%nВы ввели некорректное число.%n");
        }
      } catch (NumberFormatException e) {
        System.out.printf("%nВы ввели некорректные данные.%n");
      }
    }
  }


  private static String nameFromUser() {
    Scanner in = new Scanner(System.in);
    String name = in.nextLine();
    while (name.isBlank()) {
      System.out.printf("Строка не должна быть пустой. Попробуйте ещё раз!%n");
      System.out.printf("%nВведите название игрушки: %n");
      name = in.nextLine();
    }
    return name;
  }


}
