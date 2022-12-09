package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class Output {
    private static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_SIZE = "%n%d개를 구매했습니다.";

    public void requestAmount() {
        System.out.println(REQUEST_MONEY);
    }

    public void printLotto(Lottos lottos) {
        System.out.println(String.format(PURCHASE_SIZE, lottos.getSize()));
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}
