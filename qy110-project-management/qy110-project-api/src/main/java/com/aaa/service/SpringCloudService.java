package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Component
@FeignClient("springcloud-provider")
public interface SpringCloudService {

    /**
     * 登陆操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    public ResultData doLogin(@RequestBody User user);


    /**
     * 保存日志
     * @return
     */
    @PostMapping("/addLoginLog")
    public Integer addLoginLog(@RequestBody LoginLog loginLog);

    /**
     * 查询所有部门
     * @return
     */
    @GetMapping("/selectAllDept")
    public ResultData selectAllDept();
    /**
     * 添加部门
     * @return
     */
    @PostMapping("/insertDept")
    public ResultData insertDept(@RequestBody Dept dept);
    /**
     * 修改部门
     * @param dept
     * @return
     */
    @PostMapping("/updateDept")
    public ResultData updateDept(@RequestBody Dept dept);
    /**
     * 根据主键删除部门
     * @param dept
     * @return
     */
    @DeleteMapping("/deleteDept")
    public ResultData deleteDept(@RequestBody Dept dept);

    /**
     * redis测试
     * @return
     */
    @GetMapping("/deptList")
    public ResultData deptList();

    /**
     * 批量删除dept
     * @param ids
     * @return
     */
    @DeleteMapping ("/deleteBatchDept")
    public ResultData deleteBatchDept(@RequestBody List<Dept> ids);

    /**
     * 搜索+查询
     * @param deptVo
     * @return
     */
    @PostMapping("/selectAndSearch")
    public ResultData selectAndSearch(@RequestBody DeptVo deptVo);

    /**
     * 分页查询字典列表
     * @param dictVo
     * @return
     */
    @PostMapping("/selectPageDict")
    public ResultData selectPageDict(@RequestBody DictVo dictVo);
    /**
     * 根据id查询字典
     * @param dict
     * @return
     */
    @PostMapping("/selectById")
    public ResultData selectById(@RequestBody Dict dict);

    /**
     * 根据id修改字典信息
     * @param dict
     * @return
     */
    @PostMapping("/updateById")
    public ResultData updateById(@RequestBody Dict dict);

    /**
     * 添加字典信息
     * @param dict
     * @return
     */
    @PostMapping("/addDict")
    public ResultData addDict(@RequestBody Dict dict);
    /**
     * 批量删除字典信息
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchByIds")
    public ResultData deleteBatchByIds(@RequestBody List<Integer> ids);

    /**
     * 分页查询所有用户信息
     * @return
     */
    @PostMapping("/selectPageAllUser")
    public ResultData selectPageAllUser(@RequestBody PageVo pageVo);

    /**
     * 查看全部角色
     * @return
     */
    @GetMapping("/selectList")
    ResultData selectList();

    /**
     * 模糊查询
     * @param roleSelecter
     * @return
     */
    @GetMapping("/selectOne")
    ResultData selectOne(@RequestBody RoleSelecter roleSelecter);

    /**
     * 查看详细信息
     * @param role
     * @return
     */
    @GetMapping("/selectOneBath")
    ResultData selectOneRole(@RequestBody Role role);

    /**
     * 新增角色
     * @param role
     * @return
     */
    @PutMapping("/insert")
    ResultData insertRole(@RequestBody Role role);


    /**
     * 删除角色,并将角色的权限删除
     * @param ids
     * @return
     */

    @PostMapping ("/deleteRole")
    ResultData deleteRole(List<Integer> ids);

    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/selectAllRole")
    public ResultData selectAllRole();
    /**
     * 根据用户id查询所对应的角色
     */
    @GetMapping("/selectByIdUserRole")
    public ResultData selectByIdUserRole(@RequestParam("id") Integer id);

    /**
     * 根据id批量删除用户
     * @param ids
     * @return
     */
    @PostMapping("/deleteBatchUser")
    public ResultData deleteBatchUser (@RequestBody List<Integer> ids);

    /**
     * 根据用户id修改用户信息
     * @return
     */
    @PostMapping("/updateUser")
    public ResultData updateUser(@RequestBody UpdateOrAddUserVo updateUserVo);
    /**
     * 新增用户
     * @param addUserVo
     * @return
     */
    @PostMapping("/addUser")
    public ResultData addUser(@RequestBody UpdateOrAddUserVo addUserVo);

    /**
     * 获取用户的字典表状态
     * @return
     */
    @GetMapping("/getUserStatus")
    public ResultData getUserStatus();

    /**
     * 获取用户字典表性别值
     * @return
     */
    @GetMapping("/getUserSsex")
    public ResultData getUserSsex();


    /**
     *      查询用户权限
     * @param userid
     * @return
     */
    @GetMapping("/selectAllPer")
    ResultData selectAllPer(@RequestParam("userid") Long userid);

    /**
     *      获取所有菜单
     * @param menu
     * @return
     */
    @PostMapping("/selectAllMenu")
    ResultData selectMenuById(@RequestBody Menu menu);

    /**
     *      修改菜单
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
     ResultData updateMenu(@RequestBody Menu menu);

    /**
     *      添加菜单
     * @param menu
     * @return
     */
    @PostMapping("/insertMenu")
    ResultData insertMenu(@RequestBody Menu menu);

    /**
     *      删除菜单
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestBody List<Integer> ids);

    /**
     * 项目统计信息
     *      项目审核模块中项目信息，汇交成果信息、项目审核、成果汇交审核也是这个
     * @return
     */
    @GetMapping("/selectAllUnit")
    public ResultData selectAllUnit();

    /**
     * 所有单位统计信息
     * @return
     */
    @GetMapping("/selectAllProject")
    public ResultData selectAllProject();

    /**
     * 项目类型统计
     */
    @GetMapping("/selectQualification")
    public ResultData selectQualification();

    /**
     * 查询单位资质等级
     */
    @GetMapping("/selectQualificationLevel")
    public ResultData selectQualificationLevel();

    /**
     * 单位所属技术员和项目数量
     * @return
     */
    @GetMapping("/selectTechnicist")
    public ResultData selectTechnicist(@RequestParam("userId") Integer userId);

    /**
     * 所有单位人员设备汇总统计
     * @return
     */
    @GetMapping("/selectEquipmentByUnit")
    public ResultData selectEquipmentByUnit();

    /**
     * 修改角色权限
     * @param roleMenuVo
     * @return
     */
    @PostMapping("/updatePer")
    ResultData updatePer(@RequestBody RoleMenuVo roleMenuVo);

    /**
     * 根据项目姓名进行查询
     *      项目审核模块中项目信息，汇交成果信息、项目审核、成果汇交审核也是这个
     * @param name
     * @return
     */
    @GetMapping("/selectProjectByName")
    public ResultData selectProjectByName(@RequestParam("name") String name);

    /**
     * 根据用户编号查找本单位的附件
     * @param number
     * @return
     */
    @GetMapping("/selectResourceByNum")
    public ResultData selectResourceByNum(@RequestParam("number") String number);

    /**
     * 根据用户编号查找汇交结果
     * @param num
     * @return
     */
    @GetMapping("/selectResultCommitByNum")
    public ResultData selectResultCommitByNum(@RequestParam("num") String num);

    /**
     * 根据用户编号查找审核记录
     * @param num
     * @return
     */
    @GetMapping("/selectAuditByNum")
    public ResultData selectAuditByNum(@RequestParam("num") String num);

    /**
     * 单位审核中：单位列表
     * 根据单位名称进行查询
     * @param name
     * @return
     */
    @GetMapping("/selectOneUnitByName")
    public ResultData selectOneUnitByName(@RequestParam("name") String name);

    /**
     * 单位修改待审核、单位注册待审核
     * @param status 2:单位修改待审核  3:单位修改待审核
     * @param name  根据姓名进行模糊查询
     * @return
     */
    @GetMapping("/selectUnitByAuditStatus")
    public ResultData selectUnitByAuditStatus(@RequestParam("name") String name,@RequestParam("status") String status);

    /**
     * 根据单位的编号查找评分记录
     * @param num
     * @return
     */
    @GetMapping("/selectListScore")
    public ResultData selectListScore(@RequestParam("num") String num);

    /**
     * 插入评分记录
     * @param id 评分记录编号
     * @param scoreNum 要加减的分数值
     * @param score 当前分数值
     * @param unitId 关联单位的id
     * @param reason 备注
     * @param createTime 创建时间
     * @param status 根据这个状态判断加分减分  0:加分  1:减分
     * @return
     */
    @PostMapping("/insertScore")
    public ResultData insertScore(@RequestBody ScoreVo scoreVo);
}
