package hello.advance.pattern.composite.second;

/**
 * @author karl xie
 */
public class Test {

    public static void main(String[] args) {
        Folder folder = new Folder("我的收藏");
        AbstractFile image = new ImageFile("xxx.jpg");
        AbstractFile text = new TextFile("xxx.txt");
        folder.add(image);
        folder.add(text);
        Folder folder2 = new Folder("子文件夹");
        AbstractFile image2 = new ImageFile("xxx2.jpg");
        AbstractFile text2 = new TextFile("xxx2.txt");
        folder2.add(image2);
        folder2.add(text2);
        folder.add(folder2);
        folder.killVirus();
    }
}