package tema.frr.chicken.handler;

import java.util.Scanner;
import tema.frr.chicken.domain.*;

public class WritingReviewHandler2 {


  static final int REVIEW_SIZE = 100_000;
  static WritingReview[] reviews = new WritingReview[REVIEW_SIZE];
  static int reviewCount = 0;
  public static Scanner keyboard;

  public static void addWritingReview() { 
    WritingReview r = new WritingReview();

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

  public static void listWritingReview() {
    for (int i = 0; i < reviewCount; i++) {
      WritingReview r = reviews[i];
      System.out.printf("%s, %s, %s, %s, %s\n", r.storeName, r.menu, r.price, r.starQuality, r.starQuantity);
    }

  }

}
