package uk.gov.dvsa.moti.web.cookie;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Manages cookies
 */
public class Cookies {
    /**
     * Remove cookie
     * @param response
     * @param cookieName
     */
    public static void removeCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = createCookie(cookieName, "", "/", 0);
        response.addCookie(cookie);
    }

    /**
     * Read cookie
     * @param request
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)  {
            return Arrays.stream(request.getCookies()).filter(cookie -> cookie.getName().equals(cookieName)).findFirst().orElse(null);
        }
        return null;
    }

    /**
     * Create cookie
     * @param cookieName
     * @param value
     * @param path
     * @param cookieMaxAge
     * @return
     */
    public static Cookie createCookie(String cookieName, String value, String path, int cookieMaxAge) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath(path);
        cookie.setMaxAge(cookieMaxAge);
        return cookie;
    }
}
