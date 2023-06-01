package codingq.top.mybatis.binding;

import codingq.top.mybatis.binding.dao.IUserDao;
import codingq.top.mybatis.session.SqlSession;
import codingq.top.mybatis.session.SqlSessionFactory;
import codingq.top.mybatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ApiTest
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/5/29 16:57
 * @Version 1.0
 **/
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);
    @Test
    public void test_MapperProxyFactory() {
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("codingq.top.mybatis.binding.dao");

        SqlSessionFactory sqlSessionFactory=new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        String res = mapper.queryUserName("10001");
        logger.info("测试结果：{}", res);
    }
    @Test
    public void test_proxy_class() {
        IUserDao userDao = (IUserDao) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class}, (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果：" + result);
    }
}
