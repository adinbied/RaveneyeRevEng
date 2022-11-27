package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;

public class SimpleImageTranscoder
  implements ImageTranscoder
{
  private static final String TAG = "SimpleImageTranscoder";
  private final int mMaxBitmapSize;
  private final boolean mResizingEnabled;
  
  public SimpleImageTranscoder(boolean paramBoolean, int paramInt)
  {
    this.mResizingEnabled = paramBoolean;
    this.mMaxBitmapSize = paramInt;
  }
  
  private static Bitmap.CompressFormat getOutputFormat(@Nullable ImageFormat paramImageFormat)
  {
    if (paramImageFormat == null) {
      return Bitmap.CompressFormat.JPEG;
    }
    if (paramImageFormat == DefaultImageFormats.JPEG) {
      return Bitmap.CompressFormat.JPEG;
    }
    if (paramImageFormat == DefaultImageFormats.PNG) {
      return Bitmap.CompressFormat.PNG;
    }
    if ((Build.VERSION.SDK_INT >= 14) && (DefaultImageFormats.isStaticWebpFormat(paramImageFormat))) {
      return Bitmap.CompressFormat.WEBP;
    }
    return Bitmap.CompressFormat.JPEG;
  }
  
  private int getSampleSize(EncodedImage paramEncodedImage, RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions)
  {
    if (!this.mResizingEnabled) {
      return 1;
    }
    return DownsampleUtil.determineSampleSize(paramRotationOptions, paramResizeOptions, paramEncodedImage, this.mMaxBitmapSize);
  }
  
  public boolean canResize(EncodedImage paramEncodedImage, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions)
  {
    RotationOptions localRotationOptions = paramRotationOptions;
    if (paramRotationOptions == null) {
      localRotationOptions = RotationOptions.autoRotate();
    }
    return (this.mResizingEnabled) && (DownsampleUtil.determineSampleSize(localRotationOptions, paramResizeOptions, paramEncodedImage, this.mMaxBitmapSize) > 1);
  }
  
  public boolean canTranscode(ImageFormat paramImageFormat)
  {
    return (paramImageFormat == DefaultImageFormats.HEIF) || (paramImageFormat == DefaultImageFormats.JPEG);
  }
  
  public String getIdentifier()
  {
    return "SimpleImageTranscoder";
  }
  
  /* Error */
  public ImageTranscodeResult transcode(EncodedImage paramEncodedImage, java.io.OutputStream paramOutputStream, @Nullable RotationOptions paramRotationOptions, @Nullable ResizeOptions paramResizeOptions, @Nullable ImageFormat paramImageFormat, @Nullable Integer paramInteger)
  {
    // Byte code:
    //   0: aload 6
    //   2: ifnonnull +13 -> 15
    //   5: bipush 85
    //   7: invokestatic 88	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   10: astore 6
    //   12: goto +3 -> 15
    //   15: aload_3
    //   16: ifnonnull +11 -> 27
    //   19: invokestatic 72	com/facebook/imagepipeline/common/RotationOptions:autoRotate	()Lcom/facebook/imagepipeline/common/RotationOptions;
    //   22: astore 9
    //   24: goto +6 -> 30
    //   27: aload_3
    //   28: astore 9
    //   30: aload_0
    //   31: aload_1
    //   32: aload 9
    //   34: aload 4
    //   36: invokespecial 90	com/facebook/imagepipeline/transcoder/SimpleImageTranscoder:getSampleSize	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/common/RotationOptions;Lcom/facebook/imagepipeline/common/ResizeOptions;)I
    //   39: istore 8
    //   41: new 92	android/graphics/BitmapFactory$Options
    //   44: dup
    //   45: invokespecial 93	android/graphics/BitmapFactory$Options:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: iload 8
    //   52: putfield 96	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   55: aload_1
    //   56: invokevirtual 102	com/facebook/imagepipeline/image/EncodedImage:getInputStream	()Ljava/io/InputStream;
    //   59: aconst_null
    //   60: aload_3
    //   61: invokestatic 108	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   64: astore_3
    //   65: aload_3
    //   66: ifnonnull +19 -> 85
    //   69: ldc 10
    //   71: ldc 110
    //   73: invokestatic 116	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: new 118	com/facebook/imagepipeline/transcoder/ImageTranscodeResult
    //   79: dup
    //   80: iconst_2
    //   81: invokespecial 121	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:<init>	(I)V
    //   84: areturn
    //   85: aload_1
    //   86: aload 9
    //   88: invokestatic 127	com/facebook/imagepipeline/transcoder/JpegTranscoderUtils:getTransformationMatrix	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/common/RotationOptions;)Landroid/graphics/Matrix;
    //   91: astore_1
    //   92: aload_1
    //   93: ifnull +35 -> 128
    //   96: aload_3
    //   97: iconst_0
    //   98: iconst_0
    //   99: aload_3
    //   100: invokevirtual 133	android/graphics/Bitmap:getWidth	()I
    //   103: aload_3
    //   104: invokevirtual 136	android/graphics/Bitmap:getHeight	()I
    //   107: aload_1
    //   108: iconst_0
    //   109: invokestatic 140	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   112: astore_1
    //   113: goto +17 -> 130
    //   116: astore_1
    //   117: aload_3
    //   118: astore_2
    //   119: goto +106 -> 225
    //   122: astore_2
    //   123: aload_3
    //   124: astore_1
    //   125: goto +67 -> 192
    //   128: aload_3
    //   129: astore_1
    //   130: aload_1
    //   131: astore 4
    //   133: aload_1
    //   134: aload 5
    //   136: invokestatic 142	com/facebook/imagepipeline/transcoder/SimpleImageTranscoder:getOutputFormat	(Lcom/facebook/imageformat/ImageFormat;)Landroid/graphics/Bitmap$CompressFormat;
    //   139: aload 6
    //   141: invokevirtual 145	java/lang/Integer:intValue	()I
    //   144: aload_2
    //   145: invokevirtual 149	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   148: pop
    //   149: iconst_1
    //   150: istore 7
    //   152: iload 8
    //   154: iconst_1
    //   155: if_icmple +6 -> 161
    //   158: iconst_0
    //   159: istore 7
    //   161: aload_1
    //   162: astore 4
    //   164: new 118	com/facebook/imagepipeline/transcoder/ImageTranscodeResult
    //   167: dup
    //   168: iload 7
    //   170: invokespecial 121	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:<init>	(I)V
    //   173: astore_2
    //   174: aload_1
    //   175: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   178: aload_3
    //   179: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   182: aload_2
    //   183: areturn
    //   184: astore_1
    //   185: aload 4
    //   187: astore_2
    //   188: goto +37 -> 225
    //   191: astore_2
    //   192: aload_1
    //   193: astore 4
    //   195: ldc 10
    //   197: ldc -102
    //   199: aload_2
    //   200: invokestatic 157	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload_1
    //   204: astore 4
    //   206: new 118	com/facebook/imagepipeline/transcoder/ImageTranscodeResult
    //   209: dup
    //   210: iconst_2
    //   211: invokespecial 121	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:<init>	(I)V
    //   214: astore_2
    //   215: aload_1
    //   216: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   219: aload_3
    //   220: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   223: aload_2
    //   224: areturn
    //   225: aload_2
    //   226: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   229: aload_3
    //   230: invokevirtual 152	android/graphics/Bitmap:recycle	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: ldc 10
    //   238: ldc -102
    //   240: aload_1
    //   241: invokestatic 157	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   244: new 118	com/facebook/imagepipeline/transcoder/ImageTranscodeResult
    //   247: dup
    //   248: iconst_2
    //   249: invokespecial 121	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:<init>	(I)V
    //   252: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	SimpleImageTranscoder
    //   0	253	1	paramEncodedImage	EncodedImage
    //   0	253	2	paramOutputStream	java.io.OutputStream
    //   0	253	3	paramRotationOptions	RotationOptions
    //   0	253	4	paramResizeOptions	ResizeOptions
    //   0	253	5	paramImageFormat	ImageFormat
    //   0	253	6	paramInteger	Integer
    //   150	19	7	i	int
    //   39	117	8	j	int
    //   22	65	9	localRotationOptions	RotationOptions
    // Exception table:
    //   from	to	target	type
    //   96	113	116	finally
    //   96	113	122	java/lang/OutOfMemoryError
    //   133	149	184	finally
    //   164	174	184	finally
    //   195	203	184	finally
    //   206	215	184	finally
    //   133	149	191	java/lang/OutOfMemoryError
    //   164	174	191	java/lang/OutOfMemoryError
    //   55	65	235	java/lang/OutOfMemoryError
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\transcoder\SimpleImageTranscoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */