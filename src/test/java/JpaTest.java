
import com.atzhuang.RunProject;
import com.atzhuang.datadao.StudentBasicRepos;
import com.atzhuang.datadao.StudentsConsumptionRepos;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunProject.class)
public class JpaTest {

    @Autowired
    private StudentBasicRepos studentBasicRepos;

    @Test
    public void countByProvinceAndStu_grade() {
        List<List> sb = studentBasicRepos.countByProvinceAndStu_grade();
        //  int length = sb.size();
        for (List a : sb) {
            System.out.println(a.get(1).getClass());

            System.out.println(a.get(0) + "  / " + a.get(1) + "   /  " + a.get(2));
            //.out.println();

        }
    }

    @Test
    public void countByCityAndStu_grade() {
        List<List> sb = studentBasicRepos.countByCityAndStu_grade();
        //  int length = sb.size();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "   /  " + a.get(2));
            //.out.println();

        }
    }

    @Test
    public void countByCity() {
        List<List> sb = studentBasicRepos.countByCity();
        //  int length = sb.size();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1));
            //.out.println();

        }
    }

    @Test
    public void countByProvince() {
        List<List> sb = studentBasicRepos.countByProvince();
        //  int length = sb.size();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1));
            //.out.println();

        }
    }

    @Test
    public void findstudents_basicBy() {
        List<List> sb = studentBasicRepos.findGoodStuByCity();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1));
        }
    }

    @Test
    public void findGoodStuByCityAndGrade() {
        List<List> sb = studentBasicRepos.findGoodStuByCityAndGrade();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "  / " + a.get(2));
        }
    }

    @Test
    public void fiindAllStuByCollegeAndGrade() {
        List<List> sb = studentBasicRepos.fiindAllStuByCollegeAndGrade();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "  / " + a.get(2));
        }
    }

    @Autowired
    private StudentsConsumptionRepos studentsConsumptionRepos;

    @Test
    public void findAsverCost() {
        List<List> sb = studentsConsumptionRepos.findAverCost();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "  / " + a.get(2));
        }
    }

    @Test
    public void findMaxCost() {
        List<List> sb = studentsConsumptionRepos.findMaxCost();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "  / " + a.get(2));
        }
    }

    @Test
    public void countSexByProvince() {
        List<List> sb = studentBasicRepos.countSexByCity();
        //  int length = sb.size();
        for (List a : sb) {
            System.out.println(a.get(0) + "  / " + a.get(1) + "  / " + a.get(2));
            //.out.println();

        }

    }

    @Test
    public void findAverCost() {
        List<List> sb = studentsConsumptionRepos.findCityCost();

        for (List a : sb) {
            BigDecimal    s=(BigDecimal)a.get(1);
            long b = s.longValue();
            System.out.println(b);
        }

    }


}