package com.dubrechi.ambag

import com.dubrechi.ambag.RetrofitServiceBuilder.coronaApi

class CoroutineFunctions {

    val TAG = this.javaClass.simpleName

    suspend fun getCases(): List<CaseDTO> {

        return coronaApi().cases()
    }

    suspend fun getCasesOutsidePH(): List<CaseOutsidePhDTO> {

        return coronaApi().casesOutsidePH()
    }

    suspend fun getPUI(): MutableList<PatientUnderInvestigationDTO> {

        return coronaApi().patientUnderInvestigation()
    }

}