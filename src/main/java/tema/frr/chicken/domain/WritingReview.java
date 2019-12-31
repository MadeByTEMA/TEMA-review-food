package tema.frr.chicken.domain;

public class WritingReview {
  
  private String category;
  private String storeName;
  private String menu;
  private int price;
  private int starQuality;
  private int starQuantity;
  private int starPrice;
  private int starTotalSum;
  private String review;
  
  void starTotalSum() {
    this.starTotalSum = this.starQuality + this.starQuantity + this.starPrice;
    return;
  }
  
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public String getStoreName() {
    return storeName;
  }
  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }
  public String getMenu() {
    return menu;
  }
  public void setMenu(String menu) {
    this.menu = menu;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getStarQuality() {
    return starQuality;
  }
  public void setStarQuality(int starQuality) {
    this.starQuality = starQuality;
    this.starTotalSum();
  }
  public int getStarQuantity() {
    return starQuantity;
  }
  public void setStarQuantity(int starQuantity) {
    this.starQuantity = starQuantity;
    this.starTotalSum();
  }
  public int getStarPrice() {
    return starPrice;
  }
  public void setStarPrice(int starPrice) {
    this.starPrice = starPrice;
    this.starTotalSum();
  }
  public int getStarTotalSum() {
    return starTotalSum;
  }
  public String getReview() {
    return review;
  }
  public void setReview(String review) {
    this.review = review;
  }
}
