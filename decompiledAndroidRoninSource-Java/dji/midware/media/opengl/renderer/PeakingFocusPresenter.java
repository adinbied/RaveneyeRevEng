package dji.midware.media.opengl.renderer;

public class PeakingFocusPresenter
  extends GLRenderBase
{
  public static boolean DEBUG = false;
  protected static final String FRAGMENT_SHADER_EXTERNAL = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying highp vec2 v_texcoord;\n varying highp vec4 v_overexp_texcoord;\n \n uniform samplerExternalOES sTexture;\n //const highp vec4 dxdy = vec4(widthReci,heightReci,2.0,0)\n\n //texcord of left right top bottom\n const highp vec4 range = vec4(0,1.0,0,1.0);\n uniform float widthReci;\n uniform float heightReci;\n uniform float threshold;\n \n const highp vec4 RED = vec4(1.0,0,0,1.0);\n const highp vec4 GREEN = vec4(0,1.0,0,1.0);\n const highp vec4 BLUE = vec4(0,0,1.0,1.0);\n \nhighp vec4 sample(highp float dx, highp float dy)\n{\n    highp vec2 dif = vec2(dx,dy);\n    highp vec2 texcord = v_texcoord.st+dif;\n    \n    highp vec4 min_range = step(vec4(range.xz, texcord), vec4(texcord, range.yw));\n    texcord = v_texcoord.st + min_range.x*min_range.y*min_range.z*min_range.w*dif;\n    \n//    texcord = clamp(texcord, vec2(0,0), vec2(1.0,1.0));\n    return texture2D(sTexture, texcord);\n}\n \n highp vec4 sampleNoClamp(highp float dx, highp float dy)\n{\n    highp vec2 texcord = v_texcoord.st+vec2(dx,dy);\n    return texture2D(sTexture, texcord);\n}\n \nhighp float mag(highp vec4 p)\n{\n    return length(p.rgb);\n}\n \n void main()\n {\n     float blockWidth = 1.5*widthReci;\n     float blockHeight = 1.5*heightReci;\n     float c1 = mod(v_texcoord.x, 2.0*blockWidth);  \n     c1 = step(blockWidth, c1);  \n     float c2 = mod(v_texcoord.y, 2.0*blockHeight);  \n     c2 = step(blockHeight, c2); \n     float horRange = 0.99;\n     float verRange = 0.97;\n     if (c1*c2>0.0 || v_texcoord.x > (horRange) || v_texcoord.y > (verRange) || v_texcoord.x < (1.0-horRange) || v_texcoord.y < (1.0-verRange)) {\n          gl_FragColor = sampleNoClamp(0.0, 0.0);\n     }\n     else {\n     vec4 leftTop = sampleNoClamp(-widthReci,+heightReci);\n     vec4 midTop = sampleNoClamp(0.0,+heightReci);\n     vec4 rightTop = sampleNoClamp(+widthReci,+heightReci);\n     vec4 leftMid = sampleNoClamp(-widthReci,0.0);\n     vec4 midMid = sampleNoClamp(0.0,0.0);     vec4 rightMid = sampleNoClamp(+widthReci,0.0);\n     vec4 leftBottom = sampleNoClamp(-widthReci,-heightReci);\n     vec4 midBottom = sampleNoClamp(0.0,-heightReci);\n     vec4 rightBottom = sampleNoClamp(+widthReci,-heightReci);\n     gl_FragColor = midMid;\n     highp float MAG = length((-6.834 * leftBottom+2.142 * midBottom-6.834 * rightBottom+2.142 * leftMid+18.717* midMid+2.142 * rightMid-6.834 * leftTop+2.142 * midTop-6.834 * rightTop).rgb);\n     if(MAG>threshold)         gl_FragColor = vec4(RED.xyz, gl_FragColor.a);\n }\n }\n";
  protected static final String FRAGMENT_SHADER_INTERNAL = "precision mediump float;\nvarying highp vec2 v_texcoord;\n varying highp vec4 v_overexp_texcoord;\n \nuniform sampler2D sTexture;\n //const highp vec4 dxdy = vec4(widthReci,heightReci,2.0,0)\n\n //texcord of left right top bottom\n const highp vec4 range = vec4(0,1.0,0,1.0);\n uniform float widthReci;\n uniform float heightReci;\n uniform float threshold;\n \n const highp vec4 RED = vec4(1.0,0,0,1.0);\n const highp vec4 GREEN = vec4(0,1.0,0,1.0);\n const highp vec4 BLUE = vec4(0,0,1.0,1.0);\n \nhighp vec4 sample(highp float dx, highp float dy)\n{\n    highp vec2 dif = vec2(dx,dy);\n    highp vec2 texcord = v_texcoord.st+dif;\n    \n    highp vec4 min_range = step(vec4(range.xz, texcord), vec4(texcord, range.yw));\n    texcord = v_texcoord.st + min_range.x*min_range.y*min_range.z*min_range.w*dif;\n    \n//    texcord = clamp(texcord, vec2(0,0), vec2(1.0,1.0));\n    return texture2D(sTexture, texcord);\n}\n \n highp vec4 sampleNoClamp(highp float dx, highp float dy)\n{\n    highp vec2 texcord = v_texcoord.st+vec2(dx,dy);\n    return texture2D(sTexture, texcord);\n}\n \nhighp float mag(highp vec4 p)\n{\n    return length(p.rgb);\n}\n \n void main()\n {\n     vec4 leftTop = sample(-widthReci,+heightReci);\n     vec4 midTop = sample(0.0,+heightReci);\n     vec4 rightTop = sample(+widthReci,+heightReci);\n     vec4 leftMid = sample(-widthReci,0.0);\n     vec4 midMid = sample(0.0,0.0);     vec4 rightMid = sample(+widthReci,0.0);\n     vec4 leftBottom = sample(-widthReci,-heightReci);\n     vec4 midBottom = sample(0.0,-heightReci);\n     vec4 rightBottom = sample(+widthReci,-heightReci);\n     gl_FragColor = sampleNoClamp(0.0, 0.0);\n     highp float MAG = length((-6.834 * leftBottom+2.142 * midBottom-6.834 * rightBottom+2.142 * leftMid+18.717* midMid+2.142 * rightMid-6.834 * leftTop+2.142 * midTop-6.834 * rightTop).rgb);\n     if(MAG>threshold) gl_FragColor = vec4(RED.xyz, gl_FragColor.a);\n }\n";
  public static String TAG = "PeakingFocusPresenter";
  protected static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 v_texcoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    v_texcoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private int dxdyParam;
  private int height = 0;
  private int heightReciParam;
  protected final boolean isExternal;
  private float rangeBottom = 0.0F;
  private float rangeLeft = 0.0F;
  private int rangeParam;
  private float rangeRight = 1.0F;
  private float rangeTop = 1.0F;
  private float threshold = 2.7F;
  private int thresholdParam;
  private int width = 0;
  private int widthReciParam;
  
  public PeakingFocusPresenter(boolean paramBoolean)
  {
    this.isExternal = paramBoolean;
  }
  
  protected String getFragmentShader()
  {
    return null;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public float getThreshold()
  {
    return this.threshold;
  }
  
  protected String getVertexShader()
  {
    return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 v_texcoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    v_texcoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void init()
  {
    super.init();
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
  
  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public void setThreshold(float paramFloat)
  {
    this.threshold = paramFloat;
  }
  
  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\renderer\PeakingFocusPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */