package tema.frr.chicken.handler;

import java.sql.Date;
import java.util.Scanner;
import tema.frr.chicken.domain.Client;
import tema.frr.util.ArrayList;

public class ClientHandler {
  
  ArrayList<Client> clientList;
  Scanner input;
  
  public ClientHandler(Scanner input) {
    this.input = input;
    clientList = new ArrayList<>();
  }

  public void addClient() {
    Client c = new Client();

    System.out.println("ID를 입력해주세요.");
    c.setId(input.nextLine());

    System.out.println("PWD를 입력해주세요.");
    c.setPwd(input.nextLine());

    System.out.println("이름을 입력해주세요.");
    c.setName(input.nextLine());

    System.out.println("생년월일을 입력해주세요.");
    c.setBirthday(Date.valueOf(input.nextLine()));

    System.out.println("성별을 입력해주세요.");
    c.setSex(input.nextLine());

    System.out.println("전화번호를 입력해주세요.");
    c.setTel(input.nextLine());

    System.out.println("주소를 입력해주세요.");
    c.setAddress(input.nextLine());

    c.setSignUpDate(new Date(System.currentTimeMillis()));

    clientList.add(c);

    System.out.println("저장하였습니다.");
  }

  public void listClient() {
    Client[] clients = this.clientList.toArray(new Client[this.clientList.size()]);
    for (Client c : clients) {
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), 
          c.getBirthday(), c.getSex(), c.getTel(), c.getSignUpDate());
    }
  }
}
