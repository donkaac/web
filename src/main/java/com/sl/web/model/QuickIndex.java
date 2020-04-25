package com.sl.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Created by Achi on 4/19/2020.
 */
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class QuickIndex {
    private Integer id;
    private String title;
    private String content;

    @JsonIgnore
    private Collection<QuickIndexImages> quickIndexImagesById;


    public QuickIndex() {
    }

    public QuickIndex(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuickIndex that = (QuickIndex) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    public Collection<QuickIndexImages> getQuickIndexImagesById() {
        return quickIndexImagesById;
    }

    public void setQuickIndexImagesById(Collection<QuickIndexImages> quickIndexImagesById) {
        this.quickIndexImagesById = quickIndexImagesById;
    }
}
