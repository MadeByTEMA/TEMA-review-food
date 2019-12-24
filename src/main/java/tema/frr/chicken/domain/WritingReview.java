package tema.frr.chicken.domain;

public class WritingReview {
  
  public String category;
  public String storeName;
  public String menu;
  public int price;
  public int starQuality;
  public int starQuantity;
  public int starPrice;
  public int starTotalSum = starQuality + starQuantity + starPrice;
  public String review;
  
}
