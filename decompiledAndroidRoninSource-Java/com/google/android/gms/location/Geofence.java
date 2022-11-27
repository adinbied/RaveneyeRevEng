package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.location.zzbh;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String zzad = null;
    private int zzae = 0;
    private long zzaf = Long.MIN_VALUE;
    private short zzag = -1;
    private double zzah;
    private double zzai;
    private float zzaj;
    private int zzak = 0;
    private int zzal = -1;
    
    public final Geofence build()
    {
      if (this.zzad != null)
      {
        int i = this.zzae;
        if (i != 0)
        {
          if (((i & 0x4) != 0) && (this.zzal < 0)) {
            throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
          }
          long l = this.zzaf;
          if (l != Long.MIN_VALUE)
          {
            if (this.zzag != -1)
            {
              i = this.zzak;
              if (i >= 0) {
                return new zzbh(this.zzad, this.zzae, (short)1, this.zzah, this.zzai, this.zzaj, l, i, this.zzal);
              }
              throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
            throw new IllegalArgumentException("Geofence region not set.");
          }
          throw new IllegalArgumentException("Expiration not set.");
        }
        throw new IllegalArgumentException("Transitions types not set.");
      }
      throw new IllegalArgumentException("Request ID not set.");
    }
    
    public final Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.zzag = 1;
      this.zzah = paramDouble1;
      this.zzai = paramDouble2;
      this.zzaj = paramFloat;
      return this;
    }
    
    public final Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.zzaf = -1L;
        return this;
      }
      this.zzaf = (SystemClock.elapsedRealtime() + paramLong);
      return this;
    }
    
    public final Builder setLoiteringDelay(int paramInt)
    {
      this.zzal = paramInt;
      return this;
    }
    
    public final Builder setNotificationResponsiveness(int paramInt)
    {
      this.zzak = paramInt;
      return this;
    }
    
    public final Builder setRequestId(String paramString)
    {
      this.zzad = paramString;
      return this;
    }
    
    public final Builder setTransitionTypes(int paramInt)
    {
      this.zzae = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\Geofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */