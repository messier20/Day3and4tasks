package lt.swedbank.itacademy.domain;

public class CarLoan extends VehicleLoan implements Comparable<CarLoan> {
    private float enginePower;

    public float getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(float enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public int compareTo(CarLoan o) {

        if (getPrice().compareTo(o.getPrice()) > 0) {
            return -1;
        }
        if (getPrice().compareTo(o.getPrice()) < 0) {
            return 1;

        }
        if (getEnginePower() > o.getEnginePower()) {
            return -1;
        }
        if (getEnginePower() < o.getEnginePower()) {
            return 1;
        }

        if (getInterestRate().compareTo(o.getInterestRate()) > 0) {
            return 1;
        }
        if (getInterestRate().compareTo(o.getInterestRate()) < 0) {
            return -1;
        }
        else return 0;
    }

}
