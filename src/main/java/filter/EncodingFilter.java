package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @web.filter name="Encoding Filter" display-name="Encoding Filter"
 * @web.filter-init-param name="encoding" value="utf-8"         
 * @web.filter-mapping url-pattern="/*"
 */
public class EncodingFilter implements Filter {
    private String encoding = null;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            if (encoding != null) {
                request.setCharacterEncoding(encoding);
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }
    
    @Override
    public void destroy() {
        this.encoding = null;
    }
}
