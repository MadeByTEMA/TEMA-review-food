package tema.frr.chicken.handler;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.util.Prompt;

public class ClientDeleteCommand implements Command {

  ClientDao clientDao;
  Prompt prompt;

  public ClientDeleteCommand(ClientDao clientDao, Prompt prompt) {
    this.clientDao = clientDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      int clientNo = prompt.inputInt("번호? ");
      clientDao.delete(clientNo);
      System.out.println("고객 정보를 삭제했습니다.");

    } catch (Exception e) {
      System.out.println("삭제 실패!");
    }
  }
}
