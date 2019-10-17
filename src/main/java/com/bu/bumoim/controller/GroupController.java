package com.bu.bumoim.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bu.bumoim.domain.GroupList;
import com.bu.bumoim.domain.Member;
import com.bu.bumoim.service.GroupService;

@Controller
public class GroupController {

	
	private Logger logger = Logger.getLogger(getClass());
	@Autowired
	private GroupService groupservice;
	
	@RequestMapping(value="/GroupList.do")
	public ModelAndView grouplist(GroupList grouplist) {
		
		List<GroupList> list = groupservice.selectGroupList(grouplist);
		ModelAndView mav = new ModelAndView("group/grouplist");
		mav.addObject("GroupList", list);
		logger.info(grouplist);
		return mav;
	}
	
	@RequestMapping(value="/GroupCreate.do", method=RequestMethod.GET)
	public String group_groupcreate() {
		return "group/groupcreate";
	}
	
	@RequestMapping(value="/GroupCreate.do", method=RequestMethod.POST)
	public String groupcreate(GroupList grouplist, Model model) {
		int insertResult = groupservice.insertGroup(grouplist);
		if (insertResult == 1) {
			logger.info("그룹생성~~~~!");
		}else {
			logger.info("실패했지롱~~~~~!!!!!!!!!!!!!!!!!!!!!!1");
		}
		return "redirect:GroupList.do";
	}
	//그룹 중복체크
	@ResponseBody
	@RequestMapping(value="/groupDuplicationCheck.do", method=RequestMethod.POST)
	public int idDuplicationCheck(HttpServletRequest request, Model model) {
		//
		String grouplist_name = request.getParameter("grouplist_name");
		GroupList grouplist = groupservice.groupDuplicationCheck(grouplist_name);
		
		if(grouplist != null) {
			logger.info("그룹이름 중복 사용불가");
			return 0;
		} else {
			logger.info("그룹이름 사용가능");
			return 1;
		}
	}

}
