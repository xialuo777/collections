package com.hdu.mapper;

import com.hdu.entity.users.Role;
import com.hdu.entity.users.User;
import com.hdu.entity.users.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * 用户CRUD
     * @param user
     * @return
     */

    @Insert("insert into users (user_id,username,password,email) values (#{userId},#{userName},#{password},#{email})")
    int addUser(User user);
    @Select("select * from users where user_id=#{id}")
    User findById(Integer id);
    @Update("update users set username=#{userName},password=#{password},email=#{email} where user_id = #{userId}")
    int updateUser(User user);
    @Delete("delete from users where user_id=#{id}")
    int deleteUser(Integer id);
    @Select("select * from users where username like concat ('%',#{name},'%')")
    List<User> findByName(String name);
    @Select("select * from users")
    List<User> findAll();

    /**
     * 角色CRUD
     * @param uerRole
     * @return
     */
    @Insert("insert into user_role (user_id,role_id) values (#{userId},#{roleId})")
    int addRole(UserRole uerRole);
    @Delete("delete from user_role where id = #{id}")
    int deleteRole(Integer id);
    @Update("update user_role set role_id=#{roleId} where id = #{id}")
    int updateRole(UserRole userRole);


    @Select("select * from user_role,roles where user_role.user_id = (select user_id from users where users.username = #{name}) and roles.role_id = user_role.role_id")
    List<Role> findRoleByUserName(String name);
    @Select("SELECT u.*, ur.role_id\n" +
            "FROM ssm.user_role AS ur\n" +
            "JOIN ssm.users AS u ON u.user_id = ur.user_id\n" +
            "JOIN ssm.roles AS r ON ur.role_id = r.role_id\n" +
            "WHERE r.role_name = #{name} ")
    List<User> findUserByRoleName(String name);
    @Select("select * from roles where role_id = (select role_id from user_role where user_id = #{id}))")
    List<Role> findRoleByUserId(Integer id);
    @Select("select * from users where user_id = (select user_id from user_role where role_id = #{id})")
    List<User> findUserByRoleId(Integer id);


}
