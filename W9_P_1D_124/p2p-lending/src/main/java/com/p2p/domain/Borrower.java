package com.p2p.domain;

public class Borrower {
    private boolean verified;
    private int creditScore;

    public Borrower(boolean verified, int creditScore) {
        this.verified = verified;
        this.creditScore = creditScore;
    }

    public int getCreditScore() {
        return creditScore;
    }

    // =========================
    // DOMAIN BEHAVIOR (NEW)
    // =========================
    public boolean canApplyLoan() {
        return verified;
    }
}