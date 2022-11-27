package dji.thirdparty.afinal.bitmap.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;

public class BitmapDecoder
{
  private static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    if ((j <= paramInt2) && (k <= paramInt1)) {
      return 1;
    }
    int i;
    if (k > j) {
      i = Math.round(j / paramInt2);
    } else {
      i = Math.round(k / paramInt1);
    }
    float f1 = k * j;
    float f2 = paramInt1 * paramInt2 * 2;
    while (f1 / (i * i) > f2) {
      i += 1;
    }
    return i;
  }
  
  public static Bitmap decodeSampledBitmapFromByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt3, paramInt4);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
  }
  
  public static Bitmap decodeSampledBitmapFromDescriptor(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
      return paramFileDescriptor;
    }
    catch (OutOfMemoryError paramFileDescriptor)
    {
      paramFileDescriptor.printStackTrace();
    }
    return null;
  }
  
  public static Bitmap decodeSampledBitmapFromResource(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPurgeable = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt2, paramInt3);
    localOptions.inJustDecodeBounds = false;
    try
    {
      paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
      return paramResources;
    }
    catch (OutOfMemoryError paramResources)
    {
      paramResources.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\bitmap\core\BitmapDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */