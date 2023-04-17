package toysshop;

package toysshop;

import java.util.ArrayList;
import java.util.Scanner;
import static toysshop.Methods.*;


public class Main {
  public static void main(String[] args) {
         /*Необходимо написать проект, для розыгрыша в магазине игрушек.
        Функционал должен содержать добавление новых игрушек и задания веса для выпадения игрушек.*/

    startProgramm();
  }

  private static void startProgramm() {
    System.out.println();
    System.out.printf("Создайте список игрушек для розыгрыша.%n");
    ArrayList<Toys> allToys = getListAllToys();
    printAll(allToys);

    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.printf("%nДля выбора необходимого действия введите соответсвующий номер пункта меню: %n" +
          " 0. Завершить работу приложения.%n" +
          " 1. Добавить новую игрушку в список.%n" +
          " 2. Изменить название игрушки для розыгрыша.%n" +
          " 3. Изменить количество игрушек для розыгрыша конкретного вида игрушек.%n" +
          " 4. Начать розыгрыш игрушек.%n");

      String inputString = in.nextLine();

      if (inputString.isBlank()) {
        System.out.printf("Строка не должна быть пустой. Введите данные.%n");
        continue;
      }

      if (inputString.equalsIgnoreCase("0")) {
        System.out.printf("Работа завершена.%n");
        break;
      }

      if (inputString.equalsIgnoreCase("1")) {
        inputNewToy(allToys);
        printAll(allToys);
        continue;
      }

      if (inputString.equalsIgnoreCase("2")) {
        changeNameToy(allToys);
        printAll(allToys);
        continue;
      }

      if (inputString.equalsIgnoreCase("3")) {
        changeAmountToys(allToys);
        printAll(allToys);
        continue;
      }

      if (inputString.equalsIgnoreCase("4")) {
        ArrayList<String> allToysForRaffle = getListForRaffle(allToys);
        ArrayList<String> listOfGifts = new ArrayList<>();

        while (true) {
          System.out.printf("%nДля выбора необходимого действия введите соответсвующий номер пункта меню: %n" +
              " 1. Разыграть игрушку.%n" +
              " 2. Вывести список разыгранных игрушек.%n");

          String inputString2 = in.nextLine();

          if (inputString2.isBlank()) {
            System.out.printf("Строка не должна быть пустой. Введите данные.%n");
            continue;
          }

          if (inputString2.equalsIgnoreCase("1")) {
            startRaffle(allToysForRaffle, listOfGifts);
            continue;
          }

          if (inputString2.equalsIgnoreCase("2")) {
            writeStringIntoFile("Итоги очередного розыгрыша игрушек:",false);
            printListGifts(listOfGifts);
          } else {
            System.out.printf("Такого пункта меню не существует. Сделайте выбор еще раз.%n");
          }
        }

      } else {
        System.out.printf("Такого пункта меню не существует. Сделайте выбор еще раз.%n");
      }
    }
  }
}