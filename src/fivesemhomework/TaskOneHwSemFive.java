package fivesemhomework;

import java.util.*;

import static fivesemhomework.Methods.*;

public class TaskOneHwSemFive {
  public static void main(String[] args) {
//        1. Реализуйте структуру телефонной книги с помощью HashMap,
//        учитывая, что 1 человек может иметь несколько телефонов.

    HashMap<String, LinkedList<String>> phoneBook = new HashMap<>();

    LinkedList<String> first = new LinkedList<>();
    Collections.addAll(first, "19235", "75342");
    phoneBook.put("Иван Петров", first);

    LinkedList<String> second = new LinkedList<>();
    Collections.addAll(second, "43835", "94268");
    phoneBook.put("Иванка Трамп", second);

    LinkedList<String> third = new LinkedList<>();
    Collections.addAll(third, "79328", "50492");
    phoneBook.put("Петро Чернышов", third);

    LinkedList<String> fourth = new LinkedList<>();
    Collections.addAll(fourth, "75726", "65851");
    phoneBook.put("Света Петрова", fourth);

    LinkedList<String> fifth = new LinkedList<>();
    Collections.addAll(fifth, "85476", "28624");
    phoneBook.put("Петр Лыков", fifth);

    LinkedList<String> sixth = new LinkedList<>();
    Collections.addAll(sixth, "47886", "21354");
    phoneBook.put("Светалана Петрова-Крутова", sixth);

    startProgramm(phoneBook);

  }

  private static void startProgramm(HashMap<String, LinkedList<String>> book) {
    Scanner in = new Scanner(System.in);

    while (true) {
      System.out.println();
      System.out.print("Введите действие:\n" +
          "1. Вывести всю телефонную книгу -> \"printall\"\n" +
          "2. Вывести телефоны абонента по имени и фамилии -> \"printperson\"\n" +
          "3. Удалить телефон абонента -> \"deletephone\"\n" +
          "4. Удалить абонента -> \"deleteperson\"\n" +
          "5. Добавить абонента и телефон -> \"newperson\"\n" +
          "6. Добавить телефон абонента -> \"newphone\"\n" +
          "7. Изменить имя и фамилию абонента-> \"change\"\n" +
          "8. Поиск абонента по номеру телефона -> \"findperson\"\n" +
          "9. Остановить программу -> \"stop\"\n");

      String inputString = in.nextLine();

      if (inputString.isBlank()) {
        System.out.println("Строка не должна быть пустой. Попробуйте ещё раз!\n");
        continue;
      }

      if (inputString.equalsIgnoreCase("stop")) {
        System.out.println("Работа со справочникам завершена.\n");
        break;
      }

      if (inputString.equalsIgnoreCase("printall")) {
        printAllPhoneBook(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("printperson")) {
        printPerson(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("deletephone")) {
        deletePhone(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("deleteperson")) {
        deletePerson(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("newperson")) {
        addNewPerson(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("newphone")) {
        addNewPhone(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("change")) {
        changePerson(book);
        continue;
      }

      if (inputString.equalsIgnoreCase("findperson")) {
        findPersonByPhone(book);

      } else {
        System.out.println("Ошибка ввода команды. Попробуйте ещё раз!\n");
      }
    }
  }
}

