package com.salmi.bouchelaghem.studynet.Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.salmi.bouchelaghem.studynet.Models.Department;
import com.salmi.bouchelaghem.studynet.Models.Module;
import com.salmi.bouchelaghem.studynet.Models.Section;
import com.salmi.bouchelaghem.studynet.Models.Specialty;
import com.salmi.bouchelaghem.studynet.Models.Teacher;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StudynetAPI {

    // *** Departments ***

    /** Get all departments */
    @GET("departments")
    Call<List<Department>> getDepartments();

    // *** Specialities ***

    /** Get specialities based on department */
    @GET("specialties")
    Call<List<Specialty>> getSpecialities(@Query("department") String department);
    // This will generate 'specialties/?department=INFO'

    // *** Sections ***

    /** Get sections based on specialty*/
    @GET("sections")
    Call<List<Section>> getAllSections();
    // sections

    /** Get sections based on specialty*/
    @GET("sections")
    Call<List<Section>> getSpecialitySections(@Query("specialty") String specialty);
    // sections/?specialty=ISIL

    /** Get sections based on department*/
    @GET("sections")
    Call<List<Section>> getDepartmentSections(@Query("department") String department);
    // sections/?department=INFO

    /** Get section object based on section code*/
    @GET("sections/{code}")
    Call<Section> getSection(@Path("code") String code);
    // sections/L3 ACAD A

    // *** Modules ***

    /** Get modules based on section*/
    @GET("modules")
    Call<List<Module>> getSectionModules(@Query("section") String section);
    // modules/?section=L3 ISIL B

    // *** Teachers ***
    /** Get teachers based on section*/
    @GET("teachers")
    Call<JsonArray> getSectionTeachers(@Header("Authorization") String token, @Query("section") String section);
    // teachers/?section=ISIL B L3

    /** Get teachers based on section*/
    @GET("teachers")
    Call<JsonArray> getDepartmentTeachers(@Header("Authorization") String token, @Query("department") String department);
    // teachers/?department=INFO

    /** Get the user data using the token */
    @GET("user_data")
    Call<JsonObject> getUserData(@Header("Authorization") String token);

    /**Register a student */
    @POST("students/")
    Call<JsonObject> registerStudent(@Body JsonObject student);
    /** Login using email and password */
    @POST("login/")
    Call<JsonObject> login(@Body JsonObject credentials);

    /** Logout current session by invalidating the current token.*/
    @POST("logout/")
    Call<ResponseBody> logout(@Header("Authorization") String token);

    /** Logout all sessions by invalidating all tokens associated with the current token's account.*/
    @POST("logoutall/")
    Call<ResponseBody> logoutAll(@Header("Authorization") String token);

    /** Check if the email is used*/
    @POST("check_email/")
    Call<ResponseBody> checkEmail(@Body JsonObject email, @Header("Authorization") String token);

    /** Create a teacher with all of his data including his assignments (requires admin token)*/
    @POST("teachers/")
    Call<JsonObject> createTeacher(@Body JsonObject teacherJson, @Header("Authorization") String token);

}
