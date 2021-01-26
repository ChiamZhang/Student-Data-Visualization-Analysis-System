package com.atzhuang.datadao;




import com.atzhuang.bean.databean.students_consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsConsumptionRepos  extends JpaRepository<students_consumption,Integer> {
    @Query("select  Floor(number/1000000)  , avg(consumption),month FROM students_consumption group by  month, Floor(number/1000000)")
    List<List> findAverCost();

    @Query("select  Floor(number/1000000)  , max(consumption),month FROM students_consumption group by  month, Floor(number/1000000)")
    List<List> findMaxCost();

    @Query("select  Floor(number/1000000)  , min(consumption),month FROM students_consumption group by  month, Floor(number/1000000)")
    List<List> findMinCost();

    @Query(value="select students_basic.sex,sum(students_consumption.consumption) From students_basic left join  students_consumption   on students_basic.number=students_consumption.number GROUP BY students_basic.sex ",nativeQuery=true)
    List<List> findSexCost();

    @Query(value="select students_basic.province,sum(students_consumption.consumption) From students_basic left join  students_consumption   on students_basic.number=students_consumption.number GROUP BY students_basic.province ",nativeQuery=true)
    List<List> findProvinceCost();

    @Query(value="select students_basic.city,sum(students_consumption.consumption) From students_basic left join  students_consumption   on students_basic.number=students_consumption.number GROUP BY students_basic.city ",nativeQuery=true)
    List<List> findCityCost();
}
