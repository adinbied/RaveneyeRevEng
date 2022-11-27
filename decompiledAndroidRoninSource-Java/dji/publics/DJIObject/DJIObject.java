package dji.publics.DJIObject;

public abstract class DJIObject
{
  public DJIObject()
  {
    onCreate();
  }
  
  protected abstract void onCreate();
  
  public abstract void onDestroy();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\DJIObject\DJIObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */