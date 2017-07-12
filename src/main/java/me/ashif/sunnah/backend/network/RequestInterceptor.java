package me.ashif.sunnah.backend.network;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * Created by Ashif on 12/7/17.
 * github.com/SheikhZayed
 */
public class RequestInterceptor implements ClientHttpRequestInterceptor{
    private String mHeaderName;
    private String mHeaderValue;

    public RequestInterceptor(String mHeaderName, String mHeaderValue) {
        this.mHeaderName = mHeaderName;
        this.mHeaderValue = mHeaderValue;
    }

    public void setmHeaderName(String mHeaderName) {
        this.mHeaderName = mHeaderName;
    }

    public void setmHeaderValue(String mHeaderValue) {
        this.mHeaderValue = mHeaderValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        HttpRequest requestWrapper = new HttpRequestWrapper(httpRequest);
        requestWrapper.getHeaders().set(mHeaderName,mHeaderValue);
        return clientHttpRequestExecution.execute(requestWrapper,bytes);
    }
}
