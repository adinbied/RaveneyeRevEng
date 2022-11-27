package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;

public class DisabledBreadcrumbSource
  implements BreadcrumbSource
{
  public void registerBreadcrumbHandler(BreadcrumbHandler paramBreadcrumbHandler)
  {
    Logger.getLogger().d("Could not register handler for breadcrumbs events.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\breadcrumbs\DisabledBreadcrumbSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */