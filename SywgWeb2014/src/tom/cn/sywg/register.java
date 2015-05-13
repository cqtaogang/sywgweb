package tom.cn.sywg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import android.content.Intent;

import android.widget.Spinner;

public class register extends Activity {

	private Spinner regYybSpinner;
	private EditText regGh;
	private EditText regPw;
	private Button regButton;
	private Button retButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Log.v("register","register start");
		regYybSpinner = (Spinner) findViewById(R.id.yybselect);
		regGh = (EditText) findViewById(R.id.register_edit_account);
		regPw = (EditText) findViewById(R.id.login_edit_pwd);
		regButton = (Button) findViewById(R.id.register_btn_register);
		retButton = (Button) findViewById(R.id.register_btn_return);

		
		regButton.setOnClickListener(rListener);
		retButton.setOnClickListener(rListener);
		
		
	}
		OnClickListener rListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.register_btn_return:
					Intent intent = new Intent();  
					intent.setClass(register.this,LoginActivity.class);   
					startActivity(intent);
					//setContentView(R.layout.loginpage);
					Log.v("register", "register return");
					break;
				case R.id.register_btn_register:
					Log.v("register ", "register ....");
					String yybx="";
					int yyb=regYybSpinner.getSelectedItemPosition();
					String username = regGh.getText().toString();
					String password = regPw.getText().toString();
					switch(yyb){
					case 0:
						yybx="2611";
						break;
					case 1:
						yybx="2612";
						break;
					case 2:
						yybx="2613";
						break;
					case 3:
						yybx="2614";
						break;
					case 4:
						yybx="2615";
						break;
					case 5:
						yybx="2616";
						break;
					case 6:
						yybx="2617";
						break;
				}
				
					Log.v("register",yyb+"/"+yybx+"/"+username+"/"+password);
					
					
				
					String str=WebServiceUtil.register(yybx, username, password);
					Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show(); 
					
					break;
				}
			}
		};
}
