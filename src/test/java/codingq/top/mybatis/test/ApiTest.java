package codingq.top.mybatis.test;

import codingq.top.mybatis.io.Resources;
import codingq.top.mybatis.session.SqlSession;
import codingq.top.mybatis.session.SqlSessionFactory;
import codingq.top.mybatis.session.SqlSessionFactoryBuilder;
import codingq.top.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;

/**
 * @ClassName ApiTest
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/6/1 17:36
 * @Version 1.0
 **/
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory() throws IOException {
        // 1. 从SqlSessionFactory中获取SqlSession
        Reader reader = Resources.getResourceAsReader("mybatis-config-datasource.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        String res = userDao.queryUserInfoById("10001");
        logger.info("测试结果：{}", res);
    }

}
