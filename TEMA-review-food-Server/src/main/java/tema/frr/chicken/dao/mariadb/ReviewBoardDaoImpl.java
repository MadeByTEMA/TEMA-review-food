package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.sql.DataSource;

public class ReviewBoardDaoImpl implements ReviewBoardDao {

  DataSource dataSource;

  public ReviewBoardDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public int insert(ReviewBoard reviewBoard) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "insert into frr_board(stnm, menu, price, stqul, stquan, revi)" + " values(?, ?, ?, ?, ?, ?)")) {
      stmt.setString(1, reviewBoard.getStoreName());
      stmt.setString(2, reviewBoard.getMenu());
      stmt.setInt(3, reviewBoard.getPrice());
      stmt.setInt(4, reviewBoard.getStarQuality());
      stmt.setInt(5, reviewBoard.getStarQuantity());
      stmt.setString(6, reviewBoard.getReview());
      return stmt.executeUpdate();
    }
  }

  @Override
  public List<ReviewBoard> findAll() throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con
            .prepareStatement("select board_no, cg, stnm, menu, price, stqul, stquan, stprice revi from frr_board");
        ResultSet rs = stmt.executeQuery()) {
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
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "select board_no, cg, stnm, menu, price, stqul, stquan, stprice revi from frr_board where board_no=?")) {
      stmt.setInt(1, boardNo);
      try (ResultSet rs = stmt.executeQuery()) {
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
  }

  @Override
  public int update(ReviewBoard reviewBoard) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "update frr_board set stnm=?, menu=?, price=?, stqul=?, stquan=?, revi=? where board_no=?")) {
      stmt.setString(1, reviewBoard.getStoreName());
      stmt.setString(2, reviewBoard.getMenu());
      stmt.setInt(3, reviewBoard.getPrice());
      stmt.setInt(4, reviewBoard.getStarQuality());
      stmt.setInt(5, reviewBoard.getStarQuantity());
      stmt.setString(6, reviewBoard.getReview());
      stmt.setInt(7, reviewBoard.getBoardNo());

      return stmt.executeUpdate();
    }
  }

  @Override
  public int delete(int boardNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from frr_board where board_no=?")) {
      stmt.setInt(1, boardNo);
      return stmt.executeUpdate();
    }
  }

}
