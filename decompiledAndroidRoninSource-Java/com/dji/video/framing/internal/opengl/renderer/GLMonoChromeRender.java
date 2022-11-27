package com.dji.video.framing.internal.opengl.renderer;

public class GLMonoChromeRender
  extends GLRenderBase
{
  private static final String TAG = GLMonoChromeRender.class.getSimpleName();
  private final String FRAGMENT_SHADER = "//#declare\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int vChangeType;\nuniform vec3 vChangeColor;\nvoid main() {\n    lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    if(vChangeType==0){\n        float c=textureColor.r*vChangeColor.r+textureColor.g*vChangeColor.g+textureColor.b*vChangeColor.b;\n        gl_FragColor=vec4(c,c,c,textureColor.a);\n    }else if(vChangeType==1){\n        gl_FragColor=vec4(textureColor.r*vChangeColor.r,textureColor.g*vChangeColor.g,textureColor.b*vChangeColor.b,textureColor.a);\n    }else{\n        gl_FragColor=textureColor;\n    }\n}\n";
  private final String MOMOCHROME_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  private int mChangeColor;
  private int mChangeType;
  private Filter mFilter = Filter.NONE;
  
  public GLMonoChromeRender()
  {
    this(Filter.NONE);
  }
  
  public GLMonoChromeRender(Filter paramFilter)
  {
    this.mFilter = paramFilter;
  }
  
  protected String getFragmentShader()
  {
    return "//#declare\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform int vChangeType;\nuniform vec3 vChangeColor;\nvoid main() {\n    lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    if(vChangeType==0){\n        float c=textureColor.r*vChangeColor.r+textureColor.g*vChangeColor.g+textureColor.b*vChangeColor.b;\n        gl_FragColor=vec4(c,c,c,textureColor.a);\n    }else if(vChangeType==1){\n        gl_FragColor=vec4(textureColor.r*vChangeColor.r,textureColor.g*vChangeColor.g,textureColor.b*vChangeColor.b,textureColor.a);\n    }else{\n        gl_FragColor=textureColor;\n    }\n}\n";
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
  
  public void setFilter(Filter paramFilter)
  {
    this.mFilter = paramFilter;
  }
  
  public static enum Filter
  {
    private float[] data;
    private int vChangeType;
    
    static
    {
      GREEN = new Filter("GREEN", 3, 1, new float[] { 0.0F, 1.0F, 0.0F });
      Filter localFilter = new Filter("BLUE", 4, 1, new float[] { 0.0F, 0.0F, 1.0F });
      BLUE = localFilter;
      $VALUES = new Filter[] { GRAY, NONE, RED, GREEN, localFilter };
    }
    
    private Filter(int paramInt, float[] paramArrayOfFloat)
    {
      this.vChangeType = paramInt;
      this.data = paramArrayOfFloat;
    }
    
    public float[] data()
    {
      return this.data;
    }
    
    public int getType()
    {
      return this.vChangeType;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLMonoChromeRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */