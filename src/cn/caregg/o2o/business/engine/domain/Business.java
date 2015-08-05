package cn.caregg.o2o.business.engine.domain;

/**
 * @ClassName: Buseinss
 * @Description: TODO  商家
 * @author FH 
 * @date 2015年7月13日 上午10:41:08
 * 
*/
public class Business {
   
//	商家组织序号
	private String serviceOrgSeq;
	
	private String serviceOrgEToken;
	
//	手机号码
	private String telephone;
	
//	登录标记
	private String flag;
	
//	信息
	private String message;
	
	

	public String getServiceOrgSeq() {
		return serviceOrgSeq;
	}

	public void setServiceOrgSeq(String serviceOrgSeq) {
		this.serviceOrgSeq = serviceOrgSeq;
	}

	public String getServiceOrgEToken() {
		return serviceOrgEToken;
	}

	public void setServiceOrgEToken(String serviceOrgEToken) {
		this.serviceOrgEToken = serviceOrgEToken;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String isLoginSucc) {
		this.flag = isLoginSucc;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Business [serviceOrgSeq=" + serviceOrgSeq
				+ ", serviceOrgEToken=" + serviceOrgEToken + ", telephone="
				+ telephone + ", isLoginSucc=" + flag + ", message="
				+ message + "]";
	}
	
	
	
}
