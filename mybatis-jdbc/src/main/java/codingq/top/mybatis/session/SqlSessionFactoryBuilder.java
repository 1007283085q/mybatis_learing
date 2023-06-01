package codingq.top.mybatis.session;

import codingq.top.mybatis.builder.xml.XMlConfigBuilder;
import codingq.top.mybatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

/**
 * @ClassName SqlSessionFactoryBuilder
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/6/1 11:15
 * @Version 1.0
 **/
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(Reader reader){
        XMlConfigBuilder xmlConfigBuilder = new XMlConfigBuilder(reader);
        return build(xmlConfigBuilder.parse());
    }
    public SqlSessionFactory build(Configuration config) {
        return new DefaultSqlSessionFactory(config);
    }

}
