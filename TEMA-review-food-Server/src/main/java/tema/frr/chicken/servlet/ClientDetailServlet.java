package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientDetailServlet implements Servlet {

  List<Client> clients;

  public ClientDetailServlet(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      String id = in.readUTF();

      Client client = null;
      for (Client b : clients) {
        if (b.getId() == id) {
          client = b;
          break;
        }
      }

      if (client != null) {
        out.writeUTF("OK");
        out.writeObject(client);

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 ID의 고객이 없습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
