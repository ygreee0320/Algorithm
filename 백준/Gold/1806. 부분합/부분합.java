import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    void solution() throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        while (true) {
            if (sum >= S) {
                res = Math.min(res, right - left);
                sum -= nums[left];
                left++;
            } else if (right == N) {
                break;
            } else {
                sum += nums[right];
                right++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}