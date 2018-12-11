package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author zhaokaiyuan
 * @create 2018-03-06 9:46
 **/
@ApiResponses(
        @ApiResponse(code = 500, message = "error", response = ReturnStatus.class)
)
public class BaseController {
}
