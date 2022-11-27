package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.TextureVo;
import java.util.ArrayList;

public class TextureList
{
  private ArrayList<TextureVo> _t = new ArrayList();
  
  public void add(int paramInt, TextureVo paramTextureVo)
  {
    this._t.add(paramInt, paramTextureVo);
  }
  
  public boolean add(TextureVo paramTextureVo)
  {
    return false;
  }
  
  public TextureVo addById(String paramString)
  {
    return null;
  }
  
  public boolean addReplace(TextureVo paramTextureVo)
  {
    return false;
  }
  
  public void clear()
  {
    this._t.clear();
  }
  
  public TextureVo get(int paramInt)
  {
    return null;
  }
  
  public TextureVo getById(String paramString)
  {
    return null;
  }
  
  public String[] getIds()
  {
    return null;
  }
  
  public boolean remove(TextureVo paramTextureVo)
  {
    return this._t.remove(paramTextureVo);
  }
  
  /* Error */
  public void removeAll()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean removeById(String paramString)
  {
    return false;
  }
  
  public int size()
  {
    return this._t.size();
  }
  
  public TextureVo[] toArray()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\TextureList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */