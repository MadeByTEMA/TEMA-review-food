package tema.frr.chicken.handler;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.util.Prompt;

public class ClientUpdateCommand implements Command {

  ClientDaoProxy clientDao;
  Prompt prompt;

  public ClientUpdateCommand(ClientDaoProxy clientDao, Prompt prompt) {
    this.clientDao = clientDao;
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    try {
      String id = prompt.inputString("ID? ");

      Client oldClient = null;
      try {
        oldClient = clientDao.findById(id);
      } catch (Exception e) {
        System.out.println("해당 ID의 회원이 없습니다!");
        return;
      }

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

      clientDao.update(newClient);
      System.out.println("고객을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 실패!");
    }
  }
}
