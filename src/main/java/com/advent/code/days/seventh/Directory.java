package com.advent.code.days.seventh;

import java.util.ArrayList;
import java.util.List;

public class Directory {

    String name;

    List<Directory> childrens;
    Integer size;

    Integer totalSize;

    List<File> files;

    public Directory(String name) {
        this.name = name;
    }

    public void addChildren(Directory directory) {
        if (childrens == null) {
            childrens = new ArrayList<>();
        }
        childrens.add(directory);
    }

    public void addFile(File file) {
        if (files == null) {
            files = new ArrayList<>();
        }
        files.add(file);
    }

    public Integer getSize() {
        return size;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", childrens=" + childrens +
                ", size=" + size +
                ", totalSize=" + totalSize +
                ", files=" + files +
                '}';
    }
}
