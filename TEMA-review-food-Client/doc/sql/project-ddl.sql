-- 회원 테이블 생성
create table frr_client (
  client_no int not null auto_increment primary key comment '회원 데이터 식별 번호',
  id varchar(30) not null comment '아이디',
  pwd varchar(255) not null comment '암호',
  name varchar(30) not null comment '이름',
  vdt datetime null comment '생년월일',
  gen varchar(30) not null comment '성별',
  tel varchar(20) comment '전화',
  address varchar(255) comment '주소',
  rdt datetime not null default now() comment '가입일'
) comment '회원';

-- 후기 게시판 테이블 생성
create table frr_board (
  board_no int not null auto_increment primary key comment '게시물 식별 번호',
  cg varchar(30) not null comment '카테고리',
  stnm varchar(30) not null comment '가게명',
  menu varchar(30) not null comment '메뉴',
  price int not null comment '가격',
  stqul int default 0 comment '맛별점',
  stquan int default 0 comment '양별점',
  stprice int default 0 comment '가격별점',
  sttsum int default 0 comment '총별점',
  revi text not null comment '후기'
) comment '후기 게시판';

-- 사진 후기 게시판 테이블 생성
create table frr_photo (
  photo_no int not null auto_increment primary key comment '사진 게시물 식별 번호',
  board_no int not null comment '게시물 번호',
  titl varchar(30) not null comment '제목',
  cdt datetime default now() comment '생성일',
  vw_cnt int default 0 comment '조회수',
  -- board_no에 저장되는 값은 frr_board 테이블의 board_no 값으로 제한하는 조건을 추가한다.
  constraint fk_photo_to_board foreign key (board_no)
    references frr_board (board_no)
) comment '사진 후기 게시판';

-- 사진 게시물에 첨부하는 사진 파일 테이블 생성
create table frr_photo_file (
  photo_file_no int not null auto_increment primary key comment '사진 파일 식별 번호',
  photo_no int not null,
  file_path varchar(255) not null,
  constraint fk_photo_file_to_photo foreign key (photo_no)
    references frr_photo (photo_no)
) comment '사진 게시물 첨부파일 테이블'; 






