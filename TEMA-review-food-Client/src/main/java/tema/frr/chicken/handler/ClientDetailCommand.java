package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientDetailCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public ClientDetailCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      out.writeUTF("/client/detail");
      out.writeUTF((prompt.inputString("ID? ")));
      out.flush();


      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      Client client = (Client) in.readObject();

      System.out.printf("이름 : %s\n", client.getName());
      System.out.printf("생일 : %s\n", client.getBirthday());
      System.out.printf("성별 : %s\n", client.getSex());
      System.out.printf("전화번호 : %s\n", client.getTel());
      System.out.printf("주소 : %s\n", client.getAddress());
      System.out.printf("가입일 : %s\n", client.getSignUpDate());
    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
