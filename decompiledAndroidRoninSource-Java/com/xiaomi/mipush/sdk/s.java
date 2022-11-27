package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

public class s
{
  private static volatile s jdField_a_of_type_ComXiaomiMipushSdkS;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private Context jdField_a_of_type_AndroidContentContext;
  
  private s(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static s a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiMipushSdkS == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiMipushSdkS == null) {
          jdField_a_of_type_ComXiaomiMipushSdkS = new s(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiMipushSdkS;
  }
  
  private File a(String paramString)
  {
    return null;
  }
  
  public String a(File paramFile)
  {
    return null;
  }
  
  public ArrayList<File> a()
  {
    return null;
  }
  
  /* Error */
  public void a(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */