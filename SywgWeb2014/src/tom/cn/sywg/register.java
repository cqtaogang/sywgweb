package tom.cn.sywg;

//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;

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
	private EditText regName;
	private EditText regTel;
	private EditText regMail;
	private Button regButton;
	private Button retButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		Log.v("register","register start");
		regYybSpinner = (Spinner) findViewById(R.id.yybselect);
		
		regGh = (EditText) findViewById(R.id.register_edit_account);
		regName = (EditText) findViewById(R.id.login_edit_name);
		regTel = (EditText) findViewById(R.id.login_edit_tel);
		regMail = (EditText) findViewById(R.id.login_edit_mail);
		
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
					String name=regName.getText().toString();
					String tel = regTel.getText().toString();
					String mail = regMail.getText().toString();
					
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
					case 7:
						yybx="8236";
						break;					
					case 8:
						yybx="8259";
						break;				
					}
				
			/*	String strTest=regName.getText().toString();;
				    try {
						 strTest = URLEncoder.encode(name, "GB2312");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					  */
					Log.v("register",yyb+"/"+yybx+"/"+username+"/"+name+"/"+tel+"/"+mail+"/");
					String str=WebServiceUtil.register(yybx, username, name,tel,mail);
					Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show(); 
					
					break;
				}
			}
		};
}
