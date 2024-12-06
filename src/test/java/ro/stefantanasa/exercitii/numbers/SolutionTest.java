package ro.stefantanasa.exercitii.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final Solution solution;

    public SolutionTest() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/solution_success.csv", numLinesToSkip = 1, delimiter = ':')
    void testSolutionSuccess(@ConvertWith(CSVtoIntArray.class) int[] params, int expectedResult) {
        assertEquals(expectedResult, solution.solution(params));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/solution_default.csv", numLinesToSkip = 1, delimiter = ':')
    void testSolutionDefault(@ConvertWith(CSVtoIntArray.class) int[] params) {
        assertEquals(-1, solution.solution(params));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/solution_exception.csv", numLinesToSkip = 1, delimiter = ':')
    void testSolutionException(@ConvertWith(CSVtoIntArray.class) int[] params) {
        assertThrows(IllegalArgumentException.class, () -> solution.solution(params));
    }

    static class CSVtoIntArray extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            String s = (String) source;
            return Arrays.stream(s.split(",")).mapToInt(Integer::valueOf).toArray();
        }
    }
}