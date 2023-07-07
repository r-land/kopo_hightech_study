package com.exam.myapp.bbs;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.exam.myapp.member.MemberService;
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
	//컨트롤러 메서드가 인자로 HttpServletResponse, OutputStream, Writer를 ;받고,
	//반환타입이 void이면,
	//직접 응답을 처리(전송)했다고 판단하여 스프링은 뷰에 대한 처리를 하지 않는다.
	@GetMapping("down.do")
	public void download(int attNo, HttpServletResponse resp) {
		AttachVo vo= bbsService.selectAttach(attNo);//DB에서 다운로드할 첨부파일 정보 조회

		File f = bbsService.getAttachFile(vo); //디스크 상에서 첨부파일 가져오기
		
		resp.setContentLength((int) f.length()); //응답메세지 본문(파일)의 크기 설정
		/* resp.setContentLengthLong(f.length()); */
		
		resp.setContentType("application/octet-stream"); //무조건 다운로드 팝업창
		//resp.setContentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE);
		
		
		//다운로드 파일 저장할 떄 사용할 디폴트 파일명 설정
		//지원하는 브라우저에 따라서 다른 처리가 필요할 수도 있다
		/*
		 * try { String fname = URLEncoder.encode(vo.getAttOrgName(),
		 * "UTF-8").replace("+", "%20"); //replace() 공백처리
		 * resp.setHeader("Content-Disposition",
		 * "attachment; filename*=UTF-8''"+fname);//파일명 디폴트값으로 저장하는 헤더 한글은 인코딩 후 써야한다
		 * 
		 * } catch (UnsupportedEncodingException e1) { e1.printStackTrace(); }
		 * //주소이름(vo.attorgName)으로 인코딩 후 fname으로 사용
		 */	
		
		String cdv = ContentDisposition.attachment().filename(vo.getAttOrgName(), StandardCharsets.UTF_8).build().toString(); 
		//인자를 charset으로 받아서 자주쓰는 것 charset으로 만들어주는 
		//StandardCharsets 쓰고 문자로 반환해서 변수로 만들어서 아래서 사용  스프링 5.0 이후 부터 사용 가능한 방법 예외처리 필요 없다 
		resp.setHeader(HttpHeaders.CONTENT_DISPOSITION, cdv);//파일명 디폴트값으로 저장하는 헤더 한글은 인코딩 후 써야한다
		
		try {
			//파일 f의 내용을 응답 객체(의 출력 스트림)에 복사(전송)
			FileCopyUtils.copy(new FileInputStream(f), resp.getOutputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


	

