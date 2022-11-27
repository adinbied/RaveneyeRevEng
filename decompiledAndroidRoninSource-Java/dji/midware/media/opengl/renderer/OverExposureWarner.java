package dji.midware.media.opengl.renderer;

public class OverExposureWarner
  extends GLRenderBase
{
  private static final String TAG = "OverExposureWarner";
  private static String fragmentShader = "//#declare \nvarying highp vec2 v_texcoord; \nvarying highp vec4 v_overexp_texcoord; \nuniform sampler2D sTexture; \nuniform sampler2D s_texture_overexp; \n// use alpha channel to store lumaince \n// const highp vec4 luminanceVec = vec4(0.2126, 0.7152, 0.0722, 1.0); \nvoid main() \n{\t  \n  \t//get rgb color \n\t\thighp vec4 rgb_color = texture2D(sTexture, v_texcoord); \n//get over exposed texture color \n     highp vec4 over_exposed_tex_color = vec4(texture2D(s_texture_overexp, v_overexp_texcoord.xy).a);  \n     highp float lumaince = 0.2568*rgb_color.r+0.5041*rgb_color.g+0.0979*rgb_color.b+0.0625;  \n     highp float blend_factor = clamp(lumaince*64.0 - v_overexp_texcoord.w, 0.0 ,1.0)*v_overexp_texcoord.z;  \n     highp vec4 ret_color = mix(rgb_color, over_exposed_tex_color, blend_factor); \n    gl_FragColor = vec4(ret_color.xyz, 1.0);  \n }  \n";
  private static String vertexShader = "attribute vec4 aPosition; \nattribute vec4 aTextureCoord; \nuniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\n//x:width in {0, 1}, y:height in {0, 1} z:offset in {0, 1}, w:blend factor \nuniform vec4 overexp_texture_param; \nvarying vec2 v_texcoord; \nvarying vec4 v_overexp_texcoord; \n \t void main() \n\t { \n\t     gl_Position = uMVPMatrix * aPosition; \n\t     v_texcoord = (uSTMatrix * aTextureCoord).xy; \n\t     v_overexp_texcoord = vec4(v_texcoord.x * overexp_texture_param.x + overexp_texture_param.z,\t                               v_texcoord.y * overexp_texture_param.y,\t                               ceil(overexp_texture_param.w), overexp_texture_param.w*64.0); \n\t } \n";
  private int bw_texture_height;
  private int bw_texture_width;
  private boolean isExternal;
  private int mus_texture_overexp;
  private int overexp_texture_param;
  private long start_time_ms;
  private int textureResID = 0;
  private int texture_overexp_ID = -1;
  
  public OverExposureWarner(boolean paramBoolean, int paramInt)
  {
    this.isExternal = paramBoolean;
    this.textureResID = paramInt;
  }
  
  protected String getFragmentShader()
  {
    return null;
  }
  
  protected String getVertexShader()
  {
    return vertexShader;
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
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class OverExposureWarnerStatus
  {
    public boolean enable = false;
    public int resID = 0;
    
    public OverExposureWarnerStatus(boolean paramBoolean, int paramInt)
    {
      this.enable = paramBoolean;
      this.resID = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\renderer\OverExposureWarner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */