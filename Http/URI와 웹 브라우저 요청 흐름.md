### URI

**통합 자원 식별자**(Uniform Resource Identifier, **URI**)는 인터넷에 있는 자원을 나타내는 유일한 주소이다.

- **U**niform : 리소스 식별하는 통일된 방식
- **R**esource : 자원 , URI로 식별할 수 있는 모든 것(제한 X)
- **I**dentifier : 다른 항목과 구분하는데 필요한 정보

URI? URL? URN?

- URI 는 로케이터(**I**ocator), 이름(**n**ame) 또는 둘다 추가로 분류 될수 있다.

  - URL(Resouce **Locator**)
    - Locator : 리소스가 있는 위치를 지정
  - URN(Resouce **Name**) 이름
    - Name : 리소스에 이름을 부여
  - **위치는 변할수 있지만, 이름은 변하지 않는다.**

- ![image-20211015205448799](https://user-images.githubusercontent.com/45530877/137488001-ddb248c1-de07-45be-b273-0a17cbae3ebd.png)

  [이미지 출처 위키 백과](https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EC%9E%90%EC%9B%90_%EC%8B%9D%EB%B3%84%EC%9E%90)

  - 웹브라우저 에서 적는 첫번째 방식이 URL
  - URN은 이름을 부여
    - **이름을 부여하면 찾는게 어렵다**

  **URL** 문법

  ` scheme:[//[user[:password]@]host[:port]][/path][?query][#fragment]`

  - scheme

    - 주로 프로토콜 사용

    - 프로토콜: 어떤 방식으로 자원에 접근할 것인가 하는 약속 규칙

      - ex) http, https, ftp 등

    - http는 80 포트, https는 443 포트를 주로 사용 (포트는 생략 가능)

    - https는 http에 보안 추가 (HTTP Secure)

      > 그냥 간단하게 보면 https는 HTTP의 보안이 강화된 버전이라고 보면 된다.
      >
      > 그리고 위키에 아래와 같이 작성되어있다.
      >
      > - HTTPS는 통신의 인증과 암호화를 위해 만들어졌으며 **전자 상거래**에서 널리 쓰인다고 한다.
      > - HTTPS는 소켓 통신에서 일반 텍스트를 이용하는 대신에, [SSL](https://ko.wikipedia.org/wiki/SSL)이나 [TLS](https://ko.wikipedia.org/wiki/트랜스포트_레이어_보안) 프로토콜을 통해 [세션](https://en.wikipedia.org/wiki/Session_(computer_science)) 데이터를 암호화한다. 따라서 데이터의 적절한 보호를 보장한다.  
      > - HTTPS의 기본 [TCP/IP](https://ko.wikipedia.org/wiki/TCP/IP) 포트는 443이다.

  - `host`

    - 호스트 명
    - 도메인명 또는 IP 주소를 직접 사용 가능.

  - `PORT`

    - 포트
    - 접속 포트
    - 일반적으로 생략 가능

  - `path`

    - 리소스 경로, 계층적 구조로 되어있다.

  - `query`

    - key=value 형태
    - ?로 시작, &로 추가 가능 ?keyA=valueA&keyB=valueB
    - query parameter, query string 등으로 불림, 웹서버에 제공하는파라미터, 문자 형태

  - `fragment`

    - html 내부 북마크 등에 사용
    - **서버에 전송하는 정보 아님**

### 웹 브라우저 요청 흐름

**클라이언트 -> 서버**

URL을 입력 -> DNS에서 이 해당 URL에 IP 주소를 획득해서 HTTP 요청 메시지를 생성 -> SOCKET 라이브러리를 통해 특정 서버랑 연결 -> 데이터를 전달 -> TCP/IP 에서 패킷을 생성(여기에는 IP포트 정보가 들어가있음) ->  서버한테 요청 패킷을 전달

**서버 -> 클라이언트**

서버가 받음(TCP/IP 패킷 말고 그 안에 있는 HTTP 메시지를 해석) -> 서버에서 HTTP 응답 메시지를 생성 -> 똑같이 TCP/IP 패킷을 생성 -> 클라이언트에 전달 -> 클라이언트에서 TCP/IP 패킷 안에 있는 HTTP 메시지를 보게됨.

---

**[출처]**

[**URI**](https://ko.wikipedia.org/wiki/%ED%86%B5%ED%95%A9_%EC%9E%90%EC%9B%90_%EC%8B%9D%EB%B3%84%EC%9E%90)

[**모든 개발자를 위한 HTTP 웹 기본 지식(인프런)**](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)

