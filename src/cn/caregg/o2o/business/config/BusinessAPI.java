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
		DOMAIN = Domain.TYPE.getEnvrionment(1);
	}
    
	enum Domain{
		TYPE;
		
		public String getEnvrionment(int type){
			String str = "";
			switch (type) {
			case 1:str = "http://192.168.1.104:8080/";break;
			case 2:str = "";break;                          //测试
			case 3:str = "";break;                          //正式
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
	

	
//	密码重置
	public static String USER_RESTPWD = getRequestUrl("user/resetPwd");
//	登录
	public static String USER_LOGIN = getRequestUrl("user/login");
//	发送短信验证
	public static String SEND_SMS  =getRequestUrl("user/sendSMSvalidateCode");
	
}
