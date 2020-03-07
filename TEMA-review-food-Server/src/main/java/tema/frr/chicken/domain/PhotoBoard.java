package tema.frr.chicken.domain;

import java.io.Serializable;
import java.sql.Date;

public class PhotoBoard implements Serializable {

  private static final long serialVersionUID = 1L;

  int no;
  String title;
  Date createdDate;
  int viewCount;
  ReviewBoard reviewBoard;

  @Override
  public String toString() {
    return "PhotoBoard [no=" + no + ", title=" + title + ", createdDate=" + createdDate
        + ", viewCount=" + viewCount + ", ReviewBoard=" + reviewBoard + "]";
  }

  public ReviewBoard getReviewBoard() {
    return reviewBoard;
  }

  public void setReviewBoard(ReviewBoard reviewBoard) {
    this.reviewBoard = reviewBoard;
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


}
