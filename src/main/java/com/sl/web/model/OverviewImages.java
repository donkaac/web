package com.sl.web.model;

/**
 * Created by Achi on 4/14/2020.
 */
public class OverviewImages {
    private Integer id;
    private String path;
    private Integer overviewId;
    private Overview overviewByOverviewId;

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

    public Integer getOverviewId() {
        return overviewId;
    }

    public void setOverviewId(Integer overviewId) {
        this.overviewId = overviewId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OverviewImages that = (OverviewImages) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (overviewId != null ? !overviewId.equals(that.overviewId) : that.overviewId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (overviewId != null ? overviewId.hashCode() : 0);
        return result;
    }

    public Overview getOverviewByOverviewId() {
        return overviewByOverviewId;
    }

    public void setOverviewByOverviewId(Overview overviewByOverviewId) {
        this.overviewByOverviewId = overviewByOverviewId;
    }
}
