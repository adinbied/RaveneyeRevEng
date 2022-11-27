package com.huawei.hms.support.api.game.c.b;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.huawei.hms.c.h;

public class d
  extends FrameLayout
{
  private View a;
  private View b;
  
  public d(Context paramContext, String paramString)
  {
    super(paramContext);
    paramContext = LayoutInflater.from(paramContext).inflate(getResources().getLayout(h.a("hms_game_top_async_login")), this);
    this.b = paramContext.findViewById(h.b("login_notice_view"));
    this.a = paramContext.findViewById(h.b("top_notice_bg"));
    ((TextView)paramContext.findViewById(h.b("top_notice_text"))).setText(h.a("hms_game_login_notice", new Object[] { paramString }));
  }
  
  public View getBackgroundView()
  {
    return this.a;
  }
  
  public View getTopNoticeView()
  {
    return this.b;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\game\c\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */