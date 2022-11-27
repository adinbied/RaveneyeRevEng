package com.facebook.imagepipeline.nativecode;

public class NativeJpegTranscoderSoLoader
{
  private static boolean sInitialized;
  
  /* Error */
  public static void ensure()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/facebook/imagepipeline/nativecode/NativeJpegTranscoderSoLoader:sInitialized	Z
    //   6: ifne +30 -> 36
    //   9: getstatic 22	android/os/Build$VERSION:SDK_INT	I
    //   12: istore_0
    //   13: iload_0
    //   14: bipush 16
    //   16: if_icmpgt +10 -> 26
    //   19: ldc 24
    //   21: iconst_1
    //   22: invokestatic 30	com/facebook/soloader/nativeloader/NativeLoader:loadLibrary	(Ljava/lang/String;I)Z
    //   25: pop
    //   26: ldc 32
    //   28: invokestatic 35	com/facebook/soloader/nativeloader/NativeLoader:loadLibrary	(Ljava/lang/String;)Z
    //   31: pop
    //   32: iconst_1
    //   33: putstatic 16	com/facebook/imagepipeline/nativecode/NativeJpegTranscoderSoLoader:sInitialized	Z
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: astore_1
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: goto -21 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	5	0	i	int
    //   40	5	1	localObject	Object
    //   46	1	1	localUnsatisfiedLinkError	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   3	13	40	finally
    //   19	26	40	finally
    //   26	36	40	finally
    //   19	26	46	java/lang/UnsatisfiedLinkError
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeJpegTranscoderSoLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */