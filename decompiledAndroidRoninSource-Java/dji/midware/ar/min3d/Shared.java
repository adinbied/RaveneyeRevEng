package dji.midware.ar.min3d;

import android.content.Context;
import dji.midware.ar.min3d.core.Renderer;
import dji.midware.ar.min3d.core.TextureManager;

public class Shared
{
  private static Context _context;
  private static Renderer _renderer;
  private static TextureManager _textureManager;
  
  public static Context context()
  {
    return _context;
  }
  
  public static void context(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    } else {
      paramContext = paramContext.getApplicationContext();
    }
    _context = paramContext;
  }
  
  public static Renderer renderer()
  {
    return _renderer;
  }
  
  public static void renderer(Renderer paramRenderer)
  {
    _renderer = paramRenderer;
  }
  
  public static TextureManager textureManager()
  {
    return _textureManager;
  }
  
  public static void textureManager(TextureManager paramTextureManager)
  {
    _textureManager = paramTextureManager;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\Shared.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */