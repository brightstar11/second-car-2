package com.xh.web.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xh.entity.News;
import com.xh.entity.NewsType;
import com.xh.service.NewsService;
import com.xh.web.model.PageModel;

@Controller
@RequestMapping("WebCar/admin")
public class Admin_CarInformationController {

	@Autowired
	NewsService n;
@RequestMapping("/carInformationLook")
public String carInformationLook(Model model,Integer pageNum){
	
	
	//分页
	 PageModel pm = new PageModel();
		Integer num = 1;
		if(pageNum != null && pageNum >= 0) {
			num = pageNum;
		}
		pm.setPageNum(num);
   PageHelper.startPage(num, 5, true);
   List<News> list=n.news();
	
		
		PageInfo pageinfo = new PageInfo(list);
		int x = pageinfo.getStartRow();
		int y = pageinfo.getEndRow();
		long z = pageinfo.getTotal();
		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
		model.addAttribute("pageInfo",pageinfo);
		model.addAttribute("info",info);

		model.addAttribute("news",list);
	
	return "admin_CarInformationManage";
}
@RequestMapping("/carinformationDelect")
@ResponseBody
public Integer carinformationDelect(Integer id) {
	
	
	return n.delectnews(id);
}
@RequestMapping("/carinformationUpdate")

public String carinformationUpdate(Integer id,Model model) {
	System.out.println(id);
	
	List<News> list=n.Newsdetail(id);
	News news=(News)list.get(0);
	
	model.addAttribute("list",news);
	return "admin_CarInformationUpdate";
}
@RequestMapping("/admin_CarInformationupdate2")
@ResponseBody
public Integer carinformationUpdate2(@RequestParam(name="id",required=false)Integer id,@RequestParam(name="time",required=false)String time,@RequestParam(name="ptwo",required=false)String ptwo,@RequestParam(name="pthree",required=false)String pthree,@RequestParam(name="pfour",required=false)String pfour,@RequestParam(name="pfive",required=false)String pfive,@RequestParam(name="autor",required=false)String autor,@RequestParam(name="pone",required=false)String pone,@RequestParam(name="context",required=false)String context,@RequestParam(name="title",required=false)String title,@RequestParam(name="image1",required=false)MultipartFile file1,@RequestParam(name="image2",required=false)MultipartFile file2,@RequestParam(name="image3",required=false)MultipartFile file3,@RequestParam(name="image4",required=false)MultipartFile file4) {
System.out.println(id);
	News news=new News();
	news.setId(id);
	news.setAutor(autor);
	news.setContext(context);
	news.setTime(time);
	news.setTitle(title);
	news.setPone(pone);
	news.setPtwo(ptwo);
	news.setPthree(pthree);
	news.setPfour(pfour);
	news.setPfive(pfive);
	String path=null;
	String path1=null;
	String path2=null;
	String path3=null;
	if (file1!=null) {  
        try {  
            // 文件保存路径  
        	path = "\\images\\upload\\".concat(file1.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file1.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
      news.setImage1(path);
    } 
	if (file2!=null) {  
        try {  
            // 文件保存路径  
        	path1 = "\\images\\upload\\".concat(file2.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path1);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file2.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
       news.setImage2(path1);
    } 
	if (file3!=null) {  
        try {  
            // 文件保存路径  
        	path2 = "\\images\\upload\\".concat(file3.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path2);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file3.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        news.setImage3(path2);
    } 
	if (file4!=null) {  
        try {  
            // 文件保存路径  
        	path3 = "\\images\\upload\\".concat(file4.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path3);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file4.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        news.setImage4(path3);
    } 
  
	return n.updateNews(news);
}
@RequestMapping("carInformationAdd")
public String carInformationAdd(Model model){
List<NewsType> list=n.newstypes();	
model.addAttribute("list",list);
return "admin_CarInformationAdd";
}
@RequestMapping("carInformationAdd2")
@ResponseBody
public Integer carInformationAdd2(@RequestParam(name="newsytpe",required=false)String newsytpe,@RequestParam(name="time",required=false)String time,@RequestParam(name="ptwo",required=false)String ptwo,@RequestParam(name="pthree",required=false)String pthree,@RequestParam(name="pfour",required=false)String pfour,@RequestParam(name="pfive",required=false)String pfive,@RequestParam(name="autor",required=false)String autor,@RequestParam(name="pone",required=false)String pone,@RequestParam(name="context",required=false)String context,@RequestParam(name="title",required=false)String title,@RequestParam(name="image1",required=false)MultipartFile file1,@RequestParam(name="image2",required=false)MultipartFile file2,@RequestParam(name="image3",required=false)MultipartFile file3,@RequestParam(name="image4",required=false)MultipartFile file4){
	News news=new News();
	
	news.setAutor(autor);
	news.setContext(context);
	news.setTime(time);
	news.setTitle(title);
	news.setPone(pone);
	news.setPtwo(ptwo);
	news.setPthree(pthree);
	news.setPfour(pfour);
	news.setPfive(pfive);
	news.setNewsytpe(newsytpe);
	String path=null;
	String path1=null;
	String path2=null;
	String path3=null;
	if (file1!=null) {  
        try {  
            // 文件保存路径  
        	path = "\\images\\upload\\".concat(file1.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file1.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
      news.setImage1(path);
    } 
	if (file2!=null) {  
        try {  
            // 文件保存路径  
        	path1 = "\\images\\upload\\".concat(file2.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path1);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file2.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
       news.setImage2(path1);
    } 
	if (file3!=null) {  
        try {  
            // 文件保存路径  
        	path2 = "\\images\\upload\\".concat(file3.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path2);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file3.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        news.setImage3(path2);
    } 
	if (file4!=null) {  
        try {  
            // 文件保存路径  
        	path3 = "\\images\\upload\\".concat(file4.getOriginalFilename());//数据库存path
            String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path3);  
            System.out.println(filePath);
            // 转存文件  
            File desFile = new File(filePath);
            if(!desFile.getParentFile().exists()){
                desFile.getParentFile().mkdirs();
            }
            file4.transferTo(desFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        news.setImage4(path3);
    } 
  
	return n.insertNews(news);
	
}
//@RequestMapping("admin_CarInformationLook2")
//public String admin_CarInformationLook2(Integer id,Model model,Integer pageNum){
//	
//	 PageModel pm = new PageModel();
//		Integer num = 1;
//		if(pageNum != null && pageNum >= 0) {
//			num = pageNum;
//		}
//		pm.setPageNum(num);
//PageHelper.startPage(num, 10, true);
//List<Car_Information> list=car_InformationService.aboutcarinformationSee(id);
//	
//		
//		PageInfo pageinfo = new PageInfo(list);
//		int x = pageinfo.getStartRow();
//		int y = pageinfo.getEndRow();
//		long z = pageinfo.getTotal();
//		String info = "显示"+(x)+"到"+(y)+"共"+z+"条";
//		model.addAttribute("pageInfo",pageinfo);
//		model.addAttribute("info",info);
//	model.addAttribute("list",list);
//	return "admin_CarInformationManage";
//}
//@RequestMapping("admin_CarInformationAdd2")
//@ResponseBody
//public Integer admin_CarInformationAdd2(String content,String title) {
//	Car_Information car_Information=new Car_Information();
//	car_Information.setContent(content);
//	car_Information.setTitle(title);
//	
//	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//	String time=df.format(new Date());
//	car_Information.setTime(time);
//	
//	
//	return car_InformationService.carinformationAdd(car_Information);
//}
}
