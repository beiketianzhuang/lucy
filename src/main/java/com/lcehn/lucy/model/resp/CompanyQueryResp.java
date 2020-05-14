package com.lcehn.lucy.model.resp;

import lombok.Data;

import java.util.Collection;

@Data
public class CompanyQueryResp<T> {

    /**
     * 成功几率
     */
    private int successRate;

    private Collection<T> results;

    /**
     * 是否显示广告
     */
    private boolean adShow = true;


}
