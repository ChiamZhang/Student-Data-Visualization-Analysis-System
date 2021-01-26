package com.atzhuang.Service.Impl;

import com.atzhuang.Service.userService;
import com.atzhuang.datadao.UserRepository;
import com.atzhuang.bean.databean.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class userServiceimpl implements userService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable(value = "person")
    public person findByXuehao(String xuehao) {
        return userRepository.findByXuehao(xuehao);
    }

    @Cacheable(value = "person",key = "person_all")
    public List<person> findAll()
    {
        List<person> all = userRepository.findAll();
        return all;

    }
}
