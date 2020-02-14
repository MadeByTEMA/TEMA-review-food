package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientListServlet implements Servlet {

  List<Client> clients;

  public ClientListServlet(List<Client> clients) {
    this.clients = clients;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK");
    out.reset();
    out.writeObject(clients);
  }
}
