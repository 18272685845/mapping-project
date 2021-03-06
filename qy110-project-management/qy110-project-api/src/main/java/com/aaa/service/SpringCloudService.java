package com.aaa.service;

import com.aaa.base.ResultData;
import com.aaa.model.*;
import com.aaa.vo.*;
import com.aaa.vo.DeptVo;
import com.aaa.vo.DictVo;

import com.aaa.vo.RoleMenuVo;

import com.aaa.vo.RoleSelecter;
import com.aaa.vo.PageVo;
import com.aaa.vo.UpdateOrAddUserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


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
<<<<<<< HEAD
=======
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

//    /**
//     * 新增项目信息，文件上传
//     * @param mappingProject
//     * @param resultCommit
//     * @param multipartFile
//     * @param refBizType
//     * @return
//     */
//    @PostMapping(value = "/insertMappingProject", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResultData insertMappingProject(@RequestBody MappingProject mappingProject,@RequestBody ResultCommit resultCommit,@RequestBody MultipartFile[] multipartFile,@RequestParam("refBizType") String refBizType);
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

    /**
>>>>>>> 0d292191da24dc20edf3fd6620c90bfe27e9458a
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
     * 首页模糊查询
     * @param projectName
     * @param projectType
     * @param startDate
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectNameAndProjectTypeAndStartDate")
    public  ResultData selectMappingProjectByProjectNameAndProjectTypeAndStartDate(@RequestParam("projectName") String projectName,@RequestParam("projectType") String projectType,@RequestParam("startDate") String startDate);
    /**
     * 通过名字查询项目
     * @param projectName
     * @return
     */
    @GetMapping("/selectMappingProjectByProjectName")
    public ResultData selectMappingProjectByProjectName(@RequestParam("projectName") String projectName);
    /**
     * 模糊查询的下拉框数据  测绘类型
     * @return
     */
    @GetMapping("/selectProjectType")
    public ResultData selectProjectType();

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
     *      抽查分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRound")
    ResultData selectByRound(@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);

    /**
     *      抽查表初始化
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/selectByRounds")
    ResultData selectByRounds(@RequestParam("address") String address,@RequestParam("scale") Double scale,@RequestParam("pageNum") Integer pageNum,@RequestParam("pageSize") Integer pageSize);
    /**
     *      白名单
     * @return
     */
    @GetMapping("/selectByWhite")
    ResultData selectByWhite();


    /**
     *      黑名单
     * @return
     */
    @GetMapping("/selectByBlack")
    ResultData selectByBlack();

    /**
     *      信息公开
     * @return
     */
    @GetMapping("/selectAllNews")
    ResultData selectAllNews();
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

//     * @param id 评分记录编号
//     * @param scoreNum 要加减的分数值
//     * @param score 当前分数值
//     * @param unitId 关联单位的id
//     * @param reason 备注
//     * @param createTime 创建时间
//     * @param status 根据这个状态判断加分减分  0:加分  1:减分
    /**
     * 插入评分记录
     * @return
     */
    @PostMapping("/insertScore")
    public ResultData insertScore(@RequestBody ScoreVo scoreVo);

}
