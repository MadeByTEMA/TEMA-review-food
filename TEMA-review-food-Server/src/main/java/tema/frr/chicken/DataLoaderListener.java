package tema.frr.chicken;

import java.util.Map;

import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.json.ClientJsonFileDao;
import tema.frr.chicken.dao.json.ReviewBoardJsonFileDao;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    context.put("clientDao", new ClientJsonFileDao("./client.json"));
    context.put("ReviewBoardDao", new ReviewBoardJsonFileDao("./ReviewBoard.json"));
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}
}

