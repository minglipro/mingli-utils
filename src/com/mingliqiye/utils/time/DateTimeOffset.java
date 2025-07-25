package com.mingliqiye.utils.time;

import java.time.temporal.ChronoUnit;
import lombok.Getter;

/**
 * 时间位移 类
 *
 * @author MingLiPro
 */
@Getter
public class DateTimeOffset {

    private final ChronoUnit offsetType;
    private final Long offset;

    private DateTimeOffset(ChronoUnit offsetType, Long offset) {
        this.offsetType = offsetType;
        this.offset = offset;
    }

    /**
     * 创建一个新的DateTimeOffset实例
     *
     * @param offsetType 偏移量的单位类型，指定偏移量的计算单位
     * @param offset     偏移量的数值，可以为正数、负数或零
     * @return 返回一个新的DateTimeOffset对象，包含指定的偏移量信息
     */
    public static DateTimeOffset of(ChronoUnit offsetType, Long offset) {
        return new DateTimeOffset(offsetType, offset);
    }

    /**
     * 创建一个 DateTimeOffset 实例
     *
     * @param offset     偏移量数值
     * @param offsetType 偏移量的时间单位类型
     * @return 返回一个新的 DateTimeOffset 实例
     */
    public static DateTimeOffset of(Long offset, ChronoUnit offsetType) {
        return new DateTimeOffset(offsetType, offset);
    }
}
