package com.cwl.mail.pojo;

import java.io.Serializable;

public class TbCities implements Serializable {
    /**
     * 唯一ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 城市ID
     *
     * @mbg.generated
     */
    private String cityid;

    /**
     * 城市名称
     *
     * @mbg.generated
     */
    private String city;

    /**
     * 省份ID
     *
     * @mbg.generated
     */
    private String provinceid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityid=").append(cityid);
        sb.append(", city=").append(city);
        sb.append(", provinceid=").append(provinceid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}