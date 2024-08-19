package com.hdu.service;

import com.hdu.entity.users.Role;
import com.hdu.entity.users.User;
import com.hdu.entity.users.UserRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 根据用户id查找用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(Integer id);
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from users")
    List<User> findAll();

    /**
     * 添加用户角色
     * @param uerRole
     * @return
     */
    boolean addRole(UserRole uerRole);

    /**
     * 删除用户角色
     * @param id
     * @return
     */
    boolean deleteRole(Integer id);

    /**
     * 修改用户角色
     * @param userRole
     * @return
     */
    boolean updateRole(UserRole userRole);

    /**
     * 根据用户名查找用户角色
     * @param name
     * @return
     */
    List<Role> findRoleByUserName(String name);

    /**
     * 根据角色名字查找当前角色下的所有用户
     * @param name
     * @return
     */
    List<User> findUserByRoleName(String name);

    /**
     * 根据用户id查找用户角色
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Integer id);

    /**
     * 根据角色id查找当前角色下的所有用户
     * @param id
     * @return
     */
    List<User> findUserByRoleId(Integer id);


}
