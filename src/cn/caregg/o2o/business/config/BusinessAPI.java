package cn.caregg.o2o.business.config;

/**
 * @ClassName: BusinessAPI
 * @Description: TODO
 * @author FH 
 * @date 2015年6月30日 下午4:11:25
 * 
*/

public class BusinessAPI {
    
	
//	本地测试
	private static String DOMAIN;
	private static String DEV="caregg-o2o-seller-dev/seller/";
	
	static{
		//1是本地，2是测试，3是正式
		DOMAIN = Domain.TYPE.getEnvrionment(4);
	}
    
	enum Domain{
		TYPE;
		
		public String getEnvrionment(int type){
			String str = "";
			switch (type) {
			case 1:str = "http://192.168.1.104:8080/";break;
			case 2:str = "";break;                            //测试
			case 3:str = "";break;                            //正式
			case 4:str = "http://192.168.1.98:8080/";break;  //余西红本地ID
			default:
				str = "http://192.168.1.104:8080/";break;  //默认切换测试环境
			}
			return str;
		}
	}
	
	
	private static String getRequestUrl(String url){
		StringBuffer req = new StringBuffer(DOMAIN);
		req.append(DEV);
		req.append(url);
		return req.toString();
	}
	

	/**
	 *  数据请求
	 * **/
	
//	密码重置
	public static String USER_RESTPWD = getRequestUrl("user/resetPwd");
//	登录
	public static String USER_LOGIN = getRequestUrl("user/login");
//	发送短信验证
	public static String SEND_SMS  =getRequestUrl("user/sendSMSvalidateCode");
//	消息通知
	public static String FINDNOTICE = getRequestUrl("org/findNoticeInfoByUserSeq");
//	标记消息为已读
	public static String ALLARTICLE = getRequestUrl("org/updateStatusAllbyUserSeq");
//	用户信息搜索
	public static String FIND_CAR_OWNER  =getRequestUrl("org/findCarOwner");
//	查看用户详情
	public static String FIND_CAROWNER_BY_SEQ = getRequestUrl("org/findCarOwnerBySeq");
//	意见反馈
	public static String  FEEDBACK = getRequestUrl("org/feedback");
//	首页
	public static String  MAINPAGE = getRequestUrl("org/countNumber");
	
	/**
	 *  页面请求
	 * **/
	public static String  PORTAL="https://www.caregg.cn/";
	
}
