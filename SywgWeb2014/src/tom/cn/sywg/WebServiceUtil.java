/**
 *
 */
package tom.cn.sywg;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


public class WebServiceUtil {
	// 定义Web Service的命名空间
	static final String SERVICE_NS = "http://www.w3.org/2001/XMLSchema/";

	// static final String SERVICE_NS = "http://WebXml.com/";
	// 定义Web Service提供服务的URL
	//static final String SERVICE_URL = "http://218.70.15.66:16699/sw/swsoapserver.php";
	static final String SERVICE_URL = "http://www.cntoman.com/sw/swsoapserver.php";

	// 定义Web Service的命名空间
	// - static final String SERVICE_NS = "http://WebXml.com.cn/";
	// 定义Web Service提供服务的URL
	// - static final String SERVICE_URL =
	// - "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx";

	// ------------

	public static String register(String yyb, String username, String name,String tel,String mail) {
		// 调用的方法
		final String methodName = "register";
		// 创建HttpTransportSE传输对象
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// 使用SOAP1.1协议创建Envelop对象
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("yyb", yyb);
		soapObject.addProperty("username", username);
		soapObject.addProperty("name", name);
		soapObject.addProperty("tel", tel);
		soapObject.addProperty("mail", mail);

		envelope.bodyOut = soapObject;
		// 设置与.Net提供的Web Service保持较好的兼容性
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// 调用Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// 获取服务器响应返回的SOAP消息
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// 解析服务器响应的SOAP消息。
							// return parseProvinceOrCity(detail);
							return result.getProperty(0).toString();
							// + envelope.toString();
							// return envelope.toString();

						}
						return null;
					}
				});
		new Thread(task).start();
		try {
			return task.get();
			// + "//*//" + soapObject.toString() + "//*//";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String login(String username, String password) {
		// 调用的方法
		final String methodName = "login";
		// 创建HttpTransportSE传输对象
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// 使用SOAP1.1协议创建Envelop对象
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("username", username);
		soapObject.addProperty("password", password);

		envelope.bodyOut = soapObject;
		// 设置与.Net提供的Web Service保持较好的兼容性
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// 调用Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// 获取服务器响应返回的SOAP消息
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// 解析服务器响应的SOAP消息。
							// return parseProvinceOrCity(detail);
							return result.getProperty(0).toString();
							// + envelope.toString();
							// return envelope.toString();

						}
						return null;
					}
				});
		new Thread(task).start();
		try {
			return task.get();
			// + "//*//" + soapObject.toString() + "//*//";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String Xcx() {
		// 调用的方法
		final String methodName = "returnx";
		// 创建HttpTransportSE传输对象
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// 使用SOAP1.1协议创建Envelop对象
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);

		envelope.bodyOut = soapObject;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {

						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {

							SoapObject result = (SoapObject) envelope.bodyIn;
							return result.getProperty(0).toString();

						}
						return null;
					}
				});
		new Thread(task).start();
		try {
			return task.get();
			// + "//*//" + soapObject.toString() + "//*//";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String Scx() {
		// 调用的方法
		final String methodName = "returns";
		// 创建HttpTransportSE传输对象
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// 使用SOAP1.1协议创建Envelop对象
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);

		envelope.bodyOut = soapObject;
		// 设置与.Net提供的Web Service保持较好的兼容性
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// 调用Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// 获取服务器响应返回的SOAP消息
							SoapObject result = (SoapObject) envelope.bodyIn;

							return result.getProperty(0).toString();
						}
						return null;
					}
				});
		new Thread(task).start();
		try {
			return task.get();
			// + "//*//" + soapObject.toString() + "//*//";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String hqWrite(String username,String jrcj,String zrcj,String zrdlsr,String ip ) {
		// 调用的方法
		final String methodName = "hqWrite";
		// 创建HttpTransportSE传输对象
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// 使用SOAP1.1协议创建Envelop对象
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// 实例化SoapObject对象
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("username", username);
		soapObject.addProperty("cjl", jrcj);
		soapObject.addProperty("zrcjl", zrcj);
		soapObject.addProperty("zrsr", zrdlsr);
		soapObject.addProperty("ip", ip);

		envelope.bodyOut = soapObject;
		// 设置与.Net提供的Web Service保持较好的兼容性
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// 调用Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// 获取服务器响应返回的SOAP消息
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// 解析服务器响应的SOAP消息。
							// return parseProvinceOrCity(detail);
							return result.getProperty(0).toString();
							// + envelope.toString();
							// return envelope.toString();

						}
						return null;
					}
				});
		new Thread(task).start();
		try {
			return task.get();
			// + "//*//" + soapObject.toString() + "//*//";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
