package com.era.miqrosheet.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.era.miqrosheet.domain.model.Wb;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dongjingxiang
 * @since 2025-09-29
 */
public interface WbMapper extends BaseMapper<Wb> {

    Wb selectByGridKey(@Param("gridKey") String gridKey);
}
