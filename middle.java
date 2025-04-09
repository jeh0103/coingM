import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // 입력된 5개의 정수를 저장할 정수형 배열을 선언합니다.
        int[] numbers = new int[5];

        // for 반복문을 사용해 5개의 정수를 입력받아 배열에 저장합니다.
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt(); // 정수 입력
        }

        // Arrays.sort()를 이용해 배열을 오름차순으로 정렬합니다.
        Arrays.sort(numbers);

        // 정렬된 배열에서 가운데 값(중앙값)은 인덱스 2의 값입니다. (0-based index)
        System.out.println(numbers[2]); // 중앙값 출력

        // 예시: 입력이 [101, 2, 100, 1, 102] → 정렬하면 [1, 2, 100, 101, 102]
        // 중앙값은 3번째 값인 100이 됩니다.
    }
}

// Scanner.nextInt()를 이용해 5개의 정수를 입력받습니다.

// Arrays.sort()로 정렬하면 가장 작은 값부터 큰 값 순서로 배열이 정리됩니다.

// 정렬된 배열에서 **가운데 인덱스(2)**에 있는 값이 중앙값입니다.