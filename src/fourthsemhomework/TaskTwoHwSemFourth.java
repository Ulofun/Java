package fourthsemhomework;
import java.util.*;

public class TaskTwoHwSemFourth {
  public static void main(String[] args) {
//      2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    LinkedList<String> wordsList = new LinkedList<>();
    Collections.addAll(wordsList, "apple", "orange", "banana", "mango", "tomato", "strawberry", "melon");
//        reversLinkedListMethod1(wordsList);
//        reversLinkedListMethod2(wordsList);
    reversLinkedListWithGeneratorMethod1(); //  работает быстро для больших объёмов данных
    reversLinkedListWithGeneratorMethod2(); //  работает крайне медленно для больших объёмов данных
  }

  private static void reversLinkedListMethod1(LinkedList<String> list) {
    LinkedList<String> reverslist = new LinkedList<>();
    System.out.printf("Заданный список:%n" + list + "\n");
    for (String word : list) {
//            reverslist.push(word); // первый вариант
      reverslist.addFirst(word); // второй вариант
    }
    System.out.printf("Первый метод. Перевёрнутый список:%n" + reverslist + "\n");
  }

  private static void reversLinkedListMethod2(LinkedList<String> list) {
    System.out.printf("Заданный список:%n" + list + "\n");
    int length = list.size();
    for (int i = 0; i < length / 2; i++) {
      String temp = list.get(length - 1 - i);
      list.set(length - 1 - i, list.get(i));
      list.set(i, temp);
    }
    System.out.printf("Второй метод. Перевёрнутый список:%n" + list + "\n");

  }

  private static void reversLinkedListWithGeneratorMethod1() {
    final int SIZE = 1_00000;
    Random random = new Random();
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < SIZE; i++) {
      linkedList.add(0, random.nextInt());
    }
    long start = System.currentTimeMillis();
    LinkedList<Integer> reverslist = new LinkedList<>();
    for (Integer num : linkedList) {
//            reverslist.push(word); // первый вариант
      reverslist.addFirst(num); // второй вариант
    }
    System.out.println("LinkedList: " + (System.currentTimeMillis() - start));
  }

  private static void reversLinkedListWithGeneratorMethod2() {
    final int SIZE = 1_00000;
    Random random = new Random();
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < SIZE; i++) {
      linkedList.add(0, random.nextInt());
    }
    int length = linkedList.size();
    long start = System.currentTimeMillis();
    for (int i = 0; i < length / 2; i++) {
      int temp = linkedList.get(length - 1 - i);
      linkedList.set(length - 1 - i, linkedList.get(i));
      linkedList.set(i, temp);
    }
    System.out.println("LinkedList: " + (System.currentTimeMillis() - start));
  }
}