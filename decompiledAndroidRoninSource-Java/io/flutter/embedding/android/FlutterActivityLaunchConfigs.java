package io.flutter.embedding.android;

public class FlutterActivityLaunchConfigs
{
  static final String DART_ENTRYPOINT_META_DATA_KEY = "io.flutter.Entrypoint";
  static final String DEFAULT_BACKGROUND_MODE = BackgroundMode.opaque.name();
  static final String DEFAULT_DART_ENTRYPOINT = "main";
  static final String DEFAULT_INITIAL_ROUTE = "/";
  static final String EXTRA_BACKGROUND_MODE = "background_mode";
  static final String EXTRA_CACHED_ENGINE_ID = "cached_engine_id";
  static final String EXTRA_DESTROY_ENGINE_WITH_ACTIVITY = "destroy_engine_with_activity";
  static final String EXTRA_INITIAL_ROUTE = "route";
  static final String INITIAL_ROUTE_META_DATA_KEY = "io.flutter.InitialRoute";
  static final String NORMAL_THEME_META_DATA_KEY = "io.flutter.embedding.android.NormalTheme";
  static final String SPLASH_SCREEN_META_DATA_KEY = "io.flutter.embedding.android.SplashScreenDrawable";
  
  public static enum BackgroundMode
  {
    static
    {
      BackgroundMode localBackgroundMode = new BackgroundMode("transparent", 1);
      transparent = localBackgroundMode;
      $VALUES = new BackgroundMode[] { opaque, localBackgroundMode };
    }
    
    private BackgroundMode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterActivityLaunchConfigs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */