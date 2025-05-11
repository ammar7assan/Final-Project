package src.lib;
public class Income extends Transaction {
    private String source;
    private String frequency;

    public Income(String date, double amount, String description, String source, String frequency) {
        super(date, amount, description);
        this.source = source;
        this.frequency = frequency;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean isValid() {
        return getAmount() > 0 && source != null && !source.isEmpty();
    }

    @Override
    public String toString() {
        return super.toString() + ", Source: " + source + ", Frequency: " + frequency;
    }
}
