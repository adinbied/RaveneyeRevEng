package com.google.android.gms.common.internal;

public final class ServiceSpecificExtraArgs
{
  public static abstract interface CastExtraArgs
  {
    public static final String LISTENER = "listener";
  }
  
  public static abstract interface GamesExtraArgs
  {
    public static final String DESIRED_LOCALE = "com.google.android.gms.games.key.desiredLocale";
    public static final String GAME_PACKAGE_NAME = "com.google.android.gms.games.key.gamePackageName";
    public static final String SIGNIN_OPTIONS = "com.google.android.gms.games.key.signInOptions";
    public static final String WINDOW_TOKEN = "com.google.android.gms.games.key.popupWindowToken";
  }
  
  public static abstract interface PlusExtraArgs
  {
    public static final String PLUS_AUTH_PACKAGE = "auth_package";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\ServiceSpecificExtraArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */