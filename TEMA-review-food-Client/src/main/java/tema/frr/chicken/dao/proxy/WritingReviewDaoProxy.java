package tema.frr.chicken.dao.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import tema.frr.chicken.dao.WritingReviewDao;
import tema.frr.chicken.domain.WritingReview;

public class WritingReviewDaoProxy implements WritingReviewDao{

  String host;
  int port;

  public WritingReviewDaoProxy(String host, int port) {
    this.host = host;
    this.port = port;
  }


  @Override
  public int insert(WritingReview writingReview) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/writingReview/add");
      out.writeObject(writingReview);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }

      return 1;
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<WritingReview> findAll() throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/writingReview/list");
      out.flush();
      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (List<WritingReview>) in.readObject();
    }
  }
  @Override
  public WritingReview findByStoreName(String storeName) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/writingReview/detail");
      out.writeUTF(storeName);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return (WritingReview) in.readObject();
    }
  }

  @Override
  public int update(WritingReview writingReview) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/writingReview/update");
      out.writeObject(writingReview);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    }
  }

  @Override
  public int delete(String storeName) throws Exception {
    try (Socket socket = new Socket(host, port);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
      out.writeUTF("/writingReview/delete");
      out.writeUTF(storeName);
      out.flush();

      String response = in.readUTF();
      if (response.equals("FAIL")) {
        throw new Exception(in.readUTF());
      }
      return 1;
    }
  }
}
