import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);

        // 입력: 시작 인덱스 a, 끝 인덱스 b (1-based index)
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // fibFib 리스트: 피보나치 수를 수만큼 반복하여 나열한 수열
        List<Long> fibFib = new ArrayList<>();

        // 피보나치 수열을 저장할 리스트
        List<Long> fibs = new ArrayList<>();
        fibs.add(1L); // F(1) = 1
        fibs.add(1L); // F(2) = 1

        int index = 0; // 현재 처리 중인 피보나치 수의 인덱스

        // 원하는 구간의 끝 인덱스 b까지 수열을 생성
        while (fibFib.size() < b) {
            // 피보나치 수열이 부족하다면 다음 항을 계산하여 추가
            if (index >= fibs.size()) {
                long next = fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2);
                fibs.add(next); // F(n) = F(n-1) + F(n-2)
            }

            // 현재 피보나치 수
            long value = fibs.get(index);

            // 해당 피보나치 수를 value번 리스트에 추가
            for (int i = 0; i < value; i++) {
                fibFib.add(value);

                // 이미 필요한 범위를 다 채웠으면 반복 종료
                if (fibFib.size() >= b) break;
            }

            // 다음 피보나치 수로 이동
            index++;
        }

        // 결과 구간 [a, b]의 합을 계산 (1-based → 0-based로 조정)
        long sum = 0;
        for (int i = a - 1; i < b; i++) {
            sum += fibFib.get(i);
        }

        // 합계 출력
        System.out.println(sum);
    }
}
