package tema.frr.chicken.dao.json;

import java.util.List;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientJsonFileDao extends AbstractJsonFileDao<Client> implements ClientDao{

  public ClientJsonFileDao(String filename) {
    super(filename);
  }

  @Override
  public int insert(Client client) throws Exception {

    if (indexOf(client.getId()) > -1) { // 같은 번호의 게시물이 있다면,
      return 0;
    }

    list.add(client); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  @Override
  public List<Client> findAll() throws Exception {
    return list;
  }

  @Override
  public Client findById(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public Client findByClientNo(int clientNo) throws Exception {
    int index = indexOf(clientNo);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  @Override
  public int update(Client client) throws Exception {
    int index = indexOf(client.getId());

    if (index == -1) {
      return 0;
    }

    list.set(index, client); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  @Override
  public int delete(int clientNo) throws Exception {
    int index = indexOf(clientNo);
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


