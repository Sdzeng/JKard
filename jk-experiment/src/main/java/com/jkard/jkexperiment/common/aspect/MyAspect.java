package com.jkard.jkexperiment.common.aspect;

import com.jkard.jkexperiment.service.IParentTestService;
import com.jkard.jkexperiment.service.impl.ParentTestServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**** imports ****/
@Aspect //定义切面
public class MyAspect {

    //引入,它的作用是引入新的类来增强原有的服务
    @DeclareParents(value= "com.jkard.jkexperiment.service.impl.TestServiceImpl+",defaultImpl= ParentTestServiceImpl.class)
    public IParentTestService parentTestService;

    //定义切点
    @Pointcut("execution(* com.jkard.jkexperiment.service.impl.TestServiceImpl.print(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("aop before ......");
    }

    //获取参数
    //方式1：切点处加入对应的正则式
    //方式2：对于非环绕通知还可以使用一个连接点（JoinPoint）类型的参数，通过它也可以获取参数
    //正则式pointCut() && args(user)中，pointCut()表示启用原来定义切点的规则，并且约定将连接点（目标对象方法）名称为user的参数传递进来。这里要注意，JoinPoint类型的参数对于非环绕通知而言，Spring AOP会自动地把它传递到通知中；对于环绕通知而言，可以使用ProceedingJoinPoint类型的参数。
    @Before("pointCut() && args(content)")
    public void beforeParam(JoinPoint point, String content) {
        Object[] args = point.getArgs();
        System.out.println("aop before args ......");
    }

    //环绕通知
    //注意：用环绕通知注解测试的时候总是不按顺序执行，估计是Spring版本之间的差异留下的问题，这是在使用时需要注意的。所以在没有必要的时候，应尽量不要使用环绕通知，它很强大，但是也很危险。
    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("aop around before......");
        jp.proceed();//回调目标对象的原有方法

        System.out.println("aop around after......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("aop after ......");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("aop afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("aop afterThrowing ......");
    }
}