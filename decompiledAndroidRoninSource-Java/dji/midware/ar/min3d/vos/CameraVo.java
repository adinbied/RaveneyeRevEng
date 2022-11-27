package dji.midware.ar.min3d.vos;

public class CameraVo
{
  public float aspect;
  public float fovy;
  public FrustumManaged frustum = new FrustumManaged(null);
  public Number3d position = new Number3d(0.0F, 0.0F, 5.0F);
  public Number3d target = new Number3d(0.0F, 0.0F, 0.0F);
  public Number3d upAxis = new Number3d(0.0F, 1.0F, 0.0F);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\CameraVo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */