package com.fcb.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcb.beans.AddressProofBean;
import com.fcb.beans.EmployeeBean;
import com.fcb.beans.FCBResponse;
import com.fcb.beans.IdentificationProofBean;
import com.fcb.beans.OtherIdCardBean;
import com.fcb.beans.PassportDetailsBean;
import com.fcb.beans.PermanentAddressBean;
import com.fcb.beans.PresentAddressBean;
import com.fcb.dao.EmployeeDAO;
import com.fcb.entity.AddressProof;
import com.fcb.entity.Branch;
import com.fcb.entity.Employee;
import com.fcb.entity.IdentificationProof;
import com.fcb.entity.OtherIdCard;
import com.fcb.entity.PassportDetails;
import com.fcb.entity.PermanentAddress;
import com.fcb.entity.PresentAddress;
import com.fcb.entity.UserAuthentication;
import com.fcb.util.DateConverter;
import com.fcb.util.FCBConstaint;
import com.fcb.util.JSONUtile;

@Service
public class EmployeeRegisterServiceIpml implements EmployeeRegisterService {

	private static final Logger logger = Logger.getLogger(EmployeeRegisterService.class);
	@Autowired
	private EmployeeDAO employeeDAO;

	/**
	 * This method is use for register employee
	 * @param list of employee details
	 * @return response object
	 */
	public String registerEmployee(List list) {
		FCBResponse response = new FCBResponse();
		response.setMessage("Unable to process your request ! please try again");
		response.setStatus(FCBConstaint.FCB_FAILURE);
		if (list != null && employeeDAO != null) {
			EmployeeBean employeeBean = (EmployeeBean) list.get(0);
			PermanentAddressBean permanentAddressBean = (PermanentAddressBean) list.get(1);
			PresentAddressBean presentAddressBean = (PresentAddressBean) list.get(2);
			IdentificationProofBean identificationProofBean = (IdentificationProofBean) list.get(3);
			AddressProofBean addressProofBean = (AddressProofBean) list.get(4);
			PassportDetailsBean passportDetailsBean = (PassportDetailsBean) list.get(5);
			OtherIdCardBean otherIdCardBean = (OtherIdCardBean) list.get(6);
			AddressProof addressProof = new AddressProof();
			BeanUtils.copyProperties(addressProofBean, addressProof);

			PassportDetails passportDetails = new PassportDetails();
			passportDetails.setIssuedPlace(passportDetailsBean.getIssuedPlace());
			passportDetails.setPassportNumber(passportDetailsBean.getPassportNumber());
			passportDetails.setPassportIssuedDate(DateConverter.setDate(passportDetailsBean.getPassportIssuedDate()));
			passportDetails.setPassportExpiryDate(DateConverter.setDate(passportDetailsBean.getPassportExpiryDate()));

			OtherIdCard otherIdCard = new OtherIdCard();
			BeanUtils.copyProperties(otherIdCardBean, otherIdCard);

			IdentificationProof identificationProof = new IdentificationProof();
			BeanUtils.copyProperties(identificationProofBean, identificationProof);
			PermanentAddress permanentAddress = new PermanentAddress();
			BeanUtils.copyProperties(permanentAddressBean, permanentAddress);

			PresentAddress presentAddress = new PresentAddress();
			BeanUtils.copyProperties(presentAddressBean, presentAddress);
			Branch branch = new Branch();
			branch.setBranchId(employeeBean.getBranchId());

			Employee employee = new Employee();
			employee.setFirstName(employeeBean.getFirstName());
			employee.setLastName(employeeBean.getLastName());
			employee.setDob(DateConverter.setDate(employeeBean.getDob()));
			employee.setGender(employeeBean.getGender());
			employee.setEmail(employeeBean.getEmail());
			employee.setMobile(employeeBean.getMobile());
			employee.setBloodGroup(employeeBean.getBloodGroup());
			employee.setDesgination(employeeBean.getDesgination());
			employee.setSalary(employeeBean.getSalary());
			employee.setStatus(employeeBean.getStatus());
			employee.setCreatedBy(1);
			employee.setCreatedDate(new Date());
			employee.setJoiningDate(DateConverter.setDate(employeeBean.getJoiningDate()));
			employee.setIdentificationProof(identificationProof);
			employee.setPermanentAddress(permanentAddress);
			employee.setPresentAddress(presentAddress);
			employee.setAddressProof(addressProof);
			employee.setPassport(passportDetails);
			employee.setOtherCard(otherIdCard);
			try {
				 employeeDAO.registerEmployee(employee, branch.getBranchId());
				 Integer employeeId =	getMaxEmployeeId();
				if (employeeId == 0) {
					response.setMessage("Unable to process your request ! please try again");
					response.setStatus(FCBConstaint.FCB_FAILURE);
					logger.error("Exception occure while register employee details");
				} else {
					response.setMessage("Eployee registe successfully employee Id :"+employeeId);
					response.setStatus(FCBConstaint.FCB_SUCCESS);
					response.setData(employeeId);
					logger.error("Employee regiser success fully Employee id :"+employeeId);
				}
			} catch (HibernateException e) {
				response.setMessage("Unable to process your request ! please try again");
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occure while registe employee details");
			} catch (Exception e) {
				response.setMessage("Unable to process your request ! please try again");
				response.setStatus(FCBConstaint.FCB_FAILURE);
				logger.error("Exception occure while registe employee details");
			}
		}
		return JSONUtile.convertJavaToJson(response);
	}//method 
	
	private Integer getMaxEmployeeId(){
		Integer employeeId=null;
		employeeId=employeeDAO.getMaxEmployeeId();
		System.out.println(employeeId);
		return employeeId;
	}

}
