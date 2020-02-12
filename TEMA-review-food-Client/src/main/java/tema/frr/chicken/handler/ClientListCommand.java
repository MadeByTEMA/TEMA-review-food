package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public ClientListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void execute() {

    try {
      out.writeUTF("/client/list");
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      } else {
        List<Client> clients = (List<Client>) in.readObject();
        for (Client c : clients) {
          System.out.printf("%s, %s, %s, %s, %s, %s\n", c.getId(), c.getName(), c.getBirthday(),
              c.getSex(), c.getTel(), c.getSignUpDate());
        }
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}
