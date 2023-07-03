package com.exam.myapp.bbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.myapp.member.MemberVo;

@Controller
@RequestMapping("/bbs/") //현재 컨트롤러 클래스 내부 모든 메서드 공통 경로
public class BbsController {
	@Autowired
	private BbsService bbsService;
	
	@RequestMapping(value = "list.do",method = RequestMethod.GET)
	public String list(Model model){
		List<BbsVo> list = bbsService.selectBbsList();
		model.addAttribute("bbsList", list);
		return "bbs/bbsList";
	}
	
	@GetMapping("add.do")
	public String addform() {
		return "bbs/bbsAdd";
	}
	
	@RequestMapping(value = "add.do",method = RequestMethod.POST)
	public String add(BbsVo vo, @SessionAttribute("loginUser") MemberVo mvo //지정한 세션속성값을 이 변수에 주입 (전달)
			) {
		//HttpSession session 변수생성 후  MemberVo mvo = (MemberVo) session.getAttribute("loginUser"); 로 할수도 있음  스프링 4.3 이상부터  @SessionAttribute 지원 
		vo.setBbsWriter(mvo.getMemId()); //	로그인한 사용자아이디를 게시글 작성자로 설정
		int n = bbsService.insertBbs(vo);
		System.out.println(n + "개의 글 추가 성공");
		return "redirect:/bbs/list.do";				 	
	}
	
	@RequestMapping(value = "edit.do",method = RequestMethod.GET)
	public String editform(int bbsNo, Model model) {
		BbsVo vo =bbsService.selectBbs(bbsNo);
		model.addAttribute("bbsMvo", vo);
		return "bbs/bbsEdit";		
	}
	
	@RequestMapping(value = "edit.do",method = RequestMethod.POST)
	public String edit(BbsVo vo) {			
		int n = bbsService.updateBbs(vo);
		System.out.println(n + "개의 게시글 변경 성공");
		return "redirect:/bbs/list.do";
	}

	@RequestMapping(value = "del.do",method = RequestMethod.GET)
		public String service(int bbsNo) {
		int n = bbsService.deleteBbs(bbsNo);
		System.out.println(n + "개의 게시글 삭제 성공");
		return "redirect:/bbs/list.do";
	}
	//컨트롤러 메서드가 인자로 HttpServletResponse, OutputStream, Writer를 받고,
	//반환타입이 void이면,
	//직접 응답을 처리(전송)했다고 판단하여 스프링은 뷰에 대한 처리를 하지 않는다.
	@GetMapping("down.do")
	public void download(int attNo, HttpServletResponse resp) {
		AttachVo vo= bbsService.selectAttach(attNo);

		File f = bbsService.getAttachFile(vo);
		
		try {
			//파일 f의 내용을 응답 객체(의 출력 스트림)에 복사(전송)
			FileCopyUtils.copy(new FileInputStream(f), resp.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


	

