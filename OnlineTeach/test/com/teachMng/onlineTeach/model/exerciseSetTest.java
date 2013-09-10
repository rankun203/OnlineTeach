package com.teachMng.onlineTeach.model;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.teachMng.onlineTeach.model.exercise.CompletionExercise;
import com.teachMng.onlineTeach.model.exercise.ExerciseSet;
import com.teachMng.onlineTeach.model.exercise.JudgeExercise;
import com.teachMng.onlineTeach.model.exercise.QuestionExercise;
import com.teachMng.onlineTeach.model.exercise.SelectionExercise;

public class exerciseSetTest {

	ServiceRegistry serviceRegistry;
	SessionFactory sf;

	public void before(){
		Configuration configuration = new Configuration();
		configuration = configuration.configure("lonely.hibernate.cfg.xml");
		ServiceRegistryBuilder srb = new ServiceRegistryBuilder();
		srb = srb.applySettings(configuration.getProperties());
		serviceRegistry = srb.buildServiceRegistry();
		sf = configuration.buildSessionFactory(serviceRegistry);
	}
	public void exerciseTest(){
		Teacher t1 = new Teacher("老师1");

		JudgeExercise j1 = new JudgeExercise();
		j1.setFullTopic("海绵宝宝是泥巴做的？");
		j1.setStdScore(2);
		JudgeExercise j2 = new JudgeExercise();
		j2.setFullTopic("派大星是男的？");
		j2.setStdScore(2);
		JudgeExercise j3 = new JudgeExercise();
		j3.setFullTopic("你有1块钱吗？");
		j3.setStdScore(2);
		JudgeExercise j4 = new JudgeExercise();
		j4.setFullTopic("你是未成年？");
		j4.setStdScore(2);
		

		CompletionExercise c1 = new CompletionExercise();
		c1.setFullTopic("你是我的" + CompletionExercise.spaceHolder + "，你是我的" 
						+ CompletionExercise.spaceHolder + "，你是我的" + CompletionExercise.spaceHolder
						+ "，是我的" + CompletionExercise.spaceHolder);
		c1.setStdScore(5);
		c1.setStdAnswer("\"玫瑰\",\"花\",\"爱人\",\"牵挂\"");
		CompletionExercise c2 = new CompletionExercise();
		c2.setFullTopic("我是一只" + CompletionExercise.spaceHolder + "，想要" 
				+ CompletionExercise.spaceHolder + "呀" + CompletionExercise.spaceHolder + "，却飞也飞不高～～");
		c2.setStdScore(5);
		c2.setStdAnswer("\"小小小小鸟\",\"飞\",\"飞\"");
		CompletionExercise c3 = new CompletionExercise();
		c3.setFullTopic("羞答答的玫瑰静"+CompletionExercise.spaceHolder+"开，慢慢地绽放她留给我的"
				+CompletionExercise.spaceHolder+"，春天的手吖翻阅他的"+CompletionExercise.spaceHolder
				+"，我在暗暗思量该不该将它"+CompletionExercise.spaceHolder+"摘。");
		c3.setStdScore(5);
		c3.setStdAnswer("\"悄悄地\",\"情怀\",\"等待\",\"轻轻地\"");
		CompletionExercise c4 = new CompletionExercise();
		c4.setFullTopic("如果没有"+CompletionExercise.spaceHolder+"，我将会是"+CompletionExercise.spaceHolder
				+"，日子过的"+CompletionExercise.spaceHolder+"，人生是否"+CompletionExercise.spaceHolder+"");
		c4.setStdScore(5);
		c4.setStdAnswer("\"遇见你\",\"在那里\",\"怎么样\",\"要珍惜\"");

		
		QuestionExercise q1 = new QuestionExercise(); 
		q1.setFullTopic("请，默写 林俊杰-《不潮不用花钱》");
		q1.setStdScore(10);
		q1.setStdKeyword("Hey greedy,don’t fret"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		"You name it,I have it"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"左左 左左 偏左 就用左手"+QuestionExercise.brHolder+
		"生活 就不用 想太多"+QuestionExercise.brHolder+
		"怦怦 怦怦 心动 张开眼睛"+QuestionExercise.brHolder+
		"就记得当下的 强烈"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"有时灵光一闪而过"+QuestionExercise.brHolder+
		"牛顿也吃苹果"+QuestionExercise.brHolder+
		"我的念头不太罗嗦"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"限时间能入座"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"请你 不要到处叩叩"+QuestionExercise.brHolder+
		"潮流需要抠抠 不小心就没抠抠"+QuestionExercise.brHolder+
		"用力到处扣扣 花掉所有抠抠"+QuestionExercise.brHolder+
		"钱买不到绝活"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"你说 听说 听说 你听谁说"+QuestionExercise.brHolder+
		"跟着 乱走 闹哄哄"+QuestionExercise.brHolder+
		"通通 通通 普通 普通"+QuestionExercise.brHolder+
		"如果不懂 不要 随便 拒绝"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"有时灵光一闪而过"+QuestionExercise.brHolder+
		"牛顿也吃苹果"+QuestionExercise.brHolder+
		"我的念头不太罗嗦"+QuestionExercise.brHolder+
		"限时间能入座"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"请你 不要到处叩叩"+QuestionExercise.brHolder+
		"潮流需要抠抠 不小心就没抠抠"+QuestionExercise.brHolder+
		"用力到处扣扣 花掉所有抠抠"+QuestionExercise.brHolder+
		"钱买不到绝活"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"Little chick having chips on my sofa"+QuestionExercise.brHolder+
		"Bearbricxs take a shit on my sofa"+QuestionExercise.brHolder+
		"Smudge babies lying on my sofa"+QuestionExercise.brHolder+
		"Neighborhxxds and kiks singing “so-fa”"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"Little chick having chips on my sofa"+QuestionExercise.brHolder+
		"Bearbricxs take a shit on my sofa"+QuestionExercise.brHolder+
		"Smudge babies lying on my sofa"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"Hey greedy,don’t fret"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		"You name it,I have it"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"请你 不要到处叩叩"+QuestionExercise.brHolder+
		"潮流需要抠抠 不小心就没抠抠"+QuestionExercise.brHolder+
		"用力到处扣扣 花掉所有抠抠"+QuestionExercise.brHolder+
		"钱买不到绝活"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"Hey greedy,don’t fret(叩叩)"+QuestionExercise.brHolder+
		"What you see is what you get(叩叩)"+QuestionExercise.brHolder+
		"You name it,I have it(不要到处叩叩)"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"Hey greedy,don’t fret(不要到处叩叩)"+QuestionExercise.brHolder+
		"What you see is what you get(叩叩)"+QuestionExercise.brHolder+
		"You name it,I have it(叩叩)"+QuestionExercise.brHolder+
		"What you see is what you get"+QuestionExercise.brHolder+
		""+QuestionExercise.brHolder+
		"叩叩... 叩叩 ...");
		QuestionExercise q2 = new QuestionExercise(); 
		q2.setFullTopic("《天上掉下个猪八戒》 是一本书吗？");
		q2.setStdScore(10);
		q2.setStdKeyword("不");
		
		SelectionExercise se1 = new SelectionExercise(); 
		se1.setFullTopic("请选择最酷毙的职业：" + SelectionExercise.hrHolder +
				"A.理发师" + SelectionExercise.brHolder +
				"B.园丁" + SelectionExercise.brHolder +
				"C.码农" + SelectionExercise.brHolder +
				"D.糕帅富");
		se1.setStdAnswer('D');
		se1.setStdScore(5);
		SelectionExercise se2 = new SelectionExercise(); 
		se2.setFullTopic("请选择最苦逼的职业：" + SelectionExercise.hrHolder +
				"A.理发师" + SelectionExercise.brHolder +
				"B.园丁" + SelectionExercise.brHolder +
				"C.程序员" + SelectionExercise.brHolder +
				"D.糕帅富");
		se2.setStdAnswer('C');
		se2.setStdScore(5);
		SelectionExercise se3 = new SelectionExercise(); 
		se3.setFullTopic("请选择最高尚的职业：" + SelectionExercise.hrHolder +
				"A.理发师" + SelectionExercise.brHolder +
				"B.园丁" + SelectionExercise.brHolder +
				"C.码农" + SelectionExercise.brHolder +
				"D.糕帅富");
		se3.setStdAnswer('B');
		se3.setStdScore(5);
		SelectionExercise se4 = new SelectionExercise(); 
		se4.setFullTopic("请选择最有型的职业：" + SelectionExercise.hrHolder +
				"A.理发师" + SelectionExercise.brHolder +
				"B.园丁" + SelectionExercise.brHolder +
				"C.码农" + SelectionExercise.brHolder +
				"D.糕帅富");
		se4.setStdAnswer('A');
		se4.setStdScore(5);
		
		
		ExerciseSet es1 = new ExerciseSet();
		es1.setFounder(t1);
		List<QuestionExercise> qeList = new LinkedList<QuestionExercise>();
		qeList.add(q1);
		qeList.add(q2);
		// TODO 由于我修改model映射，这里会报错，所以先注释掉
//		es1.setQuestionExercise(qeList);
		List<SelectionExercise> seList = new LinkedList<SelectionExercise>();
		seList.add(se1);
		seList.add(se2);
		seList.add(se3);
		seList.add(se4);
//		es1.setSelectionExercise(seList);
		List<CompletionExercise> ceList = new LinkedList<CompletionExercise>();
		ceList.add(c1);
		ceList.add(c2);
		ceList.add(c3);
		ceList.add(c4);
//		es1.setCompletionExercise(ceList);
		List<JudgeExercise> jeList = new LinkedList<JudgeExercise>();
		jeList.add(j1);
		jeList.add(j2);
		jeList.add(j3);
		jeList.add(j4);
//		es1.setJudgeExercise(jeList);

		
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(t1);
		session.save(q1);
		session.save(q2);
		session.save(se1);
		session.save(se2);
		session.save(se3);
		session.save(se4);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		session.save(j1);
		session.save(j2);
		session.save(j3);
		session.save(j4);

		es1.setCreateDate(new Date());
		session.save(es1);
		
		session.getTransaction().commit();
		sf.getCurrentSession().close();
	}
	
	public void replyTest(){
		Student s1 = new Student("学生1");

		Session session = sf.openSession();
		session.beginTransaction();
		ExerciseSet es1 = (ExerciseSet) session.load(ExerciseSet.class, 1);
		es1.setStudent(s1);
		session.save(s1);
		session.saveOrUpdate(es1);
		session.getTransaction().commit();
		sf.getCurrentSession().close();
	}

	public void setUp(){
System.out.println("生成数据库结构");
		new SchemaExport(new Configuration().configure("lonely.hibernate.cfg.xml")).create(true, true);
System.out.println("数据库结构生成结束");
	}
	public void after(){
	}
}
