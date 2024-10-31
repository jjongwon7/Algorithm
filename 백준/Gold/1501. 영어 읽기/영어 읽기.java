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
            String sentence = br.readLine();
            sb.append(translate(sentence)).append("\n");
        }

        System.out.println(sb);
    }

    private static void addWordToDictionary(String word) {
        // 단어 길이가 4보다 작으면 한 가지 해석만 가능하므로 따로 관리
        if (word.length() < 4) {
            dictionaryAboutShortWords.add(word);
            return;
        }

        // ex) abcd -> ad
        String firstAndLastCharacter = String.valueOf(word.charAt(0)) + word.charAt(word.length() - 1);

        if (!dictionaryAboutLongWords.containsKey(firstAndLastCharacter)) {
            dictionaryAboutLongWords.put(firstAndLastCharacter, new HashMap<>());
        }

        // key: 단어의 맨 앞과 뒤 문자를 제거하고 사전순으로 정렳한 문자열, value: 그런 문자열의 개수
        Map<String, Integer> map = dictionaryAboutLongWords.get(firstAndLastCharacter);

        String sortedAndRemovedFirstAndLastCharacter = sortAndRemoveFirstAndLastCharacter(word);

        map.put(sortedAndRemovedFirstAndLastCharacter,
                map.getOrDefault(sortedAndRemovedFirstAndLastCharacter, 0) + 1);
    }

    private static String sortAndRemoveFirstAndLastCharacter(String word) {
        // ex) abcd -> bc
        String removedFirstAndLastCharacter = word.substring(1, word.length() - 1);
        char[] chars = removedFirstAndLastCharacter.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static int translate(String sentence) {
        String[] words = sentence.split(" ");
        int count = 1;
        boolean translateYn = false;

        for (String word : words) {
            // 단어 길이가 4보다 작으면 한 가지 해석만 가능
            if (word.length() < 4) {
                if (dictionaryAboutShortWords.contains(word)) {
                    translateYn = true;
                    continue;
                }
            }

            String firstAndLastCharacter = String.valueOf(word.charAt(0)) + word.charAt(word.length() - 1);

            if (!dictionaryAboutLongWords.containsKey(firstAndLastCharacter)) {
                continue;
            }

            Map<String, Integer> map = dictionaryAboutLongWords.get(firstAndLastCharacter);
            String sortedAndRemovedFirstAndLastCharacter = sortAndRemoveFirstAndLastCharacter(word);

            if (map.containsKey(sortedAndRemovedFirstAndLastCharacter)) {
                translateYn = true;
                count *= map.get(sortedAndRemovedFirstAndLastCharacter);
            }
        }

        return translateYn ? count : 0;
    }
}