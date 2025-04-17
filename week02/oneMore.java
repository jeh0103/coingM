// 떡 하나 주면 안 잡아먹지지

// don't place package name.  
 
import java.io.*; 
import java.util.*;  
 
// don't change 'Main' class name and  'public' accessor.  
 
public class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
  
        int N = scanner.nextInt(); 
 
        // 격자에 있는 떡의 개수
        int[][] map = new int[N][N]; 
        // 각 위치로 가는 최소 떡 개수
        int[][] dist = new int[N][N]; 
         
        // 상하좌우 
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1}; 
 
        // 격자에 호랑이 떡 요구량 입력받기 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) { 
                map[i][j] = scanner.nextInt(); 
                dist[i][j] = Integer.MAX_VALUE;  // 시작 전엔 최소 떡 개수를 무한
            } 
        } 
 
        // 시작점
        dist[0][0] = map[0][0]; 
 
        // 우선순위 큐 (다익스트라를 위한 최소 힙) 
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost); 
        pq.offer(new Point(0, 0, map[0][0]));  // 시작점 넣기 
 
        // 다익스트라 알고리즘 
        while (!pq.isEmpty()) { 
            Point current = pq.poll(); 
 
            int x = current.x; 
            int y = current.y; 
            int cost = current.cost; 
 
            // 현재 위치의 떡을 주는 비용보다 더 적은 비용으로 방문할 수 있다면 
            for (int dir = 0; dir < 4; dir++) { 
                int nx = x + dx[dir]; 
                int ny = y + dy[dir]; 
 
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) { 
                    int newCost = cost + map[nx][ny]; 
 
                    if (newCost < dist[nx][ny]) { 
                        dist[nx][ny] = newCost; 
                        pq.offer(new Point(nx, ny, newCost)); 
                    } 
                } 
            } 
        } 
 
        System.out.println(dist[N-1][N-1]); 
    } 
  
    static class Point { 
        int x, y, cost; 
 
        Point(int x, int y, int cost) { 
            this.x = x; 
            this.y = y; 
            this.cost = cost; 
        } 
    } 
}
