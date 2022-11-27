package com.dji.video.framing.internal.opengl.renderer;

public class GLGrayRender
  extends GLRenderBase
{
  private static String TAG = "GLRGB2YUVRender";
  private final String FRAGMENT_SHADER_EXTERNAL_FULL_RANGE = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\nvec3 yuv;\nvec3 rgb;\nrgb.r=texture2D(sTexture, vTextureCoord).r;\nrgb.g=texture2D(sTexture, vTextureCoord).g;\nrgb.b=texture2D(sTexture, vTextureCoord).b;\nyuv.r=0.299*rgb.r+0.587*rgb.g+0.114*rgb.b;\nyuv.g=-0.148*rgb.r-0.289*rgb.g+0.437*rgb.b+0.5;\nyuv.b=0.615*rgb.r-0.515*rgb.g-0.100*rgb.b+0.5;\n;gl_FragColor =vec4(yuv,1.0);\n}\n";
  private final String FRAGMENT_SHADER_EXTERNAL_VIDEO_RANGE = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\nvec3 yuv;\nvec3 rgb;\nrgb.r=texture2D(sTexture, vTextureCoord).r;\nrgb.g=texture2D(sTexture, vTextureCoord).g;\nrgb.b=texture2D(sTexture, vTextureCoord).b;\nyuv.r=0.2568*rgb.r+0.5041*rgb.g+0.0979*rgb.b+0.0625;\nyuv.g=0.2568*rgb.r+0.5041*rgb.g+0.0979*rgb.b+0.0625;\nyuv.b=0.2568*rgb.r+0.5041*rgb.g+0.0979*rgb.b+0.0625;\n;gl_FragColor =vec4(yuv,1.0);\n}\n";
  private final String RGB2YUV_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private byte[] dst;
  final boolean isExternal;
  final boolean isFullRange;
  private int preheight = 0;
  private int prewidth = 0;
  protected boolean saveFirstReadData = false;
  private byte[] src;
  
  public GLGrayRender(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isExternal = paramBoolean1;
    this.isFullRange = paramBoolean2;
  }
  
  protected String getFragmentShader()
  {
    return null;
  }
  
  protected String getVertexShader()
  {
    return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  }
  
  protected void onInit() {}
  
  protected void preDrawArrays() {}
  
  /* Error */
  public void readYUVData(java.nio.ByteBuffer arg1, int arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void readYUVData(java.nio.ByteBuffer arg1, int arg2, int arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLGrayRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */