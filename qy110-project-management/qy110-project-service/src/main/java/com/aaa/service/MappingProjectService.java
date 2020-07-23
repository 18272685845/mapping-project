package com.aaa.service;

import com.aaa.base.BaseService;
import com.aaa.mapper.MappingProjectMapper;
import com.aaa.model.MappingProject;
import com.aaa.model.Resource;
import com.aaa.model.ResultCommit;
import com.aaa.properties.FtpProperties;
import com.aaa.utils.*;
import com.aaa.vo.InsertProjectVo;
import com.aaa.vo.MappingProjectVo;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.aaa.staticproperties.FtpIpProperties.*;
import static com.aaa.staticproperties.FtpIpProperties.FTP_IP;
import static com.aaa.staticproperties.TimeForatProperties.DATE_FORMAT;
import static com.aaa.staticproperties.TimeForatProperties.TIME_FORMAT;

/**
 * @Author 郭航宇 LQY
 * @Date 14:53 2020/7/18
 * Description:
 **/

@Service
public class MappingProjectService extends BaseService<MappingProject> {

    @Autowired
    private MappingProjectMapper mappingProjectMapper;

    @Autowired
    private FtpProperties ftpProperties;

    /**
     * 首页模糊查询
     * @param projectName
     * @param projectType
     * @param startDate
     * @return
     */
    public List<Map<String,Object>> selectMappingProjectByProjectNameAndProjectTypeAndStartDate( String projectName,  String projectType, String startDate){
        List<Map<String, Object>> mapList = mappingProjectMapper.selectMappingProjectByProjectNameAndProjectTypeAndStartDate(projectName, projectType, startDate);
        if (mapList != null ){
            return mapList;
        }
        return null;

    }
    /**
     * 模糊查询的下拉框数据  测绘类型
     * @return
     */
    public List<Map<String,Object>> selectProjectType(){
        List<Map<String, Object>> mapList = mappingProjectMapper.selectProjectType();
        if (mapList != null){
            return mapList;
        }
        return null;
    }
    /**
     * 通过名字查询项目
     * @param projectName
     * @return
     */
   public MappingProject selectMappingProjectByProjectName(String projectName){
       MappingProject project = mappingProjectMapper.selectMappingProjectByProjectName(projectName);
       if (project != null){
            return project;
        }
        return null;
    }

    /**
     * 带条件查询的 分页查询项目信息
     * @param mappingProjectVo
     * @return
     */
    public PageInfo selectMappingProjectByPage(MappingProjectVo mappingProjectVo){
        if (mappingProjectVo.getPageNum() == 0 ){
            mappingProjectVo.setPageNum(1);
        }
        if (mappingProjectVo.getPageSize() == 0 ){
            mappingProjectVo.setPageSize(5);
        }
        PageInfo<MappingProject> pageInfo = super.selectListByPage(mappingProjectVo.getMappingProject(), mappingProjectVo.getPageNum(), mappingProjectVo.getPageSize());
        return pageInfo;
    }

    /**
     * 新增项目信息
     * @return
     */
    public Long insertMappingProject(MappingProject mappingProject) {
        if (mappingProject != null) {
            mappingProject.setCreateTime(DateUtils.getCurrentDate());
            Long longID = IdUtils.getLongID();
            mappingProject.setId(longID);
            Integer add = super.add(mappingProject);
            if (add > 0) {
                    return longID;

            }
        }
        return null;
    }



    /**
     * ftp文件上传
     * @param multipartFile
     * @param refBizType
     * @param resourceService
     * @param tyid
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public Boolean
    beforeToDo(MultipartFile[] multipartFile, String refBizType, ResourceService resourceService, Long tyid) throws Exception {
        Integer add=0;
        boolean uploadFileOfResult =false;
        for (MultipartFile file : multipartFile) {
            String filePath = DateUtils.formatDate(new Date(),DATE_FORMAT);
            String suffix = "." + file.getOriginalFilename().split("\\.")[1];
            String newFileName = FileNameUtils.getFileName() + suffix;
            String createTimeAndModifyTime=DateUtils.formatDate(new Date(),TIME_FORMAT);
            uploadFileOfResult = FtpUtils.upload(FTP_HOST, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newFileName, file.getInputStream());
            //将数据放到t_resource中
            Resource resource = new Resource();
            resource.setId(new IdWorker().nextId())
                    .setName(file.getOriginalFilename())
                    .setSize(file.getSize())
                    .setPath(FTP_IP + "/" + filePath + "/" + newFileName)
                    .setExtName(suffix)
                    .setRefBizType(refBizType)
                    .setRefBizId(tyid)
                    .setCreateTime(createTimeAndModifyTime)
                    .setModifyTime(createTimeAndModifyTime);
            add = resourceService.add(resource);

        }
        if (add >0 && uploadFileOfResult) {
            return true;
        }
        return false;
    }
    /**
     * 统计所有项目信息
     *      项目审核模块中，汇交成果信息、项目审核、成果汇交审核也是这个
     * @return
     */
    public List<MappingProject> selectAllProject(){
        List<MappingProject> mappingProjects = mappingProjectMapper.selectAll();
        if(null != mappingProjects && 0 < mappingProjects.size()){
            return mappingProjects;
        }
        return null;
    }

    /**

     * 修改项目信息
     * @return
     */
    public Integer updateMappingProject(MappingProject mappingProject){
        if (mappingProject != null){
            mappingProject.setModifyTime(DateUtils.getCurrentDate());
            Integer update = super.update(mappingProject);
            if (update > 0){
                return update;
            }
        }
        return null;
    }
    /**
     * 根据项目id修改项目提交状态
     * @param id
     * @return
     */
    public Integer updateProjectResultsStatusById(Long id){
        Integer integer = mappingProjectMapper.updateProjectResultsStatusById(id);
        if (integer > 0){
            return integer;
        }
        return integer;
    }

    /**
     * 查询项目类型
     * @return
     */
    public List<HashMap> selectQualification(){
        List<HashMap> hashMaps = mappingProjectMapper.selectQualification();
        if(null != hashMaps && 0 < hashMaps.size()){
            return hashMaps;
        }
        return null;
    }

    /**
     * 根据项目姓名进行模糊查询
     *              项目审核模块中，汇交成果信息的搜索、项目审核、成果汇交审核也是这个
     * @param name
     * @return
     */
    public MappingProject selectProjectByName(String name){
        MappingProject mappingProject = mappingProjectMapper.selectProjectByName(name);
        if(null != mappingProject && !mappingProject.equals("")){
            return mappingProject;
        }
        return null;
    }
}
