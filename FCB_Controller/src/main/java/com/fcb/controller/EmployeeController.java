package com.fcb.controller;



import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fcb.beans.AddressProofBean;
import com.fcb.beans.EmployeeBean;
import com.fcb.beans.IdentificationProofBean;
import com.fcb.beans.OtherIdCardBean;
import com.fcb.beans.PassportDetailsBean;
import com.fcb.beans.PermanentAddressBean;
import com.fcb.beans.PresentAddressBean;
import com.fcb.service.EmployeeRegisterService;
import com.fcb.util.JSONUtile;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRegisterService employeeRegisterService;
	
	@ResponseBody
	@RequestMapping(value="registerEmployee",method=RequestMethod.POST)
	public String registerEmployee(@RequestBody String registerEmployeeJson){
		List list=new ArrayList();
		String responseJson=null;
		JSONObject jsonObject=new JSONObject(registerEmployeeJson);
		
		EmployeeBean employeeBean=JSONUtile.convertJsonToJava(EmployeeBean.class,(jsonObject.get("employeeJson")).toString());			
		PermanentAddressBean permanentAddressBean=JSONUtile.convertJsonToJava(PermanentAddressBean.class, jsonObject.get("permanentAddJson").toString());
		PresentAddressBean presentAddressBean=JSONUtile.convertJsonToJava(PresentAddressBean.class, jsonObject.get("presentAddJson").toString());
		IdentificationProofBean identificationProofBean=JSONUtile.convertJsonToJava(IdentificationProofBean.class, jsonObject.get("identificationProofJson").toString());
		AddressProofBean addressProofBean=JSONUtile.convertJsonToJava(AddressProofBean.class, jsonObject.get("addressProofJson").toString());
		PassportDetailsBean passportDetailsBean=JSONUtile.convertJsonToJava(PassportDetailsBean.class, jsonObject.get("passportJson").toString());
		OtherIdCardBean otherIdCardBean=JSONUtile.convertJsonToJava(OtherIdCardBean.class, jsonObject.get("otherCardJson").toString());
		
		list.add(employeeBean);
		list.add(permanentAddressBean);
		list.add(presentAddressBean);
		list.add(identificationProofBean);
		list.add(addressProofBean);
		list.add(passportDetailsBean);
		list.add(otherIdCardBean);
		responseJson=employeeRegisterService.registerEmployee(list);
		
		return responseJson;
		
	}
	
}
