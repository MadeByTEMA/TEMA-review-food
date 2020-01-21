package tema.frr.chicken.handler;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientUpdateCommand implements Command {

  List<Client> clientList;

  Prompt prompt;

  public ClientUpdateCommand(Prompt prompt, List<Client> list) {
    this.prompt = prompt;
    clientList = list;
  }

  public void addClient() {
    Client c = new Client();

    c.setId(prompt.inputString("ID를 입력해주세요. "));
    c.setPwd(prompt.inputString("Pwd를 입력해주세요. "));
    c.setName(prompt.inputString("이름을 입력해주세요. "));
    c.setBirthday(prompt.inputDate("생년월일을 입력해주세요. "));
    c.setSex(prompt.inputString("성별을 입력해주세요. "));
    c.setTel(prompt.inputString("전화번호를 입력해주세요. "));
    c.setAddress(prompt.inputString("주소를 입력해주세요. "));
    c.setSignUpDate(new Date(System.currentTimeMillis()));

    clientList.add(c);

    System.out.println("저장하였습니다.");
  }

  public void listClient() {
    Iterator<Client> iterator = clientList.iterator();
    while (iterator.hasNext()) {
      Client c = iterator.next();
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
          c.getSex(), c.getTel(), c.getSignUpDate());
    }
  }

  public void detailClient() {
    int index = indexOfClient(prompt.inputString("ID? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    Client client = this.clientList.get(index);

    System.out.printf("이름 : %s\n", client.getName());
    System.out.printf("생일 : %s\n", client.getBirthday());
    System.out.printf("성별 : %s\n", client.getSex());
    System.out.printf("전화번호 : %s\n", client.getTel());
    System.out.printf("주소 : %s\n", client.getAddress());
    System.out.printf("가입일 : %s\n", client.getSignUpDate());
  }

  public void updateClient() {
    int index = indexOfClient(prompt.inputString("ID? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    Client oldClient = this.clientList.get(index);
    Client newClient = new Client();

    newClient.setId(oldClient.getId());

    newClient.setName(
        prompt.inputString(String.format("이름(%s): \n", oldClient.getName()), oldClient.getName()));

    newClient.setBirthday(prompt.inputDate(String.format("생일(%s): \n", oldClient.getBirthday()),
        oldClient.getBirthday()));

    newClient.setSex(
        prompt.inputString(String.format("성별(%s): \n", oldClient.getSex()), oldClient.getSex()));

    newClient.setTel(
        prompt.inputString(String.format("전화번호(%s): \n", oldClient.getTel()), oldClient.getTel()));

    newClient.setAddress(prompt.inputString(String.format("주소(%s): \n", oldClient.getAddress()),
        oldClient.getAddress()));

    if (newClient.equals(oldClient)) {
      System.out.println("고객 변경을 취소했습니다.");
      return;
    } else {
      newClient.setSignUpDate(oldClient.getSignUpDate());
      this.clientList.set(index, newClient);
      System.out.println("고객을 변경했습니다.");
    }
  }

  public void deleteClient() {
    int index = indexOfClient(prompt.inputString("ID? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    } else {
      this.clientList.remove(index);
      System.out.println("고객을 삭제했습니다.");
    }
  }

  private int indexOfClient(String id) {
    for (int i = 0; i < clientList.size(); i++) {
      Client temp = this.clientList.get(i);
      if (id.equals(temp.getId())) {
        return i;
      }
    }
    return -1;
  }
}
