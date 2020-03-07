package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;

public class ClientDeleteServlet implements Servlet {

  ClientDao clientDao;

  public ClientDeleteServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int clientno = Integer.parseInt(in.nextLine());

    if (clientDao.delete(clientno) > 0) {
      out.println("고객을 삭제했습니다.");

    } else {
      out.println("해당 ID의 고객이 없습니다.");
    }
  }
}
