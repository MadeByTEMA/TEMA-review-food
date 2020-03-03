package tema.frr.chicken.dao.proxy;

import java.util.List;

import tema.frr.chicken.dao.WritingReviewDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDaoProxy implements WritingReviewDao{

  DaoProxyHelper daoProxyHelper;

  public WritingReviewDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }


  @Override
  public int insert(WritingReview writingReview) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/writingReview/add");
      out.writeObject(writingReview);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }

      return 1;
    });
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<WritingReview> findAll() throws Exception {
    return (List<WritingReview>) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/writingReview/list");
      out.flush();
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (List<WritingReview>) in.readObject();
    });
  }

  @Override
  public WritingReview findByStoreName(String storeName) throws Exception {
    return (WritingReview) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/writingReview/detail");
      out.writeUTF(storeName);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (WritingReview) in.readObject();
    });
  }

  @Override
  public int update(WritingReview writingReview) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/writingReview/update");
      out.writeObject(writingReview);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }

  @Override
  public int delete(String storeName) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/writingReview/delete");
      out.writeUTF(storeName);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }
}
