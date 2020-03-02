package tema.frr.chicken.handler;

import java.util.List;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.domain.Client;

public class ClientListCommand implements Command {

  ClientDaoProxy clientDao;

  public ClientListCommand(ClientDaoProxy clientDao) {
    this.clientDao = clientDao;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

    try {
      List<Client> clients = clientDao.findAll();
      for (Client c : clients) {
        System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
            c.getSex(), c.getTel(), c.getSignUpDate());
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}
