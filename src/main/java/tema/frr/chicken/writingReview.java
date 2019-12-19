package tema.frr.chicken;

import java.util.Scanner;

public class writingReview {
  static final int size = 100_000;
  static writingReviewDTO[] reviews = new writingReviewDTO[size];
  static int count = 0;

  public static void main(String[] args) {

    inputReview();

    System.out.println();

    printReview();

  }

  static void inputReview() { 
    Scanner keyboard = new Scanner(System.in);
    String response;

    for(int i = 0; i < size; i++) {
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

      reviews[i] = r;

      count++;

      System.out.println();

      System.out.print("계속 입력하시겠습니까 ? Y/N ");
      response = keyboard.nextLine();
      if (!response.equalsIgnoreCase("y")) {
        break;
      }

    }
    keyboard.close();
  }
  static void printReview() {
    for (int i = 0; i < count; i++) {
    writingReviewDTO r = reviews[i];
    System.out.printf("%s, %s, %s, %s, %s, %s\n", r.storeName, r.menu, r.price, r.starQuality, r.starQuantity);
    }
  }
}