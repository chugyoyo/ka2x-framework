package com.ka2x.swagger.aspect;

import com.ka2x.swagger.annotation.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.*;

import java.util.Arrays;

/**
 * <p>
 * 对注解 {@link Ka2xApi} 进行增强
 * </p>
 *
 * @author ka2x
 * @since 2022/8/27 19:47
 */
@Slf4j
@Aspect
@Component
@SuppressWarnings({"unused"})
public class Ka2xApiAspect {

    @Pointcut("@annotation(com.ka2x.swagger.annotation.Ka2xApi).staticinitialization")
    public void ka2xApi() {
        log.info("Pointcut...");
    }

    @Before("ka2xApi()")
    public void beforePointcut(JoinPoint joinPoint) {
        // 此处进入到方法前  可以实现一些业务逻辑
        log.info("beforePointcut...");
    }

    @Around(value = "ka2xApi()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("doAround...");
        Signature signature = joinPoint.getSignature();
        log.info("signature -> {}", signature);
        String declaringTypeName = signature.getDeclaringTypeName();
        log.info("declaringTypeName -> {}", declaringTypeName);
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] params = methodSignature.getParameterNames();// 获取参数名称
        Object[] args = joinPoint.getArgs();// 获取参数值
        log.info("params -> {}", Arrays.toString(params));
        log.info("args -> {}", Arrays.toString(args));
        return joinPoint.proceed();
    }

    /**
     * 在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
     *
     * @param joinPoint
     */
    @AfterReturning("ka2xApi()")
    public void doAfterReturning(JoinPoint joinPoint) {
        log.info("doAfterReturning...");
    }
}
