package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class am
{
  private static volatile am jdField_a_of_type_ComXiaomiMipushSdkAm;
  private Context jdField_a_of_type_AndroidContentContext;
  private List<z> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  private am(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentContext = localContext;
    if (localContext == null) {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
    }
  }
  
  public static am a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiMipushSdkAm == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiMipushSdkAm == null) {
          jdField_a_of_type_ComXiaomiMipushSdkAm = new am(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiMipushSdkAm;
  }
  
  public int a(String paramString)
  {
    return 0;
  }
  
  public String a(bb parambb)
  {
    return null;
  }
  
  /* Error */
  public void a(bb arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean a(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void b(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void c(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */