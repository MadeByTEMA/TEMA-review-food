package tema.frr.chicken.handler;

import java.util.List;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientDeleteCommand implements Command {

  List<Client> clientList;

  Prompt prompt;

  public ClientDeleteCommand(Prompt prompt, List<Client> list) {
    this.prompt = prompt;
    clientList = list;
  }

  @Override
  public void execute() {
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
