package tema.frr.chicken.handler;

import java.util.Scanner;
import tema.frr.chicken.domain.*;

public class WritingReviewHandler {

  final int REVIEW_SIZE = 100_000;
  WritingReview[] reviews;
  int reviewCount = 0;

  Scanner input;
  
  public WritingReviewHandler(Scanner input) {
    this.input = input;
    this.reviews = new WritingReview[REVIEW_SIZE];
  }

  public void addWritingReview() { 
    WritingReview r = new WritingReview();

    System.out.println("가게명을 입력해주세요.");
    r.storeName = input.nextLine();

    System.out.println("메뉴을 입력해주세요.");
    r.menu = input.nextLine();

    System.out.println("가격을 입력해주세요.");
    r.price = input.nextInt();

    input.nextLine();

    System.out.println("맛 별점을 입력해주세요.");
    r.starQuality = input.nextInt();

    input.nextLine();

    System.out.println("양 별점을 입력해주세요.");
    r.starQuantity = input.nextInt();

    input.nextLine();

    System.out.println("후기를 입력해주세요.");
    r.review = input.nextLine();

    this.reviews[this.reviewCount++] = r;

    System.out.println("저장하였습니다.");
  }

  public void listWritingReview() {
    for (int i = 0; i < this.reviewCount; i++) {
      WritingReview r = this.reviews[i];
      System.out.printf("%s, %s, %s, %s, %s\n", r.storeName, r.menu, r.price, r.starQuality, r.starQuantity);
    }

  }

}
