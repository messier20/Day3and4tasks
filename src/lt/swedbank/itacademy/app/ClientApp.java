package lt.swedbank.itacademy.app;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;
import lt.swedbank.itacademy.service.LoanService;
import lt.swedbank.itacademy.service.LoanServiceInterface;

public class ClientApp {

    public static void main(String[] args) {

        Loan[] loans = getInitializer().initializeLoans();

        LoanServiceInterface service = new LoanService(loans);


        System.out.println(service.getAverageLoanCost());
        System.out.println("There are " + service.getHighRiskLoans().size());
        System.out.println(LoanRiskType.NORMAL_RISK + ": " + service.getAverageLoanCost(LoanRiskType.NORMAL_RISK));
        System.out.println(LoanRiskType.HIGH_RISK + ": " + service.getAverageLoanCost(LoanRiskType.HIGH_RISK));
        System.out.println(LoanRiskType.LOW_RISK + ": " + service.getAverageLoanCost(LoanRiskType.LOW_RISK));
        System.out.println(service.getAverageLoanCostOfHighRiskLoans());
        System.out.println(service.getMaximumPriceOfNonExpiredLoans());

        System.out.println(service.getNormalRiskVehicleLoans().size());
        System.out.println(service.getMaximumAgeOfLowRiskLoanedVehicles());
        System.out.println("There are " + service.getPersonalRealEstateLoans().size());
        System.out.println("There are " + service.getExpiredHighRiskVehicleLoansOfHighestDuration().size()
                + ", and highest duration is "
                + service.getExpiredHighRiskVehicleLoansOfHighestDuration().get(0).getTermInYears());

        System.out.println("There are " + service.getLowRiskHarvesterLoans().size());
        System.out.println(service.getExpiredLandLoansInReservation().size());
        System.out.println("getLoansofHigherThanAvg " + service.getLoansOfHigherThanAverageDepreciation().size() );



        //Ror tests:
        //System.out.println(service.findVehicleModels());
        //System.out.println(service.groupLoansByRiskType());

    }


    public static DomainInitializer getInitializer() {
        return new Task3DomainInitializer();
    }

}
