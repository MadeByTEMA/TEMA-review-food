package tema.frr.chicken.handler;

import java.util.Scanner;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.util.ArrayList;

public class WritingReviewHandler {

  Scanner input;
  ArrayList<WritingReview> writingReviewList;
  
  public WritingReviewHandler(Scanner input) {
    this.input = input;
    writingReviewList = new ArrayList<>(); 
  }

  public void addWritingReview() { 
    WritingReview r = new WritingReview();

    System.out.println("가게명을 입력해주세요.");
    r.setStoreName(input.nextLine());

    System.out.println("메뉴을 입력해주세요.");
    r.setMenu(input.nextLine());

    System.out.println("가격을 입력해주세요.");
    r.setPrice(input.nextInt());

    input.nextLine();

    System.out.println("맛 별점을 입력해주세요.");
    r.setStarQuality(input.nextInt());

    input.nextLine();

    System.out.println("양 별점을 입력해주세요.");
    r.setStarQuantity(input.nextInt());

    input.nextLine();

    System.out.println("후기를 입력해주세요.");
    r.setReview(input.nextLine());

    writingReviewList.add(r);

    System.out.println("저장하였습니다.");
  }

  public void listWritingReview() {
    WritingReview[] reviews = writingReviewList.toArray(new WritingReview[] {});
    for (WritingReview r : reviews) {
      System.out.printf("%s, %s, %s, %s, %s, %s\n", r.getStoreName(), r.getMenu(),
          r.getPrice(), r.getStarQuality(), r.getStarQuantity(), r.getStarTotalSum());
    }
  }

}
