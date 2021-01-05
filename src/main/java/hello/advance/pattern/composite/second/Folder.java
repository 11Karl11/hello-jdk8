package hello.advance.pattern.composite.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @author karl xie
 */
public class Folder implements AbstractFile{

    private String name;
    private List<AbstractFile> subFiles;

    public Folder(String name) {
        this.name = name;
        subFiles = new ArrayList<AbstractFile>();
    }
    public void add(AbstractFile file) {
        subFiles.add(file);
    }
    public void remove(AbstractFile file) {
        subFiles.remove(file);
    }
    public AbstractFile getChild(int index) {
        return subFiles.get(index);
    }
    @Override
    public void killVirus() {
        System.out.println("---文件夹：" + name + ",进行查杀");
        for (AbstractFile file : subFiles) {
            file.killVirus();
        }
    }
}