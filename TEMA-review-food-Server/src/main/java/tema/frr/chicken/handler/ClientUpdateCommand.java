package tema.frr.chicken.handler;

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

  @Override
  public void execute() {
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
