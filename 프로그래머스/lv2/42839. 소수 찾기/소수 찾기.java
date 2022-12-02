import java.util.*;

class Solution {

    static String numbers;

    static List<Integer> checkedNumbers = new ArrayList<>();
    static int answer = 0;

    public int solution(String numbers) {

        boolean[] visited = new boolean[numbers.length()];

        permutation(numbers, visited, 0);

        return answer;
    }

    public void permutation(String numbers, boolean [] visited, int currNumber) {
        if (checkedNumbers.contains(currNumber)) {
            return;
        }

        checkedNumbers.add(currNumber);
        //System.out.println(currNumber);
        if (isPrimeNumber(currNumber)) {
            answer++;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            int nextNumber = Integer.parseInt(String.valueOf(currNumber) + numbers.charAt(i));
            permutation(numbers, visited, nextNumber);
            visited[i] = false;
        }
    }

    public boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}