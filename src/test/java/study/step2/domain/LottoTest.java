package study.step2.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 당첨_계산() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(3, 5, 6, 9, 23, 43));
        lotto.matches(winningNumbers);
        assertThat(lotto.hitCount()).isEqualTo(3);
    }
}
