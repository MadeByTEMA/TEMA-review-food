package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;
import tema.frr.sql.DataSource;

public class ClientDaoImpl implements ClientDao{
  DataSource dataSource;

  public ClientDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public int insert(Client client) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into frr_client(id, pwd, name, vdt, gen, tel, address)" +
            " values(?, ?, ?, ?, ?, ?, ?)")) {
      stmt.setString(1, client.getId());
      stmt.setString(2, client.getPwd());
      stmt.setString(3, client.getName());
      stmt.setDate(4, client.getBirthday());
      stmt.setString(5, client.getSex());
      stmt.setString(6, client.getTel());
      stmt.setString(7, client.getAddress());
      return stmt.executeUpdate();
    }
  }

  @Override
  public List<Client> findAll() throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client");
        ResultSet rs = stmt.executeQuery()) {
      ArrayList<Client> list = new ArrayList<>();

      while (rs.next()) {
        Client c = new Client();
        c.setClientNo(rs.getInt("client_no"));
        c.setId(rs.getString("id"));
        c.setPwd(rs.getString("pwd"));
        c.setName(rs.getString("name"));
        c.setBirthday(rs.getDate("vdt"));
        c.setSex(rs.getString("gen"));
        c.setTel(rs.getString("tel"));
        c.setAddress(rs.getString("address"));
        c.setSignUpDate(rs.getDate("sud"));

        list.add(c);
      }
      return list;
    }
  }

  @Override
  public Client findByClientNo(int clientNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client where client_no=?");
        ) {
      stmt.setInt(1, clientNo);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Client c = new Client();
          c.setClientNo(rs.getInt("client_no"));
          c.setId(rs.getString("id"));
          c.setPwd(rs.getString("pwd"));
          c.setName(rs.getString("name"));
          c.setBirthday(rs.getDate("vdt"));
          c.setSex(rs.getString("gen"));
          c.setTel(rs.getString("tel"));
          c.setAddress(rs.getString("address"));
          c.setSignUpDate(rs.getDate("sud"));
          return c;

        } else {
          return null;
        }
      }
    }
  }

  @Override
  public Client findById(String id) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client where id=")) {
      stmt.setString(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Client c = new Client();
          c.setClientNo(rs.getInt("client_no"));
          c.setId(rs.getString("id"));
          c.setPwd(rs.getString("pwd"));
          c.setName(rs.getString("name"));
          c.setBirthday(rs.getDate("vdt"));
          c.setSex(rs.getString("gen"));
          c.setTel(rs.getString("tel"));
          c.setAddress(rs.getString("address"));
          c.setSignUpDate(rs.getDate("sud"));
          return c;

        } else {
          return null;
        }
      }
    }
  }

  @Override
  public int update(Client client) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("update frr_client set id=?, pwd=password(?), name=?, vdt=?, gen=?, tel=? address=? where client_no=?")) {
      stmt.setString(1, client.getId());
      stmt.setString(2, client.getPwd());
      stmt.setString(3, client.getName());
      stmt.setDate(4, client.getBirthday());
      stmt.setString(5, client.getSex());
      stmt.setString(6, client.getTel());
      stmt.setString(7, client.getAddress());
      stmt.setInt(8, client.getClientNo());
      return stmt.executeUpdate();
    }
  }

  @Override
  public int delete(int clientNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from frr_client where client_no=?")) {
      stmt.setInt(1, clientNo);
      return stmt.executeUpdate();
    }
  }

  @Override
  public List<Client> findByKeyword(String keyword) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select client_no, id, pwd, name, vdt, gen, tel, address, sud"
            + " from frr_client"
            + " where id like ?"
            + "%' or name like ?"
            + "%' or tel like ?")) {

      String value = "%" + keyword + "%";
      stmt.setString(1, value);
      stmt.setString(2, value);
      stmt.setString(3, value);

      try (ResultSet rs = stmt.executeQuery()) {
        ArrayList<Client> list = new ArrayList<>();
        while (rs.next()) {
          Client c = new Client();
          c.setClientNo(rs.getInt("client_no"));
          c.setId(rs.getString("id"));
          c.setPwd(rs.getString("pwd"));
          c.setName(rs.getString("name"));
          c.setBirthday(rs.getDate("vdt"));
          c.setSex(rs.getString("gen"));
          c.setTel(rs.getString("tel"));
          c.setAddress(rs.getString("address"));
          c.setSignUpDate(rs.getDate("sud"));

          list.add(c);
        }

        return list;
      }
    }
  }

  @Override
  public Client findByIdAndPassword(String id, String password) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select client_no, id, pwd, name, vdt, gen, tel, address, sud"
            + " from frr_client"
            + " where id=?"
            + " and pwd=password(?)")) {

      stmt.setString(1, id);
      stmt.setString(2, password);


      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Client c = new Client();
          c.setClientNo(rs.getInt("client_no"));
          c.setId(rs.getString("id"));
          c.setPwd(rs.getString("pwd"));
          c.setName(rs.getString("name"));
          c.setBirthday(rs.getDate("vdt"));
          c.setSex(rs.getString("gen"));
          c.setTel(rs.getString("tel"));
          c.setAddress(rs.getString("address"));
          c.setSignUpDate(rs.getDate("sud"));
          return c;

        } else {
          return null;
        }
      }
    }
  }
}
