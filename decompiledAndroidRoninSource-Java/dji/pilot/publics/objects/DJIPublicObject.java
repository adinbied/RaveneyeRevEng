package dji.pilot.publics.objects;

public class DJIPublicObject
{
  public static enum CenterSnGetted
  {
    static
    {
      CenterSnGetted localCenterSnGetted = new CenterSnGetted("FAIL", 1);
      FAIL = localCenterSnGetted;
      $VALUES = new CenterSnGetted[] { SUCCESS, localCenterSnGetted };
    }
    
    private CenterSnGetted() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\publics\objects\DJIPublicObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */