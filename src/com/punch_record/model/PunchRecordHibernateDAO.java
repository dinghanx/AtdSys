package com.punch_record.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.department.model.DepartmentVO;
import com.employee.model.EmployeeVO;
import com.hibernate.util.HibernateUtil;

public class PunchRecordHibernateDAO implements PunchRecordDAO_interface {

	private static final String GET_ALL_STMT = "from PunchRecordVO order by pr_no";

	@Override
	public void insert(PunchRecordVO PRVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(PRVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(PunchRecordVO PRVO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(PRVO);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void delete(Integer pr_no) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();

			// 【此時多方(宜)可採用HQL刪除】
			// Query query = session.createQuery("delete employee where
			// empno=?");
			// query.setParameter(0, empno);
			// System.out.println("刪除的筆數=" + query.executeUpdate());

			// 【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			PunchRecordVO PRVO = new PunchRecordVO();
			PRVO.setPr_no(pr_no);
			session.delete(PRVO);

			// 【此時多方不可(不宜)採用cascade聯級刪除】
			// 【多方emp2.hbm.xml如果設為 cascade="all"或
			// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
			// PunchRecordVO PRVO = (PunchRecordVO) session.get(PunchRecordVO.class,
			// empno);
			// session.delete(PRVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public PunchRecordVO findByPrimaryKey(Integer empno) {
		PunchRecordVO PRVO = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			PRVO = (PunchRecordVO) session.get(PunchRecordVO.class, empno);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return PRVO;
	}

	@Override
	public List<PunchRecordVO> getAll() {
		List<PunchRecordVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	@Override
	public List<PunchRecordVO> getAll(Map<String, String[]> map) {
		List<PunchRecordVO> list = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_ALL_STMT);
			list = query.list();
			session.getTransaction().commit();
			
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}

	public static void main(String[] args) {

		PunchRecordHibernateDAO dao = new PunchRecordHibernateDAO();

		// ● 新增
		EmployeeVO empVO = new EmployeeVO(); // 部門POJO
		empVO.setEmp_no(2);

//		 PunchRecordVO PRVO2 = new PunchRecordVO();
//		 PRVO2.setType_no(1);
//		 PRVO2.setPr_time(java.sql.Date.valueOf("2001-01-15"));
//		 PRVO2.setRemarks("ya");
//		 PRVO2.setEmpVO(empVO);
//		 dao.insert(PRVO2);

		// ● 修改
//		 PunchRecordVO PRVO2 = new PunchRecordVO();
//		 PRVO2.setPr_no(1);
//		 PRVO2.setType_no(2);
//		 PRVO2.setPr_time(java.sql.Date.valueOf("2001-01-15"));
//		 PRVO2.setRemarks("ya");
//		 PRVO2.setEmpVO(empVO);
//		 dao.insert(PRVO2);

		// ● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
//		 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		 dao.delete(1);

		// ● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		 PunchRecordVO aEmp = dao.findByPrimaryKey(3);
//			System.out.print(aEmp.getPr_no() + ",");
//			System.out.print(aEmp.getType_no() + ",");
//			System.out.print(aEmp.getPr_time() + ",");
//			System.out.print(aEmp.getRemarks() + ",");
//			System.out.print(aEmp.getEmpVO().getName() + ",");
//			System.out.println();
//		 System.out.println("\n---------------------");

		// ● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		List<PunchRecordVO> list2 = dao.getAll();
		for (PunchRecordVO PRVO : list2) {
			System.out.print(PRVO.getPr_no() + ",");
			System.out.print(PRVO.getATVO().getAt_no() + ",");
			System.out.print(PRVO.getPr_time() + ",");
			System.out.print(PRVO.getRemarks() + ",");
			System.out.println("\n-----------------");
			EmployeeVO emp = PRVO.getEmpVO();
				System.out.print(emp.getEmp_no() + ",");
				System.out.print(emp.getName() + ",");
				System.out.print(emp.getTitle() + ",");
				System.out.print(emp.getFir_day() + ",");
				System.out.print(emp.getLas_day() + ",");
				System.out.print(emp.getBirthday() + ",");
				System.out.print(emp.getPhoto() + ",");
				System.out.print(emp.getEmail() + ",");
				System.out.print(emp.getPsw() + ",");
				System.out.print(emp.getIs_mgr() + ",");
				System.out.print(emp.getRemarks() + ",");
				System.out.print(emp.getDepVO().getDep_no() + ",");
				System.out.print(emp.getDepVO().getName() + ",");
				System.out.print(emp.getDepVO().getRemarks());
				System.out.println();
		}
	}
}
