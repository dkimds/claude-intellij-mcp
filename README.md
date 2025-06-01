# claude-intellij-mcp
구름 프로펙트 풀스택 과정 2기 1조

## 개요
[OpenAI API 기반으로 암호화폐 모의투자를 도와주는 챗봇](https://github.com/CleanEngine/cleanengine-ai)의 임시 화면

### 프롬프트
```md
# 역할
너는 숙련된 백엔드 개발자야. 내가 요청한 기능에 맞게 Kotlin + Spring Boot 기반의 코드를 인텔리제이 demo 프로젝트에 작성해줘.
# 기술 스택
Spring Boot 3.4.5, Spring Web, Tymeleaf, WebClient
# 요구사항
1. 사용자가 질문을 입력할 수 있는 웹 UI를 제공한다.
   * 단일 입력창(text field)과 제출 버튼(Form 방식)
   * 제출 시 FastAPI 서버의 /async/chat 엔드포인트로 요청을 보낸다 (GET 방식)
2. FastAPI로부터 받은 응답 텍스트를 같은 화면에 출력한다.
3. ChatRequestDto, ChatResponseDto를 포함해, DTO / Service / Controller를 계층적으로 분리한다.
4. 서비스 클래스에서 WebClient를 사용해 FastAPI 서버와 통신한다.
5. 응답이 도착하면 Thymeleaf 템플릿에서 결과를 보여준다.
6. HTML과 Kotlin 코드 모두 간결한 챗봇 대화 시연에 초점을 맞춘다.
```

## 사용법
1. [스프링 이니셜라이저](https://start.spring.io/)로 설정
    * 프로젝트: Gradle - Kotlin
    * 언어: Kotlin
    * 스프링부트: 3.5.0
    * 패키징: Jar
    * Java: 21
1. 인텔리제이로 열기
1. 클로드 데스크탑 실행
1. 프롬프트 입력
1. 수정 및 추가 사항 입력
```md
# 수정사항
인텔리제이 demo 프로젝트의 화면구성을 바꾸고 싶어. 클로드처럼 다음과 같은 기능이 들어가면 좋겠어
* 입력창은 화면 하단에 위치
* 대화기록이 쌓여서 오래된 내용은 위로 올라감 
* 답변마다 복사하는 기능을 가진 버튼 추가
```

## ETC
### 한계점
기능 최소 구현 수준으로 정적 오류 또는 누락 가능성이 있고, 테스트 및 예외처리 미비 
### 개선점
* 코드 리팩토링 및 정리

    * 불필요한 중복, 과도한 추상화, 네이밍 문제 등을 리팩토링.

* 단위 테스트 및 예외처리 추가

    * JUnit 또는 IntelliJ Test Framework를 이용해 테스트 코드와 예외 처리 로직을 추가.