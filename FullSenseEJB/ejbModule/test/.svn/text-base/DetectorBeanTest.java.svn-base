package test;

import java.util.List;

import core.entityBeans.Area;
import core.entityBeans.Circle;
import core.entityBeans.Detector;
import core.entityBeans.Identifier;
import core.entityBeans.Protocol;
import core.sessionBeans.DetectorBean;
import core.sessionBeans.interfaces.DetectorBeanRemote;


public class DetectorBeanTest {
	public static void main(String[] args) throws Exception {
	DetectorBeanRemote lbr=(DetectorBeanRemote)MyInjector.getEJBr(DetectorBean.class);
	CrudBeanRemote cb = (CrudBeanRemote)MyInjector.getEJBr(CrudBean.class);
	Detector d = new Detector();
	Circle c=new Circle();
	c.setcX(0);
	c.setcY(0);
	c.setFloor(2);
	d.setArea(c);
	d.setId("det3");
	cb.save(d);
	
	Protocol p =new Protocol();
	p.setName("protocol5");
//	cb.save(p);
	
//	System.out.println(lbr.readProtocol("protocol1").getName());
//	System.out.println(lbr.create(p));
//	System.out.println(lbr.countProtocols());
//	System.out.println(lbr.drop(p));
	
//	List <Protocol> l= lbr.listProtocols(0, 2);
//	for(int i=0;i<l.size();i++)
//	{
//		System.out.println(l.get(i).getName());
//	}
	
//	System.out.println(lbr.countDetectors());
	
	Identifier id = new Identifier();
	id.setId("id2");
	id.setProtocol(p);
//	cb.save(id);
	
//	System.out.println(lbr.countIdentifiers());
//	Identifier id1=lbr.readIdentifier("id1");
//	System.out.println(id1.getId());

//	Detector det1=lbr.readDetector("det1");
//	System.out.println(det1.getId());
	
//	System.out.println(lbr.create(id));
	
	Detector det2= new Detector();
	det2.setArea(c);
	det2.setId("detector1");
//	System.out.println(lbr.create(det2));
	
//	System.out.println(lbr.drop(id));
//	System.out.println(lbr.drop(det2));
//	System.out.println(lbr.countDetectors());
	
//	List <Detector> ld = lbr.listDetectors(0, 2);
//	for(int i=0;i<ld.size();i++)
//	{
//		System.out.println(ld.get(i).getId());
//		
//	}
	
//	List <Identifier> ld = lbr.listIdentifiers(0, 2);
//	for(int i=0;i<ld.size();i++)
//	{
//		System.out.println(ld.get(i).getId());
//		
//	}
	
//	Identifier id5=lbr.readIdentifier("id1");
//	System.out.println(id5.getId());
//	id5.setProtocol(p);
//	lbr.update(id5);
	
//	Detector det9=lbr.readDetector("detector2");
//	System.out.println(det9.getId());
//	det9.setArea(c);
//	lbr.update(det9);
	
	}

}
