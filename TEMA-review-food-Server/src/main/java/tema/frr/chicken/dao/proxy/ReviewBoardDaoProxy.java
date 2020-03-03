package tema.frr.chicken.dao.proxy;

import java.util.List;

import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.ReviewBoard;

public class ReviewBoardDaoProxy implements ReviewBoardDao{

  DaoProxyHelper daoProxyHelper;

  public ReviewBoardDaoProxy(DaoProxyHelper daoProxyHelper) {
    this.daoProxyHelper = daoProxyHelper;
  }


  @Override
  public int insert(ReviewBoard ReviewBoard) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/reviewboard/add");
      out.writeObject(ReviewBoard);
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
  public List<ReviewBoard> findAll() throws Exception {
    return (List<ReviewBoard>) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/reviewboard/list");
      out.flush();
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (List<ReviewBoard>) in.readObject();
    });
  }

  @Override
  public ReviewBoard findByBoardNo(int boardNo) throws Exception {
    return (ReviewBoard) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/reviewboard/detail");
      out.writeInt(boardNo);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (ReviewBoard) in.readObject();
    });
  }

  @Override
  public int update(ReviewBoard reviewBoard) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/reviewboard/update");
      out.writeObject(reviewBoard);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }

  @Override
  public int delete(int boardNo) throws Exception {
    return (int) daoProxyHelper.request((in, out) -> {
      out.writeUTF("/reviewboard/delete");
      out.writeInt(boardNo);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    });
  }
}
