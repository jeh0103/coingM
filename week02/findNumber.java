// 내 이름이 적힌 번호 찾기기

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        Scanner scanner = new Scanner(System.in);
        
        // 첫 번째 줄: 이름의 수 N과 영덕이의 영어 이름
        int N = scanner.nextInt();
        String targetName = scanner.next();
        
        // 두 번째 줄: 이름 목록
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            names[i] = scanner.next();
        }
        
        // 영덕이의 이름이 몇 번째로 등장하는지 찾아 출력
        for (int i = 0; i < N; i++) {
            if (names[i].equals(targetName)) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
