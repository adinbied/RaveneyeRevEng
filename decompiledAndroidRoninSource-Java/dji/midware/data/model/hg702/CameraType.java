package dji.midware.data.model.hg702;

public enum CameraType
{
  private int data;
  
  static
  {
    DJICameraTypeHasselH6D_100C = new CameraType("DJICameraTypeHasselH6D_100C", 1, 167);
    DJICameraTypeRed = new CameraType("DJICameraTypeRed", 2, 168);
    DJICameraTypeArri = new CameraType("DJICameraTypeArri", 3, 169);
    DJICameraTypeUSBNikon = new CameraType("DJICameraTypeUSBNikon", 4, 173);
    DJICameraTypeThirdParty_Sony = new CameraType("DJICameraTypeThirdParty_Sony", 5, 174);
    DJICameraTypeThirdParty_Panasonic = new CameraType("DJICameraTypeThirdParty_Panasonic", 6, 175);
    DJICameraTypeThirdParty_Canon = new CameraType("DJICameraTypeThirdParty_Canon", 7, 176);
    DJICameraTypeThirdParty_DefaultSony = new CameraType("DJICameraTypeThirdParty_DefaultSony", 8, 177);
    DJICameraTypeThirdParty_Hassel = new CameraType("DJICameraTypeThirdParty_Hassel", 9, 178);
    DJICameraTypeThirdParty_FUJI = new CameraType("DJICameraTypeThirdParty_FUJI", 10, 179);
    DJICameraTypeThirdParty_BMPCC = new CameraType("DJICameraTypeThirdParty_BMPCC", 11, 180);
    DJICameraTypeThirdParty_ZCam = new CameraType("DJICameraTypeThirdParty_ZCam", 12, 181);
    DJICameraTypeThirdParty_OLYMPUS = new CameraType("DJICameraTypeThirdParty_OLYMPUS", 13, 182);
    DJICameraTypeThirdParty_SIGMA = new CameraType("DJICameraTypeThirdParty_SIGMA", 14, 183);
    DJICameraTypeThirdParty_GENERAL = new CameraType("DJICameraTypeThirdParty_GENERAL", 15, 254);
    CameraType localCameraType = new CameraType("OTHER", 16, 255);
    OTHER = localCameraType;
    $VALUES = new CameraType[] { DJICameraTypeHasselH6D_50C, DJICameraTypeHasselH6D_100C, DJICameraTypeRed, DJICameraTypeArri, DJICameraTypeUSBNikon, DJICameraTypeThirdParty_Sony, DJICameraTypeThirdParty_Panasonic, DJICameraTypeThirdParty_Canon, DJICameraTypeThirdParty_DefaultSony, DJICameraTypeThirdParty_Hassel, DJICameraTypeThirdParty_FUJI, DJICameraTypeThirdParty_BMPCC, DJICameraTypeThirdParty_ZCam, DJICameraTypeThirdParty_OLYMPUS, DJICameraTypeThirdParty_SIGMA, DJICameraTypeThirdParty_GENERAL, localCameraType };
  }
  
  private CameraType(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static CameraType find(int paramInt)
  {
    CameraType localCameraType = OTHER;
    CameraType[] arrayOfCameraType = values();
    int i = 0;
    while (i < arrayOfCameraType.length)
    {
      if (arrayOfCameraType[i]._equals(paramInt)) {
        return arrayOfCameraType[i];
      }
      i += 1;
    }
    return localCameraType;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\CameraType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */