/**
 *
 */
package com.example;

/**
 * @描述 : 系统级错误编码，为了统一系统异常设置
 * @作者 : JiaoJian
 * @创建时间 : 2015年9月16日  上午10:16:13
 */
public enum ErrorCode {

    SUCCESS(0x0, "成功"),

    /**
     * 全局异常
     */
    ERR_UNKNOWN(0x40000001, "未知异常"),
    ERR_SYSTEM(0x40000002, "系统异常"),
    ERR_PARAM(0x40000003, "参数异常"),
    ERR_TIMEOUT(0x40000004, "处理超时"),
    ERR_TIMEOUT_CONNECT(0x40000005, "连接超时"),
    ERR_TIMEOUT_SOCKET(0x40000006, "链接超时"),

    /**
     * 前4位 系统＋模块
     * 0x4001 用户中心
     * 0x4002 客户中心
     * 0x4003 审批系统
     * 0x4004 账务系统
     * 0x4005 影像系统
     * 0x4006 通知系统
     * 0x4007 数据中心
     * 0x4008 API
     * ox4009 银联
     * 后4位 错误码
     * 0001～0999 技术错误
     * 1001～9999 业务错误
     */

    /**
     * 用户中心
     */
    UM_SMS_CODE_INVALID							(0x40011001, "无效验证码"),
    UM_SMS_CODE_EXPIRED							(0x40011002, "验证码已过期"),
    UM_SMS_CODE_TO_MANY_TIME					(0x40011003, "验证码发送次数超过限制"),
    UM_TOKEN_NOTEXIT							(0x40011004, "token不存在"),
    UM_TOKEN_KICK								(0x40011005, "token踢出失效"),
    UM_TOKEN_LOGOUT								(0x40011006, "token登出失效"),
    UM_TOKEN_TIMEOUT							(0x40011007, "token超时失效"),

    UM_REG_IDENT_EXIST							(0x40012001, "身份证已被注册"),
    UM_REG_MOBILE_EXIT							(0x40012002, "手机号码已被注册"),
    UM_REG_IDENT_ERROR							(0x40012003, "请输入真实的身份证"),

    UM_LOGIN_IMEI_ERROR							(0x40012101, "imei 设备不一样, 请进行手机验证码校验"),
    UM_LOGIN_TO_MANY_TIME						(0x40012102, "登录错误次数已达上限，稍后再试"),
    UM_LOGIN_IDCARD_AND_NAME_AND_PASSWORD		(0x40012103, "身份证号和姓名密码不匹配"),
    UM_LOGIN_LOGIN_TYPE							(0x40012104, "登录标识有误"),
    UM_LOGIN_PASSWORD							(0x40012105, "登录密码不正确"),
    UM_LOGIN_IDCARD_AND_NAME					(0x40012106, "姓名身份证号不匹配"),
    UM_LOGIN_MOBILE								(0x40012107, "手机号不存在"),

    UM_PSWD_OLD									(0x40012201, "旧密码不正确"),
    UM_PSWD_IDCARD_NAME_MOBILE					(0x40012202, "身份证、姓名、手机号不匹配"),
    UM_PSWD_OLD_MOBILE							(0x40012203, "旧手机验证不通过"),
    UM_PSWD_EXIST_PSWD							(0x40012204, "方法调用错误，用户已设置交易密码"),
    UM_PSWD_NOT_EXIST_PSWD						(0x40012205, "用户未设置交易密码"),
    UM_PSWD_OLD_TRANS							(0x40012206, "旧交易密码不正确"),
    UM_PSWD_ERR_TRANS							(0x40012207, "交易密码错误"),
    UM_PSWD_LOCK								(0x40012209, "交易密码错误次数超过限制，已被锁定"),

    UM_FILE_UPLOAD_LIMIT						(0x40012208, "文件上传次数超过上限"),
    
    UM_MOBILE_MODIFY_NAME_IDENT_ERROE			(0x40012210, "姓名或身份证号不正确"),
    /**
     * 客户中心
     */
    CM_CARD_NOT_SURPPORT						(0x40021001, "不支持的银行卡"),
    CM_CARD_MASTER_MUST_DEBIT					(0x40021002, "主卡必须是借记卡"),
    CM_CARD_NO_CARD								(0x40021003, "用户未绑定银行卡"),
    CM_CARD_IS_MASTER							(0x40021004, "当前银行卡已经是主卡"),
    CM_CARD_EXIST								(0x40021005, "银行卡已经绑定"),
    CM_CARD_AREA_ERROR							(0x40021006, "银行卡区域错误"),
    CM_CARD_TO_MANY_TIMES						(0x40021007, "绑定银行卡连续错误次数超出限制"),
    CM_CARD_BANK_CODE_ERROR						(0x40021008, "银行编码与银行卡号不匹配"),
    CM_CARD_BANK_APPROVAING						(0x40021009, "您存在正在审批的申请单，不能修改银行卡主卡"),
    /**
     * 银联
     */
    // 9904、9907、9913
    CUP_CARD_ERROR								(0x40091001, "银行卡号不正确或已过期，请更换银行卡再试"),
    // 9919、9920、9908(原为密码错误，但是实际情况不是密码错误，具体错误原因不知道是什么)
    CUP_CARD_IDENT								(0x40091002, "身份证与银行卡号不匹配，绑卡失败"),
    // 其他
    CUP_SYS_BUSY								(0x40091003, "系统繁忙，请稍后再试，或更换银行卡再试"),

    /**
     * 账务系统
     */
    QUERY_PRODUCT_FAIL							(0x40042001, "查询产品列表失败"),
    QUERY_CONTRACTLIST_FAIL						(0x40042002, "查询客户合同列表失败"),
    QUERY_QUERYPRODUCTDETAILS_FAIL				(0x40042003, "查询产品详情失败"),
    PRODUCT_TRIAL_CALCULATION					(0x40042004, "产品试算失败"),
    QUERY_PRODUCT_LIST_FAILED					(0x40042005, "查询产品资料清单失败"),
    UPDATE_BANKCARD_FAIL						(0x40042006, "修改银行卡信息失败"),
    ERR_CCS_UPDATE_MOBILE_FAIL					(0x40042007, "修改手机号失败"),
    ERR_CCS_NO_DEBT								(0x40042008, "没有贷款信息"),
    CONTRACT_TRIAL_CALCULATION					(0x40042009, "合同试算失败"),

    //审批相关
    QUERY_APPLYNO_FAIL							(0x40032010, "查询申请单号失败"),
    SUBMIT_APPLY_FAIL							(0x40032011, "提交申请单失败"),
    QUERY_APPLY_DETAIL_FAIL						(0x40032012, "查询申请详情失败"),
    QUERY_APPLY_LIST_FAIL						(0x40032013, "查询申请列表失败"),
    CONTRACT_SIGNING_CONFIRMED_FAIL				(0x40032014, "合同签约确认失败"),
    PRODUCT_CODE_ERROR							(0x40032015, "产品编码参数错误"),

    QUERY_PRODUCT_REQUEST_NULL					(0x40033001, "JSON字符串为空"),
    QUERY_PRODUCT_JSON_FAIL						(0x40033002, "JSON字符串有误"),

    //APP api 状态码
    API_TIMESTAMP								(0x4008001, "时间戳异常"),
    API_SIGN									(0x40080001, "签名异常"),
    API_TOKEN									(0x40080001, "认证TOKEN异常"),
    API_ERR_WITHDRAW_FAIL						(0x40081001, "提现失败"),
    API_ERR_REPAY_FAIL							(0x40081002, "还款失败"),
    API_VERIFY_WHITELIST_FAIL					(0x40082001, "白名单校验未通过"),
    API_VERIFY_BANKCARD_FAIL					(0x40082002, "银行卡实名校验未通过"),
    API_VERIFY_CAPTCHA_FAIL						(0x40082003, "验证码无效或已失效"),
    
    API_CUSTOM                					(0x40082000, "自定义错误信息"),
    API_DEAL_ING                            	(0x40082004, "交易正在处理中"),
    API_ERROR_SUBMIT 							(0x40082005, "提交信息有误，请确认后再试"),
    API_TOO_OFTEN								(0x40082006, "您的操作较为频繁，请稍后再试"),
    API_INVALID_CONTRACT						(0x40082007, "合同失效"),
    API_STOP_CONTRACT							(0x40082008, "合同已停止"),
    API_VERIFYING_SUBMIT						(0x40082009, "提交信息审核中"),
    API_PASS_LOAN_DATE							(0x40082010, "合同已过放款有效期"),
    API_END_CONTRACT							(0x40082011, "合同已终止，请勿进行还款操作"),
    API_END_PAY_CONTRACT					    (0x40082011, "合同已终止，请勿进行提现操作"),
    API_PAYED_CONTRACT							(0x40082012, "合同已还款，请勿进行还款操作"),
    API_NOT_ENOUGH_BALANCE						(0x40082013, "余额不足，请确认后再试"),
    API_REPAYING								(0x40082014, "您有一笔还款正在进行中，请稍后再试"),
    API_REPAY_MORE_THAN_DUE 					(0x40082015, "还款金额大于欠款，请确认后再试"),
    API_NOT_SUPPORT_INITIATIVE_REPAY			(0x40082016, "非额度产品不支持还款，请勿进行还款操作"),
    API_NO_PREREPAY_CONTRACT 					(0x40082017, "暂无待还款合同，请勿进行还款操作"),
    API_ORDER_STATUS_NOT_MATCH                  (0x40082018, "订单状态不匹配"),
    API_MAKE_LOANS                  			(0x40082019, "放款遇到问题？请联系客户400-036-8876"),

    /**
     * 数据中心
     * @create Oct 1, 2015 11:34:24 AM
     * @author 玄玉<http://blog.csdn.net/jadyer>
     */
    DATACENTER_VERIFY_BANKCARD_SUCCESS               (0x40070000, "银行卡实名认证成功"),
    DATACENTER_VERIFY_BANKCARD_FAIL                  (0x40070001, "银行卡与身份证姓名不匹配"),
    DATACENTER_VERIFY_BANKCARD_BUSY                  (0x40070002, "系统繁忙"),
    DATACENTER_VERIFY_BANKCARD_UNAUTHEN              (0x40071111, "未认证"),
    DATACENTER_VERIFY_BANKCARD_PROCESSING            (0x40072222, "认证已提交，正在处理中"),
    DATACENTER_VERIFY_BANKCARD_RETRY                 (0x40079999, "认证失败,请稍后重试"),
    DATACENTER_VERIFY_BANKCARD_FAIL_CONTACT_BANK     (0x40079900, "认证失败,请联系发卡行"),
    DATACENTER_VERIFY_BANKCARD_VALID_BANK            (0x40079901, "无效的发卡行"),
    DATACENTER_VERIFY_BANKCARD_VALID_TRADE           (0x40079902, "无效交易"),
    DATACENTER_VERIFY_BANKCARD_VALID_AMOUNT          (0x40079903, "无效金额"),
    DATACENTER_VERIFY_BANKCARD_VALID_CARDNO          (0x40079904, "无效卡号"),
    DATACENTER_VERIFY_BANKCARD_CUSTOMER_CANCLE       (0x40079905, "客户取消交易"),
    DATACENTER_VERIFY_BANKCARD_VALID_TRADERESP       (0x40079906, "无效交易响应"),
    DATACENTER_VERIFY_BANKCARD_CARD_EXPIRE           (0x40079907, "此卡已过期"),
    DATACENTER_VERIFY_BANKCARD_PASSWORD_ERROR        (0x40079908, "密码错误"),
    DATACENTER_VERIFY_BANKCARD_AMOUNT_UNENOUGH       (0x40079909, "余额不足"),
    DATACENTER_VERIFY_BANKCARD_DID_NOT_OPEN          (0x40079910, "未开通此功能"),
    DATACENTER_VERIFY_BANKCARD_TRADE_CONTACT_BANK    (0x40079911, "交易异常,请联系发卡行"),
    DATACENTER_VERIFY_BANKCARD_AMOUNT_LIMIT          (0x40079912, "超出金额限制"),
    DATACENTER_VERIFY_BANKCARD_CARD_CONTACT_BANK     (0x40079913, "此卡受限制,请联系发卡行"),
    DATACENTER_VERIFY_BANKCARD_WITHDRAW_COUNT        (0x40079914, "超出取款次数限制"),
    DATACENTER_VERIFY_BANKCARD_PASSWROD_CONTACT_BANK (0x40079915, "超出最大输入密码次数,请联系发卡行"),
    DATACENTER_VERIFY_BANKCARD_TIMEOUT               (0x40079916, "交易超时,请重试"),
    DATACENTER_VERIFY_BANKCARD_REPEAT                (0x40079917, "交易重复,请稍后查询结果"),
    DATACENTER_VERIFY_BANKCARD_PASSWORD_FORMAT_ERROR (0x40079918, "密码格式错误"),
    DATACENTER_VERIFY_BANKCARD_FAIL_UNKNOWN_NAME     (0x40079919, "银行卡与姓名不符"),
    DATACENTER_VERIFY_BANKCARD_FAIL_UNKNOWN_IDENT    (0x40079920, "银行卡与证件不符"),
    DATACENTER_FAIL_GET_USER_AREA_INFO				 (0x40079921, "获取用户位置失败");

    private final int value;

    private final String message;

    ErrorCode(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    public String getCode() {
        return Integer.toHexString(this.value).toUpperCase();
    }

    public String getSystem() {
        return Integer.toHexString(this.value >>> 24).toUpperCase();
    }

    public String getModule() {
        return Integer.toHexString(this.value >>> 16).toUpperCase();
    }

    /**
	 * 通过枚举code获取枚举对象
	 * @return 取不到时返回null
	 * @create Oct 1, 2015 11:34:24 AM
     * @author 玄玉<http://blog.csdn.net/jadyer>
	 */
	public static ErrorCode getByCode(int value){
		for(ErrorCode _enum : values()){
			if(_enum.getValue() == value){
				return _enum;
			}
		}
		return null;
	}
}