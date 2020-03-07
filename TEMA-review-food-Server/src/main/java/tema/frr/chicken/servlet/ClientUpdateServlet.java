package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientUpdateServlet implements Servlet {

  ClientDao clientDao;

  public ClientUpdateServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int clientNo = Integer.parseInt(in.nextLine());

    Client oldClient = null;
    try {
      oldClient = clientDao.findByClientNo(clientNo);
    } catch (Exception e) {
      System.out.println("해당 ID의 회원이 없습니다!");
      return;
    }

    Client newClient = new Client();

    newClient.setId(oldClient.getId());

    out.printf("이름(%s): \n", oldClient.getName());
    out.println("!{}!");
    out.flush();
    newClient.setName(in.nextLine());

    out.printf("생일(%s): \n", oldClient.getBirthday());
    out.println("!{}!");
    out.flush();
    newClient.setBirthday(Date.valueOf(in.nextLine()));

    out.printf("성별(%s): \n", oldClient.getSex());
    out.println("!{}!");
    out.flush();
    newClient.setSex(in.nextLine());

    out.printf("전화번호(%s): \n", oldClient.getTel());
    out.println("!{}!");
    out.flush();
    newClient.setTel(in.nextLine());

    out.printf("주소(%s): \n", oldClient.getAddress());
    out.println("!{}!");
    out.flush();
    newClient.setAddress(in.nextLine());


    if (clientDao.update(oldClient) > 0) {
      out.println("고객을 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
