package pl.coderslab.commons;

public class DispatcherInstance {
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

        public DispatcherInstance build() {
            return new DispatcherInstance(this);
        }
    }

    private DispatcherInstance(Builder builder) {
        sendRedirect = builder.sendRedirect;
        redirURL = builder.redirURL;
    }

    public boolean isSendRedirect() {
        return sendRedirect;
    }

    public String getRedirURL() {
        return redirURL;
    }
}
