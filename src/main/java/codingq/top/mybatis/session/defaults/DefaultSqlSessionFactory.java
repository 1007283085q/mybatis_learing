package codingq.top.mybatis.session.defaults;


import codingq.top.mybatis.binding.MapperRegistry;
import codingq.top.mybatis.session.SqlSession;
import codingq.top.mybatis.session.SqlSessionFactory;

/**
 * @author 小傅哥，微信：fustack
 * @description 默认的 DefaultSqlSessionFactory
 * @date 2022/04/01
 * @github https://github.com/fuzhengwei
 * @copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}
