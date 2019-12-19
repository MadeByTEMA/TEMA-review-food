package tema.frr.chicken;

public class writingReviewDTO {
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
