package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientDetailServlet implements Servlet {

  ClientDao clientDao;

  public ClientDetailServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int clientNo = Prompt.getInt(in, out, "번호? ");

    Client client = clientDao.findByClientNo(clientNo);

    if (client != null) {
      out.printf("이름 : %s\n", client.getName());
      out.printf("생일 : %s\n", client.getBirthday());
      out.printf("성별 : %s\n", client.getSex());
      out.printf("전화번호 : %s\n", client.getTel());
      out.printf("주소 : %s\n", client.getAddress());
      out.printf("가입일 : %s\n", client.getSignUpDate());
    } else {
      out.println("해당 번호의 고객이 없습니다.");
    }
  }
}
