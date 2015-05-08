package tom.cn.sywg;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
//import java.net.UnknownHostException;
import java.util.Enumeration;

import tom.cn.sywg.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	private EditText mAccount;
	private EditText mPwd;
	private Button mRegisterButton;
	private Button mLoginButton;
	private Button mCancleButton;

	private UserDataManager mUserDataManager;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage);
		
		
		SharedPreferences sets = getSharedPreferences("swdata",MODE_PRIVATE);
		SharedPreferences.Editor editor = sets.edit();
		editor.putString("ip","0.0.0.0");
		editor.putString("username","2600");
		editor.commit();


		mAccount = (EditText) findViewById(R.id.login_edit_account);
		mPwd = (EditText) findViewById(R.id.login_edit_pwd);
		mRegisterButton = (Button) findViewById(R.id.login_btn_register);
		mLoginButton = (Button) findViewById(R.id.login_btn_login);
		mCancleButton = (Button) findViewById(R.id.login_btn_cancle);

		mRegisterButton.setOnClickListener(mListener);
		mLoginButton.setOnClickListener(mListener);
		mCancleButton.setOnClickListener(mListener);

		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
		}
	}

	OnClickListener mListener = new OnClickListener() {
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.login_btn_register:
				Log.v("go", "to go");
				Intent intent01 = new Intent();
				intent01.setClass(LoginActivity.this, register.class);
				startActivity(intent01);
				// setContentView(R.layout.register);
				break;
			case R.id.login_btn_login:
				login();
				break;
			case R.id.login_btn_cancle:
				cancle();
				break;
			}
		}
	};

	public void login() {
		if (!netConnected(getApplicationContext())) {
			Toast.makeText(getApplicationContext(), "ÍøÂçÎ´Áª½Ó!",
					Toast.LENGTH_SHORT).show();
		} else {

			if (isUserNameAndPwdValid()) {
				Log.v("loginx ", "login ....");
				String username = mAccount.getText().toString().trim();
				String userPwd = mPwd.getText().toString().trim();
				String str = WebServiceUtil.login(username, userPwd);

				String ip = getLocalIpAddress();

				Log.v("loginx ", username + "/" + userPwd + "/" + ip);

				if (str.equals("s")) {
					Toast.makeText(getApplicationContext(), str + "µÇÂ¼³É¹¦!" + ip,
							Toast.LENGTH_SHORT).show();

					SharedPreferences sets = getSharedPreferences("swdata",MODE_PRIVATE);
					SharedPreferences.Editor editor = sets.edit();
					editor.putString("ip",ip);
					editor.putString("username",username);
					editor.commit();


					
					Intent intent02 = new Intent();
					intent02.setClass(LoginActivity.this, cjcx.class);
					startActivity(intent02);

				} else {
					Toast.makeText(getApplicationContext(), str + "µÇÂ¼Ê§°Ü!" + ip,
							Toast.LENGTH_SHORT).show();

				}
			}
		}
	}

	private String intToIp(int i) {

		return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)
				+ "." + (i >> 24 & 0xFF);
	}

	public void register() {
		if (isUserNameAndPwdValid()) {
			String userName = mAccount.getText().toString().trim();
			String userPwd = mPwd.getText().toString().trim();
			// check if user name is already exist
			int count = mUserDataManager.findUserByName(userName);

			if (count > 0) {
				Toast.makeText(this,
						getString(R.string.name_already_exist, userName),
						Toast.LENGTH_SHORT).show();
				return;
			}

			UserData mUser = new UserData(userName, userPwd);
			mUserDataManager.openDataBase();
			long flag = mUserDataManager.insertUserData(mUser);
			if (flag == -1) {
				Toast.makeText(this, getString(R.string.register_fail),
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, getString(R.string.register_sucess),
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	// ÊÇ·ñÁªÍøÍøÂç
	public static boolean netConnected(Context context) {
		try {
			// Connectivity Manager connectivityManager =
			// (ConnectivityManager)context.getSystemService(CONNECTIVITY_SERVICE);

			ConnectivityManager manger = (ConnectivityManager) context
					.getSystemService(CONNECTIVITY_SERVICE);

			NetworkInfo info = manger.getActiveNetworkInfo();
			return (info != null && info.isConnected());
		} catch (Exception e) {
			return false;
		}
	}

	public String getLocalIpAddress() {
		String ls = "";

		try {

			WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
			if (wifiManager.isWifiEnabled()) {
				WifiInfo wifiInfo = wifiManager.getConnectionInfo();
				int ipAddress = wifiInfo.getIpAddress();
				return intToIp(ipAddress);
			} else {
				for (Enumeration<NetworkInterface> en = NetworkInterface
						.getNetworkInterfaces(); en.hasMoreElements();) {
					NetworkInterface intf = en.nextElement();
					for (Enumeration<InetAddress> enumIpAddr = intf
							.getInetAddresses(); enumIpAddr.hasMoreElements();) {
						InetAddress inetAddress = enumIpAddr.nextElement();
						if (!inetAddress.isLoopbackAddress()) {
							return inetAddress.getHostAddress().toString();
						}
					}
				}
				return null;
			}
		} catch (SocketException ex) {
			Log.e("WifiPreference IpAddress", ex.toString());
			return ex.toString();
		}
	}

	public void cancle() {
		mAccount.setText("");
		mPwd.setText("");
	}

	public boolean isUserNameAndPwdValid() {
		if (mAccount.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.account_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		} else if (mPwd.getText().toString().trim().equals("")) {
			Toast.makeText(this, getString(R.string.pwd_empty),
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	@Override
	protected void onResume() {
		if (mUserDataManager == null) {
			mUserDataManager = new UserDataManager(this);
			mUserDataManager.openDataBase();
		}
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		if (mUserDataManager != null) {
			mUserDataManager.closeDataBase();
			mUserDataManager = null;
		}
		super.onPause();
	}
}