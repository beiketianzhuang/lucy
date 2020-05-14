package com.lcehn.lucy.api;

import com.google.common.collect.Lists;
import com.lcehn.lucy.model.req.QccCompanyReq;
import com.lcehn.lucy.model.resp.QccCompanyResp;
import com.lcehn.lucy.model.resp.QccResponse;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public class QccHttpServer implements Closeable {


    private QccHttpClient client;

    public QccHttpServer(String url, String token) {
        client = new QccHttpClient(url, token);
    }

    public List<QccCompanyResp> getCompanyInfos(QccCompanyReq companyReq) {
        try {
            QccResponse response = client.query(companyReq);
            return response.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Lists.newArrayList();
    }

    @Override
    public void close() throws IOException {
        try {
            client.close();
        } catch (final IOException ex) {
        }
    }
}
