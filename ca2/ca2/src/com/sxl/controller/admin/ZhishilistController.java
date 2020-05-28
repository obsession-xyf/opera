
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

@Controller("zhishilistController")
@RequestMapping(value = "/admin/zhishilist")
public class ZhishilistController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/zhishilist/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')

		String sql="select a.*,(select title from t_zhishi b where a.zhishiId=b.id) title ,(select max(name) from t_customer b where a.customerId=b.id) name  from t_zhishilist a where 1=1 ";

if(1==2){sql+="and customerId="+getCustomer(request).get("id") +" ";}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/zhishilist/list";
	}
	
	@RequestMapping(value = "/editSave")
	@ResponseBody	public Map editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer zhishiId,Integer customerId,String content,String insertDate) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_zhishilist set zhishiId=?,content=? where id=?";
			result = db.update(initSql(sql, new Object[]{zhishiId,content,id}));
		}else{
			String sql="insert into t_zhishilist(zhishiId,customerId,content,insertDate) values(?,?,?,now())";
			result = db.update(initSql(sql, new Object[]{zhishiId,getCustomer(request).get("id"),content}));
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	@ResponseBody	public Map editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_zhishilist where id=?";
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
			String sql="select * from t_zhishilist where id=?";
			Map map = db.queryForMap(initSql(sql,new Object[]{id}));
			model.addAttribute("map", map);
		}String sql="";

 sql="select * from t_zhishi";
model.addAttribute("zhishiList", db.queryForList(sql));

		return "/admin/zhishilist/edit";
	}
}
