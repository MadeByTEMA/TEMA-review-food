package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.util.Prompt;

public class ClientDeleteCommand implements Command {

  ClientDaoProxy clientDao;
  Prompt prompt;

  public ClientDeleteCommand(ClientDaoProxy clientDao, Prompt prompt) {
    this.clientDao = clientDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String id = prompt.inputString("ID? ");
      clientDao.delete(id);
      System.out.println("고객 정보를 삭제했습니다.");

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
