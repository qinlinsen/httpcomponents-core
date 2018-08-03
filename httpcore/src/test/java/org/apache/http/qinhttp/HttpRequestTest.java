package org.apache.http.qinhttp;

import org.apache.http.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.InputStream;
import java.nio.charset.Charset;

public class HttpRequestTest {
    @Test
    public void testHttpRequest(){
        HttpRequest httpRequest = new BasicHttpRequest("GET","/some/to/some", HttpVersion.HTTP_1_1);
        System.out.println(httpRequest.getRequestLine().getMethod());
        System.out.println(httpRequest.getRequestLine().getUri());
        System.out.println(httpRequest.getRequestLine().getProtocolVersion());

        HttpResponse httpResponse=new BasicHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK,"ok");
        System.out.println(httpResponse.getStatusLine().getProtocolVersion());
        System.out.println(httpResponse.getStatusLine().getStatusCode());
        System.out.println(httpResponse.getStatusLine().getReasonPhrase());
    }
    @Test
    public void test2(){
        HttpResponse httpResponse=new BasicHttpResponse(HttpVersion.HTTP_1_1,HttpStatus.SC_OK,"ok");
        httpResponse.addHeader(new BasicHeader("Cache-Control","private"));
        httpResponse.addHeader("Connection","Keep-Alivej");
        httpResponse.addHeader("Set-Cookie","delPer=0; expires=Sun, 26-Jul-2048 00:52:30 GMT");
        Header[] headers = httpResponse.getAllHeaders();
        for(Header header:headers){
            System.out.println(header.getName()+"="+header.getValue());
        }
        System.out.println("************************");
        HeaderIterator headerIterator = httpResponse.headerIterator();
        while (headerIterator.hasNext()){
            System.out.println(headerIterator.next());
        }

    }
}

