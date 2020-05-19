package com.msr.serviceaccount.query;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerIdQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;
}
