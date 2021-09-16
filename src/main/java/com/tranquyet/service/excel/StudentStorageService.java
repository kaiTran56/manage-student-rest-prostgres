package com.tranquyet.service.excel;


import com.tranquyet.dto.StudentDTO;


import java.util.*;

import java.util.stream.Collectors;

/**
 * StudentDTO Storage use to save the information of student
 */
public class StudentStorageService {

    public static List<StudentDTO> listStudent = new ArrayList<StudentDTO>();// use to store all the student information

    /**
     * add the information of student
     *
     * @param student student object use to add to storage
     *                <p>
     *                <p>
     *                if student != null
     *                add to List
     *                else
     *                show error message
     */
    public static void addStudent(List<StudentDTO> student) {
        listStudent = student;
    }

    /**
     * @return the number of student in the list
     */
    public static List<StudentDTO> getAll() {
        return listStudent;
    }

    /**
     *
     */
    public static List<StudentDTO> getStudentForTableSheet() {
        List<StudentDTO> studentTableSheet = new ArrayList<>();
        getAll().forEach(p -> {
            StudentDTO student = new StudentDTO();
            student.setCode(p.getCode());
            student.setName(p.getName());
            student.setCodeOfClass(p.getCodeOfClass());
            student.setGender(p.getGender());
            student.setDob(p.getDob());
            student.setPhone(p.getPhone());
            studentTableSheet.add(student);
        });
        return studentTableSheet;
    }


    /**
     * @return Total student in database
     */
    public static int getTotal() {
        return listStudent.size();
    }

    /**
     * pagination of sheet 20 student/page
     *
     * @param studentPerPage number student per page
     *                       <p>
     *                       <p>
     *                       for loop at i = 0, i < total, step 20
     *                       paging add sub arraylist of all
     * @return paging - a list contain sub_list which have size 20 or smaller 20 at the last sub_list
     */
    public static List<List<StudentDTO>> pagination(final int studentPerPage) {
        Map<String, List<StudentDTO>> check = getStudentForTableSheet().stream()
                .collect(Collectors.groupingBy(StudentDTO::getCodeOfClass));
        List<List<StudentDTO>> list = new ArrayList<>();
        check.values().stream().filter(p -> p.size() > studentPerPage).sorted(Comparator.comparing(List::size))
                .forEach(p -> {
                    int n = p.size();
                    for (int i = 0; i < n; i += studentPerPage) {
                        list.add(new ArrayList<>( // create sub_list
                                p.subList(i, Math.min(n, i + studentPerPage))));
                    }
                });
        check.values().stream().filter(p -> p.size() <= studentPerPage).sorted(Comparator.comparing(List::size)).forEach(list::add);

        return list;

    }

    /**
     * Count the number of student who have the same year of birth
     *
     * @return <pre>
     *     A map which have key - unique year
     *                      value - number of student have the same year
     * </pre>
     */
    public static Map<Integer, Long> countSameYear() {
        List<Integer> listAge = new ArrayList<>();
        getAll().forEach(p -> {
            listAge.add(p.getYear());
        });
        Map<Integer, Long> temp = listAge.stream().sorted()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // create key map contain unique year
        // and value map contain the number of student have the same year
        Map<Integer, Long> map = temp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        return map;
    }

}
