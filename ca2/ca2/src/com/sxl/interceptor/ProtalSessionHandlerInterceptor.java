package com.sxl.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sxl.dao.PublicDao;
import com.sxl.model.Admin;

public class ProtalSessionHandlerInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	private MessageSource messageSource;	
	@Autowired
	public PublicDao db;

	
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		request.setAttribute("site_title", messageSource.getMessage("site_title", null, "", null));
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String url =getRequestUrl(request);
		System.out.println(url);
		String sql="select a.wdxxId,count(1) counts,(select max(title) from t_wdxx b where a.wdxxId=b.id) title " +
				"from t_log a where exists(select 1 from t_wdxx c where c.status='发布' and c.id=a.wdxxId) group by wdxxId  order by counts desc limit 4";
		List<Map> list = db.queryForList(sql);
		request.setAttribute("rightBkList", list);
//		if(url.startsWith("/admin/")){
//			Admin adminBean = (Admin)request.getSession().getAttribute("adminBean");
//			if(adminBean==null||adminBean.getId()==null){
//				response.sendRedirect(request.getContextPath()+"/adminLogin/login.html");
//				return false;
//			}else{
//				return true;
//			}
//		}else if(url.startsWith("/adminLogin/")){
//			System.out.println("********adminLogin********");
//			return true;
//		}
		
		return true;
		
	}
	/**
	 * like "/action!method.action"
	 */
	public String getRequestUrl(HttpServletRequest request)
	{
		String url =request.getRequestURI();
		String path = request.getContextPath();
		if (StringUtils.isNotEmpty(path))
		{
			return url.substring(path.length());
		}
		return url;
	}
		/***
		 * 获取IP（如果是多级代理，则得到的是一串IP值）
		 */
		public static String getIpAddr(HttpServletRequest request) {
			String ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}

			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}

			if (ip != null && ip.length() > 0) {
				String[] ips = ip.split(",");
				for (int i = 0; i < ips.length; i++) {
					if (!"unknown".equalsIgnoreCase(ips[i])) {
						ip = ips[i];
						break;
					}
				}
			}

			return ip;
		}
		

}
