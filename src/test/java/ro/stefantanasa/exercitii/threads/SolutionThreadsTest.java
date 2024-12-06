package ro.stefantanasa.exercitii.threads;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.stefantanasa.exercitii.threads.utils.PingPongGenerator;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionThreadsTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream initialOut = System.out;

    @BeforeEach
    public void redirectStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(initialOut);
    }

    @Test
    void checkPingPongThreads() {
        SolutionThreads threads = new SolutionThreads();
        threads.solution();

        final String output = outputStream.toString();
        initialOut.println(output);
        final String[] outputLines = output.split(System.lineSeparator());
        assertEquals(0, outputLines.length % 2);

        List<String> expectedLines = Stream.generate(PingPongGenerator::generateStream).limit(outputLines.length).toList();
        assertLinesMatch(expectedLines, Arrays.stream(outputLines).toList());
    }
}