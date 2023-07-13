package com.exam.myapp.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.myapp.member.MemberVo;

//@Controller
@RestController // 현재 클래스의 모든 요청처리 메서드에 @ResponseBody
public class ReplyController {

		@Autowired
		private ReplyService replyService;
		
		@GetMapping("/reply/list.do")
		//@ResponseBody
		public List<ReplyVo> list(int repBbsNo) {
			List<ReplyVo> repList = replyService.selectReplyList(repBbsNo);
			return repList;
		}
		
		@PostMapping("/reply/add.do") 
		//@ResponseBody //메서드의 반환값을 응답메세지 내용으로 전송 리턴값 포워드 시키는게 아니라 그대로 보냄
		public Map<String, Object> add(ReplyVo vo, @SessionAttribute("loginUser") MemberVo mvo //지정한 세션속성값을 이 변수에 주입 (전달)
				) {
			
		vo.setRepWriter(mvo.getMemId());
			int num = replyService.insertReply(vo);
			
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ok", true);
			map.put("result", num);
			
			return map;
			
			
			//자바스크립트 "" , '' 가능
			//var v = {memId: "코드999", memName: "철수", memPoint: 27};
			
			//JSON 자바스크립트 객체 표현과 동일하지만 2가지 차이점 존재
			//(1)문자열은 반드시 큰따옴표만 가능(작은따옴표 사용불가)
			//(2)객체 속성이름은 반드시 문자열로 표현
			
			
			//return "{\"ok\" : true, \"result\" : " + num + "}";
			//return num+"reply add"; 
			//return "redirect:/bbs/edit.do?bbsNo="+vo.getRepBbsNo();				 	
		}
		
		@GetMapping("/reply/del.do") 
		//@ResponseBody 
		public Map<String, Object> del(ReplyVo vo, @SessionAttribute("loginUser") MemberVo mvo 
				) {
			
		vo.setRepWriter(mvo.getMemId());
			int num = replyService.deleteReply(vo);
			
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("ok", true);
			map.put("result", num);
			
			return map;
		}	
	}


