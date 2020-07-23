package com.aaa.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
/**
  * @author 王登辉
  * @date 2020/7/20
  *     分页查询
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageInfoRandom<T> implements Serializable {

    private Integer pageNum;
    private Integer pageSize;
    private Integer pages;
    private Integer count;
    private List<T> list;

    public PageInfoRandom(List<T> list,Integer pageNum,Integer pageSize){
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.count=list.size();
        this.pages =  count % pageSize==0 ? count /pageSize : (count/pageSize)+1;
        int sizes=(pageNum-1)*pageSize+pageSize>count ? count :(pageNum-1)*pageSize+pageSize;
       this.list=list.subList((pageNum-1)*pageSize,sizes);
    }

}
