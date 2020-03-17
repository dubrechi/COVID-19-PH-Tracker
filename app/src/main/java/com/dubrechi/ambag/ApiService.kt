package com.dubrechi.ambag

import retrofit2.http.GET

interface ApiService {

    @GET("cases")
    suspend fun cases(): List<CaseDTO>

    @GET("cases-outside-ph")
    suspend fun casesOutsidePH(): List<CaseOutsidePhDTO>

    @GET("patients-under-investigation")
    suspend fun patientUnderInvestigation(): List<PatientUnderInvestigationDTO>

}