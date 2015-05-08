package tom.cn.sywg;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import android.content.SharedPreferences;


public class cjcx extends Activity {

	private EditText textJrcj;
	private EditText textZrcj;
	private EditText textZrdlsr;
	private EditText textCjcalc;
	private Button buttonInput;
	private Button buttonScx;
	private Button buttonXcx;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cjcx);
		Log.v("cjcx", "cjcx start");

		textJrcj = (EditText) findViewById(R.id.textJrcj);
		textZrcj = (EditText) findViewById(R.id.textZrcj);
		textZrdlsr = (EditText) findViewById(R.id.textZrdlsr);
		textCjcalc = (EditText) findViewById(R.id.textCjcalc);
		buttonInput = (Button) findViewById(R.id.buttonInput);
		buttonScx = (Button) findViewById(R.id.buttonScx);
		buttonXcx = (Button) findViewById(R.id.buttonXcx);

		buttonInput.setOnClickListener(rListener);
		buttonScx.setOnClickListener(rListener);
		buttonXcx.setOnClickListener(rListener);
	}

	OnClickListener rListener = new OnClickListener() {
		String str = "";

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.buttonInput:
				Log.v("cjcx", "dataInput...");
				String jrcj = textJrcj.getText().toString();
				String zrcj = textZrcj.getText().toString();
				String zrdlsr = textZrdlsr.getText().toString();

				SharedPreferences sets = getSharedPreferences("swdata",
						MODE_PRIVATE);
				String ip = sets.getString("ip", null);
				String username = sets.getString("username", null);

				String str = WebServiceUtil.hqWrite(username, jrcj, zrcj,
						zrdlsr, ip);

				Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT)
						.show();

				break;
			case R.id.buttonScx:
				Log.v("cjcx", "dataScx...");
				str = WebServiceUtil.Scx();
				textCjcalc.setText(str);
				break;
			case R.id.buttonXcx:
				Log.v("cjcx", "dataXcx...");
				str = WebServiceUtil.Xcx();
				textCjcalc.setText(str);
				break;
			}
		}
	};
}
