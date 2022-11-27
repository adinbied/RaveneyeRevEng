package dji.common.product;

public enum Model
{
  private String value;
  
  static
  {
    PHANTOM_4 = new Model("PHANTOM_4", 9, "Phantom 4");
    PHANTOM_4_PRO = new Model("PHANTOM_4_PRO", 10, "Phantom 4 Pro");
    OSMO = new Model("OSMO", 11, "Osmo");
    OSMO_MOBILE = new Model("OSMO_MOBILE", 12, "Osmo Mobile");
    OSMO_PRO = new Model("OSMO_PRO", 13, "Osmo Pro");
    OSMO_RAW = new Model("OSMO_RAW", 14, "Osmo RAW");
    OSMO_PLUS = new Model("OSMO_PLUS", 15, "Osmo+");
    MATRICE_600 = new Model("MATRICE_600", 16, "Matrice 600");
    M200 = new Model("M200", 17, "M200");
    M210 = new Model("M210", 18, "M210");
    M210RTK = new Model("M210RTK", 19, "M210RTK");
    MATRICE_600_PRO = new Model("MATRICE_600_PRO", 20, "Matrice 600 Pro");
    PHANTOM_4_ADV = new Model("PHANTOM_4_ADV", 21, "Phantom 4 Advanced");
    A3 = new Model("A3", 22, "A3");
    N3 = new Model("N3", 23, "N3");
    UNKNOWN_AIRCRAFT = new Model("UNKNOWN_AIRCRAFT", 24, "Unknown Aircraft");
    UNKNOWN_HANDHELD = new Model("UNKNOWN_HANDHELD", 25, "Unknown Handheld");
    MAVIC_PRO = new Model("MAVIC_PRO", 26, "Mavic Pro");
    Mammoth = new Model("Mammoth", 27, "Mammoth");
    ZENMUSE_Z3 = new Model("ZENMUSE_Z3", 28, "Zenmuse Z3");
    RONIN2 = new Model("RONIN2", 29, "Ronin2");
    RONINS = new Model("RONINS", 30, "RoninS");
    RONINSC = new Model("RONINSC", 31, "RoninSC");
    HG702 = new Model("HG702", 32, "HG702");
    HG710 = new Model("HG710", 33, "HG710");
    HG702_Monitor = new Model("HG702_Monitor", 34, "HG702_monitor");
    Model localModel = new Model("UNKNOWN", 35, "unknown");
    UNKNOWN = localModel;
    $VALUES = new Model[] { INSPIRE_1, INSPIRE_1_PRO, INSPIRE_1_RAW, INSPIRE_2, MATRICE_100, PHANTOM_3_ADVANCED, PHANTOM_3_PROFESSIONAL, PHANTOM_3_STANDARD, Phantom_3_4K, PHANTOM_4, PHANTOM_4_PRO, OSMO, OSMO_MOBILE, OSMO_PRO, OSMO_RAW, OSMO_PLUS, MATRICE_600, M200, M210, M210RTK, MATRICE_600_PRO, PHANTOM_4_ADV, A3, N3, UNKNOWN_AIRCRAFT, UNKNOWN_HANDHELD, MAVIC_PRO, Mammoth, ZENMUSE_Z3, RONIN2, RONINS, RONINSC, HG702, HG710, HG702_Monitor, localModel };
  }
  
  private Model(String paramString)
  {
    this.value = paramString;
  }
  
  public String getDisplayName()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\product\Model.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */