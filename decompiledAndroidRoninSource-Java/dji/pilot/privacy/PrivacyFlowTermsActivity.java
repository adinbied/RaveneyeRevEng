package dji.pilot.privacy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;

public class PrivacyFlowTermsActivity
  extends Activity
{
  public static final String TAG = "PrivacyFlowTermsActivity";
  private boolean mFirstAgree;
  private Button mPrivacyFlowTermsAgreeLy;
  private CheckBox mPrivacyFlowTermsCb;
  private WebView mPrivacyFlowTermsContent;
  private Button mPrivacyFlowTermsRefuseBt;
  private String ppURL;
  private String preStr = "file:///android_asset/";
  private String termURL;
  
  public PrivacyFlowTermsActivity()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.preStr);
    localStringBuilder.append("terms/dji-ronin-terms-of-use-en-2.0-2020-06-10.html");
    this.termURL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.preStr);
    localStringBuilder.append("htmls/dji-ronin-privacy-notice-20200119.html");
    this.ppURL = localStringBuilder.toString();
    this.mFirstAgree = false;
  }
  
  /* Error */
  private void assignViews()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static void start(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, PrivacyFlowTermsActivity.class));
  }
  
  public void onBackPressed() {}
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\pilot\privacy\PrivacyFlowTermsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */