package dji.pilot.usercenter;

import org.json.JSONObject;

public class MemberResponse
  extends ResponseBase
{
  public static final int FLAG_PARSE_AVATAR = 8;
  public static final int FLAG_PARSE_FLIGHTS = 16;
  public static final int FLAG_PARSE_HEADER = 1;
  public static final int FLAG_PARSE_TOKEN = 4;
  public static final int FLAG_PARSE_UID = 32;
  public static final int FLAG_PARSE_USERINFO = 2;
  public int mItemCount = 0;
  public MemberInfo mMemberInfo = null;
  public String mMessage = "";
  
  public static MemberResponse parse(JSONObject paramJSONObject, MemberResponse paramMemberResponse, int paramInt)
  {
    MemberResponse localMemberResponse = paramMemberResponse;
    if (paramJSONObject != null)
    {
      localMemberResponse = paramMemberResponse;
      if (paramMemberResponse == null) {
        localMemberResponse = new MemberResponse();
      }
      if (2 == paramInt)
      {
        localMemberResponse.parseUserInfo(paramJSONObject);
        return localMemberResponse;
      }
      if (4 == paramInt)
      {
        localMemberResponse.parseToken(paramJSONObject);
        return localMemberResponse;
      }
      if (8 == paramInt)
      {
        localMemberResponse.parseAvatar(paramJSONObject);
        return localMemberResponse;
      }
      if (16 == paramInt)
      {
        localMemberResponse.parseFlights(paramJSONObject);
        return localMemberResponse;
      }
      if (32 == paramInt)
      {
        localMemberResponse.parseUid(paramJSONObject);
        return localMemberResponse;
      }
      localMemberResponse.parseHeader(paramJSONObject);
    }
    return localMemberResponse;
  }
  
  /* Error */
  public void parseAvatar(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void parseFlights(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void parseHeader(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void parseToken(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void parseUid(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void parseUserInfo(JSONObject arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\MemberResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */