package com.dji.video.framing.internal.opengl.renderer;

public class GLPseudoRender
  extends GLRenderBase
{
  private static final String TAG = GLPseudoRender.class.getSimpleName();
  private final String FRAGMENT_SHADER = "//#declare\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    vec3 yuv;\n    yuv.r = 0.299 * textureColor.r + 0.587 * textureColor.g + 0.114 * textureColor.b;\n    if ( yuv.r > 0.64 ) {\n        gl_FragColor=vec4(1 , 0 , 0 ,textureColor.a);\n    } else if ( yuv.r < 0.125 ){ \n        gl_FragColor = vec4 ( 0 , 0 , 1 , textureColor.a );\n    } else { \n        gl_FragColor = textureColor;\n    } \n} \n";
  private final String PSEUDO_VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  
  protected String getFragmentShader()
  {
    return "//#declare\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    lowp vec4 textureColor = texture2D(sTexture, vTextureCoord);\n    vec3 yuv;\n    yuv.r = 0.299 * textureColor.r + 0.587 * textureColor.g + 0.114 * textureColor.b;\n    if ( yuv.r > 0.64 ) {\n        gl_FragColor=vec4(1 , 0 , 0 ,textureColor.a);\n    } else if ( yuv.r < 0.125 ){ \n        gl_FragColor = vec4 ( 0 , 0 , 1 , textureColor.a );\n    } else { \n        gl_FragColor = textureColor;\n    } \n} \n";
  }
  
  protected String getVertexShader()
  {
    return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  }
  
  protected void onInit() {}
  
  protected void preDrawArrays() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLPseudoRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */