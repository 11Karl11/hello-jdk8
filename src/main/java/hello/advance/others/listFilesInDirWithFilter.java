package hello.advance.others;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author karl xie
 */
public class listFilesInDirWithFilter {


    public static void main(String[] args) throws IOException {
        List<File> files = listFilesInDirWithFilter(new File("C:\\Users\\akang\\Desktop\\2.png"), (name) -> {
            return name.endsWith(".png");
        });
        System.out.println(files);
    }

    /***
     * 文件夹谓词匹配
     * @param file          文件
     * @param predicate     谓词匹配
     * @return              List<File>
     * @throws IOException  IOException
     */
    public static List<File> listFilesInDirWithFilter(File file, Predicate<String> predicate) throws IOException {
        if (!file.exists()) {
            throw new IOException("File is not exist.");
        }

        List<File> fileList = new ArrayList<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : Objects.requireNonNull(files)) {
                fileList.addAll(listFilesInDirWithFilter(f, predicate));
            }
        } else {
            if (predicate.test(file.getName())) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     *  重载可以让我们的方法调用方式变得丰富多彩，在语义明确的情况下，写代码有如神助，配合函数式编程，可以让工具类或者底层接口的能力大大增强。
     *
     * 同时，当我们需要调整某一个方法逻辑时，也可以使用继续重载的方式，将影响面降到最小，尽量不动其他模块的代码。
    */
    public static void readLine(BufferedReader br, Consumer<String> handle, boolean close) {
        String s;
        try {
            while (((s = br.readLine()) != null)) {
                handle.accept(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (close && br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 重载方法一
    public static void readLine(String path, Consumer<String> handle, boolean close) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            readLine(br, handle, close);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 重载方法二
    public static void readLine(String path, Consumer<String> handle) {
        readLine(path, handle, true);
    }


}