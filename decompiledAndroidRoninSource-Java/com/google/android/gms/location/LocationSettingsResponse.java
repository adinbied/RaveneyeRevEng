package com.google.android.gms.location;

import com.google.android.gms.common.api.Response;

public class LocationSettingsResponse
  extends Response<LocationSettingsResult>
{
  public LocationSettingsStates getLocationSettingsStates()
  {
    return ((LocationSettingsResult)getResult()).getLocationSettingsStates();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationSettingsResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */