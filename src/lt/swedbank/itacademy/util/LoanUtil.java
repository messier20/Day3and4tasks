package lt.swedbank.itacademy.util;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.VehicleLoan;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class LoanUtil {
    public static BigDecimal calculateVehicleDepreciation(VehicleLoan vehicleLoan) {

        int yearsInUse = (int) (DateUtil.differenceInDays(new Date(), vehicleLoan.getManufactured()) / 365);
        BigDecimal vehicleDepreciation =
                vehicleLoan.getPrice().multiply(new BigDecimal(yearsInUse)).
                        divide(new BigDecimal(vehicleLoan.getMaximumAge()), 2, BigDecimal.ROUND_UP);

        return vehicleDepreciation;
    }

}
