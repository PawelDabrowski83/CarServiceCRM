package pl.coderslab.experimental;

public class DispatcherInfo {
    /*
    Builder pattern for practice
     */

    private final boolean sendRedirect;
    private final String redirURL;

    public static class Builder {
        private final boolean sendRedirect;
        private final String redirURL;

        public Builder(boolean sendRedirect, String redirURL) {
            this.sendRedirect = sendRedirect;
            this.redirURL = redirURL;
        }

        public DispatcherInfo build() {
            return new DispatcherInfo(this);
        }
    }

    private DispatcherInfo(Builder builder) {
        sendRedirect = builder.sendRedirect;
        redirURL = builder.redirURL;
    }

    public boolean isSendRedirect() {
        return sendRedirect;
    }

    public String getRedirURL() {
        return redirURL;
    }

    @Override
    public String toString() {
        return "DispatcherInfo{" +
                "sendRedirect=" + sendRedirect +
                ", redirURL='" + redirURL + '\'' +
                '}';
    }
}
