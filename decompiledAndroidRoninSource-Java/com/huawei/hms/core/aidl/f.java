package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

public class f
{
  private Bundle a(String paramString, Bundle paramBundle, Object paramObject)
  {
    return null;
  }
  
  private Object a(Field paramField, Bundle paramBundle)
  {
    return null;
  }
  
  /* Error */
  private void a(IMessageEntity arg1, Field arg2, Bundle arg3)
    throws IllegalAccessException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void b(IMessageEntity arg1, Field arg2, Bundle arg3)
    throws IllegalAccessException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean b(String paramString, Object paramObject, Bundle paramBundle)
  {
    return false;
  }
  
  public Bundle a(IMessageEntity paramIMessageEntity, Bundle paramBundle)
  {
    return null;
  }
  
  public IMessageEntity a(Bundle paramBundle, IMessageEntity paramIMessageEntity)
  {
    return null;
  }
  
  protected List<Object> a(Type paramType, Bundle paramBundle)
    throws InstantiationException, IllegalAccessException
  {
    return null;
  }
  
  /* Error */
  protected void a(String arg1, Object arg2, Bundle arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void a(String arg1, List arg2, Bundle arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\core\aidl\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */