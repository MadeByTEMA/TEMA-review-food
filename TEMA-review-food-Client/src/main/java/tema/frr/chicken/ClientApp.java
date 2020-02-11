package tema.frr.chicken;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {

  public void service() {
    //
  }



  public static void main(String[] args) {
    System.out.println("먹어봐따 ( Try it ) Client 시스템입니다.");

    try (Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        Scanner in = new Scanner(socket.getInputStream());
        PrintStream out = new PrintStream(socket.getOutputStream())) {
      System.out.println("서버 연결 대기중!");

      System.out.print("ID : ");
      out.println(keyScan.nextLine());
      System.out.print("PWD : ");
      out.println(keyScan.nextLine());
      System.out.println(in.nextLine());

    } catch (Exception e) {
      System.out.println("서버 연결 중 오류 발생!");
      return;
    }

    // ClientApp app = new ClientApp();
    // app.service();

  }
}
