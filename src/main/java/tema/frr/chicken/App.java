// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
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
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.handler.ClientAddCommand;
import tema.frr.chicken.handler.ClientDeleteCommand;
import tema.frr.chicken.handler.ClientDetailCommand;
import tema.frr.chicken.handler.ClientListCommand;
import tema.frr.chicken.handler.ClientUpdateCommand;
import tema.frr.chicken.handler.Command;
import tema.frr.chicken.handler.WritingReviewAddCommand;
import tema.frr.chicken.handler.WritingReviewDeleteCommand;
import tema.frr.chicken.handler.WritingReviewDetailCommand;
import tema.frr.chicken.handler.WritingReviewListCommand;
import tema.frr.chicken.handler.WritingReviewUpdateCommand;
import tema.frr.util.Prompt;

public class App {

  Scanner keyboard = new Scanner(System.in);

  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();

  Set<ApplicationContextListener> listeners = new HashSet<>();

  LinkedList<Client> clientList = new LinkedList<>();
  ArrayList<WritingReview> writingReviewList = new ArrayList<>();

  public void service() {

    loadClientData();
    loadWritingReviewData();

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/client/add", new ClientAddCommand(prompt, clientList));
    commandMap.put("/client/list", new ClientListCommand(clientList));
    commandMap.put("/client/detail", new ClientDetailCommand(prompt, clientList));
    commandMap.put("/client/delete", new ClientDeleteCommand(prompt, clientList));
    commandMap.put("/client/update", new ClientUpdateCommand(prompt, clientList));

    commandMap.put("/writingReview/add", new WritingReviewAddCommand(prompt, writingReviewList));
    commandMap.put("/writingReview/list", new WritingReviewListCommand(writingReviewList));
    commandMap.put("/writingReview/detail",
        new WritingReviewDetailCommand(prompt, writingReviewList));
    commandMap.put("/writingReview/delete",
        new WritingReviewDeleteCommand(prompt, writingReviewList));
    commandMap.put("/writingReview/update",
        new WritingReviewUpdateCommand(prompt, writingReviewList));

    String command;

    while (true) {
      System.out.print("명령> ");
      command = keyboard.nextLine();

      if (command.length() == 0)
        continue;

      if (command.equalsIgnoreCase("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equalsIgnoreCase("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equalsIgnoreCase("history")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.printf("명령어 실행 중 오류 발생: %s\n", e.getMessage());
        }
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
    }
    keyboard.close();

    loadClientData();
    loadWritingReviewData();

  }

  void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (!iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if (count % 5 == 0) {
        System.out.print(":");
        if (("q").equalsIgnoreCase(keyboard.nextLine())) {
          break;
        }
      }
    }
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

  public static void main(String[] args) {

    App app = new App();
    app.service();

  }

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized();
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed();
    }
  }
}
