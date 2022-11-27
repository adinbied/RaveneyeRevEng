package dji.thirdparty.ciphersql;

import android.database.CharArrayBuffer;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CursorWindow
  extends android.database.CursorWindow
  implements Parcelable
{
  public static final Parcelable.Creator<CursorWindow> CREATOR = new Parcelable.Creator()
  {
    public CursorWindow createFromParcel(Parcel paramAnonymousParcel)
    {
      return new CursorWindow(paramAnonymousParcel, 0);
    }
    
    public CursorWindow[] newArray(int paramAnonymousInt)
    {
      return new CursorWindow[paramAnonymousInt];
    }
  };
  private int mStartPos;
  private long nWindow;
  
  public CursorWindow(Parcel paramParcel, int paramInt)
  {
    super(true);
    IBinder localIBinder = paramParcel.readStrongBinder();
    this.mStartPos = paramParcel.readInt();
    native_init(localIBinder);
  }
  
  public CursorWindow(boolean paramBoolean)
  {
    super(paramBoolean);
    this.mStartPos = 0;
    native_init(paramBoolean);
  }
  
  private native boolean allocRow_native();
  
  private native void close_native();
  
  private native char[] copyStringToBuffer_native(int paramInt1, int paramInt2, int paramInt3, CharArrayBuffer paramCharArrayBuffer);
  
  private native void freeLastRow_native();
  
  private native byte[] getBlob_native(int paramInt1, int paramInt2);
  
  private native double getDouble_native(int paramInt1, int paramInt2);
  
  private native long getLong_native(int paramInt1, int paramInt2);
  
  private native int getNumRows_native();
  
  private native String getString_native(int paramInt1, int paramInt2);
  
  private native int getType_native(int paramInt1, int paramInt2);
  
  private native boolean isBlob_native(int paramInt1, int paramInt2);
  
  private native boolean isFloat_native(int paramInt1, int paramInt2);
  
  private native boolean isInteger_native(int paramInt1, int paramInt2);
  
  private native boolean isNull_native(int paramInt1, int paramInt2);
  
  private native boolean isString_native(int paramInt1, int paramInt2);
  
  private native void native_clear();
  
  private native IBinder native_getBinder();
  
  private native void native_init(IBinder paramIBinder);
  
  private native void native_init(boolean paramBoolean);
  
  public static CursorWindow newFromParcel(Parcel paramParcel)
  {
    return (CursorWindow)CREATOR.createFromParcel(paramParcel);
  }
  
  private native boolean putBlob_native(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native boolean putDouble_native(double paramDouble, int paramInt1, int paramInt2);
  
  private native boolean putLong_native(long paramLong, int paramInt1, int paramInt2);
  
  private native boolean putNull_native(int paramInt1, int paramInt2);
  
  private native boolean putString_native(String paramString, int paramInt1, int paramInt2);
  
  private native boolean setNumColumns_native(int paramInt);
  
  public boolean allocRow()
  {
    return false;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void close()
  {
    releaseReference();
  }
  
  /* Error */
  public void copyStringToBuffer(int arg1, int arg2, CharArrayBuffer arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: return
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  /* Error */
  protected void finalize()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void freeLastRow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public byte[] getBlob(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public double getDouble(int paramInt1, int paramInt2)
  {
    return 1.37222045E-315D;
  }
  
  public float getFloat(int paramInt1, int paramInt2)
  {
    return 0.0F;
  }
  
  public int getInt(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public long getLong(int paramInt1, int paramInt2)
  {
    return 277740538L;
  }
  
  public int getNumRows()
  {
    return 0;
  }
  
  public short getShort(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public int getStartPosition()
  {
    return this.mStartPos;
  }
  
  public String getString(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public int getType(int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public boolean isBlob(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isFloat(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isLong(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isNull(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean isString(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  protected void onAllReferencesReleased()
  {
    close_native();
    super.onAllReferencesReleased();
  }
  
  public boolean putBlob(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean putDouble(double paramDouble, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean putLong(long paramLong, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean putNull(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean putString(String paramString, int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean setNumColumns(int paramInt)
  {
    acquireReference();
    try
    {
      boolean bool = setNumColumns_native(paramInt);
      return bool;
    }
    finally
    {
      releaseReference();
    }
  }
  
  public void setStartPosition(int paramInt)
  {
    this.mStartPos = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeStrongBinder(native_getBinder());
    paramParcel.writeInt(this.mStartPos);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\CursorWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */