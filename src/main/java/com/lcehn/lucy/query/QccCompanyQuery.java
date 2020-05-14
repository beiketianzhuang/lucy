package com.lcehn.lucy.query;

import com.lcehn.lucy.api.QccHttpServer;
import com.lcehn.lucy.model.req.QccCompanyReq;
import com.lcehn.lucy.model.resp.QccCompanyResp;

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
