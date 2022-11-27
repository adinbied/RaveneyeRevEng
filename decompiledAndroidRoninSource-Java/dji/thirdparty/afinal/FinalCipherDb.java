package dji.thirdparty.afinal;

import android.content.Context;
import dji.thirdparty.afinal.db.sqlite.CursorUtils;
import dji.thirdparty.afinal.db.sqlite.DbModel;
import dji.thirdparty.afinal.db.sqlite.SqlBuilder;
import dji.thirdparty.afinal.db.table.TableInfo;
import dji.thirdparty.ciphersql.database.SQLiteDatabase;
import dji.thirdparty.ciphersql.database.SQLiteOpenHelper;
import dji.thirdparty.ciphersql.database.SQLiteStatement;
import java.util.HashMap;
import java.util.List;

public class FinalCipherDb
  extends FinalDb
{
  private static final String TAG = "FinalCipherDb";
  private static HashMap<String, FinalCipherDb> daoMap = new HashMap();
  private DaoConfig config;
  private SQLiteDatabase db = generateDb(paramDaoConfig);
  private SQLiteStatement statement;
  private String statementKey;
  private SQLiteStatement statementWhere;
  private TableInfo tableInfo;
  
  private FinalCipherDb(DaoConfig paramDaoConfig)
  {
    this.config = paramDaoConfig;
  }
  
  public static FinalCipherDb create(Context paramContext)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString1, String paramString2)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString2);
    localDaoConfig.setTargetDirectory(paramString1);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setTargetDirectory(paramString1);
    localDaoConfig.setDbName(paramString2);
    localDaoConfig.setDebug(paramBoolean);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, DbUpdateListener paramDbUpdateListener)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setTargetDirectory(paramString1);
    localDaoConfig.setDbName(paramString2);
    localDaoConfig.setDebug(paramBoolean);
    localDaoConfig.setDbVersion(paramInt);
    localDaoConfig.setDbUpdateListener(paramDbUpdateListener);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, String paramString3, DbUpdateListener paramDbUpdateListener)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setTargetDirectory(paramString1);
    localDaoConfig.setDbName(paramString2);
    localDaoConfig.setDebug(paramBoolean);
    localDaoConfig.setDbVersion(paramInt);
    localDaoConfig.setPwdKey(paramString3);
    localDaoConfig.setDbUpdateListener(paramDbUpdateListener);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString, boolean paramBoolean)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    localDaoConfig.setDebug(paramBoolean);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, String paramString, boolean paramBoolean, int paramInt, DbUpdateListener paramDbUpdateListener)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDbName(paramString);
    localDaoConfig.setDebug(paramBoolean);
    localDaoConfig.setDbVersion(paramInt);
    localDaoConfig.setDbUpdateListener(paramDbUpdateListener);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(Context paramContext, boolean paramBoolean)
  {
    DaoConfig localDaoConfig = new DaoConfig();
    localDaoConfig.setContext(paramContext);
    localDaoConfig.setDebug(paramBoolean);
    return create(localDaoConfig);
  }
  
  public static FinalCipherDb create(DaoConfig paramDaoConfig)
  {
    return getInstance(paramDaoConfig);
  }
  
  private SQLiteDatabase createDbFileOnSDCard(String paramString1, String paramString2, int paramInt, DbUpdateListener paramDbUpdateListener)
  {
    return null;
  }
  
  /* Error */
  private void debugSql(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void exeSqlInfo(dji.thirdparty.afinal.db.sqlite.SqlInfo arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private <T> List<T> findAllBySql(Class<T> paramClass, String paramString)
  {
    return null;
  }
  
  private SQLiteDatabase generateDb(DaoConfig paramDaoConfig)
  {
    return null;
  }
  
  private static FinalCipherDb getInstance(DaoConfig paramDaoConfig)
  {
    try
    {
      FinalCipherDb localFinalCipherDb2 = (FinalCipherDb)daoMap.get(paramDaoConfig.getDbName());
      FinalCipherDb localFinalCipherDb1 = localFinalCipherDb2;
      if (localFinalCipherDb2 == null)
      {
        localFinalCipherDb1 = new FinalCipherDb(paramDaoConfig);
        daoMap.put(paramDaoConfig.getDbName(), localFinalCipherDb1);
      }
      return localFinalCipherDb1;
    }
    finally {}
  }
  
  /* Error */
  private void insertContentValues(List<dji.thirdparty.afinal.db.table.KeyValue> arg1, android.content.ContentValues arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void sqlcipherStatementBindAllStrings(SQLiteStatement arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean tableIsExist(TableInfo paramTableInfo)
  {
    return false;
  }
  
  public TableInfo checkTableExist(Class<?> paramClass)
  {
    return null;
  }
  
  /* Error */
  public void delete(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void deleteAll(Class<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void deleteById(Class<?> paramClass, Object paramObject)
  {
    checkTableExist(paramClass);
    exeSqlInfo(SqlBuilder.buildDeleteSql(paramClass, paramObject));
  }
  
  public void deleteByWhere(Class<?> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    paramClass = SqlBuilder.buildDeleteSql(paramClass, paramString);
    debugSql(paramClass);
    this.db.execSQL(paramClass);
  }
  
  /* Error */
  public void dropDb()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dropTable(Class<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public <T> List<T> findAll(Class<T> paramClass)
  {
    return null;
  }
  
  public <T> List<T> findAll(Class<T> paramClass, String paramString)
  {
    return null;
  }
  
  public <T> List<T> findAll(Class<T> paramClass, String paramString1, String paramString2)
  {
    return null;
  }
  
  public <T> List<T> findAllByWhere(Class<T> paramClass, String paramString)
  {
    checkTableExist(paramClass);
    return findAllBySql(paramClass, SqlBuilder.getSelectSQLByWhere(paramClass, paramString));
  }
  
  public <T> List<T> findAllByWhere(Class<T> paramClass, String paramString1, String paramString2)
  {
    return null;
  }
  
  public <T> T findById(Object paramObject, Class<T> paramClass)
  {
    return null;
  }
  
  public DbModel findDbModelBySQL(String paramString)
  {
    return null;
  }
  
  public List<DbModel> findDbModelListBySQL(String paramString)
  {
    return null;
  }
  
  public <T> T findWithManyToOneById(Object paramObject, Class<T> paramClass)
  {
    return null;
  }
  
  public <T> T findWithManyToOneById(Object paramObject, Class<T> paramClass, Class<?>... paramVarArgs)
  {
    return null;
  }
  
  public <T> T findWithOneToManyById(Object paramObject, Class<T> paramClass)
  {
    return null;
  }
  
  public <T> T findWithOneToManyById(Object paramObject, Class<T> paramClass, Class<?>... paramVarArgs)
  {
    checkTableExist(paramClass);
    paramObject = SqlBuilder.getSelectSQL(paramClass, paramObject);
    debugSql((String)paramObject);
    paramObject = findDbModelBySQL((String)paramObject);
    if (paramObject != null) {
      return (T)loadOneToMany(CursorUtils.dbModel2Entity((DbModel)paramObject, paramClass), paramClass, paramVarArgs);
    }
    return null;
  }
  
  public <T> T loadManyToOne(DbModel paramDbModel, T paramT, Class<T> paramClass, Class<?>... paramVarArgs)
  {
    return null;
  }
  
  public <T> T loadOneToMany(T paramT, Class<T> paramClass, Class<?>... paramVarArgs)
  {
    return null;
  }
  
  /* Error */
  public void reopen()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void save(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean saveBindId(Object paramObject)
  {
    return false;
  }
  
  /* Error */
  public void saveManyByWhereStart(Object arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveManyEnd()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveManyEndByWhere()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveManyStart(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveManyStep(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void saveManyStepByWhere(Object arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void update(Object arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void update(Object arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class DaoConfig
  {
    private FinalCipherDb.DbUpdateListener dbUpdateListener;
    private int dbVersion = 1;
    private boolean debug = true;
    private Context mContext = null;
    private String mDbName = "dji.db";
    private String pwdKey = "";
    private String targetDirectory;
    
    public Context getContext()
    {
      return this.mContext;
    }
    
    public String getDbName()
    {
      return this.mDbName;
    }
    
    public FinalCipherDb.DbUpdateListener getDbUpdateListener()
    {
      return this.dbUpdateListener;
    }
    
    public int getDbVersion()
    {
      return this.dbVersion;
    }
    
    public String getTargetDirectory()
    {
      return this.targetDirectory;
    }
    
    public boolean isDebug()
    {
      return this.debug;
    }
    
    public void setContext(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public void setDbName(String paramString)
    {
      this.mDbName = paramString;
    }
    
    public void setDbUpdateListener(FinalCipherDb.DbUpdateListener paramDbUpdateListener)
    {
      this.dbUpdateListener = paramDbUpdateListener;
    }
    
    public void setDbVersion(int paramInt)
    {
      this.dbVersion = paramInt;
    }
    
    public void setDebug(boolean paramBoolean)
    {
      this.debug = paramBoolean;
    }
    
    public void setPwdKey(String paramString)
    {
      this.pwdKey = paramString;
    }
    
    public void setTargetDirectory(String paramString)
    {
      this.targetDirectory = paramString;
    }
  }
  
  public static abstract interface DbUpdateListener
  {
    public abstract void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
    
    public abstract void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2);
  }
  
  class SqliteDbHelper
    extends SQLiteOpenHelper
  {
    private FinalCipherDb.DbUpdateListener mDbUpdateListener;
    
    public SqliteDbHelper(Context paramContext, String paramString, int paramInt, FinalCipherDb.DbUpdateListener paramDbUpdateListener)
    {
      super(paramString, null, paramInt);
      this.mDbUpdateListener = paramDbUpdateListener;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
    
    /* Error */
    public void onUpgrade(SQLiteDatabase arg1, int arg2, int arg3)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\FinalCipherDb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */