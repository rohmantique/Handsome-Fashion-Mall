
## 💡 서비스 소개

**더한섬몰 모바일 클론코딩**

> 현대백화점그룹의 더한섬몰 모바일 서비스 클론 코딩 프로젝트입니다.<br>
패션 애플리케이션처럼 ‘더한섬닷컴’을 모바일 웹뷰로 클론 코딩해 29CM, 무신사, WConcept, 지그재그와 같은 최근 패션 애플리케이션 서비스를 분석했습니다.


## 🛠️ 기술 스택
<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">  
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/springSecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"> 
  <img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> 
  <img src="https://img.shields.io/badge/NGINX-009639?style=for-the-badge&logo=nginx&logoColor=white"> 
  <br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black"> 
  <img src="https://img.shields.io/badge/ReactRouter-CA4245?style=for-the-badge&logo=reactrouter&logoColor=white">
  <img src="https://img.shields.io/badge/openid-F78C40?style=for-the-badge&logo=openid&logoColor=white">
  <br>

  <img src="https://img.shields.io/badge/gitlab-FC6D26?style=for-the-badge&logo=gitlab&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/notion-CA4245?style=for-the-badge&logo=notion&logoColor=white">
  <br>
</div>

<details>
<summary>상세 기술스택 및 버전</summary>

| 구분 | 기술스택 | 상세 | 버전 |
| --- | --- | --- | --- |
| 공통 | 형상관리 | Github | - |
|  | 이슈관리 | Jira | - |
|  | 커뮤니케이션 | Slack, Confluence, Notion | - |
| Front-end | HTML5 |  | - |
|  | CSS3 |  | - |
|  | JavaScript(ES6) |  | - |
|  | JSP |  | - |
|  | IDE | Eclipse | 1.69.2 |
| Back-end | Java | JDK | 1.8.0_192 |
|  | SpringBoot | springboot | 2.7.8 |
|  |  | Maven | - |
|  |  | Thymeleaf | 7.5 |
|  |  | SpringSecurity | - |
|  |  | querydsl | - |
|  |  | MyBatis | 2.1.4 |
|  | API관리 | Swagger | 2.9.2 |
|  | jsonwebtoken |  | 1.1.1 |
|  | DB | Oracle | 8.0.30-0ubuntu0.20.04.2 |
|  | IDE | Eclipse | - |
|</details>||||

## 🗃️ 프로젝트 구조

### 📂 디렉토리 구조

![폴더구조2.PNG](README.assets/폴더구조2.PNG-1686318436892-7.png)


## 🔗****Database Modeling****

![더한섬_erd3](README.assets/더한섬_erd1.png)

![더한섬_erd2](README.assets/더한섬_erd2.png)

![더한섬_erd3](README.assets/더한섬_erd3-1686317646857-4.png)

## 💻 주요 기능 및 스크린 샷

### **상품**

- 패션 아이템을 대분류-중분류-소분류 총 3개의 카테고리로 나누어 조회할 수 있습니다.
- 별도의 페이지 넘김 없이 무한 스크롤을 통해 상품을 계속 조회할 수 있습니다.
- 상품에 대한 리뷰를 작성할 수 있고, 이미지 첨부와 별점 평가가 가능합니다.

![상품 세부](README.assets/상품 세부.png)

![카테고리 목록](README.assets/카테고리 목록.png)

![상품 정렬](README.assets/상품 정렬.png)

### **회원관리**

- 회원가입시 입력했던 이메일을 통해 비밀번호 재설정 링크를 받을 수 있으며, 비밀번호를 비롯한 회원정보 수정이 가능합니다.
- 모바일 특성상 버튼 선택 없이 실시간 아이디 중복 확인이 가능합니다.
- 회원가입 및 로그인 여부에 따라 접근할 수 있는 페이지가 제한되어 있습니다.
- 마이페이지에서 주문한 내역과 상품 정보를 조회할 수 있습니다.

![모아존-파티-만들기_파티-검색.gif](ReadMe%208118f36887da4163b0ce9d919fa5ba90/%25EB%25AA%25A8%25EC%2595%2584%25EC%25A1%25B4-%25ED%258C%258C%25ED%258B%25B0-%25EB%25A7%258C%25EB%2593%25A4%25EA%25B8%25B0_%25ED%258C%258C%25ED%258B%25B0-%25EA%25B2%2580%25EC%2583%2589.gif)

### **장바구니 및 결제**

- 장바구니에서 상품의 수량 변경이 가능합니다.
- 카카오페이/신용카드 결제가 가능합니다.

![마이페이지.gif](ReadMe%208118f36887da4163b0ce9d919fa5ba90/%25EB%25A7%2588%25EC%259D%25B4%25ED%258E%2598%25EC%259D%25B4%25EC%25A7%2580.gif)

## 🗣️ 협업 관리

**Notion**

![Untitled](ReadMe%208118f36887da4163b0ce9d919fa5ba90/Untitled%204.png)

## 👩‍👩‍👧 개발 멤버 소개

![Untitled](ReadMe%208118f36887da4163b0ce9d919fa5ba90/Untitled%205.png)

## 📅 프로젝트 기간

### 22.07.05 ~ 22.08.19

- **기획 및 설계** : 23.02.06 ~ 23.02.07
- **프로젝트 구현** : 23.02.07 ~ 23.02.14
- **버그 수정 및 산출물 정리** : 23.02.15 ~ 23.02.15

## 📄 프로젝트 관련 문서

| 구분 | 링크 |
| --- | --- |
| 기능 정의서 | [기능 정의서 보러 가기](https://docs.google.com/spreadsheets/d/1WfJoLFtwinLhnWlKR11bC-UEMn59IrG46p22vAHViIw/edit#gid=1408271660)|
| 와이어 프레임(디자인) | [와이어프레임 보러 가기](https://www.figma.com/file/Zrl14ZgPRxZdzvOj1vSIpC/STEAMMOA-Proto-Type?node-id=0%3A1) |
| API 정의서 | [API 정의서 보러 가기](https://www.notion.so/a8af2ba49b1b47f5b281d92ba527af9a) |
| 발표 자료 | [발표 자료 보러 가기](https://github.com/rohmantique/STEAM-MOA/blob/master/Presentation/%EC%84%9C%EC%9A%B8_3%EB%B0%98_A303_%EB%B0%9C%ED%91%9C%EC%9E%90%EB%A3%8C.pdf) |
