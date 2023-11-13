package study.step1;

import org.junit.jupiter.api.Test;
import study.step1.domain.DefaultCalculation;
import study.step1.domain.exception.CalculatorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class DefaultCalculationTest {

    @Test
    void 더하기() {
        DefaultCalculation calculation = new DefaultCalculation();
        assertThat(calculation.plus(1, 2)).isEqualTo(3);
    }

    @Test
    void 빼기() {
        DefaultCalculation calculation = new DefaultCalculation();
        assertThat(calculation.minus(1, 2)).isEqualTo(-1);
    }

    @Test
    void 곱하기() {
        DefaultCalculation calculation = new DefaultCalculation();
        assertThat(calculation.times(1, 2)).isEqualTo(2);
    }

    @Test
    void 나누기() {
        DefaultCalculation calculation = new DefaultCalculation();
        assertThat(calculation.divide(1, 2)).isEqualTo(0);
        assertThat(calculation.divide(2, 2)).isEqualTo(1);
    }

    @Test
    void 나누기오류() {
        DefaultCalculation calculation = new DefaultCalculation();
        assertThatExceptionOfType(CalculatorException.class)
            .isThrownBy(() -> calculation.divide(1, 0))
            .withMessage("DivideError: 0으로는 나눌 수 없습니다.");
    }

}
