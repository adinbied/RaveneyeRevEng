package io.flutter.embedding.android;

import io.flutter.embedding.engine.FlutterEngine;

public abstract interface FlutterEngineConfigurator
{
  public abstract void cleanUpFlutterEngine(FlutterEngine paramFlutterEngine);
  
  public abstract void configureFlutterEngine(FlutterEngine paramFlutterEngine);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterEngineConfigurator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */