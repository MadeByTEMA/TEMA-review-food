# 19 - CRUD(Create/Retrieve/Update/Delete) 기능 완성

1) ArrayList 클래스에 항목 값을 조회하고 변경하고 삭제하는 기능을 추가하라.

- ArrayList.java
  - 목록의 특정 위치에 저장된 항목을 꺼내주는 get()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 바꾸는 set()을 정의한다.
  - 목록의 특정 위치에 저장된 항목을 삭제하는 remove()를 정의한다.

2) 고객 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- ClientHandler.java (ClientHandler.java.01)
  - 상세조회 기능을 수행하는 detailLesson()을 정의한다.
  - 변경 기능을 수행하는 updateLesson()을 정의한다.
  - 삭제 기능을 수행하는 deleteLesson()을 정의한다.
- App.java
  - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /Client/list
ID, 이름, 생일, 성별, 전화번호, 가입일
ID, 이름, 생일, 성별, 전화번호, 가입일

명령> /Client/detail


명령> /Client/detail
번호? 20
해당 고객을 찾을 수 없습니다.

명령> /lClient/update
번호? 2
고객을 변경했습니다.

명령> /Client/update
번호? 20
해당 고객을 찾을 수 없습니다.

명령> /Client/delete
번호? 2
고객을 삭제했습니다.

명령> /Client/delete
번호? 20
해당 고객을 찾을 수 없습니다.
```

작업3) ClientHandler 코드를 리팩토링하라.

- ClientHandler.java
    - 저장된 목록에서 고객 번호로 항목을 찾는 코드를 indexOfClient() 메서드로 분리한다.
- Client.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.


작업4) 후기 작성 데이터의 상세조회, 변경, 삭제 기능을 추가하라.

- WritingReviewHandler.java
    - 상세조회 기능을 수행하는 detailWritingReview()을 정의한다.
    - 변경 기능을 수행하는 updateWritingReview()을 정의한다.
    - 삭제 기능을 수행하는 deleteWritingReview()을 정의한다.
    - 저장된 목록에서 후기 작성 번호로 항목을 찾는 indexOfWritingReview()를 정의한다.
- WritingReview.java
    - 인스턴스 복제를 할 수 있도록 java.lang.Cloneable 인터페이스를 구현한다.
    - clone()을 오버라이딩 한다.
- App.java
    - 상세조회, 변경, 삭제 명령에 대한 분기문을 추가한다.

#### 실행 결과

```
명령> /writingReview/list
가게명, 메뉴, 가격, 맛 별점, 양 별점
가게명, 메뉴, 가격, 맛 별점, 양 별점

명령> /writingReview/detail


명령> /writingReview/detail
번호? 20
해당 후기를 찾을 수 없습니다.

명령> /writingReview/update

후기를 변경했습니다.

명령> /writingReview/update
번호? 20
해당 후기를 찾을 수 없습니다.

명령> /writingReview/delete
번호? 2
후기를 삭제했습니다.

명령> /writingReview/delete
번호? 20
해당 후기를 찾을 수 없습니다.
```