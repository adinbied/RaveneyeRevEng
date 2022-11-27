package dji.midware.ar.min3d;

import android.graphics.Bitmap;
import dji.midware.ar.min3d.core.FacesBufferedList;
import dji.midware.ar.min3d.core.Object3d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class Utils
{
  private static final int BYTES_PER_FLOAT = 4;
  public static final float DEG = 0.017453292F;
  
  public static void addQuad(Object3d paramObject3d, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FacesBufferedList localFacesBufferedList = paramObject3d.faces();
    short s1 = (short)paramInt1;
    short s2 = (short)paramInt3;
    localFacesBufferedList.add(s1, s2, (short)paramInt2);
    paramObject3d.faces().add(s1, (short)paramInt4, s2);
  }
  
  public static Bitmap makeBitmapFromResourceId(int paramInt)
  {
    return makeBitmapFromResourceId(Shared.context(), paramInt);
  }
  
  /* Error */
  public static Bitmap makeBitmapFromResourceId(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 48	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: iload_1
    //   5: invokevirtual 54	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   8: astore_0
    //   9: aload_0
    //   10: invokestatic 60	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   13: astore_2
    //   14: aload_0
    //   15: invokevirtual 65	java/io/InputStream:close	()V
    //   18: aload_2
    //   19: areturn
    //   20: astore_2
    //   21: aload_0
    //   22: invokevirtual 65	java/io/InputStream:close	()V
    //   25: aload_2
    //   26: athrow
    //   27: astore_0
    //   28: aload_2
    //   29: areturn
    //   30: astore_0
    //   31: goto -6 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	paramContext	android.content.Context
    //   0	34	1	paramInt	int
    //   13	6	2	localBitmap1	Bitmap
    //   20	9	2	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	14	20	finally
    //   14	18	27	java/io/IOException
    //   21	25	30	java/io/IOException
  }
  
  public static FloatBuffer makeFloatBuffer3(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    Object localObject = ByteBuffer.allocateDirect(12);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramFloat1);
    ((FloatBuffer)localObject).put(paramFloat2);
    ((FloatBuffer)localObject).put(paramFloat3);
    ((FloatBuffer)localObject).position(0);
    return (FloatBuffer)localObject;
  }
  
  public static FloatBuffer makeFloatBuffer4(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject = ByteBuffer.allocateDirect(16);
    ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
    localObject = ((ByteBuffer)localObject).asFloatBuffer();
    ((FloatBuffer)localObject).put(paramFloat1);
    ((FloatBuffer)localObject).put(paramFloat2);
    ((FloatBuffer)localObject).put(paramFloat3);
    ((FloatBuffer)localObject).put(paramFloat4);
    ((FloatBuffer)localObject).position(0);
    return (FloatBuffer)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */