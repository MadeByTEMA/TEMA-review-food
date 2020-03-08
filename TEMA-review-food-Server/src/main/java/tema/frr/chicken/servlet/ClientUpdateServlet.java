package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientUpdateServlet implements Servlet {

  ClientDao clientDao;

  public ClientUpdateServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {
    int clientNo = Prompt.getInt(in, out, "번호? ");

    Client oldClient = null;
    try {
      oldClient = clientDao.findByClientNo(clientNo);
    } catch (Exception e) {
      System.out.println("해당 ID의 회원이 없습니다!");
      return;
    }

    Client newClient = new Client();

    newClient.setId(oldClient.getId());
    newClient.setPwd(oldClient.getPwd());
    newClient.setName(Prompt.getString(in, out, "이름(%s): \n", oldClient.getName()));
    newClient.setBirthday(Prompt.getDate(in, out, String.format("생일(%s): \n", oldClient.getBirthday()), oldClient.getBirthday().toString()));
    newClient.setSex(Prompt.getString(in, out, "성별(%s): \n", oldClient.getSex()));
    newClient.setTel(Prompt.getString(in, out, "전화번호(%s): \n", oldClient.getTel()));
    newClient.setAddress(Prompt.getString(in, out, "주소(%s): \n", oldClient.getAddress()));

    if (clientDao.update(oldClient) > 0) {
      out.println("고객을 변경했습니다.");

    } else {
      out.println("변경에 실패했습니다.");
    }
  }
}
