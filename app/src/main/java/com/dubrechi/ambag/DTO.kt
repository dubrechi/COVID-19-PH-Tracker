package com.dubrechi.ambag

data class CaseDTO(val case_no: String?,
                   val date: String?,
                   val age: String?,
                   val gender: String?,
                   val nationality: String?,
                   val hospital_admitted_to: String?,
                   val had_recent_travel_history_abroad: String?,
                   val status: String?,
                   val notes: String?,
                   val other_information: String?,
                   val source: String?)
data class CaseOutsidePhDTO (val country_territory_place: String?,
                             val confirmed: String?,
                             val recovered: String?,
                             val died: String?)

data class SuspectedCasesDTO(val admitted: String?,
                          val deaths: String?)

data class ConfirmedCasesDTO(val admitted: String?,
                          val recoveries: String?,
                          val deaths: String?)

data class CurrentPUIStatusDTO(val suspected_cases: SuspectedCasesDTO?,
                               val confirmed_cases: ConfirmedCasesDTO?)

data class PatientUnderInvestigationDTO (val region: String?,
                                         val current_pui_status: CurrentPUIStatusDTO,
                                         val total: String?)

data class CheckpointsDTO(val id: Int?,
                          val district: String?,
                          val city: String?,
                          val location: String?,
                          val type: String?,
                          val lat: String?,
                          val lng: String?,
                          val description: String?)
