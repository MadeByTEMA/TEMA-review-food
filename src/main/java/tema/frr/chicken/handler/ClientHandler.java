package tema.frr.chicken.handler;

import java.sql.Date;
import java.util.Scanner;
import tema.frr.chicken.domain.*;

public class ClientHandler {
  
  final int CLIENT_SIZE = 100_000;
  Client[] clients;
  int clountCount = 0;
  
  Scanner input;
  
  public ClientHandler(Scanner input) {
    this.input = input;
    this.clients = new Client[CLIENT_SIZE];
  }

  public void addClient() {
    Client c = new Client();

    System.out.println("ID를 입력해주세요.");
    c.id = input.nextLine();

    System.out.println("PWD를 입력해주세요.");
    c.pwd = input.nextLine();

    System.out.println("이름을 입력해주세요.");
    c.name = input.nextLine();

    System.out.println("생년월일을 입력해주세요.");
    c.birthday = Date.valueOf(input.nextLine());

    System.out.println("성별을 입력해주세요.");
    c.sex = input.nextLine();

    System.out.println("전화번호를 입력해주세요.");
    c.tel = input.nextLine();

    System.out.println("주소를 입력해주세요.");
    c.address = input.nextLine();

    c.signUpDate = new Date(System.currentTimeMillis());

    this.clients[this.clountCount++] = c;

    System.out.println("저장하였습니다.");
  }

  public  void listClient() {
    for (int i = 0; i < this.clountCount; i++) {
      Client c = this.clients[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.id, c.name, c.birthday, c.sex, c.tel, c.signUpDate);
    }
  }


}
