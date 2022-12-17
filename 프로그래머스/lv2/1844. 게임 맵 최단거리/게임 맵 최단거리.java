import java.util.*;

class Solution {
    
    int [] dx = {1,0,-1,0};
    int [] dy = {0,1,0,-1};
    
    Queue<Point> q = new LinkedList<>();
    
    public int solution(int[][] maps) {
        int answer = 0;
        boolean [][] visited = new boolean [maps.length][maps[0].length];
        int [][] cnts = new int [maps.length][maps[0].length];
        bfs(visited, maps, cnts);
        answer = cnts[maps.length-1][maps[0].length-1];
        if(answer == 0)
            return -1;
        return answer;
    }
    
    public void bfs(boolean [][] visited, int[][] maps, int [][] cnts){
        
        visited[0][0] = true;
        q.offer(new Point(0,0));
        
        while(!q.isEmpty()){
            Point point = q.poll();
            int x = point.x;
            int y = point.y;
            cnts[0][0] = 1;
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx > maps.length-1 || nx < 0 || ny > maps[0].length-1 || ny < 0)
                    continue;
                if(visited[nx][ny] == false && maps[nx][ny] == 1){
                    q.offer(new Point(nx, ny));
                    cnts[nx][ny] =  cnts[x][y] + 1;
                    //System.out.println("x : " + nx + " y : " + ny + " cnt : " + cnts[nx][ny]);
                    visited[nx][ny] = true;
                }
                
            }
        }
    }
}

class Point{
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}