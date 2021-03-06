package dorm.system.controller;

import dorm.system.dto.RewardsDto;
import dorm.system.dto.StaffDto;
import dorm.system.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RewardsController {
    @Autowired
    private RewardsService rewardsService;

    @PostMapping("/staff/addRewards")
    @ResponseBody
    public Map<String,Object> addRewards(RewardsDto rewardsDto) {
//        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        Map<String,Object> resultMap = new HashMap<String, Object>();
        String addRewardsResult = rewardsService.addRewards(rewardsDto);
        resultMap.put("addRewardsResult", addRewardsResult);
        return resultMap;
    }

    @GetMapping("/selectRewards/{roomNo}")
    public ModelAndView selectRewards(@PathVariable("roomNo") int roomNo, HttpSession httpSession) {
        StaffDto staffDto = (StaffDto) httpSession.getAttribute("staff");
        String staffId = staffDto.getId();
        List<RewardsDto> rewardsDtoList = rewardsService.selectRewards(roomNo, staffId);
        ModelAndView mav = new ModelAndView("dorm-admin");
        if (rewardsDtoList == null || rewardsDtoList.size() == 0) {
            mav.addObject("error", "查找不到该寝室的奖惩状况！");
        }

        mav.addObject("rewardsList", rewardsDtoList);
        return mav;
    }
}