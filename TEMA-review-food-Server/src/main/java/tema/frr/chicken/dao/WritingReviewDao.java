package tema.frr.chicken.dao;

import java.util.List;
import tema.frr.chicken.domain.WritingReview;

public interface WritingReviewDao {

  public int insert(WritingReview writingReview) throws Exception;

  public List<WritingReview> findAll() throws Exception;

  public WritingReview findByStoreName(String storeName) throws Exception;

  public int update(WritingReview writingReview) throws Exception;

  public int delete(String storeName) throws Exception;
}
