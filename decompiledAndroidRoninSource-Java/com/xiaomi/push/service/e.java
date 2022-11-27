package com.xiaomi.push.service;

import com.xiaomi.push.gi;
import com.xiaomi.push.gr;
import com.xiaomi.push.gw;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class e
  implements gr
{
  public static gi a(XmlPullParser paramXmlPullParser)
  {
    if (paramXmlPullParser.getEventType() != 2) {
      return null;
    }
    String str1 = paramXmlPullParser.getName();
    String str2 = paramXmlPullParser.getNamespace();
    Object localObject3;
    Object localObject4;
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject5;
    if (paramXmlPullParser.getAttributeCount() > 0)
    {
      localObject3 = new String[paramXmlPullParser.getAttributeCount()];
      localObject4 = new String[paramXmlPullParser.getAttributeCount()];
      i = 0;
      while (i < paramXmlPullParser.getAttributeCount())
      {
        localObject3[i] = paramXmlPullParser.getAttributeName(i);
        localObject4[i] = gw.b(paramXmlPullParser.getAttributeValue(i));
        i += 1;
      }
      localObject1 = null;
      localObject2 = localObject1;
    }
    else
    {
      localObject5 = null;
      localObject3 = localObject5;
      localObject1 = localObject3;
      localObject2 = localObject1;
      localObject4 = localObject3;
      localObject3 = localObject5;
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      if (i == 3) {
        break;
      }
      if (i == 4)
      {
        localObject1 = paramXmlPullParser.getText().trim();
      }
      else if (i == 2)
      {
        localObject5 = localObject2;
        if (localObject2 == null) {
          localObject5 = new ArrayList();
        }
        gi localgi = a(paramXmlPullParser);
        localObject2 = localObject5;
        if (localgi != null)
        {
          ((List)localObject5).add(localgi);
          localObject2 = localObject5;
        }
      }
    }
    return new gi(str1, str2, (String[])localObject3, (String[])localObject4, (String)localObject1, (List)localObject2);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public gi b(XmlPullParser paramXmlPullParser)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\service\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */