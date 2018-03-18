package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.*;

import java.math.BigDecimal;
import java.util.Collection;

public interface LoanServiceInterface {
    BigDecimal getAverageLoanCost();

    Collection<Loan> getHighRiskLoans();

    BigDecimal getAverageLoanCostOfHighRiskLoans();

    BigDecimal getMaximumPriceOfNonExpiredLoans();

    BigDecimal getAverageLoanCost(LoanRiskType riskType);

    Collection<VehicleLoan> getNormalRiskVehicleLoans();

    int getMaximumAgeOfLowRiskLoanedVehicles();

    Collection<RealEstateLoan> getPersonalRealEstateLoans();

    Collection<Integer> getTermInYears();

    Collection<VehicleLoan> getExpiredHighRiskVehicleLoansOfHighestDuration();

    Collection<Integer> getTermsInYearsFromExpiredVehicleLoansOfHighestDuration();

    Collection<HarvesterLoan> getLowRiskHarvesterLoans();

    Collection<LandLoan> getExpiredLandLoansInReservation();

    Collection<VehicleLoan> getLoansOfHigherThanAverageDepreciation();
}
