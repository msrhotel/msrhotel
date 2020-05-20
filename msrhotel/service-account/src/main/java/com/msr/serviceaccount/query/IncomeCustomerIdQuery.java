package com.msr.serviceaccount.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class IncomeCustomerIdQuery {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "对应用户id")
    private String customerId;
}
