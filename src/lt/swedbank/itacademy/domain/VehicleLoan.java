package lt.swedbank.itacademy.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class VehicleLoan extends Loan {
    private Date manufactured;
    private BigDecimal interestRate;
    private String model;
    private int age;
    private int maximumAge;

    public Date getManufactured() {
        return manufactured;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

    public int getMaximumAge() {
        return maximumAge;
    }

    public void setManufactured(Date manufactured) {
        this.manufactured = manufactured;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMaximumAge(int maximumAge) {
        this.maximumAge = maximumAge;
    }

    
    public BigDecimal calculateNewInterestRate () {

        BigDecimal newInterestRate = new BigDecimal(0);

        if (getRiskType().equals(LoanRiskType.HIGH_RISK)) {
            newInterestRate = super.getInterestRate().multiply(new BigDecimal(1.5));
        } else if (getRiskType().equals(LoanRiskType.NORMAL_RISK)) {
            newInterestRate = super.getInterestRate().multiply(new BigDecimal(1));
        } else if (getRiskType().equals(LoanRiskType.LOW_RISK)) {
            newInterestRate = super.getInterestRate().multiply(new BigDecimal(0.8));
        }
        return newInterestRate;
    }


    
//    @Override
//    public BigDecimal getInterestRate() {
//        return interestRate;
//    }
    
//    @Override
//    public void setInterestRate(BigDecimal interestRate) {
//        this.interestRate = interestRate;
//    }

    //@Override
//    public void setInterestRate(BigDecimal interestRate) {
////        for (LoanRiskType loanRiskType : LoanRiskType.values()) {
//
////            this.interestRate = super.getInterestRate().multiply(findCoefficient(super.getRiskType()));
//        
//
////        }




    public BigDecimal findCoefficient(LoanRiskType riskType) {

        switch (super.getRiskType()) {
            case LOW_RISK:
                return new BigDecimal(0.8);
            case NORMAL_RISK:
                return new BigDecimal(1);
            case HIGH_RISK:
                return new BigDecimal(1.5);
            default:
                return null;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehicleLoan)) return false;
        if (!super.equals(o)) return false;
        VehicleLoan that = (VehicleLoan) o;
        return age == that.age &&
                maximumAge == that.maximumAge &&
                Objects.equals(manufactured, that.manufactured) &&
                Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufactured, model, age, maximumAge);
    }
}
