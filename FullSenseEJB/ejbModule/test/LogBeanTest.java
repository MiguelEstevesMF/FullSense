package test;

import java.util.Date;
import java.util.List;

import core.entityBeans.Log;
import core.entityBeans.SystemLog;
import core.entityBeans.SystemLogUser;
import core.sessionBeans.LogBean;

import core.sessionBeans.interfaces.LogBeanRemote;

public class LogBeanTest {
	
	public static void main(String[] args) throws Exception {
		LogBeanRemote lbr=(LogBeanRemote)MyInjector.getEJBr(LogBean.class);
		CrudBeanRemote cb = (CrudBeanRemote)MyInjector.getEJBr(CrudBean.class);
//		SystemLog l=new SystemLog();
		Log l = new Log();
		l.setDesc("teste");
		//l.setId(10);
		l.setTime(new Date());
		//cb.save(l);
		System.out.println("ola");
		
		int ano=110;
		int mes=2;
		int dia=30;
		
		
		System.out.println(lbr.countLog(Log.class, false, new Date(ano,0,dia),new Date(ano,mes,dia)));
//		List <Log> ll= lbr.listLog(Log.class, false, new Date(ano,0,dia), new Date(ano,mes,dia), 0, 3);
//		
//		for(int i=0;i<3;i++)
//		{
//			System.out.println(ll.get(i).getDesc());
//		}
		
//		System.out.println(lbr.countUserLogs(Log.class, false,"user1", new Date(ano,0,dia),new Date(ano,mes,dia)));
		
//		List <Log> ll= lbr.listUserLogs(Log.class, false,"user1", new Date(ano,0,dia), new Date(ano,mes,dia), 0, 3);
//		
//		for(int i=0;i<ll.size();i++)
//		{
//			System.out.println(ll.get(i).getDesc());
//		}
		
		//SystemLogUser sl = new SystemLogUser();
		
		//System.out.println(lbr.countResourceLogs(Log.class, false, "FP", new Date(ano,0,dia), new Date(ano,mes,dia)));
		
//		List <Log> rl= lbr.listResourceLogs(Log.class, false,"FP", new Date(ano,0,dia), new Date(ano,mes,dia), 0, 3);
//		
//		for(int i=0;i<rl.size();i++)
//		{
//			System.out.println(rl.get(i).getDesc());
//		}
		
	}

}
