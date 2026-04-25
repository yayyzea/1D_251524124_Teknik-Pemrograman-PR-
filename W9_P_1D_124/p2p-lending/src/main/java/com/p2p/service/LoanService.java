package com.p2p.service;

import com.p2p.domain.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanService {
    
    // Inisialisasi Log4j
    private static final Logger logger = LogManager.getLogger(LoanService.class);
    
    private static final int CREDIT_SCORE_THRESHOLD = 600;

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        
        if (borrower == null || amount == null) {
            logger.error("Terjadi ERROR: Data peminjam atau amount null!");
            throw new IllegalArgumentException("Borrower or amount cannot be null");
        }
        
        logger.info("Mulai memproses pengajuan loan sebesar: " + amount);
        
        // =========================
        // VALIDASI (delegasi ke domain)
        // =========================
        validateBorrower(borrower);
        validateAmount(amount);

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        if (borrower.getCreditScore() >= CREDIT_SCORE_THRESHOLD) {
            loan.approve();
            logger.info("Status Loan: APPROVED. Skor kredit memadai.");
        } else {
            loan.reject();
            logger.warn("Status Loan: REJECTED. Peringatan: Skor kredit di bawah standar!");
        }

        return loan;
    }

    // =========================
    // PRIVATE VALIDATION METHOD
    // =========================
        
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Terjadi ERROR Validasi: Borrower not verified");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }
        
    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            // Log Error-nya ditaruh langsung di sini sebelum throw!
            logger.error("Terjadi ERROR Validasi: Loan amount must be greater than zero");
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
    }
}