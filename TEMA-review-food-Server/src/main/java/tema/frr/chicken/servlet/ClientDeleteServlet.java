package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.util.Prompt;

public class ClientDeleteServlet implements Servlet {

  ClientDao clientDao;

  public ClientDeleteServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int clientno = Prompt.getInt(in, out, "번호? ");

    if (clientDao.delete(clientno) > 0) {
      out.println("고객을 삭제했습니다.");

    } else {
      out.println("해당 ID의 고객이 없습니다.");
    }
  }
}
