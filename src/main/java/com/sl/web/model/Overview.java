package com.sl.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Created by Achi on 4/19/2020.
 */
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Overview {
    private Integer id;
    private String title;
    private String subtitle;
    private String mainImage;
    private String link;
    private String content;
    private String subOverview;
    private Byte parent;
    private Collection<OverviewImages> overviewImagesById;

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubOverview() {
        return subOverview;
    }

    public void setSubOverview(String subOverview) {
        this.subOverview = subOverview;
    }

    public Byte getParent() {
        return parent;
    }

    public void setParent(Byte parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Overview overview = (Overview) o;

        if (id != null ? !id.equals(overview.id) : overview.id != null) return false;
        if (title != null ? !title.equals(overview.title) : overview.title != null) return false;
        if (subtitle != null ? !subtitle.equals(overview.subtitle) : overview.subtitle != null) return false;
        if (mainImage != null ? !mainImage.equals(overview.mainImage) : overview.mainImage != null) return false;
        if (link != null ? !link.equals(overview.link) : overview.link != null) return false;
        if (content != null ? !content.equals(overview.content) : overview.content != null) return false;
        if (subOverview != null ? !subOverview.equals(overview.subOverview) : overview.subOverview != null)
            return false;
        if (parent != null ? !parent.equals(overview.parent) : overview.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (mainImage != null ? mainImage.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (subOverview != null ? subOverview.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    public Collection<OverviewImages> getOverviewImagesById() {
        return overviewImagesById;
    }

    public void setOverviewImagesById(Collection<OverviewImages> overviewImagesById) {
        this.overviewImagesById = overviewImagesById;
    }
}
