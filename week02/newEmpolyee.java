//

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        Scanner scanner = new Scanner(System.in);
        
        // N 입력받기
        int N = scanner.nextInt(); 
        
        // 지원자의 서류 점수와 면접 점수를 저장할 리스트
        int[][] scores = new int[N][2];
        
        // 지원자들의 서류점수와 면접점수 입력 받기
        for (int i = 0; i < N; i++) {
            scores[i][0] = scanner.nextInt();  // 서류 점수
            scores[i][1] = scanner.nextInt();  // 면접 점수
        }

        // 결과를 저장할 리스트
        int[] ranks = new int[N];
        
        // 각 지원자마다 등수를 계산
        for (int i = 0; i < N; i++) {
            int rank = 1;  // 기본 등수는 1
            for (int j = 0; j < N; j++) {
                // 다른 지원자와 비교하여 서류와 면접 점수가 모두 높은 지원자가 있으면
                // 현재 지원자의 등수를 하나 증가시킴
                if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}
