package codility.lessons.stackAndQueue.fish;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class SolutionTest {

    @ParameterizedTest
    @MethodSource("generateData")
    void testSolution(List<Integer> A, List<Integer> B) {


        Solution problem = new Solution();

        int result = problem.solution(
                A.stream().mapToInt(a -> a).toArray(),
                B.stream().mapToInt(b -> b).toArray());

        System.out.println(result);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(4, 3, 2, 1, 5), Arrays.asList(0, 1, 0, 0, 0)),
                Arguments.of(Arrays.asList(4, 3, 2, 1, 5), Arrays.asList(1, 0, 0, 0, 0)),
                Arguments.of(Arrays.asList(4, 3, 2, 1, 5), Arrays.asList(0, 0, 0, 0, 1)),
                Arguments.of(Arrays.asList(8, 6, 5, 3, 2, 4, 7), Arrays.asList(1, 1, 1, 1, 1, 0, 0)),
                Arguments.of(Arrays.asList(8, 6, 4, 2, 1, 3, 5), Arrays.asList(1, 1, 1, 1, 1, 0, 0)),

                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(1, 1, 1, 1, 0))
        );
    }
}