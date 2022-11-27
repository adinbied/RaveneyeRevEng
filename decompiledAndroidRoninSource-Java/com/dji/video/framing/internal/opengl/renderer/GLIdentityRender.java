package com.dji.video.framing.internal.opengl.renderer;

import android.opengl.GLES20;

public class GLIdentityRender
  extends GLRenderBase
{
  public static boolean DEBUG = false;
  protected static final String FRAGMENT_SHADER_EXTERNAL = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float yuv_scale_uniform; \nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord)*yuv_scale_uniform;\n}\n";
  protected static final String FRAGMENT_SHADER_INTERNAL = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float yuv_scale_uniform; \nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord)*yuv_scale_uniform;\n}\n";
  public static String TAG = "GLIdentityRender";
  protected static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  protected final boolean isExternal;
  private float yuv_scale = 1.0F;
  private int yuv_scale_uniform_loc;
  
  public GLIdentityRender(boolean paramBoolean)
  {
    this.isExternal = paramBoolean;
  }
  
  protected String getFragmentShader()
  {
    return null;
  }
  
  protected String getVertexShader()
  {
    return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  }
  
  /* Error */
  protected void onInit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected void preDrawArrays()
  {
    GLES20.glUniform1f(this.yuv_scale_uniform_loc, this.yuv_scale);
  }
  
  public void setYUVScale(float paramFloat)
  {
    this.yuv_scale = paramFloat;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLIdentityRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */