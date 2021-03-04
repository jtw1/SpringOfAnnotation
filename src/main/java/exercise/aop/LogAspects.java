package exercise.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Description  日志切面类 里面的方法需要动态感知 MathCalculator.div运行到哪里了然后返回
 * @date 2021/3/4 0004-20:38
 * @Aspect 告诉spring当前类是一个切面类
 * JoinPoint joinPoint 参数必须出现在参数列表第一位，否则spring也识别不到
 */
@Aspect
public class LogAspects {
    // 抽取公共的切入点表达式
    @Pointcut("execution(public int exercise.aop.MathCalculator.div(int,int))")
    public void pointCut(){}
    // 切入点表达式的本类引用
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(""+joinPoint.getSignature().getName()+"运行。。。参数列表是{"+ Arrays.asList(args)+"}");
    }
    // 切入点表达式的外部类引用
    @After("exercise.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"结束。。。");
    }

    @AfterReturning(value="pointCut()",returning = "res")
    public void logReturn(JoinPoint joinPoint,Object res){
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。运行结果是{"+ res+"}");
    }
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception){
        System.out.println(joinPoint.getSignature().getName()+"异常。。。异常信息：{"+ exception+"}");
    }
}
