package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewDetailCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public WritingReviewDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      out.writeUTF("/writingReview/detail");
      out.writeUTF((prompt.inputString("ID? ")));
      out.flush();


      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      WritingReview writingReview = (WritingReview) in.readObject();

      System.out.printf("메뉴 : %s\n", writingReview.getMenu());
      System.out.printf("가격 : %s\n", writingReview.getPrice());
      System.out.printf("총 별점 : %s\n", writingReview.getStarTotalSum());
      System.out.printf("맛 별점:  %s\n", writingReview.getStarQuality());
      System.out.printf("양 별점 : %s\n", writingReview.getStarQuantity());
      System.out.printf("후기 : %s\n", writingReview.getReview());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
