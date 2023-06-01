package codingq.top.mybatis.mapping;

/**
 * @ClassName SqlCommandType
 * @Description TODO:
 * @Author quanjiaxing
 * @Date 2023/6/1 10:56
 * @Version 1.0
 **/
public enum SqlCommandType {
    /**
     * 未知
     */
    UNKNOWN,
    /**
     * 插入
     */
    INSERT,
    /**
     * 更新
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 查找
     */
    SELECT;
}
