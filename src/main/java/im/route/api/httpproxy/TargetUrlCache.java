
package im.route.api.httpproxy;

import org.apache.http.HttpHost;
import org.apache.http.client.utils.URIUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TargetUrlCache {

    private final ConcurrentHashMap<String, String> channelUrlMap = new ConcurrentHashMap<String, String>();

    public TargetUrlCache() {
        channelUrlMap.put("CUP CAR LOAN_YIXIN", "http://193.168.1.109:8080/IM");
        channelUrlMap.put("CUP CAR LOAN_SHYX", "http://localhost:8080/IM");
        //
        for (Map.Entry<String, String> entry : channelUrlMap.entrySet()) {
            uriHostObjectMap.put(entry.getKey(), new UriHostObject(entry.getValue(), getTargetHost(entry.getValue())));
        }
    }

    private final ConcurrentHashMap<String, UriHostObject> uriHostObjectMap = new ConcurrentHashMap<String, UriHostObject>();

    private HttpHost getTargetHost(String uri) {
        try {
            URI targetUriObj = new URI(uri);
            return URIUtils.extractHost(targetUriObj);
        } catch (Exception e) {
            e.printStackTrace();
            //throw new ServletException("Trying to process targetUri init parameter: "+e,e);
        }
        return null;
    }

    public UriHostObject getTargetUrl(HttpServletRequest servletRequest) {
        // get channel from http request
        String channel = "CUP CAR LOAN_SHYX";
        //..

        return uriHostObjectMap.get(channel);
    }
}
