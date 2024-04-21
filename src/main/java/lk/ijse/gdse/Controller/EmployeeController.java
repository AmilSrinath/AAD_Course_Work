package lk.ijse.gdse.Controller;

import lk.ijse.gdse.DAO.EmployeeDAO;
import lk.ijse.gdse.DTO.EmployeeDTO;
import lk.ijse.gdse.Entity.Gender;
import lk.ijse.gdse.Entity.Role;
import lk.ijse.gdse.conversion.Mapping;
import lk.ijse.gdse.util.UtilMatters;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * @author Amil Srinath
 */
@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeDAO employeeDAO;
    private final Mapping conversionData;

    @GetMapping("/health")
    public String healthCheck(){
        return "OK";
    }

    @PostMapping
    public boolean saveEmployee(
            @RequestPart("employeeName") String employeeName,
            @RequestPart("employeeProfilePic") String employeeProfilePic,
            @RequestPart("gender") String gender,
            @RequestPart("status") String status,
            @RequestPart("designation") String designation,
            @RequestPart("role") String role,
            @RequestPart("dob") String dob,
            @RequestPart("joinDate") String joinDate,
            @RequestPart("attachedBranch") String attachedBranch,
            @RequestPart("employeeAddress1") String employeeAddress1,
            @RequestPart("employeeAddress2") String employeeAddress2,
            @RequestPart("employeeAddress3") String employeeAddress3,
            @RequestPart("employeeAddress4") String employeeAddress4,
            @RequestPart("employeeAddress5") String employeeAddress5,
            @RequestPart("contactNo") String contactNo,
            @RequestPart("email") String email,
            @RequestPart("informInCaseOfEmergency") String informInCaseOfEmergency,
            @RequestPart("emergencyContactNo") String emergencyContactNo) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(UUID.randomUUID().toString());
        employeeDTO.setEmployeeName(employeeName);
        employeeDTO.setEmployeeProfilePic(UtilMatters.convertBase64(employeeProfilePic));
        employeeDTO.setGender(Gender.valueOf(gender));
        employeeDTO.setStatus(status);
        employeeDTO.setDesignation(designation);
        employeeDTO.setRole(Role.valueOf(role));
        employeeDTO.setDob(dateFormat.parse(dob));
        employeeDTO.setJoinDate(dateFormat.parse(joinDate));
        employeeDTO.setAttachedBranch(attachedBranch);
        employeeDTO.setEmployeeAddress1(employeeAddress1);
        employeeDTO.setEmployeeAddress2(employeeAddress2);
        employeeDTO.setEmployeeAddress3(employeeAddress3);
        employeeDTO.setEmployeeAddress4(employeeAddress4);
        employeeDTO.setEmployeeAddress5(employeeAddress5);
        employeeDTO.setContactNo(contactNo);
        employeeDTO.setEmail(email);
        employeeDTO.setInformInCaseOfEmergency(informInCaseOfEmergency);
        employeeDTO.setEmergencyContactNo(emergencyContactNo);

        EmployeeDTO savedEmployee = conversionData.toEmployeeDTO(employeeDAO.save(conversionData.toEmployee(employeeDTO)));
        return savedEmployee != null;
    }
}
