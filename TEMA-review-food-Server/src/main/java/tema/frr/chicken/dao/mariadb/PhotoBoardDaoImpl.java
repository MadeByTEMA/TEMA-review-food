package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.ReviewBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  String jdbcUrl;
  String username;
  String password;

  public PhotoBoardDaoImpl(String jdbcUrl, String username, String password) {
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate(
          "insert into frr_photo(titl,board_no) values('"
              + photoBoard.getTitle() + "', " + photoBoard.getReviewBoard().getBoardNo()
              + ")",
              Statement.RETURN_GENERATED_KEYS);

      try (ResultSet generatedKeySet = stmt.getGeneratedKeys()) {
        generatedKeySet.next();

        photoBoard.setNo(generatedKeySet.getInt(1));
      }
      return result;
    }
  }

  @Override
  public List<PhotoBoard> findAllByBoardNo(int boardNo) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select photo_no, titl, cdt, vw_cnt, board_no"
                + " from frr_photo"
                + " where board_no=" + boardNo
                + " order by photo_no desc")) {

      ArrayList<PhotoBoard> list = new ArrayList<>();

      while (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_no"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        list.add(photoBoard);
      }

      return list;
    }
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select"
                + " p.photo_no,"
                + " p.titl,"
                + " p.cdt,"
                + " p.vw_cnt,"
                + " b.board_no,"
                + " b.revi board_review"
                + " from frr_photo p"
                + " inner join frr_board b on p.board_no=b.board_no"
                + " where photo_no=" + no)) {

      if (rs.next()) {
        PhotoBoard photoBoard = new PhotoBoard();
        photoBoard.setNo(rs.getInt("photo_no"));
        photoBoard.setTitle(rs.getString("titl"));
        photoBoard.setCreatedDate(rs.getDate("cdt"));
        photoBoard.setViewCount(rs.getInt("vw_cnt"));

        ReviewBoard reviewBoard = new ReviewBoard();
        reviewBoard.setBoardNo(rs.getInt("board_no"));
        reviewBoard.setReview(rs.getString("board_review"));

        photoBoard.setReviewBoard(reviewBoard);

        return photoBoard;

      } else {
        return null;
      }
    }
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate(
          "update frr_photo set titl='"
              + photoBoard.getTitle()
              + "' where photo_no=" + photoBoard.getNo());
      return result;
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = DriverManager.getConnection(jdbcUrl, username, password);
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate(
          "delete from frr_photo"
              + " where photo_no=" + no);
      return result;
    }
  }

}
