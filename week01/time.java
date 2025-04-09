// 이별 30분전

import java.io.*;
import java.util.*;

// don't change 'Main' class name and 'public' accessor.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int hour = scanner.nextInt(); // 시간
        int minute = scanner.nextInt(); // 분

        // 30분을 빼는 로직
        minute -= 30;
        if (minute < 0) {
            minute += 60;
            hour--;
            if (hour < 0) {
                hour = 23;
            }
        }

        System.out.println(hour + " " + minute);
    }
}

// 작동 원리:
// 먼저 분에서 30을 뺍니다.

// 만약 분이 음수가 되면(0보다 작아지면), 60을 더해주고 시간을 1시간 줄입니다.

// 만약 시간이 0보다 작아지면 23으로 설정합니다. (24시간제이므로)
