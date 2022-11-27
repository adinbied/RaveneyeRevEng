package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;

class ap
  implements ar
{
  private static boolean jdField_a_of_type_Boolean;
  private volatile int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private ServiceConnection jdField_a_of_type_AndroidContentServiceConnection;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile String jdField_a_of_type_JavaLangString = null;
  private volatile String jdField_b_of_type_JavaLangString = null;
  private volatile boolean jdField_b_of_type_Boolean = false;
  
  public ap(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private static String a(Context paramContext)
  {
    localObject = null;
    for (;;)
    {
      try
      {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24)
        {
          String str = paramContext.createDeviceProtectedStorageContext().getSharedPreferences("aaid", 0).getString("aaid", null);
          localObject = str;
          if (str != null) {
            return str;
          }
        }
        else
        {
          localObject = null;
        }
      }
      catch (Exception paramContext)
      {
        paramContext = (Context)localObject;
        continue;
      }
      try
      {
        paramContext = paramContext.getSharedPreferences("aaid", 0).getString("aaid", null);
      }
      catch (Exception paramContext) {}
    }
    paramContext = (Context)localObject;
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "";
    }
    return (String)localObject;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void a(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
        if ((paramContext.applicationInfo.flags & 0x1) != 0)
        {
          i = 1;
          if (paramContext.versionCode < 20602000) {
            break label64;
          }
          bool = true;
          jdField_a_of_type_Boolean = bool;
          return i != 0;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      int i = 0;
      continue;
      label64:
      boolean bool = false;
    }
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public String a()
  {
    return null;
  }
  
  public boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public String b()
  {
    a("getOAID");
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String c()
  {
    return null;
  }
  
  public String d()
  {
    return null;
  }
  
  private class a
    implements ServiceConnection
  {
    private a() {}
    
    /* Error */
    public void onServiceConnected(ComponentName arg1, IBinder arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName) {}
  }
  
  private static class b
  {
    static String a(IBinder paramIBinder)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        paramIBinder.transact(1, localParcel1, localParcel2, 0);
        localParcel2.readException();
        paramIBinder = localParcel2.readString();
        return paramIBinder;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
    
    static boolean a(IBinder paramIBinder)
    {
      Parcel localParcel1 = Parcel.obtain();
      Parcel localParcel2 = Parcel.obtain();
      try
      {
        localParcel1.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
        boolean bool = false;
        paramIBinder.transact(2, localParcel1, localParcel2, 0);
        localParcel2.readException();
        int i = localParcel2.readInt();
        if (i != 0) {
          bool = true;
        }
        return bool;
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */