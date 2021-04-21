package gdu.diary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBDriverListener implements ServletContextListener {

	//생성자
    public DBDriverListener() {
    }

    //톰캣 종료시
    public void contextDestroyed(ServletContextEvent sce)  { 
    }

    //톰캣 부팅시
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("__________@WebListener DBDriverListener");
    	System.out.println("//톰캣 부팅시");
    	
    	try {
    		Class.forName("org.mariadb.jdbc.Driver");
    		System.out.println("__________"+this.getClass() + "DB로딩 성공");
    	}catch (ClassNotFoundException e){
    		System.out.println("DB로딩실패");
    		e.printStackTrace();
    	}
    		
    }
	
}
