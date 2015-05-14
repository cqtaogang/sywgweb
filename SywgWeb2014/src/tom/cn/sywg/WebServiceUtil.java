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
	// ����Web Service�������ռ�
	static final String SERVICE_NS = "http://www.w3.org/2001/XMLSchema/";

	// static final String SERVICE_NS = "http://WebXml.com/";
	// ����Web Service�ṩ�����URL
	//static final String SERVICE_URL = "http://218.70.15.66:16699/sw/swsoapserver.php";
	static final String SERVICE_URL = "http://www.cntoman.com/sw/swsoapserver.php";

	// ����Web Service�������ռ�
	// - static final String SERVICE_NS = "http://WebXml.com.cn/";
	// ����Web Service�ṩ�����URL
	// - static final String SERVICE_URL =
	// - "http://webservice.webxml.com.cn/WebServices/WeatherWS.asmx";

	// ------------

	public static String register(String yyb, String username, String name,String tel,String mail) {
		// ���õķ���
		final String methodName = "register";
		// ����HttpTransportSE�������
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// ʹ��SOAP1.1Э�鴴��Envelop����
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// ʵ����SoapObject����
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("yyb", yyb);
		soapObject.addProperty("username", username);
		soapObject.addProperty("name", name);
		soapObject.addProperty("tel", tel);
		soapObject.addProperty("mail", mail);

		envelope.bodyOut = soapObject;
		// ������.Net�ṩ��Web Service���ֽϺõļ�����
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// ����Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// ��ȡ��������Ӧ���ص�SOAP��Ϣ
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// ������������Ӧ��SOAP��Ϣ��
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
		// ���õķ���
		final String methodName = "login";
		// ����HttpTransportSE�������
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// ʹ��SOAP1.1Э�鴴��Envelop����
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// ʵ����SoapObject����
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("username", username);
		soapObject.addProperty("password", password);

		envelope.bodyOut = soapObject;
		// ������.Net�ṩ��Web Service���ֽϺõļ�����
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// ����Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// ��ȡ��������Ӧ���ص�SOAP��Ϣ
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// ������������Ӧ��SOAP��Ϣ��
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
		// ���õķ���
		final String methodName = "returnx";
		// ����HttpTransportSE�������
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// ʹ��SOAP1.1Э�鴴��Envelop����
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// ʵ����SoapObject����
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
		// ���õķ���
		final String methodName = "returns";
		// ����HttpTransportSE�������
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// ʹ��SOAP1.1Э�鴴��Envelop����
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// ʵ����SoapObject����
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);

		envelope.bodyOut = soapObject;
		// ������.Net�ṩ��Web Service���ֽϺõļ�����
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// ����Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// ��ȡ��������Ӧ���ص�SOAP��Ϣ
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
		// ���õķ���
		final String methodName = "hqWrite";
		// ����HttpTransportSE�������
		final HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);

		ht.debug = true;
		// ʹ��SOAP1.1Э�鴴��Envelop����
		final SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		// ʵ����SoapObject����
		SoapObject soapObject = new SoapObject(SERVICE_NS, methodName);
		soapObject.addProperty("username", username);
		soapObject.addProperty("cjl", jrcj);
		soapObject.addProperty("zrcjl", zrcj);
		soapObject.addProperty("zrsr", zrdlsr);
		soapObject.addProperty("ip", ip);

		envelope.bodyOut = soapObject;
		// ������.Net�ṩ��Web Service���ֽϺõļ�����
		// envelope.dotNet = true;

		FutureTask<String> task = new FutureTask<String>(
				new Callable<String>() {
					@Override
					public String call() throws Exception {
						// ����Web Service
						ht.call(SERVICE_NS + methodName, envelope);
						if (envelope.getResponse() != null) {
							// ��ȡ��������Ӧ���ص�SOAP��Ϣ
							SoapObject result = (SoapObject) envelope.bodyIn;
							// SoapObject detail = (SoapObject) result
							// .getProperty(methodName + "Result");
							// ������������Ӧ��SOAP��Ϣ��
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
