package dji.thirdparty.afinal.db.sqlite;

import android.text.TextUtils;
import android.util.Log;
import dji.thirdparty.afinal.db.table.Id;
import dji.thirdparty.afinal.db.table.KeyValue;
import dji.thirdparty.afinal.db.table.ManyToOne;
import dji.thirdparty.afinal.db.table.Property;
import dji.thirdparty.afinal.db.table.TableInfo;
import dji.thirdparty.afinal.exception.DbException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SqlBuilder
{
  public static SqlInfo buildDeleteSql(Class<?> paramClass, Object paramObject)
  {
    Object localObject = TableInfo.get(paramClass);
    paramClass = ((TableInfo)localObject).getId();
    if (paramObject != null)
    {
      localObject = new StringBuffer(getDeleteSqlBytableName(((TableInfo)localObject).getTableName()));
      ((StringBuffer)localObject).append(" WHERE ");
      ((StringBuffer)localObject).append(paramClass.getColumn());
      ((StringBuffer)localObject).append("=?");
      paramClass = new SqlInfo();
      paramClass.setSql(((StringBuffer)localObject).toString());
      paramClass.addValue(paramObject);
      return paramClass;
    }
    throw new DbException("getDeleteSQL:idValue is null");
  }
  
  public static SqlInfo buildDeleteSql(Object paramObject)
  {
    TableInfo localTableInfo = TableInfo.get(paramObject.getClass());
    Object localObject2 = localTableInfo.getId();
    Object localObject1 = ((Id)localObject2).getValue(paramObject);
    if (localObject1 != null)
    {
      paramObject = new StringBuffer(getDeleteSqlBytableName(localTableInfo.getTableName()));
      ((StringBuffer)paramObject).append(" WHERE ");
      ((StringBuffer)paramObject).append(((Id)localObject2).getColumn());
      ((StringBuffer)paramObject).append("=?");
      localObject2 = new SqlInfo();
      ((SqlInfo)localObject2).setSql(((StringBuffer)paramObject).toString());
      ((SqlInfo)localObject2).addValue(localObject1);
      return (SqlInfo)localObject2;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getDeleteSQL:");
    ((StringBuilder)localObject1).append(paramObject.getClass());
    ((StringBuilder)localObject1).append(" id value is null");
    throw new DbException(((StringBuilder)localObject1).toString());
  }
  
  public static String buildDeleteSql(Class<?> paramClass, String paramString)
  {
    paramClass = new StringBuffer(getDeleteSqlBytableName(TableInfo.get(paramClass).getTableName()));
    if (!TextUtils.isEmpty(paramString))
    {
      paramClass.append(" WHERE ");
      paramClass.append(paramString);
    }
    return paramClass.toString();
  }
  
  public static SqlInfo buildInsertSql(Object paramObject)
  {
    List localList = getSaveKeyValueListByEntity(paramObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList != null) && (localList.size() > 0))
    {
      SqlInfo localSqlInfo = new SqlInfo();
      localStringBuffer.append("INSERT INTO ");
      localStringBuffer.append(TableInfo.get(paramObject.getClass()).getTableName());
      localStringBuffer.append(" (");
      paramObject = localList.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        KeyValue localKeyValue = (KeyValue)((Iterator)paramObject).next();
        localStringBuffer.append(localKeyValue.getKey());
        localStringBuffer.append(",");
        localSqlInfo.addValue(localKeyValue.getValue());
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append(") VALUES ( ");
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append("?,");
        i += 1;
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append(")");
      localSqlInfo.setSql(localStringBuffer.toString());
      return localSqlInfo;
    }
    return null;
  }
  
  public static String buildInsertSqlNoValue(Object paramObject)
  {
    List localList = getSaveKeyValueListByEntity(paramObject);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((localList != null) && (localList.size() > 0))
    {
      localStringBuffer.append("INSERT OR REPLACE INTO ");
      localStringBuffer.append(TableInfo.get(paramObject.getClass()).getTableName());
      localStringBuffer.append(" (");
      paramObject = localList.iterator();
      while (((Iterator)paramObject).hasNext())
      {
        localStringBuffer.append(((KeyValue)((Iterator)paramObject).next()).getKey());
        localStringBuffer.append(",");
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append(") VALUES ( ");
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        localStringBuffer.append("?,");
        i += 1;
      }
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      localStringBuffer.append(")");
    }
    return localStringBuffer.toString();
  }
  
  public static String buildInsertSqlNoValueWithId(Object paramObject, String paramString)
  {
    Object localObject1 = getSaveKeyValueListByEntityWithId(paramObject);
    String str1 = ((KeyValue)((List)localObject1).get(0)).getKey();
    String str2 = TableInfo.get(paramObject.getClass()).getTableName();
    paramObject = new StringBuffer();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      ((StringBuffer)paramObject).append("INSERT OR REPLACE INTO ");
      ((StringBuffer)paramObject).append(str2);
      ((StringBuffer)paramObject).append(" (");
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuffer)paramObject).append(((KeyValue)((Iterator)localObject2).next()).getKey());
        ((StringBuffer)paramObject).append(",");
      }
      ((StringBuffer)paramObject).deleteCharAt(((StringBuffer)paramObject).length() - 1);
      ((StringBuffer)paramObject).append(") VALUES ( ");
      ((List)localObject1).size();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((KeyValue)((Iterator)localObject1).next()).getKey().equals(str1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("(select ");
          ((StringBuilder)localObject2).append(str1);
          ((StringBuilder)localObject2).append(" from ");
          ((StringBuilder)localObject2).append(str2);
          ((StringBuilder)localObject2).append(" where ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" = ?),");
          ((StringBuffer)paramObject).append(((StringBuilder)localObject2).toString());
        }
        else
        {
          ((StringBuffer)paramObject).append("?,");
        }
      }
      ((StringBuffer)paramObject).deleteCharAt(((StringBuffer)paramObject).length() - 1);
      ((StringBuffer)paramObject).append(")");
    }
    paramString = new StringBuilder();
    paramString.append("ttttttt=");
    paramString.append(((StringBuffer)paramObject).toString());
    Log.d("", paramString.toString());
    return ((StringBuffer)paramObject).toString();
  }
  
  public static String getCreatTableSQL(Class<?> paramClass)
  {
    Object localObject1 = TableInfo.get(paramClass);
    Object localObject2 = ((TableInfo)localObject1).getId();
    paramClass = new StringBuffer();
    paramClass.append("CREATE TABLE IF NOT EXISTS ");
    paramClass.append(((TableInfo)localObject1).getTableName());
    paramClass.append(" ( ");
    Object localObject3 = ((Id)localObject2).getDataType();
    if ((localObject3 != Integer.TYPE) && (localObject3 != Integer.class) && (localObject3 != Long.TYPE) && (localObject3 != Long.class))
    {
      paramClass.append(((Id)localObject2).getColumn());
      paramClass.append(" TEXT PRIMARY KEY,");
    }
    else
    {
      paramClass.append(((Id)localObject2).getColumn());
      paramClass.append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
    }
    localObject2 = ((TableInfo)localObject1).propertyMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Property)((Iterator)localObject2).next();
      paramClass.append(((Property)localObject3).getColumn());
      localObject3 = ((Property)localObject3).getDataType();
      if ((localObject3 != Integer.TYPE) && (localObject3 != Integer.class) && (localObject3 != Long.TYPE) && (localObject3 != Long.class))
      {
        if ((localObject3 != Float.TYPE) && (localObject3 != Float.class) && (localObject3 != Double.TYPE) && (localObject3 != Double.class))
        {
          if ((localObject3 == Boolean.TYPE) || (localObject3 == Boolean.class)) {
            paramClass.append(" NUMERIC");
          }
        }
        else {
          paramClass.append(" REAL");
        }
      }
      else {
        paramClass.append(" INTEGER");
      }
      paramClass.append(",");
    }
    localObject1 = ((TableInfo)localObject1).manyToOneMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      paramClass.append(((ManyToOne)((Iterator)localObject1).next()).getColumn());
      paramClass.append(" INTEGER");
      paramClass.append(",");
    }
    paramClass.deleteCharAt(paramClass.length() - 1);
    paramClass.append(" )");
    return paramClass.toString();
  }
  
  private static String getDeleteSqlBytableName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String getPropertyStrSql(String paramString, Object paramObject)
  {
    paramString = new StringBuffer(paramString);
    paramString.append("=");
    if ((!(paramObject instanceof String)) && (!(paramObject instanceof java.util.Date)) && (!(paramObject instanceof java.sql.Date)))
    {
      paramString.append(paramObject);
    }
    else
    {
      paramString.append("'");
      paramString.append(paramObject);
      paramString.append("'");
    }
    return paramString.toString();
  }
  
  public static String[] getSaveKeyValueArrayByEntity(TableInfo paramTableInfo, Object paramObject)
  {
    Object localObject = paramTableInfo.propertyMap.values();
    paramTableInfo = new String[((Collection)localObject).size()];
    localObject = ((Collection)localObject).iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      KeyValue localKeyValue = property2KeyValue((Property)((Iterator)localObject).next(), paramObject);
      if (localKeyValue != null) {
        paramTableInfo[i] = localKeyValue.getValue().toString();
      }
      i += 1;
    }
    return paramTableInfo;
  }
  
  public static String[] getSaveKeyValueArrayByEntityWithId(TableInfo paramTableInfo, Object paramObject, String paramString1, String paramString2)
  {
    paramString1 = paramTableInfo.propertyMap.values();
    int j = paramString1.size();
    int i = 1;
    paramTableInfo = new String[j + 1];
    paramTableInfo[0] = paramString2;
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      paramString2 = property2KeyValue((Property)paramString1.next(), paramObject);
      if (paramString2 != null) {
        paramTableInfo[i] = paramString2.getValue().toString();
      }
      i += 1;
    }
    return paramTableInfo;
  }
  
  public static List<KeyValue> getSaveKeyValueListByEntity(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = TableInfo.get(paramObject.getClass());
    Object localObject2 = ((TableInfo)localObject1).getId().getValue(paramObject);
    if ((!(localObject2 instanceof Integer)) && ((localObject2 instanceof String)) && (localObject2 != null)) {
      localArrayList.add(new KeyValue(((TableInfo)localObject1).getId().getColumn(), localObject2));
    }
    localObject2 = ((TableInfo)localObject1).propertyMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      KeyValue localKeyValue = property2KeyValue((Property)((Iterator)localObject2).next(), paramObject);
      if (localKeyValue != null) {
        localArrayList.add(localKeyValue);
      }
    }
    localObject1 = ((TableInfo)localObject1).manyToOneMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = manyToOne2KeyValue((ManyToOne)((Iterator)localObject1).next(), paramObject);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static List<KeyValue> getSaveKeyValueListByEntityWithId(Object paramObject)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = TableInfo.get(paramObject.getClass());
    Object localObject2 = ((TableInfo)localObject1).getId().getValue(paramObject);
    localArrayList.add(new KeyValue(((TableInfo)localObject1).getId().getColumn(), localObject2));
    localObject2 = ((TableInfo)localObject1).propertyMap.values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      KeyValue localKeyValue = property2KeyValue((Property)((Iterator)localObject2).next(), paramObject);
      if (localKeyValue != null) {
        localArrayList.add(localKeyValue);
      }
    }
    localObject1 = ((TableInfo)localObject1).manyToOneMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = manyToOne2KeyValue((ManyToOne)((Iterator)localObject1).next(), paramObject);
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
  
  public static String getSelectSQL(Class<?> paramClass)
  {
    return getSelectSqlByTableName(TableInfo.get(paramClass).getTableName());
  }
  
  public static String getSelectSQL(Class<?> paramClass, Object paramObject)
  {
    paramClass = TableInfo.get(paramClass);
    StringBuffer localStringBuffer = new StringBuffer(getSelectSqlByTableName(paramClass.getTableName()));
    localStringBuffer.append(" WHERE ");
    localStringBuffer.append(getPropertyStrSql(paramClass.getId().getColumn(), paramObject));
    return localStringBuffer.toString();
  }
  
  public static String getSelectSQLByWhere(Class<?> paramClass, String paramString)
  {
    paramClass = new StringBuffer(getSelectSqlByTableName(TableInfo.get(paramClass).getTableName()));
    if (!TextUtils.isEmpty(paramString))
    {
      paramClass.append(" WHERE ");
      paramClass.append(paramString);
    }
    return paramClass.toString();
  }
  
  public static SqlInfo getSelectSqlAsSqlInfo(Class<?> paramClass, Object paramObject)
  {
    Object localObject = TableInfo.get(paramClass);
    paramClass = new StringBuffer(getSelectSqlByTableName(((TableInfo)localObject).getTableName()));
    paramClass.append(" WHERE ");
    paramClass.append(((TableInfo)localObject).getId().getColumn());
    paramClass.append("=?");
    localObject = new SqlInfo();
    ((SqlInfo)localObject).setSql(paramClass.toString());
    ((SqlInfo)localObject).addValue(paramObject);
    return (SqlInfo)localObject;
  }
  
  private static String getSelectSqlByTableName(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer("SELECT * FROM ");
    localStringBuffer.append(paramString);
    return localStringBuffer.toString();
  }
  
  public static SqlInfo getUpdateSqlAsSqlInfo(Object paramObject)
  {
    Object localObject1 = TableInfo.get(paramObject.getClass());
    Object localObject2 = ((TableInfo)localObject1).getId().getValue(paramObject);
    if (localObject2 != null)
    {
      Object localObject3 = new ArrayList();
      Object localObject4 = ((TableInfo)localObject1).propertyMap.values().iterator();
      KeyValue localKeyValue;
      while (((Iterator)localObject4).hasNext())
      {
        localKeyValue = property2KeyValue((Property)((Iterator)localObject4).next(), paramObject);
        if (localKeyValue != null) {
          ((List)localObject3).add(localKeyValue);
        }
      }
      localObject4 = ((TableInfo)localObject1).manyToOneMap.values().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localKeyValue = manyToOne2KeyValue((ManyToOne)((Iterator)localObject4).next(), paramObject);
        if (localKeyValue != null) {
          ((List)localObject3).add(localKeyValue);
        }
      }
      if (((List)localObject3).size() == 0) {
        return null;
      }
      paramObject = new SqlInfo();
      localObject4 = new StringBuffer("UPDATE ");
      ((StringBuffer)localObject4).append(((TableInfo)localObject1).getTableName());
      ((StringBuffer)localObject4).append(" SET ");
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localKeyValue = (KeyValue)((Iterator)localObject3).next();
        ((StringBuffer)localObject4).append(localKeyValue.getKey());
        ((StringBuffer)localObject4).append("=?,");
        ((SqlInfo)paramObject).addValue(localKeyValue.getValue());
      }
      ((StringBuffer)localObject4).deleteCharAt(((StringBuffer)localObject4).length() - 1);
      ((StringBuffer)localObject4).append(" WHERE ");
      ((StringBuffer)localObject4).append(((TableInfo)localObject1).getId().getColumn());
      ((StringBuffer)localObject4).append("=?");
      ((SqlInfo)paramObject).addValue(localObject2);
      ((SqlInfo)paramObject).setSql(((StringBuffer)localObject4).toString());
      return (SqlInfo)paramObject;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("this entity[");
    ((StringBuilder)localObject1).append(paramObject.getClass());
    ((StringBuilder)localObject1).append("]'s id value is null");
    throw new DbException(((StringBuilder)localObject1).toString());
  }
  
  public static SqlInfo getUpdateSqlAsSqlInfo(Object paramObject, String paramString)
  {
    Object localObject1 = TableInfo.get(paramObject.getClass());
    Object localObject2 = new ArrayList();
    Object localObject3 = ((TableInfo)localObject1).propertyMap.values().iterator();
    KeyValue localKeyValue;
    while (((Iterator)localObject3).hasNext())
    {
      localKeyValue = property2KeyValue((Property)((Iterator)localObject3).next(), paramObject);
      if (localKeyValue != null) {
        ((List)localObject2).add(localKeyValue);
      }
    }
    localObject3 = ((TableInfo)localObject1).manyToOneMap.values().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localKeyValue = manyToOne2KeyValue((ManyToOne)((Iterator)localObject3).next(), paramObject);
      if (localKeyValue != null) {
        ((List)localObject2).add(localKeyValue);
      }
    }
    if (((List)localObject2).size() != 0)
    {
      paramObject = new SqlInfo();
      localObject3 = new StringBuffer("UPDATE ");
      ((StringBuffer)localObject3).append(((TableInfo)localObject1).getTableName());
      ((StringBuffer)localObject3).append(" SET ");
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (KeyValue)((Iterator)localObject1).next();
        ((StringBuffer)localObject3).append(((KeyValue)localObject2).getKey());
        ((StringBuffer)localObject3).append("=?,");
        ((SqlInfo)paramObject).addValue(((KeyValue)localObject2).getValue());
      }
      ((StringBuffer)localObject3).deleteCharAt(((StringBuffer)localObject3).length() - 1);
      if (!TextUtils.isEmpty(paramString))
      {
        ((StringBuffer)localObject3).append(" WHERE ");
        ((StringBuffer)localObject3).append(paramString);
      }
      ((SqlInfo)paramObject).setSql(((StringBuffer)localObject3).toString());
      return (SqlInfo)paramObject;
    }
    paramString = new StringBuilder();
    paramString.append("this entity[");
    paramString.append(paramObject.getClass());
    paramString.append("] has no property");
    throw new DbException(paramString.toString());
  }
  
  private static KeyValue manyToOne2KeyValue(ManyToOne paramManyToOne, Object paramObject)
  {
    String str = paramManyToOne.getColumn();
    paramObject = paramManyToOne.getValue(paramObject);
    if (paramObject != null)
    {
      if (paramObject.getClass() == ManyToOneLazyLoader.class) {
        paramManyToOne = TableInfo.get(paramManyToOne.getManyClass()).getId().getValue(((ManyToOneLazyLoader)paramObject).get());
      } else {
        paramManyToOne = TableInfo.get(paramObject.getClass()).getId().getValue(paramObject);
      }
      if ((str != null) && (paramManyToOne != null)) {
        return new KeyValue(str, paramManyToOne);
      }
    }
    return null;
  }
  
  private static KeyValue property2KeyValue(Property paramProperty, Object paramObject)
  {
    String str = paramProperty.getColumn();
    paramObject = paramProperty.getValue(paramObject);
    if (paramObject != null) {
      return new KeyValue(str, paramObject);
    }
    if ((paramProperty.getDefaultValue() != null) && (paramProperty.getDefaultValue().trim().length() != 0)) {
      return new KeyValue(str, paramProperty.getDefaultValue());
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\SqlBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */