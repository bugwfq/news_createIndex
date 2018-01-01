package cn.et.timer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.et.manager.NewsManager;
import cn.et.utils.FreeMarkerUtils;
import freemarker.template.TemplateException;

public class NewsTask extends TimerTask{
	private String newsLineNum;
	private String ftlPath;
	private String ftlName;
	private String newFilePath;
	public NewsTask(String newsLineNum,String ftlPath,String ftlName,String newFilePath){
		this.newsLineNum = newsLineNum;
		this.ftlPath = ftlPath;
		this.ftlName = ftlName;
		this.newFilePath = newFilePath;
	}
	private NewsManager manager = new NewsManager();
	
	@Override
	public void run() {
		List<Map<String , String>> data = manager.getNews(newsLineNum);
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("data", data);
		try {
			FreeMarkerUtils.writerFile(root, ftlPath, ftlName, newFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
