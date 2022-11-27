package dji.midware.ar.min3d.vos;

import dji.midware.ar.min3d.Utils;
import dji.midware.ar.min3d.interfaces.IDirtyParent;
import java.nio.FloatBuffer;

public class Light
  extends AbstractDirtyManaged
  implements IDirtyParent
{
  public Number3dManaged _attenuation = new Number3dManaged(1.0F, 0.0F, 0.0F, this);
  public BooleanManaged _isVisible = new BooleanManaged(true, this);
  public FloatBuffer _positionAndTypeBuffer = Utils.makeFloatBuffer4(0.0F, 0.0F, 0.0F, 0.0F);
  public FloatManaged _spotCutoffAngle = new FloatManaged(180.0F, this);
  public FloatManaged _spotExponent = new FloatManaged(0.0F, this);
  private LightType _type = LightType.DIRECTIONAL;
  public Color4Managed ambient = new Color4Managed(205, 205, 205, 255, this);
  public Color4Managed diffuse = new Color4Managed(0, 0, 0, 255, this);
  public Number3dManaged direction = new Number3dManaged(0.0F, 0.0F, -1.0F, this);
  public Color4Managed emissive = new Color4Managed(0, 0, 0, 255, this);
  public Number3dManaged position = new Number3dManaged(0.0F, 0.0F, 1.0F, this);
  public Color4Managed specular = new Color4Managed(0, 0, 0, 255, this);
  
  public Light()
  {
    super(null);
    setDirtyFlag();
  }
  
  public float attenuationConstant()
  {
    return this._attenuation.getX();
  }
  
  /* Error */
  public void attenuationConstant(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public float attenuationLinear()
  {
    return this._attenuation.getY();
  }
  
  /* Error */
  public void attenuationLinear(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public float attenuationQuadratic()
  {
    return this._attenuation.getZ();
  }
  
  /* Error */
  public void attenuationQuadratic(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attenuationSetAll(float arg1, float arg2, float arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore 4
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void commitPositionAndTypeBuffer()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void isVisible(Boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isVisible()
  {
    return this._isVisible.get();
  }
  
  public void onDirty()
  {
    setDirtyFlag();
  }
  
  /* Error */
  public void setAllDirty()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public float spotCutoffAngle()
  {
    return this._spotCutoffAngle.get();
  }
  
  /* Error */
  public void spotCutoffAngle(Float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void spotCutoffAngleNone()
  {
    this._spotCutoffAngle.set(180.0F);
  }
  
  public float spotExponent()
  {
    return this._spotExponent.get();
  }
  
  /* Error */
  public void spotExponent(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public LightType type()
  {
    return this._type;
  }
  
  public void type(LightType paramLightType)
  {
    this._type = paramLightType;
    this.position.setDirtyFlag();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Light.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */