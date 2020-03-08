package tema.frr.chicken.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tema.frr.chicken.dao.PhotoFileDao;
import tema.frr.chicken.domain.PhotoFile;
import tema.frr.sql.DataSource;

public class PhotoFileDaoImpl implements PhotoFileDao {

  DataSource dataSource;

  public PhotoFileDaoImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public int insert(PhotoFile photoFile) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("insert into frr_photo_file(photo_no,file_path) values(?,?)")) {

      stmt.setInt(1, photoFile.getBoardNo());
      stmt.setString(2, photoFile.getFilepath());
      return stmt.executeUpdate();
    }
  }

  @Override
  public List<PhotoFile> findAll(int boardNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("select photo_file_no, photo_no, file_path from frr_photo_file where photo_no=? order by photo_file_no asc")) {
      stmt.setInt(1, boardNo);
      try (ResultSet rs = stmt.executeQuery()) {
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
  }

  @Override
  public int deleteAll(int boardNo) throws Exception {
    try (Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement("delete from frr_photo_file"
            + " where photo_no=?")) {
      stmt.setInt(1, boardNo);
      return stmt.executeUpdate();
    }
  }

}
