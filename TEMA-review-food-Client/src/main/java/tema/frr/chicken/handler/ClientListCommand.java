package tema.frr.chicken.handler;

import java.util.Iterator;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientListCommand implements Command {

  List<Client> clientList;

  public ClientListCommand(List<Client> list) {
    clientList = list;
  }

  @Override
  public void execute() {
    Iterator<Client> iterator = clientList.iterator();
    while (iterator.hasNext()) {
      Client c = iterator.next();
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
          c.getSex(), c.getTel(), c.getSignUpDate());
    }
  }
}
