package tema.frr.chicken.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import tema.frr.chicken.domain.Client;

public class ClientObjectFileDao {

  String filename;
  List<Client> list;


  public ClientObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings("unchecked")
  void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      list = (List<Client>) in.readObject();

      System.out.printf("총 %d 개의 고객 데이터를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset();
      out.writeObject(list);

      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  public int insert(Client client) throws Exception {

    if (indexOf(client.getId()) > -1) { // 같은 번호의 게시물이 있다면,
      return 0;
    }

    list.add(client); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  public List<Client> findAll() throws Exception {
    return list;
  }

  public Client findByNo(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(Client client) throws Exception {
    int index = indexOf(client.getId());

    if (index == -1) {
      return 0;
    }

    list.set(index, client); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  public int delete(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData();
    return 1;
  }

  private int indexOf(String id) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getId() == id) {
        return i;
      }
    }
    return -1;
  }
}


