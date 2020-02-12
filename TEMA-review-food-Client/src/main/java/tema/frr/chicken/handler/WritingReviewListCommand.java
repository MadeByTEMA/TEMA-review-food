package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewListCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;

  public WritingReviewListCommand(ObjectOutputStream out, ObjectInputStream in) {
    this.out = out;
    this.in = in;
  }

  @Override
  public void execute() {

    try {
      out.writeUTF("/client/list");
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      } else {
        List<WritingReview> writingReviews = (List<WritingReview>) in.readObject();

        for (WritingReview r : writingReviews) {
          System.out.printf("%s, %s, %s, %s, %s, %s\n", r.getStoreName(), r.getMenu(), r.getPrice(),
              r.getStarQuality(), r.getStarQuantity(), r.getStarTotalSum());
        }
      }
    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }
  }
}
