package com.izeye.tools.developertools.service;

import com.izeye.tools.developertools.domain.QueryParameter;
import com.izeye.tools.developertools.domain.UrlInfo;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * Default {@link UrlSupportService}.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultUrlSupportService implements UrlSupportService {

    @Override
    public UrlInfo analyze(String url) {
        String[] schemeAndOthers = url.split("://", 2);
        String scheme = schemeAndOthers[0];
        String[] domainAndOthers = schemeAndOthers[1].split("/", 2);
        String domain = domainAndOthers[0];
        String[] pathAndOthers = domainAndOthers[1].split("\\?", 2);
        String path = "/" + pathAndOthers[0];
        String[] queryAndOthers = pathAndOthers[1].split("#", 2);
        String queryParameters = queryAndOthers[0];
        List<QueryParameter> parameters = analyzeQueryParameters(queryParameters);
        String fragment = (queryAndOthers.length == 2) ? queryAndOthers[1] : null;
        return new UrlInfo(scheme, domain, path, parameters, fragment);
    }

    @Override
    public List<QueryParameter> analyzeQueryParameters(String queryParameters) {
        return Arrays.stream(queryParameters.split("&")).map((parameter) -> {
            String[] nameAndValue = parameter.split("=", 2);
            String value = (nameAndValue.length == 2) ? URLDecoder.decode(nameAndValue[1], StandardCharsets.UTF_8) : null;
            return new QueryParameter(nameAndValue[0], value);
        }).toList();
    }

}
