package dji.common.util;

import android.util.SparseArray;
import dji.common.camera.SettingsDefinitions.Aperture;
import java.util.EnumMap;
import java.util.HashMap;

public class DJILensFeatureUtils
{
  private static final String DEFAULT_MEMBERNAME = "Unknown";
  private static final String DEFAUL_PRODUCTNAME = "Unknown";
  private static final int MEMBERID_DJI = 8;
  private static final int MEMBERID_JKIMAGING = 7;
  private static final int MEMBERID_KENKO_TOKINA = 6;
  private static final int MEMBERID_OLYMPUS = 0;
  private static final int MEMBERID_PANASONIC2 = 2;
  private static final int MEMBERID_PANASONIC3 = 3;
  private static final int MEMBERID_SIGMA = 1;
  private static final int MEMBERID_TAMRON = 5;
  private static final SparseArray<SparseArray<String>> cameraInfoSpArray = new SparseArray();
  
  static EnumMap<SettingsDefinitions.Aperture, Short> buildApertureMap()
  {
    EnumMap localEnumMap = new EnumMap(SettingsDefinitions.Aperture.class);
    localEnumMap.put(SettingsDefinitions.Aperture.F_10, Short.valueOf((short)1000));
    localEnumMap.put(SettingsDefinitions.Aperture.F_11, Short.valueOf((short)1100));
    localEnumMap.put(SettingsDefinitions.Aperture.F_13, Short.valueOf((short)1300));
    localEnumMap.put(SettingsDefinitions.Aperture.F_14, Short.valueOf((short)1400));
    localEnumMap.put(SettingsDefinitions.Aperture.F_16, Short.valueOf((short)1600));
    localEnumMap.put(SettingsDefinitions.Aperture.F_18, Short.valueOf((short)1800));
    localEnumMap.put(SettingsDefinitions.Aperture.F_1_DOT_7, Short.valueOf((short)170));
    localEnumMap.put(SettingsDefinitions.Aperture.F_1_DOT_8, Short.valueOf((short)180));
    localEnumMap.put(SettingsDefinitions.Aperture.F_20, Short.valueOf((short)2000));
    localEnumMap.put(SettingsDefinitions.Aperture.F_22, Short.valueOf((short)2200));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2, Short.valueOf((short)200));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_2, Short.valueOf((short)220));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_5, Short.valueOf((short)250));
    localEnumMap.put(SettingsDefinitions.Aperture.F_2_DOT_8, Short.valueOf((short)280));
    localEnumMap.put(SettingsDefinitions.Aperture.F_3_DOT_2, Short.valueOf((short)320));
    localEnumMap.put(SettingsDefinitions.Aperture.F_3_DOT_5, Short.valueOf((short)350));
    localEnumMap.put(SettingsDefinitions.Aperture.F_4, Short.valueOf((short)400));
    localEnumMap.put(SettingsDefinitions.Aperture.F_4_DOT_5, Short.valueOf((short)450));
    localEnumMap.put(SettingsDefinitions.Aperture.F_5, Short.valueOf((short)500));
    localEnumMap.put(SettingsDefinitions.Aperture.F_5_DOT_6, Short.valueOf((short)560));
    localEnumMap.put(SettingsDefinitions.Aperture.F_6_DOT_3, Short.valueOf((short)630));
    localEnumMap.put(SettingsDefinitions.Aperture.F_7_DOT_1, Short.valueOf((short)710));
    localEnumMap.put(SettingsDefinitions.Aperture.F_8, Short.valueOf((short)800));
    localEnumMap.put(SettingsDefinitions.Aperture.F_9, Short.valueOf((short)900));
    return localEnumMap;
  }
  
  static HashMap<Integer, SettingsDefinitions.Aperture> buildApertureMapRevert()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(1000), SettingsDefinitions.Aperture.F_10);
    localHashMap.put(Integer.valueOf(1100), SettingsDefinitions.Aperture.F_11);
    localHashMap.put(Integer.valueOf(1300), SettingsDefinitions.Aperture.F_13);
    localHashMap.put(Integer.valueOf(1400), SettingsDefinitions.Aperture.F_14);
    localHashMap.put(Integer.valueOf(1600), SettingsDefinitions.Aperture.F_16);
    localHashMap.put(Integer.valueOf(1800), SettingsDefinitions.Aperture.F_18);
    localHashMap.put(Integer.valueOf(170), SettingsDefinitions.Aperture.F_1_DOT_7);
    localHashMap.put(Integer.valueOf(180), SettingsDefinitions.Aperture.F_1_DOT_8);
    localHashMap.put(Integer.valueOf(2000), SettingsDefinitions.Aperture.F_20);
    localHashMap.put(Integer.valueOf(2200), SettingsDefinitions.Aperture.F_22);
    localHashMap.put(Integer.valueOf(200), SettingsDefinitions.Aperture.F_2);
    localHashMap.put(Integer.valueOf(220), SettingsDefinitions.Aperture.F_2_DOT_2);
    localHashMap.put(Integer.valueOf(250), SettingsDefinitions.Aperture.F_2_DOT_5);
    localHashMap.put(Integer.valueOf(280), SettingsDefinitions.Aperture.F_2_DOT_8);
    localHashMap.put(Integer.valueOf(320), SettingsDefinitions.Aperture.F_3_DOT_2);
    localHashMap.put(Integer.valueOf(350), SettingsDefinitions.Aperture.F_3_DOT_5);
    localHashMap.put(Integer.valueOf(400), SettingsDefinitions.Aperture.F_4);
    localHashMap.put(Integer.valueOf(450), SettingsDefinitions.Aperture.F_4_DOT_5);
    localHashMap.put(Integer.valueOf(500), SettingsDefinitions.Aperture.F_5);
    localHashMap.put(Integer.valueOf(560), SettingsDefinitions.Aperture.F_5_DOT_6);
    localHashMap.put(Integer.valueOf(630), SettingsDefinitions.Aperture.F_6_DOT_3);
    localHashMap.put(Integer.valueOf(710), SettingsDefinitions.Aperture.F_7_DOT_1);
    localHashMap.put(Integer.valueOf(800), SettingsDefinitions.Aperture.F_8);
    localHashMap.put(Integer.valueOf(900), SettingsDefinitions.Aperture.F_9);
    return localHashMap;
  }
  
  private static int generateKey(int paramInt1, int paramInt2)
  {
    return paramInt1 << 16 & paramInt2;
  }
  
  public static String getProductName(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = (SparseArray)cameraInfoSpArray.get(paramInt2);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      if (8 == paramInt1)
      {
        localObject1 = loadDJISp();
      }
      else if (7 == paramInt1)
      {
        localObject1 = loadJKImagingSp();
      }
      else if (6 == paramInt1)
      {
        localObject1 = loadKenkoTokinaSp();
      }
      else if (5 == paramInt1)
      {
        localObject1 = loadTamronSp();
      }
      else if (3 == paramInt1)
      {
        localObject1 = loadPanasonic3Sp();
      }
      else if (2 == paramInt1)
      {
        localObject1 = loadPanasonic2Sp();
      }
      else if (1 == paramInt1)
      {
        localObject1 = loadSigmaSp();
      }
      else
      {
        localObject1 = localObject2;
        if (paramInt1 == 0) {
          localObject1 = loadOlympusSp();
        }
      }
    }
    localObject2 = "Unknown";
    if (localObject1 != null) {
      localObject2 = (String)((SparseArray)localObject1).get(generateKey(paramInt2, paramInt3), "Unknown");
    }
    return (String)localObject2;
  }
  
  public static SparseArray<String> loadDJISp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4097, 0), "DJI MFT 15mm F1.7 ASPH");
    cameraInfoSpArray.put(8, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadJKImagingSp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4097, 4096), "PIXPRO SZ 12-45/F3.5-6.3 AF");
    localSparseArray.put(generateKey(4098, 4096), "PIXPRO SZ 42.5-160/F3.9-5.9 AF");
    cameraInfoSpArray.put(7, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadKenkoTokinaSp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4097, 0), "Reflex 300mm F6.3 MF Macro");
    cameraInfoSpArray.put(6, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadOlympusSp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4097, 0), "M.ZUIKO DIGITAL ED 14-42mm F3.5-5.6");
    localSparseArray.put(generateKey(4103, 0), "M.ZUIKO DIGITAL ED 12mm F2.0");
    localSparseArray.put(generateKey(4113, 0), "M.ZUIKO DIGITAL 45mm F1.8");
    localSparseArray.put(generateKey(4118, 0), "M.ZUIKO DIGITAL 17mm F1.8");
    localSparseArray.put(generateKey(4129, 0), "M.ZUIKO DIGITAL ED 14-42mm F3.5-5.6 EZ");
    localSparseArray.put(generateKey(4130, 0), "M.ZUIKO DIGITAL 25mm F1.8");
    localSparseArray.put(generateKey(4131, 0), "M.ZUIKO DIGITAL ED 7-14mm F2.8 PRO");
    localSparseArray.put(generateKey(4133, 0), "M.ZUIKO DIGITAL ED 8mm F1.8 Fisheye");
    cameraInfoSpArray.put(0, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadPanasonic2Sp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4101, 4096), "LUMIX G 20mm F1.7");
    localSparseArray.put(generateKey(4101, 4352), "LUMIX G 20mm F1.7 II");
    localSparseArray.put(generateKey(4116, 4096), "LUMIX G VARIO PZ 14-42mm/F3.5-5.6");
    localSparseArray.put(generateKey(4131, 4096), "LUMIX G VARIO 35-100mm/F4.0-5.6");
    localSparseArray.put(generateKey(4132, 4096), "LUMIX G MACRO 30mm/F2.8");
    localSparseArray.put(generateKey(4133, 4096), "LUMIX G 42.5mm/F1.7");
    localSparseArray.put(generateKey(4134, 4096), "LUMIX G 25mm/F1.7");
    cameraInfoSpArray.put(2, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadPanasonic3Sp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(2, 4096), "LEICA D SUMMILUX 25mm F1.4 ASPH");
    cameraInfoSpArray.put(3, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadSigmaSp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4099, 0), "SIGMA 30mm F2.8 DN");
    localSparseArray.put(generateKey(4100, 0), "SIGMA 19mm F2.8 DN");
    localSparseArray.put(generateKey(4101, 0), "SIGMA 60mm F2.8 DN");
    cameraInfoSpArray.put(1, localSparseArray);
    return localSparseArray;
  }
  
  public static SparseArray<String> loadTamronSp()
  {
    SparseArray localSparseArray = new SparseArray();
    localSparseArray.put(generateKey(4097, 1), "14-150mm F/3.5-5.8 Di IIII C 001");
    localSparseArray.put(generateKey(4098, 1), "14-150mm F/3.5-5.8 Di IIII C 001");
    cameraInfoSpArray.put(5, localSparseArray);
    return localSparseArray;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\DJILensFeatureUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */