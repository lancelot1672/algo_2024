package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] map = new char[N][M];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        // Start 0,0
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0));

        // Visit
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;


        int dist = 1;
        while (!q.isEmpty()){
            int size = q.size();
            for(int s=0; s<size; s++){
                Point now = q.poll();
                if(now.i == N-1 && now.j == M-1){
                    System.out.println(dist);
                    return;
                }
                //4-Direction Detection
                for(int d=0; d<4; d++){
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti < 0 || nexti >= N || nextj < 0 || nextj >= M) continue;
                    if(visited[nexti][nextj] || map[nexti][nextj] == '0') continue;

                    visited[nexti][nextj] = true;
                    q.add(new Point(nexti, nextj));
                }
            }
            dist++;
        }
    }
    static class Point{
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}

