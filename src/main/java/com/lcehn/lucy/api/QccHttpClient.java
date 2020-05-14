package com.lcehn.lucy.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.ByteStreams;
import com.lcehn.lucy.model.req.QccCompanyReq;
import com.lcehn.lucy.model.resp.QccResponse;
import com.lcehn.lucy.validator.HttpResponseValidator;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class QccHttpClient {

    private CloseableHttpClient client;
    private String url;
    private ObjectMapper mapper;
    private String token;
    private HttpResponseValidator httpResponseValidator;

    public QccHttpClient(String url, String token) {
        this.url = url;
        this.token = token;
        client = HttpClients.custom().build();
        this.mapper = createDefaultObjectMapper();
        this.httpResponseValidator = new HttpResponseValidator();

    }

    public QccResponse query(QccCompanyReq companyReq) throws IOException {
        HttpGet get = new HttpGet();
        get.setHeader("Token", this.token);
        ZoneOffset zoneOffset = ZoneOffset.ofHours(8);
        LocalDateTime localDateTime = LocalDateTime.now();
        get.setHeader("Timespan", localDateTime.toEpochSecond(zoneOffset) + "");
        get.setURI(URI.create(this.url + "/ECIV4/Search?" + companyReq.toPath()));
        CloseableHttpResponse response = client.execute(get);
        try {
            httpResponseValidator.valid(response);
            return objectFromResponse(QccResponse.class, response);
        } finally {
            EntityUtils.consume(response.getEntity());
            releaseConnection(get);
        }
    }

    private ObjectMapper createDefaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

    private <T> T objectFromResponse(Class<T> cls, HttpResponse response) throws IOException {
        InputStream content = response.getEntity().getContent();
        byte[] bytes = ByteStreams.toByteArray(content);
        T result = mapper.readValue(bytes, cls);
        return result;
    }

    private void releaseConnection(HttpRequestBase httpRequestBase) {
        httpRequestBase.releaseConnection();
    }

    public void close() throws IOException {
        client.close();
    }
}
