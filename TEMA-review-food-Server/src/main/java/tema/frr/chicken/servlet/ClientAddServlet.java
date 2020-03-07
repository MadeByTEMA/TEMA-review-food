package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.sql.Date;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientAddServlet implements Servlet {

  ClientDao clientDao;

  public ClientAddServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    Client c = new Client();

    c.setId(Prompt.getString(in, out, "ID를 입력해주세요. "));
    c.setPwd(Prompt.getString(in, out, "Pwd를 입력해주세요. "));
    c.setName(Prompt.getString(in, out, "이름을 입력해주세요. "));
    c.setBirthday(Prompt.getDate(in, out, "생년월일을 입력해주세요. "));
    c.setSex(Prompt.getString(in, out, "성별을 입력해주세요. "));
    c.setTel(Prompt.getString(in, out, "전화번호를 입력해주세요. "));
    c.setAddress(Prompt.getString(in, out, "주소를 입력해주세요. "));
    c.setSignUpDate(new Date(System.currentTimeMillis()));

    if (clientDao.update(c) > 0) {
      out.println("고객을 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
