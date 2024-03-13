package com.izeye.tools.developertools.web;

import com.izeye.tools.developertools.domain.QueryParameter;
import com.izeye.tools.developertools.domain.UrlInfo;
import com.izeye.tools.developertools.service.UrlSupportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * {@link RestController} for supporting URLs.
 *
 * @author Johnny Lim
 */
@RestController
@RequestMapping("/api/urls")
public class UrlSupportController {

    private final UrlSupportService urlSupportService;

    public UrlSupportController(UrlSupportService urlSupportService) {
        this.urlSupportService = urlSupportService;
    }

    @GetMapping("/analyze")
    public UrlInfo analyze(@RequestParam String url) {
        return this.urlSupportService.analyze(url);
    }

    @GetMapping("/analyze-query-parameters")
    public List<QueryParameter> analyzeQueryParameters(@RequestParam String query) {
        return this.urlSupportService.analyzeQueryParameters(query);
    }

}
