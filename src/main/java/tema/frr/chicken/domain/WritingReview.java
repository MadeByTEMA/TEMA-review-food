package tema.frr.chicken.domain;

public class WritingReview {
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WritingReview other = (WritingReview) obj;
    if (category == null) {
      if (other.category != null)
        return false;
    } else if (!category.equals(other.category))
      return false;
    if (menu == null) {
      if (other.menu != null)
        return false;
    } else if (!menu.equals(other.menu))
      return false;
    if (price != other.price)
      return false;
    if (review == null) {
      if (other.review != null)
        return false;
    } else if (!review.equals(other.review))
      return false;
    if (starPrice != other.starPrice)
      return false;
    if (starQuality != other.starQuality)
      return false;
    if (starQuantity != other.starQuantity)
      return false;
    if (starTotalSum != other.starTotalSum)
      return false;
    if (storeName == null) {
      if (other.storeName != null)
        return false;
    } else if (!storeName.equals(other.storeName))
      return false;
    return true;
  }
  
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
