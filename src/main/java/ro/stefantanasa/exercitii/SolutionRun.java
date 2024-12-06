package ro.stefantanasa.exercitii;

import ro.stefantanasa.exercitii.numbers.Solution;

public class SolutionRun {
//    private static int[] NUMBERS = {130, 191, 200, 10};
//    private static int[] NUMBERS = {405, 45, 300, 300};
//    private static int[] NUMBERS = {50, 222, 49, 52, 25};
    private static int[] NUMBERS = {30, 909, 3190, 99, 3990, 9009};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(NUMBERS));
    }
}
