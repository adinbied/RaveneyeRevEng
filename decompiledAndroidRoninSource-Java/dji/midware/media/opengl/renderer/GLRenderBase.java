package dji.midware.media.opengl.renderer;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

public abstract class GLRenderBase
{
  private static boolean DEBUG = false;
  private static final int FLOAT_SIZE_BYTES = 4;
  private static String TAG = "GLRenderBase";
  private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
  private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 20;
  private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
  private float[] mMVPMatrix = new float[16];
  protected int mProgram;
  private FloatBuffer mTriangleVertices;
  protected float[] mTriangleVerticesData = { -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  private int maPositionHandle;
  private int maTextureHandle;
  private int muMVPMatrixHandle;
  private int muSTMatrixHandle;
  private int musTexture;
  protected int viewport_height;
  protected int viewport_width;
  
  /* Error */
  private void createProgram()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void deleteShader(int paramInt)
  {
    GLES20.glDeleteShader(paramInt);
  }
  
  private int loadShader(int paramInt, String paramString)
  {
    return 0;
  }
  
  protected void bindTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES20.glActiveTexture(paramInt1);
    GLES20.glBindTexture(paramInt2, paramInt3);
  }
  
  /* Error */
  protected void checkLocation(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void draw(int arg1, int arg2, float[] arg3, boolean arg4, float arg5, int arg6, int arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void draw(int arg1, int arg2, float[] arg3, boolean arg4, float arg5, int arg6, int arg7, int arg8, int arg9)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void draw(int arg1, float[] arg2, float arg3, int arg4, int arg5, int arg6, int arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void draw(dji.midware.media.opengl.extra.FrameBufferTexturePair arg1, int arg2, int arg3, float[] arg4, boolean arg5, float arg6, int arg7, int arg8, int arg9, int arg10)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void drawFromRange(int arg1, int arg2, float[] arg3, boolean arg4, float arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void drawRange(int paramInt1, int paramInt2, float[] paramArrayOfFloat, boolean paramBoolean, float paramFloat, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    drawFromRange(paramInt1, paramInt2, paramArrayOfFloat, paramBoolean, paramFloat, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8);
  }
  
  /* Error */
  public void drawToRange(int arg1, int arg2, float[] arg3, boolean arg4, float arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  protected abstract String getFragmentShader();
  
  protected abstract String getVertexShader();
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void onInit();
  
  protected abstract void preDrawArrays();
  
  /* Error */
  public void readRGBAData(java.nio.ByteBuffer arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\renderer\GLRenderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */