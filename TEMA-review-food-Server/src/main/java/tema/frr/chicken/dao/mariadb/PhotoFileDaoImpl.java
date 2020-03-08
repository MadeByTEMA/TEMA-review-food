package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.PhotoFileDao;
import tema.frr.chicken.domain.PhotoFile;
import tema.frr.util.ConnectionFactory;

public class PhotoFileDaoImpl implements PhotoFileDao {

  ConnectionFactory conFactory;

  public PhotoFileDaoImpl(ConnectionFactory conFactory) {
    this.conFactory = conFactory;
  }

  @Override
  public int insert(PhotoFile photoFile) throws Exception {
    try (Connection con = conFactory.getConnection();
        Statement stmt = con.createStatement()) {

      int result = stmt.executeUpdate(
          "insert into frr_photo_file(photo_no,file_path) values("
              + photoFile.getBoardNo() + ", '" + photoFile.getFilepath()
              + "')");

      return result;
    }
  }

  @Override
  public List<PhotoFile> findAll(int boardNo) throws Exception {
    try (Connection con = conFactory.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select photo_file_no, photo_no, file_path"
                + " from frr_photo_file"
                + " where photo_no=" + boardNo
                + " order by photo_file_no asc")) {

      ArrayList<PhotoFile> list = new ArrayList<>();
      while (rs.next()) {
        list.add(new PhotoFile()
            .setNo(rs.getInt("photo_file_no"))
            .setFilepath(rs.getString("file_path"))
            .setBoardNo(rs.getInt("photo_no")));
      }
      return list;
    }
  }

  @Override
  public int deleteAll(int boardNo) throws Exception {
    try (Connection con = conFactory.getConnection();
        Statement stmt = con.createStatement()) {
      int result = stmt.executeUpdate(
          "delete from frr_photo_file"
              + " where photo_no=" + boardNo);
      return result;
    }
  }

}