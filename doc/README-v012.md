# 12 - 클래스 필드와 클래스 메서드의 한계

1) 새 게시판을 추가하라.

- WritingReviewHandler2.java
    - `/writingReview/add`, `/writingReview/list` 명령을 처리할 클래스를 추가한다.
- App.java
    - 새 명령을 처리하는 코드를 추가한다.

실행 결과:

```
명령> /writingReview2/add
분류 : 
가게명 : 
메뉴명 : 
가격 : 
맛 별점 :  
양 별점 :
후기 : 
저장하였습니다.

명령> /writingReview2/add
분류 : 
가게명 : 
메뉴명 : 
가격 : 
맛 별점 :  
양 별점 :
후기 : 
저장하였습니다.

명령> /writingReview/add
분류 : 
가게명 : 
메뉴명 : 
가격 : 
맛 별점 :  
양 별점 :
후기 : 
저장하였습니다.

명령> /writingReview2/list
가게명, 메뉴, 가격, 맛 별점, 양 별점,
가게명, 메뉴, 가격, 맛 별점, 양 별점,

명령> /writingReview/list
가게명, 메뉴, 가격, 맛 별점, 양 별점,
```
