package com.lb.cloud.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "myindex", type = "myindex")
public class ESInfo implements Serializable{

    public ESInfo() {
    }

    public int getId() {
        return id;
    }

    public ESInfo(int id, String name, String subtitle, String keywords) {
        this.id = id;
        this.name = name;
        this.subtitle = subtitle;
        this.keywords = keywords;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    // 必须指定一个id，
    @Id
    private int id;

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    // 这里配置了分词器，字段类型，可以不配置，默认也可
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String name;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String subtitle;
    @Field(analyzer = "ik_smart", type = FieldType.Text)
    private String keywords;

    @Override
    public String toString() {
        return "ESInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subtitle + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }
}
