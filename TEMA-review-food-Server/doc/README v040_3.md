# 40_3 - Connection을 스레드에 보관하기: 트랜잭션 적용하기
 
1) PhotoBoardAddServlet에 트랜잭션을 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardAddServlet 변경
  - ConnectionFactory를 주입 받는다.
  - ConnectionFactory를 통해 Connection을 얻은 후에 트랜잭션을 제어한다.
 
2) PhotoBoardUpdateServlet에 트랜잭션을 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardUpdateServlet 변경
  - ConnectionFactory를 주입 받는다.
  - ConnectionFactory를 통해 Connection을 얻은 후에 트랜잭션을 제어한다.
 
3) PhotoBoardDeleteServlet에 트랜잭션을 적용하라.
 
- tema.frr.chicken.servlet.PhotoBoardDeleteServlet 변경
  - ConnectionFactory를 주입 받는다.
  - ConnectionFactory를 통해 Connection을 얻은 후에 트랜잭션을 제어한다.
 
4) 트랜잭션을 다뤄야 하는 서블릿 객체에 ConnectionFactory를 주입하라.
 
- tema.frr.chicken.ServerApp 변경
  - PhotoBoardAddServlet, PhotoBoardUpdateServlet, PhotoBoardDeleteServlet 객체에
    ConectionFactory를 주입한다.
 
