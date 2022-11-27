package dji.midware.ar.min3d.vos;

public class Number3d
{
  private static Number3d _temp = new Number3d();
  public float x;
  public float y;
  public float z;
  
  public Number3d()
  {
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
  }
  
  public Number3d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public static Number3d add(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    return new Number3d(paramNumber3d1.x + paramNumber3d2.x, paramNumber3d1.y + paramNumber3d2.y, paramNumber3d1.z + paramNumber3d2.z);
  }
  
  public static Number3d cross(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    float f1 = paramNumber3d2.y;
    float f2 = paramNumber3d1.z;
    float f3 = paramNumber3d2.z;
    float f4 = paramNumber3d1.y;
    float f5 = paramNumber3d1.x;
    float f6 = paramNumber3d2.x;
    return new Number3d(f1 * f2 - f3 * f4, f3 * f5 - f2 * f6, f6 * f4 - f1 * f5);
  }
  
  public static float dot(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    return paramNumber3d1.x * paramNumber3d2.x + paramNumber3d1.y * paramNumber3d2.y + paramNumber3d2.z * paramNumber3d1.z;
  }
  
  public static Number3d multiply(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    return new Number3d(paramNumber3d1.x * paramNumber3d2.x, paramNumber3d1.y * paramNumber3d2.y, paramNumber3d1.z * paramNumber3d2.z);
  }
  
  public static Number3d subtract(Number3d paramNumber3d1, Number3d paramNumber3d2)
  {
    return new Number3d(paramNumber3d1.x - paramNumber3d2.x, paramNumber3d1.y - paramNumber3d2.y, paramNumber3d1.z - paramNumber3d2.z);
  }
  
  /* Error */
  public void add(Number3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Number3d clone()
  {
    return null;
  }
  
  public float length()
  {
    return 0.0F;
  }
  
  /* Error */
  public void multiply(Float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void normalize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void rotateX(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void rotateY(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void rotateZ(float arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setAll(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  /* Error */
  public void setAllFrom(Number3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void subtract(Number3d arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Number3d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */