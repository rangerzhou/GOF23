package structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private final String folderName;
    private final List<FileSystemComponent> componentList = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public void showDetails() {
        System.out.println("文件夹: " + folderName + " (大小: " + getSize() + "KB)");
        for (FileSystemComponent component : componentList) {
            component.showDetails();
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : componentList) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    public void add(FileSystemComponent component) {
        componentList.add(component);
    }

    public void remove(FileSystemComponent component) {
        componentList.remove(component);
    }
}
