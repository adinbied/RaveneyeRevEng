package com.drew.metadata.icc;

import com.drew.metadata.Directory;
import java.util.HashMap;

public class IccDirectory
  extends Directory
{
  public static final int TAG_APPLE_MULTI_LANGUAGE_PROFILE_NAME = 1685283693;
  public static final int TAG_CMM_FLAGS = 44;
  public static final int TAG_CMM_TYPE = 4;
  public static final int TAG_COLOR_SPACE = 16;
  public static final int TAG_DEVICE_ATTR = 56;
  public static final int TAG_DEVICE_MAKE = 48;
  public static final int TAG_DEVICE_MODEL = 52;
  public static final int TAG_PLATFORM = 40;
  public static final int TAG_PROFILE_BYTE_COUNT = 0;
  public static final int TAG_PROFILE_CLASS = 12;
  public static final int TAG_PROFILE_CONNECTION_SPACE = 20;
  public static final int TAG_PROFILE_CREATOR = 80;
  public static final int TAG_PROFILE_DATETIME = 24;
  public static final int TAG_PROFILE_VERSION = 8;
  public static final int TAG_RENDERING_INTENT = 64;
  public static final int TAG_SIGNATURE = 36;
  public static final int TAG_TAG_A2B0 = 1093812784;
  public static final int TAG_TAG_A2B1 = 1093812785;
  public static final int TAG_TAG_A2B2 = 1093812786;
  public static final int TAG_TAG_B2A0 = 1110589744;
  public static final int TAG_TAG_B2A1 = 1110589745;
  public static final int TAG_TAG_B2A2 = 1110589746;
  public static final int TAG_TAG_COUNT = 128;
  public static final int TAG_TAG_bTRC = 1649693251;
  public static final int TAG_TAG_bXYZ = 1649957210;
  public static final int TAG_TAG_bfd = 1650877472;
  public static final int TAG_TAG_bkpt = 1651208308;
  public static final int TAG_TAG_calt = 1667329140;
  public static final int TAG_TAG_chad = 1667785060;
  public static final int TAG_TAG_chrm = 1667789421;
  public static final int TAG_TAG_cprt = 1668313716;
  public static final int TAG_TAG_crdi = 1668441193;
  public static final int TAG_TAG_desc = 1684370275;
  public static final int TAG_TAG_devs = 1684371059;
  public static final int TAG_TAG_dmdd = 1684890724;
  public static final int TAG_TAG_dmnd = 1684893284;
  public static final int TAG_TAG_gTRC = 1733579331;
  public static final int TAG_TAG_gXYZ = 1733843290;
  public static final int TAG_TAG_gamt = 1734438260;
  public static final int TAG_TAG_kTRC = 1800688195;
  public static final int TAG_TAG_lumi = 1819635049;
  public static final int TAG_TAG_meas = 1835360627;
  public static final int TAG_TAG_ncl2 = 1852009522;
  public static final int TAG_TAG_ncol = 1852010348;
  public static final int TAG_TAG_pre0 = 1886545200;
  public static final int TAG_TAG_pre1 = 1886545201;
  public static final int TAG_TAG_pre2 = 1886545202;
  public static final int TAG_TAG_ps2i = 1886597737;
  public static final int TAG_TAG_ps2s = 1886597747;
  public static final int TAG_TAG_psd0 = 1886610480;
  public static final int TAG_TAG_psd1 = 1886610481;
  public static final int TAG_TAG_psd2 = 1886610482;
  public static final int TAG_TAG_psd3 = 1886610483;
  public static final int TAG_TAG_pseq = 1886610801;
  public static final int TAG_TAG_rTRC = 1918128707;
  public static final int TAG_TAG_rXYZ = 1918392666;
  public static final int TAG_TAG_resp = 1919251312;
  public static final int TAG_TAG_scrd = 1935897188;
  public static final int TAG_TAG_scrn = 1935897198;
  public static final int TAG_TAG_targ = 1952543335;
  public static final int TAG_TAG_tech = 1952801640;
  public static final int TAG_TAG_view = 1986618743;
  public static final int TAG_TAG_vued = 1987405156;
  public static final int TAG_TAG_wtpt = 2004119668;
  public static final int TAG_XYZ_VALUES = 68;
  protected static final HashMap<Integer, String> _tagNameMap;
  
  static
  {
    HashMap localHashMap = new HashMap();
    _tagNameMap = localHashMap;
    localHashMap.put(Integer.valueOf(0), "Profile Size");
    _tagNameMap.put(Integer.valueOf(4), "CMM Type");
    _tagNameMap.put(Integer.valueOf(8), "Version");
    _tagNameMap.put(Integer.valueOf(12), "Class");
    _tagNameMap.put(Integer.valueOf(16), "Color space");
    _tagNameMap.put(Integer.valueOf(20), "Profile Connection Space");
    _tagNameMap.put(Integer.valueOf(24), "Profile Date/Time");
    _tagNameMap.put(Integer.valueOf(36), "Signature");
    _tagNameMap.put(Integer.valueOf(40), "Primary Platform");
    _tagNameMap.put(Integer.valueOf(44), "CMM Flags");
    _tagNameMap.put(Integer.valueOf(48), "Device manufacturer");
    _tagNameMap.put(Integer.valueOf(52), "Device model");
    _tagNameMap.put(Integer.valueOf(56), "Device attributes");
    _tagNameMap.put(Integer.valueOf(64), "Rendering Intent");
    _tagNameMap.put(Integer.valueOf(68), "XYZ values");
    _tagNameMap.put(Integer.valueOf(80), "Profile Creator");
    _tagNameMap.put(Integer.valueOf(128), "Tag Count");
    _tagNameMap.put(Integer.valueOf(1093812784), "AToB 0");
    _tagNameMap.put(Integer.valueOf(1093812785), "AToB 1");
    _tagNameMap.put(Integer.valueOf(1093812786), "AToB 2");
    _tagNameMap.put(Integer.valueOf(1649957210), "Blue Colorant");
    _tagNameMap.put(Integer.valueOf(1649693251), "Blue TRC");
    _tagNameMap.put(Integer.valueOf(1110589744), "BToA 0");
    _tagNameMap.put(Integer.valueOf(1110589745), "BToA 1");
    _tagNameMap.put(Integer.valueOf(1110589746), "BToA 2");
    _tagNameMap.put(Integer.valueOf(1667329140), "Calibration Date/Time");
    _tagNameMap.put(Integer.valueOf(1952543335), "Char Target");
    _tagNameMap.put(Integer.valueOf(1667785060), "Chromatic Adaptation");
    _tagNameMap.put(Integer.valueOf(1667789421), "Chromaticity");
    _tagNameMap.put(Integer.valueOf(1668313716), "Copyright");
    _tagNameMap.put(Integer.valueOf(1668441193), "CrdInfo");
    _tagNameMap.put(Integer.valueOf(1684893284), "Device Mfg Description");
    _tagNameMap.put(Integer.valueOf(1684890724), "Device Model Description");
    _tagNameMap.put(Integer.valueOf(1684371059), "Device Settings");
    _tagNameMap.put(Integer.valueOf(1734438260), "Gamut");
    _tagNameMap.put(Integer.valueOf(1800688195), "Gray TRC");
    _tagNameMap.put(Integer.valueOf(1733843290), "Green Colorant");
    _tagNameMap.put(Integer.valueOf(1733579331), "Green TRC");
    _tagNameMap.put(Integer.valueOf(1819635049), "Luminance");
    _tagNameMap.put(Integer.valueOf(1835360627), "Measurement");
    _tagNameMap.put(Integer.valueOf(1651208308), "Media Black Point");
    _tagNameMap.put(Integer.valueOf(2004119668), "Media White Point");
    _tagNameMap.put(Integer.valueOf(1852010348), "Named Color");
    _tagNameMap.put(Integer.valueOf(1852009522), "Named Color 2");
    _tagNameMap.put(Integer.valueOf(1919251312), "Output Response");
    _tagNameMap.put(Integer.valueOf(1886545200), "Preview 0");
    _tagNameMap.put(Integer.valueOf(1886545201), "Preview 1");
    _tagNameMap.put(Integer.valueOf(1886545202), "Preview 2");
    _tagNameMap.put(Integer.valueOf(1684370275), "Profile Description");
    _tagNameMap.put(Integer.valueOf(1886610801), "Profile Sequence Description");
    _tagNameMap.put(Integer.valueOf(1886610480), "Ps2 CRD 0");
    _tagNameMap.put(Integer.valueOf(1886610481), "Ps2 CRD 1");
    _tagNameMap.put(Integer.valueOf(1886610482), "Ps2 CRD 2");
    _tagNameMap.put(Integer.valueOf(1886610483), "Ps2 CRD 3");
    _tagNameMap.put(Integer.valueOf(1886597747), "Ps2 CSA");
    _tagNameMap.put(Integer.valueOf(1886597737), "Ps2 Rendering Intent");
    _tagNameMap.put(Integer.valueOf(1918392666), "Red Colorant");
    _tagNameMap.put(Integer.valueOf(1918128707), "Red TRC");
    _tagNameMap.put(Integer.valueOf(1935897188), "Screening Desc");
    _tagNameMap.put(Integer.valueOf(1935897198), "Screening");
    _tagNameMap.put(Integer.valueOf(1952801640), "Technology");
    _tagNameMap.put(Integer.valueOf(1650877472), "Ucrbg");
    _tagNameMap.put(Integer.valueOf(1987405156), "Viewing Conditions Description");
    _tagNameMap.put(Integer.valueOf(1986618743), "Viewing Conditions");
    _tagNameMap.put(Integer.valueOf(1685283693), "Apple Multi-language Profile Name");
  }
  
  public IccDirectory()
  {
    setDescriptor(new IccDescriptor(this));
  }
  
  public String getName()
  {
    return "ICC Profile";
  }
  
  protected HashMap<Integer, String> getTagNameMap()
  {
    return _tagNameMap;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\icc\IccDirectory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */