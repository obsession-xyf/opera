package com.sxl.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxl.controller.MyController;
import com.sxl.util.StringHelper;

@Controller("webController")
@RequestMapping(value = "/front")
public class FrontController extends MyController {

	///用户的基本功能开始///////////////////////////////////////////////
	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request,String dth,Long oneClassifyId,String quyu,String hx,String begin,String end,String czxs)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select max(name) from t_customer b where b.id=a.customerId) customerName," +
				"(select bkName from t_bk c where c.id=a.bkId) bkName from t_wdxx a where 1=1 and status='发布'  ";
		if(dth !=null&&!"".equals(dth)){
			sql+=" and a.dth like '%"+dth+"%'";
		}
		if(quyu !=null&&!"".equals(quyu)){
			sql+=" and a.quyu= '"+quyu+"'";
		}
		if(hx !=null&&!"".equals(hx)){
			sql+=" and a.hx= '"+hx+"'";
		}
		if(begin !=null&&!"".equals(begin)){
			sql+=" and a.jiage>= "+begin+"";
		}
		if(end !=null&&!"".equals(end)){
			sql+=" and a.jiage<= "+end+"";
		}
		if(customer==null||customer.size()==0){
			sql+=" and a.nologin='是' ";
		}
		if(czxs !=null&&!"".equals(czxs)){
			sql+=" and a.czxs= '"+czxs+"'";
		}
		
		sql+=" order by zan desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list1", list);
		
		
		request.getSession().setAttribute("seachList", list);
		
		
		return "/front/index";
	}
	
	@RequestMapping(value = "/index2")
	public String index2(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select max(name) from t_customer b where b.id=a.customerId) customerName," +
				"(select bkName from t_bk c where c.id=a.bkId) bkName from t_wdxx a where bkId=1  ";
		if(searchName !=null&&!"".equals(searchName)){
			sql+=" and a.title like '%"+searchName+"%'";
		}
		if(customer==null||customer.size()==0){
			sql+=" and a.nologin='是' ";
		}
		
		sql+=" order by id desc ";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		
		
		return "/front/index2";
	}
	

	@RequestMapping(value = "/index3")
	public String index3(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select max(name) from t_customer b where b.id=a.customerId) customerName," +
				"(select bkName from t_bk c where c.id=a.bkId) bkName from t_wdxx a where bkId=2  ";
		if(searchName !=null&&!"".equals(searchName)){
			sql+=" and a.title like '%"+searchName+"%'";
		}
		if(customer==null||customer.size()==0){
			sql+=" and a.nologin='是' ";
		}
		
		sql+=" order by id desc ";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		
		
		return "/front/index3";
	}
	
	public List<Map> initList2(List<Map> list){
		String sql="select * from t_mgc ";
		List<Map> mgcList = db.queryForList(sql);
		if(list!=null&&list.size()>0){
			if(mgcList!=null&&mgcList.size()>0){
				for (int i = 0; i < list.size(); i++) {
					Map map = list.get(i);
					String title = map.get("title").toString();
					String content = map.get("content").toString();
					for (int j = 0; j < mgcList.size(); j++) {
						String mgc = mgcList.get(j).get("mgc").toString();
						title = title.replace(mgc, "***");
						content = content.replace(mgc, "***");
						list.get(i).put("title", title);
						list.get(i).put("content", content);
					}
				}
			}
			
			
		}
		return list;
	}
	
	public Map initMap2(Map map){
		String sql="select * from t_mgc ";
		List<Map> mgcList = db.queryForList(sql);
			if(mgcList!=null&&mgcList.size()>0){
				String title = map.get("title").toString();
				String content = map.get("content").toString();
				for (int j = 0; j < mgcList.size(); j++) {
					String mgc = mgcList.get(j).get("mgc").toString();
					title = title.replace(mgc, "***");
					content = content.replace(mgc, "***");
					map.put("title", title);
					map.put("content", content);
				}
			
			
		}
		return map;
	}
	
	@RequestMapping(value = "/bk")
	public String bk(Model model, HttpServletRequest request,Long id)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select * from t_bk where id="+id;
		Map map  =db.queryForMap(sql);
		model.addAttribute("map", map);
		
		sql="select *,(select max(name) from t_customer b where b.id=a.customerId) customerName," +
				"(select bkName from t_bk c where c.id=a.bkId) bkName from t_wdxx a where bkId="+id+" ";
		if(customer==null||customer.size()==0){
			sql+=" and a.nologin='是' ";
		}
		sql+=" order by id desc";
		
		
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/front/bk";
	}
	
	
	@RequestMapping(value = "/ltgz")
	public String ltgz(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		String sql="select * from t_ltsm limit 1";
		Map map  =db.queryForMap(sql);
		model.addAttribute("map", map);
		return "/front/ltgz";
	}
	
	@RequestMapping(value = "/list1")
	public String list1(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		String sql="select a.*,(select max(title) from t_wdxx b where a.wdxxId=b.id) title from t_log a where customerId="+getCustomer(request).get("id")+" order by id desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/front/list1";
	}
	
	@RequestMapping(value = "/list2")
	public String list2(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		String sql="select a.*,(select max(title) from t_wdxx b where a.wdxxId=b.id) title from t_zanlog a where customerId="+getCustomer(request).get("id")+" order by id desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/front/list2";
	}
	
	@RequestMapping(value = "/list3")
	public String list3(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		String sql="select a.*,(select max(title) from t_wdxx b where a.wdxxId=b.id) title from t_pinglun a where customerId="+getCustomer(request).get("id")+" order by id desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/front/list3";
	}
	
	@RequestMapping(value = "/map")
	public String map(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		
		return "/front/map";
	}
	
	@RequestMapping(value = "/find")
	public String find(Model model, HttpServletRequest request)
			throws Exception {
		return "/front/find";
	}
	
	@RequestMapping(value = "/cwshow")
	public String cwshow(Model model, HttpServletRequest request,Long id)
			throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_cw where id=?";
			Map map = db.queryForMap(initSql(sql,new Object[]{id}));
			model.addAttribute("map", map);
		}
		return "/front/cwshow";
	}
	
	@RequestMapping(value = "/mycw")
	public String mycw(Model model, HttpServletRequest request,Long id)
			throws Exception {
		String sql="select * from t_cw where customerId='"+getCustomer(request).get("id")+"' order by id desc";
		List<Map> cwList = db.queryForList(sql);
		model.addAttribute("cwList", cwList);
		return "/front/mycw";
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model, HttpServletRequest request,String searchName,Long oneClassifyId)
			throws Exception {
		String sql="select * from t_rd order by id desc";
		List<Map> rdList = db.queryForList(sql);
		model.addAttribute("rdList", rdList);
		
		
		sql="select * from t_cw order by id desc";
		List<Map> cwList = db.queryForList(sql);
		model.addAttribute("cwList", cwList);
		return "/front/home";
	}

	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request)
			throws Exception {
		return "/front/login";
	}
	
	@RequestMapping(value = "/register")
	public String register(Model model, HttpServletRequest request)
			throws Exception {
		return "/front/register";
	}
	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request)
			throws Exception {
		Map customer = getCustomer(request);
		model.addAttribute("customer", customer);
		return "/front/mine";
	}
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request)
			throws Exception {
		return "/front/password";
	}

	@RequestMapping(value = "/changePassword")
	@ResponseBody	public Map changePassword(Model model,
			HttpServletRequest request, String oldPassword, String newPassword)
			throws Exception {
		Map admin = getAdmin(request);
		if (oldPassword.equals(admin.get("password").toString())) {
			String sql = "update t_admin set password=? where id=?";
			db.update(initSql(sql, new Object[] { newPassword, admin.get("id") }));
			return renderData(true, "1", null);
		} else {
			return renderData(false, "1", null);
		}
	}

	@RequestMapping(value = "/save")
	@ResponseBody	public Map loginSave(Model model,
			HttpServletRequest request, String username, String password)
			throws Exception {
		String sql = "select * from t_customer where username=?";
		List<Map> list = db.queryForList(initSql(sql, new Object[] { username }));
		String result = "1";
		if (list != null && list.size() > 0) {
			Map map = list.get(0);
			if (StringHelper.get(map, "password").equals(password)) {
				request.getSession().setMaxInactiveInterval(60 * 60 * 24);
				request.getSession().setAttribute("customerBean", map);
				result = "1";
			} else {
				result = "0";
			}
		} else {
			result = "0";
		}
		return renderData(true, result, null);
	}
	
	@RequestMapping(value = "/findSave")
	@ResponseBody	public Map findSave(Model model,
			HttpServletRequest request, String username, String mb1,String mb2,String mb3)
			throws Exception {
		String sql = "select * from t_customer where username=? and mb1=? and mb2=? and mb3=?";
		List<Map> list = db.queryForList(initSql(sql, new Object[] { username,mb1,mb2,mb3 }));
		System.out.println(list);
		String result = "1";
		if (list != null && list.size() > 0) {
			Map map = list.get(0);
			return renderData(true, result, null);
		} else {
			return renderData(false, result, null);
		}
		
	}
	
	@RequestMapping(value = "/findSaveConfirm")
	@ResponseBody	public Map findSaveConfirm(Model model,
			HttpServletRequest request, String username, String phone,String password, String mb1,String mb2,String mb3)
			throws Exception {
		String sql = "update t_customer set password=? where  username=?  and mb1=? and mb2=? and mb3=?";
		db.update(initSql(sql, new Object[] {password, username,mb1,mb2,mb3 }));
		return renderData(true, "", null);
	}

	@RequestMapping(value = "/registerSave")
	@ResponseBody	public Map mineSave(Model model,
			HttpServletRequest request, Long id, String username,String name,
			String password, String phone,String sex,String age,
			String address,String idcard,String headPic,String mb1,String mb2,String mb3) throws Exception {
		/*
		create table t_customer(
		id int primary key auto_increment,
		username varchar(1000) comment '账号',
		password varchar(1000) comment '密码',
		name varchar(1000) comment '姓名',
		phone varchar(1000) comment '手机',
		sex varchar(100) comment '性别',
		age  varchar(100) comment '年龄',
		address varchar(100) comment '家庭住址',
		idcard varchar(100) comment '身份证',
		insertDate datetime comment '入库日期'
		) comment '用户';
		*/
		
		
		int result = 0;
		
		
		String sql="select * from t_customer where username='"+username+"'";
		List<Map> aaa = db.queryForList(sql);
		if(aaa!=null&&aaa.size()>0){
			return renderData(false, "1", null);
		}
		
		 sql = "insert into t_customer(username,password,name,phone,sex,age,address,idcard,insertDate," +
				"headPic,level,ispl,isft,mb1,mb2,mb3) values(?,?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?)";
		result = db.update(initSql(sql, new Object[] { username, password,name, phone,
				sex,age,address,idcard ,headPic,"初级","是","是",mb1,mb2,mb3}));
		sql = "select * from t_customer order by id desc limit 1";
		List<Map> list = db.queryForList(sql);
		request.getSession().setMaxInactiveInterval(60 * 60 * 24);
		request.getSession().setAttribute("customerBean", list.get(0));
		return renderData(true, "操作成功", null);
	}
	
	@RequestMapping(value = "/registerModifySave")
	@ResponseBody	public Map registerModifySave(Model model,
			HttpServletRequest request, Long id, String username,String name,
			String password, String phone,String sex,String age,String address,String idcard,String headPic,String mb1,String mb2,String mb3) throws Exception {
		
		int result = 0;
		String sql = "update t_customer set password=?, name=?,phone=?,sex=?,age=?,address=?,idcard=?,headPic=?,mb1=?,mb2=?,mb3=? where id=?";
		result = db.update(initSql(sql, new Object[] { password, name, phone,
				sex,age,address,idcard,headPic,mb1,mb2,mb3,id }));
		sql = "select * from t_customer where id="+getCustomer(request).get("id");
		List<Map> list = db.queryForList(sql);
		request.getSession().setMaxInactiveInterval(60 * 60 * 24);
		request.getSession().setAttribute("customerBean", list.get(0));
		return renderData(true, "操作成功", null);
	}
	

	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request) throws Exception {
		request.getSession().removeAttribute("customerBean");
		return "redirect:/front/login.html";
	}
	
	@RequestMapping(value = "/friend")
	public String friend(Model model, HttpServletRequest request,String name)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select case when exists(select 1 from t_wdhy b where b.customerId="+customer.get("id")+" and b.hhId=a.id) then 1 else 0 end) isGz from t_customer a where 1=1";
		if(name!=null&&!"".equals(name)){
				sql+=" and name like '%"+name+"%'";
			}
			sql+=" order by id desc";
			List list = db.queryForList(sql);
			request.setAttribute("list", list);
		return "/front/friend";
	}
	
	
	@RequestMapping(value = "/qxgz")
	@ResponseBody	public Map qxgz(Model model,
			HttpServletRequest request, Long id) throws Exception {
		Map customer = getCustomer(request);
		String sql="delete from t_wdhy where customerId=? and hhId=?";
		db.update(initSql(sql, new Object[]{customer.get("id"),id}));
		return renderData(true, "操作成功", null);
	}
	

	@RequestMapping(value = "/wdxxDelete")
	@ResponseBody	public Map wdxxDelete(Model model,
			HttpServletRequest request, Long id) throws Exception {
		Map customer = getCustomer(request);
		String sql="delete from t_wdxx where  id=?";
		db.update(initSql(sql, new Object[]{id}));
		return renderData(true, "操作成功", null);
	}
	
	
	@RequestMapping(value = "/gz")
	@ResponseBody	public Map gz(Model model,
			HttpServletRequest request, Long id) throws Exception {
		Map customer = getCustomer(request);
		String sql="insert into t_wdhy(customerId,hhId,insertDate) values(?,?,now())";
		db.update(initSql(sql, new Object[]{customer.get("id"),id}));
		return renderData(true, "操作成功", null);
	}
	
	@RequestMapping(value = "/myfriend")
	public String myfriend(Model model, HttpServletRequest request,String name)
			throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select case when exists(select 1 from t_wdhy b where b.customerId="+customer.get("id")+" and b.hhId=a.id) then 1 else 0 end) isGz from t_customer a where 1=1";
		if(name!=null&&!"".equals(name)){
				sql+=" and name like '%"+name+"%'";
			}
		sql+=" and exists(select 1 from t_wdhy b where b.customerId="+customer.get("id")+" and b.hhId=a.id) ";
			sql+=" order by id desc";
			List list = db.queryForList(sql);
			request.setAttribute("list", list);
		return "/front/myfriend";
	}
	
	@RequestMapping(value = "/wdxxList")
	public String list(Model model, HttpServletRequest request,String flag,String title,String types,Long bkId)throws Exception {
		String sql="select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName  from t_wdxx a where 1=1  ";

if(1==1){sql+=" and customerId="+getCustomer(request).get("id") +" ";}
	if(title!=null&&!"".equals(title)){
			sql+=" and title like '%"+title+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/front/wdxxList";
	}
	
	@RequestMapping(value = "/hywdxxList")
	public String hywdxxList(Model model, HttpServletRequest request,String flag,String title)throws Exception {
		Map customer = getCustomer(request);
		String sql="select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName  from t_wdxx a where 1=1";
		sql+=" and exists(select 1 from t_wdhy b where a.customerId=b.hhId and b.customerId="+customer.get("id")+") ";
	if(title!=null&&!"".equals(title)){
			sql+=" and title like '%"+title+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/front/wdxxList";
	}
	
	@RequestMapping(value = "/wdxxEditSave")
	@ResponseBody	public Map editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer customerId,String title,String pic,String content,Integer zan,
		String insertDate,String nologin,Long bkId,String types,
		String hx,String czxs,String quyu,String jiage,String dth,String fwzt,String lxr,String lxdh,String jwd,String status
		) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_wdxx set title=?,pic=?,content=?,nologin=?,hx=?," +
					"czxs=?,quyu=?,jiage=?,dth=?,fwzt=?,lxr=?,lxdh=?,jwd=?,status=? where id=?";
			result = db.update(initSql(sql, new Object[]{title,pic,content,nologin,
					hx,czxs,quyu,jiage,dth,fwzt,lxr,lxdh,jwd,status,id}));
			System.out.println("====================================="+status);
		}else{
			String sql="insert into t_wdxx(customerId,title,pic,content,zan,insertDate,nologin," +
					"bkId,bh,hx,czxs,quyu,jiage,dth,fwzt,lxr,lxdh,jwd,status) values(?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?)";
			result = db.update(initSql(sql, new Object[]{getCustomer(request).get("id"),title,
					pic,content,0,nologin,bkId,System.currentTimeMillis()+"",hx,czxs,quyu,jiage,dth,fwzt,lxr,lxdh,jwd,status}));
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/wdxxEditDelete")
	@ResponseBody	public Map editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_wdxx where id=?";
		int result = db.update(initSql(sql, new Object[]{id}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/scSave")
	@ResponseBody	public Map scSave(Model model,HttpServletRequest request,Long id,Long bkId) throws Exception {
		String sql="delete from t_sc where customerId=? and wdxxId=?";
		db.update(initSql(sql, new Object[]{getCustomer(request).get("id"),id}));
		 sql="insert into t_sc(wdxxId,customerId,insertDate,bkId) values(?,?,now(),?)";
		int result = db.update(initSql(sql, new Object[]{id,getCustomer(request).get("id"),bkId}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/scList")
	public String edit(Model model, HttpServletRequest request,Long id,String flag,Long bkId)throws Exception {
		String sql="select a.*,(select max(title) from t_wdxx b where b.id=a.wdxxId) title from t_sc a where  customerId=?";
		List<Map> list = db.queryForList(initSql(sql,new Object[]{getCustomer(request).get("id")}));
		model.addAttribute("list", list);
		return "/front/scList";
	}
	
	
	
	@RequestMapping(value = "/wdxxEdit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag,String types)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_wdxx where id=?";
			Map map = db.queryForMap(initSql(sql,new Object[]{id}));
			model.addAttribute("map", map);
		}String sql="";

		return "/front/wdxxEdit";
	}
	
	@RequestMapping(value = "/wdxxShow")
	public String wdxxShow(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_wdxx where id=?";
			Map map = db.queryForMap(initSql(sql,new Object[]{id}));
			model.addAttribute("map", map);
			Map customer = getCustomer(request);
			if(customer!=null&&customer.size()>0){
				sql="insert into t_log(wdxxId,insertDate,customerId) values(?,now(),?)";
				db.update(initSql(sql,new Object[]{id,customer.get("id")}));
			}else{
				sql="insert into t_log(wdxxId,insertDate) values(?,now())";
				db.update(initSql(sql,new Object[]{id}));
			}
		}
		String sql="select a.*,(select max(name) from t_customer b where a.customerId=b.id) customerName from t_pinglun a where wdxxId=? order by id desc";
		List<Map> list = db.queryForList(initSql(sql,new Object[]{id}));
		model.addAttribute("list", list);
		
		
		//其他房屋推荐
		List seachList = (List)request.getSession().getAttribute("seachList");
		if(seachList!=null&&seachList.size()>0){
			if(seachList.size()>4){
				List out = new ArrayList();
				out.add(seachList.get(0));
				out.add(seachList.get(1));
				out.add(seachList.get(2));
				out.add(seachList.get(3));
				seachList = out;
			}
		}
		model.addAttribute("lista", seachList);
		return "/front/wdxxShow";
	}
	
	@RequestMapping(value = "/checkIsLogin")
	@ResponseBody	public Map checkIsLogin(Model model,
			HttpServletRequest request) throws Exception {
		Map customer = getCustomer(request);
		if (customer != null && customer.size() > 0) {
			return renderData(true, "操作成功", null);
		} else {
			return renderData(false, "操作失败", null);
		}
	}
	
	@RequestMapping(value = "/pinglunSave")
	@ResponseBody	public Map pinglunSave(Model model,HttpServletRequest request,Long id,String flag
		,String wdxxId,Integer customerId,String content,String insertDate) throws Exception{
		int result = 0;
		String sql="insert into t_pinglun(wdxxId,customerId,content,insertDate) values(?,?,?,now())";
		result = db.update(initSql(sql, new Object[]{wdxxId,getCustomer(request).get("id"),content}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/zanSave")
	@ResponseBody	public Map zanSave(Model model,HttpServletRequest request,Long id) throws Exception{
		int result = 0;
		String sql="update t_wdxx set zan=zan+1 where id=?";
		result = db.update(initSql(sql, new Object[]{id}));
		
		sql="insert into t_zanlog(wdxxId,insertDate,customerId) values(?,now(),?)";
		db.update(initSql(sql,new Object[]{id,getCustomer(request).get("id")}));
		
		
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	
	///用户的基本功能结束///////////////////////////////////////////////
	
	
	
	@RequestMapping(value = "/lySave")
	@ResponseBody	public Map lySave(Model model,HttpServletRequest request,Long id,String flag
		,String cwName,String zl,String pz,String sex,String ms,String jkzt,String llfw,String hjdz,String cwnl,String status,Integer customerId,String syrxm,String syrsex,String syrsfz,String ly,String jtzz,String jtcy,String syrdh,String jjdz) throws Exception{
		int result = 0;
		Map customer = getCustomer(request);
		String sql="update t_cw set customerId=?, syrxm=?,syrsex=?,syrsfz=?,ly=?,jtzz=?,jtcy=?,syrdh=?,jjdz=?,status='已领养' where id=?";
		result = db.update(initSql(sql, new Object[]{customer.get("id"),syrxm,syrsex,syrsfz,ly,jtzz,jtcy,syrdh,jjdz,id}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/qxly")
	@ResponseBody	public Map qxly(Model model,
			HttpServletRequest request, Long id) throws Exception {
		Map customer = getCustomer(request);
		String sql="update t_cw set status='待领养',customerId=null where id=?";
		db.update(initSql(sql, new Object[]{id}));
		return renderData(true, "操作成功", null);
	}
	
	@RequestMapping(value = "/zhishi")
	public String list(Model model, HttpServletRequest request,String flag,String title)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')

		String sql="select a.* from t_zhishi a where 1=1 ";


		sql+=" order by showDate desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/front/zhishi";
	}
	
	@RequestMapping(value = "/zhishiDetail")
	public String zhishiDetail(Model model, HttpServletRequest request,String flag,String title,Long id)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		System.out.println("id=========1========"+id);
		String sql="select * from t_zhishi where id="+id;
		Map map = db.queryForMap(sql);
		model.addAttribute("map", map);
		
		
		String sql2="select a.* ," +
				"(select max(name) from t_customer b where a.customerId=b.id) name  from t_zhishilist a where zhishiId= "+id;
				sql+=" order by id desc ";
				List list = db.queryForList(sql2);
				request.setAttribute("list", list);
		return "/front/zhishiDetail";
	}
	
	@RequestMapping(value = "/zslistSave")
	@ResponseBody	public Map zslistSave(Model model,HttpServletRequest request,Long id,String flag
		,String zhishiId,Integer customerId,String content,String insertDate) throws Exception{
		int result = 0;
		String sql="insert into t_zhishilist(zhishiId,customerId,content,insertDate) values(?,?,?,now())";
		result = db.update(initSql(sql, new Object[]{zhishiId,getCustomer(request).get("id"),content}));
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	
	
	@RequestMapping(value = "/hd")
	public String hd(Model model, HttpServletRequest request,String flag,String title)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		String sql="select a.* from t_hd a where 1=1 ";
		sql+=" order by showDate desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/front/hd";
	}
	
	@RequestMapping(value = "/hdDetail")
	public String hdDetail(Model model, HttpServletRequest request,String flag,String title,Long id)throws Exception {		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		String sql="select * from t_hd where id="+id;
		Map map = db.queryForMap(sql);
		model.addAttribute("map", map);
		return "/front/hdDetail";
	}

}
