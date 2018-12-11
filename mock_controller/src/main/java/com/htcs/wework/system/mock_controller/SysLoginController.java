package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.system.model.dto.RouteDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhaokaiyuan
 * @create 2018-03-01 15:25
 **/
@RestController
@RequestMapping("/mock/admin")
@Api(tags = "登录注销", description = "登录注销获取用户信息")
public class SysLoginController extends BaseController {

    @ApiOperation(value = "登录")
    @PostMapping(value = "/login", produces = "application/json")
    public ReturnStatus<String> login(@ApiParam(value = "用户登录名", required = true) @RequestParam String username,
                                      @ApiParam(value = "用户密码", required = true) @RequestParam String password) throws Exception {
        return new ReturnStatus<>();
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public ReturnStatus logout() {
        return ReturnStatus.success();

    }


    @ApiOperation("生成路由")
    @GetMapping("/generateRoutes")
    public ReturnStatus<List<RouteDto>> generateRoutes() {

        return ReturnStatus.success();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo")
    public ReturnStatus<Map> getLoginMsg() {

        return ReturnStatus.success();
    }

}
