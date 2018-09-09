package miaodiyun.httpApiDemo;

import miaodiyun.httpApiDemo.common.Config;
import miaodiyun.httpApiDemo.common.HttpUtil;

import java.net.URLEncoder;
import java.util.Random;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	public static String smsContent = "【下厨吧】您的验证码为"+Random()+"，如非本人操作，请忽略此短信。";
//	public static String randomNumber=Random();
	/**a
	 * 验证码通知短信
	 */

	public static String Random(){
		StringBuffer str = new StringBuffer();
		for (int i = 0 ; i<4 ;i++){
			str.append((int)(Math.random()*(10)));
		}
		return str.toString();
	}


	public static void execute(String to)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}
