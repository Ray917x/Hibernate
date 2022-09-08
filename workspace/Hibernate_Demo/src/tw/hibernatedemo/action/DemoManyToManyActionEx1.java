
package tw.hibernatedemo.action;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Friend;
import tw.hibernatedemo.model.Instructor;
import tw.hibernatedemo.model.MyGroup;
import tw.hibernatedemo.util.HibernateUtil;

public class DemoManyToManyActionEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		// Friend & MyGroup
		// Work 群組 ID 是 3，需把 Mary 從 Work 群組刪除，加 Bill 到 Work 群組
		
		try {
			session.beginTransaction();
			
			// 找到 work 群組的物件
			MyGroup workGroup = session.get(MyGroup.class, 3);

			Set<Friend> friends = workGroup.getFriends(); //抓出work裡面的資料
			// 找出 Tina，用 Iterator 把 Tina 從 Set 內移除
			Iterator<Friend> it = friends.iterator(); //如同for each,如果要表單裡的所有資料可用interator
						
			while(it.hasNext()) {
				Friend friend = it.next();
				String name = friend.getFriendName();
				
				if(name.equals("Tina")) {
					it.remove();
				}
			}
			
			// 把 Bill 加進 work 群組
			Friend bill = new Friend();
			bill.setFriendName("Bill");
			session.save(bill);
			
			friends.add(bill);
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			
		}finally {
			HibernateUtil.closeSessionFactory();
		}

	}

}