package com.zyw.microservice.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zyw.microservice.a.service.CronJobService;

/**
 * @description 定时任务的Controler
 * @author ZhangYuWei
 * @create 2019-05-21
 */
@Component
public class CronJobController {
	@Autowired
	private CronJobService cronJobService;

//	Cron表达式写法：
//	（1）Seconds Minutes Hours DayofMonth Month DayofWeek Year
//	（2）Seconds Minutes Hours DayofMonth Month DayofWeek
//
//	Cron表达式含义：
//	Cron表达式是一个字符串，字符串以5或6个空格隔开，分为6或7个域，每一个域代表一个含义
//	第一位，表示秒，取值0-59
//	第二位，表示分，取值0-59
//	第三位，表示小时，取值0-23
//	第四位，日期天/日，取值1-31
//	第五位，日期月份，取值1-12
//	第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思
//	另外：7表示星期天，1表示星期一。
//	第7为，年份，可以留空，取值1970-2099
//
//	(*)星号：可以理解为每的意思，每秒，每分，每天，每月，每年...
//	(?)问号：问号只能出现在日期和星期这两个位置，表示这个位置的值不确定，每天3点执行，所以第六位星期的位置，我们是不需要关注的，就是不确定的值。同时：日期和星期是两个相互排斥的元素，通过问号来表明不指定值。比如，1月10日，比如是星期1，如果在星期的位置是另指定星期二，就前后冲突矛盾了。
//	(-)减号：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12
//	(,)逗号：表达一个列表值，如在星期字段中使用“1,2,4”，则表示星期一，星期二，星期四
//	(/)斜杠：如：x/y，x是开始值，y是步长，比如在第一位（秒） 0/15就是，从0秒开始，每15秒，最后就是0，15，30，45，60 另：*/y，等同于0/y
//
//	常用表达式举例：
//	0 5 3 * * ? 每天3点5分执行
//	0 5 3 ? * * 每天3点5分执行，与上面作用相同
//	0 5/10 3 * * ? 每天3点的 5分，15分，25分，35分，45分，55分这几个时间点执行
//	0 10 3 ? * 1 每周星期天，3点10分 执行，注：1表示星期天 
//	0 10 3 ? * 1#3 每个月的第三个星期，星期天 执行，#号只能出现在星期的位置
//	0 0 2 1 * ? *   表示在每月的1日的凌晨2点调整任务
//	0 15 10 ? * MON-FRI   表示周一到周五每天上午10:15执行作业
//	0 15 10 ? 6L 2002-2006   表示2002-2006年的每个月的最后一个星期五上午10:15执行作
//	0 0 10,14,16 * * ?   每天上午10点，下午2点，4点 
//	0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时 
//	0 0 12 ? * WED    表示每个星期三中午12点 
//	0 15 10 * * ? 2005    2005年的每天上午10:15触发 
//	0 * 14 * * ?     在每天下午2点到下午2:59期间的每1分钟触发 
//	0 0/5 14 * * ?    在每天下午2点到下午2:55期间的每5分钟触发 
//	0 0/5 14,18 * * ?     在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发 
//	0 0-5 14 * * ?    在每天下午2点到下午2:05期间的每1分钟触发 
//	0 10,44 14 ? 3 WED    每年三月的星期三的下午2:10和2:44触发 
//	0 15 10 ? * MON-FRI    周一至周五的上午10:15触发 
//	0 15 10 15 * ?    每月15日上午10:15触发 
//	0 15 10 L * ?    每月最后一日的上午10:15触发 
//	0 15 10 ? * 6L    每月的最后一个星期五上午10:15触发 
//	0 15 10 ? * 6L 2002-2005   2002年至2005年的每月的最后一个星期五上午10:15触发 
//	0 15 10 ? * 6#3   每月的第三个星期五上午10:15触发
	
	@Scheduled(cron = "0 0 20 * * ?")
	public void automaticScheduler() {
		cronJobService.automaticScheduler();
	}

}
