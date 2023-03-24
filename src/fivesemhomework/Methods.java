package fivesemhomework;

import java.util.*;

public class Methods {
  public static String enterFromUser(String text) {
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

  public static void addNewPhone(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите имя и фамилию через пробел:\n";
    String inputName = enterFromUser(msg);
    if (book.containsKey(inputName)) {
      String msg1 = "Введите новый номер:\n";
      String inputNewPhone = enterFromUser(msg1);
      LinkedList<String> UserPhones = book.get(inputName);
      if (UserPhones.contains(inputNewPhone)) {
        System.out.printf("У абонента \"%s\" номер \"%s\" уже сохранён.%n", inputName, inputNewPhone);
      } else {
        UserPhones.add(inputNewPhone);
        book.put(inputName, UserPhones);
        System.out.printf("Абоненту \"%s\" добавлен новый номер %s%n", inputName, inputNewPhone);
      }
    } else {
      System.out.printf("Абонента \"%s\" в справочнике нет.\n", inputName);
    }
  }

  public static void findPersonByPhone(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите номер абонента для поиска:\n";
    String inputPhone = enterFromUser(msg);
    int count = 0;
    for (Map.Entry<String, LinkedList<String>> item : book.entrySet()) {
      String key = item.getKey();
      LinkedList<String> UserPhones = item.getValue();
      for (String phone : UserPhones) {
        if (phone.equals(inputPhone)) {
          System.out.printf("За абонентом \"%s\" числится номер \"%s\"%n", key, inputPhone);
          count++;
        }
      }
    }
    if (count == 0) {
      System.out.printf("Номер \"%s\" отсутствует в справочнике.%n", inputPhone);
    }
  }

  public static void changePerson(HashMap<String, LinkedList<String>> book) {
    String msg1 = "Введите имя абонента, подлежащее замене:\n";
    String inputName = enterFromUser(msg1);
    if (book.containsKey(inputName)) {
      String msg2 = "Введите новые имя и фамилию абонента:\n";
      String newName = enterFromUser(msg2);
      LinkedList<String> UserPhones = book.get(inputName);
      book.put(newName, UserPhones);
      book.remove(inputName);
      System.out.println("Имя и фамилия успешно изменены.\n");
    } else {
      System.out.printf("Абонента \"%s\" в справочнике нет.\n", inputName);
    }
  }

  public static void deletePhone(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите имя и фамилию через пробел:\n";
    String inputName = enterFromUser(msg);
    if (book.containsKey(inputName)) {
      String msg1 = "Введите номер для удаления: \n";
      String inputPhone = enterFromUser(msg1);
      LinkedList<String> userPhones = book.get(inputName);
      int count = 0;
      for (int i = 0; i < userPhones.size(); i++) {
        if (userPhones.get(i).equals(inputPhone)) {
          System.out.printf("У абонента \"%s\" удалён номер \"%s\".%n", inputName, userPhones.remove(i));
          count++;
        }
      }
      if (count == 0) {
        System.out.printf("У абонента \"%s\" не найден номер \"%s\".%n", inputName, inputPhone);
      }
    } else {
      System.out.printf("Абонента \"%s\" нет в справочнике.%n", inputName);
    }
  }

  public static void deletePerson(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите имя и фамилию через пробел:\n";
    String inputName = enterFromUser(msg);
    if (book.containsKey(inputName)) {
      book.remove(inputName);
      System.out.printf("Удаление абонента \"%s\" из справочника прошло успешно!%n", inputName);
    } else {
      System.out.printf("Абонента \"%s\" нет в справочнике.%n", inputName);
    }
  }

  public static void printPerson(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите имя и фамилию через пробел:\n";
    String inputName = enterFromUser(msg);
    if (book.containsKey(inputName)) {
      LinkedList<String> userPhones = book.get(inputName);
      System.out.printf("Абонент \"%s\" найден:%n", inputName);
      for (int i = 0; i < userPhones.size(); i++) {
        System.out.printf("Номер \"%d\" -> \"%s\"%n", i + 1, userPhones.get(i));
      }
    } else {
      int count = 0;
      for (Map.Entry<String, LinkedList<String>> item : book.entrySet()) {
        String key = item.getKey();
        if (key.contains(inputName)) {
//                    LinkedList<String> userPhones = item.getValue();
          LinkedList<String> userPhones = book.get(key);
          System.out.printf("Абонент \"%s\", содержит искомое \"%s\":%n", key, inputName);
          for (int i = 0; i < userPhones.size(); i++) {
            System.out.printf("Номер \"%d\" -> \"%s\"%n", i + 1, userPhones.get(i));
            count++;
          }
        }
      }
      if (count == 0) {
        System.out.printf("Абонента \"%s\" нет в справочнике.%n", inputName);
      }
    }
  }

  public static void printAllPhoneBook(HashMap<String, LinkedList<String>> book) {
    TreeMap<String, LinkedList<String>> bookTreeMap = new TreeMap<>(Comparator.naturalOrder());
    bookTreeMap.putAll(book);
    for (Map.Entry<String, LinkedList<String>> item : bookTreeMap.entrySet()) {
      String key = item.getKey();
      LinkedList<String> userPhones = item.getValue();
      System.out.printf("Телефоны абонента \"%s\":%n", key);
      int count = 1;
      for (String phone : userPhones) {
        System.out.printf("Номер \"%d\" -> \"%s\"%n", count, phone);
        count++;
      }
    }
  }

  public static void addNewPerson(HashMap<String, LinkedList<String>> book) {
    String msg = "Введите имя и фамилию через пробел:\n";
    String inputName = enterFromUser(msg);
    if (book.containsKey(inputName)) {
      System.out.printf("Абонент \"%s\" уже есть в справочнике!%n", inputName);
    } else {
      String msg1 = "Введите новый номер:%n";
      String inputNewPhone = enterFromUser(msg1);
      LinkedList<String> UserPhones = new LinkedList<>();
      UserPhones.add(inputNewPhone);
      book.put(inputName, UserPhones);
      System.out.printf("Новый абонент \"%s\" и номер \"%s\" успешно добалены!%n", inputName, inputNewPhone);
    }
  }
}
