package tema.frr.chicken;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import tema.frr.chicken.dao.proxy.ClientDaoProxy;
import tema.frr.chicken.dao.proxy.DaoProxyHelper;
import tema.frr.chicken.dao.proxy.WritingReviewDaoProxy;
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
import tema.frr.chicken.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;

  String host;
  int port;

  HashMap<String, Command> commandMap = new HashMap<>();

  public ClientApp() {
    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();

    try {
      host = prompt.inputString("서버? ");
      port = prompt.inputInt("포트? ");

    } catch (Exception e) {
      System.out.println("서버 주소 또는 포트 번호가 유효하지 않습니다!");
      keyboard.close();
      return;
    }


    DaoProxyHelper daoProxyHelper = new DaoProxyHelper(host, port);

    ClientDaoProxy clientDao = new ClientDaoProxy(daoProxyHelper);
    WritingReviewDaoProxy writingReviewDao = new WritingReviewDaoProxy(daoProxyHelper);

    commandMap.put("/client/add", new ClientAddCommand(clientDao, prompt));
    commandMap.put("/client/list", new ClientListCommand(clientDao));
    commandMap.put("/client/detail", new ClientDetailCommand(clientDao, prompt));
    commandMap.put("/client/delete", new ClientDeleteCommand(clientDao, prompt));
    commandMap.put("/client/update", new ClientUpdateCommand(clientDao, prompt));

    commandMap.put("/writingReview/add", new WritingReviewAddCommand(writingReviewDao, prompt));
    commandMap.put("/writingReview/list", new WritingReviewListCommand(writingReviewDao));
    commandMap.put("/writingReview/detail", new WritingReviewDetailCommand(writingReviewDao, prompt));
    commandMap.put("/writingReview/delete", new WritingReviewDeleteCommand(writingReviewDao, prompt));
    commandMap.put("/writingReview/update", new WritingReviewUpdateCommand(writingReviewDao, prompt));

    commandMap.put("/server/stop", () -> {
      try {
        try (Socket socket = new Socket(host, port);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
          out.flush();
          System.out.println("서버: " + in.readUTF());
          System.out.println("안녕!");
        }
      } catch (Exception e) {
      }
    });

  }

  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("명령> ");

      if (command.length() == 0) {
        continue;
      }

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

      processCommand(command);
    }
    keyboard.close();
  }

  public void processCommand(String command) {
    Command commandHandler = commandMap.get(command);

    if (commandHandler == null) {
      System.out.println("실행할 수 없는 명령입니다.");
      return;
    }
    commandHandler.execute();
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
    System.out.println("먹어봐따 ( Try it ) Client 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();

  }


}
