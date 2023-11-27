import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int p = sc.nextInt();
        int ans = 0;
        char[] dnaAlphabet = sc.next().toCharArray();
        Map<Character, Integer> ansAlphabetCnt = new HashMap<>();
        ansAlphabetCnt.put('A', sc.nextInt());
        ansAlphabetCnt.put('C', sc.nextInt());
        ansAlphabetCnt.put('G', sc.nextInt());
        ansAlphabetCnt.put('T', sc.nextInt());

        Map<Character, Integer> curAlphabetCnt = new HashMap<>();
        for (int i=0; i < p; i++) {
            curAlphabetCnt.put(dnaAlphabet[i], curAlphabetCnt.getOrDefault(dnaAlphabet[i], 0) + 1);
        }

        if (compareAnsAlphabetCnt(curAlphabetCnt, ansAlphabetCnt)) {
            ans++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            curAlphabetCnt.put(dnaAlphabet[j], curAlphabetCnt.get(dnaAlphabet[j]) - 1);
            curAlphabetCnt.put(dnaAlphabet[i], curAlphabetCnt.getOrDefault(dnaAlphabet[i], 0) + 1);

            if (compareAnsAlphabetCnt(curAlphabetCnt, ansAlphabetCnt)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean compareAnsAlphabetCnt(Map<Character, Integer> curAlphabet, Map<Character, Integer> ansAlphabet) {
        for (Entry<Character, Integer> ansEntry : ansAlphabet.entrySet()) {
            if (curAlphabet.getOrDefault(ansEntry.getKey(), 0) < ansEntry.getValue()) {
                return false;
            }
        }
        return true;
    }
}