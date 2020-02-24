package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.ClientJsonFileDao;
import tema.frr.chicken.domain.Client;

public class ClientAddServlet implements Servlet {

  ClientJsonFileDao clientDao;

  public ClientAddServlet(ClientJsonFileDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    Client client = (Client) in.readObject();

    if (clientDao.insert(client) > 0) {
      out.writeUTF("OK");
    } else {
      out.writeUTF("FAIL");
      out.writeUTF("같은 ID의 고객이 있습니다.");
    }
  }
}
