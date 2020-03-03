package tema.frr.chicken.dao;

import java.util.List;

import tema.frr.chicken.domain.ReviewBoard;

public interface ReviewBoardDao {

  public int insert(ReviewBoard reviewBoard) throws Exception;

  public List<ReviewBoard> findAll() throws Exception;

  public ReviewBoard findByBoardNo(int BoardNo) throws Exception;

  public int update(ReviewBoard reviewBoard) throws Exception;

  public int delete(int BoardNo) throws Exception;
}
