package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.util.Prompt;

public class ClientDeleteCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public ClientDeleteCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      out.writeUTF("/client/delete");
      out.writeUTF(prompt.inputString("ID? "));
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }
      System.out.println("고객을 삭제했습니다.");
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
