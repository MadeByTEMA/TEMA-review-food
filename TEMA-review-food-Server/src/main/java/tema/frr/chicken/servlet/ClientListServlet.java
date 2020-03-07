package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientListServlet implements Servlet {

  ClientDao clientDao;

  public ClientListServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    List<Client> clients = clientDao.findAll();
    for (Client c : clients) {
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
          c.getSex(), c.getTel(), c.getSignUpDate());
    }
  }
}
