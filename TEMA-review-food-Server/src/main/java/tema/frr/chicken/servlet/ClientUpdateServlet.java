package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientUpdateServlet implements Servlet {

  List<Client> clients;

  public ClientUpdateServlet(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Client client = (Client) in.readObject();

      int index = -1;
      for (int i = 0; i < clients.size(); i++) {
        if (clients.get(i).getId() == client.getId()) {
          index = i;
          break;
        }
      }

      if (index != -1) {
        clients.set(index, client);
        out.writeUTF("OK");
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
