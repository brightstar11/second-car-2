package com.xh.web.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.service.CarEvaluationService;
import com.xh.service.CarService;
import com.xh.service.MailService;
import com.xh.web.model.EvaluationModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class Userinfo_CarEvaluationController {
	@Autowired
	CarService car;
	@Autowired
	CarEvaluationService CarEvaluationService;
	   @Autowired
	   private MailService mailService;
	//跳转，前台展示
 @RequestMapping("/CarEvaluation")
 public String CarEvaluation(Model model) {
	 
	
	 
	 List<EvaluationModel> list2= CarEvaluationService.CarEvaluationcarpassion();
	 List<EvaluationModel> list3=new ArrayList<EvaluationModel>();
	 
	 int index=list2.size();
	if(index>=5) {
		index=5;
	}else {
	 for(int i=0;i<index;i++) {
		 
		 EvaluationModel evaluationModel2=new EvaluationModel();
		 evaluationModel2.setCarpassion(list2.get(i).getCarpassion());
		 evaluationModel2.setCarband(list2.get(i).getCarband());
		 System.out.println(list2.get(i).getCarband());
		 EvaluationModel lis=CarEvaluationService.carbandpriceall(list2.get(i).getCarband());
		 System.out.println(lis.getCarband()+lis.getCarprice());
		 Integer carbandsum1=CarEvaluationService.carbandsum(list2.get(i).getCarband());
		 DecimalFormat df = new DecimalFormat("#.00");
		 if(lis.getCarprice()%carbandsum1==0) {
			 Double price=lis.getCarprice()/carbandsum1;
			 price=Double.valueOf(df.format(price)) ;
			 evaluationModel2.setCarprice(price);
		 }else {
			 
			 
			 Double price=lis.getCarprice()/(carbandsum1*1.00);
			 price=Double.valueOf(df.format(price)) ;
			 evaluationModel2.setCarprice(price);
		 }
		 evaluationModel2.setCount(i+1);
		 list3.add(evaluationModel2);
		 
		 
	 }
	 
	 System.out.println(list3.size());
	 for (EvaluationModel evaluationModel : list3) {
		System.out.println(evaluationModel.getCarband()+evaluationModel.getCarprice());
	}
	 
	}
	
	List<EvaluationModel> list=CarEvaluationService.carbandS();
	List<EvaluationModel> list4=CarEvaluationService.carnameS();
	List<EvaluationModel> list5=CarEvaluationService.carlevelS();
	 model.addAttribute("paihang",list3);
	 model.addAttribute("carbands",list);
	 model.addAttribute("carnames",list4);
	 model.addAttribute("carlevels",list5);
	return "elvauate";
	 
 }
 /*
  * 重置成本法：

1.新车价格（品牌    款式   车型   车名）
2.使用时间       当前时间 -上牌时间      以月为计数0.25%
3.里程                                                     500公里 0.25%
           不足 就4舍五入
  */
 @RequestMapping("/CarEvaluationGet")
 @ResponseBody
 public Integer CarEvaluationGet(EvaluationModel evaluationModel) throws ParseException {
	 double newCarPrice=0;
	 Double CarPrice=CarEvaluationService.CarEvaluationPrice(evaluationModel);
	 Integer Carpassion=evaluationModel.getCarpassion();
	 evaluationModel.setCarpassion((Carpassion+1));
	 CarEvaluationService.UPDATEcarprice(evaluationModel);
	 System.out.println("进入");
	 System.out.println(evaluationModel.toString()); 
	
	 String Carlntime= evaluationModel.getCarlntime();
	 String Carmileages=evaluationModel.getCarmileages();
	 String useremail=evaluationModel.getUseremail();
	 System.out.println(Carmileages+"-----"+useremail);
	 
	 //获取当前时间
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	 String nowtime=df.format(new Date());// new Date()为获取当前系统时间
	 Calendar c = Calendar.getInstance();
     c.setTime(df.parse(nowtime));
     int year1 = c.get(Calendar.YEAR);
     int month1 = c.get(Calendar.MONTH);
      
     c.setTime(df.parse(Carlntime));
     int year2 = c.get(Calendar.YEAR);
     int month2 = c.get(Calendar.MONTH);
      
     int result;//两个时间相差月
     if(year1 == year2) {
         result = month1 - month2;
     } else {
         result = 12*(year1 - year2) + month1 - month2;
     }
            double month=(double)result;
	            
	            if("1000".compareTo(Carmileages)>0) {
	            	Double mileage=Double.valueOf(Carmileages);
	            	double mileages=((mileage*10000)/500);
	            	
	            	if((mileage*10000)%500>250) {
	            		mileages=mileages+1;
	            		newCarPrice=CarPrice-month*0.0025-mileages*0.0025;
	            		 System.out.println(newCarPrice);
	            		 if (newCarPrice!=0) {
	            			 
	            			 mailService.sendMail(useremail,"估价结果","嘻哈估车网，人人都爱的好车网，你的爱车:"+evaluationModel.getCarband()+" "+evaluationModel.getCarname()+" "+evaluationModel.getCarlevel()+"    经过我们仔细的评估后，得出的结果为价值:"+newCarPrice+"元");
	            			 return 1;
	            		}
	            	}else {
	            		newCarPrice=CarPrice-month*0.0025-mileages*0.0025;
	            		 System.out.println(newCarPrice);
	            		 if (newCarPrice!=0) {
	            			 
	            			 mailService.sendMail(useremail,"估价结果","嘻哈估车网，人人都爱的好车网，你的爱车:"+evaluationModel.getCarband()+" "+evaluationModel.getCarname()+" "+evaluationModel.getCarlevel()+"    经过我们仔细的评估后，得出的结果为价值:"+newCarPrice+"元");
	            			 return 1;
	            		}
	            	}
	            }
	            
	 
	
	 
	 return 0;
 }
 
 
}
