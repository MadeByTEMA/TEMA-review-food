package tema.frr.chicken.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientAddCommand implements Command {

  ObjectOutputStream out;
  ObjectInputStream in;
  Prompt prompt;

  public ClientAddCommand(ObjectOutputStream out, ObjectInputStream in, Prompt prompt) {
    this.out = out;
    this.in = in;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    Client c = new Client();

    c.setId(prompt.inputString("ID를 입력해주세요. "));
    c.setPwd(prompt.inputString("Pwd를 입력해주세요. "));
    c.setName(prompt.inputString("이름을 입력해주세요. "));
    c.setBirthday(prompt.inputDate("생년월일을 입력해주세요. "));
    c.setSex(prompt.inputString("성별을 입력해주세요. "));
    c.setTel(prompt.inputString("전화번호를 입력해주세요. "));
    c.setAddress(prompt.inputString("주소를 입력해주세요. "));
    c.setSignUpDate(new Date(System.currentTimeMillis()));

    try {
      out.writeUTF("/client/add");
      out.writeObject(c);
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
