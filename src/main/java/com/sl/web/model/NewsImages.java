package com.sl.web.model;

/**
 * Created by Achi on 4/14/2020.
 */
public class NewsImages {
    private Integer id;
    private String path;
    private Integer newsId;
    private News newsByNewsId;

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

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsImages that = (NewsImages) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (newsId != null ? !newsId.equals(that.newsId) : that.newsId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (newsId != null ? newsId.hashCode() : 0);
        return result;
    }

    public News getNewsByNewsId() {
        return newsByNewsId;
    }

    public void setNewsByNewsId(News newsByNewsId) {
        this.newsByNewsId = newsByNewsId;
    }
}
