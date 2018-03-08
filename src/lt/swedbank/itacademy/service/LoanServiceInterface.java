package lt.swedbank.itacademy.service;

import lt.swedbank.itacademy.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public interface LoanServiceInterface {
    BigDecimal getAverageLoanCost();

    ArrayList<Loan> getHighRiskLoans();

    BigDecimal getAverageLoanCostOfHighRiskLoans();

    BigDecimal getMaximumPriceOfNonExpiredLoans();

    BigDecimal getAverageLoanCost(LoanRiskType riskType);

    ArrayList<VehicleLoan> getNormalRiskVehicleLoans();

    int getMaximumAgeOfLowRiskLoanedVehicles();

    ArrayList<RealEstateLoan> getPersonalRealEstateLoans();

    ArrayList<VehicleLoan> getExpiredHighRiskVehicleLoansOfHighestDuration();

    Collection<HarvesterLoan> getLowRiskHarvesterLoans();

    Collection<LandLoan> getExpiredLandLoansInReservation();

    Collection<VehicleLoan> getLoansOfHigherThanAverageDepreciation();
}
