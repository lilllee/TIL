### @RestController

- html 파일이 아니라 data를 return 해주는 Controller

  >위에 있는 user의 return 값은 **java 오브젝트**다. 하지만 요청을 받는것은 **웹브라우저** (html, js 를 받겠지?)
  >
  >그런데 어떻게 java 오브젝트가 웹 브라우저에 응답에 요청이 될수 있는것인가 그에 대한 답은 json으로 변환 시키면 된다.
  >
  >그 json 파일로 변환 시켜주는 것은 **스프링 부트에 있는 MessageConverter 라는 애다.**
  >
  >플로우는 아래와 같다.
  >
  >user return 하게 되면 -> MessageConverter가 Jackson 라이브러리를 호출 -> user 를 json 파일로 변환해서 준다.

  ![image-20211111192841677](C:\Users\kopqw\AppData\Roaming\Typora\typora-user-images\image-20211111192841677.png)

