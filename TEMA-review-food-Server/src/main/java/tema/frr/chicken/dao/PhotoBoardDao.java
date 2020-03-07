package tema.frr.chicken.dao;

import java.util.List;

import tema.frr.chicken.domain.PhotoBoard;

public interface PhotoBoardDao {
  int insert(PhotoBoard photoBoard) throws Exception;

  List<PhotoBoard> findAllByBoardNo(int boardNo) throws Exception;

  PhotoBoard findByNo(int no) throws Exception;

  int update(PhotoBoard photoBoard) throws Exception;

  int delete(int no) throws Exception;
}


