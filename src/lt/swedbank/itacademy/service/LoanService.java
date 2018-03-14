package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.*;
import lt.swedbank.itacademy.util.DateUtil;
import lt.swedbank.itacademy.util.LoanUtil;

import java.math.BigDecimal;
import java.util.*;

import static lt.swedbank.itacademy.domain.LoanRiskType.HIGH_RISK;
import static lt.swedbank.itacademy.domain.LoanRiskType.LOW_RISK;
import static lt.swedbank.itacademy.domain.LoanRiskType.NORMAL_RISK;


public class LoanService implements LoanServiceInterface {
    private Loan[] loans;


    public LoanService(Loan[] loans) {
        this.loans = loans;
    }

    public Loan[] getLoans() {
        return loans;
    }

    public Collection<BigDecimal> calculateInterest() {

        Collection<BigDecimal> interests = new ArrayList<>();

        for (Loan loan : loans) {
             loan.getPrice().multiply(loan.getInterestRate().divide(new BigDecimal(100)));
        }

        return interests;
    }

    public Collection<BigDecimal> calculateTotalLoanCost() {

        Collection<BigDecimal> totalLoansCosts = new ArrayList<>();
        Collection<BigDecimal> interests = calculateInterest();

        for (Loan loan : loans) {
            totalLoansCosts.add(loan.getPrice().add((BigDecimal) interests));
        }
        return totalLoansCosts;
    }

    public BigDecimal calculateNewInterestRate() {

        Collection<VehicleLoan> vehicleLoans = getVehicleLoans();

        BigDecimal newInterestRate = new BigDecimal(0);

        for (VehicleLoan vehicleLoan : vehicleLoans) {
            newInterestRate = vehicleLoan.getInterestRate().multiply(findCoefficient());


//            if (vehicleLoan.getRiskType().equals(HIGH_RISK)) {
//                newInterestRate = vehicleLoan.getInterestRate().multiply(new BigDecimal(1.5));
//            } else if (vehicleLoan.getRiskType().equals(NORMAL_RISK)) {
//                newInterestRate = vehicleLoan.getInterestRate().multiply(new BigDecimal(1));
//            } else if (vehicleLoan.getRiskType().equals(LOW_RISK)) {
//                newInterestRate = vehicleLoan.getInterestRate().multiply(new BigDecimal(0.8));
//            }
        }

        return newInterestRate;
    }

    public BigDecimal findCoefficient() {

        VehicleLoan vehicleLoan = new VehicleLoan();

        switch (vehicleLoan.getRiskType()) {
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
    public BigDecimal getAverageLoanCost() {

        BigDecimal averageLoanCost = BigDecimal.ZERO;
        Collection<BigDecimal> totalLoanCost = calculateTotalLoanCost();

        int numberOfLoans = 0;

        for (Loan loan : loans) {

            if (loan instanceof VehicleLoan) {
                    loan.setInterestRate(calculateNewInterestRate());
            }

            averageLoanCost = averageLoanCost.add((BigDecimal) totalLoanCost);
            numberOfLoans++;
        }

        averageLoanCost = averageLoanCost.divide(new BigDecimal(numberOfLoans), 2, BigDecimal.ROUND_UP);

        return averageLoanCost;
    }

    @Override
    public Collection<Loan> getHighRiskLoans() {

        Collection<Loan> highRiskLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan.getRiskType() == HIGH_RISK) {
                highRiskLoans.add(loan);
            }
        }

        return highRiskLoans;
    }

    @Override
    public BigDecimal getAverageLoanCostOfHighRiskLoans() {

        return getAverageLoanCost(HIGH_RISK);

    }

    @Override
    public BigDecimal getMaximumPriceOfNonExpiredLoans() {

        BigDecimal maximumPriceOfNonExpiredLoans = new BigDecimal(0);

        for (Loan loan : loans) {
            if (loan.isValid()) {
                if (loan.getPrice().compareTo(maximumPriceOfNonExpiredLoans) > 0)
                    maximumPriceOfNonExpiredLoans = loan.getPrice();
            }
        }

        return maximumPriceOfNonExpiredLoans;
    }

    @Override
    public BigDecimal getAverageLoanCost(LoanRiskType riskType) {

        BigDecimal averageLoanCost = BigDecimal.ZERO;
        Collection<BigDecimal> totalLoanCost = calculateTotalLoanCost();

        int numberOfRiskLoans = 0;

        for (Loan loan : loans) {
            if (loan.getRiskType() == riskType) {
                averageLoanCost = averageLoanCost.add((BigDecimal)totalLoanCost);
                numberOfRiskLoans++;
            }
        }

        return averageLoanCost.divide(new BigDecimal(numberOfRiskLoans), 2, BigDecimal.ROUND_UP);

    }

    private Collection<VehicleLoan> getVehicleLoans() {

        Collection<VehicleLoan> vehicleLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan instanceof VehicleLoan) {
                vehicleLoans.add((VehicleLoan) loan);
            }
        }
        return vehicleLoans;
    }

    @Override
    public Collection<VehicleLoan> getNormalRiskVehicleLoans() {

        Collection<VehicleLoan> normalRiskVehicleLoans = new ArrayList<>();
        Collection<VehicleLoan> vehicleLoans = getVehicleLoans();

        for (VehicleLoan vehicleLoan : vehicleLoans) {
            if (vehicleLoan.getRiskType() == NORMAL_RISK) {
                normalRiskVehicleLoans.add(vehicleLoan);
            }
        }

        return normalRiskVehicleLoans;
    }

    @Override
    public int getMaximumAgeOfLowRiskLoanedVehicles() {

        Collection<VehicleLoan> vehicleLoans = getVehicleLoans();
        int temporaryMaxAge = 0;
        for (VehicleLoan vehicleLoan : vehicleLoans) {
            if (vehicleLoan.getRiskType() == LOW_RISK) {
                long ageInDays = DateUtil.differenceInDays(new Date(), vehicleLoan.getManufactured());
                int ageInYears = (int) (ageInDays / 365);

                if (temporaryMaxAge < ageInYears) {
                    temporaryMaxAge = ageInYears;
                }
            }

        }
        return temporaryMaxAge;
    }


    private Collection<RealEstateLoan> getRealEstateLoan() {

        Collection<RealEstateLoan> realEstateLoans = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan instanceof RealEstateLoan) {
                realEstateLoans.add((RealEstateLoan) loan);
            }
        }
        return realEstateLoans;
    }

    @Override
    public Collection<RealEstateLoan> getPersonalRealEstateLoans() {

        Collection<RealEstateLoan> realEstateLoans = getRealEstateLoan();
        Collection<RealEstateLoan> personalRealEstateLoans = new ArrayList<>();

        for (RealEstateLoan realEstateLoan : realEstateLoans) {
            if (realEstateLoan.getPurpose() == RealEstatePurpose.PERSONAL) {
                personalRealEstateLoans.add(realEstateLoan);
            }
        }
        return personalRealEstateLoans;
    }


    @Override
    public Collection<VehicleLoan> getExpiredHighRiskVehicleLoansOfHighestDuration() {

        Collection<VehicleLoan> vehicleLoans = getVehicleLoans();
        Collection<VehicleLoan> expiredVehicleLoansOfHighestDuration = new ArrayList<>();

        int temporaryHighestDuration = 0;

        for (VehicleLoan vehicleLoan : vehicleLoans) {
            if (!vehicleLoan.isValid() && vehicleLoan.getRiskType() == HIGH_RISK) {
                if (vehicleLoan.getTermInYears() > temporaryHighestDuration) {
                    expiredVehicleLoansOfHighestDuration.add(vehicleLoan);
                }
            }
        }

        return expiredVehicleLoansOfHighestDuration;

    }

    @Override
    public Collection<HarvesterLoan> getLowRiskHarvesterLoans() {

        Collection<HarvesterLoan> lowRiskHarvesterLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan instanceof HarvesterLoan && loan.getRiskType() == LOW_RISK) {
                lowRiskHarvesterLoans.add((HarvesterLoan) loan);

            }
        }
        return lowRiskHarvesterLoans;
    }

    @Override
    public Collection<LandLoan> getExpiredLandLoansInReservation() {
        Collection<LandLoan> expiredLandLoansInReservation = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan instanceof LandLoan && (((LandLoan) loan).isInReservation())) {
                expiredLandLoansInReservation.add((LandLoan) loan);
            }
        }
        return expiredLandLoansInReservation;
    }

    @Override
    public Collection<VehicleLoan> getLoansOfHigherThanAverageDepreciation() {

        Collection<VehicleLoan> loansOfHigherThanAverageDepreciation = new ArrayList<>();
        int counter = 0;
        BigDecimal sum = new BigDecimal(0);
        BigDecimal avg;

        for (VehicleLoan vehicleLoan : getVehicleLoans()) {
            counter++;

            BigDecimal vehicleDepreciation = LoanUtil.calculateVehicleDepreciation(vehicleLoan);
            if (LoanUtil.calculateVehicleDepreciation(vehicleLoan).compareTo(vehicleLoan.getPrice()) > 0) {
                sum = sum.add(vehicleLoan.getPrice());
            } else {
                sum = sum.add(vehicleDepreciation);
            }
        }
        avg = sum.divide(BigDecimal.valueOf(counter), 2, BigDecimal.ROUND_UP);

        for (VehicleLoan vehicleLoan : getVehicleLoans()) {
            if (vehicleLoan.getPrice().compareTo(avg) > 0
                    && LoanUtil.calculateVehicleDepreciation(vehicleLoan).compareTo(vehicleLoan.getPrice()) > 0) {
                loansOfHigherThanAverageDepreciation.add(vehicleLoan);
            }
            if (LoanUtil.calculateVehicleDepreciation(vehicleLoan).compareTo(avg) > 0
                    && vehicleLoan.getPrice().compareTo(LoanUtil.calculateVehicleDepreciation(vehicleLoan)) > 0) {
                loansOfHigherThanAverageDepreciation.add(vehicleLoan);
            }
        }

        return loansOfHigherThanAverageDepreciation;
    }

    public Collection<String> findVehicleModels() {
        Collection<VehicleLoan> vehicleLoans = getVehicleLoans();
        Collection<String> vehicleModels = new HashSet<>();

        for (VehicleLoan vehicleLoan : vehicleLoans) {
            vehicleModels.add(vehicleLoan.getModel());
        }
        return vehicleModels;
    }

    public Map<LoanRiskType, Collection<Loan>> groupLoansByRiskType() {

        Map<LoanRiskType, Collection<Loan>> groupedLoansByRiskType = new HashMap<>();


        for (Loan loan : loans) {
            LoanRiskType loanRiskType = loan.getRiskType();
            if (groupedLoansByRiskType.containsKey(loanRiskType)) {
                groupedLoansByRiskType.get(loanRiskType).add(loan);
            } else {
                Collection<Loan> loans = new ArrayList<>();
                loans.add(loan);
                groupedLoansByRiskType.put(loanRiskType, loans);
            }


        }
        return groupedLoansByRiskType;
    }


//    public Set<Loan> prioritizeLoans() {
//
//        Set<Loan> prioritisedLoans = new TreeSet<>(new Prioritization());
//
//        for (Loan loan : loans) {
//            prioritisedLoans.add(loan);
//        }
//        return prioritisedLoans;
//    }
}
