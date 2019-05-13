package com.mytest.permission;

import com.mytest.permission.error.DuplicateEntries;
import com.mytest.permission.error.PasswordWrong;
import com.mytest.permission.error.UserNotExist;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class PermisssionUtils {
    final private String Key_UserId = "com.mytest.permission.xse716UserId";
    private Mapper mapper;

    public PermisssionUtils(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(Mapper.class);
        this.mapper = new SqlSessionTemplate(sqlSessionFactory).getMapper(Mapper.class);
    }

    public Boolean hasResource(String resourceName) {
        return mapper.userHasResource((Integer) this.currentSession().getAttribute(Key_UserId), resourceName);
    }

    public Integer userId() {
        return (Integer) this.currentSession().getAttribute(this.Key_UserId);
    }

    public Integer loginIn(String userName, String password) throws UserNotExist, PasswordWrong, DuplicateEntries {
        if (null != this.currentSession().getAttribute(this.Key_UserId)) {
            throw new DuplicateEntries();
        }
        Integer id = this.mapper.selectIdByUsername(userName);
        if (null == id) {
            throw new UserNotExist();
        } else if (!this.mapper.checkPassword(userName, password)) {
            throw new PasswordWrong();
        } else {
            this.currentSession().setAttribute(this.Key_UserId, id.intValue());
            return id;
        }
    }

    public void loginOut() {
        this.currentSession().removeAttribute(this.Key_UserId);
    }

    private HttpSession currentSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    private interface Mapper {
        @Select("select #{resourceName} in (select role_resource.resource from user_role left join role_resource on user_role.role=role_resource.role where user_role.user=#{userId}) as result")
        Boolean userHasResource(@Param("userId") int userId, @Param("resourceName") String resourceName);

        @Select("select id from user where username=#{username}")
        Integer selectIdByUsername(@Param("username") String username);

        @Select("select #{password}=(select password from user where username=#{username}) as result")
        Boolean checkPassword(@Param("username") String username, @Param("password") String password);
    }
}
