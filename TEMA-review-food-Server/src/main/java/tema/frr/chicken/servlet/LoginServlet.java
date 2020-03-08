package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class LoginServlet implements Servlet {

  ClientDao cientDao;

  public LoginServlet(ClientDao memberDao) {
    this.cientDao = memberDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    String email = Prompt.getString(in, out, "이메일? ");
    String password = Prompt.getString(in, out, "암호? ");

    Client client = cientDao.findByIdAndPassword(email, password);

    if (client != null) {
      out.printf("'%s'님 환영합니다.\n", client.getName());
    } else {
      out.println("사용자 정보가 유효하지 않습니다.");
    }
  }
}
