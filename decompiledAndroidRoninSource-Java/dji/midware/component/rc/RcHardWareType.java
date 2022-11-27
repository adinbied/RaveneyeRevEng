package dji.midware.component.rc;

import dji.log.RoninLog;
import dji.midware.component.DJIComponentManager.RcComponentType;
import dji.midware.data.config.P3.ProductType;
import dji.midware.util.BytesUtil;

public enum RcHardWareType
{
  private static final String TAG = "RcHardWareType";
  protected String hwName;
  protected ProductType productType;
  protected DJIComponentManager.RcComponentType rcComponentType;
  
  static
  {
    IN1_GL658B = new RcHardWareType("IN1_GL658B", 2, "GL658B", ProductType.Orange, DJIComponentManager.RcComponentType.Inspire);
    P3_GL300A = new RcHardWareType("P3_GL300A", 3, "GL300A", ProductType.litchiX, DJIComponentManager.RcComponentType.P3P4);
    P3_GL300B = new RcHardWareType("P3_GL300B", 4, "GL300B", ProductType.litchiX, DJIComponentManager.RcComponentType.P3P4);
    P4_GL300C = new RcHardWareType("P4_GL300C", 5, "GL300C", ProductType.Tomato, DJIComponentManager.RcComponentType.P3P4);
    P3C_GL358wA = new RcHardWareType("P3C_GL358wA", 6, "GL358wA", ProductType.litchiC, DJIComponentManager.RcComponentType.P3c);
    P3C_GL390wA = new RcHardWareType("P3C_GL390wA", 7, "GL390wA", ProductType.litchiC, DJIComponentManager.RcComponentType.P3c);
    P3C_GL358wB = new RcHardWareType("P3C_GL358wB", 8, "GL358wB", ProductType.P34K, DJIComponentManager.RcComponentType.P3w);
    LB2_GL858A = new RcHardWareType("LB2_GL858A", 9, "GL858A", ProductType.Grape2, DJIComponentManager.RcComponentType.LB2);
    LB2_GL890A = new RcHardWareType("LB2_GL890A", 10, "GL890A", ProductType.Grape2, DJIComponentManager.RcComponentType.LB2);
    P4_PV1 = new RcHardWareType("P4_PV1", 11, "P4_PV1", ProductType.Pomato, DJIComponentManager.RcComponentType.P4P);
    P4_PV2 = new RcHardWareType("P4_PV2", 12, "P4_PV2", ProductType.Pomato, DJIComponentManager.RcComponentType.P4P);
    IN2_V3 = new RcHardWareType("IN2_V3", 13, "IN2_V3", ProductType.Orange2, DJIComponentManager.RcComponentType.Inspire2);
    IN2_V4 = new RcHardWareType("IN2_V4", 14, "IN2_V4", ProductType.Orange2, DJIComponentManager.RcComponentType.Inspire2);
    RcHardWareType localRcHardWareType = new RcHardWareType("POTATO", 15, "GL300I", ProductType.Potato, DJIComponentManager.RcComponentType.Potato);
    POTATO = localRcHardWareType;
    $VALUES = new RcHardWareType[] { IN1_GL658A, IN1_GL690A, IN1_GL658B, P3_GL300A, P3_GL300B, P4_GL300C, P3C_GL358wA, P3C_GL390wA, P3C_GL358wB, LB2_GL858A, LB2_GL890A, P4_PV1, P4_PV2, IN2_V3, IN2_V4, localRcHardWareType };
  }
  
  private RcHardWareType(String paramString, ProductType paramProductType, DJIComponentManager.RcComponentType paramRcComponentType)
  {
    this.hwName = paramString;
    this.productType = paramProductType;
    this.rcComponentType = paramRcComponentType;
  }
  
  public static RcHardWareType getByOsdData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = BytesUtil.getStringUTF8Offset(paramArrayOfByte, 1, 16);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("hardwareVer : ");
    ((StringBuilder)localObject).append(paramArrayOfByte);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    RoninLog.d("RcHardWareType", (String)localObject, new Object[0]);
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.isEmpty()) {
        return null;
      }
      localObject = values();
      int j = localObject.length;
      while (i < j)
      {
        RcHardWareType localRcHardWareType = localObject[i];
        if (paramArrayOfByte.contains(localRcHardWareType.hwName))
        {
          if ((localRcHardWareType != P4_PV1) && (localRcHardWareType != P4_PV2) && (localRcHardWareType != IN2_V3) && (IN2_V4 != localRcHardWareType) && (POTATO != localRcHardWareType))
          {
            if (P4_GL300C == localRcHardWareType) {
              return localRcHardWareType;
            }
            return null;
          }
          return localRcHardWareType;
        }
        i += 1;
      }
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\component\rc\RcHardWareType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */