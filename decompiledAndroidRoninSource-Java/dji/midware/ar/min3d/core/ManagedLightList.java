package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.vos.Light;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagedLightList
{
  private ArrayList<Integer> _availGlIndices;
  private boolean[] _glIndexEnabled;
  private boolean[] _glIndexEnabledDirty;
  private HashMap<Light, Integer> _lightToGlIndex;
  private ArrayList<Light> _lights;
  
  public ManagedLightList()
  {
    reset();
  }
  
  public boolean add(Light paramLight)
  {
    return false;
  }
  
  public Light get(int paramInt)
  {
    return null;
  }
  
  int getGlIndexByLight(Light paramLight)
  {
    return 0;
  }
  
  Light getLightByGlIndex(int paramInt)
  {
    return null;
  }
  
  boolean[] glIndexEnabled()
  {
    return this._glIndexEnabled;
  }
  
  boolean[] glIndexEnabledDirty()
  {
    return this._glIndexEnabledDirty;
  }
  
  /* Error */
  public void remove(Light arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void removeAll()
  {
    reset();
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int size()
  {
    return this._lights.size();
  }
  
  public Light[] toArray()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\ManagedLightList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */