package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientUpdateServlet implements Servlet {

  ClientDao clientDao;

  public ClientUpdateServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Client client = (Client) in.readObject();

    if (clientDao.update(client) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 ID의 고객이 없습니다.");
    }
  }
}
