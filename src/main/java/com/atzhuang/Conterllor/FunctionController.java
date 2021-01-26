package com.atzhuang.Conterllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunctionController {
    @RequestMapping("/export")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public  String export()
    {
        return "/views/export";
    }
    @RequestMapping("/import")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public  String import2()
    {
        return "/views/import";
    }
    @RequestMapping("/ajax")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public  String ajax()
    {
        return "/ajax";
    }


    /*
     * 学霸指数的图
     * */
    @RequestMapping("/myfirst")
    public  String myfirst()
    {
        return "/echarts/myfirst.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    /*
     * 计划招生图
     * */
    @RequestMapping("/mysecond")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public  String mysecond()
    {
        return "/echarts/mysecond.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/ProvinceAtlas")  //生源图谱省份分布
    public  String tiaozhuanDemo1()
    {
        return "/echarts/ProvinceAtlas.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/CityAtlas")  //生源图谱城市分布
    public  String tiaozhuanDemo17()
    {
        return "/echarts/StuSourceCityAtlas.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/GoodStudentsByProvince")  //优秀学子生源图谱省份分布
    public  String tiaozhuanDemo18()
    {
        return "/echarts/GoodStudentsByProvince.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/GoodStudentsByCity")  //优秀学子生源图谱城市分布
    public  String tiaozhuanDemo19()
    {
        return "/echarts/GoodStudentsByCity.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/PovertyByProvince")  //贫困学子生源图谱省份分布
    public  String tiaozhuanDemo20()
    {
        return "/echarts/PovertyByProvince.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/PovertyByCity")  //贫困学子生源图谱城市分布
    public  String tiaozhuanDemo21()
    {
        return "/echarts/PovertyByCity.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/SexProvince")  //男女比例按省份统计
    public  String tiaozhuanDemo2()
    {
        return "/echarts/nannvbili.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/SexCity")  //男女比例按城市统计
    public  String tiaozhuanDemo3()
    {
        return "/echarts/nannvbiliBycity.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/SexCollege")  //男女比例按学院统计
    public  String tiaozhuanDemo4()
    {
        return "/echarts/nannvbiliByCollege.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/CountStudentByCollegeandGrade")  //各学院每年级的学生数量
    public  String tiaozhuanDemo5()
    {
        return "/echarts/CountStudentByCollegeandGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/MaxCostByGrade")  //最大消费统计
    public  String tiaozhuanDemo6()
    {
        return "/echarts/MaxCostByGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/MinCostByGrade")  //最小消费统计
    public  String tiaozhuanDemo7()
    {
        return "/echarts/MinCostByGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/CostBySex")  //消费总值男女比例饼图
    public  String tiaozhuanDemo8()
    {
        return "/echarts/CostBysex.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/AvgCostByGrade")  //平均消费统计
    public  String tiaozhuanDemo9()
    {
        return "/echarts/AvgCostByGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/CostByProvince")  //消费分布按省份统计
    public  String tiaozhuanDemo10()
    {
        return "/echarts/CostByProvince.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/CostByCity")  //消费分布按城市统计
    public  String tiaozhuanDemo11()
    {
        return "/echarts/CostByCIty.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/JobByGrade")  //2016级就业分布
    public  String tiaozhuanDemo12()
    {
        return "/echarts/JobByGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/JobByCity")  //2016级就业城市分布
    public  String tiaozhuanDemo16()
    {
        return "/echarts/JobByCity.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/NatureByGrade")  //岗位性质按年级分类
    public  String tiaozhuanDemo13()
    {
        return "/echarts/NatureByGrade.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/NatureByCollege")  //岗位性质按学院分类
    public  String tiaozhuanDemo14()
    {
        return "/echarts/NatureByCollege.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/NatureByMajor")  //岗位性质按专业分类
    public  String tiaozhuanDemo15()
    {
        return "/echarts/NatureByMajor.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/JobByCityandCollege")//就业城市分布按学院统计
    public  String tiaozhuanDemo22()
    {
        return "/echarts/JobByCityandCollege.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }
    @RequestMapping("/JobByCityandMajor")  //就业城市分布按专业统计
    public  String tiaozhuanDemo23()
    {
        return "/echarts/JobByCityandMajor.html";//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }

}
