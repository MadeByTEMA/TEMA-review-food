package tema.frr.chicken.handler;

import java.sql.Date;
import java.util.List;
import tema.frr.chicken.domain.Client;
import tema.frr.util.Prompt;

public class ClientAddCommand implements Command {

  List<Client> clientList;

  Prompt prompt;

  public ClientAddCommand(Prompt prompt, List<Client> list) {
    this.prompt = prompt;
    clientList = list;
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

    clientList.add(c);

    System.out.println("저장하였습니다.");
  }
}
