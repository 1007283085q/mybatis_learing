package codingq.top.mybatis.session;

import codingq.top.mybatis.binding.MapperRegistry;
import codingq.top.mybatis.mapping.MappedStatement;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Configuration
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/6/1 10:52
 * @Version 1.0
 **/
public class Configuration {
    /**
     * 映射注册机
     */
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);
    /**
     * 映射语句存储在一个map对象里面
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
}

