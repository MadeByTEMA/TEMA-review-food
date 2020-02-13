package tema.frr.chicken.domain;

import java.io.Serializable;

public class WritingReview implements Serializable {

  private static final long serialVersionUID = 202002007L;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((menu == null) ? 0 : menu.hashCode());
    result = prime * result + price;
    result = prime * result + ((review == null) ? 0 : review.hashCode());
    result = prime * result + starPrice;
    result = prime * result + starQuality;
    result = prime * result + starQuantity;
    result = prime * result + starTotalSum;
    result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
    return result;
  }

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



  public static WritingReview valueOf(String csv) {
    String[] data = csv.split(",");

    WritingReview writingReview = new WritingReview();

    writingReview.setCategory(data[0]);
    writingReview.setStoreName(data[1]);
    writingReview.setMenu(data[2]);
    writingReview.setPrice(Integer.parseInt(data[3]));
    writingReview.setStarQuality(Integer.parseInt(data[4]));
    writingReview.setStarQuantity(Integer.parseInt(data[5]));
    writingReview.setStarPrice(Integer.parseInt(data[6]));
    writingReview.setReview(data[7]);

    return writingReview;
  }

  public String toCsvString() {
    return String.format("%s,%s,%s,%s,%d,%d,%d,%s\n", this.getCategory(), this.getStoreName(),
        this.getMenu(), this.getPrice(), this.getStarQuality(), this.getStarQuantity(),
        this.getStarPrice(), this.getStarTotalSum(), this.getReview());
  }

}
