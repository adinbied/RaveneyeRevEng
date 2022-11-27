package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cq
  implements cv
{
  private static cq jdField_a_of_type_ComXiaomiPushCq;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private cp jdField_a_of_type_ComXiaomiPushCp;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, co> jdField_a_of_type_JavaUtilHashMap;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d;
  
  public static cq a()
  {
    try
    {
      cq localcq = jdField_a_of_type_ComXiaomiPushCq;
      return localcq;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private String a(ArrayList<cn> paramArrayList, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localJSONObject.put("imei", ct.a(this.jdField_a_of_type_JavaLangString));
    }
    localJSONObject.put("actionType", paramString);
    localJSONObject.put("actionTime", System.currentTimeMillis());
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramString = null;
      if (TextUtils.isEmpty(((cn)paramArrayList.get(i)).jdField_a_of_type_JavaLangString)) {
        paramString = new JSONObject();
      }
      try
      {
        localObject = new JSONObject(((cn)paramArrayList.get(i)).jdField_a_of_type_JavaLangString);
        paramString = (String)localObject;
      }
      catch (Exception localException)
      {
        Object localObject;
        for (;;) {}
      }
      Log.e("com.xiaomi.miui.ads.pushsdk", "content 不是json串");
      localObject = paramString;
      if (paramString == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("adId", ((cn)paramArrayList.get(i)).jdField_a_of_type_Long);
      localArrayList.add(localObject);
      i += 1;
    }
    localJSONObject.put("adList", new JSONArray(localArrayList));
    return Base64.encodeToString(localJSONObject.toString().getBytes(), 2);
  }
  
  private void a(co paramco)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramco.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.jdField_b_of_type_Int += 1;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("send: ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    ct.a(((StringBuilder)localObject).toString());
    localObject = new cr(this, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramco);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramco.jdField_b_of_type_JavaLangString, paramco);
    ((cr)localObject).execute(new String[0]);
  }
  
  private void a(ArrayList<cn> paramArrayList, String paramString, int paramInt)
  {
    try
    {
      paramArrayList = a(paramArrayList, paramString);
      paramString = ct.a(paramArrayList);
      if (a(new co(paramInt, paramArrayList, paramString))) {
        a(new co(paramInt, paramArrayList, paramString));
      }
      return;
    }
    catch (JSONException paramArrayList) {}
  }
  
  private boolean a(co paramco)
  {
    if (cs.a(this.jdField_a_of_type_AndroidContentContext)) {
      return true;
    }
    b(paramco);
    return false;
  }
  
  private void b(co paramco)
  {
    this.d += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cacheCount: ");
    localStringBuilder.append(this.d);
    ct.a(localStringBuilder.toString());
    this.jdField_a_of_type_ComXiaomiPushCp.a(paramco);
    this.jdField_a_of_type_ComXiaomiPushCp.a();
  }
  
  public void a(cn paramcn)
  {
    if (paramcn.jdField_a_of_type_Long <= 0L) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramcn);
    a(localArrayList, "click", paramcn.jdField_a_of_type_Int);
  }
  
  public void a(Integer paramInteger, co paramco)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramco.jdField_b_of_type_JavaLangString))
    {
      if (paramInteger.intValue() != 0)
      {
        this.jdField_c_of_type_Int += 1;
        paramInteger = new StringBuilder();
        paramInteger.append("faild: ");
        paramInteger.append(this.jdField_c_of_type_Int);
        paramInteger.append(" ");
        paramInteger.append(paramco.jdField_b_of_type_JavaLangString);
        paramInteger.append("  ");
        paramInteger.append(this.jdField_a_of_type_JavaUtilHashMap.size());
        ct.a(paramInteger.toString());
        b(paramco);
      }
      else
      {
        this.jdField_a_of_type_Int += 1;
        paramInteger = new StringBuilder();
        paramInteger.append("success: ");
        paramInteger.append(this.jdField_a_of_type_Int);
        ct.a(paramInteger.toString());
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramco.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void b(cn paramcn)
  {
    if (paramcn.jdField_a_of_type_Long <= 0L) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramcn);
    a(localArrayList, "remove", paramcn.jdField_a_of_type_Int);
  }
  
  public void c(cn paramcn)
  {
    if (paramcn.jdField_a_of_type_Long <= 0L) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramcn);
    a(localArrayList, "received", paramcn.jdField_a_of_type_Int);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */