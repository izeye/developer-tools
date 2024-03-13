package com.izeye.tools.developertools.service;

import com.izeye.tools.developertools.domain.QueryParameter;
import com.izeye.tools.developertools.domain.UrlInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link UrlSupportService}.
 *
 * @author Johnny Lim
 */
@SpringBootTest
class UrlServiceTests {

    @Autowired
    private UrlSupportService urlSupportService;

    @Test
    void analyze() {
        String url = "https://www.example.com/path1/path2?param1=value1&param2=%ED%85%8C%EC%8A%A4%ED%8A%B8#fragment";
        UrlInfo urlInfo = this.urlSupportService.analyze(url);
        assertThat(urlInfo.scheme()).isEqualTo("https");
        assertThat(urlInfo.domain()).isEqualTo("www.example.com");
        assertThat(urlInfo.path()).isEqualTo("/path1/path2");
        assertThat(urlInfo.parameters()).containsExactly(new QueryParameter("param1", "value1"), new QueryParameter("param2", "테스트"));
        assertThat(urlInfo.fragment()).isEqualTo("fragment");
    }

    @Test
    void analyzeQueryParameters() {
        String queryParameters = "param1=value1&param2=%ED%85%8C%EC%8A%A4%ED%8A%B8";
        assertThat(this.urlSupportService.analyzeQueryParameters(queryParameters))
                .containsExactly(new QueryParameter("param1", "value1"), new QueryParameter("param2", "테스트"));
    }

}
