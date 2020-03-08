package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.ReviewBoard;
import tema.frr.sql.DataSource;

public class PhotoBoardDaoImpl implements PhotoBoardDao {

  DataSource dataSource;

  public PhotoBoardDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public int insert(PhotoBoard photoBoard) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into frr_photo(titl,board_no) values(?,?)", Statement.RETURN_GENERATED_KEYS)) {

      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getReviewBoard().getBoardNo());

      int result = stmt.executeUpdate();
      try (ResultSet generatedKeySet = stmt.getGeneratedKeys()) {
        generatedKeySet.next();
        photoBoard.setNo(generatedKeySet.getInt(1));
      }
      return result;
    }
  }

  @Override
  public List<PhotoBoard> findAllByBoardNo(int boardNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "select photo_no, titl, cdt, vw_cnt, board_no"
                + " from frr_photo"
                + " where board_no=?"
                + " order by photo_no desc")) {
      stmt.setInt(1, boardNo);

      try (ResultSet rs = stmt.executeQuery()) {
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
  }

  @Override
  public PhotoBoard findByNo(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "select"
                + " p.photo_no,"
                + " p.titl,"
                + " p.cdt,"
                + " p.vw_cnt,"
                + " b.board_no,"
                + " b.revi board_review"
                + " from frr_photo p"
                + " inner join frr_board b on p.board_no=b.board_no"
                + " where photo_no=?")) {
      stmt.setInt(1, no);
      try (ResultSet rs = stmt.executeQuery()) {
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
  }

  @Override
  public int update(PhotoBoard photoBoard) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "update frr_photo set titl=? where photo_no=?")) {
      stmt.setString(1, photoBoard.getTitle());
      stmt.setInt(2, photoBoard.getNo());
      return stmt.executeUpdate();
    }
  }

  @Override
  public int delete(int no) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "delete from frr_photo"
                + " where photo_no=?")) {
      stmt.setInt(1, no);
      return stmt.executeUpdate();
    }
  }
}
