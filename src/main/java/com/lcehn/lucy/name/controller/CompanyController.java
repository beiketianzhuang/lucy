package com.lcehn.lucy.name.controller;

import com.lcehn.lucy.name.handler.Handler;
import com.lcehn.lucy.name.model.req.QccCompanyReq;
import com.lcehn.lucy.name.model.resp.CompanyQueryResp;
import com.lcehn.lucy.name.model.resp.QccCompanyResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.lcehn.lucy.name.constants.LucyConstants.COMPANY_INFO_PATH;


@RestController
public class CompanyController {

    @Autowired
    private Handler<CompanyQueryResp<QccCompanyResp>, QccCompanyReq> companyReqHandler;

    /**
     * 查询企业信息
     *
     * @param keyword
     * @return
     */
    @CrossOrigin(value = "http://localhost:8080")
    @GetMapping(value = COMPANY_INFO_PATH)
    public CompanyQueryResp<QccCompanyResp> qccCompanies(@RequestParam("keyword") String keyword) {
        QccCompanyReq qccCompanyReq = new QccCompanyReq();
        qccCompanyReq.setKeyword(keyword);
        qccCompanyReq.setProvinceCode("SH");
        qccCompanyReq.setCityCode("1");
        return companyReqHandler.handle(qccCompanyReq);
    }


}
