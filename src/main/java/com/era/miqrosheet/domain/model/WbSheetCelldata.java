package com.era.miqrosheet.domain.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongjingxiang
 * @since 2025-09-29
 */
@Getter
@Setter
@ToString
@TableName("wb_sheet_celldata")
@ApiModel(value = "WbSheetCelldata对象", description = "")
public class WbSheetCelldata implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long sheetId;

    private String sheetIndex;

    private String gridKey;

    /**
     * 行
     */
    @ApiModelProperty("行")
    private Integer r;

    /**
     * 列
     */
    @ApiModelProperty("列")
    private Integer c;

    /**
     * 值
     */
    @ApiModelProperty("值")
    private String v;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
