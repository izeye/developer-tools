package com.izeye.tools.developertools.service;

import com.izeye.tools.developertools.domain.QueryParameter;
import com.izeye.tools.developertools.domain.UrlInfo;

import java.util.List;

/**
 * Service interface for supporting URLs.
 *
 * @author Johnny Lim
 */
public interface UrlSupportService {

    UrlInfo analyze(String url);

    List<QueryParameter> analyzeQueryParameters(String queryParameters);

}
