package tema.frr.chicken;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.domain.WritingReview;

public class DataLoaderListener implements ApplicationContextListener {

  LinkedList<Client> clientList = new LinkedList<>();
  ArrayList<WritingReview> writingReviewList = new ArrayList<>();

  @Override
  public void contextDestroyed(Map<String, Object> context) {
    System.out.println("데이터를 로딩합니다.");

    loadClientData();
    loadWritingReviewData();

    context.put("clientList", clientList);
    context.put("writingReviewList", writingReviewList);
  }

  @Override
  public void contextInitialized(Map<String, Object> context) {
    System.out.println("데이터를 저장합니다.");

    saveClientData();
    saveWritingReviewData();
  }

  void loadClientData() {
    File file = new File("./client.data");

    try (ObjectInputStream in =
        new ObjectInputStream(new DataInputStream(new FileInputStream(file)))) {

      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        Client client = new Client();
        client.setId(in.readUTF());
        client.setPwd(in.readUTF());
        client.setName(in.readUTF());
        client.setBirthday(Date.valueOf(in.readUTF()));
        client.setSex(in.readUTF());
        client.setTel(in.readUTF());
        client.setAddress(in.readUTF());
        client.setSignUpDate(Date.valueOf(in.readUTF()));

        clientList.add(client);
      }

      System.out.printf("총 %d 개의 회원 데이터를 로딩했습니다.\n", clientList.size());
    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  void saveClientData() {
    File file = new File("client.data");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new DataOutputStream(new FileOutputStream(file)))) {
      out.writeInt(clientList.size());

      for (Client client : clientList) {
        out.writeUTF(client.getId());
        out.writeUTF(client.getPwd());
        out.writeUTF(client.getName());
        out.writeUTF(client.getBirthday().toString());
        out.writeUTF(client.getSex());
        out.writeUTF(client.getTel());
        out.writeUTF(client.getAddress());
        out.writeUTF(client.getSignUpDate().toString());
      }

      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", clientList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  void loadWritingReviewData() {
    File file = new File("./writingReview.json");


    try (ObjectInputStream in =
        new ObjectInputStream(new DataInputStream(new FileInputStream(file)))) {

      int size = in.readInt();
      for (int i = 0; i < size; i++) {
        WritingReview writingReview = new WritingReview();

        writingReview.setCategory(in.readUTF());
        writingReview.setStoreName(in.readUTF());
        writingReview.setMenu(in.readUTF());
        writingReview.setPrice(in.readInt());
        writingReview.setStarQuality(in.readInt());
        writingReview.setStarQuantity(in.readInt());
        writingReview.setStarPrice(in.readInt());
        writingReview.setReview(in.readUTF());
        writingReviewList.add(writingReview);
      }

      System.out.printf("총 %d 개의 후기 데이터를 로딩했습니다.\n", writingReviewList.size());

    } catch (IOException e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  void saveWritingReviewData() {
    File file = new File("./writingReview.json");

    try (ObjectOutputStream out =
        new ObjectOutputStream(new DataOutputStream(new FileOutputStream(file)))) {
      out.writeInt(writingReviewList.size());

      for (WritingReview writingReview : writingReviewList) {
        out.writeUTF(writingReview.getCategory());
        out.writeUTF(writingReview.getStoreName());
        out.writeUTF(writingReview.getMenu());
        out.writeInt(writingReview.getPrice());
        out.writeInt(writingReview.getStarQuality());
        out.writeInt(writingReview.getStarQuantity());
        out.writeInt(writingReview.getStarPrice());
        out.writeInt(writingReview.getStarTotalSum());
        out.writeUTF(writingReview.getReview());
      }

      System.out.printf("총 %d 개의 후기 데이터를 저장했습니다.\n", writingReviewList.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }
}
