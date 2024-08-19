package com.hdu.controller;

import com.hdu.entity.issues.Issue;
import com.hdu.entity.users.Role;
import com.hdu.entity.users.User;
import com.hdu.entity.users.UserRole;
import com.hdu.service.UserService;
import com.hdu.service.impl.UserImpl;
import com.hdu.service.impl.UserImpl2;
import com.hdu.util.Code;
import com.hdu.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

//    @Resource
    @Autowired
    @Qualifier("userService")
    private UserService userService;

//    @Resource
    @Autowired
    @Qualifier("userImpl2")
    private UserImpl2 userImpl2;

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        boolean flag = userService.addUser(user);
        return flag ? new Result(Code.SAVE_OK, "添加用户成功") : new Result(Code.SAVE_ERR, "添加用户失败");
    }

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delById/{id}")
    public Result delById(@PathVariable Integer id) {
        boolean flag = userService.deleteUser(id);
        return flag ? new Result(Code.DELETE_OK, "删除用户成功") : new Result(Code.DELETE_ERR, "删除用户失败");
    }

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public Optional<User> findById(@PathVariable Integer id) {
        Optional<User> user = Optional.ofNullable(userService.findById(id));
        return user;
    }

    /**
     * 通过用户名模糊查询
     *
     * @param name
     * @return
     */
    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        boolean flag = userService.updateUser(user);
        return flag ? new Result(Code.UPDATE_OK, "更新用户成功") : new Result(Code.UPDATE_ERR, "更新用户失败");
    }

    /**
     * 通过用户名查找其角色
     *
     * @param name
     * @return
     */
    @GetMapping("/findRoleByUserName/{name}")
    public List<Role> findRoleByUserName(@PathVariable String name) {
        return userService.findRoleByUserName(name);
    }

    /**
     * 通过角色名查找所有用户
     *
     * @param name
     * @return
     */
    @GetMapping("/findUserByRoleName/{name}")
    public List<User> findUserByRoleName(@PathVariable String name) {
        return userService.findUserByRoleName(name);
    }

    /**
     * 根据用户id查找角色
     *
     * @param id
     * @return
     */
    @GetMapping("/findRoleByUserId/{id}")
    public List<Role> findRoleByUserId(@PathVariable Integer id) {
        return userService.findRoleByUserId(id);
    }

    /**
     * 根据角色id查找用户
     *
     * @return
     */
    @GetMapping("/findUserByRoleId/{id}")
    public List<User> findUserByRoleId(@PathVariable Integer id) {
        return userService.findUserByRoleId(id);
    }

    /**
     * 分页查看所有用户
     *
     * @param page
     * @return
     */
    @GetMapping
    public Result findAll(@RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        List<User> users = userService.findAll();
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, users.size());
        List<User> userList = users.subList(startIndex, endIndex);
        Integer code = users != null ? Code.GET_OK : Code.GET_ERR;
        String msg = users != null ? "获取成功" : "获取失败";
        return new Result(code, userList, msg);
    }

    /**
     * 增加角色
     * @param userRole
     * @return
     */
    @PostMapping("/addRole")
    public Result addRoleById(@RequestBody UserRole userRole) {
        boolean flag = userService.addRole(userRole);
        return flag ? new Result(Code.UPDATE_OK, "添加角色成功") : new Result(Code.UPDATE_ERR, "添加角色失败");
    }

    /**
     * 通过角色id删除指定角色
     *
     * @param roleId
     * @return
     */
    @DeleteMapping("/delRoleById")
    public Result delRoleById(Integer roleId) {
        boolean flag = userService.deleteRole(roleId);
        return flag ? new Result(Code.DELETE_OK, "删除角色成功") : new Result(Code.DELETE_ERR, "删除角色失败");
    }

}
