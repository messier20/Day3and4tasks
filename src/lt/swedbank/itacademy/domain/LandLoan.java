package lt.swedbank.itacademy.domain;

public class LandLoan extends RealEstateLoan {
    private boolean inReservation;

    public boolean isInReservation() {
        return inReservation;
    }

    public void setInReservation(boolean inReservation) {
        this.inReservation = inReservation;
    }

}
