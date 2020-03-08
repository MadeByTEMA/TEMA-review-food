package tema.frr.chicken;

import java.util.Map;

import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.mariadb.ClientDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl;
import tema.frr.chicken.dao.mariadb.ReviewBoardDaoImpl;
import tema.frr.util.ConnectionFactory;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      ConnectionFactory conFactory = new ConnectionFactory(//
          jdbcUrl, username, password);

      context.put("clientDao", new ClientDaoImpl(conFactory));
      context.put("reviewBoardDao", new ReviewBoardDaoImpl(conFactory));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(conFactory));
      context.put("photoFileDao", new PhotoFileDaoImpl(conFactory));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
  }
}
