// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

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

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();


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

  public void service() {

    notifyApplicationInitialized();

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


  public static void main(String[] args) {
    System.out.println("먹어봐따 ( Try it ) Server 시스템입니다.");

    // ServerApp app = new ServerApp();
    // app.addApplicationContextListener(new DataLoaderListener());
    // app.service();
  }



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

        if (request.equals("quit")) {
          out.writeUTF("OK");
          out.flush();
          break;
        }

        if (request.equals("/server/stop")) {
          out.writeUTF("OK");
          out.flush();
          return 9;
        }

        List<Client> clientList = (List<Client>) context.get("clientList");
        List<WritingReview> writingReviewList =
            (List<WritingReview>) context.get("writingReviewList");


      }
      System.out.println();
      return 0;

    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
      return -1;
    }
  }

}
