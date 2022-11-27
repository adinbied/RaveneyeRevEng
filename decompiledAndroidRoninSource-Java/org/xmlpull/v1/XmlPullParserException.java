package org.xmlpull.v1;

import java.io.PrintStream;

public class XmlPullParserException
  extends Exception
{
  protected int column = -1;
  protected Throwable detail;
  protected int row = -1;
  
  public XmlPullParserException(String paramString)
  {
    super(paramString);
  }
  
  public XmlPullParserException(String paramString, XmlPullParser paramXmlPullParser, Throwable paramThrowable)
  {
    super(localStringBuffer1.toString());
    if (paramXmlPullParser != null)
    {
      this.row = paramXmlPullParser.getLineNumber();
      this.column = paramXmlPullParser.getColumnNumber();
    }
    this.detail = paramThrowable;
  }
  
  public int getColumnNumber()
  {
    return this.column;
  }
  
  public Throwable getDetail()
  {
    return this.detail;
  }
  
  public int getLineNumber()
  {
    return this.row;
  }
  
  public void printStackTrace()
  {
    if (this.detail == null)
    {
      super.printStackTrace();
      return;
    }
    synchronized (System.err)
    {
      PrintStream localPrintStream2 = System.err;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(super.getMessage());
      localStringBuffer.append("; nested exception is:");
      localPrintStream2.println(localStringBuffer.toString());
      this.detail.printStackTrace();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\xmlpull\v1\XmlPullParserException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */