package dji.pilot.usercenter;

import org.json.JSONObject;

public class MemberParser
{
  public static Object parseAvatar(String paramString)
  {
    Object localObject2 = new MemberResponse();
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = MemberResponse.parse(localJSONObject, (MemberResponse)localObject2, 1);
      localObject2 = paramString;
      localObject1 = paramString;
      if (paramString.mStatus == 0)
      {
        localObject1 = paramString;
        localObject2 = MemberResponse.parse(localJSONObject, paramString, 8);
      }
      return localObject2;
    }
    catch (Exception paramString) {}
    return localObject1;
  }
  
  public static Object parseHeader(String paramString)
  {
    MemberResponse localMemberResponse = new MemberResponse();
    try
    {
      paramString = MemberResponse.parse(new JSONObject(paramString), localMemberResponse, 1);
      return paramString;
    }
    catch (Exception paramString) {}
    return localMemberResponse;
  }
  
  public static Object parseToken(String paramString)
  {
    Object localObject2 = new MemberResponse();
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = MemberResponse.parse(localJSONObject, (MemberResponse)localObject2, 1);
      localObject2 = paramString;
      localObject1 = paramString;
      if (paramString.mStatus == 0)
      {
        localObject1 = paramString;
        paramString = MemberResponse.parse(localJSONObject, paramString, 4);
        localObject1 = paramString;
        localObject2 = MemberResponse.parse(localJSONObject, paramString, 32);
      }
      return localObject2;
    }
    catch (Exception paramString) {}
    return localObject1;
  }
  
  public static Object parseUserInfo(String paramString)
  {
    Object localObject2 = new MemberResponse();
    Object localObject1 = localObject2;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = MemberResponse.parse(localJSONObject, (MemberResponse)localObject2, 1);
      localObject2 = paramString;
      localObject1 = paramString;
      if (paramString.mStatus == 0)
      {
        localObject1 = paramString;
        paramString = MemberResponse.parse(localJSONObject, paramString, 2);
        localObject1 = paramString;
        localObject2 = MemberResponse.parse(localJSONObject, paramString, 16);
      }
      return localObject2;
    }
    catch (Exception paramString) {}
    return localObject1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilo\\usercenter\MemberParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */