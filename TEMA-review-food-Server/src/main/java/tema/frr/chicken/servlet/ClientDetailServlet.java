package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientDetailServlet implements Servlet {

  ClientDao clientDao;

  public ClientDetailServlet(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String id = in.readUTF();

    Client client = clientDao.findById(id);

    if (client != null) {
      out.writeUTF("OK");
      out.writeObject(client);

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 ID의 고객이 없습니다.");
    }
  }
}
