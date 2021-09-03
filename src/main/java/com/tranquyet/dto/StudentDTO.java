package com.tranquyet.dto;


import com.tranquyet.error.annotation.Dob;
import com.tranquyet.error.annotation.Email;
import com.tranquyet.error.annotation.Name;
import com.tranquyet.error.annotation.Phone;
import com.tranquyet.util.constant.student.StudentValueConstant;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends AbstractDTO<StudentDTO> {
    private String code;
    @Name
    private String name;
    private String location;
    @Dob
    private String dob;
    private String gender;
    @Phone
    private String phone;
    private String email;
    private String codeOfClass;
    private String note;


    /**
     * count the current age by current year - year of birth
     *
     * @return return the current age
     */
    public int countCurrentAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR); // current year
        int yearOfBirth = 0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(StudentValueConstant.FORMAT_DATE);
            yearOfBirth = sdf.parse(dob).getYear() + 1900; // year of dob
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int currentAge = currentYear - yearOfBirth; // current age

        return currentAge;
    }

    public void setDob(String dob){
        this.dob = dob;
        this.getYear();
        this.countCurrentAge();
    }

    /**
     * @return arr which contain all information of student
     */
    public String[] getArrayInformation() {
        String[] arrInfor = {code, name, gender, dob, phone, countCurrentAge() + ""};
        return arrInfor;
    }

    /**
     * split year of birth from dob
     *
     * @return year of dob
     */
    public int getYear() {
        int yearOfBirth = 0;
        SimpleDateFormat sdf = new SimpleDateFormat(StudentValueConstant.FORMAT_DATE);
        try {
            yearOfBirth = sdf.parse(dob).getYear() + 1900;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return yearOfBirth;
    }
}
