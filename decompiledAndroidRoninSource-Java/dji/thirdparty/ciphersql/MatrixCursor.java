package dji.thirdparty.ciphersql;

public class MatrixCursor
  extends AbstractCursor
{
  private final int columnCount;
  private final String[] columnNames;
  private Object[] data;
  private int rowCount = 0;
  
  public MatrixCursor(String[] paramArrayOfString)
  {
    this(paramArrayOfString, 16);
  }
  
  public MatrixCursor(String[] paramArrayOfString, int paramInt)
  {
    this.columnNames = paramArrayOfString;
    this.columnCount = paramArrayOfString.length;
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    this.data = new Object[this.columnCount * i];
  }
  
  /* Error */
  private void addRow(java.util.ArrayList<?> arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void ensureCapacity(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  private Object get(int paramInt)
  {
    return null;
  }
  
  /* Error */
  public void addRow(Iterable<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addRow(Object[] arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String[] getColumnNames()
  {
    return this.columnNames;
  }
  
  public int getCount()
  {
    return this.rowCount;
  }
  
  public double getDouble(int paramInt)
  {
    return 1.37330967E-315D;
  }
  
  public float getFloat(int paramInt)
  {
    return 0.0F;
  }
  
  public int getInt(int paramInt)
  {
    return 0;
  }
  
  public long getLong(int paramInt)
  {
    return 277960996L;
  }
  
  public short getShort(int paramInt)
  {
    return 0;
  }
  
  public String getString(int paramInt)
  {
    Object localObject = get(paramInt);
    if (localObject == null) {
      return null;
    }
    return localObject.toString();
  }
  
  public int getType(int paramInt)
  {
    return DatabaseUtils.getTypeOfObject(get(paramInt));
  }
  
  public boolean isNull(int paramInt)
  {
    return get(paramInt) == null;
  }
  
  public RowBuilder newRow()
  {
    return null;
  }
  
  public class RowBuilder
  {
    private final int endIndex;
    private int index;
    
    RowBuilder(int paramInt1, int paramInt2)
    {
      this.index = paramInt1;
      this.endIndex = paramInt2;
    }
    
    public RowBuilder add(Object paramObject)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\MatrixCursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */