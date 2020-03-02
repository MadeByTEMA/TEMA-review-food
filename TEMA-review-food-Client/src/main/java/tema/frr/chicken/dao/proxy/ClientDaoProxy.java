package tema.frr.chicken.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientDaoProxy implements ClientDao{

  ObjectInputStream in;
  ObjectOutputStream out;

  public ClientDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  @Override
  public int insert(Client client) throws Exception {
    out.writeUTF("/client/add");
    out.writeObject(client);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }

    return 1;
  }


  @SuppressWarnings("unchecked")
  @Override
  public List<Client> findAll() throws Exception {
    out.writeUTF("/client/list");
    out.flush();
    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (List<Client>) in.readObject();
  }

  @Override
  public Client findById(String id) throws Exception {
    out.writeUTF("/client/detail");
    out.writeUTF(id);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return (Client) in.readObject();
  }

  @Override
  public int update(Client client) throws Exception {
    out.writeUTF("/client/update");
    out.writeObject(client);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }

  @Override
  public int delete(String id) throws Exception {
    out.writeUTF("/client/delete");
    out.writeUTF(id);
    out.flush();

    String response = in.readUTF();
    if (response.equals("FAIL")) {
      throw new Exception(in.readUTF());
    }
    return 1;
  }
}




