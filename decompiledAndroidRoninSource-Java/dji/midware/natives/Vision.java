package dji.midware.natives;

import android.graphics.Bitmap;
import dji.log.RoninLog;

public class Vision
{
  static
  {
    try
    {
      System.loadLibrary("Vision");
      RoninLog.d(Vision.class.getName(), "load lib suc", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      RoninLog.d(Vision.class.getName(), "Couldn't load lib", new Object[0]);
    }
  }
  
  public static native void HDBokeh(Bitmap paramBitmap);
  
  public static native void decodeYUV420SP(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString);
  
  public static native int getDenseDepth(Bitmap paramBitmap, Bitmap[] paramArrayOfBitmap, String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native void initCallback();
  
  public static void loadLibrary() {}
  
  public static native void pano1x3(String[] paramArrayOfString, float[] paramArrayOfFloat, String paramString);
  
  public static native void pano3x3(String[] paramArrayOfString, float[] paramArrayOfFloat, String paramString);
  
  public static native int poseFromImages(Bitmap[] paramArrayOfBitmap, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public static native int[] render(String paramString, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, int paramInt2, double paramDouble);
  
  public static native void saveResult(String paramString);
  
  public static native void setParams(int paramInt1, int paramInt2, float paramFloat1, int paramInt3, int paramInt4, float paramFloat2, float paramFloat3);
  
  public static native void test();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\Vision.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */