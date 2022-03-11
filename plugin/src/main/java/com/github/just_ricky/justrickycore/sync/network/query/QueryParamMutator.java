package com.github.just_ricky.justrickycore.sync.network.query;

import java.util.HashMap;
import java.util.Map;

public class QueryParamMutator {

    /**
     * Original url
     */
    private final String url;

    /**
     * Query params map
     */
    private Map<String, String> queryParams = new HashMap<>();

    /**
     * Query param mutator
     *
     * @param url url
     */
    public QueryParamMutator(String url) {
        this.url = url;
    }

    /**
     * Adds a query param
     *
     * @param key   key
     * @param value value
     * @return this
     */
    public QueryParamMutator addParam(String key, Object value) {
        this.queryParams.put(key, value.toString());
        return this;
    }

    /**
     * Builds the final url
     *
     * @return url
     */
    public String build() {
        String url = new String(this.url);

        if (this.queryParams.size() >= 1) {
            url += "?";
        }

        for (Map.Entry<String, String> stringStringEntry : this.queryParams.entrySet()) {
            url += stringStringEntry.getKey() + "=" + stringStringEntry.getValue();
            url += "&";
        }

        // remove last "&"
        url = url.substring(0, url.length() - 1);

        return url;
    }
}
