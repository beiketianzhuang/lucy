package com.lcehn.lucy.model.resp;

import lombok.Data;


@Data
public class QccCompanyResp {

    /**
     * 内部KeyNo
     */
    private String KeyNo;
    /**
     * 公司名称
     */
    private String Name;
    /**
     * 法人名称
     */
    private String OperName;
    /**
     * 成立日期
     */
    private String StartDate;
    /**
     * 企业状态
     */
    private String Status;
    /**
     * 注册号
     */
    private String No;
    /**
     * 社会统一信用代码
     */
    private String CreditCode;

}

