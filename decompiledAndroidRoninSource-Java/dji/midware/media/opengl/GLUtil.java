package dji.midware.media.opengl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import dji.log.RoninLog;
import dji.midware.media.MediaLogger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class GLUtil
{
  public static boolean DEBUG = false;
  public static final int GLCOLORFORMAT = 6408;
  public static String TAG = "GLUtil";
  
  public static void bindFrameBuffer(int paramInt)
  {
    boolean bool = DEBUG;
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Bind frameBuffer to target. FB=");
    localStringBuilder.append(paramInt);
    MediaLogger.i(bool, str, localStringBuilder.toString());
    GLES20.glBindFramebuffer(36160, paramInt);
  }
  
  public static void checkGlError(String paramString)
  {
    int i;
    do
    {
      i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      RoninLog.e((String)localObject, localStringBuilder.toString(), new Object[0]);
    } while (!DEBUG);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(": glError ");
    ((StringBuilder)localObject).append(i);
    throw new RuntimeException(((StringBuilder)localObject).toString());
  }
  
  public static void clearError()
  {
    GLES20.glGetError();
  }
  
  public static void destroyFrameBuffer(int paramInt)
  {
    if (paramInt >= 0) {
      GLES20.glDeleteFramebuffers(1, new int[] { paramInt }, 0);
    }
  }
  
  public static void destroyTexture(int paramInt)
  {
    if (paramInt >= 0) {
      GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    }
  }
  
  public static int genTexture(int paramInt)
  {
    return genTexture(paramInt, false);
  }
  
  public static int genTexture(int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(1, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES20.glBindTexture(paramInt, i);
    checkGlError("glBindTexture mTextureID");
    GLES20.glTexParameterf(paramInt, 10241, 9728.0F);
    GLES20.glTexParameterf(paramInt, 10240, 9729.0F);
    if (!paramBoolean)
    {
      GLES20.glTexParameteri(paramInt, 10242, 33071);
      GLES20.glTexParameteri(paramInt, 10243, 33071);
    }
    else
    {
      GLES20.glTexParameteri(paramInt, 10242, 10497);
      GLES20.glTexParameteri(paramInt, 10243, 10497);
    }
    checkGlError("glTexParameter");
    return i;
  }
  
  public static int getFrameBufferBinding()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGetIntegerv(36006, IntBuffer.wrap(arrayOfInt));
    return arrayOfInt[0];
  }
  
  public static void loadRGBAData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, paramByteBuffer);
  }
  
  public static void loadTextureData(int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3, int paramInt4)
  {
    GLES20.glBindTexture(paramInt2, paramInt1);
    GLES20.glTexImage2D(paramInt2, 0, 6408, paramInt3, paramInt4, 0, 6408, 5121, paramByteBuffer);
  }
  
  public static void saveFrameBufferToBitmapFile(String paramString, int paramInt1, int paramInt2)
  {
    GLES20.glPixelStorei(3333, 4);
    int i = paramInt1 * paramInt2 * 4;
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(i);
    localByteBuffer.clear();
    GLES20.glReadPixels(0, 0, paramInt1, paramInt2, 6408, 5121, localByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localByteBuffer.position(0);
    localByteBuffer.limit(i);
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    try
    {
      paramString = new FileOutputStream(paramString);
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 90, paramString);
      try
      {
        paramString.close();
        return;
      }
      catch (IOException paramString)
      {
        MediaLogger.e(TAG, paramString);
        return;
      }
      return;
    }
    catch (FileNotFoundException paramString)
    {
      MediaLogger.e(TAG, paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\GLUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */