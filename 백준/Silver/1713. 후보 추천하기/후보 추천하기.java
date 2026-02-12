import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
    int id;
    int count;
    int time;

    public Student(int id, int count, int time) {
        this.id = id;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}

public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N, K;
    ArrayList<Student> pics = new ArrayList<>();

    void solution() throws Exception {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int sId = Integer.parseInt(st.nextToken());

            boolean flag = false;
            for (Student s : pics) {
                if (s.id == sId) {
                    s.count++;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (pics.size() >= N) {
                    pics.sort((s1, s2) -> {
                        if (s1.count == s2.count) {
                            return s1.time - s2.time;
                        }
                        return s1.count - s2.count;
                    });

                    pics.remove(0);
                }

                pics.add(new Student(sId, 1, i));
            }
        }

        Collections.sort(pics);

        for (Student s : pics) {
            sb.append(s.id).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}