package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.miui.pushads.sdk.f;
import com.xiaomi.miui.pushads.sdk.k.a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

class cs
{
  public static int a(String paramString1, String paramString2, co paramco)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(new BasicNameValuePair("logValue", paramco.jdField_a_of_type_JavaLangString));
    localLinkedList.add(new BasicNameValuePair("appId", paramString1));
    paramString1 = new StringBuilder();
    paramString1.append(paramco.jdField_a_of_type_Int);
    paramString1.append("");
    localLinkedList.add(new BasicNameValuePair("showType", paramString1.toString()));
    localLinkedList.add(new BasicNameValuePair("s", ct.a(localLinkedList, paramString2)));
    try
    {
      paramString1 = new HttpPost("http://new.api.ad.xiaomi.com/logNotificationAdActions");
      paramString1.setEntity(new UrlEncodedFormEntity(localLinkedList, "UTF-8"));
      int i = new DefaultHttpClient().execute(paramString1).getStatusLine().getStatusCode();
      if (200 == i) {
        return 0;
      }
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (ClientProtocolException paramString1)
    {
      paramString1.printStackTrace();
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return 1;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = f.a(paramContext);
    return k.a.a != paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */