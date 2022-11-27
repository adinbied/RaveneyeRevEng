package com.xiaomi.push;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class fq
{
  private XmlPullParser a;
  
  fq()
  {
    try
    {
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      this.a = localXmlPullParser;
      localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException) {}
  }
  
  gl a(byte[] paramArrayOfByte, fu paramfu)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */