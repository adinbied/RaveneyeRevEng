package dji.midware.data.model.hg702;

public enum CameraParamType
{
  private int data;
  private int size;
  
  static
  {
    CAPTURE_STATUS = new CameraParamType("CAPTURE_STATUS", 2, 3, 1);
    EV_MODE = new CameraParamType("EV_MODE", 3, 4097, 4);
    APERTURE = new CameraParamType("APERTURE", 4, 4098, 4);
    SHUTTER = new CameraParamType("SHUTTER", 5, 4099, 4);
    ISO = new CameraParamType("ISO", 6, 4100, 4);
    EV = new CameraParamType("EV", 7, 4101, 4);
    FOCUS_RNK = new CameraParamType("FOCUS_RNK", 8, 8193, 1);
    ZOOM_RNK = new CameraParamType("ZOOM_RNK", 9, 8194, 1);
    CameraParamType localCameraParamType = new CameraParamType("OTHER", 10, 65535, 1);
    OTHER = localCameraParamType;
    $VALUES = new CameraParamType[] { CAMERA_TYPE, LINE_TYPE, CAPTURE_STATUS, EV_MODE, APERTURE, SHUTTER, ISO, EV, FOCUS_RNK, ZOOM_RNK, localCameraParamType };
  }
  
  private CameraParamType(int paramInt1, int paramInt2)
  {
    this.data = paramInt1;
    this.size = paramInt2;
  }
  
  public static CameraParamType find(int paramInt)
  {
    CameraParamType localCameraParamType = OTHER;
    CameraParamType[] arrayOfCameraParamType = values();
    int i = 0;
    while (i < arrayOfCameraParamType.length)
    {
      if (arrayOfCameraParamType[i]._equals(paramInt)) {
        return arrayOfCameraParamType[i];
      }
      i += 1;
    }
    return localCameraParamType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\CameraParamType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */