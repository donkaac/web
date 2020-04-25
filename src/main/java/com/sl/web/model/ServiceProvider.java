package com.sl.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

/**
 * Created by Achi on 4/19/2020.
 */
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class ServiceProvider {
    private Integer id;
    private String name;
    private String description;
    private String address;
    private String phone1;
    private String phone2;
    private String email;
    private Integer serviceId;
    private Integer packageTypeId;
    private Service serviceByServiceId;
    private PackageType packageTypeByPackageTypeId;
    @JsonIgnore
    private Collection<ServiceProviderImages> serviceProviderImagesById;

    public ServiceProvider() {
    }

    public ServiceProvider(String name, String description, String address, String phone1, String phone2, String email) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.serviceId = serviceId;
        this.packageTypeId = packageTypeId;
        this.serviceByServiceId = serviceByServiceId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceProvider that = (ServiceProvider) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone1 != null ? !phone1.equals(that.phone1) : that.phone1 != null) return false;
        if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (serviceId != null ? !serviceId.equals(that.serviceId) : that.serviceId != null) return false;
        if (packageTypeId != null ? !packageTypeId.equals(that.packageTypeId) : that.packageTypeId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone1 != null ? phone1.hashCode() : 0);
        result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (serviceId != null ? serviceId.hashCode() : 0);
        result = 31 * result + (packageTypeId != null ? packageTypeId.hashCode() : 0);
        return result;
    }

    public Service getServiceByServiceId() {
        return serviceByServiceId;
    }

    public void setServiceByServiceId(Service serviceByServiceId) {
        this.serviceByServiceId = serviceByServiceId;
    }

    public PackageType getPackageTypeByPackageTypeId() {
        return packageTypeByPackageTypeId;
    }

    public void setPackageTypeByPackageTypeId(PackageType packageTypeByPackageTypeId) {
        this.packageTypeByPackageTypeId = packageTypeByPackageTypeId;
    }

    public Collection<ServiceProviderImages> getServiceProviderImagesById() {
        return serviceProviderImagesById;
    }

    public void setServiceProviderImagesById(Collection<ServiceProviderImages> serviceProviderImagesById) {
        this.serviceProviderImagesById = serviceProviderImagesById;
    }
}
