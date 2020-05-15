package servicebase.exception;

import com.msr.common.msrUtil.ExceptionUtil;
import com.msr.common.msrUtil.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        log.error(ExceptionUtil.getMessage(e));
        return R.error().message("全局异常");
    }
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        log.error(ExceptionUtil.getMessage(e));
//        e.printStackTrace();
        return R.error().message("算术异常");
    }

    @ExceptionHandler(MSRException.class)
    @ResponseBody
    public R error(MSRException e){
       log.error(ExceptionUtil.getMessage(e));
//          e.printStackTrace();
        return R.error().message(e.getMsg()).code(e.getCode());
    }
}
