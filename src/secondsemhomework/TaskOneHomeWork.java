package secondsemhomework;

import java.lang.reflect.Array;

public class TaskOneHomeWork {
  //Напишите метод, который принимает на вход строку (String)
  //и определяет является ли строка палиндромом (возвращает boolean значение).
  public Boolean task1hw(String word) {
    int wordSize = word.length() - 1;
    char[] wordAsArray = word.toCharArray();
    String result = "";


    for (int i = wordSize; i != -1; i--) {
      result = result.concat(String.valueOf(wordAsArray[i]));
    }

    return result.equals(word);
  }
}
