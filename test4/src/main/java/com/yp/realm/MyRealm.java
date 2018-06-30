package com.yp.realm;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

 

import com.yp.pojo.Function;
import com.yp.pojo.Role;
import com.yp.pojo.User;
import com.yp.service.FunctionService;
import com.yp.service.RoleService;
import com.yp.service.UserService;

public class MyRealm extends AuthorizingRealm{
	 @Resource
	    private UserService userService;
	    @Resource
	    private FunctionService functionService;	
	    @Resource
	    private RoleService roleService;
	    
	    /** @description 添加角色	
	     * @param username
	     * @param info
	     *2015年10月12日  下午2:40:39
	     *返回类型:void	
	     */
	    private void addRole(String username, SimpleAuthorizationInfo info) {
		List<Role> roles = roleService.findByName(username);
		for (Role role : roles) {
		    info.addRole(role.getRoleName());
		}
	    }

	    /**
	     * @description 添加权限	
	     * @param username
	     * @param info
	     * @return
	     *2015年10月12日  下午2:42:15
	     *返回类型:SimpleAuthorizationInfo
	     */
	    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {
		List<Function> functions = functionService.findByName(username);
		for (Function function : functions) {
		    info.addStringPermission(function.getUrl());//添加权限  
		}
		return info;  
	    }  
	  
	    
	    
	    
	    /**
	     * 获取授权信息
	     */
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
	        //用户名  
	        String username = (String) principals.fromRealm(getName()).iterator().next(); 
	        
	        //根据用户名来添加相应的权限和角色
	        if(!StringUtils.isEmpty(username)){
	            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	            addPermission(username,info);
	            addRole(username, info);
	            return info;
 	        }
 	        return null;  
	    }
  	   /** 
	    * 登录验证 
	    */  
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken ) throws AuthenticationException {  
	        //令牌——基于用户名和密码的令牌  
	        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
	        //令牌中可以取出用户名密码  
	        String accountName = token.getUsername();
 	        //让shiro框架去验证账号密码
	        if(!StringUtils.isEmpty(accountName)){
	            User user = userService.find(accountName);
	            if(user != null){
	        	return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
	            }
	        }
 	        return null;
	    }  

}
