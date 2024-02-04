package com.zero.common.response;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(0, "操作成功"),
    ERROR(101, "操作失败"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    FILE_IS_INVALID(10005, "文件格式无效"),

    // 未知错误 30001-39999
    UNKNOWNERROE(301, "未知错误"),

    /* 成功操作  20001 -29999 */
    UPLOAD_SUCCESS(20001, "文件上传成功"),
    CONTRZCT_UPLOAD_SUCCESS(20002, "合同上传成功"),
    SUCCESS_ADD(20003, "保存成功"),
    SUCCESS_DEL(20004, "删除成功"),
    SUCCESS_AUDIT(20005, "审批成功"),
    UP_ADD(20006, "升级成功"),
    DOWN_ADD(20007, "降级成功"),
    UPLOAD_SUCESS(20008, "上传成功"),
    ENABLE_SUCESS(20009, "启用成功"),
    DISABLE_SUCESS(20010, "禁用成功"),
    TRANINFORUN_SUCESS(20011, "出清成功"),
    SUCCESS_IN(20012, "准入成功"),
    SUCCESS_OUT(20013, "准出成功"),
    OPTION_SUCESS(20014, "设置成功"),

    /* 警告操作 30001 -39999*/
    OPERADATE(30001, "没有权限操作"),
    TRANINFO_UPDATE(30002, "当前分组下还有交易序列,不能修改"),
    TRANINFO_DEL(30003, "当前分组下还有交易序列,不能删除"),
    TRANINFOBACK_ADUIT(30004, "该数据已审批,请勿重复操作"),
    TRANINFOIN_ADUIT(30005, "此步骤有正在进行中的审批，暂时不能修改"),
    TRISCQ(30006, "交易序列不存在或已出清"),
    TRISTYPE(30007, "非集中竞价交易禁止出清"),
    TRCQTIME(30008, "不在出清时间范围内禁止出清"),

    /* 失败操作 40001 -49999*/
    UPLOAD_DEAULT(40001, "上传失败"),

    TRISCQ_NONE(41045, "交易序列不存在或已出清"),
    TRISTYPE_FORBID(41046, "非集中竞价交易禁止出清"),
    TRCQTIME_ERROR(41047, "不在出清时间范围内禁止出清"),

    /* 数据错误：50001-599999 */
    SQLERROR(501, "数据库错误"),
    RESULT_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_DOLOGIN_PW(50004, "用户名或密码不能为空"),

    /**
     * 返回码和状态说明
     */
    NO_TOKEN(com.zero.common.response.HttpStatus.NO_TOKEN, "请先进行用户登录!"),
    BAD_REQUEST(com.zero.common.response.HttpStatus.BAD_REQUEST, "参数或者语法不对"),
    ACCOUNT_STOP(com.zero.common.response.HttpStatus.ACCOUNT_STOP, "帐号被停用,禁止登录!!"),
    UNAUTHORIZED(com.zero.common.response.HttpStatus.UNAUTHORIZED, "认证失败!"),
    LOGIN_EXPIRED(com.zero.common.response.HttpStatus.ACCOUNT_EXPIRED, "登录失效,请重新登录！"),
    LOGIN_ERROR(com.zero.common.response.HttpStatus.LOGIN_ERROR, "登录失败,用户名或密码错误!"),
    NOT_FOUND(com.zero.common.response.HttpStatus.NOT_FOUND, "请求的资源不存在!"),
    REPEAT_SUBMIT(com.zero.common.response.HttpStatus.REPEAT_SUBMIT, "重复提交!"),
    SERVICE_ERROR(com.zero.common.response.HttpStatus.SERVICE_ERROR, "服务器内部错误!"),
    ORDER_DEAL_WITH(com.zero.common.response.HttpStatus.ORDER_DEAL_WITH, "订单处理超期，重新调用"),
    TICKET_USER_ERROR(com.zero.common.response.HttpStatus.TICKET_USER_ERROR, "根据ticket获取用户信息失败！"),
    REQUEST_OPENPLATFORM_ERROR(3330011, "请求统一开放平台接口失败！"),
    /**
     * 内网统计模块相关Code 占用x02xx状态码
     */
    NW_STATISTICS_LOGIN_FAIL(202001, "当前未登录!"),
    NW_STATISTICS_SELECT_SUCCESS(202002, "查询成功"),
    NW_COLLECTION_SELECT_SUCCESS(111111, "查询成功"),
    NW_STATISTICS_VOUCHER_SUCCESS(202004, "超额消纳量生成计算成功"),
    NW_STATISTICS_VOUCHER_FAIL(202003, "超额消纳量生成计算失败"),
    NW_STATISTICS_CONFIRM_VOUCHER_FAIL(202005, "确认失败"),
    NW_STATISTICS_CONFIRM_VOUCHER_SUCCESS(202006, "确认成功"),
    NW_STATISTICS_XN_PROVINCE_SUCCESS(202008, "统计成功"),
    NW_STATISTICS_XN_PROVINCE_FAIL(202007, "统计失败"),
    NW_STATISTICS_XN_PROVINCE(202009, "当前无数据进行统计"),
    NW_STATISTICS_XN_PROVINCE_YEAR_SUCCESS(202010, "统计成功"),
    NW_STATISTICS_XN_PROVINCE_YEAR_FAIL(202011, "统计失败"),
    NW_STATISTICS_XN_PROVINCE_YEAR(202013, "当前无数据进行统计"),
    NW_STATISTICS_XN_SUBJECT_SUCCESS(2020012, "统计成功"),
    NW_STATISTICS_XN_SUBJECT_FAIL(2020015, "统计失败"),
    NW_STATISTICS_XN_SUBJECT(2020017, "当前无数据进行统计"),
    NW_STATISTICS_XN_SUBJECT_YEAR_SUCCESS(202014, "统计成功"),
    NW_STATISTICS_XN_SUBJECT_YEAR_FAIL(202019, "统计失败"),
    NW_STATISTICS_XN_SUBJECT_YEAR(202021, "当前无数据进行统计"),
    NW_STATISTICS_JSSE_VOUCHER_FAIL(202023, "计算失败"),
    NW_STATISTICS_JSSE_VOUCHER_SUCCESS(202024, "计算成功"),
    /**
     * 内网系统设置模块相关Code 占用x04xxx状态码
     */
    NW_SYSTEM_SELECT_SUCCESS(204002, "查询成功"),
    NW_SAVE_SYSTEM_STATISTICS_SUCCESS(204004, "添加成功"),
    NW_SAVE_SYSTEM_STATISTICS_FAIL(204003, "添加失败"),
    NW_SAVE_SYSTEM_STATISTICS_REPEAT(204005, "不可重复生成配置数据"),
    NW_Update_SYSTEM_STATISTICS_SUCCESS(204006, "修改成功"),
    NW_Update_SYSTEM_STATISTICS_FAIL(204007, "修改失败"),
    NW_Update_SYSTEM_STATISTICS_EXIST(204009, "修改数据不存在"),
    NW_SAVE_SYSTEM_TIME_SUCCESS(204008, "新增成功"),
    NW_SAVE_SYSTEM_TIME_FAIL(204017, "新增失败"),
    NW_SAVE_SYSTEM_TIME_ERROR(204019, "加入定时任务配置出现异常,请检查添加信息!"),
    NW_SAVE_SYSTEM_TIME_EXIST(204011, "名称已存在"),
    NW_UPDATE_SYSTEM_TIME_EXIST(204013, "修改内容不存在"),
    NW_UPDATE_SYSTEM_TIME_SUCCESS(204010, "更新成功"),
    NW_UPDATE_SYSTEM_TIME_FAIL(204015, "更新失败"),

    /**
     * 内网首页相关Code 占用x044x状态码
     */
    NW_INDEX_SELECT_SUCCESS(204402, "查询成功"),

    /*数据导入*/
    DATA_UPLOAD_SUCCESS(203310, "导入成功！"),
    DATA_UPLOAD_FAIL(20339, "导入成功0条！");

    private final Integer code;
    private final String message;

    ResultCode(int i, String success) {
        this.code = i;
        this.message = success;
    }

}
