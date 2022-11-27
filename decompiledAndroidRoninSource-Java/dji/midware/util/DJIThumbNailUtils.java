package dji.midware.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import dji.log.DJILogHelper;
import dji.midware.natives.GroudStation;
import dji.midware.natives.Vision;
import dji.thirdparty.sanselan.ImageReadException;
import dji.thirdparty.sanselan.Sanselan;
import dji.thirdparty.sanselan.formats.tiff.TiffField;
import dji.thirdparty.sanselan.formats.tiff.TiffImageMetadata;
import dji.thirdparty.sanselan.formats.tiff.constants.TiffConstants;
import java.io.File;
import java.io.IOException;

public class DJIThumbNailUtils
{
  public static Bitmap covertTIFtoJPG(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      Object localObject = (TiffImageMetadata)Sanselan.getMetadata(arrayOfByte);
      paramArrayOfByte = ((TiffImageMetadata)localObject).findField(TiffConstants.EXIF_TAG_IMAGE_WIDTH_IFD0);
      TiffField localTiffField1 = ((TiffImageMetadata)localObject).findField(TiffConstants.EXIF_TAG_IMAGE_HEIGHT_IFD0);
      TiffField localTiffField2 = ((TiffImageMetadata)localObject).findField(TiffConstants.EXIF_TAG_PREVIEW_IMAGE_START_IFD0);
      TiffField localTiffField3 = ((TiffImageMetadata)localObject).findField(TiffConstants.EXIF_TAG_PREVIEW_IMAGE_LENGTH_IFD0);
      paramInt1 = ((TiffImageMetadata)localObject).findField(TiffConstants.EXIF_TAG_BITS_PER_SAMPLE).getIntValue() / 8;
      paramInt2 = localTiffField3.getIntValue();
      localObject = new int[paramInt2 / paramInt1];
      normalized(arrayOfByte, localTiffField2.getIntValue(), paramInt2, paramInt1, (int[])localObject);
      paramArrayOfByte = Bitmap.createBitmap((int[])localObject, paramArrayOfByte.getIntValue(), localTiffField1.getIntValue(), Bitmap.Config.ARGB_8888);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    catch (ImageReadException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  private static Bitmap cropBitmap(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = i * 9 / 16;
    return Bitmap.createBitmap(paramBitmap, 0, (j - k) / 2, i, k, null, false);
  }
  
  public static Bitmap getBokeh(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    localOptions.inSampleSize = 1;
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
  }
  
  public static Bitmap getBokehYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getPath());
    ((StringBuilder)localObject).append("/tmp.jpg");
    localObject = ((StringBuilder)localObject).toString();
    Vision.decodeYUV420SP(paramArrayOfByte, paramInt1, paramInt2, (String)localObject);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    paramArrayOfByte = null;
    try
    {
      if (new File((String)localObject).exists())
      {
        localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        paramArrayOfByte = BitmapFactory.decodeFile((String)localObject);
      }
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static Bitmap getThumbNail(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inSampleSize = 1;
    return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, localOptions);
  }
  
  public static Bitmap getThumbNailDNG(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 + 4;
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if (((j != 0) && (k != 0)) || (i1 + 18 >= paramInt2 - paramInt1))
    {
      if (j != 0)
      {
        if (k == 0) {
          return null;
        }
        paramInt1 += m;
        if (i <= 0) {
          return null;
        }
        if (paramInt1 + i > paramInt2) {
          return null;
        }
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localOptions.inSampleSize = 1;
        return BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, i, localOptions);
      }
      return null;
    }
    int n = BytesUtil.getInt(paramArrayOfByte, i1) + paramInt1;
    int i7 = BytesUtil.getUShort(paramArrayOfByte, n);
    n += 2;
    int i2 = 0;
    int i6 = i;
    int i4 = m;
    int i3 = k;
    int i5 = j;
    for (;;)
    {
      i1 = n;
      j = i5;
      k = i3;
      m = i4;
      i = i6;
      if (i2 >= i7) {
        break;
      }
      int i8 = BytesUtil.getUShort(paramArrayOfByte, n);
      i = n + 2;
      BytesUtil.getUShort(paramArrayOfByte, i);
      i += 2;
      BytesUtil.getInt(paramArrayOfByte, i);
      i += 4;
      i1 = BytesUtil.getInt(paramArrayOfByte, i);
      n = i + 4;
      if (i8 == 273)
      {
        m = i1;
        k = 1;
        j = i5;
        i = i6;
      }
      else
      {
        j = i5;
        k = i3;
        m = i4;
        i = i6;
        if (i8 == 279)
        {
          i = i1;
          j = 1;
          m = i4;
          k = i3;
        }
      }
      if ((j != 0) && (k != 0))
      {
        i1 = n;
        break;
      }
      i2 += 1;
      i5 = j;
      i3 = k;
      i4 = m;
      i6 = i;
    }
  }
  
  public static Bitmap getThumbNailJPEG(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = BytesUtil.getUShort(paramArrayOfByte, paramInt1);
    paramInt1 += 2;
    if (i != 55551) {
      return null;
    }
    do
    {
      i = paramInt1;
      if (paramInt1 >= paramArrayOfByte.length) {
        break;
      }
      j = BytesUtil.getUShort(paramArrayOfByte, paramInt1);
      i = paramInt1 + 2;
      paramInt1 = BytesUtil.getUShort(paramArrayOfByte, i);
      i += 2;
      if (j == 57855) {
        break;
      }
      paramInt1 = i + paramInt1;
      i = BytesUtil.getUShort(paramArrayOfByte, paramInt1);
      paramInt1 += 2;
    } while (55807 != i);
    return null;
    paramInt1 = BytesUtil.getUShort(paramArrayOfByte, i);
    int j = i + 2;
    i = BytesUtil.getUShort(paramArrayOfByte, j);
    int k = j + 2;
    j = BytesUtil.getUShort(paramArrayOfByte, k);
    int i6 = k + 2;
    if (paramInt1 != 30789) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    }
    if (i != 26217) {
      i = 1;
    } else {
      i = 0;
    }
    if (j != 0) {
      j = 1;
    } else {
      j = 0;
    }
    if ((paramInt1 | i | j) != 0) {
      return null;
    }
    int n = i6 + 4;
    i = 0;
    j = 0;
    k = 0;
    paramInt1 = 0;
    if ((i != 0) && (j != 0))
    {
      i = i6 + k;
      if (paramInt1 <= 0) {
        return null;
      }
      if (i + paramInt1 > paramInt2) {
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      localOptions.inSampleSize = 1;
      return BitmapFactory.decodeByteArray(paramArrayOfByte, i, paramInt1, localOptions);
    }
    int m = BytesUtil.getInt(paramArrayOfByte, n) + i6;
    int i7 = BytesUtil.getUShort(paramArrayOfByte, m);
    m += 2;
    int i1 = 0;
    int i5 = paramInt1;
    int i3 = k;
    int i2 = j;
    int i4 = i;
    for (;;)
    {
      n = m;
      i = i4;
      j = i2;
      k = i3;
      paramInt1 = i5;
      if (i1 >= i7) {
        break;
      }
      int i8 = BytesUtil.getUShort(paramArrayOfByte, m);
      paramInt1 = m + 2;
      BytesUtil.getUShort(paramArrayOfByte, paramInt1);
      paramInt1 += 2;
      BytesUtil.getInt(paramArrayOfByte, paramInt1);
      paramInt1 += 4;
      n = BytesUtil.getInt(paramArrayOfByte, paramInt1);
      m = paramInt1 + 4;
      if (i8 == 513)
      {
        k = n;
        j = 1;
        i = i4;
        paramInt1 = i5;
      }
      else
      {
        i = i4;
        j = i2;
        k = i3;
        paramInt1 = i5;
        if (i8 == 514)
        {
          paramInt1 = n;
          i = 1;
          k = i3;
          j = i2;
        }
      }
      if ((i != 0) && (j != 0))
      {
        n = m;
        break;
      }
      i1 += 1;
      i4 = i;
      i2 = j;
      i3 = k;
      i5 = paramInt1;
    }
  }
  
  public static Bitmap getThumbNailThm(byte[] paramArrayOfByte)
  {
    DJILogHelper localDJILogHelper = DJILogHelper.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer size:");
    localStringBuilder.append(paramArrayOfByte.length);
    localDJILogHelper.LOGE("thumbnail", localStringBuilder.toString());
    return cropBitmap(Bitmap.createBitmap(GroudStation.native_yuv422ToImage(paramArrayOfByte, 160, 120), 160, 120, Bitmap.Config.ARGB_8888));
  }
  
  private static void normalized(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt)
  {
    int n = 0;
    int j = 100000;
    int i = paramInt1;
    int k = 0;
    while (i < paramInt2 + paramInt1)
    {
      int i1 = (i - paramInt1) / paramInt3;
      int m = 0;
      while (m < paramInt3)
      {
        paramArrayOfInt[i1] += ((paramArrayOfByte[(i + m)] & 0xFF) << m * 8);
        m += 1;
      }
      if (j >= paramArrayOfInt[i1]) {
        j = paramArrayOfInt[i1];
      }
      if (k <= paramArrayOfInt[i1]) {
        k = paramArrayOfInt[i1];
      }
      i += paramInt3;
    }
    float f = (k - j) * 1.0F / 256.0F;
    paramInt1 = n;
    while (paramInt1 < paramArrayOfInt.length)
    {
      paramArrayOfInt[paramInt1] = Math.round((paramArrayOfInt[paramInt1] - j) / f);
      paramArrayOfInt[paramInt1] = (paramArrayOfInt[paramInt1] | paramArrayOfInt[paramInt1] << 8 | paramArrayOfInt[paramInt1] << 16 | 0xFF000000);
      paramInt1 += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DJIThumbNailUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */