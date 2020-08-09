package com.lcehn.lucy.name.query;

import com.lcehn.lucy.name.api.QccHttpServer;
import com.lcehn.lucy.name.model.req.QccCompanyReq;
import com.lcehn.lucy.name.model.resp.QccCompanyResp;

import java.util.Collection;

/**
 * 企查查
 */
public class QccCompanyQuery implements Query<QccCompanyResp, QccCompanyReq> {

    private QccHttpServer qccHttpServer;

    public QccCompanyQuery(QccHttpServer qccHttpServer) {
        this.qccHttpServer = qccHttpServer;
    }

    @Override
    public Collection<QccCompanyResp> query(QccCompanyReq qccCompanyReq) {
        return qccHttpServer.getCompanyInfos(qccCompanyReq);
    }
}
