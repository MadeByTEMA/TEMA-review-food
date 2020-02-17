package tema.frr.chicken.dao;

import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientObjectFileDao extends AbstractObjectFileDao<Client> {

  public ClientObjectFileDao(String filename) {
    super(filename);
  }

  public int insert(Client client) throws Exception {

    if (indexOf(client.getId()) > -1) { // 같은 번호의 게시물이 있다면,
      return 0;
    }

    list.add(client); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  public List<Client> findAll() throws Exception {
    return list;
  }

  public Client findByNo(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Client client) throws Exception {
    int index = indexOf(client.getId());

    if (index == -1) {
      return 0;
    }

    list.set(index, client); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  public int delete(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData();
    return 1;
  }

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == (String) key) {
        return i;
      }
    }
    return -1;
  }
}

