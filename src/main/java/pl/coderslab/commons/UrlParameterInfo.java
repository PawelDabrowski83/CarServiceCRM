package pl.coderslab.commons;

public class UrlParameterInfo {

    private final String method;
    private final String action; // page URL
    private final String ordnung; // type of activity: edit, delete, new, view
    private final int id;

    public static class Builder {
        private final String method;
        private final String action;
        private final String ordnung;
        private int id = 0;

        public Builder(String method, String action, String ordnung, String id) {
            this.method = method;
            this.action = action;
            this.ordnung = ordnung;
            try {
                this.id = Integer.parseInt(id);
            } catch (NumberFormatException | NullPointerException e) {
                this.id = 0;
                e.printStackTrace();
                System.out.println("ID is not numeric with: " + id);

            }
        }

        public UrlParameterInfo build() {
            return new UrlParameterInfo(this);
        }
    }

    private UrlParameterInfo(Builder builder) {
        method = builder.method;
        action = builder.action;
        ordnung = builder.ordnung;
        id = builder.id;

    }

    public String getMethod() {
        return method;
    }

    public String getAction() {
        return action;
    }

    public String getOrdnung() {
        return ordnung;
    }

    public int getId() {
        return id;
    }
}
