package dji.publics.widget.util;

public enum CommonEvent
{
  static
  {
    CommonEvent localCommonEvent = new CommonEvent("RcC2Clicked", 1);
    RcC2Clicked = localCommonEvent;
    $VALUES = new CommonEvent[] { RcC1Clicked, localCommonEvent };
  }
  
  private CommonEvent() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widge\\util\CommonEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */