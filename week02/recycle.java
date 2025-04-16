// 분리수거장

import java.io.*;
import java.util.*;

public class Main {
    static class Apartment implements Comparable<Apartment> {
        int index;      // 단지 번호 (1부터 시작)
        int location;   // 위치 D[i]
        int people;     // 거주 인원 A[i]

        public Apartment(int index, int location, int people) {
            this.index = index;
            this.location = location;
            this.people = people;
        }

        @Override
        public int compareTo(Apartment o) {
            return Integer.compare(this.location, o.location); // 위치 기준 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Apartment> list = new ArrayList<>();

        long totalPeople = 0;
        for (int i = 1; i <= N; i++) {
            int location = sc.nextInt();
            int people = sc.nextInt();
            list.add(new Apartment(i, location, people));
            totalPeople += people;
        }

        // 위치 기준 정렬
        Collections.sort(list);

        // 누적 인원 수를 계산하며 전체 인원의 절반 이상이 되는 단지를 찾음
        long prefixSum = 0;
        for (Apartment apt : list) {
            prefixSum += apt.people;
            if (prefixSum >= (totalPeople + 1) / 2) { // 절반 이상이면
                System.out.println(apt.index);
                break;
            }
        }
    }
}
