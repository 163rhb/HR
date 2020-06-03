package org.rhb.vhr.exception;

import org.rhb.vhr.model.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/*@RestControllerAdvice*/
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException e) {
        if (e instanceof SQLIntegrityConstraintViolationException) {

            return RespBean.error("该数据有关联数据，操作失败");
        }

        return RespBean.error("数据库操作异常，请求失败!");
    }
}