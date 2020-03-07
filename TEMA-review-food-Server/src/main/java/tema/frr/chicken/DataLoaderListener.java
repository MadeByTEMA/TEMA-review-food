package tema.frr.chicken;

import java.sql.Connection;
import java.util.Map;

import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.mariadb.ClientDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl;
import tema.frr.chicken.dao.mariadb.ReviewBoardDaoImpl;

public class DataLoaderListener implements ApplicationContextListener {

  public static Connection con;


  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      context.put("clientDao", new ClientDaoImpl(jdbcUrl, username, password));
      context.put("reviewBoardDao", new ReviewBoardDaoImpl(jdbcUrl, username, password));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(jdbcUrl, username, password));
      context.put("photoFileDao", new PhotoFileDaoImpl(jdbcUrl, username, password));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    try {
      con.close();
    } catch (Exception e) {
    }
  }
}

