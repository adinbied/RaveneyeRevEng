package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator
  implements BitmapCreator
{
  private final FlexByteArrayPool mFlexByteArrayPool;
  private final EmptyJpegGenerator mJpegGenerator;
  
  public HoneycombBitmapCreator(PoolFactory paramPoolFactory)
  {
    this.mFlexByteArrayPool = paramPoolFactory.getFlexByteArrayPool();
    this.mJpegGenerator = new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory());
  }
  
  private static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    return localOptions;
  }
  
  /* Error */
  public android.graphics.Bitmap createNakedBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mJpegGenerator	Lcom/facebook/imagepipeline/bitmaps/EmptyJpegGenerator;
    //   4: iload_1
    //   5: i2s
    //   6: iload_2
    //   7: i2s
    //   8: invokevirtual 72	com/facebook/imagepipeline/bitmaps/EmptyJpegGenerator:generate	(SS)Lcom/facebook/common/references/CloseableReference;
    //   11: astore 7
    //   13: aconst_null
    //   14: astore 4
    //   16: aconst_null
    //   17: astore 6
    //   19: new 74	com/facebook/imagepipeline/image/EncodedImage
    //   22: dup
    //   23: aload 7
    //   25: invokespecial 77	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   28: astore 5
    //   30: aload 6
    //   32: astore 4
    //   34: aload 5
    //   36: getstatic 83	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
    //   39: invokevirtual 87	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
    //   42: aload 6
    //   44: astore 4
    //   46: aload 5
    //   48: invokevirtual 91	com/facebook/imagepipeline/image/EncodedImage:getSampleSize	()I
    //   51: aload_3
    //   52: invokestatic 93	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:getBitmapFactoryOptions	(ILandroid/graphics/Bitmap$Config;)Landroid/graphics/BitmapFactory$Options;
    //   55: astore 8
    //   57: aload 6
    //   59: astore 4
    //   61: aload 7
    //   63: invokevirtual 99	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   66: checkcast 101	com/facebook/common/memory/PooledByteBuffer
    //   69: invokeinterface 104 1 0
    //   74: istore_1
    //   75: aload 6
    //   77: astore 4
    //   79: aload 7
    //   81: invokevirtual 99	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   84: checkcast 101	com/facebook/common/memory/PooledByteBuffer
    //   87: astore 9
    //   89: aload 6
    //   91: astore 4
    //   93: aload_0
    //   94: getfield 23	com/facebook/imagepipeline/bitmaps/HoneycombBitmapCreator:mFlexByteArrayPool	Lcom/facebook/imagepipeline/memory/FlexByteArrayPool;
    //   97: iload_1
    //   98: iconst_2
    //   99: iadd
    //   100: invokevirtual 109	com/facebook/imagepipeline/memory/FlexByteArrayPool:get	(I)Lcom/facebook/common/references/CloseableReference;
    //   103: astore_3
    //   104: aload_3
    //   105: astore 4
    //   107: aload_3
    //   108: invokevirtual 99	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
    //   111: checkcast 111	[B
    //   114: astore 6
    //   116: aload_3
    //   117: astore 4
    //   119: aload 9
    //   121: iconst_0
    //   122: aload 6
    //   124: iconst_0
    //   125: iload_1
    //   126: invokeinterface 115 5 0
    //   131: pop
    //   132: aload_3
    //   133: astore 4
    //   135: aload 6
    //   137: iconst_0
    //   138: iload_1
    //   139: aload 8
    //   141: invokestatic 121	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   144: astore 6
    //   146: aload_3
    //   147: astore 4
    //   149: aload 6
    //   151: iconst_1
    //   152: invokevirtual 127	android/graphics/Bitmap:setHasAlpha	(Z)V
    //   155: aload_3
    //   156: astore 4
    //   158: aload 6
    //   160: iconst_0
    //   161: invokevirtual 131	android/graphics/Bitmap:eraseColor	(I)V
    //   164: aload_3
    //   165: invokestatic 134	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   168: aload 5
    //   170: invokestatic 137	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   173: aload 7
    //   175: invokestatic 134	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   178: aload 6
    //   180: areturn
    //   181: astore 6
    //   183: aload 5
    //   185: astore_3
    //   186: aload 6
    //   188: astore 5
    //   190: goto +7 -> 197
    //   193: astore 5
    //   195: aconst_null
    //   196: astore_3
    //   197: aload 4
    //   199: invokestatic 134	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   202: aload_3
    //   203: invokestatic 137	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   206: aload 7
    //   208: invokestatic 134	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   211: aload 5
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	HoneycombBitmapCreator
    //   0	214	1	paramInt1	int
    //   0	214	2	paramInt2	int
    //   0	214	3	paramConfig	Bitmap.Config
    //   14	184	4	localObject1	Object
    //   28	161	5	localObject2	Object
    //   193	19	5	localObject3	Object
    //   17	162	6	localObject4	Object
    //   181	6	6	localObject5	Object
    //   11	196	7	localCloseableReference	com.facebook.common.references.CloseableReference
    //   55	85	8	localOptions	BitmapFactory.Options
    //   87	33	9	localPooledByteBuffer	com.facebook.common.memory.PooledByteBuffer
    // Exception table:
    //   from	to	target	type
    //   34	42	181	finally
    //   46	57	181	finally
    //   61	75	181	finally
    //   79	89	181	finally
    //   93	104	181	finally
    //   107	116	181	finally
    //   119	132	181	finally
    //   135	146	181	finally
    //   149	155	181	finally
    //   158	164	181	finally
    //   19	30	193	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\HoneycombBitmapCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */