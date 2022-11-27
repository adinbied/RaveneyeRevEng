package com.facebook.imagepipeline.nativecode;

import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class NativeImageTranscoderFactory
{
  public static ImageTranscoderFactory getNativeImageTranscoderFactory(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      ImageTranscoderFactory localImageTranscoderFactory = (ImageTranscoderFactory)Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory").getConstructor(new Class[] { Integer.TYPE, Boolean.TYPE, Boolean.TYPE }).newInstance(new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return localImageTranscoderFactory;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}catch (SecurityException localSecurityException) {}catch (NoSuchMethodException localNoSuchMethodException) {}
    throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", localNoSuchMethodException);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeImageTranscoderFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */