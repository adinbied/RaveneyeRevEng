package dji.pilot.active;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.dji.basic.countrycode.contorller.CountryCodeGetter;
import dji.log.RoninLog;
import dji.logic.manager.DJIUSBWifiSwitchManager;
import dji.midware.broadcastReceivers.DJINetWorkReceiver;
import dji.midware.data.manager.P3.ServiceManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivateUtils
{
  private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
  
  public static int dp2px(Context paramContext, int paramInt)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    return (int)(paramInt * f + 0.5F);
  }
  
  public static boolean getIsChina(Context paramContext)
  {
    int i = paramContext.getResources().getConfiguration().mcc;
    boolean bool3 = true;
    boolean bool2 = true;
    boolean bool1 = bool3;
    if (i != 460)
    {
      bool1 = bool3;
      if (i != 454)
      {
        bool1 = bool3;
        if (i != 466)
        {
          if (i == 455) {
            return true;
          }
          paramContext = CountryCodeGetter.getInstance().getBestValue();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get c get code=");
          localStringBuilder.append(paramContext);
          log(localStringBuilder.toString());
          if (!TextUtils.isEmpty(paramContext))
          {
            bool1 = bool2;
            if (!paramContext.equals("CN"))
            {
              bool1 = bool2;
              if (!paramContext.equals("HK"))
              {
                bool1 = bool2;
                if (!paramContext.equals("TW"))
                {
                  if (paramContext.equals("MO")) {
                    return true;
                  }
                  bool1 = false;
                }
              }
            }
            return bool1;
          }
          paramContext = Locale.getDefault().getCountry();
          bool1 = bool3;
          if (!Locale.CHINA.getCountry().equals(paramContext))
          {
            if (Locale.TAIWAN.getCountry().equals(paramContext)) {
              return true;
            }
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean getIsJapan(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getResources().getConfiguration().mcc == 440)) {
      return true;
    }
    paramContext = CountryCodeGetter.getInstance().getBestValue();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("get j get code=");
    localStringBuilder.append(paramContext);
    log(localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext.equals("JP");
    }
    return Locale.JAPAN.getCountry().equals(Locale.getDefault().getCountry());
  }
  
  public static boolean getIsNetWorkOk(Context paramContext)
  {
    return (DJINetWorkReceiver.getNetWorkStatusNoPing(paramContext)) && ((!DJIUSBWifiSwitchManager.getInstance().isProductWifiConnected(null)) || (!ServiceManager.getInstance().isRemoteOK()));
  }
  
  public static int getListViewHeight(ListView paramListView)
  {
    ListAdapter localListAdapter = paramListView.getAdapter();
    if (localListAdapter == null) {
      return 0;
    }
    int i = 0;
    int j = 0;
    while (i < localListAdapter.getCount())
    {
      View localView = localListAdapter.getView(i, null, paramListView);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      j += localView.getMeasuredHeight();
      i += 1;
    }
    return j + paramListView.getDividerHeight() * (localListAdapter.getCount() - 1);
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    paramContext.getSize(localPoint);
    return localPoint.y;
  }
  
  public static void log(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(format.format(new Date()));
    localStringBuilder.append(" @");
    localStringBuilder.append(paramString);
    RoninLog.logWriteE("ACTIVATE_NEW", localStringBuilder.toString(), "active", new Object[0]);
  }
  
  public static void logLite(String paramString)
  {
    RoninLog.logWriteE("ACTIVATE_NEW", paramString, "active", new Object[0]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\active\ActivateUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */