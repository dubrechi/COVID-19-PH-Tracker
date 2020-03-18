package com.dubrechi.ambag

import com.google.gson.JsonObject
import retrofit2.http.GET
import java.util.*

interface ApiService {

    @GET("cases")
    suspend fun cases(): List<CaseDTO>

    @GET("cases-outside-ph")
    suspend fun casesOutsidePH(): List<CaseOutsidePhDTO>

    @GET("patients-under-investigation")
    suspend fun patientUnderInvestigation(): MutableList<PatientUnderInvestigationDTO>

    @GET("mm-checkpoints")
    suspend fun metroManilaCheckpoints(): MutableList<CheckpointsDTO>

}