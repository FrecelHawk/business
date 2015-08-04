package cn.caregg.o2o.business.engine.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName: UserInfo
 * @Description: TODO  用户信息
 * @author FH 
 * @date 2015年8月3日 上午11:04:49
 * 
*/

public class UserInfo implements Parcelable{

//	车牌号
	private String carId;
	
//  用户电话
	private String ownerTel;
	
//	用户头像
	private String carOwnerPic;
	
//	车主序号
	private String carOwnerSeq;

//	用户昵称
	private String ownerNickName;
	
//	最后登录时间
	private Long lastLoginTime;

//	车厂名称
	private String carMakerName;
	
//  品牌名称
	private String carBrandName;
	
//	车主姓名
	private String ownerName;
	
//	消费订单数
	private String countOder;
	
//	注册时间
	private Long ownerCreateTime;
	
//	消费总数	
	private String sumPrice;


	@Override
	public int describeContents() {
		return 0;
	}
	
	
	

public UserInfo(String carId, String ownerTel, String carOwnerPic,
			String carOwnerSeq, String ownerNickName, Long lastLoginTime,
			String carMakerName, String carBrandName, String ownerName,
			String countOder, Long ownerCreateTime, String sumPrice) {
		super();
		this.carId = carId;
		this.ownerTel = ownerTel;
		this.carOwnerPic = carOwnerPic;
		this.carOwnerSeq = carOwnerSeq;
		this.ownerNickName = ownerNickName;
		this.lastLoginTime = lastLoginTime;
		this.carMakerName = carMakerName;
		this.carBrandName = carBrandName;
		this.ownerName = ownerName;
		this.countOder = countOder;
		this.ownerCreateTime = ownerCreateTime;
		this.sumPrice = sumPrice;
	}




//	序列化
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(carId);
		dest.writeString(ownerTel);
		dest.writeString(carOwnerPic);
		dest.writeString(carOwnerSeq);
		dest.writeString(ownerNickName);
		if(null!=lastLoginTime)
		    dest.writeLong(lastLoginTime);
		dest.writeString(carMakerName);
		dest.writeString(carBrandName);
		dest.writeString(ownerName);
		dest.writeString(countOder);
		if(null!=ownerCreateTime)
		    dest.writeLong(ownerCreateTime);
		dest.writeString(sumPrice);
	}

	public static final Parcelable.Creator<UserInfo> CREATOR = new Creator<UserInfo>() {

		//反序列化
		@Override
		public UserInfo createFromParcel(Parcel source) {
			UserInfo  user = new UserInfo();
			user.setCarId(source.readString());
			user.setOwnerTel(source.readString());
			user.setCarOwnerPic(source.readString());
			user.setCarOwnerSeq(source.readString());
			user.setOwnerNickName(source.readString());
			user.setLastLoginTime(source.readLong());
			user.setCarMakerName(source.readString());
			user.setCarBrandName(source.readString());
			user.setOwnerName(source.readString());
			user.setCountOder(source.readString());
			user.setOwnerCreateTime(source.readLong());
			user.setSumPrice(source.readString());
			return user;
		}

		@Override
		public UserInfo[] newArray(int size) {
			return new UserInfo[size];
		}

	};
	
	public UserInfo(){};
	

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getOwnerTel() {
		return ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	public String getCarOwnerPic() {
		return carOwnerPic;
	}

	public void setCarOwnerPic(String carOwnerPic) {
		this.carOwnerPic = carOwnerPic;
	}

	public String getCarOwnerSeq() {
		return carOwnerSeq;
	}

	public void setCarOwnerSeq(String carOwnerSeq) {
		this.carOwnerSeq = carOwnerSeq;
	}

	public String getOwnerNickName() {
		return ownerNickName;
	}

	public void setOwnerNickName(String ownerNickName) {
		this.ownerNickName = ownerNickName;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public static Parcelable.Creator<UserInfo> getCreator() {
		return CREATOR;
	}

	public String getCarMakerName() {
		return carMakerName;
	}

	public void setCarMakerName(String carMakerName) {
		this.carMakerName = carMakerName;
	}

	public String getCarBrandName() {
		return carBrandName;
	}

	public void setCarBrandName(String carBrandName) {
		this.carBrandName = carBrandName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getCountOder() {
		return countOder;
	}

	public void setCountOder(String countOder) {
		this.countOder = countOder;
	}

	public Long getOwnerCreateTime() {
		return ownerCreateTime;
	}

	public void setOwnerCreateTime(Long ownerCreateTime) {
		this.ownerCreateTime = ownerCreateTime;
	}

	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
	
}
