package com.sl.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Created by Achi on 4/19/2020.
 */
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Service {
    private Integer id;
    private String name;
    private String content;
    private String slideShowImages;

    @JsonIgnore
    private Collection<ServiceImages> serviceImagesById;
    @JsonIgnore
    private Collection<ServiceProvider> serviceProvidersById;

    public Service() {
    }

    public Service(String name, String content, String slideShowImages) {
        this.name = name;
        this.content = content;
        this.slideShowImages = slideShowImages;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSlideShowImages() {
        return slideShowImages;
    }

    public void setSlideShowImages(String slideShowImages) {
        this.slideShowImages = slideShowImages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (id != null ? !id.equals(service.id) : service.id != null) return false;
        if (name != null ? !name.equals(service.name) : service.name != null) return false;
        if (content != null ? !content.equals(service.content) : service.content != null) return false;
        if (slideShowImages != null ? !slideShowImages.equals(service.slideShowImages) : service.slideShowImages != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (slideShowImages != null ? slideShowImages.hashCode() : 0);
        return result;
    }

    public Collection<ServiceImages> getServiceImagesById() {
        return serviceImagesById;
    }

    public void setServiceImagesById(Collection<ServiceImages> serviceImagesById) {
        this.serviceImagesById = serviceImagesById;
    }

    public Collection<ServiceProvider> getServiceProvidersById() {
        return serviceProvidersById;
    }

    public void setServiceProvidersById(Collection<ServiceProvider> serviceProvidersById) {
        this.serviceProvidersById = serviceProvidersById;
    }
}
