package fivesemhomework;

import java.util.*;

public class TaskTwoHwSemFive {
  public static void main(String[] args) {
//        2. Пусть дан список сотрудников:
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//        Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений
//        Отсортировать по убыванию популярности.

    List<String> names = new ArrayList<>();
    Collections.addAll(names,
        "Иван Иванов", "Светлана Петрова", "Кристина Белова",
        "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
        "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
        "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
        "Иван Мечников", "Петр Петин", "Иван Ежов");
    System.out.println(names);
    HashMap<String, Integer> namesMap = getNamesMap(names);
//        System.out.println(namesMap);
    TreeMap<Integer, String> numNamesTMap = sortNamesMap(namesMap);
//        System.out.println(numNamesTMap);
    printMap(numNamesTMap);

  }

  private static void printMap(TreeMap<Integer, String> numNamesTMap) {
    for (Map.Entry<Integer, String> item : numNamesTMap.entrySet()) {
      int key = item.getKey();
      String[] values = item.getValue().split(" ");
      for (int i = 0; i < values.length; i++) {
        System.out.printf("Имя %s повторяется %d раз(а)%n", values[i], key);
      }
    }
  }

  private static TreeMap<Integer, String> sortNamesMap(HashMap<String, Integer> namesMap) {
    TreeMap<Integer, String> numNamesTMap = new TreeMap<>(Comparator.reverseOrder());
    for (Map.Entry<String, Integer> item : namesMap.entrySet()) { //Мария=3
      int newKey = item.getValue(); // 3
      String newValue = item.getKey(); // Мария
      if (numNamesTMap.containsKey(newKey)) {
        numNamesTMap.put(newKey, numNamesTMap.get(newKey) + " " + newValue);
      } else {
        numNamesTMap.put(newKey, newValue);
      }
    }
    return numNamesTMap;
  }


  private static HashMap<String, Integer> getNamesMap(List<String> names) {
    HashMap<String, Integer> namesMap = new HashMap<>();
    for (String item : names) {
      String[] name = item.split(" ");
      if (namesMap.containsKey(name[0])) {
        namesMap.put(name[0], namesMap.get(name[0]) + 1);
      } else {
        namesMap.put(name[0], 1);
      }
    }
    return namesMap;
  }
}
