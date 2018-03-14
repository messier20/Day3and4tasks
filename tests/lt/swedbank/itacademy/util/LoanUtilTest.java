package lt.swedbank.itacademy.util;

import lt.swedbank.itacademy.domain.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;

public class LoanUtilTest {

    private Loan[] loans;

    @Before
    public void setup() {
        loans = new Loan[13];

        loans[0] = new LandLoan();

        loans[0].setCreationDate(DateUtil.getDateFromString("2010-01-01"));
        loans[0].setInterestRate(new BigDecimal(15.0));
        loans[0].setPrice(new BigDecimal(10000));
        loans[0].setRiskType(LoanRiskType.HIGH_RISK);
        loans[0].setTermInYears(2);
        ((LandLoan)loans[0]).setArea(100);
        ((LandLoan)loans[0]).setDistrict("Vilnius, Fabijoniškių raj.");
        ((LandLoan)loans[0]).setPurpose(RealEstatePurpose.COMMERCIAL);
        ((LandLoan)loans[0]).setInReservation(false);
        loans[0].setName("LandLoan 0");

        loans[1] = new LandLoan();

        loans[1].setCreationDate(DateUtil.getDateFromString("2017-01-01"));
        loans[1].setInterestRate(new BigDecimal(17.0));
        loans[1].setPrice(new BigDecimal(100000));
        loans[1].setRiskType(LoanRiskType.HIGH_RISK);
        loans[1].setTermInYears(5);
        ((LandLoan)loans[1]).setArea(50);
        ((LandLoan)loans[1]).setDistrict("Klaipėda, Melnragė");
        ((LandLoan)loans[1]).setPurpose(RealEstatePurpose.PERSONAL);
        ((LandLoan)loans[1]).setInReservation(true);
        loans[1].setName("LandLoan 1");

        loans[2] = new LandLoan();

        loans[2].setCreationDate(DateUtil.getDateFromString("2010-01-01"));
        loans[2].setInterestRate(new BigDecimal(15.0));
        loans[2].setPrice(new BigDecimal(20000000));
        loans[2].setRiskType(LoanRiskType.HIGH_RISK);
        loans[2].setTermInYears(5);
        ((LandLoan)loans[2]).setArea(500);
        ((LandLoan)loans[2]).setDistrict("Kaunas, Senamiestis");
        ((LandLoan)loans[2]).setPurpose(RealEstatePurpose.COMMERCIAL);
        ((LandLoan)loans[2]).setInReservation(false);
        loans[2].setName("LandLoan 2");

        loans[3] = new HouseLoan();

        loans[3].setCreationDate(DateUtil.getDateFromString("2015-01-01"));
        loans[3].setInterestRate(new BigDecimal(12.0));
        loans[3].setPrice(new BigDecimal(19000));
        loans[3].setRiskType(LoanRiskType.NORMAL_RISK);
        loans[3].setTermInYears(20);
        ((HouseLoan)loans[3]).setArea(100);
        ((HouseLoan)loans[3]).setDistrict("Kazlų Rūda");
        ((HouseLoan)loans[3]).setPurpose(RealEstatePurpose.COMMERCIAL);
        ((HouseLoan)loans[3]).setConstructionDate(DateUtil.getDateFromString("2005-01-01"));
        ((HouseLoan)loans[3]).setFloorCount(2);
        loans[3].setName("HouseLoan 3");

        loans[4] = new HouseLoan();

        loans[4].setCreationDate(DateUtil.getDateFromString("2014-01-01"));
        loans[4].setInterestRate(new BigDecimal(20.0));
        loans[4].setPrice(new BigDecimal(5000));
        loans[4].setRiskType(LoanRiskType.LOW_RISK);
        loans[4].setTermInYears(15);
        ((HouseLoan)loans[4]).setArea(100);
        ((HouseLoan)loans[4]).setDistrict("Vilnius, Naujininkų raj.");
        ((HouseLoan)loans[4]).setPurpose(RealEstatePurpose.PERSONAL);
        ((HouseLoan)loans[4]).setConstructionDate(DateUtil.getDateFromString("2004-01-01"));
        ((HouseLoan)loans[4]).setFloorCount(4);
        loans[4].setName("HouseLoan 4");


        loans[10] = new HouseLoan();

        loans[10].setCreationDate(DateUtil.getDateFromString("2014-01-01"));
        loans[10].setInterestRate(new BigDecimal(20.0));
        loans[10].setPrice(new BigDecimal(5000));
        loans[10].setRiskType(LoanRiskType.LOW_RISK);
        loans[10].setTermInYears(15);
        ((HouseLoan)loans[10]).setArea(100);
        ((HouseLoan)loans[10]).setDistrict("Vilnius, Naujos Vilnios raj.");
        ((HouseLoan)loans[10]).setPurpose(RealEstatePurpose.COMMERCIAL);
        ((HouseLoan)loans[10]).setConstructionDate(DateUtil.getDateFromString("2000-01-01"));
        ((HouseLoan)loans[10]).setFloorCount(3);
        loans[10].setName("HouseLoan 10");

        loans[5] = new CarLoan();

        loans[5].setCreationDate(DateUtil.getDateFromString("2013-01-01"));
        loans[5].setInterestRate(new BigDecimal(15.0));
        loans[5].setPrice(new BigDecimal(30000));
        loans[5].setRiskType(LoanRiskType.NORMAL_RISK);
        loans[5].setTermInYears(2);
        ((CarLoan)loans[5]).setManufactured(DateUtil.getDateFromString("2010-01-01"));
        ((CarLoan)loans[5]).setMaximumAge(9);
        ((CarLoan)loans[5]).setModel("Porsche Cayenne");
        ((CarLoan)loans[5]).setEnginePower(100);
        loans[5].setName("CarLoan 5");

        loans[6] = new CarLoan();

        loans[6].setCreationDate(DateUtil.getDateFromString("2014-01-01"));
        loans[6].setInterestRate(new BigDecimal(11.0));
        loans[6].setPrice(new BigDecimal(19000));
        loans[6].setRiskType(LoanRiskType.HIGH_RISK);
        loans[6].setTermInYears(4);
        ((CarLoan)loans[6]).setManufactured(DateUtil.getDateFromString("2014-01-01"));
        ((CarLoan)loans[6]).setMaximumAge(15);
        ((CarLoan)loans[6]).setModel("Audio A5");
        ((CarLoan)loans[6]).setEnginePower(300);
        loans[6].setName("CarLoan 6");

        loans[7] = new CarLoan();

        loans[7].setCreationDate(DateUtil.getDateFromString("2015-01-01"));
        loans[7].setInterestRate(new BigDecimal(15.0));
        loans[7].setPrice(new BigDecimal(14000));
        loans[7].setRiskType(LoanRiskType.NORMAL_RISK);
        loans[7].setTermInYears(2);
        ((CarLoan)loans[7]).setManufactured(DateUtil.getDateFromString("2012-01-01"));
        ((CarLoan)loans[7]).setMaximumAge(10);
        ((CarLoan)loans[7]).setModel("Jaguar XJ");
        ((CarLoan)loans[7]).setEnginePower(200);
        loans[7].setName("CarLoan 7");

        loans[8] = new HarvesterLoan();

        loans[8].setCreationDate(DateUtil.getDateFromString("2016-01-01"));
        loans[8].setInterestRate(new BigDecimal(5.0));
        loans[8].setPrice(new BigDecimal(10000));
        loans[8].setRiskType(LoanRiskType.NORMAL_RISK);
        loans[8].setTermInYears(2);
        ((HarvesterLoan)loans[8]).setManufactured(DateUtil.getDateFromString("1998-01-01"));
        ((HarvesterLoan)loans[8]).setMaximumAge(10);
        ((HarvesterLoan)loans[8]).setModel("New Holland TX68");
        ((HarvesterLoan)loans[8]).setCapacity(10);
        loans[8].setName("HarvesterLoan 8");

        loans[9] = new HarvesterLoan();

        loans[9].setCreationDate(DateUtil.getDateFromString("2018-01-01"));
        loans[9].setInterestRate(new BigDecimal(19.0));
        loans[9].setPrice(new BigDecimal(69000));
        loans[9].setRiskType(LoanRiskType.LOW_RISK);
        loans[9].setTermInYears(5);
        ((HarvesterLoan)loans[9]).setManufactured(DateUtil.getDateFromString("2017-01-01"));
        ((HarvesterLoan)loans[9]).setMaximumAge(15);
        ((HarvesterLoan)loans[9]).setModel("Claas Lexion 570");
        ((HarvesterLoan)loans[9]).setCapacity(20);
        loans[9].setName("HarvesterLoan 9");


        loans[11] = new HarvesterLoan();

        loans[11].setCreationDate(DateUtil.getDateFromString("2016-01-01"));
        loans[11].setInterestRate(new BigDecimal(19.0));
        loans[11].setPrice(new BigDecimal(25000));
        loans[11].setRiskType(LoanRiskType.LOW_RISK);
        loans[11].setTermInYears(10);
        ((HarvesterLoan)loans[11]).setManufactured(DateUtil.getDateFromString("2010-01-01"));
        ((HarvesterLoan)loans[11]).setMaximumAge(20);
        ((HarvesterLoan)loans[11]).setCapacity(30);
        ((HarvesterLoan)loans[11]).setModel("John Deere 9870");
        loans[11].setName("HarvesterLoan 11");

        loans[12] = new HarvesterLoan();

        loans[12].setCreationDate(DateUtil.getDateFromString("2010-01-01"));
        loans[12].setInterestRate(new BigDecimal(19.0));
        loans[12].setPrice(null);
        loans[12].setRiskType(LoanRiskType.LOW_RISK);
        loans[12].setTermInYears(10);
        ((HarvesterLoan)loans[11]).setManufactured(DateUtil.getDateFromString("2010-01-01"));
        ((HarvesterLoan)loans[11]).setMaximumAge(20);
        ((HarvesterLoan)loans[11]).setCapacity(30);
        ((HarvesterLoan)loans[11]).setModel("John Deere 9870");
        loans[12].setName("HarvesterLoan 11");

    }

    @Test
    public void calculateVehicleDepreciation() throws Exception {
//        BigDecimal[] vehicleDepreciation = new BigDecimal[9];
        Collection<BigDecimal> actualVehicleDepreciation = new ArrayList<>();

        for (Loan loan : loans) {
            if (loan instanceof VehicleLoan) {
                LoanUtil.calculateVehicleDepreciation((VehicleLoan) loan);
//                vehicleDepreciation[loan] =

                actualVehicleDepreciation.add(LoanUtil.calculateVehicleDepreciation((VehicleLoan) loan));
            }
        }

        BigDecimal[] expectedVehicleDepreciation =
                {
                        BigDecimal.valueOf(26666.67).setScale(2),
                        BigDecimal.valueOf(5066.67).setScale(2),
                        BigDecimal.valueOf(8400.00).setScale(2),
                        BigDecimal.valueOf(20000.00).setScale(2),
                        BigDecimal.valueOf(4600.00).setScale(2),
//                        BigDecimal.valueOf(10000.00).setScal
                        null
                };

        assertArrayEquals(expectedVehicleDepreciation, actualVehicleDepreciation.toArray());



    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests finished");

    }

}