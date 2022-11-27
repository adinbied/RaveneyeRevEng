package com.huawei.hms.support.api.client;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Status
  implements Parcelable
{
  public static final Parcelable.Creator<Status> CREATOR = new a();
  public static final Status CoreException;
  public static final Status FAILURE;
  public static final Status MessageNotFound;
  public static final Status SUCCESS = new Status(0);
  @com.huawei.hms.core.aidl.a.a
  private int a;
  @com.huawei.hms.core.aidl.a.a
  private String b;
  @com.huawei.hms.core.aidl.a.a
  private final PendingIntent c;
  
  static
  {
    FAILURE = new Status(1);
    MessageNotFound = new Status(404);
    CoreException = new Status(500);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  public Status(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramPendingIntent;
  }
  
  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public PendingIntent getResolution()
  {
    return this.c;
  }
  
  public int getStatusCode()
  {
    return this.a;
  }
  
  public String getStatusMessage()
  {
    return this.b;
  }
  
  public boolean hasResolution()
  {
    return this.c != null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isSuccess()
  {
    return this.a <= 0;
  }
  
  /* Error */
  public void startResolutionForResult(android.app.Activity arg1, int arg2)
    throws android.content.IntentSender.SendIntentException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String toString()
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    PendingIntent.writePendingIntentOrNullToParcel(this.c, paramParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\client\Status.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */