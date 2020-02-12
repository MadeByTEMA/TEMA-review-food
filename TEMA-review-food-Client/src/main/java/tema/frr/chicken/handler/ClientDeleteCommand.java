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
    out.writeInt(prompt.inputInt("ID? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    } else {
      this.clientList.remove(index);
      System.out.println("고객을 삭제했습니다.");
    }
  }
}
