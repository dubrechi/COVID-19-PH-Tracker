package com.dubrechi.ambag

import android.app.Application

class Application: Application(){

    companion object {

        var baseUrl = "https://coronavirus-ph-api.now.sh/"
        val recovered: MutableList<CaseDTO> = ArrayList()
        val admitted: MutableList<CaseDTO> = ArrayList()
        val died: MutableList<CaseDTO> = ArrayList()
        val tba: MutableList<CaseDTO> = ArrayList()
    }
}