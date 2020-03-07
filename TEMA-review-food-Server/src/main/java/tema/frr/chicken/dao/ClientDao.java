package tema.frr.chicken.dao;

import java.util.List;

import tema.frr.chicken.domain.Client;

public interface ClientDao {

  public int insert(Client client) throws Exception;

  public List<Client> findAll() throws Exception;

  public Client findByClientNo(int clientNo) throws Exception;

  public Client findById(String id) throws Exception;

  public int update(Client client) throws Exception;

  public int delete(int clientNo) throws Exception;

  default List<Client> findByKeyword(String keyword) throws Exception {
    return null;
  }
}


