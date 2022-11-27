package dji.midware.ar.min3d.vos;

import java.util.ArrayList;

public class TextureVo
{
  public float offsetU = 0.0F;
  public float offsetV = 0.0F;
  public boolean repeatU = true;
  public boolean repeatV = true;
  public ArrayList<TexEnvxVo> textureEnvs;
  public String textureId;
  
  public TextureVo(String paramString)
  {
    this.textureId = paramString;
    paramString = new ArrayList();
    this.textureEnvs = paramString;
    paramString.add(new TexEnvxVo());
  }
  
  public TextureVo(String paramString, ArrayList<TexEnvxVo> paramArrayList)
  {
    this.textureId = paramString;
    this.textureEnvs = paramArrayList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\TextureVo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */