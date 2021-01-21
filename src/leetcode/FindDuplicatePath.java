package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在系统中查找重复文件
 * https://leetcode-cn.com/problems/find-duplicate-file-in-system/
 */
public class FindDuplicatePath {

    private static HashMap<String, List<String>> map;


    private static List<List<String>> findDuplicate(String[] paths) {
        map = new HashMap<>();

        for (String path : paths) {
            parse(path);
        }


        return map.values().stream().filter(list -> list.size() > 1).collect(Collectors.toList());
    }

    private static void parse(String path) {
        String[] dirAndFileAndContentsArr = path.split(" ");

        String dir = dirAndFileAndContentsArr[0];

        for (int i = 1; i < dirAndFileAndContentsArr.length; i++) {
            String str = dirAndFileAndContentsArr[i];

            int fileNameEndIdx = str.indexOf("(");
            String fileName = str.substring(0, fileNameEndIdx);
            String fileContent = str.substring(fileNameEndIdx + 1, str.length() - 1);

            List<String> list = map.get(fileContent);
            String absolutePath = dir + "/" + fileName;

            if (list == null) {
                list = new ArrayList<>();

                list.add(absolutePath);
                map.put(fileContent, list);
            } else {
                list.add(dir + "/" + fileName);
            }
        }

    }


    public static void main(String[] args) {
        findDuplicate(new String[]{ "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)" });
    }

}
