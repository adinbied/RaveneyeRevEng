package com.dji.video.framing.internal.opengl.renderer;

public class GLUndistortRender
  extends GLRenderBase
{
  protected static final String FRAGMENT_SHADER_EXTERNAL = "#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float k1;\nuniform float k2;\nuniform float k3;\nuniform float p1;\nuniform float p2;\nvoid main() {\n \tfloat xd=vTextureCoord.x*2.0-1.0; \n    float yd=vTextureCoord.y*2.0-1.0; \n    float rd2=xd*xd+yd*yd;    \n    float xc=xd*(1.0-k1*rd2+k2*rd2*rd2+k3*rd2*rd2*rd2)-2.0*p1*xd*yd+p2*(rd2+2.0*xd*xd); \n   float yc=yd*(1.0-k1*rd2+k2*rd2*rd2+k3*rd2*rd2*rd2)+p1*(rd2+2.0*yd*yd)+2.0*p2*xd*yd; \n   if (xc>1.0||yc>1.0||xc<-1.0||yc<-1.0) { \n   \tgl_FragColor = vec4(0.0, 0.0, 0.0, 1.0); \n   } else { \n\t\tgl_FragColor = texture2D(sTexture, vec2(xc*0.5+0.5, yc*0.5+0.5));\n   } \n }\n";
  protected static final String FRAGMENT_SHADER_INTERNAL = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
  protected static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  protected final boolean isExternal;
  private float k1 = -0.02226907F;
  private float k2 = 0.01961271F;
  private float k3 = 0.00522009F;
  private float p1 = -0.00380254F;
  private float p2 = 0.0F;
  private int u_k1;
  private int u_k2;
  private int u_k3;
  private int u_p1;
  private int u_p2;
  
  public GLUndistortRender(boolean paramBoolean)
  {
    this(paramBoolean, 1.0F);
  }
  
  public GLUndistortRender(boolean paramBoolean, float paramFloat)
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
  
  /* Error */
  protected void preDrawArrays()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDistortionParameters(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.k1 = paramFloat1;
    this.k2 = paramFloat2;
    this.k3 = paramFloat3;
    this.p1 = paramFloat4;
    this.p2 = paramFloat5;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLUndistortRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */