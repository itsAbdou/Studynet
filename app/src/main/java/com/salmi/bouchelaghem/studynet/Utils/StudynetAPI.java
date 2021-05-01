package com.salmi.bouchelaghem.studynet.Utils;

import com.salmi.bouchelaghem.studynet.Models.Department;
import com.salmi.bouchelaghem.studynet.Models.Section;
import com.salmi.bouchelaghem.studynet.Models.Specialty;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudynetAPI {

    // Departments

    // Get all departments
    @GET("departments")
    Call<List<Department>> getDepartments();

    // Specialities

    // Get specialities based on department
    @GET("specialties")
    Call<List<Specialty>> getSpecialities(@Query("department") String department);
    // This will generate 'specialties/?department=INFO'

    // Sections
    @GET("sections")
    Call<List<Section>> getSections(@Query("specialty") String specialty);
    // sections/?specialty=ISIL

}