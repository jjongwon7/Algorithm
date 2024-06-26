import java.io.*;
import java.util.*;

public class Main {

    static Map<String, List<FileSystem>> entityMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // main 하위 폴더 총 개수
        int m = Integer.parseInt(st.nextToken()); // 파일의 총 개수

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken(); // 상위 폴더 이름
            String f = st.nextToken(); // 폴더 또는 파일의 이름
            int c = Integer.parseInt(st.nextToken()); // 1: F가 폴더, 0: F가 파일

            if (entityMap.containsKey(p)) {
                entityMap.get(p).add(new FileSystem(f, c));
            } else {
                entityMap.put(p, new ArrayList<>(Arrays.asList(new FileSystem(f, c))));
            }
        }

        int q = Integer.parseInt(br.readLine()); // 쿼리의 개수
        for (int i = 0; i < q; i++) {
            String path = br.readLine();
            String[] split = path.split("/");
            String targetDirectoryName = split[split.length - 1];

            Set<String> subDirectoryFileSet = new HashSet<>();
            int totalFileCnt = readEverySubfolderOf(targetDirectoryName, subDirectoryFileSet);

            System.out.println(subDirectoryFileSet.size() + " " + totalFileCnt);
        }
    }

    public static int readEverySubfolderOf(String targetDirectoryName, Set<String> fileNameSet) {
        int totalFileCnt = 0; // 파일 총 개수

        if (!entityMap.containsKey(targetDirectoryName)) {
            return totalFileCnt;
        }

        List<FileSystem> fileSystems = entityMap.get(targetDirectoryName);
        for (FileSystem fileSystem : fileSystems) {
            // 폴더인 경우
            if (fileSystem.type == 1) {
                totalFileCnt += readEverySubfolderOf(fileSystem.name, fileNameSet);
            }
            // 파일인 경우
            else {
                fileNameSet.add(fileSystem.name);
                totalFileCnt++;
            }
        }

        return totalFileCnt;
    }

    public static class FileSystem {
        String name;
        int type; // 1: 폴더, 0: 디렉토리

        public FileSystem(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }
}