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
