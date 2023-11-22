## 🚘 기능 목록

### 입출력 기능

- [x] 자동차 이름 입력 메세지를 출력한다.
    - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`
- [x] 시도 횟수 입력 메세지를 출력한다.
    - `시도할 회수는 몇회인가요?`
- [x] 실행 결과 메세지를 출력한다.
    - `실행 결과`
- [x] 실행 결과를 출력한다.
    - `이름 : 전진횟수`
    - `-`로 한칸을 표현한다.
- [x] 최종 우승자를 출력한다.
    - `최종 우승자 : 이름`
    - 공동 우승자가 있을 경우 `, `로 구분한다.
- [x] 자동차 이름을 입력 받는다.
    - [x] ⚠️ 빈값이 입력되어서는 안된다.
- [x] 시도 횟수를 입력 받는다.
    - [x] ⚠️ 빈값이 입력되어서는 안된다.
    - [x] ⚠️ 시도 횟수는 숫자 입력만 가능하다.

### 도메인 기능

- [x] 경주에 참여할 자동차 목록을 만든다.
    - [x] ⚠️ 2대 이상만 가능하다.
- [x] 자동차를 만든다.
    - [x] ⚠️ 자동차 이름은 1~5글자만 가능하다.
    - [x] ⚠️ 자동차 이름에 특수문자나 숫자는 포함될 수 없다.
    - [x] 이름 앞뒤 공백을 제거한다.
- [x] 전진 유무를 결정한다.
    - [x] 0~9 사이의 무작위 값을 구한다.
    - [x] 무작위 값이 4 이상인지 확인한다.
- [x] 자동차를 전진한다.
- [x] 시도 횟수만큼 경주를 반복한다.
- [x] 우승자를 구한다.
    - [x] 가장 많이 전진한 자동차를 구한다.

## 🖥️ 체크리스트

- [x] 사용자가 잘못된 값을 입력하면 `IllegalArgumentException` 발생 후 종료
- [x] indent depth 2까지 허용
- [x] 3항 연산자 사용 금지
- [x] 하나의 함수는 한가지 일만
- [x] 기능 테스트 작성