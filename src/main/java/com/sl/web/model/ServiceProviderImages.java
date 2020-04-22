package com.sl.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Achi on 4/19/2020.
 */
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class ServiceProviderImages {
    private Integer id;
    private String path;
    private Byte isLogo;
    private Integer serviceProviderId;
    private ServiceProvider serviceProviderByServiceProviderId;

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

    public Byte getIsLogo() {
        return isLogo;
    }

    public void setIsLogo(Byte isLogo) {
        this.isLogo = isLogo;
    }

    public Integer getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Integer serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceProviderImages that = (ServiceProviderImages) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (isLogo != null ? !isLogo.equals(that.isLogo) : that.isLogo != null) return false;
        if (serviceProviderId != null ? !serviceProviderId.equals(that.serviceProviderId) : that.serviceProviderId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (isLogo != null ? isLogo.hashCode() : 0);
        result = 31 * result + (serviceProviderId != null ? serviceProviderId.hashCode() : 0);
        return result;
    }

    public ServiceProvider getServiceProviderByServiceProviderId() {
        return serviceProviderByServiceProviderId;
    }

    public void setServiceProviderByServiceProviderId(ServiceProvider serviceProviderByServiceProviderId) {
        this.serviceProviderByServiceProviderId = serviceProviderByServiceProviderId;
    }
}
