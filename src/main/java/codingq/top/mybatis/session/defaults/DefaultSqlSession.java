package codingq.top.mybatis.session.defaults;

import codingq.top.mybatis.binding.MapperRegistry;
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
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }
    @Override
    public <T> T selectOne(String statement) {
        return (T) ("你被代理了！" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

}
