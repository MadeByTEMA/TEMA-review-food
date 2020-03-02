package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientDetailCommand implements Command {

  ClientDaoProxy clientDao;
  Prompt prompt;

  public ClientDetailCommand(ClientDaoProxy clientDao, Prompt prompt) {
    this.clientDao = clientDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String id = prompt.inputString("ID? ");

      Client client = clientDao.findById(id);

      System.out.printf("이름 : %s\n", client.getName());
      System.out.printf("생일 : %s\n", client.getBirthday());
      System.out.printf("성별 : %s\n", client.getSex());
      System.out.printf("전화번호 : %s\n", client.getTel());
      System.out.printf("주소 : %s\n", client.getAddress());
      System.out.printf("가입일 : %s\n", client.getSignUpDate());

    } catch (Exception e) {
      System.out.println("조회 실패!");
    }
  }
}
