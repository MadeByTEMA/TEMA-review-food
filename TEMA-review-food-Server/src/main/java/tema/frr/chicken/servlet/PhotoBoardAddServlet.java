package tema.frr.chicken.servlet;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import tema.frr.chicken.dao.PhotoBoardDao;
import tema.frr.chicken.dao.PhotoFileDao;
import tema.frr.chicken.dao.ReviewBoardDao;
import tema.frr.chicken.domain.PhotoBoard;
import tema.frr.chicken.domain.PhotoFile;
import tema.frr.chicken.domain.ReviewBoard;

public class PhotoBoardAddServlet implements Servlet {

  PhotoBoardDao photoBoardDao;
  ReviewBoardDao reviewBoardDao;
  PhotoFileDao photoFileDao;

  public PhotoBoardAddServlet(PhotoBoardDao photoBoardDao , ReviewBoardDao reviewBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.reviewBoardDao = reviewBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void service(Scanner in, PrintStream out) throws Exception {

    PhotoBoard photoBoard = new PhotoBoard();

    out.println("제목? ");
    out.println("!{}!");
    out.flush();
    photoBoard.setTitle(in.nextLine());

    out.println("후기 번호? ");
    out.println("!{}!");
    out.flush();

    int boardNo = Integer.parseInt(in.nextLine());

    ReviewBoard reviewBoard = reviewBoardDao.findByBoardNo(boardNo);
    if (reviewBoard == null) {
      out.println("후기 번호가 유효하지 않습니다.");
      return;
    }

    photoBoard.setReviewBoard(reviewBoard);

    if (photoBoardDao.insert(photoBoard) > 0) {
      out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      out.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

      ArrayList<PhotoFile> photoFiles = new ArrayList<>();

      while (true) {
        out.println("사진 파일? ");
        out.println("!{}!");
        out.flush();
        String filepath = in.nextLine();

        if (filepath.length() == 0) {
          if (photoFiles.size() > 0) {
            break;
          } else {
            out.println("최소 한 개의 사진 파일을 등록해야 합니다.");
            continue;
          }
        }

        photoFiles.add(new PhotoFile()
            .setFilepath(filepath)
            .setBoardNo(photoBoard.getNo()));
      }

      for (PhotoFile photoFile : photoFiles) {
        photoFileDao.insert(photoFile);
      }

      out.println("새 사진 게시글을 등록했습니다.");

    } else {
      out.println("사진 게시글 등록에 실패했습니다.");
    }
  }
}
