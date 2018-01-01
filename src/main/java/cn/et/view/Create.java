package cn.et.view;

import java.util.Date;
import java.util.Timer;

import cn.et.timer.NewsTask;

public class Create {
	public static void main(String[] args) {
		//生成的页面显示数据库后几条数据
		String newsLineNum = "5";
		//模板存放的根目录
		String ftlPath = "src/main/resources/templates";
		//模板的名称
		String ftlName = "index.ftl";
		String newFilePath = "src/main/webapp/index.html";
		NewsTask task = new NewsTask(newsLineNum, ftlPath, ftlName, newFilePath);
		
		Timer timer = new Timer();
		Date date = new Date();
		timer.scheduleAtFixedRate(task, date, 10000);
	}

}
