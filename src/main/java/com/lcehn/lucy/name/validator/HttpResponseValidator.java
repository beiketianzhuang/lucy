package com.lcehn.lucy.name.validator;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpResponseException;


public class HttpResponseValidator implements Validator<HttpResponse>{

    @Override
    public void valid(HttpResponse response) throws HttpResponseException{
        int status = response.getStatusLine().getStatusCode();
        if (status < 200 || status >= 400) {
            throw new HttpResponseException(status, response.getStatusLine().getReasonPhrase());
        }
    }
}