package tema.frr.chicken.dao.json;

import java.util.List;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardJsonFileDao extends AbstractJsonFileDao<ReviewBoard> implements ReviewBoardDao{

  public ReviewBoardJsonFileDao(String filename) {
    super(filename);
  }


  public int insert(ReviewBoard reviewBoard) throws Exception {

    if (indexOf(reviewBoard.getBoardNo()) > -1) { // 같은 번호의 게시물이 있다면,
      return 0;
    }

    list.add(reviewBoard); // 새 게시물을 등록한다.
    saveData();
    return 1;
  }

  public List<ReviewBoard> findAll() throws Exception {
    return list;
  }

  public ReviewBoard findByBoardNo(int boardNo) throws Exception {
    int index = indexOf(boardNo);
    if (index == -1) {
      return null;
    }
    return list.get(index);
  }

  public int update(ReviewBoard reviewBoard) throws Exception {
    int index = indexOf(reviewBoard.getBoardNo());

    if (index == -1) {
      return 0;
    }

    list.set(index, reviewBoard); // 기존 객체를 파라미터로 받은 객체로 바꾼다.
    saveData();
    return 1;
  }

  public int delete(int BoardNo) throws Exception {
    int index = indexOf(BoardNo);
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
      if (list.get(i).getBoardNo() == (int) key) {
        return i;
      }
    }
    return -1;
  }
}
