package study.step3.domain;

import java.util.Objects;

import study.step3.domain.exception.LottoException;

public class LottoNumber {

    private final Integer lottoNumber;
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    public LottoNumber(Integer number) {
        validate(number);
        this.lottoNumber = number;
    }

    private void validate(Integer number) {
        if (!isValid(number)) {
            throw new LottoException("번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isValid(Integer number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    public boolean matchesBonusNumber(LottoNumber bonusNumber) {
        return lottoNumber.equals(bonusNumber.lottoNumber());
    }

    public Integer lottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) object;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
