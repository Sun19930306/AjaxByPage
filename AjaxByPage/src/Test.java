import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qf.utils.C3P0Utils;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="insert into shop (name,price,category) values (?,?,?)";
		Object[][] params =new Object[500][];
		for (int i = 0; i < params.length; i++) {
			params[i]=new Object[] {"name22=="+i,100*i+100,"category22=="+i};
		}
		try {
			int[]  rowCounts = queryRunner.batch(sql, params);
			if (rowCounts.length>0) {
				System.out.println("成功");
			}else {
				System.out.println("失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
