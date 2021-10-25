### HTTP

### **특징**

- 클라이언트 서버 구조

  - Request Response 구조
  - 클라이언트는 서버에 요청을 보내고, 응답을 대기
  - 서버가 요청에 대한 결과를 만들어서 응답.

- 무상태 프로토콜 , 비연결성

  - 서버가 클라이언트의 상태를 보존 X

    - Stateful 과  Stateless가 있다.

      > 간단하게 **이전의 정보를 보존하는것과 하지 않는것** 이라고 보면 된다.

  - 상태 유지 - Stateful

    - 항상 같은 서버가 유지되어야 한다.

  - 무상태 - Stateless

    - 아무 서버나 호출해도 된다.

      > 중간에 특정 서버 하나가 장애가나면 다른 서버에서 그대로 클라이언트한테 물어볼수 있음.

    - 수평 확장에 유리하다.

      >  그냥 서버를 많이 늘릴수 있는 장점이 있다.

    - 데이터를 너무 많이 보냄.

  - 비연결성

    - HTTp는 기본이 연결을 유지하지 않는 모델

    - 일반적으로 초 단위의 이하의 빠른 속도로 응답

    - 서버의 자원을 매우 효율적으로 사용 할수 있음.

- HTTP 메시지

  - HTTP의 구조는 이런식으로 생겼다

    ![image-20211023194633352](C:\Users\kopqw\AppData\Roaming\Typora\typora-user-images\image-20211023194633352.png)

    - 시작라인

      요청, 응답에 따라 **형태가 다르다**

      요청 메시지 일때는 **request-line**다.

      > request-line = method SP(공백) request-target SP HTTP-version CRLF(엔터)

      HTTP 메서드

      - 종류 : GET, POST, PUT, DELETE 등이 존재

      HTTP 상태 코드: 요청 성공, 실패를 나타냄

      - 200 : 성공
      - 400 : 클라이언트 요청 오류
      - 500 : 서버 내부 오류
    
    - 헤더
    
      header-field: field-value 로 구성되어있다.
      
      field-name은 대소문자 구문이 없음.

- 단순함, 확장 가능.

---

### HTTP 메서드

HTTP API 를 설계할때 리소스에 맞춰서 만들어 줘야한다.

- URI는 리소스만 식별

  ex) 리소스 : 회원 , 행위 : 조회, 등록, 삭제, 변경

**주요 메서드**

- GET 

  리소스 조회

  Path에 있는 자원을 받는것

  서버에 전달하고 싶은 데이터는 query(쿼리 파라미터, 쿼리 스트링)를 통해서 전달

  ```http
  GET /search?q=hello&hl=ko HTTP/1.1
  HOST: www.google.com
  ```

  GET으로 특정원하는것을 서버에 요청-> 서버에서 조회를 해서 데이터를 만든뒤  응답메시지를 보냄

  

- POST 

  요청 데이터 처리, 주로 등록에 사용

  **메시지 바디를 통해 서버로 요청 데이터 전달**

  ```http
  POST /members HTTP/1.1
  Content-Type: application/json
  
  {
  	"username": "hello",
  	"age": 20
  }
  ```

  서버는 요청 데이터를 **처리**

  메시지 바디를 통해 들어온 데이터를 처리하는 모든 기능을 수행한다.

  메시지를 전달하고 -> 신규 리소스 생성 ->응답 메시지 보냄

  `HTTP/1.1 201 Created` **201로 보내게 될때**는 `Location : /members/100` 신규 생성된 URI 로 보내줌.

  ---

  POST는 다음과 같은 기능에 사용됨

  - HTML 양식에 입력 된 필드와 같은 데이터 블록을 데이터 처리 프로세스에 제공
    - ex) HTML FORM에 입력한 정보로 회원 가입, 주문 등에서 사용
  - 게시판, 뉴스 그룹, 메일링 리스트, 블로그 또는 유사한 기사 그룹에 메시지 게시
    - ex) 게시판 글쓰기, 댓글 달기
  - 서버가 아직 식별하지 않은 새 리소스 생성
    - ex) 신규 주문 생성
  - 기존 자원에 데이터 추가
    - ex) 한 문서 끝에 내용 추가하기

  **이 리소스 URI에 POST 요청이 오면 요청 데이터를 어떻게 처리할지 리소스마다 따로 정해야 함**

  ---

  

- PUT 

  리소스를 대체

  - 리소스가 있으면 대체
  - 리소스가 없으면 생성
  - **덮어버림**

  ```http
  PUT /members/100 HTTP/1.1
  Content-Type: application/json
  
  {
  	"username": "hello",
  	"age": 20
  }
  
  위에 `/members/100` 리소스가 없으면 아래 내용이 신규로 생성되고 , 없으면 대체해버린다.
  ```

  **POST와 차이점은 리소스 위치를 알고 URI를 지정함.**

  이미 리소스가 있는 상태에서 특정값만 바꾼다고 메시지를 보낼때 그 값도 바뀌니까 주의하자

  

- PATCH

  리소스 부분 변경

  

- DELETE 

  리소스 삭제

  ```http
  DELETE /members/100 HTTP/1.1
  Host: localhost:8080
  ```

  이런식으로 사용 하고 위에 내용으로 보면 **/members/100 번을 지워버린다**

**HTTP 메서드 속성**

- 안전

  호출해도 리소스를 변경하지 않는다. (POST PUT 등은 안전하지 X)

  **해당 리소스가 변하지 않는다로 생각**

- 멱등

  한 번 호출하든 여러번 호출 하든 결과가 똑같은것을 멱등하다고 생각하자.

- 캐시 가능

  응답 결과 리소스를 캐시해서 사용해도 되는가?

  실제로는 GET, HEAD 정도만 캐시로 사용

---

**[출처]**

[**HTTP 구조정리 - 삽질중인 개발자**](https://programmer93.tistory.com/60)

[**모든 개발자를 위한 HTTP 웹 기본 지식(인프런)**](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

