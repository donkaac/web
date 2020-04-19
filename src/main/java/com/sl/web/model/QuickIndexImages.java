package com.sl.web.model;

/**
 * Created by Achi on 4/19/2020.
 */
public class QuickIndexImages {
    private Integer id;
    private String path;
    private Integer quickIndexId;
    private QuickIndex quickIndexByQuickIndexId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getQuickIndexId() {
        return quickIndexId;
    }

    public void setQuickIndexId(Integer quickIndexId) {
        this.quickIndexId = quickIndexId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuickIndexImages that = (QuickIndexImages) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (quickIndexId != null ? !quickIndexId.equals(that.quickIndexId) : that.quickIndexId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (quickIndexId != null ? quickIndexId.hashCode() : 0);
        return result;
    }

    public QuickIndex getQuickIndexByQuickIndexId() {
        return quickIndexByQuickIndexId;
    }

    public void setQuickIndexByQuickIndexId(QuickIndex quickIndexByQuickIndexId) {
        this.quickIndexByQuickIndexId = quickIndexByQuickIndexId;
    }
}
