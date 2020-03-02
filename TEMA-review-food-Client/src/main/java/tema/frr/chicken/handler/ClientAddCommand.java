package tema.frr.chicken.handler;

import java.sql.Date;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientAddCommand implements Command {

  ClientDaoProxy clientDao;
  Prompt prompt;

  public ClientAddCommand(ClientDaoProxy clientDao, Prompt prompt) {
    this.clientDao = clientDao;
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
      clientDao.insert(c);
      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      System.out.println("저장 실패!");
    }
  }
}
