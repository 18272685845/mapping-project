package com.aaa.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (TDict)实体类
 *
 * @author makejava
 * @since 2020-06-03 23:52:09
 */
@Table(name = "t_dict")
public class Dict implements Serializable {
    private static final long serialVersionUID = -10019602865497751L;
    /**
    * 字典ID
    */
    @Id
    @Column(name = "DICT_ID")
    private Long dictId;
    /**
    * 键
    */
    @Column(name = "KEYY")
    private Long keyy;
    /**
    * 值
    */
    @Column(name = "VALUEE")
    private String valuee;
    /**
    * 字段名称
    */
    @Column(name = "FIELD_NAME")
    private String fieldName;
    /**
    * 表名
    */
    @Column(name = "TABLE_NAME")
    private String tableName;


    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getKeyy() {
        return keyy;
    }

    public void setKeyy(Long keyy) {
        this.keyy = keyy;
    }

    public String getValuee() {
        return valuee;
    }

    public void setValuee(String valuee) {
        this.valuee = valuee;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

}