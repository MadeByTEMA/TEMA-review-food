package tema.frr.chicken.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewObjectFileDao {

  String filename;
  List<WritingReview> list;


  public WritingReviewObjectFileDao(String filename) {
    this.filename = filename;
    list = new ArrayList<>();
    loadData();
  }

  @SuppressWarnings("unchecked")
  void loadData() {
    File file = new File(filename);

    try (ObjectInputStream in =
        new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {

      list = (List<WritingReview>) in.readObject();

      System.out.printf("총 %d 개의 고객 데이터를 로딩했습니다.\n", list.size());

    } catch (Exception e) {
      System.out.println("파일 읽기 중 오류 발생! - " + e.getMessage());
    }
  }

  void saveData() {
    File file = new File(filename);

    try (ObjectOutputStream out =
        new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
      out.reset();
      out.writeObject(list);

      System.out.printf("총 %d 개의 수업 데이터를 저장했습니다.\n", list.size());

    } catch (IOException e) {
      System.out.println("파일 쓰기 중 오류 발생! - " + e.getMessage());
    }
  }

  public int insert(WritingReview writingReview) throws Exception {

    if (indexOf(writingReview.getStoreName()) > -1) { // 같은 번호의 게시물이 있다면,
      return 0;
    }

    list.add(writingReview); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  public List<WritingReview> findAll() throws Exception {
    return list;
  }

  public WritingReview findByNo(String id) throws Exception {
    int index = indexOf(id);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(WritingReview writingReview) throws Exception {
    int index = indexOf(writingReview.getStoreName());

    if (index == -1) {
      return 0;
    }

    list.set(index, writingReview); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  public int delete(String storeName) throws Exception {
    int index = indexOf(storeName);
    if (index == -1) {
      return 0;
    }

    list.remove(index);
    saveData();
    return 1;
  }

  private int indexOf(String storeName) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getStoreName() == storeName) {
        return i;
      }
    }
    return -1;
  }
}
