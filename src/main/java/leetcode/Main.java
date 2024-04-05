package leetcode;

public class Main {

  public static void main(String[] args) {
    String input = "Это строка с цифрами: 1234asd56789123asdasd0";

    // Заменяем все цифры на пустоту
    String result = input.replaceAll("\\D", "");

    System.out.println(result);
  }
}
