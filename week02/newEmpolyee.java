//신입사원 채용

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException { 
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); 
        
     
        int[][] scores = new int[N][2];
        
        for (int i = 0; i < N; i++) {
            scores[i][0] = scanner.nextInt();  // 서류 점수
            scores[i][1] = scanner.nextInt();  // 면접 점수
        }

        int[] ranks = new int[N];
        
        for (int i = 0; i < N; i++) {
            int rank = 1;  
            for (int j = 0; j < N; j++) {
                // 다른 지원자와 비교하여 서류와 면접 점수가 모두 높은 지원자가 있으면
                // 현재 지원자의 등수를 하나 증가시킴
                if (scores[i][0] < scores[j][0] && scores[i][1] < scores[j][1]) {
                    rank++;
                }
            }
            ranks[i] = rank;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ranks[i] + " ");
        }
    }
}
