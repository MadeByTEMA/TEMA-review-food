// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
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

  static Scanner keyboard = new Scanner(System.in);
  static Deque<String> commandStack = new ArrayDeque<>();
  static Queue<String> commandQueue = new LinkedList<>();

  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    HashMap<String, Command> commandMap = new HashMap<>();
    LinkedList<Client> clientList = new LinkedList<>();
    commandMap.put("/client/add", new ClientAddCommand(prompt, clientList));
    commandMap.put("/client/list", new ClientListCommand(clientList));
    commandMap.put("/client/detail", new ClientDetailCommand(prompt, clientList));
    commandMap.put("/client/delete", new ClientDeleteCommand(prompt, clientList));
    commandMap.put("/client/update", new ClientUpdateCommand(prompt, clientList));
    ArrayList<WritingReview> writingReviewList = new ArrayList<>();
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
        commandHandler.execute();
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      keyboard.close();
    }

  }

  static void printCommandHistory(Iterator<String> iterator) {
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
}
