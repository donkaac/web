package com.sl.web.model;

import java.util.Collection;

/**
 * Created by Achi on 4/14/2020.
 */
public class Document {
    private Integer id;
    private String content;
    private Integer menuId;
    private Menu menuByMenuId;
    private Collection<DocumentImages> documentImagesById;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Document document = (Document) o;

        if (id != null ? !id.equals(document.id) : document.id != null) return false;
        if (content != null ? !content.equals(document.content) : document.content != null) return false;
        if (menuId != null ? !menuId.equals(document.menuId) : document.menuId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (menuId != null ? menuId.hashCode() : 0);
        return result;
    }

    public Menu getMenuByMenuId() {
        return menuByMenuId;
    }

    public void setMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }

    public Collection<DocumentImages> getDocumentImagesById() {
        return documentImagesById;
    }

    public void setDocumentImagesById(Collection<DocumentImages> documentImagesById) {
        this.documentImagesById = documentImagesById;
    }
}
