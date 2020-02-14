package tema.frr.chicken.servlet;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDeleteServlet implements Servlet {

  List<WritingReview> writingReviews;

  public WritingReviewDeleteServlet(List<WritingReview> writingReviews) {
    this.writingReviews = writingReviews;
  }

  @Override
  public void service(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    try {
      String storeName = in.readUTF();

      int index = -1;
      for (int i = 0; i < writingReviews.size(); i++) {
        if (writingReviews.get(i).getStoreName() == storeName) {
          index = i;
          break;
        }
      }

      if (index != -1) { // 삭제하려는 번호의 게시물을 찾았다면
        writingReviews.remove(index);
        out.writeUTF("OK");

      } else {
        out.writeUTF("FAIL");
        out.writeUTF("해당 후기가 없습니다.");
      }
    } catch (Exception e) {
      out.writeUTF("FAIL");
      out.writeUTF(e.getMessage());
    }
  }
}
