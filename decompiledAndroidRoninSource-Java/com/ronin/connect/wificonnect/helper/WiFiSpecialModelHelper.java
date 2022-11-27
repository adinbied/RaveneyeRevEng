package com.ronin.connect.wificonnect.helper;

import java.util.HashMap;
import java.util.Map;

public class WiFiSpecialModelHelper
{
  private static volatile WiFiSpecialModelHelper instance;
  private final String TAG = "WiFiSpecialModelHelper";
  private boolean isChecked;
  private boolean isSpecialModel;
  private final Map<String, BrandModel> specialTypeMap = new HashMap();
  private final Map<String, BrandModel> whiteTypeMap = new HashMap();
  
  private WiFiSpecialModelHelper()
  {
    this.specialTypeMap.clear();
    this.specialTypeMap.put(BrandModel.LG.getTag(), BrandModel.LG);
    this.whiteTypeMap.clear();
    this.whiteTypeMap.put(BrandModel.EMUI.getTag(), BrandModel.EMUI);
    this.whiteTypeMap.put(BrandModel.MIUI.getTag(), BrandModel.MIUI);
    this.whiteTypeMap.put(BrandModel.SAMSUNG.getTag(), BrandModel.SAMSUNG);
    this.whiteTypeMap.put(BrandModel.ONEPLUS.getTag(), BrandModel.ONEPLUS);
    this.whiteTypeMap.put(BrandModel.OPPO.getTag(), BrandModel.OPPO);
    this.whiteTypeMap.put(BrandModel.PIXEL.getTag(), BrandModel.PIXEL);
    this.whiteTypeMap.put(BrandModel.VIVO.getTag(), BrandModel.VIVO);
    this.whiteTypeMap.put(BrandModel.SONY.getTag(), BrandModel.SONY);
  }
  
  public static WiFiSpecialModelHelper getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new WiFiSpecialModelHelper();
        }
      }
      finally {}
    }
    return instance;
  }
  
  /* Error */
  private void saveLog(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean isSpecialModel()
  {
    return false;
  }
  
  public static enum BrandModel
  {
    private String tag;
    private int versionLevel;
    
    static
    {
      ONEPLUS = new BrandModel("ONEPLUS", 3, "OnePlus", 29);
      PIXEL = new BrandModel("PIXEL", 4, "Google", 29);
      OPPO = new BrandModel("OPPO", 5, "OPPO", 29);
      VIVO = new BrandModel("VIVO", 6, "vivo", 29);
      SONY = new BrandModel("SONY", 7, "Sony", 29);
      FLYME = new BrandModel("FLYME", 8, "MEIZU", 29);
      BrandModel localBrandModel = new BrandModel("LG", 9, "LGE", 29);
      LG = localBrandModel;
      $VALUES = new BrandModel[] { EMUI, MIUI, SAMSUNG, ONEPLUS, PIXEL, OPPO, VIVO, SONY, FLYME, localBrandModel };
    }
    
    private BrandModel(String paramString, int paramInt)
    {
      this.tag = paramString;
      this.versionLevel = paramInt;
    }
    
    public String getTag()
    {
      return this.tag.toUpperCase();
    }
    
    public int getVersionLevel()
    {
      return this.versionLevel;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\ronin\connect\wificonnect\helper\WiFiSpecialModelHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */