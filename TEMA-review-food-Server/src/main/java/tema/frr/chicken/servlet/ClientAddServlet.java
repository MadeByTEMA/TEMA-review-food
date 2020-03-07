package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientAddServlet implements Servlet {

  ClientDao clientDao;

  public ClientAddServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Client c = new Client();

    out.println("ID를 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setId(in.nextLine());

    out.println("Pwd를 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setPwd(in.nextLine());

    out.println("이름을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setName(in.nextLine());

    out.println("생년월일을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setBirthday(Date.valueOf(in.nextLine()));

    out.println("성별을 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setSex(in.nextLine());

    out.println("전화번호를 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setTel(in.nextLine());

    out.println("주소를 입력해주세요. ");
    out.println("!{}!");
    out.flush();
    c.setAddress(in.nextLine());

    c.setSignUpDate(new Date(System.currentTimeMillis()));

    if (clientDao.update(c) > 0) {
      out.println("고객을 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
