package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.domain.Client;

public class ClientDaoImpl implements ClientDao{
  String jdbcUrl;
  String username;
  String password;

  public ClientDaoImpl(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public int insert(Client client) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("insert into frr_client(id, pwd, name, vdt, gen, tel, address)" +
          " values( '" + client.getId() + "', '" + client.getPwd() + "', '" + client.getName() + "', '" + client.getBirthday().toString() + "', '" + client.getSex() + "', '" + client.getTel() + "', '" + client.getAddress() +"')");
      return result;
    }
  }

  @Override
  public List<Client> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client")) {
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
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client where client_no="+ clientNo)) {

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

  @Override
  public Client findById(String id) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select client_no, id, pwd, name, vdt, gen, tel, address, sud from frr_client where id="+ id)) {

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

  @Override
  public int update(Client client) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("update frr_client set id='" + client.getId() + "', pwd='" + client.getPwd() + "', name='"+ client.getName() + "', vdt='"+ client.getBirthday() + "', gen='"+ client.getSex() + "', address='"+ client.getAddress() + "' where client_no=" + client.getClientNo());
      return result;
    }
  }

  @Override
  public int delete(int clientNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("delete from frr_client where client_no=" + clientNo);

      return result;
    }
  }

  @Override
  public List<Client> findByKeyword(String keyword) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select client_no, id, pwd, name, vdt, gen, tel, address, sud"
                + " from frr_client"
                + " where id like '%" + keyword
                + "%' or name like '%" + keyword
                + "%' or tel like '%" + keyword + "%'")) {

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
