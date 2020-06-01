package com.lcehn.lucy.handler;

import com.google.common.collect.Lists;
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
//        Collection<QccCompanyResp> qccCompanyResps = this.query.query(companyReq);
        Collection<QccCompanyResp> qccCompanies = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            QccCompanyResp qccCompanyResp = new QccCompanyResp();
            qccCompanyResp.setName("上海启贵服务有限公司" + i);
            qccCompanyResp.setOperName("陈朗" + i);
            qccCompanyResp.setStartDate("2019-05-11");
            qccCompanyResp.setStatus("经营中");
            qccCompanies.add(qccCompanyResp);
        }
        CompanyQueryResp<QccCompanyResp> resp = new CompanyQueryResp<>();
        resp.setAdShow(true);
        resp.setResults(qccCompanies);
        resp.setSuccessRate(89);
        return resp;
    }


}
