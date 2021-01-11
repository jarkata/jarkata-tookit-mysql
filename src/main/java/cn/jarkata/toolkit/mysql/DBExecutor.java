package cn.jarkata.toolkit.mysql;

import cn.jarkata.common.exception.DBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBExecutor {

    private final static Logger logger = LoggerFactory.getLogger(DBExecutor.class);

    /**
     * 执行sql脚本
     *
     * @param dataSource 数据源
     * @param sqlList    sql脚本
     */
    public static void execute(DataSource dataSource, List<String> sqlList) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
        ) {
            String tmpSql = null;
            try {
                connection.setAutoCommit(false);
                for (String sql : sqlList) {
                    tmpSql = sql;
                    statement.execute(sql);
                }
                statement.closeOnCompletion();
                connection.commit();
            } catch (Exception ex) {
                logger.warn("execute sql fail,sq={}", tmpSql);
                connection.rollback();
                throw ex;
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            logger.warn("数据库执行失败", ex);
            throw new DBException("9", ex.getMessage());
        }
    }

}
