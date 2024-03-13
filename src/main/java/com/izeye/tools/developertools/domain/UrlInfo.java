package com.izeye.tools.developertools.domain;

import java.util.List;

/**
 * URL information.
 *
 * @param scheme scheme
 * @param domain domain
 * @param path path
 * @param parameters parameters
 *
 * @author Johnny Lim
 */
public record UrlInfo(String scheme, String domain, String path, List<QueryParameter> parameters, String fragment) {
}
