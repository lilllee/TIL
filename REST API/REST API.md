RESTful  을 알아보기전에 공부한 내용입니다.

**아래 글은 해당 영상을 보고 작성했습니다.**

[그런 RESTT API로 괜찮은가](https://www.youtube.com/watch?v=RP_f5dMoHFc)

---

REST API

REST의 약자는 (REpresentational State Transfer)

Q : 어떻게 인터넷에서 정보를 공유할 것인가?

​	A : 정보들을 하이퍼텍스트로 연결 한다 

- HTML : 정보를 표현하고  
- URL : 그 정보를 식별하고
- HTTP :  정보를 전송하는 HTTP 프로토콜을 만들어냄

그럼  HTTP를 고치면 웹이 깨질꺼같은 고민에서 나온 것이

HTTP Object Model 후에 REST 발표를 하게된다.

---

REST API

- REST 아키텍쳐 스타일을 따르는 API

REST 

- 분산 하이퍼미디어 시스템 (ex: 웹)을 위한 아키텍쳐 스타일

아키텍쳐 스타일

- 제약조건의 집합

**제약 조건들을 모두 따라야만 REST를 지킨다라고 할수있다**

그러면 REST를 구성하는 스타일에는 

- client-server
- stateless
- cache
- **uniform interface**
- layered system
- code-on-demand (optional) 

현재는 HTTP만 잘 따라도 대체로 (client-server , stateless , cache , layered system) 따를수 있다.

code-on-demand (optional) 의 경우에는 서버에서 코드를 클라이언트로 보내서 실행할수 있어야한다 가 code-on-demand다.

그런데 이중에 단 하나 **uniform interface** 는 잘 만족을 못한다고 한다.

### **uniform interface** 

uniform interface 의 제약 조건은 총 4가지다.

- identification of resources 
  - 리소스가 uri를 식별하면 된다.
- manipulation of resources through representations
  - 리소스를 만들거나 업데이트 삭제할때 http message 에다가 표현을 담아서 전송을해서 달성하는것.

---

거의 예외없이 아래의 2가지 조건은 지키지 못하고 있다.

- **self-descriptive messages**

  - 메시지는 스스로를 설명해야 한다.

    ```html
    GET / HTTP/1.1
    ```

    - 이 HTTP 요청 메시지는 목적지 빠져있어서 self-descriptive 하지 못하다.

    ```html
    GET / HTTP/1.1
    HOST: www.example.org
    ```

    - 목적지를 추가하면 이제 self-descriptive

    ```json
    HTTP/1.1 200 OK
    [ { "op" : "remove", "path": "/a/b/c" }]
    ```

    - 위 사항은 어떤 문법으로 작성된건지 모르기때문에 해석을 할수가 없다.

    ```json
    HTTP/1.1 200 OK
    Content-Type: application/json
    [ { "op" : "remove", "path": "/a/b/c" }]
    ```

    - Content-Type 헤더가 들어가야한다 . json 으로 되어있는것을 보면 해석을 할수 있다. **하지만** op 는 뭐고 path는 뭘 가르키는건데?

    ```json
    HTTP/1.1 200 OK
    Content-Type: application/json-patch+json
    [ { "op" : "remove", "path": "/a/b/c" }]
    ```

    - 이렇게 해야 완벽해진다.

  - **messages 의 내용으로 온전히 해석이 가능해야 한다.**

    

- **hypermedia as the engine of application state (HATEOAS)**

  애플리케이션의 상태는 **Hyperlink를 통해서 전이**가 되어야 한다.

  ```html
  HTTP/1.1 200 OK
  Content-Type: text/html
  
  <html>
  <head></head>
  <body><a href="/test">test</a></body>
  </html>
  ```

  HTML 같은 경우를 보면 HATEOAS를 만족하게 되는데  `a`태그를 통해서 Hyperlink 가 나와있고 Hyperlink를 통해서 그 다음상태로 전이 되기 떄문에 만족하게 된다.

---

### **uniform interface** 필요한 이유

독립적인 진화

- 서버와 클라이언트가 각각 독립적으로 진화한다.
- **서버의 기능이 변경(새로운 API 추가 , 기존 API 변경 , 삭제 uri 등) 되어도 클라이언트가 업데이트를 할 필요가 X**
- REST를 만들게 된 계기

실제로 REST를 잘 지키고 있는 사례는 **웹이다**

> 위에 내용들을 듣고 생각 해보니까 무슨소리인지 이해가 됬다. 왜냐하면 내가 특정 페이지에 뭐가 바뀌던 브라우저는 업데이트를 하지 않았으니까.

**상호운용성에 대한 집착**

> 결론 : 진짜 대단하신 분들이 많은거 같다.

---

**REST API가 REST의 제약조건들을 다 지켜야 하나?**

**하이퍼텍스트를 포함한 self-descriptive한 메시지의 uniform interface를 통해 리소스에 접근하는 API **라고 한다.

> 지키라는 거임.

---

### API는 왜 REST가 잘안되나?

|              | 흔한 웹 페이지 | HHTP API                        |
| ------------ | -------------- | ------------------------------- |
| Protocol     | HTTP           | HTTP                            |
| 커뮤니케이션 | 사람 - 기계    | **기계 - 기계**                 |
| Media Type   | HTML           | **JSON** (기계가 이해할수 있는) |

> 그럼 JSON 떄문에???

**HTML , JSON 비교**

|                  | HTML           | JSON              |
| ---------------- | -------------- | ----------------- |
| Hyperlink        | 됨 (a 태그 등) | 정의되어있지 않음 |
| Self-descriptive | 됨 (HTML 명세) | 불완전*           |

불완전하다는 것

- 적어도 문법은 정의가 되어있음.
- **하지만 그 안에 들어가는 값들이 어떠한 의미를 가져야 한다는것은 정의가 안되어있다.**

**문법 해석은 가능하지만, 의미를 해석하려면 별도로 문서가(API 문서 등) 필요하다.**

**HTML**

```html
GET /todos HTTP/1.1
HOST: example.org

HTTP/1.1 200 OK
Content-Type: text/html

<html>
<body>
<a href="https://todos/1" 회사 가기 </a>
<a href="https://todos/2" 집에 가기 </a>
</body>
</html>
```

Self-descriptive

1. Content-Type 이 text/html 이니까 media type 은 text/html 확인가능.
2. HTTP 명세에 media type은 IANA에 등록 되어있으므로 IANA에서 text/html의 설명을 찾고
3. IANA에  text/html 명세는 http://www.w3.org/TR/html 로 찾아가서 그 명세를 해석한다.
4. 그 명세에는 모든 태그의 해석방법이 구체적으로 나와있음.

HATEOAS

- a 태그를 통해 표현된 링크로 다음 상태로 전이될수 있음.

**JSON**

```json
GET /todos HTTP/1.1
HOST: example.org

HTTP/1.1 200 OK
Content-Type: application/json

[
	{"id": 1, "title" : "회사 가기"},
	{"id": 2, "title" : "집에 가기"}
]
```

Self-descriptive

1. Content-Type 이 application/json 이니까 media type은 application/json 확인 가능.
2. IANA에서 application/json의 설명을 찾아보면
3. application/json 명세는 draft-ietf-jsonbis-rfc7159bis-04 이므로 명세를 찾아가서 해석
4. 명세에 json 문서를 파싱하는 방법이 명시되어 있으므로 성공적으로 파싱 **하지만 "id"가 무엇을 의미하고, "title"이 무엇을 의미하는지 알 방법은 X** -> **FAIL**

HATEOAS

- 다음 상태로 전이할 링크가 없다 -> **FAIL**

---

### 그러면 위 둘의 제약 조건은 어떻게 독립적 진화에 도움이 될까?

**Self-descriptive**

확장 가능한 커뮤니케이션을 가능하게 한다.

- 서버가 변하거나 클라이언트가 변해도 메시지는 **언제나 메시지만 가지고 해석이 가능** 하다.

**HATEOAS**

애플리케이션 상태 전이의 late binding

- 링크를 마음대로 바꿀수 있는것을 의미한다.