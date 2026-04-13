package project.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Donation")
public class Donation {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "donation_id")
    private Integer donationId;
   @Column(name = "donor_name")
    private String donorName;
   @Column(name = "amount")
    private Double amount;
   @Column(name = "transaction_date")
    private LocalDate transactionDate;
   @Column(name = "donation_purpose")
    private String donationPurpose;

    public Integer getDonationId() {
        return donationId;
    }

    public void setDonationId(Integer donationId) {
        this.donationId = donationId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDonationPurpose() {
        return donationPurpose;
    }

    public void setDonationPurpose(String donationPurpose) {
        this.donationPurpose = donationPurpose;
    }
}
