package com.zero.common.response;

/**
 * 返回状态码
 *
 */
public interface HttpStatus {
    /**
     * 操作成功
     */
    public static final int SUCCESS = 200;

    /**
     * 对象创建成功
     */
    public static final int CREATED = 201;

    /**
     * 请求已经被接受
     */
    public static final int ACCEPTED = 202;

    /**
     * 操作已经执行成功，但是没有返回数据
     */
    public static final int NO_CONTENT = 204;

    /**
     * 资源已被移除
     */
    public static final int MOVED_PERM = 301;

    /**
     * 重定向
     */
    public static final int SEE_OTHER = 303;

    /**
     * 资源没有被修改
     */
    public static final int NOT_MODIFIED = 304;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 未授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 访问受限，授权过期
     */
    public static final int FORBIDDEN = 403;

    /**
     * 资源，服务未找到
     */
    public static final int NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    public static final int BAD_METHOD = 405;

    /**
     * 资源冲突，或者资源被锁
     */
    public static final int CONFLICT = 409;

    /**
     * 不支持的数据，媒体类型
     */
    public static final int UNSUPPORTED_TYPE = 415;

    /**
     * 系统内部错误
     */
    public static final int ERROR = 500;

    /**
     * 接口未实现
     */
    public static final int NOT_IMPLEMENTED = 501;
    /**
     * 重复提交
     */
    public static final int REPEAT_SUBMIT = -889;

    /**
     * 全局异常错误
     */
    public static final int SERVICE_ERROR = 101;

    /**
     * 权限错误,没有TOKEN
     */
    public static final int NO_TOKEN = 10001;

    /**
     * 帐号被停用
     */
    public static final int ACCOUNT_STOP = 10002;

    /**
     * 帐号授权失效过期
     */
    public static final int ACCOUNT_EXPIRED = 10003;
    /**
     * 登录失败
     */
    public static final int LOGIN_ERROR = 10005;

    /**
     * 订单处理失败，重新调用
     */
    public static final int ORDER_DEAL_WITH = 10006;

    /**
     * 根据ticket获取用户信息失败
     */
    public static final int TICKET_USER_ERROR = 10007;
}
