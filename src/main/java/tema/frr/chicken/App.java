// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.sql.Date;
import java.util.Scanner;

public class App {

  static class clientDTO {
    String id;
    String pwd;
    String name;
    Date birthday;
    String sex;
    String tel;
    String address;
    Date signUpDate;
  }

  static final int CLIENT_SIZE = 100_000;
  static clientDTO[] clients = new clientDTO[CLIENT_SIZE];
  static int clountCount = 0;

  static class writingReviewDTO {
    String category;
    String storeName;
    String menu;
    int price;
    int starQuality;
    int starQuantity;
    int starPrice;
    int starTotalSum = starQuality + starQuantity + starPrice;
    String review;
  }

  static final int REVIEW_SIZE = 100_000;
  static writingReviewDTO[] reviews = new writingReviewDTO[REVIEW_SIZE];
  static int reviewCount = 0;

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    String command; 

    do {
      System.out.println("명령> ");
      command = keyboard.nextLine();

      switch (command) {
        case "/client/add":
          addClient();
          break;
        case "/client/list":
          listClient();
          break;

        case "/writingReview/add":
          addWritingReview();
          break;

        case "/writingReview/list":
          listWritingReview();
          break;

        default:
          if(!command.equalsIgnoreCase("quit")) {
            System.out.println("실행할 수 없는 명령입니다.");
          }
      } 

    } while (!command.equalsIgnoreCase("quit"));
    System.out.println("안녕!");
  }


  static void addClient() {
      clientDTO c = new clientDTO();

      System.out.println("ID를 입력해주세요.");
      c.id = keyboard.nextLine();

      System.out.println("PWD를 입력해주세요.");
      c.pwd = keyboard.nextLine();

      System.out.println("이름을 입력해주세요.");
      c.name = keyboard.nextLine();

      System.out.println("생년월일을 입력해주세요.");
      c.birthday = Date.valueOf(keyboard.nextLine());

      System.out.println("성별을 입력해주세요.");
      c.sex = keyboard.nextLine();

      System.out.println("전화번호를 입력해주세요.");
      c.tel = keyboard.nextLine();

      System.out.println("주소를 입력해주세요.");
      c.address = keyboard.nextLine();

      c.signUpDate = new Date(System.currentTimeMillis());

      clients[clountCount++] = c;

      System.out.println("저장하였습니다.");
    }

  static void listClient() {
    for (int i = 0; i < clountCount; i++) {
      clientDTO c = clients[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n", c.id, c.name, c.birthday, c.sex, c.tel, c.signUpDate);
    }
  }

  static void addWritingReview() { 
      writingReviewDTO r = new writingReviewDTO();

      System.out.println("가게명을 입력해주세요.");
      r.storeName = keyboard.nextLine();

      System.out.println("메뉴을 입력해주세요.");
      r.menu = keyboard.nextLine();

      System.out.println("가격을 입력해주세요.");
      r.price = keyboard.nextInt();

      keyboard.nextLine();

      System.out.println("맛 별점을 입력해주세요.");
      r.starQuality = keyboard.nextInt();

      keyboard.nextLine();

      System.out.println("양 별점을 입력해주세요.");
      r.starQuantity = keyboard.nextInt();

      keyboard.nextLine();

      System.out.println("후기를 입력해주세요.");
      r.review = keyboard.nextLine();

      reviews[reviewCount++] = r;

      System.out.println("저장하였습니다.");
    }

  static void listWritingReview() {
    for (int i = 0; i < reviewCount; i++) {
      writingReviewDTO r = reviews[i];
      System.out.printf("%s, %s, %s, %s, %s, %s\n", r.storeName, r.menu, r.price, r.starQuality, r.starQuantity);
    }
  }
}
