package jr.domain.roundTrip;

public enum RoundTrip {
    Yes,
    No;

    public boolean isRoundTrip() {
        return this.equals(Yes);
    }
}
