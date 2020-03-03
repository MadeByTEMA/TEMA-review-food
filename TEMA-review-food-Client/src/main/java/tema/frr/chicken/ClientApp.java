package tema.frr.chicken;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import tema.frr.chicken.dao.ClientDao;
import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.dao.mariadb.ClientDaoImpl;
import tema.frr.chicken.dao.mariadb.ReviewBoardDaoImpl;
import tema.frr.chicken.handler.ClientAddCommand;
import tema.frr.chicken.handler.ClientDeleteCommand;
import tema.frr.chicken.handler.ClientDetailCommand;
import tema.frr.chicken.handler.ClientListCommand;
import tema.frr.chicken.handler.ClientUpdateCommand;
import tema.frr.chicken.handler.Command;
import tema.frr.chicken.handler.ReviewBoardAddCommand;
import tema.frr.chicken.handler.ReviewBoardDeleteCommand;
import tema.frr.chicken.handler.ReviewBoardDetailCommand;
import tema.frr.chicken.handler.ReviewBoardListCommand;
import tema.frr.chicken.handler.ReviewBoardUpdateCommand;
import tema.frr.chicken.util.Prompt;

public class ClientApp {

  Scanner keyboard = new Scanner(System.in);
  Prompt prompt = new Prompt(keyboard);

  Deque<String> commandStack;
  Queue<String> commandQueue;

  Connection con;

  HashMap<String, Command> commandMap = new HashMap<>();

  public ClientApp() throws Exception {

    Class.forName("org.mariadb.jdbc.Driver");
    con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

    commandStack = new ArrayDeque<>();
    commandQueue = new LinkedList<>();

    ClientDao clientDao = new ClientDaoImpl(con);
    ReviewBoardDao reviewBoardDao = new ReviewBoardDaoImpl(con);

    commandMap.put("/client/add", new ClientAddCommand(clientDao, prompt));
    commandMap.put("/client/list", new ClientListCommand(clientDao));
    commandMap.put("/client/detail", new ClientDetailCommand(clientDao, prompt));
    commandMap.put("/client/delete", new ClientDeleteCommand(clientDao, prompt));
    commandMap.put("/client/update", new ClientUpdateCommand(clientDao, prompt));

    commandMap.put("/reviewboard/add", new ReviewBoardAddCommand(reviewBoardDao, prompt));
    commandMap.put("/reviewboard/list", new ReviewBoardListCommand(reviewBoardDao));
    commandMap.put("/reviewboard/detail", new ReviewBoardDetailCommand(reviewBoardDao, prompt));
    commandMap.put("/reviewboard/delete", new ReviewBoardDeleteCommand(reviewBoardDao, prompt));
    commandMap.put("/reviewboard/update", new ReviewBoardUpdateCommand(reviewBoardDao, prompt));
  }

  public void service() {

    while (true) {
      String command;
      command = prompt.inputString("명령> ");

      if (command.length() == 0) {
        continue;
      }

      if (command.equalsIgnoreCase("quit")) {
        System.out.println("안녕!");
        break;
      } else if (command.equalsIgnoreCase("history")) {
        printCommandHistory(commandStack.iterator());
        continue;
      } else if (command.equalsIgnoreCase("history")) {
        printCommandHistory(commandQueue.iterator());
        continue;
      }

      commandStack.push(command);
      commandQueue.offer(command);

      processCommand(command);
    }
    keyboard.close();
  }

  public void processCommand(String command) {
    Command commandHandler = commandMap.get(command);

    if (commandHandler == null) {
      System.out.println("실행할 수 없는 명령입니다.");
      return;
    }
    commandHandler.execute();
  }

  void printCommandHistory(Iterator<String> iterator) {
    int count = 0;
    while (!iterator.hasNext()) {
      System.out.println(iterator.next());
      count++;

      if (count % 5 == 0) {
        System.out.print(":");
        if (("q").equalsIgnoreCase(keyboard.nextLine())) {
          break;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.println("먹어봐따 ( Try it ) Client 시스템입니다.");

    ClientApp app = new ClientApp();
    app.service();
  }
}
