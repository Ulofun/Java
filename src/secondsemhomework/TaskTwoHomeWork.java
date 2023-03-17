package secondsemhomework;

import java.io.FileOutputStream;
import java.io.IOException;

public class TaskTwoHomeWork {
  /*
   * Напишите метод, который составит строку, состоящую из 100 повторений слова
   * TEST и метод,
   * который запишет эту строку в простой текстовый файл, обработайте исключения.
   */

  public StringBuilder generateString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("TEST ".repeat(100));
    return stringBuilder;
  }

  public void writer() {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream("test.txt");

      fileOutputStream.write(generateString().toString().getBytes());

      fileOutputStream.close();
    } catch (IOException e) {
      System.out.println("Проблема вывода!");
      e.printStackTrace();
    }
  }
}
