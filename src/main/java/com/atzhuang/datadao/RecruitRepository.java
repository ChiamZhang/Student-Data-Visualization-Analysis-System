package com.atzhuang.datadao;

import com.atzhuang.bean.databean.recruit_students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitRepository extends JpaRepository<recruit_students,Integer> {

}
