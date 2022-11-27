package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract class DefaultDecoder
  implements PlatformDecoder
{
  private static final int DECODE_BUFFER_SIZE = 16384;
  private static final byte[] EOI_TAIL = { -1, -39 };
  private static final Class<?> TAG = DefaultDecoder.class;
  private final BitmapPool mBitmapPool;
  final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
  @Nullable
  private final PreverificationHelper mPreverificationHelper;
  
  public DefaultDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    PreverificationHelper localPreverificationHelper;
    if (Build.VERSION.SDK_INT >= 26) {
      localPreverificationHelper = new PreverificationHelper();
    } else {
      localPreverificationHelper = null;
    }
    this.mPreverificationHelper = localPreverificationHelper;
    this.mBitmapPool = paramBitmapPool;
    this.mDecodeBuffers = paramSynchronizedPool;
    int i = 0;
    while (i < paramInt)
    {
      this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
      i += 1;
    }
  }
  
  /* Error */
  private CloseableReference<Bitmap> decodeFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions, @Nullable Rect paramRect, @Nullable ColorSpace paramColorSpace)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 75	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_2
    //   6: getfield 80	android/graphics/BitmapFactory$Options:outWidth	I
    //   9: istore 5
    //   11: aload_2
    //   12: getfield 83	android/graphics/BitmapFactory$Options:outHeight	I
    //   15: istore 6
    //   17: aload_3
    //   18: ifnull +25 -> 43
    //   21: aload_3
    //   22: invokevirtual 89	android/graphics/Rect:width	()I
    //   25: aload_2
    //   26: getfield 92	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   29: idiv
    //   30: istore 5
    //   32: aload_3
    //   33: invokevirtual 95	android/graphics/Rect:height	()I
    //   36: aload_2
    //   37: getfield 92	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: idiv
    //   41: istore 6
    //   43: getstatic 40	android/os/Build$VERSION:SDK_INT	I
    //   46: bipush 26
    //   48: if_icmplt +32 -> 80
    //   51: aload_0
    //   52: getfield 45	com/facebook/imagepipeline/platform/DefaultDecoder:mPreverificationHelper	Lcom/facebook/imagepipeline/platform/PreverificationHelper;
    //   55: astore 8
    //   57: aload 8
    //   59: ifnull +21 -> 80
    //   62: aload 8
    //   64: aload_2
    //   65: getfield 99	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   68: invokevirtual 103	com/facebook/imagepipeline/platform/PreverificationHelper:shouldUseHardwareBitmapConfig	(Landroid/graphics/Bitmap$Config;)Z
    //   71: ifeq +9 -> 80
    //   74: iconst_1
    //   75: istore 7
    //   77: goto +6 -> 83
    //   80: iconst_0
    //   81: istore 7
    //   83: aconst_null
    //   84: astore 11
    //   86: aload_3
    //   87: ifnonnull +19 -> 106
    //   90: iload 7
    //   92: ifeq +14 -> 106
    //   95: aload_2
    //   96: iconst_0
    //   97: putfield 107	android/graphics/BitmapFactory$Options:inMutable	Z
    //   100: aconst_null
    //   101: astore 9
    //   103: goto +51 -> 154
    //   106: aload_3
    //   107: ifnull +15 -> 122
    //   110: iload 7
    //   112: ifeq +10 -> 122
    //   115: aload_2
    //   116: getstatic 112	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   119: putfield 99	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   122: aload_0
    //   123: iload 5
    //   125: iload 6
    //   127: aload_2
    //   128: invokevirtual 116	com/facebook/imagepipeline/platform/DefaultDecoder:getBitmapSize	(IILandroid/graphics/BitmapFactory$Options;)I
    //   131: istore 7
    //   133: aload_0
    //   134: getfield 47	com/facebook/imagepipeline/platform/DefaultDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   137: iload 7
    //   139: invokeinterface 122 2 0
    //   144: checkcast 124	android/graphics/Bitmap
    //   147: astore 9
    //   149: aload 9
    //   151: ifnull +367 -> 518
    //   154: aload_2
    //   155: aload 9
    //   157: putfield 128	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   160: getstatic 40	android/os/Build$VERSION:SDK_INT	I
    //   163: bipush 26
    //   165: if_icmplt +26 -> 191
    //   168: aload 4
    //   170: astore 8
    //   172: aload 4
    //   174: ifnonnull +11 -> 185
    //   177: getstatic 134	android/graphics/ColorSpace$Named:SRGB	Landroid/graphics/ColorSpace$Named;
    //   180: invokestatic 139	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   183: astore 8
    //   185: aload_2
    //   186: aload 8
    //   188: putfield 143	android/graphics/BitmapFactory$Options:inPreferredColorSpace	Landroid/graphics/ColorSpace;
    //   191: aload_0
    //   192: getfield 49	com/facebook/imagepipeline/platform/DefaultDecoder:mDecodeBuffers	Landroidx/core/util/Pools$SynchronizedPool;
    //   195: invokevirtual 147	androidx/core/util/Pools$SynchronizedPool:acquire	()Ljava/lang/Object;
    //   198: checkcast 51	java/nio/ByteBuffer
    //   201: astore 4
    //   203: aload 4
    //   205: astore 10
    //   207: aload 4
    //   209: ifnonnull +11 -> 220
    //   212: sipush 16384
    //   215: invokestatic 55	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   218: astore 10
    //   220: aload_2
    //   221: aload 10
    //   223: invokevirtual 151	java/nio/ByteBuffer:array	()[B
    //   226: putfield 154	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   229: getstatic 40	android/os/Build$VERSION:SDK_INT	I
    //   232: istore 7
    //   234: iload 7
    //   236: bipush 19
    //   238: if_icmplt +311 -> 549
    //   241: aload_3
    //   242: ifnull +307 -> 549
    //   245: aload 9
    //   247: ifnull +302 -> 549
    //   250: aload 9
    //   252: iload 5
    //   254: iload 6
    //   256: aload_2
    //   257: getfield 99	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   260: invokevirtual 158	android/graphics/Bitmap:reconfigure	(IILandroid/graphics/Bitmap$Config;)V
    //   263: aload_1
    //   264: iconst_1
    //   265: invokestatic 164	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   268: astore 8
    //   270: aload 8
    //   272: astore 4
    //   274: aload 8
    //   276: aload_3
    //   277: aload_2
    //   278: invokevirtual 168	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   281: astore 11
    //   283: aload 11
    //   285: astore_3
    //   286: aload 8
    //   288: ifnull +67 -> 355
    //   291: aload 8
    //   293: invokevirtual 171	android/graphics/BitmapRegionDecoder:recycle	()V
    //   296: aload 11
    //   298: astore_3
    //   299: goto +56 -> 355
    //   302: astore_3
    //   303: aload 11
    //   305: astore_2
    //   306: goto +39 -> 345
    //   309: aconst_null
    //   310: astore 8
    //   312: aload 8
    //   314: astore 4
    //   316: getstatic 26	com/facebook/imagepipeline/platform/DefaultDecoder:TAG	Ljava/lang/Class;
    //   319: ldc -83
    //   321: iconst_1
    //   322: anewarray 4	java/lang/Object
    //   325: dup
    //   326: iconst_0
    //   327: aload_3
    //   328: aastore
    //   329: invokestatic 179	com/facebook/common/logging/FLog:e	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   332: aload 8
    //   334: ifnull +215 -> 549
    //   337: aload 8
    //   339: invokevirtual 171	android/graphics/BitmapRegionDecoder:recycle	()V
    //   342: goto +207 -> 549
    //   345: aload_2
    //   346: ifnull +7 -> 353
    //   349: aload_2
    //   350: invokevirtual 171	android/graphics/BitmapRegionDecoder:recycle	()V
    //   353: aload_3
    //   354: athrow
    //   355: aload_3
    //   356: astore 4
    //   358: aload_3
    //   359: ifnonnull +11 -> 370
    //   362: aload_1
    //   363: aconst_null
    //   364: aload_2
    //   365: invokestatic 185	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   368: astore 4
    //   370: aload_0
    //   371: getfield 49	com/facebook/imagepipeline/platform/DefaultDecoder:mDecodeBuffers	Landroidx/core/util/Pools$SynchronizedPool;
    //   374: aload 10
    //   376: invokevirtual 61	androidx/core/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   379: pop
    //   380: aload 9
    //   382: ifnull +37 -> 419
    //   385: aload 9
    //   387: aload 4
    //   389: if_acmpne +6 -> 395
    //   392: goto +27 -> 419
    //   395: aload_0
    //   396: getfield 47	com/facebook/imagepipeline/platform/DefaultDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   399: aload 9
    //   401: invokeinterface 188 2 0
    //   406: aload 4
    //   408: invokevirtual 189	android/graphics/Bitmap:recycle	()V
    //   411: new 191	java/lang/IllegalStateException
    //   414: dup
    //   415: invokespecial 192	java/lang/IllegalStateException:<init>	()V
    //   418: athrow
    //   419: aload 4
    //   421: aload_0
    //   422: getfield 47	com/facebook/imagepipeline/platform/DefaultDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   425: invokestatic 198	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   428: areturn
    //   429: astore_1
    //   430: goto +76 -> 506
    //   433: astore_1
    //   434: aload 9
    //   436: ifnull +14 -> 450
    //   439: aload_0
    //   440: getfield 47	com/facebook/imagepipeline/platform/DefaultDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   443: aload 9
    //   445: invokeinterface 188 2 0
    //   450: aload_1
    //   451: athrow
    //   452: astore_2
    //   453: aload 9
    //   455: ifnull +14 -> 469
    //   458: aload_0
    //   459: getfield 47	com/facebook/imagepipeline/platform/DefaultDecoder:mBitmapPool	Lcom/facebook/imagepipeline/memory/BitmapPool;
    //   462: aload 9
    //   464: invokeinterface 188 2 0
    //   469: aload_1
    //   470: invokevirtual 203	java/io/InputStream:reset	()V
    //   473: aload_1
    //   474: invokestatic 206	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   477: astore_1
    //   478: aload_1
    //   479: ifnull +23 -> 502
    //   482: aload_1
    //   483: invokestatic 212	com/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser:getInstance	()Lcom/facebook/imagepipeline/bitmaps/SimpleBitmapReleaser;
    //   486: invokestatic 198	com/facebook/common/references/CloseableReference:of	(Ljava/lang/Object;Lcom/facebook/common/references/ResourceReleaser;)Lcom/facebook/common/references/CloseableReference;
    //   489: astore_1
    //   490: aload_0
    //   491: getfield 49	com/facebook/imagepipeline/platform/DefaultDecoder:mDecodeBuffers	Landroidx/core/util/Pools$SynchronizedPool;
    //   494: aload 10
    //   496: invokevirtual 61	androidx/core/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   499: pop
    //   500: aload_1
    //   501: areturn
    //   502: aload_2
    //   503: athrow
    //   504: aload_2
    //   505: athrow
    //   506: aload_0
    //   507: getfield 49	com/facebook/imagepipeline/platform/DefaultDecoder:mDecodeBuffers	Landroidx/core/util/Pools$SynchronizedPool;
    //   510: aload 10
    //   512: invokevirtual 61	androidx/core/util/Pools$SynchronizedPool:release	(Ljava/lang/Object;)Z
    //   515: pop
    //   516: aload_1
    //   517: athrow
    //   518: new 214	java/lang/NullPointerException
    //   521: dup
    //   522: ldc -40
    //   524: invokespecial 219	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   527: athrow
    //   528: astore 4
    //   530: goto -221 -> 309
    //   533: astore 4
    //   535: goto -223 -> 312
    //   538: astore_1
    //   539: goto -35 -> 504
    //   542: astore_3
    //   543: aload 4
    //   545: astore_2
    //   546: goto -201 -> 345
    //   549: aconst_null
    //   550: astore_3
    //   551: goto -196 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	554	0	this	DefaultDecoder
    //   0	554	1	paramInputStream	InputStream
    //   0	554	2	paramOptions	BitmapFactory.Options
    //   0	554	3	paramRect	Rect
    //   0	554	4	paramColorSpace	ColorSpace
    //   9	244	5	i	int
    //   15	240	6	j	int
    //   75	164	7	k	int
    //   55	283	8	localObject1	Object
    //   101	362	9	localBitmap1	Bitmap
    //   205	306	10	localObject2	Object
    //   84	220	11	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   250	270	302	finally
    //   220	234	429	finally
    //   291	296	429	finally
    //   337	342	429	finally
    //   349	353	429	finally
    //   353	355	429	finally
    //   362	370	429	finally
    //   439	450	429	finally
    //   450	452	429	finally
    //   458	469	429	finally
    //   469	478	429	finally
    //   482	490	429	finally
    //   502	504	429	finally
    //   504	506	429	finally
    //   220	234	433	java/lang/RuntimeException
    //   291	296	433	java/lang/RuntimeException
    //   337	342	433	java/lang/RuntimeException
    //   349	353	433	java/lang/RuntimeException
    //   353	355	433	java/lang/RuntimeException
    //   362	370	433	java/lang/RuntimeException
    //   220	234	452	java/lang/IllegalArgumentException
    //   291	296	452	java/lang/IllegalArgumentException
    //   337	342	452	java/lang/IllegalArgumentException
    //   349	353	452	java/lang/IllegalArgumentException
    //   353	355	452	java/lang/IllegalArgumentException
    //   362	370	452	java/lang/IllegalArgumentException
    //   250	270	528	java/io/IOException
    //   274	283	533	java/io/IOException
    //   469	478	538	java/io/IOException
    //   482	490	538	java/io/IOException
    //   502	504	538	java/io/IOException
    //   274	283	542	finally
    //   316	332	542	finally
  }
  
  private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage paramEncodedImage, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = paramEncodedImage.getSampleSize();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramEncodedImage.getInputStream(), null, localOptions);
    if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1))
    {
      localOptions.inJustDecodeBounds = false;
      localOptions.inDither = true;
      localOptions.inPreferredConfig = paramConfig;
      localOptions.inMutable = true;
      return localOptions;
    }
    throw new IllegalArgumentException();
  }
  
  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect)
  {
    return decodeFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, null);
  }
  
  public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, @Nullable ColorSpace paramColorSpace)
  {
    paramConfig = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    int i;
    if (paramConfig.inPreferredConfig != Bitmap.Config.ARGB_8888) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      paramConfig = decodeFromStream(paramEncodedImage.getInputStream(), paramConfig, paramRect, paramColorSpace);
      return paramConfig;
    }
    catch (RuntimeException paramConfig)
    {
      if (i != 0) {
        return decodeFromEncodedImageWithColorSpace(paramEncodedImage, Bitmap.Config.ARGB_8888, paramRect, paramColorSpace);
      }
      throw paramConfig;
    }
  }
  
  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt)
  {
    return decodeJPEGFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, paramInt, null);
  }
  
  public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt, @Nullable ColorSpace paramColorSpace)
  {
    boolean bool = paramEncodedImage.isCompleteAt(paramInt);
    BitmapFactory.Options localOptions = getDecodeOptionsForStream(paramEncodedImage, paramConfig);
    Object localObject = paramEncodedImage.getInputStream();
    Preconditions.checkNotNull(localObject);
    paramConfig = (Bitmap.Config)localObject;
    if (paramEncodedImage.getSize() > paramInt) {
      paramConfig = new LimitedInputStream((InputStream)localObject, paramInt);
    }
    localObject = paramConfig;
    if (!bool) {
      localObject = new TailAppendingInputStream(paramConfig, EOI_TAIL);
    }
    int i;
    if (localOptions.inPreferredConfig != Bitmap.Config.ARGB_8888) {
      i = 1;
    } else {
      i = 0;
    }
    try
    {
      paramConfig = decodeFromStream((InputStream)localObject, localOptions, paramRect, paramColorSpace);
      return paramConfig;
    }
    catch (RuntimeException paramConfig)
    {
      if (i != 0) {
        return decodeJPEGFromEncodedImageWithColorSpace(paramEncodedImage, Bitmap.Config.ARGB_8888, paramRect, paramInt, paramColorSpace);
      }
      throw paramConfig;
    }
  }
  
  protected CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream paramInputStream, BitmapFactory.Options paramOptions, @Nullable Rect paramRect)
  {
    return decodeFromStream(paramInputStream, paramOptions, paramRect, null);
  }
  
  public abstract int getBitmapSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\DefaultDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */