## 기능 목록

> 핵심 기능 : 미션을 함께할 페어를 정한다.

### 🕹️ 도메인

- [x] 과정을 만든다.
    - `백엔드`, `프론트엔드`
- [x] 레벨별 미션을 만든다.
    - 5개 레벨
    - 레벨별 미션 세팅
- [x] 과정별 크루를 만든다.
    - [x] 제공된 파일을 읽어 크루들의 이름을 불러온다.
- [x] 페어 매칭을 진행한다.
    - [ ] 매칭 시도 횟수를 확인한다.
        - [ ] 3회가 넘어갈 경우 에러 메시지를 출력한다.
    - [ ] 매칭 정보가 있는지 확인한다.
    - [x] 크루 목록의 순서를 랜덤으로 섞는다.
        - `camp.nextstep.edu.missionutils.Randoms.suffle`을 활용한다.
    - [x] 2명씩 매칭한다.
        - [x] 섞인 크루 목록에서 앞에 있는 순서대로 페어를 맺는다.
        - [x] 인원이 홀수인 경우 마지막 크루는 마지막 페어에 포함시킨다.
        - [ ] 같은 레벨에서 이미 매칭 이력이 있는 크루끼리 매칭된다면, 크루 목록의 순서를 다시 랜덤으로 섞어 매칭을 시도한다.
- [ ] 페어 매칭 결과를 조회한다.
    - 매칭 이력이 없으면 `매칭 이력이 없습니다.` 에러를 출력한다.
- [ ] 페어 매칭 결과를 초기화 한다.

### ⌨️ 입력

- `camp.nextstep.edu.missionutils.Console.readLine`을 활용한다.
- [x] 기능을 입력 받는다.
    ```text
    기능을 선택하세요.
    1. 페어 매칭
    2. 페어 조회
    3. 페어 초기화
    Q. 종료
    ```
- [x] 페어 매칭 정보를 입력 받는다.
    ```text
    #############################################
    과정: 백엔드 | 프론트엔드
    미션:
      - 레벨1: 자동차경주 | 로또 | 숫자야구게임
      - 레벨2: 장바구니 | 결제 | 지하철노선도
      - 레벨3: 
      - 레벨4: 성능개선 | 배포
      - 레벨5: 
    ############################################
    과정, 레벨, 미션을 선택하세요.
    ex) 백엔드, 레벨1, 자동차경주
    ```
- [ ] 페어 재매칭 여부를 입력 받는다.
    ```text
    매칭 정보가 있습니다. 다시 매칭하시겠습니까?
    네 | 아니오
    ```

### 🖥 출력

- [ ] 페어 매칭 결과를 출력한다.
    - `페어 매칭 결과입니다.`
    - `용팔 : 대만`
- [x] 에러 메시지를 출력한다.
    - `[ERROR] 에러 메세지`

### 🧨 예외

- 잘못된 입력일 경우 `IllegalArgumentException`를 발생시키고 재입력 받는다.

---

## 프로그래밍 체크사항

- 함수 길이 15라인 제한
- indent depth 2까지 허용
- 3항 연산자, else 예약어 금지