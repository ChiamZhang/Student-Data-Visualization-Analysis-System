package com.atzhuang.bean.responseBody;

public class SexProvinceCount {
    public String province;
    public String sex;

    public long quality;

    public SexProvinceCount( String province,String sex, long quality) {
        this.sex = sex;
        this.province = province;
        this.quality = quality;
    }
}
