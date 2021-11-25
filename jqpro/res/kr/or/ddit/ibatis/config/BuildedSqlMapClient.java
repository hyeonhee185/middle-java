package kr.or.ddit.ibatis.config;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapClient {
	
	private static SqlMapClient smc;
	
	static{
	
		Reader rd = null;
		try {
			Charset charset = Charset.forName("utf-8");
			Resources.setCharset(charset);
			
			//환경설정파일 읽어오기
			rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/SqlMapConfig.xml");
			
			//Builder를 통해 sqlMapConfig.xml과 mapper file을 조합
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			throw new RuntimeException("SqlMapClient객체 생성 실패" + e,e);
		}finally{
			if(rd != null) try{ rd.close();} catch (IOException e){}
		}
		
	}
	
	public static SqlMapClient getSqlMapClient(){
		return smc;
	}
}
