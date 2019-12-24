// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.util.Scanner;
import tema.frr.chicken.handler.*;

public class App {

  static Scanner keyboard = new Scanner(System.in);


  public static void main(String[] args) {

    ClientHandler.keyboard = keyboard;
    WritingReviewHandler.keyboard = keyboard;

    String command;

    do {
      System.out.println("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/client/add":
          ClientHandler.addClient();
          break;

        case "/client/list":
          ClientHandler.listClient();
          break;

        case "/writingReview/add":
          WritingReviewHandler.addWritingReview();
          break;

        case "/writingReview/list":
          WritingReviewHandler.listWritingReview();
          break;

        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      } 
    } while (!command.equalsIgnoreCase("quit"));

    System.out.println("안녕!");

    keyboard.close();
  }
}
