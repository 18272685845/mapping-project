package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


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
     *      权限
     * @param userid
     * @return
     */
    @GetMapping("/selectAllPer")
    ResultData selectAllPer(@RequestParam("userid") Long userid);

    /**
     *  查询所有菜单
     * @return
     */
    @GetMapping("/selectAllMenu")
    ResultData selectAllMenu();

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
    public ResultData insertMenu(@RequestBody Menu menu);

    /**
     *      删除菜单
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenu")
    public ResultData deleteMenu(@RequestBody List<Integer> ids);

    /**
     * 根据登陆用户查询其单位信息
     * @param
     * @return
     */
    @GetMapping("/selectMappingUnitById")
    public ResultData selectMappingUnitById();

    /**
     *  根据前端传递id获取单位信息
     * @param userId
     * @return
     */
    @GetMapping("/getMappingUnitByUserId")
    public ResultData getMappingUnitByUserId(@RequestParam("userId") Long userId);

    /**
     * 修改单位信息
     * @return
     */
    @PostMapping("/updateMappingUnit")
    public ResultData updateMappingUnit(@RequestBody MappingUnit mappingUnit);

    /**
     * 查询一条单位信息
     * @param mappingUnit
     * @return
     */
    @PostMapping("/selectOneMappingUnit")
    public ResultData selectOneMappingUnit(@RequestBody MappingUnit mappingUnit);

    /**
     * 根据用户id查询单位负责人
     * @param userId
     * @return
     */
    @GetMapping("/selectPrincipalById")
    public ResultData selectPrincipalById(@RequestParam("userId") Integer userId);


    /**
     * 根据id编号查询单位负责人附件信息
     * @param id
     * @return
     */
    @GetMapping("/selectPrincipalByResource")
    public ResultData selectPrincipalByResource(@RequestParam("id") Long id);
    /**
     * 修改单位负责人信息
     * @return
     */
    @PostMapping("/updatePrincipal")
    public ResultData updatePrincipal(@RequestBody Principal principal);

    /**
     * 增加单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/addPrincipal")
    public ResultData addPrincipal(@RequestBody Principal principal);
    /**
     * 删除单位负责人
     * @param principal
     * @return
     */
    @PostMapping("/deletePrincipal")
    public ResultData deletePrincipal(@RequestBody Principal principal);

    /**
     * 根据用户Id查询技术人员信息
     * @param userId
     * @return
     */
    @GetMapping ("/selectTechnicistById")
    public ResultData selectTechnicistById(@RequestParam("userId") Integer userId);

    /**
     * 新增技术人员
     * @param technicist
     * @return
     */
    @PostMapping("/addTechnicist")
    public ResultData addTechnicist(@RequestBody Technicist technicist);

    /**
     * 修改技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/updateTechnicist")
    public ResultData updateTechnicist(@RequestBody Technicist technicist);
    /**
     * 删除技术人员信息
     * @param technicist
     * @return
     */
    @PostMapping("/deleteTechnicist")
    public ResultData deleteTechnicist(@RequestBody Technicist technicist);

    /**
     * 根据用户id查询设备仪器信息
     * @param userId
     * @return
     */
    @GetMapping("/selectEquipmentById")
    public ResultData selectEquipmentById(@RequestParam("userId") Integer userId);
    /**
     * 增加设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/addEquipment")
    public ResultData addEquipment(@RequestBody Equipment equipment);

    /**
     * 修改设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/updateEquipment")
    public ResultData updateEquipment(@RequestBody Equipment equipment);
    /**
     * 删除设备仪器信息
     * @param equipment
     * @return
     */
    @PostMapping("/deleteEquipment")
    public ResultData deleteEquipment(@RequestBody Equipment equipment);

    /**
     * 根据用户id查询特殊岗位信息
     * @param userId
     * @return
     */
    @GetMapping("/selectSpecialPostById")
    public ResultData selectSpecialPostById(@RequestParam("userId") Integer userId);
    /**
     * 新增特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/addSpecialPost")
    public ResultData addSpecialPost(@RequestBody SpecialPost specialPost);
    /**
     * 修改特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/updateSpecialPost")
    public ResultData updateSpecialPost(@RequestBody SpecialPost specialPost);
    /**
     * 删除特殊岗位信息
     * @param specialPost
     * @return
     */
    @PostMapping("/deleteSpecialPost")
    public ResultData deleteSpecialPost(@RequestBody SpecialPost specialPost);
    /**
     * 根据单位编号id查询附件表
     * @param id
     * @return
     */
    @GetMapping("/selectResourceById")
    public ResultData selectResourceById(@RequestParam("id") Long id);

    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    @PostMapping("/selectMappingProjectByPage")
    public ResultData selectMappingProjectByPage(@RequestBody MappingProjectVo mappingProjectVo);

    /**
     * 新增项目信息
     * @return
     */
    @PostMapping("/insertMappingProject")
    public ResultData insertMappingProject(@RequestBody InsertProjectVo insertProjectVo);
    /**
     * 修改项目信息
     * @return
     */
    @PostMapping("/updateMappingProject")
    public ResultData updateMappingProject(@RequestBody MappingProject mappingProject);

    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    @GetMapping("/updateProjectResultsStatusById")
    public ResultData updateProjectResultsStatusById(@RequestParam("id") Long id);
}
