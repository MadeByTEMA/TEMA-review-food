// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
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

public class ServerApp {

  Scanner keyboard = new Scanner(System.in);
  //
  Deque<String> commandStack = new ArrayDeque<>();
  Queue<String> commandQueue = new LinkedList<>();

  Set<ApplicationContextListener> listeners = new HashSet<>();
  HashMap<String, Object> context = new HashMap<>();

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    List<Client> clientList = (List<Client>) context.get("clientList");
    List<WritingReview> writingReviewList = (List<WritingReview>) context.get("writingReviewList");

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

    notifyApplicationDestroyed();

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

  public static void main(String[] args) {
    System.out.println("먹어봐따 ( Try it ) Server 시스템입니다.");

    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("Client 연결 대기중");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Client 연결 되었음!");

        processRequest(socket);

      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
      return;
    }
    // ServerApp app = new ServerApp();
    // app.addApplicationContextListener(new DataLoaderListener());
    // app.service();
  }



  static void processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      String clientId = in.nextLine();
      String clientPwd = in.nextLine();
      out.print("먹어봐따 ( Try it )에 오신걸 환영합니다.");


    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
    }
  }

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }
}
