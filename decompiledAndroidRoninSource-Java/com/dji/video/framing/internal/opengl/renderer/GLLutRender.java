package com.dji.video.framing.internal.opengl.renderer;

import android.graphics.Bitmap;

public class GLLutRender
  extends GLRenderBase
{
  public static boolean DEBUG = false;
  public static String TAG = "GLLutRender";
  protected static final String VERTEX_SHADER = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
  protected static final String fragmentShader;
  protected final boolean isExternal;
  private int mBlockSize;
  private int mBlockSizeParam;
  private int mHeightBlock;
  private int mHeightBlockParam;
  private Bitmap mLutBmp;
  private int mWidthBlock;
  private int mWidthBlockParam;
  private int musTextureLookupTable = -1;
  private int textureHeight;
  private int textureLookupTableId = -1;
  private int textureWidth;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("//#declare \nprecision highp float;\nvarying highp  vec2 vTextureCoord;\n// varying vec2 vTextureCoord2; // TODO: This is not used\n\nuniform sampler2D sTexture;\nuniform sampler2D lookupTable; // lookup texture\n uniform lowp float widthBlock;\n uniform lowp float heightBlock;\n uniform lowp float blockSize;\n\nvoid main()\n{\n     float intensity = 1.0;\n     vec4 textureColor = texture2D(sTexture, vTextureCoord);\n\n     highp float blueColor = textureColor.b * (blockSize-1.0);\n\n     highp vec2 quad1;\n//floor()返回小于等于x的最大整数值\n     quad1.y = floor(floor(blueColor) / widthBlock);\n     quad1.x = floor(blueColor) - (quad1.y * widthBlock);\n\n     highp vec2 quad2;\n//ceil()返回大于等于x的最小整数值\n     quad2.y = floor(ceil(blueColor) / widthBlock);\n     quad2.x = ceil(blueColor) - (quad2.y * widthBlock);\n\n     highp vec2 texPos1;\n     texPos1.x = (quad1.x / widthBlock) + 0.5/ ( widthBlock * blockSize) + ((blockSize - 1.0)/(widthBlock * blockSize) * textureColor.r);\n     texPos1.y = (quad1.y / heightBlock) + 0.5/ (heightBlock * blockSize) + ((blockSize - 1.0) / (heightBlock * blockSize) * textureColor.g);\n\n     highp vec2 texPos2;\n     texPos2.x = (quad2.x / widthBlock) + 0.5 / (widthBlock * blockSize) + ((blockSize - 1.0) / (widthBlock * blockSize) * textureColor.r);\n     texPos2.y = (quad2.y / heightBlock) + 0.5 / (heightBlock * blockSize) + ((blockSize - 1.0) / (heightBlock * blockSize) * textureColor.g);\n     vec4 newColor1 = texture2D(lookupTable, texPos1);\n     vec4 newColor2 = texture2D(lookupTable, texPos2);\n\n//mix() uses a value from 0-1 to mix the two colors\n//fract() return 参数的小数部分\n     vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n");
    String str;
    if (DEBUG) {
      str = "     if(vTextureCoord.x>=(0.5))\n     {\n           gl_FragColor = texture2D(sTexture, vTextureCoord);     }\n";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("}\n");
    fragmentShader = localStringBuilder.toString();
  }
  
  public GLLutRender(Bitmap paramBitmap, boolean paramBoolean)
  {
    this.mLutBmp = paramBitmap;
    this.isExternal = paramBoolean;
  }
  
  public GLLutRender(boolean paramBoolean)
  {
    this.isExternal = paramBoolean;
  }
  
  /* Error */
  private void updateBitmap(Bitmap arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected String getFragmentShader()
  {
    return null;
  }
  
  protected String getVertexShader()
  {
    return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
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
  
  /* Error */
  public void setLutBmp(Bitmap arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\renderer\GLLutRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */