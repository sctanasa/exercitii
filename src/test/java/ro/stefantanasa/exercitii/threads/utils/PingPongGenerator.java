package ro.stefantanasa.exercitii.threads.utils;

public class PingPongGenerator {
    private static final String[] values = {"ping", "pong"};
    private static int index = 0;
    public static <T> String generateStream() {
        String result = values[index];
        index = (index + 1) % values.length;
        return result;
    }
}
