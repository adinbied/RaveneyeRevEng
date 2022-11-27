package com.huawei.hms.support.api.entity.hwid;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.a.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInReq
  implements IMessageEntity
{
  private static final String KEY_DYNAMIC_PERMISSIONS = "dynamicpermissions";
  private static final String KEY_SCOPES = "scopes";
  @a
  public String mLocalJsonObject;
  
  public SignInReq() {}
  
  public SignInReq(Set<String> paramSet1, Set<String> paramSet2)
  {
    JSONArray localJSONArray = new JSONArray();
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext()) {
      localJSONArray.put((String)paramSet1.next());
    }
    paramSet1 = new JSONArray();
    paramSet2 = paramSet2.iterator();
    while (paramSet2.hasNext()) {
      paramSet1.put((String)paramSet2.next());
    }
    paramSet2 = new JSONObject();
    try
    {
      paramSet2.put("scopes", localJSONArray);
      paramSet2.put("dynamicpermissions", paramSet1);
      this.mLocalJsonObject = paramSet2.toString();
      return;
    }
    catch (JSONException paramSet1)
    {
      for (;;) {}
    }
    this.mLocalJsonObject = new JSONObject().toString();
  }
  
  private JSONObject getJsonObj()
  {
    return null;
  }
  
  public List<String> getPermissionInfos()
  {
    return null;
  }
  
  public List<String> getScopes()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\entity\hwid\SignInReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */