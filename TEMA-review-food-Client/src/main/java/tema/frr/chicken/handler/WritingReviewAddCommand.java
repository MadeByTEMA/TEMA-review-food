package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.util.Prompt;

public class WritingReviewAddCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public WritingReviewAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    WritingReview r = new WritingReview();

    r.setStoreName(prompt.inputString("가게명을 입력해주세요. "));
    r.setMenu(prompt.inputString("메뉴을 입력해주세요. "));
    r.setPrice(prompt.inputInt("가격을 입력해주세요. "));
    r.setStarQuality(prompt.inputInt("맛 별점을 입력해주세요. "));
    r.setStarQuantity(prompt.inputInt("양 별점을 입력해주세요. "));
    r.setReview(prompt.inputString("후기를 입력해주세요. "));

    try {
      out.writeUTF("/writingReview/add");
      out.writeObject(r);
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      } else {
        System.out.println("저장하였습니다.");
      }

    } catch (Exception e) {
      System.out.println("통신 오류 발생!");
    }


    System.out.println("저장하였습니다.");
  }
}
