package tema.frr.chicken.servlet;


import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientSearchServlet implements Servlet{

  ClientDao clientDao;

  public ClientSearchServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    String keyword = Prompt.getString(in, out, "키워드? ");

    List<Client> clients = clientDao.findByKeyword(keyword);

    for (Client c : clients) {
      out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
          c.getSex(), c.getTel(), c.getSignUpDate());
    }
  }
}
