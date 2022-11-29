package demo.testexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.testexample.model.MobileModel;
import demo.testexample.service.MobileService;
@RestController
@RequestMapping("/mobile")
public class MobileController {
	@Autowired
	MobileService mobileService;
	
	@PostMapping("/save")
	public MobileModel postMobile(@RequestBody MobileModel mobileModel) {
		MobileModel mobileModel1=mobileService.postMobile(mobileModel);
		return mobileModel1;	
	}
	
	@GetMapping("/get")
	public List<MobileModel> getMobiles() {
		 List<MobileModel> mobileModel1=mobileService.getMobiles();
		return mobileModel1;	
	}
	
	@DeleteMapping("/delete")
	public String deleteMobiles(@PathVariable Integer mobileImeiNo) {
		 mobileService.deleteMobiles(mobileImeiNo);
		return "deleted";	
	}
	
	@PutMapping("/save")
	public MobileModel updateMobile(@RequestBody MobileModel mobileModel) {
		Integer mobileImeiNo = mobileModel.getMobileImeiNo();
		MobileModel mobileModel1=mobileService.updateMobile(mobileModel,mobileImeiNo);
		return mobileModel1;	
	}

}
