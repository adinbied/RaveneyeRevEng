package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.am.b;
import com.xiaomi.push.service.av;
import com.xiaomi.push.service.e;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class gt
{
  private static XmlPullParser a;
  
  public static gi a(String paramString1, String paramString2, XmlPullParser paramXmlPullParser)
  {
    paramString1 = gs.a().a("all", "xm:chat");
    if ((paramString1 != null) && ((paramString1 instanceof e))) {
      return ((e)paramString1).b(paramXmlPullParser);
    }
    return null;
  }
  
  public static gj a(XmlPullParser paramXmlPullParser, fu paramfu)
  {
    String str1 = paramXmlPullParser.getAttributeValue("", "id");
    String str2 = paramXmlPullParser.getAttributeValue("", "to");
    String str3 = paramXmlPullParser.getAttributeValue("", "from");
    String str4 = paramXmlPullParser.getAttributeValue("", "chid");
    gj.a locala = gj.a.a(paramXmlPullParser.getAttributeValue("", "type"));
    HashMap localHashMap = new HashMap();
    int j = 0;
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      localObject1 = paramXmlPullParser.getAttributeName(i);
      localHashMap.put(localObject1, paramXmlPullParser.getAttributeValue("", (String)localObject1));
      i += 1;
    }
    Object localObject1 = null;
    Object localObject2 = localObject1;
    i = j;
    while (i == 0)
    {
      j = paramXmlPullParser.next();
      if (j == 2)
      {
        String str5 = paramXmlPullParser.getName();
        String str6 = paramXmlPullParser.getNamespace();
        if (str5.equals("error"))
        {
          localObject2 = a(paramXmlPullParser);
        }
        else
        {
          localObject1 = new gj();
          ((gj)localObject1).a(a(str5, str6, paramXmlPullParser));
        }
      }
      else if ((j == 3) && (paramXmlPullParser.getName().equals("iq")))
      {
        i = 1;
      }
    }
    paramXmlPullParser = (XmlPullParser)localObject1;
    if (localObject1 == null) {
      if ((gj.a.a != locala) && (gj.a.b != locala))
      {
        paramXmlPullParser = new gv();
      }
      else
      {
        paramXmlPullParser = new gu();
        paramXmlPullParser.k(str1);
        paramXmlPullParser.m(str3);
        paramXmlPullParser.n(str2);
        paramXmlPullParser.a(gj.a.d);
        paramXmlPullParser.l(str4);
        paramXmlPullParser.a(new gp(gp.a.e));
        paramfu.a(paramXmlPullParser);
        b.d("iq usage error. send packet in packet parser.");
        return null;
      }
    }
    paramXmlPullParser.k(str1);
    paramXmlPullParser.m(str2);
    paramXmlPullParser.l(str4);
    paramXmlPullParser.n(str3);
    paramXmlPullParser.a(locala);
    paramXmlPullParser.a((gp)localObject2);
    paramXmlPullParser.a(localHashMap);
    return paramXmlPullParser;
  }
  
  public static gl a(XmlPullParser paramXmlPullParser)
  {
    bool = "1".equals(paramXmlPullParser.getAttributeValue("", "s"));
    j = 0;
    i = 0;
    localObject2 = null;
    if (bool)
    {
      str1 = paramXmlPullParser.getAttributeValue("", "chid");
      localObject3 = paramXmlPullParser.getAttributeValue("", "id");
      str2 = paramXmlPullParser.getAttributeValue("", "from");
      String str3 = paramXmlPullParser.getAttributeValue("", "to");
      String str4 = paramXmlPullParser.getAttributeValue("", "type");
      localObject2 = am.a().a(str1, str3);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = am.a().a(str1, str2);
      }
      if (localObject1 != null)
      {
        localObject2 = null;
        while (i == 0)
        {
          j = paramXmlPullParser.next();
          if (j == 2)
          {
            if ("s".equals(paramXmlPullParser.getName()))
            {
              if (paramXmlPullParser.next() == 4)
              {
                localObject2 = paramXmlPullParser.getText();
                if ((!"5".equals(str1)) && (!"6".equals(str1)))
                {
                  a(av.a(av.a(((am.b)localObject1).h, (String)localObject3), (String)localObject2));
                  a.next();
                  localObject2 = a(a);
                }
                else
                {
                  paramXmlPullParser = new gk();
                  paramXmlPullParser.l(str1);
                  paramXmlPullParser.b(true);
                  paramXmlPullParser.n(str2);
                  paramXmlPullParser.m(str3);
                  paramXmlPullParser.k((String)localObject3);
                  paramXmlPullParser.f(str4);
                  localObject1 = (String[])null;
                  localObject1 = new gi("s", null, (String[])localObject1, (String[])localObject1);
                  ((gi)localObject1).a((String)localObject2);
                  paramXmlPullParser.a((gi)localObject1);
                  return paramXmlPullParser;
                }
              }
              else
              {
                throw new gf("error while receiving a encrypted message with wrong format");
              }
            }
            else {
              throw new gf("error while receiving a encrypted message with wrong format");
            }
          }
          else if ((j == 3) && (paramXmlPullParser.getName().equals("message"))) {
            i = 1;
          }
        }
        if (localObject2 != null) {
          return (gl)localObject2;
        }
        throw new gf("error while receiving a encrypted message with wrong format");
      }
      throw new gf("the channel id is wrong while receiving a encrypted message");
    }
    localObject3 = new gk();
    str1 = paramXmlPullParser.getAttributeValue("", "id");
    localObject1 = str1;
    if (str1 == null) {
      localObject1 = "ID_NOT_AVAILABLE";
    }
    ((gk)localObject3).k((String)localObject1);
    ((gk)localObject3).m(paramXmlPullParser.getAttributeValue("", "to"));
    ((gk)localObject3).n(paramXmlPullParser.getAttributeValue("", "from"));
    ((gk)localObject3).l(paramXmlPullParser.getAttributeValue("", "chid"));
    ((gk)localObject3).a(paramXmlPullParser.getAttributeValue("", "appid"));
    try
    {
      localObject1 = paramXmlPullParser.getAttributeValue("", "transient");
    }
    catch (Exception localException3)
    {
      try
      {
        str1 = paramXmlPullParser.getAttributeValue("", "seq");
        if (TextUtils.isEmpty(str1)) {
          break label535;
        }
        ((gk)localObject3).b(str1);
      }
      catch (Exception localException3)
      {
        try
        {
          str1 = paramXmlPullParser.getAttributeValue("", "mseq");
          if (TextUtils.isEmpty(str1)) {
            break label562;
          }
          ((gk)localObject3).c(str1);
        }
        catch (Exception localException3)
        {
          try
          {
            for (;;)
            {
              str1 = paramXmlPullParser.getAttributeValue("", "fseq");
              if (!TextUtils.isEmpty(str1)) {
                ((gk)localObject3).d(str1);
              }
              try
              {
                str1 = paramXmlPullParser.getAttributeValue("", "status");
                if (!TextUtils.isEmpty(str1)) {
                  ((gk)localObject3).e(str1);
                }
              }
              catch (Exception localException5)
              {
                for (;;) {}
              }
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equalsIgnoreCase("true"))) {
                bool = true;
              } else {
                bool = false;
              }
              ((gk)localObject3).a(bool);
              ((gk)localObject3).f(paramXmlPullParser.getAttributeValue("", "type"));
              localObject1 = b(paramXmlPullParser);
              if ((localObject1 != null) && (!"".equals(((String)localObject1).trim())))
              {
                ((gk)localObject3).j((String)localObject1);
                i = j;
                localObject1 = localObject2;
              }
              else
              {
                gl.q();
                localObject1 = localObject2;
                i = j;
              }
              while (i == 0)
              {
                j = paramXmlPullParser.next();
                if (j == 2)
                {
                  str2 = paramXmlPullParser.getName();
                  str1 = paramXmlPullParser.getNamespace();
                  localObject2 = str1;
                  if (TextUtils.isEmpty(str1)) {
                    localObject2 = "xm";
                  }
                  if (str2.equals("subject"))
                  {
                    b(paramXmlPullParser);
                    ((gk)localObject3).g(a(paramXmlPullParser));
                    localObject2 = localObject1;
                  }
                  else if (str2.equals("body"))
                  {
                    localObject2 = paramXmlPullParser.getAttributeValue("", "encode");
                    str1 = a(paramXmlPullParser);
                    if (!TextUtils.isEmpty((CharSequence)localObject2))
                    {
                      ((gk)localObject3).a(str1, (String)localObject2);
                      localObject2 = localObject1;
                    }
                    else
                    {
                      ((gk)localObject3).h(str1);
                      localObject2 = localObject1;
                    }
                  }
                  else if (str2.equals("thread"))
                  {
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = paramXmlPullParser.nextText();
                    }
                  }
                  else if (str2.equals("error"))
                  {
                    ((gk)localObject3).a(a(paramXmlPullParser));
                    localObject2 = localObject1;
                  }
                  else
                  {
                    ((gk)localObject3).a(a(str2, (String)localObject2, paramXmlPullParser));
                    localObject2 = localObject1;
                  }
                  localObject1 = localObject2;
                }
                else if ((j == 3) && (paramXmlPullParser.getName().equals("message")))
                {
                  i = 1;
                }
              }
              ((gk)localObject3).i((String)localObject1);
              return (gl)localObject3;
              localException1 = localException1;
              continue;
              localException2 = localException2;
              continue;
              localException3 = localException3;
            }
          }
          catch (Exception localException4)
          {
            for (;;) {}
          }
        }
      }
    }
    localObject1 = null;
  }
  
  public static gn a(XmlPullParser paramXmlPullParser)
  {
    Object localObject2 = gn.b.a;
    Object localObject3 = paramXmlPullParser.getAttributeValue("", "type");
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject3).equals("")) {}
    }
    try
    {
      localObject1 = gn.b.valueOf((String)localObject3);
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      StringBuilder localStringBuilder;
      int i;
      for (;;) {}
    }
    localObject1 = System.err;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Found invalid presence type ");
    localStringBuilder.append((String)localObject3);
    ((PrintStream)localObject1).println(localStringBuilder.toString());
    localObject1 = localObject2;
    localObject3 = new gn((gn.b)localObject1);
    ((gn)localObject3).m(paramXmlPullParser.getAttributeValue("", "to"));
    ((gn)localObject3).n(paramXmlPullParser.getAttributeValue("", "from"));
    ((gn)localObject3).l(paramXmlPullParser.getAttributeValue("", "chid"));
    localObject2 = paramXmlPullParser.getAttributeValue("", "id");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "ID_NOT_AVAILABLE";
    }
    ((gn)localObject3).k((String)localObject1);
    i = 0;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        localObject2 = paramXmlPullParser.getNamespace();
        if (((String)localObject1).equals("status"))
        {
          ((gn)localObject3).a(paramXmlPullParser.nextText());
          continue;
        }
        if (!((String)localObject1).equals("priority")) {}
      }
      try
      {
        ((gn)localObject3).a(Integer.parseInt(paramXmlPullParser.nextText()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        for (;;) {}
      }
      ((gn)localObject3).a(0);
      continue;
      continue;
      if (((String)localObject1).equals("show")) {
        localObject1 = paramXmlPullParser.nextText();
      }
      try
      {
        ((gn)localObject3).a(gn.a.valueOf((String)localObject1));
      }
      catch (IllegalArgumentException localIllegalArgumentException3)
      {
        for (;;) {}
      }
      localObject2 = System.err;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Found invalid presence mode ");
      localStringBuilder.append((String)localObject1);
      ((PrintStream)localObject2).println(localStringBuilder.toString());
      continue;
      if (((String)localObject1).equals("error"))
      {
        ((gn)localObject3).a(a(paramXmlPullParser));
      }
      else
      {
        ((gn)localObject3).a(a((String)localObject1, (String)localObject2, paramXmlPullParser));
        continue;
        if ((j == 3) && (paramXmlPullParser.getName().equals("presence"))) {
          i = 1;
        }
      }
    }
    return (gn)localObject3;
  }
  
  public static go a(XmlPullParser paramXmlPullParser)
  {
    go localgo = null;
    int i = 0;
    while (i == 0)
    {
      int j = paramXmlPullParser.next();
      if (j == 2) {
        localgo = new go(paramXmlPullParser.getName());
      } else if ((j == 3) && (paramXmlPullParser.getName().equals("error"))) {
        i = 1;
      }
    }
    return localgo;
  }
  
  public static gp a(XmlPullParser paramXmlPullParser)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    String str3 = "-1";
    String str2 = null;
    String str1 = str2;
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      if (paramXmlPullParser.getAttributeName(i).equals("code")) {
        str3 = paramXmlPullParser.getAttributeValue("", "code");
      }
      if (paramXmlPullParser.getAttributeName(i).equals("type")) {
        str1 = paramXmlPullParser.getAttributeValue("", "type");
      }
      if (paramXmlPullParser.getAttributeName(i).equals("reason")) {
        str2 = paramXmlPullParser.getAttributeValue("", "reason");
      }
      i += 1;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    i = j;
    while (i == 0)
    {
      j = paramXmlPullParser.next();
      if (j == 2)
      {
        if (paramXmlPullParser.getName().equals("text"))
        {
          localObject1 = paramXmlPullParser.nextText();
        }
        else
        {
          String str4 = paramXmlPullParser.getName();
          String str5 = paramXmlPullParser.getNamespace();
          if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(str5)) {
            localObject2 = str4;
          } else {
            localArrayList.add(a(str4, str5, paramXmlPullParser));
          }
        }
      }
      else if (j == 3)
      {
        if (paramXmlPullParser.getName().equals("error")) {
          i = 1;
        }
      }
      else if (j == 4) {
        localObject1 = paramXmlPullParser.getText();
      }
    }
    if (str1 == null) {
      str1 = "cancel";
    }
    return new gp(Integer.parseInt(str3), str1, str2, (String)localObject2, (String)localObject1, localArrayList);
  }
  
  private static String a(XmlPullParser paramXmlPullParser)
  {
    int i = paramXmlPullParser.getDepth();
    StringBuilder localStringBuilder;
    for (String str = "";; str = localStringBuilder.toString())
    {
      if ((paramXmlPullParser.next() == 3) && (paramXmlPullParser.getDepth() == i)) {
        return str;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(paramXmlPullParser.getText());
    }
  }
  
  private static void a(byte[] paramArrayOfByte)
  {
    if (a == null) {
      try
      {
        XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
        a = localXmlPullParser;
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      }
      catch (XmlPullParserException localXmlPullParserException)
      {
        localXmlPullParserException.printStackTrace();
      }
    }
    a.setInput(new InputStreamReader(new ByteArrayInputStream(paramArrayOfByte)));
  }
  
  private static String b(XmlPullParser paramXmlPullParser)
  {
    int i = 0;
    while (i < paramXmlPullParser.getAttributeCount())
    {
      String str = paramXmlPullParser.getAttributeName(i);
      if ((!"xml:lang".equals(str)) && ((!"lang".equals(str)) || (!"xml".equals(paramXmlPullParser.getAttributePrefix(i))))) {
        i += 1;
      } else {
        return paramXmlPullParser.getAttributeValue(i);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */