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

  public void detailClient() {
    System.out.print("ID? ");
    String command = input.nextLine();

    int index = indexOfClient(command);

    Client client = new Client();
    
    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    client = this.clientList.get(index);

    System.out.printf("이름 : %s\n", client.getId());
    System.out.printf("생일 : %s\n", client.getBirthday());
    System.out.printf("성별 : %s\n", client.getSex());
    System.out.printf("전화번호 : %s\\n", client.getTel());
    System.out.printf("주소 : %s\n", client.getAddress());
    System.out.printf("가입일 : %s\n", client.getSignUpDate());
  }

  public void updateClient() {
    System.out.print("ID? ");
    String command = input.nextLine();

    int index = indexOfClient(command);

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    Client oldClient = this.clientList.get(index);

    Client newClient = new Client();

    boolean changed = false;

    newClient.setId(oldClient.getId());
    
    System.out.printf("이름(%s): \n", oldClient.getName());
    newClient.setName(input.nextLine());
    if(newClient.getName().length() == 0) {
      newClient.setName(oldClient.getName());
    } else {
      changed = true;
    }

    System.out.printf("생일(%s): \n", oldClient.getBirthday());
    String birthday = input.nextLine();
    if(birthday.length() == 0) {
      newClient.setBirthday(oldClient.getBirthday());
    } else {
      newClient.setBirthday(Date.valueOf(birthday));
      changed = true;
    }

    System.out.printf("성별(%s): \n", oldClient.getSex());
    newClient.setSex(input.nextLine());
    if(newClient.getSex().length() == 0) {
      newClient.setSex(oldClient.getSex());
    } else {
      changed = true;
    }
    System
    .out.printf("전화번호(%s): \n", oldClient.getTel());
    newClient.setTel(input.nextLine());
    if(newClient.getTel().length() == 0) {
      newClient.setTel(oldClient.getTel());
    } else {
      changed = true;
    }

    System.out.printf("주소(%s): \n", oldClient.getAddress());
    newClient.setAddress(input.nextLine());
    if(newClient.getAddress().length() == 0) {
      newClient.setAddress(oldClient.getAddress());
    } else {
      changed = true;
    }
    
    newClient.setSignUpDate(oldClient.getSignUpDate());

    if (changed) {
      this.clientList.set(index, newClient);
      System.out.println("고객을 변경했습니다.");
    } else {
      System.out.println("고객 변경을 취소했습니다.");
    }
  }

  public void deleteClient() {
    System.out.print("ID? ");
    String command = input.nextLine();

    int index = indexOfClient(command);

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    } else {
      this.clientList.remove(index);
      System.out.println("고객을 삭제했습니다.");
    }
  }

  private int indexOfClient(String id) {
    for(int i = 0; i < clientList.size(); i++) {
      Client temp = this.clientList.get(i);
      if (id.equals(temp.getId())) {
        return i;
      }
    }
    return -1;
  }
}
