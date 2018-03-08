package lt.swedbank.itacademy;

import lt.swedbank.itacademy.domain.Loan;
import lt.swedbank.itacademy.domain.LoanRiskType;
import lt.swedbank.itacademy.service.LoanService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Task6Test {
  private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  private static final LoanRiskType HIGH_RISK = LoanRiskType.HIGH_RISK;
  private static final LoanRiskType NORMAL_RISK = LoanRiskType.NORMAL_RISK;
  private static final LoanRiskType LOW_RISK = LoanRiskType.LOW_RISK;
  private static final BigDecimal HIGHEST_PRICE = new BigDecimal(1000);
  private static final BigDecimal LOW_PRICE = new BigDecimal(100);
  private static final BigDecimal HIGHEST_INTEREST_RATE = BigDecimal.TEN;
  private static final BigDecimal LOW_INTEREST_RATE = BigDecimal.ONE;
  private static final Date OLDER = stringToDate("2018-03-06");
  private static final Date NEWER = stringToDate("2018-03-07");

  public static void main(String[] args) {
    List<Loan> loans = Arrays.asList(
      createLoan("1", HIGH_RISK, LOW_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("2", HIGH_RISK, LOW_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("3", HIGH_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("4", HIGH_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, OLDER),
      createLoan("5", HIGH_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("6", HIGH_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("7", HIGH_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("8", HIGH_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, OLDER),
      createLoan("9", LOW_RISK, LOW_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("10", LOW_RISK, LOW_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("11", LOW_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("12", LOW_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, OLDER),
      createLoan("13", LOW_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("14", LOW_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("15", LOW_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("16", LOW_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, OLDER),
      createLoan("17", NORMAL_RISK, LOW_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("18", NORMAL_RISK, LOW_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("19", NORMAL_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("20", NORMAL_RISK, LOW_PRICE, HIGHEST_INTEREST_RATE, OLDER),
      createLoan("21", NORMAL_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, NEWER),
      createLoan("22", NORMAL_RISK, HIGHEST_PRICE, LOW_INTEREST_RATE, OLDER),
      createLoan("23", NORMAL_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, NEWER),
      createLoan("24", NORMAL_RISK, HIGHEST_PRICE, HIGHEST_INTEREST_RATE, OLDER)
    );
    Collections.shuffle(loans);

    for (Loan loan : new LoanService((Loan[])loans.toArray()).prioritizeLoans()) {
      System.out.print(loan.getName() + " ");
    }
  }

  private static Loan createLoan(String name, LoanRiskType riskType, BigDecimal price, BigDecimal interestRate, Date creationDate) {
    Loan loan = new Loan();
    loan.setName(name);
    loan.setRiskType(riskType);
    loan.setPrice(price);
    loan.setInterestRate(interestRate);
    loan.setCreationDate(creationDate);
    return loan;
  }

  private static Date stringToDate(String dateString) {
    try {
      return SIMPLE_DATE_FORMAT.parse(dateString);
    }
    catch (ParseException e) {
      return null;
    }
  }
}
