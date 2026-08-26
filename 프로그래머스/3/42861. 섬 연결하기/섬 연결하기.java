import java.util.*;

class Solution {
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int selected = 0;
        
        // 비용 기준 오름차순 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기화(자기 자신을 부모로)
        }
        
        // 비용이 낮은 간선부터 확인
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2];
            
            if (union(a, b)) {
                answer += c;
                selected++;
            }
                        
            if (selected == n - 1) {
                break;
            }
        }
        
        return answer;
    }
    
    // 해당 노드가 속한 그룹의 대표 노드 찾기
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        
        parent[node] = find(parent[node]);
        return parent[node];
    }
    
    // 두 그룹 합치기
    private boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return false;
        }
        
        parent[rootB] = rootA;
        return true;
    }
}