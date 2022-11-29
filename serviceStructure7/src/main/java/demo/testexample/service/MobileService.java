package demo.testexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.testexample.model.MobileModel;
import demo.testexample.repository.MobileRepository;
@Service
public class MobileService {
	
	@Autowired
	MobileRepository mobileRepository;

	public MobileModel postMobile(MobileModel mobileModel) {
		MobileModel m = mobileRepository.save(mobileModel);
		return m;
	}

	public List<MobileModel> getMobiles() {
		Iterable<MobileModel> findAll = mobileRepository.findAll();
		return (List<MobileModel>) findAll;
	}

	public void deleteMobiles(Integer id) {
		mobileRepository.deleteById(id);
		
	}

	public MobileModel updateMobile(MobileModel mobileModel, Integer mobileImeiNo) {
		Optional<MobileModel> dbdata = mobileRepository.findById(mobileImeiNo);
		MobileModel mobileModel2 = dbdata.get();
		mobileModel2.setColour(mobileModel.getColour());
		mobileModel2.setMobileImeiNo(mobileImeiNo);
		mobileModel2.setName(mobileModel.getName());
		MobileModel save = mobileRepository.save(mobileModel2);
		return save;
	}

	

}
