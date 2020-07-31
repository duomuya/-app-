package com.cdut.utils;

/**
 * Created with IntelliJ IDEA.
 * Date: 2020/06/04 21:44
 * Description:
 * Version: V1.0
 *
 * @author healer
 */
public enum ResultCode {

    /**
     * 0：请求成功
     */
    SUCCESS(0, "成功"),

    /* **************************参数错误时，状态码范围在：1001~1999************************* */

    /**
     * 1001：参数无效
     */
    PARAM_IS_INVALID(1001, "参数无效"),
    /**
     * 1002：参数为空
     */
    PARAM_IS_BLANK(1002, "参数为空"),
    /**
     * 1003：参数类型错误
     */
    PARAM_TYPE_ERROR(1003, "参数类型错误"),
    /**
     * 1004：参数缺失
     */
    PARAM_NOT_COMPLETE(1004, "参数缺失"),

    /* *****************************用户错误时，状态码范围在：2000~2999*********************** */
    /**
     * 2000：权限不足
     */
    USER_NOT(2000, "权限不足"),

    /**
     * 2001：用户不存在
     */
    USER_NOT_EXIST(2001, "用户不存在"),

    /**
     * 2002：用户登录时用户名或密码错误
     */
    USER_LOGIN_ERROR(2002, "密码错误"),

    /**
     * 2003：用户登录验证码有误
     */
    USER_VERIFICATION_CODE_ERROR(2003, "用户登录验证码有误"),
    /**
     * 2004：用户登录手机号有误
     */
    USER_TELEPHONE_ERROR(2004, "用户登录手机号有误"),
    /**
     * 2005：用户登录验证码已过期
     */
    USER_VERIFICATION_CODE_EXPIRED(2005, "用户登录验证码已过期"),
    /**
     * 2006：用户信息插入数据库失败
     */
    USER_INSERT_ERROR(2006, "用户插入数据库失败"),
    /**
     * 2007：用户信息从数据库删除失败
     */
    USER_DELETE_ERROR(2007, "用户从数据库删除失败"),
    /**
     * 2008：用户信息更新到数据库失败
     */
    USER_UPDATE_ERROR(2008, "用户更新到数据库失败"),
    /**
     * 2009：发送短信验证码失败
     */
    USER_SEND_VERIFICATIO_CODE_ERROR(2009, "发送短信验证码失败"),
    /**
     * 2010：获取session中的用户数据失败
     */
    USER_SESSION_ERROR(2010, "获取session中的用户数据失败"),
    /**
     * 2011：注册时用户已经存在
     */
    USER_HAS_EXIST(2011, "用户已存在"),
    /**
     * 2022：用户电话号码已经被注册
     */
    USER_PHONE_REGISTED(2022, "电话号码已被注册"),
    /**
     * 2023：用户注册失败
     */
    USER_REGISTER_FAILED(2023, "用户注册失败"),

    /* ******************课程相关错误时，状态码范围在：3001~3999********************* */



    /* ******************考试相关错误时，状态码范围在：4001~4999********************* */
    EXAM_SELECT_FAILED(4001,"考试信息查询失败"),
    EXAM_ADD_FAILED(4002,"考试信息添加失败"),
    EXAM_DELETE_FAILED(4003,"考试信息删除失败"),
    EXAM_BATCH_DELETE_FAILED(4004,"考试信息批量删除失败"),
    EXAM_UPDATE_FAILED(4005,"考试信息更新失败"),
    EXAM_SELECT_MINE_FAILED(4006,"考试信息查询我的失败"),
    QUESTION_SELECT_FAILED(4007,"试题信息查询失败"),
    QUESTION_ADD_FAILED(4007,"试题添加失败"),
    QUESTION_DELETE_FAILED(4008,"试题删除失败"),
    QUESTION_BATCH_DELETE_FAILED(4009,"试题批量删除失败"),
    QUESTION_UPDATE_FAILED(4010,"试题信息更新失败"),
    Paper_SELECT_FAILED(4011,"试卷信息查询失败"),
    Paper_ADD_FAILED(4012,"试卷添加失败"),
    Paper_DELETE_FAILED(4013,"试卷删除失败"),
    Paper_BATCH_DELETE_FAILED(4014,"试卷批量删除失败"),
    Paper_UPDATE_FAILED(4015,"试卷信息更新失败");


    /* ******************作业相关错误时，状态码范围在：5001~5999********************* */


    /* ******************聊天管理相关错误时，状态码范围在：5001~5999********************* */

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String message;

    /**
     * ResultCode构造器
     *
     * @param code    状态码
     * @param message 状态信息
     */
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
