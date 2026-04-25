package com.p2p.domain;

/**
 *
 * @author ZAHRA
 */
public class Loan {
    
    // Enum untuk status loan
    public enum Status {
        PENDING, APPROVED, REJECTED
    }

    private Status status;

    // Saat loan dibuat, status awal adalah PENDING
    public Loan() {
        this.status = Status.PENDING;
    }

    // Getter untuk membaca status loan
    public Status getStatus() {
        return status;
    }
    
    // =========================
    // DOMAIN BEHAVIOR
    // =========================
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }
}


