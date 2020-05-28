
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxl.controller.MyController;

@Controller("zhishiController")
@RequestMapping(value = "/admin/zhishi")
public class ZhishiController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/zhishi/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String title)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')

		String sql="select a.* from t_zhishi a where 1=1 ";


	if(title!=null&&!"".equals(title)){
			sql+=" and title like '%"+title+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/zhishi/list";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody	public Map editSave(Model model,HttpServletRequest request,Long id,String flag
		,String title,String pic,String fileUrl,String content,String showDate) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_zhishi set title=?,pic=?,fileUrl=?,content=?,showDate=? where id=?";
			result = db.update(initSql(sql, new Object[]{title,pic,fileUrl,content,showDate,id}));
		}else{
			String sql="insert into t_zhishi(title,pic,fileUrl,content,showDate) values(?,?,?,?,?)";
			result = db.update(initSql(sql, new Object[]{title,pic,fileUrl,content,showDate}));
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody	public Map editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_zhishi where id=?";
		int result = db.update(initSql(sql, new Object[]{id}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_zhishi where id=?";
			Map map = db.queryForMap(initSql(sql,new Object[]{id}));
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/zhishi/edit";
	}
}
