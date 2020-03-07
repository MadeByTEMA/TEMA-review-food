// 먹어봐따 Try it(가칭) : 음식 후기 및 평점 사이트
// 실제 프렌차이즈에 다양한 음식 먹은 후기와 별점들을 유저들이 남기고,
// 해당 프렌차이즈에서 뭘 먹을지 제시, 추천해주는 사이트.
//
package tema.frr.chicken;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import tema.frr.chicken.context.ApplicationContextListener;
import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.servlet.ClientAddServlet;
import tema.frr.chicken.servlet.ClientDeleteServlet;
import tema.frr.chicken.servlet.ClientDetailServlet;
import tema.frr.chicken.servlet.ClientListServlet;
import tema.frr.chicken.servlet.ClientSearchServlet;
import tema.frr.chicken.servlet.ClientUpdateServlet;
import tema.frr.chicken.servlet.ReviewBoardAddServlet;
import tema.frr.chicken.servlet.ReviewBoardDeleteServlet;
import tema.frr.chicken.servlet.ReviewBoardDetailServlet;
import tema.frr.chicken.servlet.ReviewBoardListServlet;
import tema.frr.chicken.servlet.ReviewBoardUpdateServlet;
import tema.frr.chicken.servlet.Servlet;

public class ServerApp {

  Set<ApplicationContextListener> listeners = new HashSet<>();
  Map<String, Object> context = new HashMap<>();
  Map<String, Servlet> servletMap = new HashMap<>();
  ExecutorService executorService = Executors.newCachedThreadPool();

  boolean serverStop = false;

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

    ClientDao clientDao = (ClientDao) context.get("clientDao");
    ReviewBoardDao reviewBoardDao =
        (ReviewBoardDao) context.get("reviewBoardDao");

    servletMap.put("/client/list", new ClientListServlet(clientDao));
    servletMap.put("/client/add", new ClientAddServlet(clientDao));
    servletMap.put("/client/detail", new ClientDetailServlet(clientDao));
    servletMap.put("/client/update", new ClientUpdateServlet(clientDao));
    servletMap.put("/client/delete", new ClientDeleteServlet(clientDao));
    servletMap.put("/client/search", new ClientSearchServlet(clientDao));
    servletMap.put("/reviewBoardDao/list", new ReviewBoardListServlet(reviewBoardDao));
    servletMap.put("/reviewBoardDao/add", new ReviewBoardAddServlet(reviewBoardDao));
    servletMap.put("/reviewBoardDao/detail",
        new ReviewBoardDetailServlet(reviewBoardDao));
    servletMap.put("/reviewBoardDao/update",
        new ReviewBoardUpdateServlet(reviewBoardDao));
    servletMap.put("/reviewBoardDao/delete",
        new ReviewBoardDeleteServlet(reviewBoardDao));

    try (ServerSocket serverSocket = new ServerSocket(9999)) {

      System.out.println("Client 연결 대기중");

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Client 연결 되었음!");

        executorService.submit(() -> {
          processRequest(socket);
          System.out.println("--------------------------------------");
        });

        if (serverStop) {
          break;
        }

      }

    } catch (Exception e) {
      System.out.println("서버 준비 중 오류 발생!");
    }



    executorService.shutdown();

    while (true) {
      if (executorService.isTerminated()) {
        break;
      }
      try {
        Thread.sleep(500);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    notifyApplicationDestroyed();

    System.out.println("서버 종료!");
  }

  void processRequest(Socket clientSocket) {
    try (Socket socket = clientSocket;
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      String request = in.nextLine();
      System.out.printf("=> %s\n", request);

      if (request.equalsIgnoreCase("/server/stop")) {
        quit(out);
        return;
      }

      Servlet servlet = servletMap.get(request);

      if (servlet != null) {
        try {
          servlet.service(in, out);

        } catch (Exception e) {
          out.println("요청 처리 중 오류 발생!");
          out.println(e.getMessage());

          System.out.println("클라이언트 요청 처리 중 오류 발생:");
          e.printStackTrace();
        }
      } else {
        notFound(out);
      }
      out.println("!end!");
      out.flush();
      System.out.println("클라이언트에게 응답하였음!");

    } catch (Exception e) {
      System.out.println("예외 발생:");
      e.printStackTrace();
    }
  }

  private void notFound(PrintStream out) throws IOException {
    out.println("요청한 명령을 처리할 수 없습니다.");
  }

  private void quit(PrintStream out) throws IOException {
    serverStop = true;
    out.println("OK");
    out.println("!end!");
    out.flush();
  }

  public static void main(String[] args) {
    System.out.println("먹어봐따 ( Try it ) Server 시스템입니다.");

    ServerApp app = new ServerApp();
    app.addApplicationContextListener(new DataLoaderListener());
    app.service();
  }
}
