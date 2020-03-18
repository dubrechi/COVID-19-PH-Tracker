package com.dubrechi.ambag

import com.dubrechi.ambag.RetrofitServiceBuilder.coronaApi
import java.lang.Exception

class CoroutineFunctions {

    val TAG = this.javaClass.simpleName

    suspend fun getCases(): List<CaseDTO> {

        return try {
            coronaApi().cases()

        }catch (e: Exception) {
            val emptyList:List<CaseDTO> = ArrayList()
            emptyList
        }
    }

    suspend fun getCasesOutsidePH(): List<CaseOutsidePhDTO> {

        return try {
            coronaApi().casesOutsidePH()

        }catch (e: Exception) {
            val emptyList:List<CaseOutsidePhDTO> = ArrayList()
            emptyList
        }
    }

    suspend fun getPUI(): MutableList<PatientUnderInvestigationDTO> {

        return try {
            coronaApi().patientUnderInvestigation()

        }catch (e: Exception) {
            val emptyList:MutableList<PatientUnderInvestigationDTO> = ArrayList()
            emptyList
        }
    }

}