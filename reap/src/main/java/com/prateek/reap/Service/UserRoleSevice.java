package com.prateek.reap.Service;

import com.prateek.reap.Entity.UserRole;
import com.prateek.reap.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleSevice {
    @Autowired
    UserRoleRepository userRoleRepository;
    public UserRole checkByName(String name)
    {
        return userRoleRepository.findByName(name);
    }
}
