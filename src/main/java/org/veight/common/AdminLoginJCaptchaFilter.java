package org.veight.common;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.octo.captcha.service.CaptchaService;
import com.octo.captcha.service.CaptchaServiceException;
/**
 * 拦截器 - 后台登录验证码
 * @author Administrator
 * @date  2014-4-9 下午05:52:51 修改20140724
 */
@Component
public class AdminLoginJCaptchaFilter implements Filter {

	public static final String ADMIN_CAPTCHA_ERROR_URL = "/admin/login/login.xhtml";// 后台登录验证失败跳转URL
	public static final Logger log=Logger.getLogger(AdminLoginJCaptchaFilter.class);
	@Resource
	private CaptchaService captchaService;

	public void init(FilterConfig fConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
	throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String captchaID = request.getSession().getId();
		String challengeResponse = StringUtils.upperCase(request.getParameter(JCaptchaEngine.CAPTCHA_INPUT_NAME));
		//处理验证码Invalid ID过期异常
		try {
			boolean isCaptcha=captchaService.validateResponseForID(captchaID, challengeResponse);
			if (isCaptcha) {
				chain.doFilter(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + ADMIN_CAPTCHA_ERROR_URL+"?error=captcha");
			}
		} catch (CaptchaServiceException e) {
			// TODO Invalid ID, could not validate unexisting or already validated captcha 异常
			log.info("验证码已过期");
			response.sendRedirect(request.getContextPath() + ADMIN_CAPTCHA_ERROR_URL+"?error=invalid");
		}
	}
}
