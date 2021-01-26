package com.atzhuang.datadao;


import com.atzhuang.bean.databean.students_grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentGradeRepos extends JpaRepository<students_grade,Integer> {


    @Query("select number,AVG(grade) from students_grade GROUP BY  number HAVING  AVG(grade)>4")
    List<List> findGoodStu();

    @Query(nativeQuery = true,value = "SELECT a.number,a.grade,b.`name`,b.sex,b.college,b.stu_major,b.phone FROM students_grade a,students_basic b WHERE a.number=b.number ORDER BY a.grade DESC LIMIT 0,10")
    public  List<List> GetExcellentStudent();
}
