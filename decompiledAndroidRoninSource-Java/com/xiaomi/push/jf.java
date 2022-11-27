package com.xiaomi.push;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class jf
{
  private jk jdField_a_of_type_ComXiaomiPushJk;
  private final jr jdField_a_of_type_ComXiaomiPushJr;
  private final ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  
  public jf()
  {
    this(new jg.a());
  }
  
  public jf(jm paramjm)
  {
    Object localObject = new ByteArrayOutputStream();
    this.jdField_a_of_type_JavaIoByteArrayOutputStream = ((ByteArrayOutputStream)localObject);
    localObject = new jr((OutputStream)localObject);
    this.jdField_a_of_type_ComXiaomiPushJr = ((jr)localObject);
    this.jdField_a_of_type_ComXiaomiPushJk = paramjm.a((ju)localObject);
  }
  
  public byte[] a(iz paramiz)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */