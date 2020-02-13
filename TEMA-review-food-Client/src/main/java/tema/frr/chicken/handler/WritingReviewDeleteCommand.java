package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.util.Prompt;

public class WritingReviewDeleteCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public WritingReviewDeleteCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      out.writeUTF("/writingReview/delete");
      out.writeUTF(prompt.inputString("가게명? "));
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("후기를 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
