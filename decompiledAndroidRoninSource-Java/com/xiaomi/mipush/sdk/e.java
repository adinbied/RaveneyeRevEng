package com.xiaomi.mipush.sdk;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class e
  implements AbstractPushManager
{
  private static volatile e jdField_a_of_type_ComXiaomiMipushSdkE;
  private Context jdField_a_of_type_AndroidContentContext;
  private PushConfiguration jdField_a_of_type_ComXiaomiMipushSdkPushConfiguration;
  private Map<d, AbstractPushManager> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  
  private e(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
  }
  
  public static e a(Context paramContext)
  {
    if (jdField_a_of_type_ComXiaomiMipushSdkE == null) {
      try
      {
        if (jdField_a_of_type_ComXiaomiMipushSdkE == null) {
          jdField_a_of_type_ComXiaomiMipushSdkE = new e(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComXiaomiMipushSdkE;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public AbstractPushManager a(d paramd)
  {
    return null;
  }
  
  /* Error */
  public void a(PushConfiguration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void a(d paramd)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramd);
  }
  
  /* Error */
  public void a(d arg1, AbstractPushManager arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean a(d paramd)
  {
    return this.jdField_a_of_type_JavaUtilMap.containsKey(paramd);
  }
  
  public boolean b(d paramd)
  {
    return false;
  }
  
  /* Error */
  public void register()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void unregister()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */