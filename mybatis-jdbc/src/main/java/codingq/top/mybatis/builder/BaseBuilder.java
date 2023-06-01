package codingq.top.mybatis.builder;

import codingq.top.mybatis.session.Configuration;

/**
 * @ClassName BaseBuilder
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/6/1 10:51
 * @Version 1.0
 **/
public abstract class BaseBuilder {
    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
