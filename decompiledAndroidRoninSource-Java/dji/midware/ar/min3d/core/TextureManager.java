package dji.midware.ar.min3d.core;

import android.graphics.Bitmap;
import java.util.HashMap;

public class TextureManager
{
  private static int _atlasId = 0;
  private static int _counter = 1000001;
  private HashMap<String, Boolean> _idToHasMipMap;
  private HashMap<String, Integer> _idToTextureName;
  
  public TextureManager()
  {
    reset();
  }
  
  private String arrayToString(String[] paramArrayOfString)
  {
    return null;
  }
  
  /* Error */
  private void logContents()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String addTextureId(Bitmap paramBitmap, String paramString)
  {
    return addTextureId(paramBitmap, paramString, false);
  }
  
  public String addTextureId(Bitmap paramBitmap, String paramString, boolean paramBoolean)
  {
    return null;
  }
  
  public boolean contains(String paramString)
  {
    return this._idToTextureName.containsKey(paramString);
  }
  
  public String createTextureId(Bitmap paramBitmap, boolean paramBoolean)
  {
    return null;
  }
  
  /* Error */
  public void deleteTexture(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  int getGlTextureId(String paramString)
  {
    return 0;
  }
  
  public String getNewAtlasId()
  {
    return null;
  }
  
  public String[] getTextureIds()
  {
    return null;
  }
  
  boolean hasMipMap(String paramString)
  {
    return false;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\TextureManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */