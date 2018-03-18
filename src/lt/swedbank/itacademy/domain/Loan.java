package lt.swedbank.itacademy.domain;

import lt.swedbank.itacademy.util.DateUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Loan {

    private Date creationDate;
    private int termInYears;
    private String name;
    private BigDecimal interestRate;
    private BigDecimal price;
    private LoanRiskType riskType;


    public Date getCreationDate() {
        return creationDate;
    }

    public int getTermInYears() {
        return termInYears;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LoanRiskType getRiskType() {
        return riskType;
    }


    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTermInYears(int termInYears) {
        this.termInYears = termInYears;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setRiskType(LoanRiskType riskType) {
        this.riskType = riskType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return termInYears == loan.termInYears &&
                Objects.equals(creationDate, loan.creationDate) &&
                Objects.equals(name, loan.name) &&
                Objects.equals(interestRate, loan.interestRate) &&
                Objects.equals(price, loan.price) &&
                riskType == loan.riskType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationDate, termInYears, name, interestRate, price, riskType);
    }
}
