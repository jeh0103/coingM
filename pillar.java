// don't place package name. 

import java.io.*;

import java.util.*; 

// don't change 'Main' class name and  'public' accessor. 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: N은 행(세로) 수, M은 열(가로) 수
        int N = sc.nextInt(); // 궁전의 세로 크기
        int M = sc.nextInt(); // 궁전의 가로 크기

        int[][] board = new int[N][M]; // 궁전 상태를 저장할 2차원 배열

        // 각 행과 열에 기둥(0)이 있는지를 저장할 배열
        boolean[] rowHasZero = new boolean[N]; // 각 행에 기둥이 있는지 여부
        boolean[] colHasZero = new boolean[M]; // 각 열에 기둥이 있는지 여부

        // 궁전 상태 입력 받기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt(); // 0: 기둥 있음, 1: 기둥 없음

                if (board[i][j] == 0) {
                    // 해당 행과 열에 이미 기둥이 있는 것으로 체크
                    rowHasZero[i] = true;
                    colHasZero[j] = true;
                }
            }
        }

        // 기둥이 하나도 없는 행의 개수 세기
        int rowNeed = 0;
        for (boolean has : rowHasZero) {
            if (!has) rowNeed++; // false면 해당 행에 기둥이 없음 → 보수 필요
        }

        // 기둥이 하나도 없는 열의 개수 세기
        int colNeed = 0;
        for (boolean has : colHasZero) {
            if (!has) colNeed++; // false면 해당 열에 기둥이 없음 → 보수 필요
        }

        // 핵심 아이디어:
        // 기둥 하나로 한 행과 한 열을 동시에 만족시킬 수 있기 때문에
        // 필요한 기둥의 최소 개수는 "기둥이 없는 행의 수"와 "기둥이 없는 열의 수" 중 더 큰 값
        System.out.println(Math.max(rowNeed, colNeed));
    }
}