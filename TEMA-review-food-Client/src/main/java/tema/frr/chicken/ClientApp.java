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

  public void service() {
    try (Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("서버와 연결을 되었음!");

      out.writeUTF(prompt.inputString("ID : "));
      out.writeUTF(prompt.inputString("PWD : "));
      System.out.println(in.readUTF());

      processCommand(out, in);

      System.out.println("서버와 연결을 끊었음!");

    } catch (Exception e) {
      System.out.println("서버 연결 중 오류 발생!");
      e.printStackTrace();
    }

    keyboard.close();
  }

  public void processCommand(ObjectOutputStream out, ObjectInputStream in) {

    Deque<String> commandStack = new ArrayDeque<>();
    Queue<String> commandQueue = new LinkedList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/client/add", new ClientAddCommand(out, in, prompt));
    commandMap.put("/client/list", new ClientListCommand(out, in));
    commandMap.put("/client/detail", new ClientDetailCommand(out, in, prompt));
    commandMap.put("/client/delete", new ClientDeleteCommand(out, in, prompt));
    commandMap.put("/client/update", new ClientUpdateCommand(out, in, prompt));

    commandMap.put("/writingReview/add", new WritingReviewAddCommand(out, in, prompt));
    commandMap.put("/writingReview/list", new WritingReviewListCommand(out, in));
    commandMap.put("/writingReview/detail", new WritingReviewDetailCommand(out, in, prompt));
    commandMap.put("/writingReview/delete", new WritingReviewDeleteCommand(out, in, prompt));
    commandMap.put("/writingReview/update", new WritingReviewUpdateCommand(out, in, prompt));

    while (true) {
      String command;
      command = prompt.inputString("명령> ");

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
