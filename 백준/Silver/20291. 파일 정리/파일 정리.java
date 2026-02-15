import java.io.*;
import java.util.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> types = new TreeMap<>();

    void solution() throws Exception {
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String newFile = br.readLine();
            String newType = newFile.split("\\.")[1];

            if (types.containsKey(newType)) {
                types.put(newType, types.get(newType) + 1);
            } else {
                types.put(newType, 1);
            }
        }

        for (String key : types.keySet()) {
            sb.append(key).append(" ").append(types.get(key)).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}