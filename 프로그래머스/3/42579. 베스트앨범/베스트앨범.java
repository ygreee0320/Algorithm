import java.util.*;

class Solution {
    static class Song implements Comparable<Song> {
        int id;
        int play;
            
        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
            
        @Override
        public int compareTo(Song o) {
            if (this.play == o.play) {
                return this.id - o.id; // 오름차순
            }
                
            return o.play - this.play; // 내림차순
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        
        // 장르별 총 재생 횟수
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 리스트
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!genreSongs.containsKey(genres[i])) {
                genreSongs.put(genres[i], new ArrayList<>());
            }
            
            genreSongs.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            Collections.sort(songs); // 정의한 대로 정렬
            
            for (int i = 0; i < songs.size() && i < 2; i++) {
                answer.add(songs.get(i).id);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}