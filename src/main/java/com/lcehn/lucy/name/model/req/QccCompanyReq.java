package com.lcehn.lucy.name.model.req;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class QccCompanyReq {
    /**
     * 应用APPKEY(应用详细页查询)
     */
    private String key;
    /**
     * 搜索关键字（公司名、注册号或社会统一信用代码）
     */
    private String keyword;
    /**
     * 省份代码
     */
    private String provinceCode;
    /**
     * 地级市代码
     */
    private String cityCode;
    /**
     * 每页条数，默认为10,最大不超过20条
     */
    private int pageSize;
    /**
     * 页码，默认第一页
     */
    private int pageIndex;
    /**
     * 返回数据格式：json或xml，默认json
     */
    private String dtype;


    public String toPath() {
        //key=AppKey&keyword=小桔科技
        StringBuilder sb = new StringBuilder();
        sb.append("key=" + this.key);
        sb.append("&keyword=" + this.keyword);
        if (StringUtils.isNoneBlank(this.provinceCode)) {
            sb.append("&provinceCode=" + this.provinceCode);
        }
        if (StringUtils.isNoneBlank(this.cityCode)) {
            sb.append("&cityCode=" + this.cityCode);
        }
        return sb.toString();
    }

}
