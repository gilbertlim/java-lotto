package study.step2;

import org.junit.jupiter.api.Test;
import study.step2.domain.dto.PurchaseAmount;
import study.step2.domain.exception.LottoException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PurchaseAmountTest {

    @Test
    void 구입_금액_부족() {
        assertThatExceptionOfType(LottoException.class)
            .isThrownBy(() -> new PurchaseAmount(500))
            .withMessage("구입 금액이 부족합니다.");
    }
}
