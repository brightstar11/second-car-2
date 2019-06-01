package com.xh.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xh.common.Page;
import com.xh.common.Secondwork;
import com.xh.entity.CarBirth;
import com.xh.entity.CarBrands;
import com.xh.entity.CarColor;
import com.xh.entity.CarMileAge;
import com.xh.entity.CarPmethod;
import com.xh.entity.CarPop;
import com.xh.entity.CarPower;
import com.xh.entity.Carlevel;
import com.xh.service.CarService;
import com.xh.web.model.CarModel;

@Controller
@RequestMapping("WebCar/userInfo")
public class UserInfo_CarController {
	private static String REGEX_CHINESE = "[\u4e00-\u9fa5]";
	@Autowired
	CarService car;
	//@Autowired
	

	// 排序升序
	public List<CarModel> sortup(List<CarModel> list, String paixubiaoshi, CarModel carModel) {
		// sort-one 默认排序
		// sort-two 价格升序
		// sort-three 价格降
		
		if (paixubiaoshi.equals("sort-two")) {
			// 排序升序
			Collections.sort(list, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					CarModel stu1 = (CarModel) o1;
					CarModel stu2 = (CarModel) o2;
					if (Double.parseDouble(stu1.getCarprice()) > Double.parseDouble(stu2.getCarprice())) {
						return 1;
					} else {
						return -1;
					}
				}
			});

			System.out.println("/////////////排序之后///////////////");
			List<CarModel> list2 = new ArrayList<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				CarModel st = (CarModel) list.get(i);
				list2.add(st);
			}
	
			return list2;
		} else if (paixubiaoshi.equals("sort-three")) {
			// 排序降序
			Collections.sort(list, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					CarModel stu1 = (CarModel) o1;
					CarModel stu2 = (CarModel) o2;
					

					if (Double.parseDouble(stu1.getCarprice()) > Double.parseDouble(stu2.getCarprice())) {
						return 1;
					} else {
						return -1;
					}
				}
			});

			System.out.println("/////////////排序之后///////////////");
			List<CarModel> list2 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				CarModel st = (CarModel) list.get(i);
				list2.add(st);

			}
			
			return list2;
		} else if (paixubiaoshi.equals("sort-four")) {

			// List<CarModel> list2= car.CarselectAlldongCarMileages(carModel);

			Collections.sort(list, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					CarModel stu1 = (CarModel) o1;
					CarModel stu2 = (CarModel) o2;
					if (Double.parseDouble((stu1.getCarmileages().substring(0,
							(stu1.getCarmileages()).length() - 3))) > Double.parseDouble(
									((stu2.getCarmileages().substring(0, (stu2.getCarmileages()).length() - 3))))) {
						return 1;
					} else {
						return -1;
					}
				}
			});

			System.out.println("/////////////排序之后///////////////");
			List<CarModel> list3 = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				CarModel st = (CarModel) list.get(i);
				list3.add(st);

			}
			//System.out.println(list3.size());
			return list3;

		} else if (paixubiaoshi.equals("sort-five")) {
			// 排序升序
			Collections.sort(list, new Comparator() {
				@Override
				public int compare(Object o1, Object o2) {
					CarModel stu1 = (CarModel) o1;
					CarModel stu2 = (CarModel) o2;
					return stu1.getCarlntime().compareTo(stu2.getCarlntime());
				}
			});

			System.out.println("/////////////排序之后///////////////");
			List<CarModel> list2 = new ArrayList<>();
			for (int i = list.size() - 1; i >= 0; i--) {
				CarModel st = (CarModel) list.get(i);
				list2.add(st);

			}
			return list2;
		} else {
			return list;
		}

	}

	@RequestMapping("/buyCar")
	public String buyCar(Integer pageNum, Model model) {

		List<CarModel> list = car.CarselectAll();

		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		model.addAttribute("listAll", list);
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		return "user_buyCar";

	}

	@RequestMapping("/newbuyCar")
	public String newbuyCar(Model model) {
		List<CarModel> list = car.CarselectAll();
		model.addAttribute("listAll", list);

		return "user_newbuyCar";

	}

//买车初始化
	@RequestMapping("/buyCar1")
	@ResponseBody
	public List<CarModel> buyCar1() {

		List<CarModel> list = car.CarselectAll();

		return list;

	}

//搜索框搜索
//@RequestMapping("/User_BuyCarSearch124")
//@ResponseBody
	public PageInfo<CarModel> buyCarjinque(String search, Integer pageNo) {
		Secondwork secondwork = new Secondwork();
		String[] strings = new String[100];
		strings = secondwork.fenci(search);
		CarModel carModel = new CarModel();
		carModel.setBrandname("不限");
		carModel.setLevelname("不限");
		carModel.setCarcolor("不限");
		carModel.setCarpower("不限");
		carModel.setCarpop("不限");
		carModel.setCarmileage("不限");
		carModel.setCarpmethod("不限");
		carModel.setCarprice("不限");
		List<CarModel> list2 = car.CarselectAlldong(carModel);
		List<CarBrands> carBrands = car.CarbrandsAll();
		List<CarBirth> carBirths = car.Carbirth();
		List<String> carname = car.Carcarname();
		List<String> cartype = car.Carcartype();
		List<String> drivetype = car.drivetype();
		for (String string : drivetype) {
			System.out.println(string);
		}
		for (int i = 0; i < strings.length; i++) {
			String s = strings[i];
			if (s != null && s != "") {
				for (int j = 0; j < carBrands.size(); j++) {
					if (carBrands.get(j).getBrandname().equals(s)) {
						carModel.setBrandname(s);

					}
				}
				for (int r = 0; r < carBirths.size(); r++) {
					if ((carBirths.get(r).getCarbirth() + "").equals(s)) {
						carModel.setCarbirth(s);

					}
				}
				for (int w = 0; w < carname.size(); w++) {
					if (carname.get(w).equals(s)) {
						carModel.setCarname(s);

					}
				}
				for (int e = 0; e < cartype.size(); e++) {
					if (cartype.get(e).equals(s)) {
						carModel.setCartype(s);

					}
				}
				for (int t = 0; t < drivetype.size(); t++) {
					if (drivetype.get(t).equals(s)) {
						carModel.setDrivetype(s);
					}
				}
			}
		}
		List<CarModel> list3 = car.CarselectAlldongsearch(carModel);
		//System.out.println(carModel + "装入后的");
		if (list3.size() == list2.size()) {
			//System.out.println("在這裏");
			return null;
		} else {
			PageHelper.startPage(pageNo, 10);
			List<CarModel> list = car.CarselectAlldongsearch(carModel);
			for (CarModel carModel2 : list) {
				System.out.println(carModel2.toString());
			}
			PageInfo info = new PageInfo(list, 10);

			return info;
		}
	}

	// 根据车的关键字段，进行模糊搜索
	@RequestMapping("/User_BuyCarSearch123")
	@ResponseBody
	public Page<CarModel> BuyCarSearch(@RequestBody Page<CarModel> page) {

		CarModel carModel = page.getObj();// 前端传的实体
		//System.out.println(carModel.getSearch());
		if (carModel.getSearch() != "" && carModel.getSearch() != null) {
			System.out.println("进入搜索不为空");
			PageInfo<CarModel> list = buyCarjinque(carModel.getSearch(), page.getPageNo());

			Page<CarModel> page2 = new Page<>();
			if (list != null) {
				page2.setPagetotal(list.getPages());// 總頁數
				page2.setDataList(list.getList());// 數據
				page2.setTotal((int) list.getTotal());
				return page2;
			} else {
				return page2;
			}
		} else {

			Page<CarModel> result = new Page<>();
			if (carModel.getCarprice().equals("不限")) {
			} else {
				// 去除中文
				String str = carModel.getCarprice();
				Pattern pat = Pattern.compile(REGEX_CHINESE);
				Matcher mat = pat.matcher(str);

				String str2 = mat.replaceAll("");

				if (str2.contains("-")) {
					int index = str2.indexOf("-");
					String smallNumber = str2.substring(0, index);// 截取KEY出现位置前面的字符串
					String bigNumber = str2.substring(index + 1);
					carModel.setCarpriceleft(smallNumber);
					carModel.setCarpriceright(bigNumber);
				} else {
					if (str2.equals("100")) {
						carModel.setCarpriceleft("100");
						carModel.setCarpriceright("1000");
					} else {
						carModel.setCarpriceleft("0");
						carModel.setCarpriceright(str2);
					}

				}
			}

			List<CarModel> list;
			list = car.CarselectAlldong(carModel);
			List<CarModel> list4 = car.CarselectAlldong(carModel);
			if (carModel.getCarpriceleft() != null && carModel.getCarpriceleft() != "") {
				//System.out.println("进入");
				list = new ArrayList<CarModel>();
				for (int i = 0; i < list4.size(); i++) {

//			System.out.println(list4.get(i).getCarprice());
//			System.out.println(carModel.getCarpriceleft());
//			System.out.println(carModel.getCarpriceright());
//			System.out.println(Double.parseDouble(list4.get(i).getCarprice())-Double.parseDouble(carModel.getCarpriceleft())+"大于0");
//			System.out.println(Double.parseDouble(list4.get(i).getCarprice())-Double.parseDouble(carModel.getCarpriceright())+"小于0");
					if (Double.parseDouble(list4.get(i).getCarprice())
							- Double.parseDouble(carModel.getCarpriceleft()) >= 0
							&& Double.parseDouble(list4.get(i).getCarprice())
									- Double.parseDouble(carModel.getCarpriceright()) <= 0) {
						CarModel carModel2 = list4.get(i);
						// System.out.println(carModel2.toString());
						list.add(carModel2);
					}
				}
			}
			// 对查出的数据进行排序
			String paixubiaoshi = carModel.getPaixubiaoshi();
			//System.out.println(paixubiaoshi + "排序标识");
			if (paixubiaoshi != null && paixubiaoshi != "") {
				List<CarModel> list2 = sortup(list, paixubiaoshi, carModel);
				//System.out.println(list2.size());
				List<CarModel> list3 = new ArrayList<CarModel>();
				result.setTotal(list2.size());// 总数
				Integer pages = page.getPageNo();// 获取当前页

				Integer pageSize = page.getPageSise();// 获取每页显示数量
				int Allpage = (list2.size() / pageSize);// 当前查询的总页数
				result.setPagetotal(Allpage);
				if (list2.size() % pageSize != 0) {
					Allpage = Allpage + 1;

				}
				result.setPagetotal(Allpage);
				if (Allpage < pages) {
					page.setPageNo(pages);
					return result;
				} else if (Allpage - 1 >= pages) {
					for (int k = 0; k < pageSize; k++) {
						list3.add(list2.get(k + (pages - 1) * pageSize));

					}

					result.setDataList(list3);
					page.setPageNo(pages);
					return result;
				} else if (Allpage >= pages && pages >= (Allpage - 1)) {
					int num = list2.size() % pageSize;
					if (num == 0) {
						for (int k = 0; k < pageSize; k++) {
							list3.add(list2.get(k + (pages - 1) * pageSize));

						}
						result.setDataList(list3);
						page.setPageNo(pages);
						return result;
					} else {
						for (int k = 0; k < num; k++) {
							list3.add(list2.get(k + (pages - 1) * pageSize));

						}
						result.setDataList(list3);
						page.setPageNo(pages);
						return result;
					}
				}

				page.setPageNo(pages);
				return result;

			}
			System.out.println(list.size());
			List<CarModel> list2 = new ArrayList<CarModel>();
			result.setTotal(list.size());// 总数
			Integer pages = page.getPageNo();// 获取当前页
			Integer pageSize = page.getPageSise();// 获取每页显示数量
			int Allpage = (list.size() / pageSize);// 当前查询的总页数
			result.setPagetotal(Allpage);
			if (list.size() % pageSize != 0) {

				Allpage = Allpage + 1;

				result.setPagetotal(Allpage);
			}
			System.out.println(list.size());
			System.out.println(Allpage);
			System.out.println(pages);
			System.out.println(pageSize);
			System.out.println("--------------------");
			System.out.println(page.getPageNo() + "aaaa");
			System.out.println("--------------------");
			if (Allpage < pages) {
				page.setPageNo(pages);
				return result;
			} else if (Allpage - 1 >= pages) {
				for (int k = 0; k < pageSize; k++) {
					list2.add(list.get(k + (pages - 1) * pageSize));

				}

				result.setDataList(list2);
				page.setPageNo(pages);
				return result;
			} else if (Allpage >= pages && pages >= (Allpage - 1)) {
				int num = list.size() % pageSize;
				if (num == 0) {
					for (int k = 0; k < pageSize; k++) {
						list2.add(list.get(k + (pages - 1) * pageSize));

					}
					result.setDataList(list2);
					page.setPageNo(pages);
					return result;
				} else {
					for (int k = 0; k < num; k++) {
						list2.add(list.get(k + (pages - 1) * pageSize));

					}
					result.setDataList(list2);
					page.setPageNo(pages);
					return result;
				}
			}

			page.setPageNo(pages);
			return result;

		}

	}

	@RequestMapping("/User_BuyCarSearch")

	public String BuyCarSearch(String brandname, Model model) {
		List<CarModel> list = car.BuyCarSearch(brandname);
		model.addAttribute("listAll", list);
		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		model.addAttribute("brandname", brandname);
		return "user_buyCar";

	}

//根据车的价格，进行模糊搜索 
	@RequestMapping("/User_BuyCarSearch2")
	public String BuyCarSearch2(Integer pageNum, Integer carprice1, Integer carprice2, Model model) {
		String string = carprice1 + "-" + carprice2 + "万";
		System.out.println(string);

		String queyrString = "&carprice1=" + carprice1 + "&carprice2=" + carprice2;

		// 先所有搜索，然后进行排序
		List<CarModel> list = car.CarselectAll();
		List<CarModel> list111 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			String Carprice = list.get(i).getCarprice();
			if (Carprice != null || Carprice != "") {
				Double double1 = Double.valueOf(Carprice);
				System.out.println(double1 + "double1");
				if (double1 - carprice1 >= 0 && double1 - carprice2 <= 0) {
					System.out.println(double1 - carprice1);
					System.out.println(double1 - carprice2);
					System.out.println(list.get(i).getCarprice() + "double2");
					list111.add(list.get(i));
				}
			}
		}

		model.addAttribute("queyrString", queyrString);

		model.addAttribute("listAll", list111);
		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		model.addAttribute("carprice", carprice1 + "-" + carprice2 + "万");

		return "user_buyCar";

	}
//根据车的类型，进行模糊搜索

	@RequestMapping("/User_BuyCarSearch3")

	public String BuyCarSearch3(String levelname, Model model) {
		List<CarModel> list = car.BuyCarSearch3(levelname);
		model.addAttribute("listAll", list);
		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		model.addAttribute("levelname", levelname);
		return "user_buyCar";

	}

//根据车的品牌，进行模糊搜索 
	@RequestMapping("/User_BuyCarSearch4")

	public String BuyCarSearch4(String search, Model model) {
		// List<CarModel> list=car.BuyCarSearch(brandname);
		// model.addAttribute("listAll",list);
		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		model.addAttribute("search", search);
		return "user_buyCar";
	}

//卖车主页
	@RequestMapping("/SaleCar")
	public String salecar(Model model) {
		List<CarBrands> list2 = car.CarbrandsAll();
		List<Carlevel> list3 = car.CarLevelAll();
		List<CarMileAge> list4 = car.CarmileageAll();
		List<CarBrands> list5 = car.CarbrandsAll0_10();
		List<String> list6 = car.CarlntimeAllYear();
		List<String> list11 = car.CarlntimeAllMonth();
		List<CarColor> list7 = car.CarcolorAll();
		List<CarPop> list8 = car.CarpopAll();
		List<CarPower> list9 = car.CarPowerAll();
		List<CarPmethod> list10 = car.CarPmethodAll();
		List<CarBirth> list12 = car.Carbirth();
		List<String> list13 = car.Carnono();
		model.addAttribute("CarbrandsAll", list2);
		model.addAttribute("listlevel", list3);
		model.addAttribute("carmileageAll", list4);
		model.addAttribute("CarbrandsAll0_10", list5);
		model.addAttribute("CarlntimeAllYear", list6);
		model.addAttribute("CarlntimeAllMonth", list11);
		model.addAttribute("CarColorAll", list7);
		model.addAttribute("CarPopAll", list8);
		model.addAttribute("CarPowerAll", list9);
		model.addAttribute("CarPmethodAll", list10);
		model.addAttribute("CarBirth", list12);
		model.addAttribute("CarNono", list13);
		return "user_saleCar";
	}

//存车信息
	@RequestMapping("/PreserveCar")
	@ResponseBody
	public Integer PreserveCar(@RequestParam(name = "carImage", required = false) MultipartFile[] file,
			@RequestParam(name = "username", required = false) String username, CarModel carModel) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < file.length; i++) {
			String path = null;
			if (!file[i].isEmpty()) {
				try {
					// 文件保存路径
					path = "\\images\\upload\\".concat(file[i].getOriginalFilename());// 数据库存path
					String filePath = "D:\\Eclipse 22222\\Second-WebCar\\src\\main\\resources\\static".concat(path);
					System.out.println(filePath);
					// 转存文件
					File desFile = new File(filePath);
					if (!desFile.getParentFile().exists()) {
						desFile.getParentFile().mkdirs();
					}
					file[i].transferTo(desFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			list.add(path);
		}
		System.out.println(list.size());
		
	if(list.size()==1) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone("(null)");
		carModel.setCaricontwo("(null)");
		carModel.setCariconthree("(null)");
		carModel.setCariconfour("(null)");
		carModel.setCariconfive("(null)");
		
	}
	if(list.size()==2) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone(list.get(1));
		carModel.setCaricontwo("(null)");
		carModel.setCariconthree("(null)");
		carModel.setCariconfour("(null)");
		carModel.setCariconfive("(null)");
	}
	if(list.size()==3) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone(list.get(1));
		carModel.setCaricontwo(list.get(2));
		carModel.setCariconthree("(null)");
		carModel.setCariconfour("(null)");
		carModel.setCariconfive("(null)");
	}
	if(list.size()==4) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone(list.get(1));
		carModel.setCaricontwo(list.get(2));
		carModel.setCariconthree(list.get(3));
		carModel.setCariconfour("(null)");
		carModel.setCariconfive("(null)");
	}
	if(list.size()==5) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone(list.get(1));
		carModel.setCaricontwo(list.get(2));
		carModel.setCariconthree(list.get(3));
		carModel.setCariconfour(list.get(4));
		carModel.setCariconfive("(null)");
	}
	if(list.size()==6) {
		carModel.setCaricon(list.get(0));
		carModel.setCariconone(list.get(1));
		carModel.setCaricontwo(list.get(2));
		carModel.setCariconthree(list.get(3));
		carModel.setCariconfour(list.get(4));
		carModel.setCariconfive(list.get(5));
	}
		
		System.out.println(carModel.toString());
		
		Integer count = car.insertCar(carModel);// 存车信息
		String carno = carModel.getCarno();
		Integer count2 = car.insertCar_User(carno, username);// 更新汽车用户表
		if (count == 1 && count == count2) {
			return 1;
		} else {
			return 0;
		}
	}

}
