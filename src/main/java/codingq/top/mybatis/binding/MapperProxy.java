package codingq.top.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @ClassName codingq.top.mybatis.binding.MapperProxy
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/5/29 16:48
 * @Version 1.0
 **/
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729838L;
    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    /**
     * 这个方法是整个拦截进行实际处理的核心方法，
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            //判断传入方法是否是直接归属于object方法比如hash之类的方法
            //如果归属于则直接执行
            return method.invoke(this, args);
        }
        else {
            //如果不是返回一个代表这个类已经被代理的方式，实际情况可能是直接执行对应的xml解析出来的语句
            return "返回一个代理增强类" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
