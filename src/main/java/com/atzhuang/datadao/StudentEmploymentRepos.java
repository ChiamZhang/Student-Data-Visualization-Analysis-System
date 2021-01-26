package com.atzhuang.datadao;

import com.atzhuang.bean.databean.students_employment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentEmploymentRepos extends JpaRepository<students_employment, Integer> {
    @Query(value="select students_employment.city,count(students_employment.city),students_basic.college  FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.city,students_basic.college  ",nativeQuery=true)
    List<List> findJobByCollege();

    @Query(value="select students_employment.city,count(students_employment.city),students_basic.stu_major  FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.city,students_basic.stu_major  ",nativeQuery=true)
    List<List> findJobByMajor();

    @Query(value="select students_employment.city,count(students_employment.city),2016 FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.city   ",nativeQuery=true)
    List<List> findJobByGrade();

    @Query(value="select students_employment.job_nature,count(students_employment.job_nature),students_basic.college  FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.job_nature,students_basic.college  ",nativeQuery=true)
    List<List> findNatureByCollege();

    @Query(value="select students_employment.job_nature,count(students_employment.job_nature),students_basic.stu_major  FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.job_nature,students_basic.stu_major  ",nativeQuery=true)
    List<List> findNatureByMajor();

    @Query(value="select students_employment.job_nature,count(students_employment.job_nature),2016 FROM students_employment left join   students_basic on students_basic.number=students_employment .number  GROUP BY students_employment.job_nature   ",nativeQuery=true)
    List<List> findNatureByGrade();
}
