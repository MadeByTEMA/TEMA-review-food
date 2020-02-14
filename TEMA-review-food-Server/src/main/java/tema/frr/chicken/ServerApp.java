// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.domain.Client;
import tema.frr.chicken.domain.WritingReview;
import tema.frr.chicken.servlet.ClientAddServlet;
import tema.frr.chicken.servlet.ClientDeleteServlet;
import tema.frr.chicken.servlet.ClientDetailServlet;
import tema.frr.chicken.servlet.ClientListServlet;
import tema.frr.chicken.servlet.ClientUpdateServlet;
import tema.frr.chicken.servlet.Servlet;
import tema.frr.chicken.servlet.WritingReviewAddServlet;
import tema.frr.chicken.servlet.WritingReviewDeleteServlet;
import tema.frr.chicken.servlet.WritingReviewDetailServlet;
import tema.frr.chicken.servlet.WritingReviewListServlet;
import tema.frr.chicken.servlet.WritingReviewUpdateServlet;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();
  Map<String, Servlet> servletMap = new HashMap<>();

  List<Client> clients;
  List<WritingReview> writingReviews;

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  }

  public void removeApplicationContextListener(ApplicationContextListener listener) {
    listeners.remove(listener);
  }

  private void notifyApplicationInitialized() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextInitialized(context);
    }
  }

  private void notifyApplicationDestroyed() {
    for (ApplicationContextListener listener : listeners) {
      listener.contextDestroyed(context);
    }
  }

  @SuppressWarnings("unchecked")
  public void service() {

    notifyApplicationInitialized();

    clients = (List<Client>) context.get("clientList");
    writingReviews = (List<WritingReview>) context.get("writingReviewList");

    servletMap.put("/client/list", new ClientListServlet(clients));
    servletMap.put("/client/add", new ClientAddServlet(clients));
    servletMap.put("/client/detail", new ClientDetailServlet(clients));
    servletMap.put("/client/update", new ClientUpdateServlet(clients));
    servletMap.put("/client/delete", new ClientDeleteServlet(clients));
    servletMap.put("/writingReview/list", new WritingReviewListServlet(writingReviews));
    servletMap.put("/writingReview/add", new WritingReviewAddServlet(writingReviews));
    servletMap.put("/writingReview/detail", new WritingReviewDetailServlet(writingReviews));
    servletMap.put("/writingReview/update", new WritingReviewUpdateServlet(writingReviews));
    servletMap.put("/writingReview/delete", new WritingReviewDeleteServlet(writingReviews));

    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("Client 연결 대기중");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Client 연결 되었음!");

        if (processRequest(socket) == 9) {
          break;
        }

      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
      return;
    }

    notifyApplicationDestroyed();

  }

  @SuppressWarnings("unchecked")
  int processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {

      System.out.println("통신을 위한 입출력 스트림을 준비하였음!");

      while (true) {
        String clientId = in.readUTF();
        String clientPwd = in.readUTF();
        out.writeUTF("먹어봐따 ( Try it )에 오신걸 환영합니다.");

        String request = in.readUTF();
        System.out.println("클라이언트가 보낸 메시지를 수신하였음!");

        switch (request) {
          case "quit":
            quit(out);
            return 0;
          case "/server/stop":
            quit(out);
            return 9;
        }

        // 클라이언트의 요청을 처리할 객체를 찾는다.
        Servlet servlet = servletMap.get(request);

        if (servlet != null) {
          try {
            servlet.service(in, out);

          } catch (Exception e) {
            out.writeUTF("FAIL");
            out.writeUTF(e.getMessage());

            System.out.println("클라이언트 요청 처리 중 오류 발생:");
            e.printStackTrace();
          }
        } else {
          notFound(out);
        }

        out.flush();
        System.out.println("클라이언트에게 응답하였음!");
        System.out.println("------------------------------------");
      }
    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
      return -1;
    }
  }

  private void notFound(ObjectOutputStream out) throws IOException {
    out.writeUTF("FAIL");
    out.writeUTF("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(ObjectOutputStream out) throws IOException {
    out.writeUTF("OK");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("먹어봐따 ( Try it ) Server 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
