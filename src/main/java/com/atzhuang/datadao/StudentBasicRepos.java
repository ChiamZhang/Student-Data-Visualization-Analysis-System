package com.atzhuang.datadao;

import com.atzhuang.bean.databean.students_basic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentBasicRepos extends JpaRepository<students_basic, Integer> {
    public students_basic findByNumber(Integer number);

    /*
     * 查询
     * 驼峰命名法
     * findBy+属性名(首字母大写）+查询条件（首字母大写）
     * */
    List<students_basic> findByNameLike(String name);

    List<students_basic> findBySexAndCollege(String sex, String college);

    @Query("select province,stu_grade,count(province) from students_basic  group by province,stu_grade")
    List<List> countByProvinceAndStu_grade();

    @Query("select city,stu_grade,count(city) from students_basic  group by city,stu_grade")
    List<List> countByCityAndStu_grade();

    @Query("select province,count(province) from students_basic  group by province")
    List<List> countByProvince();

    @Query("select city ,count(city) from students_basic  group by city")
    List<List> countByCity();

    @Query("select province ,count(province) from students_basic WHERE number in (select number from students_grade GROUP BY  number HAVING  AVG(grade)>4) GROUP BY  province   ")
    List<List> findGoodStuByPro();

    @Query("select city ,count(city) from students_basic WHERE number in (select number from students_grade GROUP BY  number HAVING  AVG(grade)>4) GROUP BY  city   ")
    List<List> findGoodStuByCity();

    @Query("select province ,stu_grade,count(province) from students_basic WHERE number in (select number from students_grade GROUP BY  number HAVING  AVG(grade)>4) GROUP BY  province,stu_grade   ")
    List<List> findGoodStuByProAndGrade();

    @Query("select city ,stu_grade,count(province) from students_basic WHERE number in (select number from students_grade GROUP BY  number HAVING  AVG(grade)>4) GROUP BY  city,stu_grade   ")
    List<List> findGoodStuByCityAndGrade();

    @Query("select province,count(province) from students_basic WHERE ispoverty='是' group by province")
    List<List> findIspovertyByProvince();

    @Query("select city,count(city) from students_basic WHERE ispoverty='是' group by city,stu_grade ")
    List<List> findIspovertyByCity();

    @Query("select province,stu_grade,count(province) from students_basic WHERE ispoverty='是' group by province,stu_grade ")
    List<List> findIspovertyByProvinceAndGrade();

    @Query("select city,stu_grade,count(province)  from students_basic WHERE ispoverty='是' group by city,stu_grade")
    List<List> findIspovertyByCityAndGrade();

    @Query("select college,stu_grade ,count (stu_grade ) FROM  students_basic group by college,stu_grade")
    List<List> fiindAllStuByCollegeAndGrade();

    @Query("select province ,sex, count(province) from students_basic  group by sex, province   ORDER BY province,sex")
    List<List> countSexByProvince();

    @Query("select city ,sex,count(sex) as count from students_basic  group by   city,sex  ORDER BY city,sex")
    List<List> countSexByCity();

    @Query("select college ,sex,count(sex) from students_basic  group by   college,sex ")
    List<List> countSexByCollege();

}
