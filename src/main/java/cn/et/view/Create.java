package cn.et.view;

import java.util.Date;
import java.util.Timer;

import cn.et.timer.NewsTask;

public class Create {
	public static void main(String[] args) {
		//���ɵ�ҳ����ʾ���ݿ��������
		String newsLineNum = "5";
		//ģ���ŵĸ�Ŀ¼
		String ftlPath = "src/main/resources/templates";
		//ģ�������
		String ftlName = "index.ftl";
		String newFilePath = "src/main/webapp/index.html";
		NewsTask task = new NewsTask(newsLineNum, ftlPath, ftlName, newFilePath);
		
		Timer timer = new Timer();
		Date date = new Date();
		timer.scheduleAtFixedRate(task, date, 10000);
	}

}
