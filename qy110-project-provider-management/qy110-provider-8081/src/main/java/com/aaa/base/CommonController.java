package com.aaa.base;

import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import tk.mybatis.mapper.util.Sqls;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author 郭航宇
 * @Date 16:51 2020/7/8
 * Description:
 **/

public abstract class CommonController<T> extends BaseController {
    /**
     * 定义获取BaseService的抽象方法
     */
    public abstract BaseService<T> getBaseService();

    /**
     * 钩子函数，在新增之前所执行的内容
     * @param map
     */
    protected void beforeAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之前你需要执行某些业务的时候，则需要编写内容
    }

    /**
     * 钩子函数，在新增之后所执行的内容
     * @param map
     */
    protected void afterAdd(Map map){
        // TODO 钩子函数，也就是说如果在插入之后你需要执行某些业务的时候，则需要编写内容
    }

    /**
     * 查询方法
     * @return
     */
    @Override
    public ResultData selectAll(){
        List<T> selectAll = getBaseService().selectAll();
        if (selectAll!=null){
            return selectSuccess(selectAll);
        }
        return selectFailed();

    }

    /**
     * 新增方法
     * @param map
     * @return
     * @throws Exception
     */
    public ResultData insert(@RequestBody Map map) {
        beforeAdd(map);
        T instance = getBaseService().newInstance(map);
        Integer add = getBaseService().add(instance);
        if (add > 0){
            afterAdd(map);
            return addDataSuccess();
        }
        return addDataFailed();
    }

    /**
     * 修改方法
     * @param map
     * @return
     */
    public ResultData update(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer update = getBaseService().update(instance);
        if (update > 0){
            return updateDataSuccess();
        }
        return updateDataFailed();
    }

    /**
     * 根据主键删除
     * @param map
     * @return
     */
    public ResultData delete(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        Integer delete = getBaseService().delete(instance);
            if (delete > 0){
                return delDataSuccess();
            }
        return delDataFailed();
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public ResultData batchDelete(@RequestParam("ids") List<String> ids){
        Integer deleteByIds = getBaseService().deleteByIds((List) Arrays.asList(ids));
        if (deleteByIds > 0){
            return super.delDataSuccess("批量删除成功");
        }
        return delDataFailed("批量删除失败");
    }

    /**
     * 查询一条数据
     * @param map
     * @return
     */
    public ResultData selectOne(@RequestBody Map map){

        beforeAdd(map);

        T instance = getBaseService().newInstance(map);
        T selectOne = getBaseService().selectOne(instance);
        if (selectOne != null){
            return selectSuccess(selectOne);
        }
        return selectFailed();
    }

    /**
     * 查询集合，条件查询
     * @param map
     * @return
     */
    public ResultData selectList(@RequestBody Map map){
        T instance = getBaseService().newInstance(map);
        List<T> selectList = getBaseService().selectList(instance);
        if (selectList!=null){
            return selectSuccess(selectList);
        }
        return selectFailed();
    }

    /**
     * 不带条件的分页查询
     * @param map
     * @param pageNo
     * @param pageSize
     * @return
     */
    public ResultData selectListByPage(@RequestBody Map map,Integer pageNo,Integer pageSize){
        T instance = getBaseService().newInstance(map);
        PageInfo<T> selectListByPage = getBaseService().selectListByPage(instance, pageNo, pageSize);
        if (selectListByPage.getSize()>0){
            return selectSuccess(selectListByPage);
        }
        return selectFailed();
    }


    /**
     *   防止数据不安全，所以不能直接在controller某个方法中直接接收HttpServletRequest对象
     *   必须要从本地当前线程中获取对象
     * @return
     */
    public HttpServletRequest getServletRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes;
        if (requestAttributes instanceof ServletRequestAttributes) {
            servletRequestAttributes=(ServletRequestAttributes)requestAttributes;
            return servletRequestAttributes.getRequest();
        }
        return null;
    }

    /**
     * 获取当前客户端的session对象(如果不存在，则会重新创建一个)
     * @return
     */
    public HttpSession getSession(){
        return getServletRequest().getSession();
    }

    /**
     * 获取当前客户端的session对象(如果不存在，则直接返回null)
     * @return
     */
    public HttpSession getExistSession(){
        return getServletRequest().getSession(false);
    }




}
