package dji.midware.ar.min3d.core;

import dji.midware.ar.min3d.interfaces.IDirtyParent;
import dji.midware.ar.min3d.interfaces.IObject3dContainer;
import dji.midware.ar.min3d.interfaces.ISceneController;
import dji.midware.ar.min3d.vos.CameraVo;
import dji.midware.ar.min3d.vos.Color4;
import dji.midware.ar.min3d.vos.Color4Managed;
import dji.midware.ar.min3d.vos.FogType;
import java.util.ArrayList;

public class Scene
  implements IObject3dContainer, IDirtyParent
{
  private Color4Managed _backgroundColor;
  private CameraVo _camera;
  private ArrayList<Object3d> _children = new ArrayList();
  private Color4 _fogColor;
  private boolean _fogEnabled;
  private float _fogFar;
  private float _fogNear;
  private FogType _fogType;
  private boolean _lightingEnabled;
  private ManagedLightList _lights;
  private ISceneController _sceneController;
  
  public Scene(ISceneController paramISceneController)
  {
    this._sceneController = paramISceneController;
    this._lights = new ManagedLightList();
    this._fogColor = new Color4(255, 255, 255, 255);
    this._fogNear = 0.0F;
    this._fogFar = 10.0F;
    this._fogType = FogType.LINEAR;
    this._fogEnabled = false;
  }
  
  /* Error */
  private void clearChildren(IObject3dContainer arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addChild(Object3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addChildAt(Object3d arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Color4Managed backgroundColor()
  {
    return this._backgroundColor;
  }
  
  public CameraVo camera()
  {
    return this._camera;
  }
  
  public void camera(CameraVo paramCameraVo)
  {
    this._camera = paramCameraVo;
  }
  
  ArrayList<Object3d> children()
  {
    return this._children;
  }
  
  public Color4 fogColor()
  {
    return this._fogColor;
  }
  
  public void fogColor(Color4 paramColor4)
  {
    this._fogColor = paramColor4;
  }
  
  public void fogEnabled(boolean paramBoolean)
  {
    this._fogEnabled = paramBoolean;
  }
  
  public boolean fogEnabled()
  {
    return this._fogEnabled;
  }
  
  public float fogFar()
  {
    return this._fogFar;
  }
  
  public void fogFar(float paramFloat)
  {
    this._fogFar = paramFloat;
  }
  
  public float fogNear()
  {
    return this._fogNear;
  }
  
  public void fogNear(float paramFloat)
  {
    this._fogNear = paramFloat;
  }
  
  public FogType fogType()
  {
    return this._fogType;
  }
  
  public void fogType(FogType paramFogType)
  {
    this._fogType = paramFogType;
  }
  
  public Object3d getChildAt(int paramInt)
  {
    return null;
  }
  
  public Object3d getChildByName(String paramString)
  {
    return null;
  }
  
  public int getChildIndexOf(Object3d paramObject3d)
  {
    return this._children.indexOf(paramObject3d);
  }
  
  /* Error */
  void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void lightingEnabled(boolean paramBoolean)
  {
    this._lightingEnabled = paramBoolean;
  }
  
  public boolean lightingEnabled()
  {
    return this._lightingEnabled;
  }
  
  public ManagedLightList lights()
  {
    return this._lights;
  }
  
  public int numChildren()
  {
    return this._children.size();
  }
  
  public void onDirty() {}
  
  public boolean removeChild(Object3d paramObject3d)
  {
    return false;
  }
  
  public Object3d removeChildAt(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void reset()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ISceneController sceneController()
  {
    return this._sceneController;
  }
  
  public void sceneController(ISceneController paramISceneController)
  {
    this._sceneController = paramISceneController;
  }
  
  /* Error */
  void update()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\core\Scene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */