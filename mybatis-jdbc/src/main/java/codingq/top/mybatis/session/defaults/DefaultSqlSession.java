package codingq.top.mybatis.session.defaults;

import codingq.top.mybatis.binding.MapperRegistry;
import codingq.top.mybatis.mapping.MappedStatement;
import codingq.top.mybatis.session.Configuration;
import codingq.top.mybatis.session.SqlSession;

/**
 * @ClassName DefaultSqlSession
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/5/30 15:39
 * @Version 1.0
 **/
public class DefaultSqlSession implements SqlSession {
    /**
     * 映射器注册机
     */
    private Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }
    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        MappedStatement mappedStatement = configuration.getMappedStatement(statement);
        return (T) ("你被代理了！" + "\n方法：" + statement + "\n入参：" + parameter + "\n待执行SQL：" + mappedStatement.getSql());
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }
    @Override
    public Configuration getConfiguration() {
        return configuration;
    }

}
