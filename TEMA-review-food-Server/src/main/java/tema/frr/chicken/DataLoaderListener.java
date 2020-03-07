package tema.frr.chicken;

import java.sql.Connection;
import java.sql.DriverManager;
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
      Class.forName("org.mariadb.jdbc.Driver");
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/frr", "tema", "1111");

      context.put("clientDao", new ClientDaoImpl(con));
      context.put("reviewBoardDao", new ReviewBoardDaoImpl(con));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(con));
      context.put("photoFileDao", new PhotoFileDaoImpl(con));

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

