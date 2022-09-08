package tw.hibernatedemo.model;

import java.util.List;

public interface CompanyDaoInterface {

	public CompanyBean insert(CompanyBean comBean);

	public CompanyBean select(int id);

	public List<CompanyBean> selectAll();

	public CompanyBean updateOne(int comId, String comName);

	public boolean deleteOne(int comId);
}