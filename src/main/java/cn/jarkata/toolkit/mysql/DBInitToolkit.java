package cn.jarkata.toolkit.mysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DBInitToolkit {

    private static final Logger logger = LoggerFactory.getLogger(DBInitToolkit.class);

    /**
     * 初始化
     *
     * @param dataSource 数据源
     * @throws IOException 执行失败时抛出此异常
     */
    public static void init(DataSource dataSource) throws IOException {
        DBExecutor.execute(dataSource, getSqlList());
        logger.info("数据库脚本初始化完成");
    }

    /**
     * @return sql集合
     * @throws IOException 文件异常时返回
     */
    private static List<String> getSqlList() throws IOException {
        List<File> fileList = ResourceUtils.getFileList("sqlscript");
        List<String> sqlList = new ArrayList<>();
        for (File file : fileList) {
            String content = ResourceUtils.getContent(file);
            sqlList.add(content);
        }
        return sqlList;
    }

}
