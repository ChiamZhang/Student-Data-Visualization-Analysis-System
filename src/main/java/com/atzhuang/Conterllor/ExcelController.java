package com.atzhuang.Conterllor;

import com.atzhuang.bean.databean.*;
import com.atzhuang.datadao.*;
import com.atzhuang.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.File;
import java.util.List;

@Controller
public class ExcelController {
    @Autowired
    RecruitRepository recruitRepository;
    @Autowired
    StudentBasicRepos studentBasicRepos;
    @Autowired
    StudentEmploymentRepos studentEmploymentRepos;
    @Autowired
    StudentGradeRepos studentGradeRepos;
    @Autowired
    StudentsConsumptionRepos studentsConsumptionRepos;
    @Autowired
    UserRepository userRepository;

    @RequestMapping("ExcelImport")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public String ExcelImport(@RequestParam("file") File file,@RequestParam("leixing") String leixing, Model model)  {
        try {
            String dizhi=file.getAbsolutePath();
            System.out.println(dizhi+" "+leixing);
            if(leixing.equals("1"))
            {
                List re = ExcelUtil.importExcel(dizhi, recruit_students.class);
                if(re!=null&&recruitRepository.saveAll(re)!=null)
                {
                    model.addAttribute("msg","导入成功");
                }
                else
                {
                    model.addAttribute("msg","导入失败");
                }
            }
            else if(leixing.equals("2"))
            {
                List re = ExcelUtil.importExcel(dizhi, students_basic.class);
                if(re!=null&&studentBasicRepos.saveAll(re)!=null)
                {
                    model.addAttribute("msg","导入成功");
                }
                else
                {
                    model.addAttribute("msg","导入失败");
                }
            }
            else if(leixing.equals("3"))
            {
                List re = ExcelUtil.importExcel(dizhi, students_employment.class);
                if(re!=null&&studentEmploymentRepos.saveAll(re)!=null)
                {
                    model.addAttribute("msg","导入成功");
                }
                else
                {
                    model.addAttribute("msg","导入失败");
                }
            }
            else if(leixing.equals("4"))
            {
                List re = ExcelUtil.importExcel(dizhi, students_consumption.class);
                if(re!=null&&studentsConsumptionRepos.saveAll(re)!=null)
                {
                    model.addAttribute("msg","导入成功");
                }
                else
                {
                    model.addAttribute("msg","导入失败");
                }
            }
            else
            {
                List re = ExcelUtil.importExcel(dizhi, students_grade.class);
                if(re!=null&&studentGradeRepos.saveAll(re)!=null)
                {
                    model.addAttribute("msg","导入成功");
                }
                else
                {
                    model.addAttribute("msg","导入失败");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg","导入失败");
        }
        return "/views/import";

    }
    @RequestMapping("ExcelExport")  //设置访问路径，在http://localhost:8080 后面加什么能访问，比如示例这个浏览器访问为http://localhost:8080/urldemo
    public String ExcelExport(@RequestParam("leixing") String leixing, Model model, @RequestParam("file") File file)  {

        try
        {
                 String path=file.getAbsolutePath();
            if(leixing.equals("1"))
            {
                List all = recruitRepository.findAll();
                ExcelUtil.exportExcel(path,all,"sheet1");
                model.addAttribute("msg","导出成功");
            }
            else if(leixing.equals("2"))
            {
                List all = studentBasicRepos.findAll();
                ExcelUtil.exportExcel(path,all,"sheet1");
                model.addAttribute("msg","导出成功");
            }
            else if(leixing.equals("3"))
            {
                List all = studentEmploymentRepos.findAll();
                ExcelUtil.exportExcel(path,all,"sheet1");
                model.addAttribute("msg","导出成功");
            }
            else if(leixing.equals("4"))
            {
                List all = studentsConsumptionRepos.findAll();
                ExcelUtil.exportExcel(path,all,"sheet1");
                model.addAttribute("msg","导出成功");
            }
            else
            {
                List all = studentGradeRepos.findAll();
                ExcelUtil.exportExcel(path,all,"sheet1");
                model.addAttribute("msg","导出成功");
            }
        } catch (Exception e) {
            model.addAttribute("msg","导出失败");
            e.printStackTrace();
        }
        return "/views/export";

    }



}
