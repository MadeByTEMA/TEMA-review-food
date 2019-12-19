package tema.frr.chicken;

import java.sql.Date;
import java.util.Scanner;

public class client {
  static final int size = 100_000;
  static clientDTO[] clients = new clientDTO[size];
  static int count = 0;

  public static void main(String[] args) {

    inputBoards();

    System.out.println();

    printBoards();

  }

  static void inputBoards() {
    Scanner keyboard = new Scanner(System.in);
    String response;

    for (int i = 0; i < size; i++) {
      clientDTO c = new clientDTO();

      System.out.println("ID를 입력해주세요.");
      c.id = keyboard.nextLine();

      System.out.println("PWD를 입력해주세요.");
      c.pwd = keyboard.nextLine();

      System.out.println("이름을 입력해주세요.");
      c.name = keyboard.nextLine();

      System.out.println("생년월일을 입력해주세요.");
      c.birthday = Date.valueOf(keyboard.nextLine());

      System.out.println("성별을 입력해주세요.");
      c.sex = keyboard.nextLine();

      System.out.println("전화번호를 입력해주세요.");
      c.tel = keyboard.nextLine();

      System.out.println("주소를 입력해주세요.");
      c.address = keyboard.nextLine();

      c.signUpDate = new Date(System.currentTimeMillis());

      clients[i] = c;

      count++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까 ? Y/N ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }
    }
    keyboard.close();
  }
  static void printBoards() {
    for (int i = 0; i < count; i++) {
      clientDTO c = clients[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.id, c.name, c.birthday, c.sex, c.tel, c.signUpDate);
    }
  }
}