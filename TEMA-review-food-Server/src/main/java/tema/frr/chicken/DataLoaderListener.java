package tema.frr.chicken;

import java.util.Map;

import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.mariadb.ClientDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoBoardDaoImpl;
import tema.frr.chicken.dao.mariadb.PhotoFileDaoImpl;
import tema.frr.chicken.dao.mariadb.ReviewBoardDaoImpl;
import tema.frr.sql.DataSource;
import tema.frr.sql.PlatformTransactionManager;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    try {
      String jdbcUrl = "jdbc:mariadb://localhost:3306/studydb";
      String username = "study";
      String password = "1111";

      DataSource dataSource = new DataSource(//
          jdbcUrl, username, password);
      context.put("connectionFactory", dataSource);

      context.put("clientDao", new ClientDaoImpl(dataSource));
      context.put("reviewBoardDao", new ReviewBoardDaoImpl(dataSource));
      context.put("photoBoardDao", new PhotoBoardDaoImpl(dataSource));
      context.put("photoFileDao", new PhotoFileDaoImpl(dataSource));

      PlatformTransactionManager txManager = new PlatformTransactionManager(dataSource);
      context.put("transactionManager", txManager);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    DataSource dataSource = (DataSource) context.get("dataSource");
    dataSource.clean();
  }
}
