package cn.caregg.o2o.business.engine.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @ClassName: NoticeInfo
 * @Description: TODO   通知信息
 * @author FH 
 * @date 2015年7月30日 下午3:39:32
 * 
*/

public class NoticeInfo implements Parcelable{

//	是否已读(0 未读1 已读)
	private String noticeInfoStatus;
	
//  消息序号
	private String noticeInfoSeq;
	
//	事件消息标题
	private String noticeInfoTitle;
	
//	事件消息类别序号
	private String noticeTypeSeq;
	
//	事件生成时间
	private Long  noticeInfoTime;
	
//	事件消息内容(商家)
	private String noticeInfoContent2;
	
	
	
	
	public NoticeInfo(){};
	

	public NoticeInfo(String noticeInfoStatus, String noticeInfoSeq,
		String noticeInfoTitle, String noticeTypeSeq, Long noticeInfoTime,
		String noticeInfoContent2) {
		super();
		this.noticeInfoStatus = noticeInfoStatus;
		this.noticeInfoSeq = noticeInfoSeq;
		this.noticeInfoTitle = noticeInfoTitle;
		this.noticeTypeSeq = noticeTypeSeq;
		this.noticeInfoTime = noticeInfoTime;
		this.noticeInfoContent2 = noticeInfoContent2;
	}

	public String getNoticeInfoStatus() {
		return noticeInfoStatus;
	}

	public void setNoticeInfoStatus(String noticeInfoStatus) {
		this.noticeInfoStatus = noticeInfoStatus;
	}

	public String getNoticeInfoSeq() {
		return noticeInfoSeq;
	}

	public void setNoticeInfoSeq(String noticeInfoSeq) {
		this.noticeInfoSeq = noticeInfoSeq;
	}

	public String getNoticeInfoTitle() {
		return noticeInfoTitle;
	}

	public void setNoticeInfoTitle(String noticeInfoTitle) {
		this.noticeInfoTitle = noticeInfoTitle;
	}

	public String getNoticeTypeSeq() {
		return noticeTypeSeq;
	}

	public void setNoticeTypeSeq(String noticeTypeSeq) {
		this.noticeTypeSeq = noticeTypeSeq;
	}

	public Long getNoticeInfoTime() {
		return noticeInfoTime;
	}

	public void setNoticeInfoTime(Long noticeInfoTime) {
		this.noticeInfoTime = noticeInfoTime;
	}

	public String getNoticeInfoContent2() {
		return noticeInfoContent2;
	}

	public void setNoticeInfoContent2(String noticeInfoContent2) {
		this.noticeInfoContent2 = noticeInfoContent2;
	}

	@Override
	public String toString() {
		return "NoticeInfo [noticeInfoStatus=" + noticeInfoStatus
				+ ", noticeInfoSeq=" + noticeInfoSeq + ", noticeInfoTitle="
				+ noticeInfoTitle + ", noticeTypeSeq=" + noticeTypeSeq
				+ ", noticeInfoTime=" + noticeInfoTime
				+ ", noticeInfoContent2=" + noticeInfoContent2 + "]";
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Parcelable.Creator<NoticeInfo> CREATOR = new Creator<NoticeInfo>() {
		
		@Override
		public NoticeInfo[] newArray(int size) {
			return new NoticeInfo[size];
		}
		
		
		//反序列化
		@Override
		public NoticeInfo createFromParcel(Parcel source) {
			return new NoticeInfo(source.readString(), source.readString(),
								source.readString(), source.readString(),
								source.readLong(), source.readString());
		}
	};
	
	
	//序列化
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(noticeInfoStatus);
		dest.writeString(noticeInfoSeq);
		dest.writeString(noticeInfoTitle);
		dest.writeString(noticeTypeSeq);
		dest.writeLong(noticeInfoTime);
		dest.writeString(noticeInfoContent2);
	}
	
	
	
	
	
	
}
