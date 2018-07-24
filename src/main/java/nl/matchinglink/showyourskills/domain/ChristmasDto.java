package nl.matchinglink.showyourskills.domain;

public class ChristmasDto {
    private long daysUntilToCatholic;

    private long daysUntilToOrthodox;

    public ChristmasDto(long countDaysToCatholic, long daysUntilToOrthodox) {
        this.daysUntilToCatholic = countDaysToCatholic;
        this.daysUntilToOrthodox = daysUntilToOrthodox;
    }

    public long getDaysUntilToCatholic() {
        return daysUntilToCatholic;
    }

    public long getDaysUntilToOrthodox() {
        return daysUntilToOrthodox;
    }
}
