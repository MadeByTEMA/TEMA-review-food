package tema.frr.chicken.handler;

import java.util.Scanner;
import tema.frr.chicken.domain.*;

public class WritingReviewHandler {

  WritingReview[] reviews = new WritingReview[REVIEW_SIZE];
  int reviewCount = 0;

  static final int REVIEW_SIZE = 100_000;
  public static Scanner keyboard;

  public static void addWritingReview(WritingReviewHandler writingReviewHandler) { 
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

    writingReviewHandler.reviews[writingReviewHandler.reviewCount++] = r;

    System.out.println("저장하였습니다.");
  }

  public static void listWritingReview(WritingReviewHandler writingReviewHandler) {
    for (int i = 0; i < writingReviewHandler.reviewCount; i++) {
      WritingReview r = writingReviewHandler.reviews[i];
      System.out.printf("%s, %s, %s, %s, %s\n", r.storeName, r.menu, r.price, r.starQuality, r.starQuantity);
    }

  }

}
