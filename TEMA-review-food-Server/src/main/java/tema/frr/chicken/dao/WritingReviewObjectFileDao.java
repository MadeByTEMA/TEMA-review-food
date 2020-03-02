package tema.frr.chicken.dao;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewObjectFileDao extends AbstractObjectFileDao<WritingReview> implements WritingReviewDao{

  public WritingReviewObjectFileDao(String filename) {
    super(filename);
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

  public WritingReview findByStoreName(String storeName) throws Exception {
    int index = indexOf(storeName);
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

  @Override
  protected <K> int indexOf(K key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getStoreName() == (String) key) {
        return i;
      }
    }
    return -1;
  }
}
