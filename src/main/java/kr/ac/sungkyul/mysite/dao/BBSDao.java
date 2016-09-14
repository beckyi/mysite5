package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BBSVo;

@Repository
public class BBSDao {

	@Autowired
	private SqlSession sqlSession;

	public Long insertBoard(BBSVo bbsVo) {
	      System.out.println("before: " + bbsVo.toString());
	      sqlSession.insert("bbs.insertBoard", bbsVo);   // 파라미터 첫번째 값은 xml에 ID값, 두번째는 넘길 변수
	      System.out.println("after: " + bbsVo.toString());
	      Long no = bbsVo.getNo();
	      return no;
	   }


	public List<BBSVo> listBoard() {
		List<BBSVo> list = sqlSession.selectList("bbs.listBoard");
		return list;
	}
	
	public BBSVo readBoard(Long no) {
		BBSVo bbsoVo = sqlSession.selectOne("bbs.readBoard",no);
		return bbsoVo;
	}
	
	public void insertAttachFile(AttachFileVo attachFileVo){
		sqlSession.insert("bbs.insertAttahFile",attachFileVo);
	}
	
	public AttachFileVo selectAttachFileByNo(Long no) {
	      AttachFileVo attachFileVo = sqlSession.selectOne("bbs.selectAttachFileByNo", no);
	      return attachFileVo;
	   }
	   
   public AttachFileVo selectAttachFileByFNo(Long fno) {
      AttachFileVo attachFileVo = sqlSession.selectOne("bbs.selectAttachFileByFNo", fno);
      System.out.println(attachFileVo.toString());
      return attachFileVo;
   }

}
