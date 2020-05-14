package com.lcehn.lucy.handler;

import com.lcehn.lucy.model.req.QccCompanyReq;
import com.lcehn.lucy.model.resp.CompanyQueryResp;
import com.lcehn.lucy.model.resp.QccCompanyResp;
import com.lcehn.lucy.query.QccCompanyQuery;

import java.util.Collection;

public class CompanyInfoHandler implements Handler<CompanyQueryResp<QccCompanyResp>, QccCompanyReq> {

    private QccCompanyQuery query;

    public CompanyInfoHandler(QccCompanyQuery query) {
        this.query = query;
    }

    @Override
    public CompanyQueryResp<QccCompanyResp> handle(QccCompanyReq companyReq) {
        Collection<QccCompanyResp> qccCompanyResps = this.query.query(companyReq);
        CompanyQueryResp<QccCompanyResp> resp = new CompanyQueryResp<>();
        resp.setAdShow(true);
        resp.setResults(qccCompanyResps);
        resp.setSuccessRate(0.89);
        return resp;
    }


}
