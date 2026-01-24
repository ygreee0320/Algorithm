import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n;

    void solution() throws IOException {
        n = Integer.parseInt(br.readLine());
        int res = 0;
        int digit = 1;
        int start = 1;

        while (start <= n) {
            int end = Math.min(n, start * 10 - 1);
            res += (end - start + 1) * digit;
            digit += 1;
            start *= 10;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
