package com.sxl.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jason.framework.mvc.spring.BaseController;
import com.jason.framework.util.JacksonJsonUtil;
import com.sxl.dao.PublicDao;
import com.sxl.model.Admin;

public class MyController extends BaseController {
	@Autowired
	public PublicDao db;
	
	
//	public Admin getAdmin(HttpServletRequest request){
//		Admin customerBean = (Admin)request.getSession().getAttribute("adminBean");
//		return customerBean;
//	}
	
	public Map getAdmin(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("adminBean");
		return customerBean;
	}
	
	public Map getCustomer(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("customerBean");
		return customerBean;
	}
	
	public Map getYg(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("ygBean");
		return customerBean;
	}
	
	public String initSql(String sql,Object[] list){
		
		if(sql.endsWith("?")){
			String[] aa = sql.split("\\?");
			String res="";
			System.out.println(aa.length+"***aaaa");
			System.out.println(list.length+"***list");
			for (int i = 0; i < aa.length; i++) {
				if(list[i]==null){
					res+=(aa[i]+""+list[i]+"");
				}else{
					res+=(aa[i]+"'"+list[i]+"'");
				}
				
			}
			return res;
		}else{
			String[] aa = sql.split("\\?");
			String res="";
			System.out.println(aa.length+"***aaaa");
			System.out.println(list.length+"***list");
			for (int i = 0; i < list.length; i++) {
				if(list[i]==null){
					res+=(aa[i]+""+list[i]+"");
				}else{
					res+=(aa[i]+"'"+list[i]+"'");
				}
				
			}
			res+=aa[aa.length-1];
			return res;
		}
		
		
	}
	
	
	public Map ajaxMap(boolean is,String msg,Object data){
		Map map = new HashMap();
		map.put("status", is);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
	public Map renderData(boolean is,String msg,Object data){
		Map map = new HashMap();
		map.put("status", is);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
	
	public Map renderMsg(boolean is,String msg){
		Map map = new HashMap();
		map.put("status", is);
		map.put("msg", msg);
		return map;
	}
	
	

	public static void main(String[] args) {
		MyController mc = new MyController();
		String sql="insert into t_customer(name,password,mobile,sex,address,insertDate,status) values(?,?,?,?,?,now(),1)";
		String aaa = mc.initSql(sql, new Object[]{"1","2","3","4","5"});
		System.out.println(aaa);
		
//		System.out.println(sql.endsWith("?"));
	}
	
	
	public void writeToExcel(HSSFWorkbook wb, String fileName,HttpServletResponse response)
			throws IOException {
		fileName = (fileName == null || fileName.equals("")) ? "result"
				: fileName;
		fileName = java.net.URLEncoder.encode(fileName, "UTF-8").replace('+',
				' ');
		response.reset();
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename="
				+ fileName + ".xls");
		wb.write(response.getOutputStream());
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
	

}