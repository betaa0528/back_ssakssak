# 🙋‍♂️체험형 금융 교육 플랫폼 금융싹싹🙋‍♀️
<p align="center">
<img src="https://github.com/user-attachments/assets/87f7d526-ce00-4f43-b36e-a6100c763109" width="600" height="700">\
</p>
<ul>
  <li>배포 URL : <a href="http://ssakssak.shop">ssakssak.shop</a></li>
  <li>선생님 test 계정 ID : kimc / PW : 1212</li>
  <li>학생 test 계정 ID : minjup / PW : 1212</li>
</ul>

<div>

# 기술 스택

#### 1. **백엔드**: Java, Spring Boot, Spring Batch, Spring Security, MyBatis, MySQL, JUnit

#### 2. **프론트엔드**: JavaScript, Vue.js, Chart.js, ApexCharts.js

#### 3. **서버 및 배포**: Nginx, EC2 (AWS), SSE (Server-Sent Events), GitHub Actions (CI/CD 및 배포 자동화)

#### 4. **협업 툴**: Figma, Notion

</div>

# 프로젝트 소개
<ul>
  <li>프로젝트 명 : 금융싹싹</li>
  <li>개요 : 많은 사람들이 금융 교육의 중요성을 인식하고 있지만, 실제로 이를 체험하며 배우는 기회는 부족한 현실입니다. 이러한 문제를 해결하고자, 금융싹싹 플랫폼은 사용자가 은행, 주식, 물건 구매, 세금 등의 실제 금융 활동을 체험하면서 배울 수 있도록 설계되었습니다. 이 플랫폼은 학생들이 금융 관리 능력을 키우는 데 도움을 주며, 실제 경제 상황을 기반으로 한 실습을 제공합니다.</li>
</ul>

# 서비스 아키텍처
![Image](https://github.com/user-attachments/assets/ad3144d1-a5fb-414d-9057-202950430ff8)

# 주요 기능

## 학생 기능

- **예금 및 적금 가입**  
  학생은 **은행**에서 **예금**과 **적금** 상품을 가입하고, **정해진 날짜마다 입금**하며 **이자**를 지급받습니다.  
  예금과 적금의 차이점을 경험하며, 각 상품에 맞는 조건을 체험할 수 있습니다.
  <div style="display: flex; justify-content: space-between;">
    <div style="flex: 1; padding-right: 10px;">
      <img src="https://github.com/user-attachments/assets/5c6aa4cd-3a73-450e-9ea8-4ff9d83f6e90" style="max-width: 100%; height: auto;">
      <p><small>학생이 예금을 가입하는 화면</small></p>
    </div>
    <div style="flex: 1; padding-left: 10px;">
      <img src="https://github.com/user-attachments/assets/cd4121fd-7bd1-4d84-95ad-5beec9a47082" style="max-width: 100%; height: auto;">
      <p><small>예금 상품에 대한 정보 및 조건</small></p>
    </div>
  </div>

- **매점**  
  **선생님**이 등록한 **학교에서 사용할 수 있는 쿠폰**을 구매할 수 있습니다.
  
  ![Image](https://github.com/user-attachments/assets/65871b9f-f526-4d48-8a87-03754e20a777)
   



- **이벤트**  
  매일 달라지는 **금융 퀴즈**와 **금융 성향 테스트**를 통해 학생들의 금융 이해도를 평가합니다.  
  **Seed(가상화폐) 랭킹**을 통해 학생들의 성과를 관리하고, 게임적 요소를 추가하여 재미있게 금융을 배울 수 있습니다.

  <div style="display: flex; justify-content: space-between;">
    <div style="flex: 1; padding-right: 10px;">
      <img src="https://github.com/user-attachments/assets/e5cb91b7-aaea-4347-b42d-d2cc20f43287" style="max-width: 100%; height: auto;">
      <p><small>이벤트 페이지 화면</small></p>
    </div>
    <div style="flex: 1; padding-left: 10px;">
      <img src="https://github.com/user-attachments/assets/369066e6-da39-48a7-a096-e403335069b2" style="max-width: 100%; height: auto;">
      <p><small>소비 성향 검사</small></p>
    </div>
  </div>


- **주식**  
  **가상 회사**의 주식을 **매매**할 수 있으며, **수익률**과 **주식 현황**을 실시간으로 확인할 수 있습니다.
  
  ![Image](https://github.com/user-attachments/assets/9cbb2add-5696-485d-9faf-41d0cddff363)


---

## 선생님 기능

- **학급 관리**  
  **CSV 파일**을 사용하여 초기 **학생 정보**를 **간단하게 입력**할 수 있습니다.
  
  ![Image](https://github.com/user-attachments/assets/d4e5b2da-14c6-479d-8a26-83f83654e166)

- **학생 관리**  
  학생들을 **등록**하고, 각 학생의 **직업**을 관리할 수 있습니다.  
  **새로운 학생 등록**이 가능하며, **학생 프로필**을 쉽게 관리할 수 있습니다.
  
  ![Image](https://github.com/user-attachments/assets/a66cbb74-4376-40ff-a69b-bea7d5564717)


- **매점 관리**  
  **매점 상품**을 등록하고, **상품 등록 내역**을 확인할 수 있습니다.
  
  ![Image](https://github.com/user-attachments/assets/d3a65742-bb0d-4d60-a88e-36de192ef095)

- **은행 관리**  
  **예적금 상품**을 **추가**하거나 **삭제**할 수 있는 관리 기능을 제공합니다.
  
  ![Image](https://github.com/user-attachments/assets/67b6f169-627e-426d-8eea-b6852312bc0e)

- **주식 관리**  
  **주식 뉴스**와 **주식 등락률**을 관리하여 학생들이 주식 관련 정보를 쉽게 접할 수 있도록 합니다.
  
  ![Image](https://github.com/user-attachments/assets/067dde20-a186-46a4-b77c-c81977fa8f1c)

- **리워드 관리**  
  **이벤트**나 **칭찬**을 통해 학생에게 **Seed**를 **추가적으로 지급**할 수 있는 기능을 제공합니다.
  
  ![Image](https://github.com/user-attachments/assets/42d16d4e-7f1b-4f70-b725-706a99c9ba3c)

# 코딩 컨벤션

### 백엔드
- 네이밍 규칙: 변수 및 메소드명은 카멜케이스를 사용하여 일관되게 작성합니다. 예를 들어, `userName, getUserInfo()`와 같이 작성하여 가독성을 높이고 코드의 일관성을 유지
- Mapper 인터페이스: MyBatis의 Mapper 인터페이스에서는 SQL 문을 명확하게 나타내기 위해 메소드 이름을 **select**로 시작하여 쿼리의 목적을 분명하게 했습니다. 예를 들어, `selectUserById(), selectAllUsers()`와 같은 명확한 이름을 사용합니다.
- 서비스 로직: 서비스 레이어에서 데이터 조회 메소드는 **get**으로 시작하여, 데이터를 조회하는 메소드임을 명확히 하였습니다. 예를 들어, `getUserDetails(), getAllProducts()`와 같이 사용합니다.

### 프론트엔드
- 파일 및 폴더 네이밍 규칙: 페이지에 해당하는 파일은 page를 접미어로 사용하여 파일 이름을 명확하게 구분하였습니다. 예를 들어, `HomePage.vue`, `LoginPage.vue`와 같이 사용합니다.
- 컴포넌트는 기능에 따라 폴더로 관리하며, 각 컴포넌트의 역할을 명확히 하기 위해 폴더 및 파일 이름을 구체적으로 작성합니다. 예를 들어, components/auth/ 폴더에 로그인 관련 컴포넌트를 관리하는 방식입니다.
- 스타일링: CSS 또는 SCSS 파일은 BEM(Block Element Modifier) 규칙을 따르며, 컴포넌트에 맞게 스타일을 작성합니다. 각 컴포넌트의 스타일은 해당 컴포넌트와 모듈화하여 관리하며, 글로벌 스타일은 assets/styles/ 디렉토리에서 관리합니다.

# Git Flow

### 브랜치 전략
GitHub 프로젝트 보드와 이슈 번호를 기준으로 각 기능별 브랜치를 생성합니다. 각 브랜치에는 이슈 번호와 기능 이름을 포함시켜 해당 작업의 목적을 명확히 합니다. 
```예를 들어: 
#1-학생-은행에서-예금-가입-기능-작성

#2-회원가입-폼-유효성-검사-추가

#3-사용자-프로필-업데이트-기능-추가
```



### 커밋 메시지 규칙
각 커밋 메시지는 작업한 기능에 대해 상세하게 설명합니다. 커밋 메시지는 현재 시제로 작성하며, 구체적이고 명확하게 작성합니다.
```
커밋 메시지 예시:

#1 학생 은행에서 예금 가입 기능 작성

#2 회원가입 폼 유효성 검사 추가

#3 사용자 프로필 업데이트 기능 추가
```


### Pull Request (PR) 관리
Pull Request는 각 브랜치에서 작업을 완료한 후, 메인 브랜치로 병합하기 전 코드 리뷰를 진행합니다. PR 제목은 작업한 기능을 간결하게 요약하고, PR 설명에는 기능에 대한 설명과 테스트 사항을 포함하여 리뷰어가 쉽게 리뷰할 수 있도록 작성합니다.


# 금융싹싹 작업 관리 및 명세서

## 작업 관리

- **GitHub Projects**와 **Issue**를 사용하여 **진행 상황**을 공유하고 관리했습니다.  
  각 **기능별 Issue**를 생성하고, **GitHub Projects**에서 **칸반 보드** 형식으로 진행 상태(예: To Do, In Progress, Done)를 실시간으로 추적하여 팀원들과 공유했습니다.
  
- **GitHub Issues**:
  - 각 기능에 대해 **Issue**를 작성하여 작업 항목을 명확히 하고, **우선순위**와 **마감 기한**을 설정하여 효율적으로 관리했습니다.

## 기능 명세서 및 요구사항 명세서

- **구글 시트**를 사용하여 **기능 명세서**와 **요구사항 명세서**를 작성했습니다.  
  이 명세서는 각 기능의 **세부 사항**과 **기능별 요구사항**을 명확히 정의하여 개발 중 참조할 수 있도록 했습니다.
  
  - <a href="https://docs.google.com/spreadsheets/d/1l7M6qhCmrL9m-Y3oLFTpUHFG6dCljsqbeb3wpsVfmFU/edit?usp=sharing">기능 명세서</a>: 각 기능에 대해 어떤 방식으로 동작해야 하는지, 필요한 데이터와 API가 무엇인지 등을 상세히 작성했습니다.
  - <a href="https://docs.google.com/spreadsheets/d/1jKfcvXv16VYuHpUwVDEVww2C9W404q8KpSTaxLRVGxg/edit?usp=sharing">요구사항 명세서</a>: 시스템이 제공해야 할 요구사항과 조건들을 문서화하여 프로젝트의 범위와 목표를 명확히 했습니다.
 
# 개발 기간 및 팀원
- 개발 기간 : 2024.09 ~ 2024.10 (고도화 진행중)
- 팀원 : 3인
