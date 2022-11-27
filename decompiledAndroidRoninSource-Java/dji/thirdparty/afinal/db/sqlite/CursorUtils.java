package dji.thirdparty.afinal.db.sqlite;

import android.database.Cursor;
import dji.thirdparty.afinal.FinalDb;
import dji.thirdparty.afinal.db.table.Id;
import dji.thirdparty.afinal.db.table.ManyToOne;
import dji.thirdparty.afinal.db.table.OneToMany;
import dji.thirdparty.afinal.db.table.Property;
import dji.thirdparty.afinal.db.table.TableInfo;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CursorUtils
{
  public static <T> T dbModel2Entity(DbModel paramDbModel, Class<?> paramClass)
  {
    if (paramDbModel != null)
    {
      paramDbModel = paramDbModel.getDataMap();
      try
      {
        Object localObject1 = paramClass.newInstance();
        Iterator localIterator = paramDbModel.entrySet().iterator();
        while (localIterator.hasNext())
        {
          paramDbModel = (Map.Entry)localIterator.next();
          String str = (String)paramDbModel.getKey();
          TableInfo localTableInfo = TableInfo.get(paramClass);
          Object localObject2 = (Property)localTableInfo.propertyMap.get(str);
          if (localObject2 != null)
          {
            if (paramDbModel.getValue() == null) {
              paramDbModel = null;
            } else {
              paramDbModel = paramDbModel.getValue().toString();
            }
            ((Property)localObject2).setValue(localObject1, paramDbModel);
          }
          else if (localTableInfo.getId().getColumn().equals(str))
          {
            localObject2 = localTableInfo.getId();
            if (paramDbModel.getValue() == null) {
              paramDbModel = null;
            } else {
              paramDbModel = paramDbModel.getValue().toString();
            }
            ((Id)localObject2).setValue(localObject1, paramDbModel);
          }
        }
        return (T)localObject1;
      }
      catch (Exception paramDbModel)
      {
        paramDbModel.printStackTrace();
      }
    }
    return null;
  }
  
  public static DbModel getDbModel(Cursor paramCursor)
  {
    if ((paramCursor != null) && (paramCursor.getColumnCount() > 0))
    {
      DbModel localDbModel = new DbModel();
      int j = paramCursor.getColumnCount();
      int i = 0;
      while (i < j)
      {
        localDbModel.set(paramCursor.getColumnName(i), paramCursor.getString(i));
        i += 1;
      }
      return localDbModel;
    }
    return null;
  }
  
  public static <T> T getEntity(Cursor paramCursor, Class<T> paramClass, FinalDb paramFinalDb)
  {
    if (paramCursor != null) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject2 = TableInfo.get(paramClass);
        int j = paramCursor.getColumnCount();
        if (j > 0)
        {
          Object localObject1 = paramClass.newInstance();
          i = 0;
          Object localObject4;
          if (i < j)
          {
            localObject3 = paramCursor.getColumnName(i);
            localObject4 = (Property)((TableInfo)localObject2).propertyMap.get(localObject3);
            if (localObject4 != null)
            {
              ((Property)localObject4).setValue(localObject1, paramCursor, i);
              break label294;
            }
            if (!((TableInfo)localObject2).getId().getColumn().equals(localObject3)) {
              break label294;
            }
            ((TableInfo)localObject2).getId().setValue(localObject1, paramCursor, i);
            break label294;
          }
          Object localObject3 = ((TableInfo)localObject2).oneToManyMap.values().iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (OneToMany)((Iterator)localObject3).next();
            if (((OneToMany)localObject4).getDataType() != OneToManyLazyLoader.class) {
              continue;
            }
            ((OneToMany)localObject4).setValue(localObject1, new OneToManyLazyLoader(localObject1, paramClass, ((OneToMany)localObject4).getOneClass(), paramFinalDb));
            continue;
          }
          localObject2 = ((TableInfo)localObject2).manyToOneMap.values().iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ManyToOne)((Iterator)localObject2).next();
            if (((ManyToOne)localObject3).getDataType() != ManyToOneLazyLoader.class) {
              continue;
            }
            localObject4 = new ManyToOneLazyLoader(localObject1, paramClass, ((ManyToOne)localObject3).getManyClass(), paramFinalDb);
            ((ManyToOneLazyLoader)localObject4).setFieldValue(Integer.valueOf(paramCursor.getInt(paramCursor.getColumnIndex(((ManyToOne)localObject3).getColumn()))));
            ((ManyToOne)localObject3).setValue(localObject1, localObject4);
            continue;
          }
          return (T)localObject1;
        }
      }
      catch (Exception paramCursor)
      {
        paramCursor.printStackTrace();
      }
      return null;
      label294:
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\CursorUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */