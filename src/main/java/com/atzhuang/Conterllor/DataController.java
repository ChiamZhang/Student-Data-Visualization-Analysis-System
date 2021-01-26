package com.atzhuang.Conterllor;

import com.atzhuang.bean.createbean.excellent;
import com.atzhuang.bean.databean.recruit_students;
import com.atzhuang.bean.responseBody.*;
import com.atzhuang.datadao.*;
import net.sf.ehcache.search.aggregator.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class DataController {
    @Autowired
    private RecruitRepository recruitRepository;
    //自动注部分
    @Autowired
    StudentEmploymentRepos studentEmploymentRepos;
    @Autowired
    StudentBasicRepos studentBasicRepos;
    @Autowired
    StudentGradeRepos studentGradeRepos;
    @Autowired
    StudentsConsumptionRepos studentsConsumptionRepos;


    //功能部分

    /**
     * 各省及对应学生人数分年级
     * 年级 省份 数量
     *
     * @return
     */
    @RequestMapping("/mysecondresult")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    @ResponseBody
    public List<recruit_students> mysecondresult()
    {
        List<recruit_students> all = recruitRepository.findAll();
        System.out.println(all);
        return all;//访问路径 从temlates目录开始  比如Tem下有个User文件夹，文件里有个demo.html。那么该目录下的Html路径位  "/User/demo"
    }


    @RequestMapping("ExcellentStudentList")
    @ResponseBody
    public List<List> GetExcellentStudentList(){
        List<List> all=studentGradeRepos.GetExcellentStudent();
        Iterator<List> it=all.iterator();
        for(int i=0;i<all.size();i++)
        {
            List list=it.next();
            list.add((double)list.get(1)-0.01*i);
        }
        return all;
    }
    @RequestMapping("ExcellentStudent")
    @ResponseBody
    public List<excellent> GetExcellentStudent(){
        List<List> all=studentGradeRepos.GetExcellentStudent();
        List<excellent> student=new ArrayList<>();
        for(int i=0;i<all.size();i++){
            List one=all.get(i);
            //Integer number, double grade, String name, String sex, String college, String stu_major, String phone
            excellent two=new excellent(Integer.parseInt(one.get(0).toString()),Double.parseDouble(one.get(1).toString()),one.get(2).toString(),one.get(3).toString(),one.get(4).toString(),one.get(5).toString(),one.get(6).toString());
            student.add(two);
        }
        return student;
    }
//功能部分

    /**
     * 各省及对应学生人数分年级
     * 年级 省份 数量
     *
     * @return
     */
    @RequestMapping("/countByProvinceAndStu_grade")
    @ResponseBody
    public List<ProvinceGradeCount> countByProvinceAndStu_grade() {
        List<List> sb = studentBasicRepos.countByProvinceAndStu_grade();
        List<ProvinceGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各市及对应学生人数分年级
     * 年级 城市 数量
     *
     * @return
     */
    @RequestMapping("/countByCityAndStu_grade")
    @ResponseBody
    public List<CityGradeCount> countByCityAndStu_grade() {
        List<List> sb = studentBasicRepos.countByCityAndStu_grade();
        List<CityGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各省及对应学生人数不分年级
     * 省份 数量
     *
     * @return
     */
    @RequestMapping("/countByProvince")
    @ResponseBody
    public List<ProvinceCount> countByProvince() {
        List<List> sb = studentBasicRepos.countByProvince();
        List<ProvinceCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }

    /**
     * 各市及对应学生人数不分年级
     * 城市 数量
     *
     * @return
     */
    @RequestMapping("/countByCity")
    @ResponseBody
    public List<CityCount> countByCity() {
        List<List> sb = studentBasicRepos.countByCity();
        List<CityCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }

    /**
     * 各省优秀学生人数不分年级
     * 省份 数量
     *
     * @return
     */
    @RequestMapping("/findGoodStuByPro")
    @ResponseBody
    public List<ProvinceCount> findGoodStuByPro() {
        List<List> sb = studentBasicRepos.findGoodStuByPro();
        List<ProvinceCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }

    /**
     * 各市优秀学生人数不分年级
     * 城市 数量
     *
     * @return
     */
    @RequestMapping("/findGoodStuByCity")
    @ResponseBody
    public List<CityCount> findGoodStuByCity() {
        List<List> sb = studentBasicRepos.findGoodStuByCity();
        List<CityCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }


    /**
     * 各市优秀学生人数分年级
     * 年级 城市 数量
     *
     * @return
     */
    @RequestMapping("/findGoodStuByCityAndGrade")
    @ResponseBody
    public List<CityGradeCount> findGoodStuByCityAndGrade() {
        List<List> sb = studentBasicRepos.findGoodStuByCityAndGrade();
        List<CityGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各省优秀学生人数分年级
     * 年级 省份 数量
     *
     * @return
     */
    @RequestMapping("/findGoodStuByProAndGrade")
    @ResponseBody
    public List<ProvinceGradeCount> findGoodStuByProAndGrade() {
        List<List> sb = studentBasicRepos.findGoodStuByProAndGrade();
        List<ProvinceGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各省优贫困生人数分年级
     * 年级 省份 数量
     *
     * @return
     */
    @RequestMapping("/findIspovertyByProvinceAndGrade")
    @ResponseBody
    public List<ProvinceGradeCount> findIspovertyByProvinceAndGrade() {
        List<List> sb = studentBasicRepos.findIspovertyByProvinceAndGrade();
        List<ProvinceGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各市贫困学生人数分年级
     * 年级 城市 数量
     *
     * @return
     */
    @RequestMapping("/findIspovertyByCityAndGrade")
    @ResponseBody
    public List<CityGradeCount> findIspovertyByCityAndGrade() {
        List<List> sb = studentBasicRepos.findIspovertyByCityAndGrade();
        List<CityGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各省贫困学生人数不分年级
     * 省份 数量
     *
     * @return
     */
    @RequestMapping("/findIspovertyByProvince")
    @ResponseBody
    public List<ProvinceCount> findIspovertyByProvince() {
        List<List> sb = studentBasicRepos.findIspovertyByProvince();
        List<ProvinceCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new ProvinceCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }

    /**
     * 各市贫困学生人数不分年级
     * 城市 数量
     *
     * @return
     */
    @RequestMapping("/findIspovertyByCity")
    @ResponseBody
    public List<CityCount> findIspovertyByCity() {
        List<List> sb = studentBasicRepos.findIspovertyByCity();
        List<CityCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CityCount((String) ss.get(0), (long) ss.get(1)));
        }
        return ans;
    }


    /**
     * 各学院每年级的学生数量
     * 年级 专业 数量
     *
     * @return
     */
    @RequestMapping("/fiindAllStuByCollegeAndGrade")
    @ResponseBody
    public List<CollegeGradeCount> fiindAllStuByCollegeAndGrade() {
        List<List> sb = studentBasicRepos.fiindAllStuByCollegeAndGrade();
        List<CollegeGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new CollegeGradeCount((String) ss.get(0), (Integer) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各省男女学生数量
     * 省  性别 数量
     *
     * @return
     */
    @RequestMapping("/countSexByProvince")
    @ResponseBody
    public List<SexProvinceCount> countSexByProvince() {
        List<List> sb = studentBasicRepos.countSexByProvince();
        List<SexProvinceCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new SexProvinceCount((String) ss.get(0), (String) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各市男女学生数量
     * 市 性别 数量
     *
     * @return
     */
    @RequestMapping("/countSexByCity")
    @ResponseBody
    public List<SexCityCount> countSexByCity() {
        List<List> sb = studentBasicRepos.countSexByCity();
        List<SexCityCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new SexCityCount((String) ss.get(0), (String) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 各市男女学生数量
     * 学院  性别 数量
     *
     * @return
     */
    @RequestMapping("/countSexByCollege")
    @ResponseBody
    public List<SexCollegeCount> countSexByCollege() {
        List<List> sb = studentBasicRepos.countSexByCollege();
        List<SexCollegeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new SexCollegeCount((String) ss.get(0), (String) ss.get(1), (long) ss.get(2)));
        }
        return ans;
    }

    /**
     * 一卡通各年级每月平均消费
     * 年级 月份  消费
     */

    @RequestMapping("/findAverCost")
    @ResponseBody
    public List<GradeMonthCost> findAverCost() {
        List<List> sb = studentsConsumptionRepos.findAverCost();
        List<GradeMonthCost> ans = new ArrayList<>();
        ///  new GradeMonthCost(1,2,dou)
        for (List ss : sb) {
            ans.add(new GradeMonthCost((Integer) ss.get(0), (Integer) ss.get(2), (Double) ss.get(1)));
        }
        return ans;
    }

    /**
     * 一卡通各年级每月最高消费
     * 年级 月份  消费
     */
    @RequestMapping("/findMaxCost")
    @ResponseBody
    public List<GradeMonthCost> findMaxCost() {
        List<List> sb = studentsConsumptionRepos.findMaxCost();
        List<GradeMonthCost> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new GradeMonthCost((Integer) ss.get(0), (Integer) ss.get(2), (Integer) ss.get(1)));
        }
        return ans;
    }

    /**
     * 一卡通各年级每月最低消费统计
     * 年级 月份  消费
     */
    @RequestMapping("/findMinCost")
    @ResponseBody
    public List<GradeMonthCost> findMinCost() {
        List<List> sb = studentsConsumptionRepos.findMinCost();
        List<GradeMonthCost> ans = new ArrayList<>();
        for (List ss : sb) {
            ans.add(new GradeMonthCost((Integer) ss.get(0), (Integer) ss.get(2), (Integer) ss.get(1)));
        }
        return ans;
    }

    /**
     * 一卡通性别及对应消费总量
     * 性别 消费总和
     */
    @RequestMapping("/findSexCost")
    @ResponseBody
    public List<SexCost> findSexCost() {
        List<List> sb = studentsConsumptionRepos.findSexCost();
        List<SexCost> ans = new ArrayList<>();
        for (List ss : sb) {
            BigDecimal a = (BigDecimal) ss.get(1);
            long b = a.longValue();
            ans.add(new SexCost((String) ss.get(0), b));
        }
        return ans;
    }

    /**
     * 省份及对应消费总量
     * 省份 消费总和
     */
    @RequestMapping("/findProvinceCost")
    @ResponseBody
    public List<ProvinceCost> findProvinceCost() {
        List<List> sb = studentsConsumptionRepos.findProvinceCost();
        List<ProvinceCost> ans = new ArrayList<>();
        for (List ss : sb) {
            //System.out.println(1);
            BigDecimal a = (BigDecimal) ss.get(1);
            //  System.out.println(2);
            long b = a.longValue();
            // System.out.println(3);
            ans.add(new ProvinceCost((String) ss.get(0), b));
        }
        return ans;
    }

    /**
     * 城市及对应消费总量
     * 城市  消费总和
     */
    @RequestMapping("/findCityCost")
    @ResponseBody
    public List<CityCost> findCityCost() {
        List<List> sb = studentsConsumptionRepos.findCityCost();
        List<CityCost> ans = new ArrayList<>();
        for (List ss : sb) {
            BigDecimal a = (BigDecimal) ss.get(1);
            long b = a.longValue();
            ans.add(new CityCost((String) ss.get(0), b));
        }
        return ans;
    }

    /**
     * 就业地市及对应人数分年级
     */
    @RequestMapping("/findJobByGrade")
    @ResponseBody
    public List<CityGradeCount> findJobByGrade() {
        List<List> sb = studentEmploymentRepos.findJobByGrade();
        List<CityGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger;
            bigInteger = (BigInteger) ss.get(2);
            Long l = bigInteger.longValue();
            bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new CityGradeCount((String) ss.get(0), l, l2));
        }
        return ans;
    }

    /**
     * 就业地市及对应人数分学院
     */
    @RequestMapping("/findJobByMajor")
    @ResponseBody
    public List<CityMajorCount> findJobByMajor() {
        List<List> sb = studentEmploymentRepos.findJobByMajor();
        List<CityMajorCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new CityMajorCount((String) ss.get(2), (String) ss.get(0), l2));
        }
        return ans;
    }

    /**
     * 就业地市及对应人数分专业
     */
    @RequestMapping("/findJobByCollege")
    @ResponseBody
    public List<CityCollegeCount> findJobByCollege() {
        List<List> sb = studentEmploymentRepos.findJobByCollege();
        List<CityCollegeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new CityCollegeCount((String) ss.get(0), (String) ss.get(2), l2));
        }
        return ans;
    }

    /**
     * 岗位性质及对应人数分年级
     */
    @RequestMapping("/findNatureByGrade")
    @ResponseBody
    public List<NatureGradeCount> findNatureByGrade() {
        List<List> sb = studentEmploymentRepos.findNatureByGrade();
        List<NatureGradeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger;
            bigInteger = (BigInteger) ss.get(2);
            Long l = bigInteger.longValue();
            bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new NatureGradeCount(l, (String) ss.get(0), l2));
        }
        return ans;
    }

    /**
     * 岗位性质及对应人数分学院
     */
    @RequestMapping("/findNatureByCollege")
    @ResponseBody
    public List<NatureCollegeCount> findNatureByCollege() {
        List<List> sb = studentEmploymentRepos.findNatureByCollege();
        List<NatureCollegeCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new NatureCollegeCount((String) ss.get(2), (String) ss.get(0), l2));
        }
        return ans;
    }

    /**
     * 岗位性质及对应人数分专业
     */

    @RequestMapping("/findNatureByMajor")
    @ResponseBody
    public List<NatureMajorCount> findNatureByMajor() {
        List<List> sb = studentEmploymentRepos.findNatureByMajor();
        List<NatureMajorCount> ans = new ArrayList<>();
        for (List ss : sb) {
            BigInteger bigInteger = (BigInteger) ss.get(1);
            Long l2 = bigInteger.longValue();
            ans.add(new NatureMajorCount((String) ss.get(2), (String) ss.get(0), l2));
        }
        return ans;
    }
}
