package com.aaa.annotation;

import com.aaa.model.LoginLog;
import com.aaa.model.User;
import com.aaa.service.SpringCloudService;
import com.aaa.utils.AddressUtils;
import com.aaa.utils.IPUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.util.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.aaa.staticproperties.TimeForatProperties.*;

/**
 * 日志AOP
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Autowired
    private SpringCloudService springCloudService;

    /**
     *     定义切点信息
     *      这个时候就不能再按照常规的切点(service/controller)
     *      直接去切自定义的注解
     *      也就是说当检测自定义注解存在的时候，切面触发，也就是说AOP才会被触发
     */
    @Pointcut("@annotation(com.aaa.annotation.LoginAnnotation)")
    public void pointcut(){
        //定义切入点
    }


    /**
     * 定义环绕切面
     *    ProceedingJoinPoint:
     *     封装了目标路径中的所用到的所有参数
     *      这里会用到大量的反射
     * @param point
     * @return
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws ClassNotFoundException {
        Object result = null;
        try {
            //ProceedingJoinPoint执行proceed方法的作用是用于启动目标方式执行的
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        //获取Request对象
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();
        //1.获取Ip地址
        String ipAddr = IPUtils.getIpAddr(request);
        System.out.println(ipAddr);
        if (ipAddr.equals("127.0.0.1")){
            ipAddr="1.199.72.136";
        }
        //2.获取地理位置
        Map<String, Object> addressMap = AddressUtils.getAddresses(ipAddr, "UTF-8");
        System.out.println(addressMap);
        LoginLog loginLog=new LoginLog();
        loginLog.setIp(ipAddr);
        loginLog.setLocation(addressMap.get("province")+"|"+addressMap.get("city"));
        //3.获取登陆时间
        String formatDate = DateUtil.formatDate(new Date(),TIME_FORMAT);
        loginLog.setLoginTime(formatDate);
        //4.获取用户名
        //获取用户名，需要先获取方法参数，再通过get得到
        //获取目标方法的参数
        Object[] args = point.getArgs();
        User user = null;
        for (Object arg : args) {
            user = (User) arg;
        }
        loginLog.setUsername(user.getUsername());
        //5.获取目标的操作具体内容，要获取到方法上的注解
        // 获取操作的类型以及具体操作的内容(反射)
        // 5.1.获取目标类名(全限定名)
        String tarClassName = point.getTarget().getClass().getName();
        // 5.2.获取目标的方法名
        String tarMehtodName = point.getSignature().getName();
        // 5.3.获取类对象
        Class tarClass = Class.forName(tarClassName);
        // 5.4.获取目标类中的所有方法
        Method[] methods = tarClass.getMethods();

        String operationName = "";
        String operationType = "";
        for (Method method : methods) {
            String methodName = method.getName();
            if (tarMehtodName.equals(methodName)){
                // 这个时候虽然已经确定了目标方法没有问题，但是有可能会出现方法的重载
                // 还需要进一步判断
                //获取类方法的参数
                Class[] parameterTypes = method.getParameterTypes();
                // 5.5.判断当前方法名一致的方法的参数是否一致
                if (parameterTypes.length==args.length){
                  operationName = method.getAnnotation(LoginAnnotation.class).opeationName();
                  operationType = method.getAnnotation(LoginAnnotation.class).opeationType();
                }
            }
        }
        loginLog.setOperationName(operationName);
        loginLog.setOperationType(operationType);

        Integer integer = springCloudService.addLoginLog(loginLog);
        System.out.println(integer);
        if (integer>0){
            return result;
        }
        return null;
    }
}
