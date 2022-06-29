Feature: US1001 Kullanici DB Utils ile database baglantisi yapabilir
  Scenario: TC02 Kullanici DB Utils ile database'deki bilgileri okurur
    Given kullanici DBUtils ile HMC veri tabanina baglanir
    And kullanici DBUtils ile "tHOTELROOM" tablosundaki "Price" verilerini alir
    #SELECT Price FROM "tHOTELROOM"
    And kullanici DBUtils ile "Price" sutunundaki verileri okur