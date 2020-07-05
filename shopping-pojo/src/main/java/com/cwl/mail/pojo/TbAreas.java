package com.cwl.mail.pojo;

import java.io.Serializable;

public class TbAreas implements Serializable {
    /**
     * 唯一ID
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 区域ID
     *
     * @mbg.generated
     */
    private String areaid;

    /**
     * 区域名称
     *
     * @mbg.generated
     */
    private String area;

    /**
     * 城市ID
     *
     * @mbg.generated
     */
    private String cityid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaid=").append(areaid);
        sb.append(", area=").append(area);
        sb.append(", cityid=").append(cityid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}