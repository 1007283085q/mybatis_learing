package codingq.top.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @ClassName codingq.top.mybatis.binding.MapperProxyFactory
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/5/29 16:54
 * @Version 1.0
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}
