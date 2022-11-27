package dji.pilot.usercenter;

import dji.pilot.usercenter.region.Region;
import java.util.ArrayList;
import java.util.List;

public class MemberInfo
{
  public static final int ACCOUNT_TYPE_COMPANY = 1;
  public static final int ACCOUNT_TYPE_PERSONAL = 0;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN = 0;
  public String mAbout = "";
  public int mAccountType = 0;
  public String mAvatarUrl = "";
  public String mBio = "";
  public String mCity = "";
  public String mCompany = "";
  public String mCompanyDesc = "";
  public String mCountry = "";
  public String mCountryCode = "";
  public String mCreateTime = "";
  public String mCurrency = "";
  public long mDdsAvailable = 0L;
  public long mDdsAvailableSoon = 0L;
  @Deprecated
  public String mEmail = "";
  public String mFackBookUrl = "";
  public int mFavoritesCount = 0;
  public String mFirstName = "";
  public final List<FlightInfo> mFlights = new ArrayList();
  public String mGear = "";
  public int mGender = 1;
  public String mGooglePlusUrl = "";
  public String mId = "";
  public boolean mIsPhoneRegister = false;
  public String mLastName = "";
  public int mLikesCount = 0;
  public String mName = "";
  public String mNickName = "";
  public String mPassword = "";
  public String mPhoneArea = "";
  public String mPhoneNumber = "";
  public int mPhotosCount = 0;
  public String mPinterestUrl = "";
  public Region mRegion = null;
  public String mState = "";
  public String mToken = "";
  public String mTumblrUrl = "";
  public String mTwitterUrl = "";
  public String mUid = "";
  public String mUsedEmail = "";
  public int mVideosCount = 0;
  public String mWebPage = "";
  
  /* Error */
  public void copyOf(MemberInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  /* Error */
  public void resetInfo()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\MemberInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */