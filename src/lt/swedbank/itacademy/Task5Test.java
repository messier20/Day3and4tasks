package lt.swedbank.itacademy;

import lt.swedbank.itacademy.domain.CarLoan;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task5Test {
  private static final BigDecimal HIGHEST_PRICE = BigDecimal.TEN;
  private static final BigDecimal NORMAL_PRICE = BigDecimal.ONE;
  private static final BigDecimal LOWEST_PRICE = BigDecimal.ZERO;
  private static final float HIGHEST_ENGINE_POWER = 200f;
  private static final float NORMAL_ENGINE_POWER = 100f;
  private static final float LOWEST_ENGINE_POWER = 50f;
  private static final BigDecimal HIGHEST_INTEREST_RATE = BigDecimal.TEN;
  private static final BigDecimal LOWEST_INTEREST_RATE = BigDecimal.ONE;

  public static void main(String[] args) {
    List<CarLoan> carLoans = Arrays.asList(
      createCarLoan("1", NORMAL_PRICE, HIGHEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("2", LOWEST_PRICE, HIGHEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("3", LOWEST_PRICE, HIGHEST_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("4", HIGHEST_PRICE, HIGHEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("5", NORMAL_PRICE, LOWEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("6", LOWEST_PRICE, NORMAL_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("7", LOWEST_PRICE, LOWEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("8", HIGHEST_PRICE, NORMAL_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("9", LOWEST_PRICE, LOWEST_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("10", NORMAL_PRICE, HIGHEST_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("11", NORMAL_PRICE, NORMAL_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("12", LOWEST_PRICE, NORMAL_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("13", NORMAL_PRICE, LOWEST_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("14", HIGHEST_PRICE, LOWEST_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("15", HIGHEST_PRICE, LOWEST_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("16", HIGHEST_PRICE, NORMAL_ENGINE_POWER, LOWEST_INTEREST_RATE),
      createCarLoan("17", NORMAL_PRICE, NORMAL_ENGINE_POWER, HIGHEST_INTEREST_RATE),
      createCarLoan("18", HIGHEST_PRICE, HIGHEST_ENGINE_POWER, HIGHEST_INTEREST_RATE)
    );
    Collections.shuffle(carLoans);

    Collections.sort(carLoans);
    for (CarLoan carLoan : carLoans) {
      System.out.print(carLoan.getName() + " ");
    }
  }

  private static CarLoan createCarLoan(String name, BigDecimal price, float enginePower, BigDecimal interestRate) {
    CarLoan carLoan = new CarLoan();
    carLoan.setName(name);
    carLoan.setPrice(price);
    carLoan.setEnginePower(enginePower);
    carLoan.setInterestRate(interestRate);
    return carLoan;
  }
}
