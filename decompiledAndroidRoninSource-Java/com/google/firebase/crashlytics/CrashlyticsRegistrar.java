package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component.Builder;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar
  implements ComponentRegistrar
{
  private FirebaseCrashlytics buildCrashlytics(ComponentContainer paramComponentContainer)
  {
    FirebaseApp localFirebaseApp = (FirebaseApp)paramComponentContainer.get(FirebaseApp.class);
    CrashlyticsNativeComponent localCrashlyticsNativeComponent = (CrashlyticsNativeComponent)paramComponentContainer.get(CrashlyticsNativeComponent.class);
    AnalyticsConnector localAnalyticsConnector = (AnalyticsConnector)paramComponentContainer.get(AnalyticsConnector.class);
    return FirebaseCrashlytics.init(localFirebaseApp, (FirebaseInstallationsApi)paramComponentContainer.get(FirebaseInstallationsApi.class), localCrashlyticsNativeComponent, localAnalyticsConnector);
  }
  
  public List<Component<?>> getComponents()
  {
    return Arrays.asList(new Component[] { Component.builder(FirebaseCrashlytics.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstallationsApi.class)).add(Dependency.optional(AnalyticsConnector.class)).add(Dependency.optional(CrashlyticsNativeComponent.class)).factory(CrashlyticsRegistrar..Lambda.1.lambdaFactory$(this)).eagerInDefaultApp().build(), LibraryVersionComponent.create("fire-cls", "17.2.2") });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\CrashlyticsRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */