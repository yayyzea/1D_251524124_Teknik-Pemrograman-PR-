package com.p2p.service;
import com.p2p.domain.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);
    
    // TC-01
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================
        logger.info("Menjalankan TC-01: shouldRejectLoanWhenBorrowerNotVerified");
        
        // =========================
        // Arrange (Initial Condition)
        // =========================
        
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();
        
        // Jumlah pinjaman 
        BigDecimal amount = BigDecimal.valueOf(1000);

        // =========================
        // Act & Assert (Action + Expected Result)
        // =========================
        // Kita beritahu JUnit bahwa kita MENGHARAPKAN munculnya IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });
    }
    
    // TC-02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative(){
        // =====================================================
        // SKENARIO:
        // Borrower valid 
        // Amount ≤ 0 
        // EXPECTED:
        // Status = EXCEPTION
        // =====================================================   
        logger.info("Menjalankan TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative");
        
        // =========================
        // Arrange (Initial Condition)
        // =========================
        
        // Borrower sudah lolos proses KYC
        Borrower borrower = new Borrower(true, 700);
        
        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();
        
        // Jumlah pinjaman 
        BigDecimal zeroAmount = BigDecimal.ZERO;
        BigDecimal negativeAmount = BigDecimal.valueOf(-100);
         
        // =========================
        // Act & Assert (Action + Expected Result)
        // =========================
             
        // Ditolak saat pinjam 0 rupiah
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, zeroAmount);
        });
                        
        // Ditolak saat pinjam minus (-100) rupiah
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, negativeAmount);
        });  
    }
    
    // TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh(){
        // =====================================================
        // SKENARIO:
        // Borrower verified 
        // Credit score ≥ threshold
        // EXPECTED:
        // Status = APPROVED
        // =====================================================   
        logger.info("Menjalankan TC-03: shouldApproveLoanWhenCreditScoreHigh");
        
        // =========================
        // Arrange (Initial Condition)
        // =========================
        
        // Borrower sudah lolos proses KYC
        Borrower borrower = new Borrower (true, 700);
        
        //Service untuk pengajuan loan
        LoanService loanService = new LoanService();
        
        // Jumlah pinjaman 
        BigDecimal amount = BigDecimal.valueOf(1000);
        
        // =========================
        // Act (Action)
        // =========================       
        Loan resultLoan = loanService.createLoan(borrower, amount);
                
        // =========================
        // Assert (Expected Result)
        // =========================     
        assertEquals(Loan.Status.APPROVED, resultLoan.getStatus());
    
    }
    
    // TC-04 
    @Test
    void shouldRejectLoanWhenCreditScoreLow(){
        // =====================================================
        // SKENARIO:
        // Borrower verified 
        // Credit score < threshold
        // EXPECTED:
        // Status = REJECTED
        // =====================================================  
        logger.info("Menjalankan TC-04: shouldRejectLoanWhenCreditScoreLow");
        
        // =========================
        // Arrange (Initial Condition)
        // =========================
        
        // Borrower sudah lolos proses KYC, tapi credit score di bawah threshold
        Borrower borrower = new Borrower (true, 200);
        
        //Service untuk pengajuan loan
        LoanService loanService = new LoanService();
        
        // Jumlah pinjaman 
        BigDecimal amount = BigDecimal.valueOf(1000);
        
        // =========================
        // Act (Action)
        // =========================
        Loan resultLoan = loanService.createLoan(borrower, amount); 
        
        // =========================
        // Assert (Expected Result)
        // =========================
        assertEquals(Loan.Status.REJECTED, resultLoan.getStatus());
    }
       
}

