package dji.publics.DJIKit;

public class DJIMath
{
  public static float getNiceValue(float paramFloat1, float paramFloat2)
  {
    if (paramFloat1 > 0.0F) {
      return Math.min(paramFloat2, paramFloat1);
    }
    return Math.max(-paramFloat2, paramFloat1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIKit\DJIMath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */