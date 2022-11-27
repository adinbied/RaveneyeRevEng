package dji.utils;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImageUtils
{
  public static byte[] bitmap2Bytes(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static Drawable bitmap2Drawable(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapDrawable(AppUtils.getApp().getResources(), paramBitmap);
  }
  
  public static Bitmap bytes2Bitmap(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  public static Drawable bytes2Drawable(byte[] paramArrayOfByte)
  {
    return bitmap2Drawable(bytes2Bitmap(paramArrayOfByte));
  }
  
  private static int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = paramOptions.outHeight;
    int k = paramOptions.outWidth;
    int i = 1;
    for (;;)
    {
      k >>= 1;
      if (k < paramInt1) {
        break;
      }
      j >>= 1;
      if (j < paramInt2) {
        break;
      }
      i <<= 1;
    }
    return i;
  }
  
  public static Bitmap createAppropriateBmp(String paramString, int paramInt1, int paramInt2)
  {
    Log.d("createFitBmp", "executed");
    if ((!TextUtils.isEmpty(paramString)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      if ((localOptions.outWidth <= paramInt1) && (localOptions.outHeight <= paramInt2))
      {
        localOptions.inSampleSize = 1;
      }
      else
      {
        int i = Math.round(localOptions.outWidth * 1.0F / paramInt1);
        paramInt2 = Math.round(localOptions.outHeight * 1.0F / paramInt2);
        paramInt1 = i;
        if (i < paramInt2) {
          paramInt1 = paramInt2;
        }
        localOptions.inSampleSize = paramInt1;
      }
      localOptions.inJustDecodeBounds = false;
      return BitmapFactory.decodeFile(paramString, localOptions);
    }
    return null;
  }
  
  public static Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      if (((BitmapDrawable)localObject).getBitmap() != null) {
        return ((BitmapDrawable)localObject).getBitmap();
      }
    }
    if ((paramDrawable.getIntrinsicWidth() > 0) && (paramDrawable.getIntrinsicHeight() > 0))
    {
      int i = paramDrawable.getIntrinsicWidth();
      int j = paramDrawable.getIntrinsicHeight();
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    }
    else
    {
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      localObject = Bitmap.createBitmap(1, 1, (Bitmap.Config)localObject);
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return (Bitmap)localObject;
  }
  
  public static byte[] drawable2Bytes(Drawable paramDrawable, Bitmap.CompressFormat paramCompressFormat)
  {
    if (paramDrawable == null) {
      return null;
    }
    return bitmap2Bytes(drawable2Bitmap(paramDrawable), paramCompressFormat);
  }
  
  public static Bitmap getBitmap(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    return BitmapFactory.decodeFile(paramFile.getAbsolutePath());
  }
  
  public static Bitmap getBitmap(File paramFile, int paramInt1, int paramInt2)
  {
    if (paramFile == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    localOptions.inSampleSize = calculateInSampleSize(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
  }
  
  public static int getRotateDegree(String paramString)
  {
    try
    {
      int i = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      if (i != 3)
      {
        if (i != 6)
        {
          if (i != 8) {
            return 0;
          }
          return 270;
        }
        return 90;
      }
      return 180;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return -1;
  }
  
  private static boolean isEmptyBitmap(Bitmap paramBitmap)
  {
    return (paramBitmap == null) || (paramBitmap.getWidth() == 0) || (paramBitmap.getHeight() == 0);
  }
  
  public static boolean isImage(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = paramString.toUpperCase();
      if ((!paramString.endsWith(".PNG")) && (!paramString.endsWith(".JPG")) && (!paramString.endsWith(".JPEG")) && (!paramString.endsWith(".BMP")) && (!paramString.endsWith(".GIF")))
      {
        bool1 = bool2;
        if (!paramString.endsWith(".WEBP")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (isEmptyBitmap(paramBitmap)) {
      return null;
    }
    if (paramInt == 0) {
      return paramBitmap;
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(paramInt);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
    if ((localObject != paramBitmap) && (paramBoolean) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    return (Bitmap)localObject;
  }
  
  public static Bitmap rotate(Bitmap paramBitmap, ExifInterface paramExifInterface, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    if (paramExifInterface == null) {
      return paramBitmap;
    }
    int i = 0;
    int j = paramExifInterface.getAttributeInt("Orientation", 0);
    if (j != 3)
    {
      if (j != 6)
      {
        if (j == 8) {
          i = 270;
        }
      }
      else {
        i = 90;
      }
    }
    else {
      i = 180;
    }
    paramExifInterface = paramBitmap;
    if (i != 0) {
      paramExifInterface = rotate(paramBitmap, i, paramBoolean);
    }
    return paramExifInterface;
  }
  
  public static Bitmap scale(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (isEmptyBitmap(paramBitmap)) {
      return null;
    }
    if (paramInt1 <= paramBitmap.getWidth()) {
      paramBitmap.getHeight();
    }
    Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, paramInt1, paramInt2, true);
    if ((paramBitmap != localBitmap) && (paramBoolean) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static Bitmap toRound(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (isEmptyBitmap(paramBitmap)) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    int k = Math.min(i, j);
    Paint localPaint = new Paint(1);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, paramBitmap.getConfig());
    float f4 = k;
    float f1 = f4 / 2.0F;
    float f2 = i;
    float f3 = j;
    RectF localRectF = new RectF(0.0F, 0.0F, f2, f3);
    localRectF.inset((i - k) / 2.0F, (j - k) / 2.0F);
    Object localObject = new Matrix();
    ((Matrix)localObject).setTranslate(localRectF.left, localRectF.top);
    ((Matrix)localObject).preScale(f4 / f2, f4 / f3);
    BitmapShader localBitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    localBitmapShader.setLocalMatrix((Matrix)localObject);
    localPaint.setShader(localBitmapShader);
    localObject = new Canvas(localBitmap);
    ((Canvas)localObject).drawRoundRect(localRectF, f1, f1, localPaint);
    if (paramInt1 > 0)
    {
      localPaint.setShader(null);
      localPaint.setColor(paramInt2);
      localPaint.setStyle(Paint.Style.STROKE);
      f4 = paramInt1;
      localPaint.setStrokeWidth(f4);
      f4 /= 2.0F;
      ((Canvas)localObject).drawCircle(f2 / 2.0F, f3 / 2.0F, f1 - f4, localPaint);
    }
    if ((paramBoolean) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static Bitmap toRound(Bitmap paramBitmap, boolean paramBoolean)
  {
    return toRound(paramBitmap, 0, 0, paramBoolean);
  }
  
  public static Bitmap toRoundCorner(Bitmap paramBitmap, float paramFloat, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (isEmptyBitmap(paramBitmap)) {
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Paint localPaint = new Paint(1);
    Bitmap localBitmap = Bitmap.createBitmap(i, j, paramBitmap.getConfig());
    localPaint.setShader(new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    Canvas localCanvas = new Canvas(localBitmap);
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = paramInt1;
    float f2 = f1 / 2.0F;
    localRectF.inset(f2, f2);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    if (paramInt1 > 0)
    {
      localPaint.setShader(null);
      localPaint.setColor(paramInt2);
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setStrokeWidth(f1);
      localPaint.setStrokeCap(Paint.Cap.ROUND);
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    }
    if ((paramBoolean) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
    return localBitmap;
  }
  
  public static Bitmap toRoundCorner(Bitmap paramBitmap, float paramFloat, boolean paramBoolean)
  {
    return toRoundCorner(paramBitmap, paramFloat, 0, 0, paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dj\\utils\ImageUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */