import java.io.*;
import java.util.*;

class People {
	int level;
	String name;
	
	public People(int level, String name) {
		this.level = level;
		this.name = name;
	}
}

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	
	public void solution() throws Exception {
		st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<List<People>> room = new ArrayList<>();
		
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			
			int l = Integer.parseInt(st.nextToken());
			String n = st.nextToken();
			People new_people = new People(l, n);
			
			int room_size = room.size();
			boolean flag = false; // 새로운 방 여부
			
			for (List<People> pl: room) {
				if (Math.abs(pl.get(0).level - l) <= 10 && pl.size() < m) {
					pl.add(new_people);
					flag = true;
					break;
				}
			}
			
			if (!flag) {
				List<People> peopleList = new ArrayList<>();
				peopleList.add(new_people);
				room.add(peopleList);
			}
		}
		
		for (List<People> r : room) {
			if (r.size() == m) {
				sb.append("Started!").append("\n");
			} else {
				sb.append("Waiting!").append("\n");
			}
			
			List<People> sortedList = r;
			Collections.sort(sortedList, (o1, o2) -> {
				return o1.name.compareTo(o2.name);
			});
			
			for (People pl : r) {
				sb.append(pl.level).append(" ").append(pl.name).append("\n");
			}
		}
		
		System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}