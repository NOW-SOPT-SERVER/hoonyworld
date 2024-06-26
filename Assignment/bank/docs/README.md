# SOPT 세미나 1주차

## 미션 - 은행 프로그램 설계하기

### ✅ 핵심 기능

**목표**

예적금 거래에서 사용할 수 있는 계좌 이체, 입금, 출금 기능 구현

### ✅ 1주차 세미나 목표

#### 과제를 통해 생각해보기
- 어떻게 하면 코드를 효율적으로 짤 수 있는지
- 어떻게 하면 유지 보수에 쉬운 코드가 될 수 있는지
- 객체지향 프로그래밍이 목표하는 바가 무엇이고 이를 어떻게 코드로 구현할 수 있는지

### ✅ 구현할 기능 목록
**[ Domain ]**
-

- [x]  **Account**

입금과 출금, 잔액 확인을 관리

- [x]  **Transaction**

계좌이체 거래 처리, 거래 확인을 관리

- [ ]  **User**

계좌 추가, 계좌 조회를 관리

**[ View ]**
-

- [x]  **InputView**

입금, 출금, 이체와 같은 거래 요청을 사용자로부터 입력받음

- [x]  **OutputView**

메뉴와 거래 결과를 사용자에게 보여줌

**[ Controller ]**
-

- [x]  **BankController**

사용자의 거래 요청을 처리하는 로직을 구현

### ✅ 예외 처리 - IllegalArgumentException

********공통********

- [X]  예외 상황 시 에러 문구를 출력. 단, 에러 문구는 "[ERROR]"로 시작

---

**메뉴 입력**

- [X] 입력한 숫자가 1~3 사이의 숫자인지 검증

---

**계좌 번호 입력**

- [x] 계좌번호 숫자인지 검증
- [x] 계좌번호 길이가 14자리인지 검증 

---

**입금 금액 입력**
- [x] 숫자 인지 검증

---

**출금 금액 입력**
- [x] 숫자 인지 검증

---

**이체 금액 입력**
- [x] 이체 한도 이상인지 검증

**비밀번호 입력**
- [ ] 유효한 비밀번호 인지 검증
