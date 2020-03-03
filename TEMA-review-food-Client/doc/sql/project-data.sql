-- 회원 예제 데이터 
insert into frr_client(client_no, id, pwd, name, vdt, gen, tel, address)
  values(1, 'aaa', password('1111'), 'AAA', '2020-01-01', '남자', '010-1111-1111', '서울시');
insert into frr_client(client_no, id, pwd, name, vdt, gen, tel, address)
  values(2, 'bbb', password('1111'), 'BBB', '2020-01-02', '남자', '010-2222-2222', '서울시');
insert into frr_client(client_no, id, pwd, name, vdt, gen, tel, address)
  values(3, 'ccc', password('1111'), 'CCC', '2020-01-03', '여자', '010-3333-3333', '서울시');
insert into frr_client(client_no, id, pwd, name, vdt, gen, tel, address)
  values(4, 'ddd', password('1111'), 'DDD', '2020-01-04', '남자', '010-4444-4444', '서울시');
insert into frr_client(client_no, id, pwd, name, vdt, gen, tel, address)
  values(5, 'eee', password('1111'), 'EEE', '2020-01-05', '여자', '010-5555-5555', '서울시');

-- 후기 게시물 예제 데이터
insert into frr_board(board_no, cg, stnm, menu, price, stqul, stquan, stprice, sttsum, revi) 
  values(11, '카테고리1', '가게1', '메뉴1', 1, 1, 1, 1, 1, '후기1111');
insert into frr_board(board_no, cg, stnm, menu, price, stqul, stquan, stprice, sttsum, revi) 
  values(12, '카테고리2', '가게2', '메뉴2', 2, 2, 2, 2, 2, '후기2222');
insert into frr_board(board_no, cg, stnm, menu, price, stqul, stquan, stprice, sttsum, revi) 
  values(13, '카테고리3', '가게3', '메뉴3', 3, 3, 3, 3, 3, '후기3333');
insert into frr_board(board_no, cg, stnm, menu, price, stqul, stquan, stprice, sttsum, revi) 
  values(14, '카테고리4', '가게4', '메뉴4', 4, 4, 4, 4, 4, '후기4444');
insert into frr_board(board_no, cg, stnm, menu, price, stqul, stquan, stprice, sttsum, revi) 
  values(15, '카테고리5', '가게5', '메뉴5', 5, 5, 5, 5, 5, '후기5555');

-- 후기 사진 게시물 예제 데이터
insert into frr_photo(photo_no, board_no, titl) 
  values(111, 11, '제목1');
insert into frr_photo(photo_no, board_no, titl) 
  values(112, 12, '제목2');
insert into frr_photo(photo_no, board_no, titl) 
  values(113, 13, '제목3');
insert into frr_photo(photo_no, board_no, titl) 
  values(114, 14, '제목4');
insert into frr_photo(photo_no, board_no, titl) 
  values(115, 15, '제목5');

-- 후기 사진 게시물 첨부 파일 예제 데이터
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(1, 111, 'a1.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(2, 111, 'a2.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(3, 111, 'a3.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(4, 112, 'b1.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(5, 113, 'c1.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(6, 113, 'c2.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(7, 114, 'd1.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(8, 115, 'e1.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(9, 115, 'e2.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(10, 115, 'e3.gif');
insert into frr_photo_file(photo_file_no, photo_no, file_path)
  values(11, 115, 'e4.gif');

