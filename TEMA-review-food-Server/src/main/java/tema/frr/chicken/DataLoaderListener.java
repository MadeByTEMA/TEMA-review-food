package tema.frr.chicken;

import java.util.Map;
import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.ClientObjectFileDao;
import tema.frr.chicken.dao.WritingReviewObjectFileDao;

public class DataLoaderListener implements ApplicationContextListener {


  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    ClientObjectFileDao clientDao = new ClientObjectFileDao("./client.csv");
    WritingReviewObjectFileDao writingReviewDao =
        new WritingReviewObjectFileDao("./writingReview.csv");

    context.put("clientList", clientDao);
    context.put("writingReviewList", writingReviewDao);
  }

  @Override
  public void contextDestroyed(Map<String, Object> context) {}
}

