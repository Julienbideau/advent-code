package com.advent.code.days.seventh;

import java.util.ArrayList;
import java.util.List;

public class InputValue {

    List<Directory> directories;
    List<File> files;

    public void addFile(File file) {
        if (files == null) {
            files = new ArrayList<>();
        }
        files.add(file);
    }

    public InputValue() {
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }

    public void addDirectory(Directory directory) {
        if (directories == null) {
            directories = new ArrayList<>();
            directories.add(directory);
        } else {
            directories.add(directory);
        }
    }

    public Directory findDirectoryByName(String name, List<Directory> directories, List<Directory> rootDirectories) {
        if ("/".equals(name)) {
            return new Directory("/");
        }
        if (directories != null) {
            for (Directory directory : directories) {
                if (directory.name.equals(name)) {
                    return directory;
                }
            }
            for (Directory directory : directories) {
                if (directory.childrens != null) {
                    return findDirectoryByName(name, directory.childrens, null);
                }
            }
        } else {
            for (Directory directory : rootDirectories) {
                if (directory.name.equals(name)) {
                    return directory;
                }
            }
        }

        return new Directory("/");
    }

    public Directory findParentDirectoryByName(String name, List<Directory> directories) {
        for (Directory directory : directories) {
            if (directory.childrens != null && directory.childrens.stream().anyMatch(children -> children.name.equals(name))) {
                return directory;
            }
        }
        for (Directory directory : directories) {
            if (directory.childrens != null) {
                return findDirectoryByName(name, directory.childrens, null);
            }
        }
        return new Directory("/");
    }

    public void fillSize(List<Directory> directories) {
        for (Directory directory : directories) {
            if (directory.files != null) {
                directory.size = directory.files.stream().map(File::getSize).mapToInt(Integer::intValue).sum();
                directory.totalSize = directory.size;
            } else {
                directory.size = 0;
            }

            if (directory.childrens != null) {

                fillSize(directory.childrens);
            }
        }
    }

    public void sumSizes(List<Directory> directories) {
        for (Directory directory : directories) {
            if (directory.childrens != null) {
                directory.totalSize = directory.size + getChildrenSize(directory.childrens);
            } else {
                directory.totalSize = directory.size;
            }

        }
    }

    public Integer getChildrenSize(List<Directory> directories) {
        int sum = directories.stream().map(Directory::getSize).mapToInt(Integer::intValue).sum();
        for (Directory directory : directories) {
            if (directory.childrens != null) {

                Integer childrenSize = getChildrenSize(directory.childrens);
                directory.totalSize = directory.size + childrenSize;
                sum = sum + childrenSize;
            }
        }
        return sum;
    }

    public Integer getTotalSize(List<Directory> directories) {
        int sum = directories.stream().filter(directory -> directory.totalSize != null).filter(directory -> directory.totalSize <= 100000).map(Directory::getTotalSize).mapToInt(Integer::intValue).sum();
        for (Directory directory : directories) {
            if (directory.childrens != null && directory.totalSize <= 100000) {
                sum = sum + getTotalSize(directory.childrens);
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return "InputValue{" +
                "directories=" + directories +
                '}';
    }
}
