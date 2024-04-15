import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // genres: 고유번호가 i인 노래의 장르
        // plays: 고유번호가 i인 노래가 재생된 횟수
        // 장르에 속한 곡이 하나라면, 하나의 곡만 선택
        // 모든 장르는 재생된 횟수가 다름

        int musicSize = genres.length;

        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록한다.
        Map<String, Integer> genresMap = new HashMap<>();
        Map<String, ArrayList<Music>> musicMap = new HashMap<>();
        // 장르별 재생 횟수 저장
        for(int musicNum=0; musicNum<musicSize; musicNum++) {
            genresMap.put(genres[musicNum], genresMap.getOrDefault(genres[musicNum], 0) + plays[musicNum]);
            if (!musicMap.containsKey(genres[musicNum])) {
                musicMap.put(genres[musicNum], new ArrayList<>());
            }
            musicMap.get(genres[musicNum]).add(new Music(musicNum, plays[musicNum]));
        }

        PriorityQueue<MusicGenre> pQ = new PriorityQueue<>();

        for(String genre : genresMap.keySet()) {
            pQ.offer(new MusicGenre(genre, genresMap.get(genre)));
        }

        ArrayList<Integer> ansList = new ArrayList<>();

        while(!pQ.isEmpty()) {
            // 재생수가 가장 많은 장르 추출
            MusicGenre musicGenre = pQ.poll();

            // 장르 내에서 재생수가 가장 많은 노래 추출
            PriorityQueue<Music> musicPQ = new PriorityQueue<>();
            
            for(Music music : musicMap.get(musicGenre.genre)) {
                musicPQ.offer(music);
            }
            // 최소한 1개는 존재함
            int saveCnt = 0;
            while(!musicPQ.isEmpty() && saveCnt < 2) {
                Music music = musicPQ.poll();
                ansList.add(music.musicNum);
                saveCnt++;
            }
        }

        int[] answer = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
    
    static class MusicGenre implements Comparable<MusicGenre> {
        String genre;
        int totalCnt;
        
        public MusicGenre(String genre, int totalCnt) {
            this.genre = genre;
            this.totalCnt = totalCnt;
        }
        
        @Override
        public int compareTo(MusicGenre m) {
            return m.totalCnt - this.totalCnt;
        }
    }
    
    static class Music implements Comparable<Music> {
        int musicNum;
        int cnt;
        
        public Music(int musicNum, int cnt) {
            this.musicNum = musicNum;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Music m) {
            if(this.cnt == m.cnt) {
                return this.musicNum - m.musicNum;
            }
            else {
                return m.cnt - this.cnt;
            }
        }
    }
}