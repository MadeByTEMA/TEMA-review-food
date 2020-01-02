package tema.frr.chicken.handler;

import java.util.Arrays;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewList {
  
  static final int DEFAULT_CAPACITY = 2;
  WritingReview[] list;
  int size = 0;
  
  public WritingReviewList() {
    this.list = new WritingReview[DEFAULT_CAPACITY];
  }
  
  public void add(WritingReview writingReview) {
    if (this.list.length == this.size) {
      int oldCapacity = this.size;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      /*
      WritingReview[] arr = new WritingReview[newCapacity];
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.list[i];
      }
      this.list = arr;
      */
      this.list = Arrays.copyOf(this.list, newCapacity);
    }
    this.list[this.size++] = writingReview;
  }
  
  public WritingReview[] toArray() {
    /*
    WritingReview[] reviews = new WritingReview[this.size];
    for (int i = 0; i < this.size; i++) {
      reviews[i] = this.list[i];
    }
    return reviews;
    */
    return Arrays.copyOf(this.list, this.size);
  }
}
