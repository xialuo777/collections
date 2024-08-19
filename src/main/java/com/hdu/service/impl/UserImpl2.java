package com.hdu.service.impl;

import com.hdu.entity.users.Role;
import com.hdu.entity.users.User;
import com.hdu.entity.users.UserRole;
import com.hdu.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl2 implements UserService {
    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean addRole(UserRole uerRole) {
        return false;
    }

    @Override
    public boolean deleteRole(Integer id) {
        return false;
    }

    @Override
    public boolean updateRole(UserRole userRole) {
        return false;
    }

    @Override
    public List<Role> findRoleByUserName(String name) {
        return null;
    }

    @Override
    public List<User> findUserByRoleName(String name) {
        return null;
    }

    @Override
    public List<Role> findRoleByUserId(Integer id) {
        return null;
    }

    @Override
    public List<User> findUserByRoleId(Integer id) {
        return null;
    }
}
