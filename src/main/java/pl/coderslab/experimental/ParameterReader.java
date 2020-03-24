package pl.coderslab.experimental;

public class ParameterReader {

    private final String action;
    private final String idAsString;
    private final int id;

    public static class Builder {
        private final String action;
        private final String idAsString;
        private int id = 0;

        public Builder(String action, String idAsString) {
            this.action = action;
            this.idAsString = idAsString;
            try {
                this.id = Integer.parseInt(idAsString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        public ParameterReader build() {
            return new ParameterReader(this);
        }
    }

    private ParameterReader(Builder builder) {
        this.action = builder.action;
        this.idAsString = builder.idAsString;
        this.id = builder.id;
    }

    public String getAction() {
        return action;
    }

    public int getId() {
        return id;
    }
}
