package thirdsemhomework;
import java.util.*;
import static java.lang.Integer.*;


public class TaskThreeHwSemThree {
  //3. Создать список типа ArrayList<String>.
  // Поместить в него как строки, так и целые числа.
  // Пройти по списку, найти и удалить целые числа.
  public static void main(String[] args) {
    List<String> different = List.of("Mercury", "-25", "Venus", "12", "Earth", "-9",
        "Mars", "40", "Jupiter", "-177", "Saturn", "232", "Uranus", "54", "Neptun", "0", "Pluto", "-31");
    List<String> randomList = createRandomList(different);
    System.out.printf("Случайный массив строк:\n" + randomList + "\n");
    deleteIntegerMethod1(randomList);
    deleteIntegerMethod2(randomList);

  }
  private static void deleteIntegerMethod1(List<String> str) {
    for (int i = str.size() - 1; i >= 0; i--) {
      try {
        Integer.parseInt(str.get(i));
        str.remove(i);
      } catch (NumberFormatException ignored) {
      }
    }
    System.out.printf("Решение первым методом. Массив после удаления целых чисел:\n" + str + "\n");
  }
  private static void deleteIntegerMethod2(List<String> str) {
    List <String> result = new ArrayList<>();
    for (int i = 0; i < str.size(); i++) {
      try {
        Integer.parseInt(str.get(i));
      } catch (NumberFormatException e) {
        result.add(str.get(i));
      }
    }
    System.out.printf("Решение вторым методом. Массив после удаления целых чисел:\n" + result);
  }

  private static List<String> createRandomList(List<String> str) {
    Scanner in = new Scanner(System.in);
    System.out.println("Введите размер массива:");
    int size = parseInt(in.nextLine());
    in.close();
    Random random = new Random();
    List<String> stringList = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      String randomElement = str.get(random.nextInt(str.size()));
      stringList.add(randomElement);
    }
    return stringList;
  }
}

