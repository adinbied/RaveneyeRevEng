package dji.midware.ar.min3d.core;

import dji.log.RoninLog;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class RenderCaps
{
  private static int _aliasedLineSizeMax;
  private static int _aliasedLineSizeMin;
  private static int _aliasedPointSizeMax;
  private static int _aliasedPointSizeMin;
  private static boolean _isGl10Only;
  private static int _maxLights;
  private static int _maxTextureSize;
  private static int _maxTextureUnits;
  private static float _openGlVersion;
  private static int _smoothLineSizeMax;
  private static int _smoothLineSizeMin;
  private static int _smoothPointSizeMax;
  private static int _smoothPointSizeMin;
  
  public static int aliasedLineSizeMax()
  {
    return _aliasedLineSizeMax;
  }
  
  public static int aliasedLineSizeMin()
  {
    return _aliasedLineSizeMin;
  }
  
  public static int aliasedPointSizeMax()
  {
    return _aliasedPointSizeMax;
  }
  
  public static int aliasedPointSizeMin()
  {
    return _aliasedPointSizeMin;
  }
  
  public static boolean isGl10Only()
  {
    return _isGl10Only;
  }
  
  public static int maxLights()
  {
    return _maxLights;
  }
  
  public static int maxTextureUnits()
  {
    return _maxTextureUnits;
  }
  
  public static float openGlVersion()
  {
    return _openGlVersion;
  }
  
  static void setRenderCaps(GL10 paramGL10)
  {
    if ((paramGL10 instanceof GL11)) {
      _openGlVersion = 1.1F;
    } else {
      _openGlVersion = 1.0F;
    }
    IntBuffer localIntBuffer = IntBuffer.allocate(1);
    paramGL10.glGetIntegerv(34018, localIntBuffer);
    _maxTextureUnits = localIntBuffer.get(0);
    localIntBuffer = IntBuffer.allocate(1);
    paramGL10.glGetIntegerv(3379, localIntBuffer);
    _maxTextureSize = localIntBuffer.get(0);
    localIntBuffer = IntBuffer.allocate(2);
    paramGL10.glGetIntegerv(33901, localIntBuffer);
    _aliasedPointSizeMin = localIntBuffer.get(0);
    _aliasedPointSizeMax = localIntBuffer.get(1);
    localIntBuffer = IntBuffer.allocate(2);
    paramGL10.glGetIntegerv(2834, localIntBuffer);
    _smoothPointSizeMin = localIntBuffer.get(0);
    _smoothPointSizeMax = localIntBuffer.get(1);
    localIntBuffer = IntBuffer.allocate(2);
    paramGL10.glGetIntegerv(33902, localIntBuffer);
    _aliasedLineSizeMin = localIntBuffer.get(0);
    _aliasedLineSizeMax = localIntBuffer.get(1);
    localIntBuffer = IntBuffer.allocate(2);
    paramGL10.glGetIntegerv(2850, localIntBuffer);
    _smoothLineSizeMin = localIntBuffer.get(0);
    _smoothLineSizeMax = localIntBuffer.get(1);
    localIntBuffer = IntBuffer.allocate(1);
    paramGL10.glGetIntegerv(3377, localIntBuffer);
    _maxLights = localIntBuffer.get(0);
    paramGL10 = new StringBuilder();
    paramGL10.append("RenderCaps - openGLVersion: ");
    paramGL10.append(_openGlVersion);
    RoninLog.v("Min3D", paramGL10.toString(), new Object[0]);
    paramGL10 = new StringBuilder();
    paramGL10.append("RenderCaps - maxTextureUnits: ");
    paramGL10.append(_maxTextureUnits);
    RoninLog.v("Min3D", paramGL10.toString(), new Object[0]);
    paramGL10 = new StringBuilder();
    paramGL10.append("RenderCaps - maxTextureSize: ");
    paramGL10.append(_maxTextureSize);
    RoninLog.v("Min3D", paramGL10.toString(), new Object[0]);
    paramGL10 = new StringBuilder();
    paramGL10.append("RenderCaps - maxLights: ");
    paramGL10.append(_maxLights);
    RoninLog.v("Min3D", paramGL10.toString(), new Object[0]);
  }
  
  public static int smoothLineSizeMax()
  {
    return _smoothLineSizeMax;
  }
  
  public static int smoothLineSizeMin()
  {
    return _smoothLineSizeMin;
  }
  
  public static int smoothPointSizeMax()
  {
    return _smoothPointSizeMax;
  }
  
  public static int smoothPointSizeMin()
  {
    return _smoothPointSizeMin;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\RenderCaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */