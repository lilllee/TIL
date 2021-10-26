### HTTP API 설계 

POST 기반 등록 으로 할때 특징

- 클라이언트는 등록될 리소스의 URI를 모른다.

- 서버가 새로 등록된 리소스 URI를 생성해줌.

  > POST로 보내면 서버가 /members/100 이런식으로 URI를 만들어줌

- 컬렉션

  - 서버가 관리하는 리소스 디렉토리
  - 서버가 리소스의 URI를 생성하고 관리
  - **여기서 컬렉션은 /members**

PUT 으로 파일 기반

- 클라이언트가 리소스 URI를 알고 있어야한다.

  - 파일을 등록을 할때 예를 들어 **/files** 가 있으면  **/files/{filename}** 을 붙여줘서 해야한다.

    > 이 /file/{filename} URI를 클라이언트가 식별

- 클라이언트가 직접 리소스의 URI를 지정한다.

  - 클라이언트가 생성된 리소스의 URI 를 알고 관리함. 

    > POST는 그냥 보내기만 하고 서버에서 리소스의 URI를 만들어서 보내지만 PUT은 직접 리소스 URI를 알고 등록해야함.

- 스토어

  - 클라이언트가 관리하는 리소스 저장소
  - 클라이언트가 리소스의 URI를 알고 관리
  - **여기서 스토어는 /files**

> 둘중의 POST 기반의 컬렉션을 많이 쓴다.

HTML FORM 사용

- HTML FORM은 **GET, POST만 지원**
- AJAX 같은 기술을 사용해서 해결 가능

컨트롤 URI

- 문서, 컬렉션, 스토어로 해결하기 어려운 추가 프로세스 실행
- 동사를 직접 사용
- ex) /members/{id}/delete      (edit, new)

> 맨처음에 리소스를 생각하고(ex) members) 거기에 맞게 설계(GET, POST,등)를 하고 그걸가지고 해결이 안되는 상황일때 컨트롤 URI 사용

---

**[출처]**

[**모든 개발자를 위한 HTTP 웹 기본 지식(인프런)**](https://www.inflearn.com/course/http-%EC%9B%B9-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC/dashboard)





