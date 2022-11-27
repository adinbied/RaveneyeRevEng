package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class BitmapTeleporter
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();
  private final int mType;
  private final int zalf;
  private ParcelFileDescriptor zalg;
  private Bitmap zalh;
  private boolean zali;
  private File zalj;
  
  BitmapTeleporter(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2)
  {
    this.zalf = paramInt1;
    this.zalg = paramParcelFileDescriptor;
    this.mType = paramInt2;
    this.zalh = null;
    this.zali = false;
  }
  
  public BitmapTeleporter(Bitmap paramBitmap)
  {
    this.zalf = 1;
    this.zalg = null;
    this.mType = 0;
    this.zalh = paramBitmap;
    this.zali = true;
  }
  
  private static void zaa(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("BitmapTeleporter", "Could not close stream", paramCloseable);
    }
  }
  
  /* Error */
  private final java.io.FileOutputStream zabz()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/google/android/gms/common/data/BitmapTeleporter:zalj	Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnull +60 -> 66
    //   9: ldc 70
    //   11: ldc 72
    //   13: aload_1
    //   14: invokestatic 78	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   17: astore_1
    //   18: new 80	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: invokespecial 83	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_0
    //   28: aload_1
    //   29: ldc 84
    //   31: invokestatic 90	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   34: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   37: aload_1
    //   38: invokevirtual 94	java/io/File:delete	()Z
    //   41: pop
    //   42: aload_2
    //   43: areturn
    //   44: new 96	java/lang/IllegalStateException
    //   47: dup
    //   48: ldc 98
    //   50: invokespecial 101	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: astore_1
    //   55: new 96	java/lang/IllegalStateException
    //   58: dup
    //   59: ldc 103
    //   61: aload_1
    //   62: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   65: athrow
    //   66: new 96	java/lang/IllegalStateException
    //   69: dup
    //   70: ldc 108
    //   72: invokespecial 101	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_1
    //   77: goto -33 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	BitmapTeleporter
    //   4	34	1	localFile	File
    //   54	8	1	localIOException	IOException
    //   76	1	1	localFileNotFoundException	java.io.FileNotFoundException
    //   26	17	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	18	54	java/io/IOException
    //   18	37	76	java/io/FileNotFoundException
  }
  
  /* Error */
  public Bitmap get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 42	com/google/android/gms/common/data/BitmapTeleporter:zali	Z
    //   4: ifne +121 -> 125
    //   7: new 112	java/io/DataInputStream
    //   10: dup
    //   11: new 114	android/os/ParcelFileDescriptor$AutoCloseInputStream
    //   14: dup
    //   15: aload_0
    //   16: getfield 36	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   19: invokespecial 117	android/os/ParcelFileDescriptor$AutoCloseInputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   22: invokespecial 120	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   25: astore_3
    //   26: aload_3
    //   27: invokevirtual 124	java/io/DataInputStream:readInt	()I
    //   30: newarray <illegal type>
    //   32: astore 5
    //   34: aload_3
    //   35: invokevirtual 124	java/io/DataInputStream:readInt	()I
    //   38: istore_1
    //   39: aload_3
    //   40: invokevirtual 124	java/io/DataInputStream:readInt	()I
    //   43: istore_2
    //   44: aload_3
    //   45: invokevirtual 128	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   48: invokestatic 134	android/graphics/Bitmap$Config:valueOf	(Ljava/lang/String;)Landroid/graphics/Bitmap$Config;
    //   51: astore 4
    //   53: aload_3
    //   54: aload 5
    //   56: invokevirtual 138	java/io/DataInputStream:read	([B)I
    //   59: pop
    //   60: aload_3
    //   61: invokestatic 140	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   64: aload 5
    //   66: invokestatic 146	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   69: astore_3
    //   70: iload_1
    //   71: iload_2
    //   72: aload 4
    //   74: invokestatic 152	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   77: astore 4
    //   79: aload 4
    //   81: aload_3
    //   82: invokevirtual 156	android/graphics/Bitmap:copyPixelsFromBuffer	(Ljava/nio/Buffer;)V
    //   85: aload_0
    //   86: aload 4
    //   88: putfield 40	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   91: aload_0
    //   92: iconst_1
    //   93: putfield 42	com/google/android/gms/common/data/BitmapTeleporter:zali	Z
    //   96: goto +29 -> 125
    //   99: astore 4
    //   101: goto +17 -> 118
    //   104: astore 4
    //   106: new 96	java/lang/IllegalStateException
    //   109: dup
    //   110: ldc -98
    //   112: aload 4
    //   114: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: athrow
    //   118: aload_3
    //   119: invokestatic 140	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   122: aload 4
    //   124: athrow
    //   125: aload_0
    //   126: getfield 40	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   129: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	this	BitmapTeleporter
    //   38	33	1	i	int
    //   43	29	2	j	int
    //   25	94	3	localObject1	Object
    //   51	36	4	localObject2	Object
    //   99	1	4	localObject3	Object
    //   104	19	4	localIOException	IOException
    //   32	33	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   26	60	99	finally
    //   106	118	99	finally
    //   26	60	104	java/io/IOException
  }
  
  public void release()
  {
    if (!this.zali) {
      try
      {
        this.zalg.close();
        return;
      }
      catch (IOException localIOException)
      {
        Log.w("BitmapTeleporter", "Could not close PFD", localIOException);
      }
    }
  }
  
  public void setTempDir(File paramFile)
  {
    if (paramFile != null)
    {
      this.zalj = paramFile;
      return;
    }
    throw new NullPointerException("Cannot set null temp directory");
  }
  
  /* Error */
  public void writeToParcel(android.os.Parcel paramParcel, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   4: ifnonnull +138 -> 142
    //   7: aload_0
    //   8: getfield 40	com/google/android/gms/common/data/BitmapTeleporter:zalh	Landroid/graphics/Bitmap;
    //   11: astore 5
    //   13: aload 5
    //   15: invokevirtual 173	android/graphics/Bitmap:getRowBytes	()I
    //   18: aload 5
    //   20: invokevirtual 176	android/graphics/Bitmap:getHeight	()I
    //   23: imul
    //   24: invokestatic 180	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   27: astore 4
    //   29: aload 5
    //   31: aload 4
    //   33: invokevirtual 183	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   36: aload 4
    //   38: invokevirtual 187	java/nio/ByteBuffer:array	()[B
    //   41: astore 6
    //   43: new 189	java/io/DataOutputStream
    //   46: dup
    //   47: new 191	java/io/BufferedOutputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 193	com/google/android/gms/common/data/BitmapTeleporter:zabz	()Ljava/io/FileOutputStream;
    //   55: invokespecial 196	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   58: invokespecial 197	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   61: astore 4
    //   63: aload 4
    //   65: aload 6
    //   67: arraylength
    //   68: invokevirtual 201	java/io/DataOutputStream:writeInt	(I)V
    //   71: aload 4
    //   73: aload 5
    //   75: invokevirtual 204	android/graphics/Bitmap:getWidth	()I
    //   78: invokevirtual 201	java/io/DataOutputStream:writeInt	(I)V
    //   81: aload 4
    //   83: aload 5
    //   85: invokevirtual 176	android/graphics/Bitmap:getHeight	()I
    //   88: invokevirtual 201	java/io/DataOutputStream:writeInt	(I)V
    //   91: aload 4
    //   93: aload 5
    //   95: invokevirtual 208	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   98: invokevirtual 211	android/graphics/Bitmap$Config:toString	()Ljava/lang/String;
    //   101: invokevirtual 214	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   104: aload 4
    //   106: aload 6
    //   108: invokevirtual 218	java/io/DataOutputStream:write	([B)V
    //   111: aload 4
    //   113: invokestatic 140	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   116: goto +26 -> 142
    //   119: astore_1
    //   120: goto +15 -> 135
    //   123: astore_1
    //   124: new 96	java/lang/IllegalStateException
    //   127: dup
    //   128: ldc -36
    //   130: aload_1
    //   131: invokespecial 106	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   134: athrow
    //   135: aload 4
    //   137: invokestatic 140	com/google/android/gms/common/data/BitmapTeleporter:zaa	(Ljava/io/Closeable;)V
    //   140: aload_1
    //   141: athrow
    //   142: aload_1
    //   143: invokestatic 226	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:beginObjectHeader	(Landroid/os/Parcel;)I
    //   146: istore_3
    //   147: aload_1
    //   148: iconst_1
    //   149: aload_0
    //   150: getfield 34	com/google/android/gms/common/data/BitmapTeleporter:zalf	I
    //   153: invokestatic 229	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeInt	(Landroid/os/Parcel;II)V
    //   156: aload_1
    //   157: iconst_2
    //   158: aload_0
    //   159: getfield 36	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   162: iload_2
    //   163: iconst_1
    //   164: ior
    //   165: iconst_0
    //   166: invokestatic 233	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeParcelable	(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V
    //   169: aload_1
    //   170: iconst_3
    //   171: aload_0
    //   172: getfield 38	com/google/android/gms/common/data/BitmapTeleporter:mType	I
    //   175: invokestatic 229	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:writeInt	(Landroid/os/Parcel;II)V
    //   178: aload_1
    //   179: iload_3
    //   180: invokestatic 236	com/google/android/gms/common/internal/safeparcel/SafeParcelWriter:finishObjectHeader	(Landroid/os/Parcel;I)V
    //   183: aload_0
    //   184: aconst_null
    //   185: putfield 36	com/google/android/gms/common/data/BitmapTeleporter:zalg	Landroid/os/ParcelFileDescriptor;
    //   188: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	BitmapTeleporter
    //   0	189	1	paramParcel	android.os.Parcel
    //   0	189	2	paramInt	int
    //   146	34	3	i	int
    //   27	109	4	localObject	Object
    //   11	83	5	localBitmap	Bitmap
    //   41	66	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   63	111	119	finally
    //   124	135	119	finally
    //   63	111	123	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\data\BitmapTeleporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */