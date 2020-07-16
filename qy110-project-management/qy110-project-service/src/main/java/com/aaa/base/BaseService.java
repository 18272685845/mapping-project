package com.aaa.base;

import com.aaa.utils.Map2BeanUtils;
import com.aaa.utils.SpringContextUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.Sqls;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.aaa.staticproperties.OrderStatic.*;

/**
 * @Author 郭航宇
 * @Date 14:59 2020/7/9
 * Description:
 *  通用service
 *  这个service封装很多的通用方法
 **/

public abstract class BaseService<T> {

    //全局变量，缓存子类的泛型类型
    private Class<T> cache = null;

    @Autowired
    private Mapper<T> mapper;

    protected  Mapper getMapper(){
        return  mapper;
    }

    /**
     * 查询方法
     * @return
     */
    public List<T> selectAll() {
       return mapper.selectAll();
    }

    /**
     * 新增功能
     * insert和insertSelective区别
     * insert：此方法使用所有的属性作为字段使用，无论该字段是不是null
     * insertSelective：使用不为null的属性作为字段使用
     * @param t
     * @return
     * @throws Exception
     */
    public Integer add(T t){
        return mapper.insertSelective(t);
    }

    /**
     * 修改方法
     * @param t
     * @return
     * @throws Exception
     */
    public Integer update(T t){
        return mapper.updateByPrimaryKey(t);
    }

    /**
     * 根据主键删除
     * @return
     * @throws Exception
     */
    public Integer delete(T t){
        return mapper.deleteByPrimaryKey(t);
    }

    /**
     * 根据主键批量删除
     * @return
     */
    public Integer deleteByIds(List<Integer> ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", ids)).build();
        return mapper.deleteByExample(example);
    }

    /**
     * 批量更新
     * @return
     */
    public Integer batchUpdate(T t,Integer[] ids){
        Example example = Example.builder(getTypeArguement()).where(Sqls.custom().andIn("id", Arrays.asList(ids))).build();
        return mapper.updateByExample(t,example);
    }

    /**
     * 查询一条数据
     * @return
     */
    public T selectOne(T t){
        return  mapper.selectOne(t);
    }

    /**
     * 查询一条数据
     *  可以排序
     * @param where
     * @param orderByFiled
     * @param fileds ：不只是代表唯一键
     * @return
     */
    public T selectOneByFiled(Sqls where, String orderByFiled, String... fileds){
        return selectByFileds(null,null,where,orderByFiled,null,fileds).get(0);
    }

    /**
     * 通过条件查询一个列表
     * @param where
     * @param orderByField
     * @param fields
     * @return
     */
    public List<T> selectListByFiled(Sqls where,String orderByField, String... fields){
        return selectByFileds(null,null,where,orderByField,null,fields);
    }

    /**
     * 实现条件查询的分页
     * @param pageNo
     * @param pageSize
     * @param where
     * @param orderFiled
     * @param fileds
     * @return
     */
    public PageInfo<T> selectListByPageAndFiled(Integer pageNo, Integer pageSize, Sqls where, String orderFiled, String... fileds){
        return new PageInfo<T>(selectByFileds(pageNo,pageSize,where,orderFiled,null,fileds));
    }

    /**
     * 查询集合 条件查询
     * @param t
     * @return
     */
    public List<T> selectList(T t){
        return mapper.select(t);
    }


    /**
     * 查询集合，分页查询
     * @param t
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<T> selectListByPage(T t,Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<T> select = mapper.select(t);
        PageInfo<T> pageInfo=new PageInfo<T>(select);
        return pageInfo;
    }

    /**
     * Map类型转换实体类
     * @param map
     * @return
     */
    public T newInstance(Map map){
        return (T) Map2BeanUtils.map2Bean(map,getTypeArguement());
    }

    /**
     * 实现通用查询
     *      不仅可以作用于分页，还可以作用于排序，还能作用于多条件查询
     *
     * @param pageNo ：第几页
     * @param pageSize ：每页条数
     * @param where ：查询条件
     * @param orderByFiled ：是所要排序的字段
     * @param orderWord
     * @param fileds ：参数
     * @return
     */
    private List<T> selectByFileds(Integer pageNo,Integer pageSize,Sqls where,String orderByFiled,String orderWord,String...fileds){
        Example.Builder builder = null;
        if (fileds == null || fileds.length == 0 ){
            //查询所有数据
            builder = Example.builder(getTypeArguement());
        }else {
            //说明有参数，需要进行条件查询
            builder = Example.builder(getTypeArguement()).select(fileds);
        }
        if (orderByFiled != null){
            //说明需要对某个字段进行排序
            if (DESC.equals(orderWord.toUpperCase())){
                //说明需要倒序
                builder = builder.orderByDesc(orderByFiled);
            }else if (ASC.equals(orderWord.toUpperCase())){
                builder = builder.orderByAsc(orderByFiled);
            }else {
                builder = builder.orderByDesc(orderByFiled);
            }
        }
        Example example = builder.build();
        //实现分页
        if (pageNo !=null && pageSize!=null){
            PageHelper.startPage(pageNo,pageSize);
        }
        return getMapper().selectByExample(example);
    }

    /**
     * 获取子类泛型类型
     * @return
     */
    public Class<T> getTypeArguement(){
        if (cache == null){
            cache = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        }
        return cache;
    }

    /**
     * 获取spring容器/获取spring的上下文
     *  在项目开始运行的时候，会去加载spring配置，
     *  如果你们项目需要在项目启动的时候也加载自己的配置文件
     *  在spring的源码中有一个必须要看的方法(init())
     *  init()--->就是在项目启动的时候去加载spring的配置
     *  如果你的项目中也需要把某一些配置一开始就托管给spring
     *  需要获取到spring的上下文(ApplicationContext)
     */
    public ApplicationContext getApplicationContext(){
        return SpringContextUtils.getApplicationContext();
    }


}
