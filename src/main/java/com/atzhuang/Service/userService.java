package com.atzhuang.Service;

import com.atzhuang.bean.databean.person;

import java.util.List;

public interface userService {
    public person findByXuehao(String xuehao);

    public List<person> findAll();
}
