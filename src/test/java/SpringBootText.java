import com.atzhuang.RunProject;
import com.atzhuang.Service.Impl.userServiceimpl;
import com.atzhuang.bean.databean.students_grade;
import com.atzhuang.datadao.*;
import com.atzhuang.bean.databean.person;
import com.atzhuang.util.ExcelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunProject.class)
public class SpringBootText {

    @Autowired
    userServiceimpl uer=new userServiceimpl();
    @Autowired
    StudentBasicRepos studentBasicRepos;
    @Autowired
    StudentsConsumptionRepos studentsConsumptionRepos;
    @Autowired
    StudentEmploymentRepos studentEmploymentRepos;
    @Autowired
    StudentGradeRepos studentGradeRepos;

    @Autowired
    UserRepository userRepository;
    @Test
    public void contextLoads() throws Exception{
        person person=userRepository.findByXuehao("1414");
        System.out.println(person);
    }

    @Test
    public void test() throws Exception {
        List all=studentGradeRepos.findAll();
        ExcelUtil.exportExcel("studentgrade.xls",all,"sheet1");
        List<students_grade> list = ExcelUtil.importExcel("studentgrade.xls", students_grade.class);
        Iterator<students_grade> it=list.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next().toString());
        }
    }
}
