package com.hdu.service.impl;

import com.hdu.entity.users.Role;
import com.hdu.entity.users.User;
import com.hdu.entity.users.UserRole;
import com.hdu.mapper.UserMapper;
import com.hdu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user) > 0 ;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user) > 0;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return userMapper.deleteUser(id) > 0;
    }

    @Override
    public List<User> findByName(String name) {
        return userMapper.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public boolean addRole(UserRole uerRole) {
        return userMapper.addRole(uerRole) > 0;
    }

    @Override
    public boolean deleteRole(Integer id) {
        return userMapper.deleteRole(id) > 0;
    }

    @Override
    public boolean updateRole(UserRole userRole) {
        return userMapper.updateRole(userRole) > 0;
    }

    @Override
    public List<Role> findRoleByUserName(String name) {
        return userMapper.findRoleByUserName(name);
    }

    @Override
    public List<User> findUserByRoleName(String name) {
        return userMapper.findUserByRoleName(name);
    }

    @Override
    public List<Role> findRoleByUserId(Integer id) {
        return userMapper.findRoleByUserId(id);
    }

    @Override
    public List<User> findUserByRoleId(Integer id) {
        return userMapper.findUserByRoleId(id);
    }
}
