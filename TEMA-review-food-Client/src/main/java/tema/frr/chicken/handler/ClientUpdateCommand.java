package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientUpdateCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public ClientUpdateCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
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

      Client oldClient = (Client) in.readObject();
      Client newClient = new Client();

      newClient.setId(oldClient.getId());

      newClient.setName(prompt.inputString(String.format("이름(%s): \n", oldClient.getName()),
          oldClient.getName()));

      newClient.setBirthday(prompt.inputDate(String.format("생일(%s): \n", oldClient.getBirthday()),
          oldClient.getBirthday()));

      newClient.setSex(
          prompt.inputString(String.format("성별(%s): \n", oldClient.getSex()), oldClient.getSex()));

      newClient.setTel(prompt.inputString(String.format("전화번호(%s): \n", oldClient.getTel()),
          oldClient.getTel()));

      newClient.setAddress(prompt.inputString(String.format("주소(%s): \n", oldClient.getAddress()),
          oldClient.getAddress()));

      if (newClient.equals(oldClient)) {
        System.out.println("고객 변경을 취소했습니다.");
        return;
      }

      newClient.setSignUpDate(oldClient.getSignUpDate());

      out.writeUTF("/client/update");
      out.writeObject(newClient);
      out.flush();

      if (in.readUTF().toString().equals("FAIL")) {
        System.out.println(in.readUTF());
        return;
      }

      System.out.println("고객을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("명령 실행 중 오류 발생!");
    }
  }
}
