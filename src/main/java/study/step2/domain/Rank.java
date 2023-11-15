package study.step2.domain;

import java.util.*;
import java.util.stream.Collectors;

import study.step2.domain.dto.Result;

public enum Rank {

    FOURTH(3, 5000, "4등"),
    THIRD(4, 50000, "3등"),
    SECOND(5, 1500000, "2등"),
    FIRST(6, 2000000000, "1등"),
    NO_HIT(0, 0, "미당첨");


    private final int hitCount;
    private final int amount;
    private final String message;

    Rank(int hitCount, int amount, String message) {
        this.hitCount = hitCount;
        this.amount = amount;
        this.message = message;
    }

    public static Rank valueOfHitCount(int hitCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.hitCountEquals(hitCount))
            .findAny()
            .orElse(NO_HIT);
    }

    private boolean hitCountEquals(int hitCount) {
        return this.hitCount == hitCount;
    }

    public static List<Result> statistics(List<Rank> ranks) {
        List<Result> results = new ArrayList<>();
        for (Rank r: valuesWithoutNoHit()) {
            results.add(new Result(r, countWinning(ranks, r)));
        }
        return results;
    }

    private static List<Rank> valuesWithoutNoHit() {
        return Arrays.stream(values())
            .filter(Rank::isHit)
            .collect(Collectors.toList());
    }

    private static int countWinning(List<Rank> ranks, Rank r) {
        return (int) ranks.stream()
            .filter(rank -> rank.equals(r))
            .count();
    }

    private boolean isHit() {
        return this != NO_HIT;
    }

    public boolean equals(Rank rank) {
        return this == rank;
    }

    public int hitCount() {
        return hitCount;
    }

    public int amount() {
        return amount;
    }
}
