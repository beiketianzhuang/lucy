package com.lcehn.lucy.name.model.resp;

import lombok.Data;

import java.util.List;

@Data
public class QccResponse {

    private List<QccCompanyResp> Result;
    private String OrderNumber;
    private String Status;
    private String Message;
    private QccPaging Paging;


}
