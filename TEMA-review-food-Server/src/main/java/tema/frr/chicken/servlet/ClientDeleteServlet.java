package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.dao.json.ClientJsonFileDao;

public class ClientDeleteServlet implements Servlet {

  ClientJsonFileDao clientDao;

  public ClientDeleteServlet(ClientJsonFileDao clientDao) {
    this.clientDao = clientDao;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    String id = in.readUTF();

    if (clientDao.delete(id) > 0) {
      out.writeUTF("OK");

    } else {
      out.writeUTF("FAIL");
      out.writeUTF("해당 ID의 고객이 없습니다.");
    }
  }
}
