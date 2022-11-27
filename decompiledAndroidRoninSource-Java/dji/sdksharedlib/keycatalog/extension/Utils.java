package dji.sdksharedlib.keycatalog.extension;

import dji.log.DJILog;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
  public static final String TAG = "Utils";
  
  public static Class[] parseAllClass(Class[] paramArrayOfClass)
  {
    if ((paramArrayOfClass != null) && (paramArrayOfClass.length != 0))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfClass.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        Object localObject = paramArrayOfClass[i];
        if (IAbstractionGroup.class.isAssignableFrom((Class)localObject)) {}
        try
        {
          localObject = ((IAbstractionGroup)((Class)localObject).newInstance()).getAbstractions();
          if (localObject == null) {
            break label111;
          }
          int m = localObject.length;
          j = 0;
          while (j < m)
          {
            localArrayList.add(localObject[j]);
            j += 1;
          }
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
        DJILog.e("Utils", "error IAbstractionGroup", new Object[0]);
        label111:
        j = 1;
        break label126;
        localArrayList.add(localObject);
        label126:
        i += 1;
      }
      if (j != 0)
      {
        paramArrayOfClass = new Class[localArrayList.size()];
        localArrayList.toArray(paramArrayOfClass);
      }
      return paramArrayOfClass;
    }
    return null;
  }
  
  public static Key[] parseAllKey(ComplexKey paramComplexKey, Key paramKey)
  {
    if ((paramComplexKey != null) && (paramKey == null)) {
      return paramComplexKey.value();
    }
    if ((paramComplexKey == null) && (paramKey != null)) {
      return new Key[] { paramKey };
    }
    if ((paramComplexKey != null) && (paramKey != null)) {
      DJILog.e("Utils", "you can't define ComplexKey and Key both, please remove one", new Object[0]);
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\extension\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */