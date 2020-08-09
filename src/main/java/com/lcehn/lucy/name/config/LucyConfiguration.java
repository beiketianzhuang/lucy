package com.lcehn.lucy.name.config;

import com.lcehn.lucy.name.api.QccHttpServer;
import com.lcehn.lucy.name.handler.CompanyInfoHandler;
import com.lcehn.lucy.name.query.QccCompanyQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LucyConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public QccHttpServer qccHttpServer(@Value("${qcc.url}") String url,
                                       @Value("${qcc.token}") String token) {
        return new QccHttpServer(url, token);
    }

    @Bean
    @ConditionalOnMissingBean
    public QccCompanyQuery qccCompanyQuery(final QccHttpServer qccHttpServer) {
        return new QccCompanyQuery(qccHttpServer);
    }

    @Bean
    @ConditionalOnMissingBean
    public CompanyInfoHandler companyInfoHandler(final QccCompanyQuery query) {
        return new CompanyInfoHandler(query);
    }

}
