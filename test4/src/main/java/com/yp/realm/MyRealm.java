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
	    
	    /** @description ��ӽ�ɫ	
	     * @param username
	     * @param info
	     *2015��10��12��  ����2:40:39
	     *��������:void	
	     */
	    private void addRole(String username, SimpleAuthorizationInfo info) {
		List<Role> roles = roleService.findByName(username);
		for (Role role : roles) {
		    info.addRole(role.getRoleName());
		}
	    }

	    /**
	     * @description ���Ȩ��	
	     * @param username
	     * @param info
	     * @return
	     *2015��10��12��  ����2:42:15
	     *��������:SimpleAuthorizationInfo
	     */
	    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {
		List<Function> functions = functionService.findByName(username);
		for (Function function : functions) {
		    info.addStringPermission(function.getUrl());//���Ȩ��  
		}
		return info;  
	    }  
	  
	    
	    
	    
	    /**
	     * ��ȡ��Ȩ��Ϣ
	     */
	    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {  
	        //�û���  
	        String username = (String) principals.fromRealm(getName()).iterator().next(); 
	        
	        //�����û����������Ӧ��Ȩ�޺ͽ�ɫ
	        if(!StringUtils.isEmpty(username)){
	            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
	            addPermission(username,info);
	            addRole(username, info);
	            return info;
 	        }
 	        return null;  
	    }
  	   /** 
	    * ��¼��֤ 
	    */  
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken ) throws AuthenticationException {  
	        //���ơ��������û��������������  
	        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
	        //�����п���ȡ���û�������  
	        String accountName = token.getUsername();
 	        //��shiro���ȥ��֤�˺�����
	        if(!StringUtils.isEmpty(accountName)){
	            User user = userService.find(accountName);
	            if(user != null){
	        	return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
	            }
	        }
 	        return null;
	    }  

}
