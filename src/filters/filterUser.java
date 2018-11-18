package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.vo.EmployeeVO;

/**
 * Servlet Filter implementation class User
 */
public class filterUser implements Filter {

	private FilterConfig config;

	public void destroy() {
		config = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		EmployeeVO user = (EmployeeVO) session.getAttribute("userVO");
		System.out.println("進入filter");
		if (user == null) {
			System.out.println("準備倒出");
			System.out.println("req.getContextPath()=" + req.getContextPath());
			res.sendRedirect(req.getContextPath() + "/atd/common/login.jsp");
//			req.getRequestDispatcher(req.getContextPath() + "/atd/common/login.jsp").forward(req, res);
			return;
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
