import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    final static Map<String, Map<String, Integer>> dictionaryAboutLongWords = new HashMap<>();
    final static Set<String> dictionaryAboutShortWords = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            addWordToDictionary(br.readLine());
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(translate(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    private static void addWordToDictionary(String word) {
        // 단어 길이가 4보다 작으면 한 가지 해석만 가능하므로 따로 관리
        if (word.length() < 4) {
            dictionaryAboutShortWords.add(word);
            return;
        }

        // 첫과 마지막 단어 추출
        String firstAndLastCharacter = String.valueOf(word.charAt(0)) + word.charAt(word.length() - 1);
        dictionaryAboutLongWords.putIfAbsent(firstAndLastCharacter, new HashMap<>());

        // 첫과 마지막 단어 제거 후 정렬된 문자열
        String removedFirstAndLastCharacterAndSorted = RemoveFirstAndLastCharacterAndSort(word);

        // map에 개수 추가
        Map<String, Integer> translationCountMap = dictionaryAboutLongWords.get(firstAndLastCharacter);
        translationCountMap.put(removedFirstAndLastCharacterAndSorted,
                translationCountMap.getOrDefault(removedFirstAndLastCharacterAndSorted, 0) + 1);
    }

    private static String RemoveFirstAndLastCharacterAndSort(String word) {
        // 첫과 마지막 문자 제거 후 정렬
        String removedFirstAndLastCharacter = word.substring(1, word.length() - 1);
        char[] chars = removedFirstAndLastCharacter.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static int translate(String sentence) {
        String[] words = sentence.split(" ");
        int translationCount = 1;
        boolean translateYn = false;

        for (String word : words) {
            // 단어 길이가 4보다 작으면 한 가지 해석만 가능
            if (word.length() < 4) {
                if (dictionaryAboutShortWords.contains(word)) {
                    translateYn = true;
                }
                continue;
            }

            // 첫과 마지막 단어 추출
            String firstAndLastCharacter = String.valueOf(word.charAt(0)) + word.charAt(word.length() - 1);

            // 사전에 단어가 존재하지 않는 경우 예외 처리
            if (!dictionaryAboutLongWords.containsKey(firstAndLastCharacter)) {
                continue;
            }

            Map<String, Integer> translationCountMap = dictionaryAboutLongWords.get(firstAndLastCharacter);
            String removedFirstAndLastCharacterAndSorted = RemoveFirstAndLastCharacterAndSort(word);

            // 해석 가능한 경우 translationCount 갱신
            if (translationCountMap.containsKey(removedFirstAndLastCharacterAndSorted)) {
                translateYn = true;
                translationCount *= translationCountMap.get(removedFirstAndLastCharacterAndSorted);
            }
        }

        return translateYn ? translationCount : 0;
    }
}