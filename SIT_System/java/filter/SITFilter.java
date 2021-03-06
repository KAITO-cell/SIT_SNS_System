/**************************************************************************************************
 ***  File Name      : SITFilter.java
 ***  Version        : V1.0
 ***  Designer       : 奈良操樹
 ***  Date           : 2021.06.19
 ***  Purpose        : 文字化けをしないようにUTF-8にエンコーディングする。
 ***
 **************************************************************************************************/
/*
 *** Revision :
 *** V1.0 : 奈良操樹,2021.06.19
 */
package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ExampleFilter
 */
@WebFilter("/*")
public class SITFilter implements Filter {

	private String encoding="UTF-8";
    /**
     * Default constructor.
     */
    public SITFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
    	try {
    	request.setCharacterEncoding(encoding);
    	response.setCharacterEncoding(encoding);

		// pass the request along the filter chain
		chain.doFilter(request, response);
    	} catch (ServletException se){
        }catch(Exception e) {
    	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
    @Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
