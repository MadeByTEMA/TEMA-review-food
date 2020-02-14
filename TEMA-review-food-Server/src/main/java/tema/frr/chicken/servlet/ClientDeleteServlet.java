package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientDeleteServlet implements Servlet {

  List<Client> clients;

  public ClientDeleteServlet(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      String id = in.readUTF();

      int index = -1;
      for (int i = 0; i < clients.size(); i++) {
        if (clients.get(i).getId() == id) {
          index = i;
          break;
        }
      }

      if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
        clients.remove(index);
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
