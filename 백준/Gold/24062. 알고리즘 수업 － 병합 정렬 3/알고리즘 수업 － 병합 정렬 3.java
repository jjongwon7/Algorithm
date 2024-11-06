import java.io.*;

public class Main {

    static int n;
    static int[] arrA, arrB;
    static int arrBIdx = 0;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        arrB = new int[n];
        temp = new int[n];

        String[] splitA = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(splitA[i]);
        }

        String[] splitB = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arrB[i] = Integer.parseInt(splitB[i]);
        }

        mergeSort(0, arrA.length - 1);

        System.out.println(0);
    }

    private static void mergeSort(int p, int r) {
        if (compareArrAndIfSameReturnTrue()) {
            printResultAndExit(1);
        }

        if(p >= r) return;

        int q = (p + r) / 2;
        mergeSort(p, q);
        mergeSort(q+1, r);
        merge(p, q, r);
    }

    private static void merge(int left, int mid, int right) {
        int div1Idx = left;
        int div2Idx = mid + 1;
        int tempIdx = 0;

        while (div1Idx <= mid && div2Idx <= right) {
            if (arrA[div1Idx] <= arrA[div2Idx]) {
                temp[tempIdx++] = arrA[div1Idx++];
            } else {
                temp[tempIdx++] = arrA[div2Idx++];
            }
        }

        while (div1Idx <= mid) {
            temp[tempIdx++] = arrA[div1Idx++];
        }

        while (div2Idx <= right) {
            temp[tempIdx++] = arrA[div2Idx++];
        }

        div1Idx = left;
        tempIdx = 0;

        while (div1Idx <= right) {
            if (arrA[div1Idx] != temp[tempIdx]) {
                if (div1Idx < arrBIdx) {
                    printResultAndExit(0);
                }

                arrA[div1Idx++] = temp[tempIdx++];

                if (compareArrAndIfSameReturnTrue()) {
                    printResultAndExit(1);
                }
            } else {
                div1Idx++;
                tempIdx++;
            }
        }
    }

    private static boolean compareArrAndIfSameReturnTrue() {
        for (; arrBIdx < n; arrBIdx++) {
            if (arrBIdx == -1) {
                arrBIdx = 0;
            }


            if (arrA[arrBIdx] != arrB[arrBIdx]) {
                arrBIdx--;
                return false;
            }
        }

        return true;
    }

    private static void printResultAndExit(int result) {
        System.out.println(result);
        System.exit(0);
    }
}