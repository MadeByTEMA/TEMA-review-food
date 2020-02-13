package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewUpdateCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public WritingReviewUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
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

      WritingReview oldWritingReview = (WritingReview) in.readObject();
      WritingReview newWritingReview = new WritingReview();

      newWritingReview.setCategory(oldWritingReview.getCategory());
      newWritingReview.setStoreName(oldWritingReview.getStoreName());

      newWritingReview.setMenu(prompt.inputString(
          String.format("메뉴(%s) \n", oldWritingReview.getMenu()), oldWritingReview.getMenu()));

      newWritingReview.setPrice(prompt.inputInt(
          String.format("가격(%s) \n", oldWritingReview.getPrice()), oldWritingReview.getPrice()));

      newWritingReview.setStarQuality(
          prompt.inputInt(String.format("맛 별점(%s) \n", oldWritingReview.getStarQuality()),
              oldWritingReview.getStarQuality()));

      newWritingReview.setStarQuantity(
          prompt.inputInt(String.format("양 별점(%s) \n", oldWritingReview.getStarQuantity()),
              oldWritingReview.getStarQuantity()));

      newWritingReview.setReview(prompt.inputString(
          String.format("후기(%s) \n", oldWritingReview.getReview()), oldWritingReview.getReview()));

      if (newWritingReview.equals(oldWritingReview)) {
        System.out.println(" 후기 변경을 취소하였습니다.");
        return;
      }
      out.writeUTF("/writingReview/update");
      out.writeObject(newWritingReview);
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("후기를 변경하였습니다.");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
