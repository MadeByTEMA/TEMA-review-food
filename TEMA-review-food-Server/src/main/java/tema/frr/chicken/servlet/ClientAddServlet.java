package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientAddServlet implements Servlet {

  List<Client> clients;

  public ClientAddServlet(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      Client client = (Client) in.readObject();

      int i = 0;
      for (; i < clients.size(); i++) {
        if (clients.get(i).getId() == client.getId()) {
          break;
        }
      }

      if (i == clients.size()) { // 같은 번호의 게시물이 없다면,
        clients.add(client); // 새 게시물을 등록한다.
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("같은 ID의 고객이 있습니다.");
      }

    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
