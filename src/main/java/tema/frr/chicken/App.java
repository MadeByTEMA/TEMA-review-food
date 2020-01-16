// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.util.Scanner;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.handler.ClientHandler;
import tema.frr.chicken.handler.WritingReviewHandler;
import tema.frr.util.ArrayList;
import tema.frr.util.Iterator;
import tema.frr.util.LinkedList;
import tema.frr.util.Prompt;
import tema.frr.util.Queue;
import tema.frr.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandStack = new Stack<>();
  static Queue<String> commandQueue = new Queue<>();
  
  public static void main(String[] args) {

    Prompt prompt = new Prompt(keyboard);
    
    LinkedList<Client> clientList = new LinkedList<>();
    ClientHandler clientHandler = new ClientHandler(prompt, clientList);
    ArrayList<WritingReview> writingReviewList = new ArrayList<>();
    WritingReviewHandler writingReviewHandler = new WritingReviewHandler(prompt, writingReviewList);

    String command;

    do {
      System.out.print("명령> ");
      command = keyboard.nextLine();
      
      if (command.length() == 0)
        continue;
      
      commandStack.push(command);
      
      switch (command) {
        case "/client/add":
          clientHandler.addClient();
          break;

        case "/client/list":
          clientHandler.listClient();
          break;

        case "/client/detail":
          clientHandler.detailClient();
          break;

        case "/client/update":
          clientHandler.updateClient();
          break;

        case "/client/delete":
          clientHandler.deleteClient();
          break;
          
        case "/writingReview/add":
          writingReviewHandler.addWritingReview();
          break;

        case "/writingReview/list":
          writingReviewHandler.listWritingReview();
          break;

        case "/writingReview/detail":
          writingReviewHandler.detailWritingReview();
          break;

        case "/writingReview/update":
          writingReviewHandler.updateWritingReview();
          break;

        case "/writingReview/delete":
          writingReviewHandler.deleteWritingReview();
          break;
          
        case "history":
          printCommandHistory(commandStack.iterator());
          break;
          
        case "history2":
          printCommandHistory(commandQueue.iterator());
          break;
          
        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println(command);
            System.out.println("실행할 수 없는 명령입니다.");
          }
      } 
    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }
  
  static void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (!iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;
      
      if (count % 5 == 0) {
        System.out.print(":");
        if(("q").equalsIgnoreCase(keyboard.nextLine())) {
          break;
        }
      }
    }
  }
}
