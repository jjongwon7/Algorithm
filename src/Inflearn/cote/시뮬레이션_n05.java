package Inflearn.cote;

public class 시뮬레이션_n05 {

    public static int solution(int[] num){

        int cur = 0;
        int max = 0;

        for (int i = 1; i < num.length - 1; i++) {
            if (num[i - 1] < num[i] && num[i] > num[i + 1]) {
                int j = i;
                int k = i;
                // 꼭지점의 왼쪽 부분(증가)
                while (j > 0 && num[j-1] < num[j]) {
                    j--;
                }
                // 꼭지점의 오른쪽 부분(감소)
                while (k < num.length - 1 && num[k] > num[k + 1]) {
                    k++;
                }
                cur = k - j + 1;
                max = Math.max(max, cur);
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }

}
