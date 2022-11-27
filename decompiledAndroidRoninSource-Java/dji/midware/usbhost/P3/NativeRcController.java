package dji.midware.usbhost.P3;

import android.os.Build;
import android.view.Surface;
import dji.log.RoninLog;
import dji.midware.data.config.Dpad.DpadProductType;
import dji.midware.data.manager.Dpad.DpadProductManager;

public class NativeRcController
{
  static boolean loadSOOK = false;
  
  static
  {
    boolean bool;
    if (DpadProductManager.getInstance().getProductType() == DpadProductType.Pomato) {
      bool = true;
    } else {
      bool = false;
    }
    loadSOOK = bool;
    try
    {
      RoninLog.d("NativeRcController", "x try to load libusbdec.so", new Object[0]);
      System.loadLibrary("usbdec");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;) {}
    }
    RoninLog.e("NativeRcController", "Couldn't load libusbdec.so", new Object[0]);
  }
  
  public static boolean getIsP4pPAD()
  {
    return (loadSOOK) && ("gl300e".equals(Build.PRODUCT.toLowerCase()));
  }
  
  public static void loadLibrary() {}
  
  public static native void native_rc_exit();
  
  public static native void native_rc_init();
  
  public static native int native_rc_sendto_serial(byte[] paramArrayOfByte, int paramInt);
  
  public static native int native_rc_setIframe(byte[] paramArrayOfByte, int paramInt);
  
  public static native int native_rc_setPrdType(int paramInt);
  
  public static native int native_rc_set_cb_obj(Object paramObject);
  
  public static native int native_rc_set_iep(int paramInt1, int paramInt2);
  
  public static native int native_rc_set_sre(int paramInt);
  
  public static native void native_rc_start_dec(Surface paramSurface);
  
  public static native int native_rc_stop_dec();
  
  public static void rc_exit()
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_exit();
  }
  
  public static void rc_init()
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_init();
  }
  
  public static void rc_sendto_serial(byte[] paramArrayOfByte, int paramInt)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_sendto_serial(paramArrayOfByte, paramInt);
  }
  
  public static void rc_setIframe(byte[] paramArrayOfByte, int paramInt)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_setIframe(paramArrayOfByte, paramInt);
  }
  
  public static void rc_setPrdType(int paramInt)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_setPrdType(paramInt);
  }
  
  public static void rc_set_cb_obj(Object paramObject)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_set_cb_obj(paramObject);
  }
  
  public static void rc_set_iep(int paramInt1, int paramInt2)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_set_iep(paramInt1, paramInt2);
  }
  
  public static void rc_set_sre(int paramInt)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_set_sre(paramInt);
  }
  
  public static void rc_start_dec(Surface paramSurface)
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_start_dec(paramSurface);
  }
  
  public static void rc_stop_dec()
  {
    if (!loadSOOK) {
      return;
    }
    native_rc_stop_dec();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\usbhost\P3\NativeRcController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */