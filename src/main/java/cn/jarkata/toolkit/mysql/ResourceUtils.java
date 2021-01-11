package cn.jarkata.toolkit.mysql;

import cn.jarkata.common.exception.NotFoundException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ResourceUtils {

    /**
     * 根据路径获取文件路径
     *
     * @param path 文件路径
     * @return 文件集合
     */
    public static List<File> getFileList(String path) {
        ClassLoader classLoader = ResourceUtils.class.getClassLoader();
        if (Objects.isNull(classLoader)) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        URL resource = classLoader.getResource(path);
        if (Objects.isNull(resource)) {
            throw new NotFoundException("0", "未找到路径：" + path);
        }
        String basicPath = resource.getPath();
        File file = new File(basicPath);
        File[] files = file.listFiles((innerFile) -> innerFile.getName().endsWith(".sql"));
        assert files != null;
        return Arrays.asList(files);

    }

    public static String getContent(File file) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] buf = new byte[1024];
        StringBuilder builder = new StringBuilder();
        int len = -1;
        while ((len = bis.read(buf)) != -1) {
            builder.append(new String(buf, 0, len));
        }
        return builder.toString();
    }
}
