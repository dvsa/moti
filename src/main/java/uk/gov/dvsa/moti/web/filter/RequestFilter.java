package uk.gov.dvsa.moti.web.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerResponseFilter {
    @Context
    HttpServletRequest webRequest;
    @Context
    HttpServletResponse webResponse;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        SessionCookieStorage sessionCookieStorage = new SessionCookieStorage();

        sessionCookieStorage.storeSessionInCookie(webRequest, webResponse);
    }
}
