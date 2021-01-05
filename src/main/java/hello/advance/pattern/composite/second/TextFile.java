package hello.advance.pattern.composite.second;

/**
 * @author karl xie
 */
public class TextFile implements AbstractFile{

    private String name;

    public TextFile(String name) {
        this.name = name;
    }
    @Override
    public void killVirus() {
        System.out.println("---文本文件：" + name + ",进行查杀！");
    }
}