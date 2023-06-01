# mybatis_learing
##学习mybatis的源码和架构思想  
1.进行第二节的学习，完成使用代理类的方式，对使用的mapper进行包装增强，使得后续为执行语句打下基础  
2.完成mybatis中第二节的应用，使用mapperRegistry来对所有的dao接口进行代理工厂的缓存，并且把缓存的结果输入到sqlSession中  
sqlSession是一个主要用来定义标准实现功能的接口，通常我们还会定义一个工厂用来提供这个接口的具体实现

