package im.route.api.httpproxy;

import org.apache.http.HttpHost;

public class UriHostObject {
    protected String targetUri;
    protected HttpHost targetHost;//URIUtils.extractHost(targetUriObj);

    UriHostObject(String targetUri, HttpHost targetHost) {
        this.targetUri = targetUri;
        this.targetHost = targetHost;
    }

    public String getTargetUri() {
        return targetUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    public HttpHost getTargetHost() {
        return targetHost;
    }

    public void setTargetHost(HttpHost targetHost) {
        this.targetHost = targetHost;
    }
}
