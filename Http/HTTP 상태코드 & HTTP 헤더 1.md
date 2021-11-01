### 상태코드

클라이언트가 보낸 요청의 처리 상태를 응답에서 알려주는 기능

- 1xx(Informational) : 요청이 수신되어 처리중

- 2xx(Successful) : 요청 정상 처리

  클라이언트의 요청을 성공적으로 처리

- 3xx(Redirection) : 요청을 완료하려면 추가 행동이 필요

- 4xx(Client Error) : 클라이언트 오류, 잘못된 문법등으로 서버가 요청을 수행할 수 없음

- 5xx(Server Error) : 서버 오류, 서버가 정상 요청을 처리하지 못함

---

### HTTP 헤더 1

헤더 필드에 네임은 대소문자 구문이 없음

- HTTP 전송에 필요한 모든 부가정보
- ex) 메시지 바디의 내용, 메시지 바디의 크기, 압축, 인증, 요청 클라이언트, 서버 정보, 캐시 관리 정보...
- 표준 헤더가 많고 필요시 임의의 헤더 추가가 가능하다.

현재는 엔티티 바디라는 용어가 사라지고

- 엔티티(Entity) -> 표현(Representation)

- Representation = representation Metadata + Representation Data

  표현 = 표현 메타데이터 + 표현 데이터 이루어짐.

message body - RFC7230

![image-20211101164146980](https://user-images.githubusercontent.com/45530877/139660189-504b483e-b81c-4ca5-b3c9-1eab1df1cb4f.png)

- 메시지 본문을 통해 표현 데이터 전달

- 메시지 본문 = 페이로드(payload)

  데이터를 실어 나르는 실제 데이터부분

- **표현**은 요청이나 응답에서 전달할 실제 데이터

- **표현 헤더는 표현 데이터**를 해석할 수 있는 정보 제공

  - 데이터 유형(html, json), 데이터 길이, 압출 정보 등등

  **참고 : 표현 헤더는 표현 메타데이터와, 페이로드 메시지를 구분해야 하지만 복잡해지기 때문에 생략**

### 표현

- Content-Type: 표현 데이터의 형식
- Content-Encoding: 표현 데이터의 압출 방식
- Content-Language: 표현 데이터의 자연 언어
- Content-Length: 표현 데이터의 길이

**표현 헤더는 전송, 응답 둘다 사용**

**Content-Type**
Content body에 들어가는 내용이 뭔지

- 미디어 타입, 문자 인코딩
- ex) html 일때 ->text/html; charset=UTF-8 , json -> application/json, image -> image/png

**Content-Encoding**
표현 데이터에 대한 인코딩

- 표현 데이터를 압축하기 위해 사용
- 데이터를 전달하는 곳에서 압축 후 인코딩 헤더 추가
- 데이터를 읽는 쪽에서 인코딩 헤더의 정보로 압축 해제
- ex) gzip , deflate, identity(압축안한다는것)

**Content-Language**

- 표현 데이터의 자연 언어를 표현

- ex) ko, en , en-US

  > 본문 내용을 알수 있음.

**Content-Length**
표현 데이터의 길이

- 바이트 단위
- Transfer-Encoding(전송 코딩)을 사용하면 Content-Length를 사용하면 X

### 협상

클라이언트와 서버가 있을때 클라이언트가 원하는 표현으로 달라고 서버한테 요청 그럼 클라이언트가 원하는 우선순위에 맞춰서 표현데이터를 만들어줌.

- Accept: 클라이언트가 선호하는 **미디어 타입**을 서버한테 달라고하는것
- Accept-Charset: 클라이언트가 선호하는 **문자 인코딩**을 서버한테 달라고 하는것
- Accept-Encoding: 클라이언트가 선호하는 **압축 인코딩**을 서버한테 달라고 하는것
- Accept-Language: 클라이언트가 선호하는 **자연 언어**을 서버한테 달라고 하는것

**협상 헤더는 요청시에만 사용**

- 일단 Accecpt-Language: ko 면 한국어 로 요청하고 받게 된다. 

  > **그런데 만약?**  한국어는 없고 **디폴트로 정해있는 언어(( ja 일어 )  +  2번 째로 지원하는 언어(en 영어) **가 있는 상태에서 ko로 요청하면 **디폴트로 정해져있는 언어(ja)**가 나오게 된다. 이럴때 **2번째로 원하는 언어(en)**로 나오게 하기 위해서 필요한것이 **협상 우선순위**이다

**협상 우선순위**
Quality Values(q)

`Accecpt-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7`

- 0 ~ 1, 클수록 높은 우선 순위

- 생략하면 1

  > ko-kR 의 경우가 생략 되서 1이다.

- 순서대로 나열해보면 아래의 우선순위로 된다.

  1. ko-KR
  2. ko
  3. en-US
  4. en

  > 위 우선 순위로 아까 했던 것을 영어로 나오게 해보려면
  >
  > **`Accecpt-Language: ko-KR,ko;q=0.9,en;q=0.8` **로 하게 되면 **일어 대신 영어로 나오게 된다.**
  
- 구체적인 것이 우선한다. 디테일 하게 적은것이 우선

  - `Accept: text/*, text/plain, text/plain;format=flowed, */*` 작성되었을때 우선순위를 보게 되면 
    1. text/plain;format=flowed
    2. text/plain
    3. text/*
    4. */*

- 구체적인 것을 기준으로 미디어 타입을 맞춘다.

  - `Accept: text/*;q=0.3, text/html;q=0.7, text/html;level=1,text/html;level=2;q=0.4,*/*;q=0.5`

    - |    Media Type     | Quality |
      | :---------------: | ------- |
      | text/html;level=1 | 1       |
      |     text/html     | 0.7     |
      |    text/plain     | 0.3     |
      |    image/jpeg     | 0.5     |
      | text/html;level=2 | 0.4     |
      | text/html;level=3 | 0.7     |

  ### 전송 방식

4가지로 나뉘어 진다.

- 단순 전송

  요청을 하면 응답을 줌

  `Content-Length` 를 주면 됨

- 압축 전송

  압축해서 전송하는것

  `Content-Encoding` 으로 어떤것으로 압축되어있는지

- 분할 전송

  쪼개서 보낸다고 생각.

  `Trasfer-Encoding` 

  `Content-Length` 를 넣으면 안됨 

- 범위 전송

  특정 범위만큼 요청 하고 그 범위만큼 받음.

  `Range`

  `Content-Range` 

### 일반 정보

단순한 정보성 헤더들이다

- From

  유저 에이전트의 이메일 정보

  - 일반적으로 잘 사용 X
  - 검색 엔진 같은 곳에서 주로 사용
  - 요청에서 사용

- Referer

  이전 웹 페이지 주소

  - 현재 요청된 페이지의 이전 웹 페이지의 주소
  - A 에서 B 로 이동하는 경우 B를 요청할 때 Referer: A를 포함해서 요청
  - 요청에서 사용

- User-Agent

  유저 에이전트 애플리케이션 정보

  - 클라이언트의 애플리케이션 정보 (웹 브라우저 정보, 등)
  - 통계 정보
  - **어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능**
  - 요청에서 사용

- Server

  요청을 처리하는 ORIGIN 서버의 소프트웨어 정보

   ORIGIN 서버 : 요청의 마지막으로 해주는 서버

  - 응답에서 사용

- Date

  메시지가 발생한 날짜와 시간

  - 응답에서 사용

### 특별한 정보

- Host

  요청한 호스트 정보(도메인)

  ```http
  GET /hello HTTP/1.1
  Host: aaa.com
  ```

  > 호스트가 어디에 들어가는지 위 경우는 aaa.com으로감

  - 요청에서 사용
  - **필수**
  - 하나의 서버가 여러 도메인을 처리해야 할 때
  - 하나의 IP주소에 여러 도메인이 적용되어 있을 때

- Location

  페이지 리다이렉션

  - 웹 브라우저는 3xx 응답의 결과에 Location 헤더가 있으면, Location 위치로 자동 이동(리다이렉션)
  - 201 (Created): Location 값은 요청에 의해 생성된 리소스 URI
  - 3xx (Redirection): Location 값은 요청을 자동으로 리다이렉션하기 위한 대상 리소스를 가리킴 

- Allow

  허용 가능한 HTTP 메서드

  - 405 (Method Not Allowed) 에서 응답에 포함해야함
  - Allow: GET, HEAD, PUT

- Retry-After

  유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간

  - 503 (Service Unavailable): 서비스가 언제까지 불능인지 알려줄 수 있음

### 인증

- Authorization

  클라이언트 인증 정보를 서버에 전달

  - Authorization : Basic xxxxxxxxxxxxxxx

- WWW-Authenticate

  리소스 접근시 필요한 인증 방법 정의

  401 Unauthorized 응답과 함께 사용

### 쿠키

- 사용처
  - 사용자 로그인 세션 관리
  - 광고 정보 트래킹
- 쿠키 정보는 항상 서버에 전송됨
  - 네트워크 트래픽 추가 유발
  - 최소한의 정보만 사용(세션 id, 인증 토큰)
  - 서버에 전송하지 않고, 웹 브라우저 내부에 데이터를 저장하고 싶으면 웹 스토리지 참고
- **주의**
  - 보안에 민감한 데이터는 저장하면 안됨(주민번호, 신용카드 번호 등)

- Set-Cookie

  - `expires` 

    만료일이 되면 쿠키 삭제

    `Set-Cookie: expires=Sat, 26-Dec-2020 04:39:21 GMT`

  - `max-age`

    0이나 음수를 지정하면 쿠키 삭제

    `Set-Cookie: max-age=3600` 3600초

  세션 쿠키

  - 만료 날짜를 생략하면 브라우저 종료시 까지만 유지

  영속 쿠키

  - 만료 날짜를 입력하면 해당 날짜까지 유지

- 도메인

  - **명시: 명시한 문서 기준 도메인 + 서브 도메인 포함**
    - `domain=example.org`를 지정해서 쿠키 생성
      - example.org , dev.example.org 도 쿠키 접근
  - **생략: 현재 문서 기준 도메인만 적용**
    - example.org 에서 쿠키를 생성하고 domain 지정을 생략
      - example.org 에서만 쿠키 접근
      - dev.example.org는 미접근

- 경로

  - `path=/home` 으로 하면 이 경로를 포함한 하위 경로 페이지만 쿠키 접근
    - /home -> O
    - /home/level1 -> O
    - /home/level1/level2 -> O
    - /hello -> X
  - **일반적으로 path=/ 루트로 지정**

- 보안
  - Secure
    - 쿠키는 http, https를 구분하지 않고 전송
    - Secure를 적용하면 https인 경우에만 전송
  - HttpOnly
    - XSS 공격 방지
    - 자바스크립트에서 접근 불가
    - HTTP 전송에서만 사용
  - SameSite  
    - XSRF 공격 방지
    - 현재 내가 요청하는 도메인과 쿠키에 설정된 도메인이 같은경우에만 쿠키를 전송

---

[**출처**]

[**모든 개발자를 위한 HTTP 웹 기본 지식(인프런)**](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

