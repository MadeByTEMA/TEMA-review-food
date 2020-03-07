package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardDaoImpl implements ReviewBoardDao{

  String jdbcUrl;
  String username;
  String password;

  public ReviewBoardDaoImpl(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public int insert(ReviewBoard reviewBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("insert into frr_board(stnm, menu, price, stqul, stquan, revi)" +
          " values( '" + reviewBoard.getStoreName() + "', '" + reviewBoard.getMenu() + "', '" + reviewBoard.getPrice() + "', '" + reviewBoard.getStarQuality() + "', '" + reviewBoard.getStarQuantity() + "', '" + reviewBoard.getReview() +"')");
      return result;
    }
  }

  @Override
  public List<ReviewBoard> findAll() throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select board_no, cg, stnm, menu, price, stqul, stquan, stprice revi from frr_board")) {
      ArrayList<ReviewBoard> list = new ArrayList<>();

      while (rs.next()) {
        ReviewBoard r = new ReviewBoard();
        r.setBoardNo(rs.getInt("board_no"));
        r.setCategory(rs.getString("cg"));
        r.setStoreName(rs.getString("stnm"));
        r.setMenu(rs.getString("stnm"));
        r.setPrice(rs.getInt("price"));
        r.setStarQuality(rs.getInt("stqul"));
        r.setStarQuantity(rs.getInt("stquan"));
        r.setPrice(rs.getInt("stprice"));
        r.setReview(rs.getString("revi"));

        list.add(r);
      }
      return list;
    }
  }

  @Override
  public ReviewBoard findByBoardNo(int boardNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select board_no, cg, stnm, menu, price, stqul, stquan, stprice revi from frr_board where board_no=" + boardNo)) {

      if (rs.next()) {
        ReviewBoard r = new ReviewBoard();
        r.setBoardNo(rs.getInt("board_no"));
        r.setCategory(rs.getString("cg"));
        r.setStoreName(rs.getString("stnm"));
        r.setMenu(rs.getString("stnm"));
        r.setPrice(rs.getInt("price"));
        r.setStarQuality(rs.getInt("stqul"));
        r.setStarQuantity(rs.getInt("stquan"));
        r.setPrice(rs.getInt("stprice"));
        r.setReview(rs.getString("revi"));
        return r;

      } else {
        return null;
      }
    }
  }

  @Override
  public int update(ReviewBoard reviewBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate("update frr_board set stnm='" + reviewBoard.getStoreName() + "', menu='" + reviewBoard.getMenu() + "', price='"+ reviewBoard.getPrice() + "', stqul='"+ reviewBoard.getStarQuality() + "', stquan='"+ reviewBoard.getStarQuantity() + "', revi='"+ reviewBoard.getReview() + "' where board_no=" + reviewBoard.getBoardNo());
      return result;
    }
  }

  @Override
  public int delete(int boardNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate("delete from frr_board where board_no=" + boardNo);

      return result;
    }
  }

}
