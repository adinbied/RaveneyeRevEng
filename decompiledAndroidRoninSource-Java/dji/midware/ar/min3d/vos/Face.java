package dji.midware.ar.min3d.vos;

public class Face
{
  public short a;
  public short b;
  public short c;
  
  public Face(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = ((short)paramInt1);
    this.b = ((short)paramInt2);
    this.c = ((short)paramInt3);
  }
  
  public Face(short paramShort1, short paramShort2, short paramShort3)
  {
    this.a = paramShort1;
    this.b = paramShort2;
    this.c = paramShort3;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ar\min3d\vos\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */