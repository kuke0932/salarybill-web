package com.htcs.wework.system.mock_controller;

import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.common.page.PageBean;
import com.htcs.wework.system.model.SysGroup;
import com.htcs.wework.system.model.dto.SysUserSearchDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Dragon
 * @create 2018-01-12 16:20
 **/
@Api(tags = "群组", description = "群组增删改查接口")
@RestController
@RequestMapping("/admin/sysGroup")
public class SysGroupController {

    /**
     * 根据群组名获取群组列表
     *
     * @param groupName
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("根据群组名获取群组列表")
    @GetMapping(value = "/listGroup")
    public ReturnStatus<PageBean<Map<String, Object>>> listGroup(@ApiParam("群组名") String groupName,
                                                                 @ApiParam("页码") int pageNum,
                                                                 @ApiParam("页大小") int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 新增群组
     *
     * @param sysGroup
     * @return
     */
    @ApiOperation("新增群组")
    @PostMapping(value = "/addGroup")
    public ReturnStatus addGroup(@ApiParam("群组实体") SysGroup sysGroup) {
        return ReturnStatus.success();
    }

    /**
     * 根据id获取群组信息
     *
     * @param id
     * @return
     */
    @ApiOperation("根据id获取群组信息")
    @GetMapping(value = "/getGroupById")
    public ReturnStatus<SysGroup> getGroupById(@ApiParam("群组id") Integer id) {
        return ReturnStatus.success();
    }

    /**
     * 根据id修改群组
     *
     * @param sysGroup
     * @return
     */
    @ApiOperation("根据id修改群组")
    @PostMapping("/updateGroup")
    public ReturnStatus updateGroup(@ApiParam("群组实体") SysGroup sysGroup) {
        return ReturnStatus.success();
    }

    /**
     * 根据群组id批量删除群组
     *
     * @param ids
     * @return
     */
    @ApiOperation("根据群组id批量删除群组")
    @PostMapping(value = "/removeGroup")
    public ReturnStatus removeGroup(@ApiParam("群组id，多个群组以,分割") String ids) {
        return ReturnStatus.success();
    }

    /**
     * 根据群组id获取该群组下的用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation("根据群组id获取该群组下的用户列表")
    @GetMapping(value = "/showGroupUsers")
    public ReturnStatus<PageBean<Map<String, Object>>> showGroupUsers(@ApiParam("群组id") Integer groupId,
                                                                      @ApiParam("登录名") String loginName,
                                                                      @ApiParam("用户昵称") String userName,
                                                                      @ApiParam("页码") int pageNum,
                                                                      @ApiParam("页大小") int pageSize) {
        return ReturnStatus.success();
    }

    /**
     * 添加用户到群组
     *
     * @param groupId
     * @param userIds
     * @return
     */
    @ApiOperation("添加用户到群组")
    @PostMapping(value = "/addUserToGroup")
    public ReturnStatus addUserToGroup(@ApiParam("群组id") Integer groupId,
                                       @ApiParam("用户id, 多个用户以,分割") String userIds) {
        return ReturnStatus.success();
    }

    /**
     * 从群组里删除用户
     *
     * @param groupId
     * @param userIds
     * @return
     */
    @ApiOperation("从群组里删除用户")
    @PostMapping(value = "/removeUserFromGroup")
    public ReturnStatus removeUserFromGroup(@ApiParam("群组id") Integer groupId,
                                            @ApiParam("用户id, 多个用户以,分割")  String userIds) {
        return ReturnStatus.success();
    }
}
