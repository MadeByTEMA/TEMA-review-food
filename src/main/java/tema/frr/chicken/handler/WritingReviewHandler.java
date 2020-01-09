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

    r.setStoreName(inputString("가게명을 입력해주세요."));
    r.setMenu(inputString("메뉴을 입력해주세요."));
    r.setPrice(inputInt("가격을 입력해주세요."));
    r.setStarQuality(inputInt("맛 별점을 입력해주세요."));
    r.setStarQuantity(inputInt("양 별점을 입력해주세요."));
    r.setReview(inputString("후기를 입력해주세요."));

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

  public void detailWritingReview() {

    int index = indexOfWritingReview(inputString("가게명? "));

    if (index == -1) {
      System.out.println("해당 고객을 찾을 수 없습니다.");
      return;
    }

    WritingReview writingReview = this.writingReviewList.get(index);

    System.out.printf("메뉴 : %s\n", writingReview.getMenu());
    System.out.printf("가격 : %s\n", writingReview.getPrice());
    System.out.printf("총 별점 : %s\n", writingReview.getStarTotalSum());
    System.out.printf("맛 별점:  %s\n", writingReview.getStarQuality());
    System.out.printf("양 별점 : %s\n", writingReview.getStarQuantity());
    System.out.printf("후기 : %s\n", writingReview.getReview());
  }


  public void updateWritingReview() {

    int index = indexOfWritingReview(inputString("가게명? ")); 

    if (index == -1) {
      System.out.println("해당 후기를 찾을 수 없습니다.");
      return;
    }

    WritingReview oldWritingReview = this.writingReviewList.get(index);
    WritingReview newWritingReview = new WritingReview();

    newWritingReview.setCategory(oldWritingReview.getCategory());
    newWritingReview.setStoreName(oldWritingReview.getStoreName());
    
    newWritingReview.setMenu(inputString(
    String.format("메뉴(%s) \n", oldWritingReview.getMenu())
    , oldWritingReview.getMenu()));
   
    newWritingReview.setPrice(inputInt(
    String.format("가격(%s) \n", oldWritingReview.getPrice())
    , oldWritingReview.getPrice()));
    
    newWritingReview.setStarQuality(inputInt(
    String.format("맛 별점(%s) \n", oldWritingReview.getStarQuality())
    , oldWritingReview.getStarQuality()));
    
    newWritingReview.setStarQuantity(inputInt(
    String.format("양 별점(%s) \n", oldWritingReview.getStarQuantity())
    , oldWritingReview.getStarQuantity()));
    
    newWritingReview.setReview(inputString(
    String.format("후기(%s) \n", oldWritingReview.getReview())
    , oldWritingReview.getReview()));
    
    if (newWritingReview.equals(oldWritingReview)) {
      System.out.println(" 후기 변경을 취소하였습니다. ");
    } else {
      this.writingReviewList.set(index, newWritingReview);
      System.out.println( "후기를 변경하였습니다. ");
    }
  }

  public void deleteWritingReview() {

  }

  private int indexOfWritingReview(String storeName) {
    for (int i = 0; i < this.writingReviewList.size(); i++) {
      WritingReview temp = this.writingReviewList.get(i);
      if (storeName.equals(temp.getStoreName())) {
        return i;
      }
    }
    return -1;
  }
  
  public String inputString(String label) {
    System.out.println(label);
    return input.nextLine();
  }
  
  public String inputString(String label, String defaultValue) {
    System.out.println(label);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return value;
  }
  
  public int inputInt(String label) {
    System.out.println(label);
    return Integer.parseInt(input.nextLine());
  }
  
  public int inputInt(String label, int defaultValue) {
    System.out.println(label);
    String value = input.nextLine();
    if (value.length() == 0) {
      return defaultValue;
    }
    return Integer.parseInt(value);
  }
}