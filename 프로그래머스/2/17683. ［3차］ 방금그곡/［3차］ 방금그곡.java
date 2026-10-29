class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxLen = 0;
        
        m = convert(m);
        
        for (String musicinfo : musicinfos) {
            String[] info = musicinfo.split(",");
            
            int music_len = musicLength(info[0], info[1]);
            
            String origin_music = convert(info[3]);
            String new_music = "";
            
            while (new_music.length() < music_len) {
                int remain_l = music_len - new_music.length();
                
                if (remain_l >= origin_music.length()) {
                    new_music += origin_music;
                } else if (remain_l > 0) {
                    new_music += origin_music.substring(0, remain_l);
                }
            }
            
            if (m.length() > music_len) continue;
            
            for (int i = 0; i <= music_len - m.length(); i++) {
                if (m.equals(new_music.substring(i, i + m.length()))) {
                    if (music_len > maxLen) {
                        maxLen = music_len;
                        answer = info[2];
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int musicLength(String start, String end) {
        int start_m = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]);
        int end_m = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]);
        
        return end_m - start_m;
    }
    
    private String convert(String music) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < music.length(); i++) {
            char m = music.charAt(i);
            
            if (i + 1 < music.length() && music.charAt(i + 1) == '#') {
                result.append(Character.toLowerCase(m));
                i++;
            } else {
                result.append(m);
            }
        }
        
        return result.toString();
    }
}