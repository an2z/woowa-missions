## 📋 기능 목록

⌨️ 입력

- 잘못된 값을 입력할 경우 예외 메세지 출력 후 그 부분부터 다시 입력 받는다.
- [x] 다리 길이를 입력 받는다.
    - [x] 숫자 형식이 아니라면 예외 처리
- [x] 이동할 칸을 입력 받는다.
- [x] 재시도 및 종료 여부를 입력 받는다.

<br>

🖥 출력

- [x] `다리 건너기 게임을 시작합니다.`를 출력한다.
- [x] `다리의 길이를 입력해주세요.`를 출력한다.
- [x] `이동할 칸을 선택해주세요. (위: U, 아래: D)`를 출력한다.
- [x] `게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)`를 출력한다.
- [x] 현재까지 이동한 다리 상태를 출력한다.
    - [x] 출력 형식에 맞춰 가공한다.
    - 다리 시작 `[ `
    - 다리 끝 ` ]`
    - 다리 칸 구분 ` | `
    - 건널 수 있는 다리 `O`
    - 건널 수 없는 다리 `X`
- [x] 게임의 최종 결과를 출력한다.
    - `최종 게임 결과`
    - `게임 성공 여부: `
    - `총 시도한 횟수: `

<br>

🚧 다리 건너기

- [x] 게임을 시작한다.
    - [x] 게임 시작 메세지를 보여준다.
    - [x] 시도 횟수를 증가시킨다.
- [x] 다리를 생성한다.
    - 무작위 값이 `1`일 경우 `U`(위 칸)
    - 무작위 값이 `0`일 경우 `D`(아래 칸)
- [x] 다리를 이동한다.
    - [x] 이동할 칸이 `U` 또는 `D`가 아니라면 예외를 발생시킨다.
    - [x] 이동할 칸이 건널 수 있는 칸인지 확인한다.
    - [x] 현재까지 이동 한 다리 상태를 업데이트 한다.
    - [x] 게임 결과를 업데이트 한다.
        - 다리를 모두 건넜을 경우 `성공`
        - 다리를 모두 건너지 못한 경우 `실패`
    - [x] 현재까지 이동 한 다리 상태를 보여준다.
- [x] 다리 이동에 실패하면 재시도 및 종료 명령을 내린다.
    - [x] 게임 명령이 `R` 또는 `Q`가 아니라면 예외를 발생시킨다.
- [x] 게임을 재시도한다.
    - [x] 시도 횟수를 증가시킨다.
    - [x] 현재까지 건넌 다리 결과를 초기화시킨다.
- [x] 게임을 종료한다.
    - [x] 다리 건너기를 성공하면 게임을 종료한다.
    - [x] 다리 건너기를 실패 후 게임 종료를 선택하면 게임을 종료한다.
    - [x] 게임이 종료되면 최종 결과를 보여준다.