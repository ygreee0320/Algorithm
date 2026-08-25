import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int n = 0; // 총 노드 수
        
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }
        
        int[] inDegree = new int[n + 1]; // 나가는 간선 수
        int[] outDegree = new int[n + 1]; // 들어오는 간선 수
        boolean[] exists = new boolean[n + 1];
        
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            
            outDegree[a]++;
            inDegree[b]++;
            
            exists[a] = true;
            exists[b] = true;
        }
        
        int createdNode = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!exists[i]) {
                continue;
            }
            
            if (inDegree[i] == 0 && outDegree[i] >= 2) {
                createdNode = i;
                break;
            }
        }
        
        int stick = 0; // 막대
        int eight = 0; // 8자
        
        for (int i = 1; i <= n; i++) {
            if (!exists[i] || i == createdNode) {
                continue;
            }
            
            if (outDegree[i] == 0) {
                stick++;
            } else if (inDegree[i] >= 2 && outDegree[i] >= 2) {
                eight++;
            }
        }
        
        int total = outDegree[createdNode];
        int donut = total - stick - eight;
        
        return new int[]{createdNode, donut, stick, eight};
    }
}