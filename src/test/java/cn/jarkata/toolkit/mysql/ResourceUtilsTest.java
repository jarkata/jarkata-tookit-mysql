package cn.jarkata.toolkit.mysql;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ResourceUtilsTest {

    @Test
    public void getFileList() throws IOException {
        List<File> fileList = ResourceUtils.getFileList("sqlscript");
        System.out.println(fileList);
        for (File file : fileList) {
            String content = ResourceUtils.getContent(file);
            System.out.println(content);
        }
    }
}