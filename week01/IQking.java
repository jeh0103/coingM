// 우리만 아이큐 왕

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in); // Scanner 객체를 생성하여 사용자로부터 입력을 받습니다.

        int N = scanner.nextInt(); // 첫 번째 줄에서 학생 수 N을 입력받습니다.
        scanner.nextLine(); // nextInt() 후 남은 개행 문자를 처리하기 위해 한 줄을 넘깁니다.

        // 학생 정보를 저장할 리스트 생성 (이름과 IQ를 함께 저장)
        List<Student> students = new ArrayList<>();

        // N명의 학생 정보를 입력받아 리스트에 저장
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine(); // 한 줄을 입력받음
            String[] parts = line.split(" "); // 공백을 기준으로 이름과 IQ를 분리

            String name = parts[0]; // 이름 추출
            int iq = Integer.parseInt(parts[1]); // IQ를 정수형으로 변환

            students.add(new Student(name, iq, i)); // Student 객체 생성하여 리스트에 추가
        }

        // IQ가 높은 순으로 정렬하되, IQ가 같으면 입력 순서(index) 기준으로 정렬
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s2.iq != s1.iq) {
                    return s2.iq - s1.iq; // IQ 내림차순 정렬
                } else {
                    return s1.index - s2.index; // 입력 순서 기준 오름차순 정렬
                }
            }
        });

        // 상위 3명의 이름을 출력
        for (int i = 0; i < 3; i++) {
            System.out.println(students.get(i).name);
        }
    }

    // 학생 정보를 저장할 클래스 정의
    static class Student {
        String name; // 학생 이름
        int iq; // 학생 IQ
        int index; // 입력된 순서를 저장하기 위한 인덱스

        // 생성자: 이름, IQ, 인덱스를 받아 초기화
        public Student(String name, int iq, int index) {
            this.name = name;
            this.iq = iq;
            this.index = index;
        }
    }
}
