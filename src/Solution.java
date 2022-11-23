import java.lang.*;
import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int w = picture.length;
        int h = picture[0].length;
        boolean[][] visit = new boolean[w][h];
        Stack<Node> st = new Stack<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (visit[i][j] || picture[i][j] == 0) {
                    continue;
                }
                visit[i][j] = true;
                st.push(new Node(i, j, picture[i][j]));
                int size = 1;
                while(!st.isEmpty()) {
                    Node now = st.pop();
                    for (int dir = 0; dir < 4; dir++) {
                        int xx = now.x + dx[dir];
                        int yy = now.y + dy[dir];
                        if (xx >= w || xx < 0 || yy >= h || yy < 0 || visit[xx][yy]) {
                            continue;
                        }
                        if (picture[xx][yy] != now.v) {
                            continue;
                        }
                        st.push(new Node(xx, yy, now.v));
                        visit[xx][yy] = true;
                        size++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                    }
                }
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
class Node {
    int x;
    int y;
    int v;

    Node (int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}