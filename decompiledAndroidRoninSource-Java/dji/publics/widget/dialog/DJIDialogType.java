package dji.publics.widget.dialog;

public enum DJIDialogType
{
  static
  {
    MEDIUM = new DJIDialogType("MEDIUM", 1);
    LARGE = new DJIDialogType("LARGE", 2);
    DJIDialogType localDJIDialogType = new DJIDialogType("CUSTOM", 3);
    CUSTOM = localDJIDialogType;
    $VALUES = new DJIDialogType[] { SMALL, MEDIUM, LARGE, localDJIDialogType };
  }
  
  private DJIDialogType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\publics\widget\dialog\DJIDialogType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */