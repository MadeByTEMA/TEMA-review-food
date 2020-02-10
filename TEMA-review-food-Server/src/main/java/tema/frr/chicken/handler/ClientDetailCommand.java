package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientDetailCommand implements Command {

  List<Client> clientList;

  Prompt prompt;

  public ClientDetailCommand(Prompt prompt, List<Client> list) {
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

    Client client = this.clientList.get(index);

    System.out.printf("이름 : %s\n", client.getName());
    System.out.printf("생일 : %s\n", client.getBirthday());
    System.out.printf("성별 : %s\n", client.getSex());
    System.out.printf("전화번호 : %s\n", client.getTel());
    System.out.printf("주소 : %s\n", client.getAddress());
    System.out.printf("가입일 : %s\n", client.getSignUpDate());
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
