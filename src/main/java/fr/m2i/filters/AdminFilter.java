package fr.m2i.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.backed.LoginBean;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class AdminFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	//private String fail = "/ExerciceJSF/pages/failed.xhtml";
	
	
	@Inject
	private LoginBean lb;
	
	/**
     * @see HttpFilter#HttpFilter()
     */
    public AdminFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request; 
		HttpServletResponse resp = (HttpServletResponse) response; 
		
		//System.out.println("I haz filtered " + lb.getLogin());
		
		//Utilisation getCOntextPath() pour éliminer pb de URL en dur
		if(!lb.getLogin().equals("admin")) {
			resp.sendRedirect(req.getContextPath()+"/pages/failed.xhtml");
		}
		chain.doFilter(request, response);
		
		
		// !!! bien penser à faire ELSE pour BLOQUER !!!
		/*if ( lb.getLogin().equals("admin")) {
			System.out.println("I haz into the filter ");
			chain.doFilter(request, response);
		} else {		
			System.out.println("I haz failed the filter ");
			resp.sendRedirect(fail);
		}*/
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
