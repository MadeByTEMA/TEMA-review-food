package tema.frr.chicken.dao;

import java.util.List;

import tema.frr.chicken.domain.PhotoFile;

public interface PhotoFileDao {
  int insert(PhotoFile photoFile) throws Exception;

  List<PhotoFile> findAll(int boardNo) throws Exception;

  int deleteAll(int boardNo) throws Exception;
}


