package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    public Lottos buy(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != money.count()) {
            lottos.add(new Lotto(makeLottoNumbers()));
        }
        return new Lottos(lottos);
    }

    private List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
    }
}
