package tema.frr.chicken;

import java.sql.Date;
import java.util.Scanner;

public class ClientHandler {
  static class clientDTO {
    String id;
    String pwd;
    String name;
    Date birthday;
    String sex;
    String tel;
    String address;
    Date signUpDate;
  }

  static final int CLIENT_SIZE = 100_000;
  static clientDTO[] clients = new clientDTO[CLIENT_SIZE];
  static int clountCount = 0;
  static Scanner keyboard;

  static void addClient() {
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

    clients[clountCount++] = c;

    System.out.println("저장하였습니다.");
  }

  static void listClient() {
    for (int i = 0; i < clountCount; i++) {
      clientDTO c = clients[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.id, c.name, c.birthday, c.sex, c.tel, c.signUpDate);
    }
  }


}
