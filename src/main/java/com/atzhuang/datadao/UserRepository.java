package com.atzhuang.datadao;

import com.atzhuang.bean.databean.person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<person, String> {
    public person findByXuehao(String xuehao);
}
