package com.maeldebon.contest

class Country {
    var id: Int = 0
    var name : String = ""
    var flag : String = ""
    var capitale : String = ""
    var continent : String = ""
    var date : String = ""

    constructor(name:String) {
        this.name = name
        this.flag = flag
        this.capitale = capitale
        this.continent = continent
        this.date = date
    }

    constructor() {
        this.name = name
        this.flag = flag
        this.capitale = capitale
        this.continent = continent
        this.date = date
    }
}