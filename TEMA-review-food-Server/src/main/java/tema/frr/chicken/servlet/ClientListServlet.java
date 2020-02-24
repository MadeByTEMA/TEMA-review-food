package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.ClientJsonFileDao;

public class ClientListServlet implements Servlet {

  ClientJsonFileDao clientDao;

  public ClientListServlet(ClientJsonFileDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(clientDao.findAll());
  }
}
