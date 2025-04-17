// 몇 번씩 나올까

import java.io.*; 
import java.util.*; 
 
public class Main { 
    public static void main(String[] args) throws IOException { 
   
        Scanner scanner = new Scanner(System.in); 
        int N = scanner.nextInt();  
         
        int[] count = new int[10]; 
         
        for (int i = 1; i <= N; i++) { 
            // 현재 숫자를 문자열로 변환하여 각 자릿수를 확인 
            String number = String.valueOf(i); 
            for (char c : number.toCharArray()) { 
                // 각 자릿수의 숫자를 정수로 변환하여 카운트 배열에 증가 
                count[c - '0']++; 
            } 
        } 
 
        for (int i = 0; i < 10; i++) { 
            System.out.print(count[i] + \" \"); 
        } 
    } 
} 
