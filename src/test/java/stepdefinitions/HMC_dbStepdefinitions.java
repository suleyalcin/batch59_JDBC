package stepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;

public class HMC_dbStepdefinitions {
    //query'i==> sorguyu bir resultSete atiyoruz
    //Asagidaki bilgileri(url,username,password database devoloper verir

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; " +
            "user=techproed;password=P2s@rt65";

    String username="techproed";
    String password="P2s@rt65";

    Connection connection;//Database'e baglanmamaizi sagliyor
    Statement statement;//Query calistirmamizi sagliyor
    ResultSet resultSet;//query sonunda donen sonucu store etmemize yariyor

    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        connection = DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //parantez icerisini yoneticiden aliriz
        }

    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        String query = "SELECT "+field+" FROM "+ table;
        resultSet = statement.executeQuery(query);

    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {
        resultSet.first();
        System.out.println(resultSet.getString("Price"));//225.0000
        resultSet.next();//iteratora benzer sekilde calisir
        //next()' u imleci bir sonraki degerin yanina goturur
        //bize true yada false doner
        System.out.println(resultSet.getString("Price"));//4000.0000
        System.out.println(resultSet.next());//true yada false dondurur yaninda eleman varsa true yoksa false doner
        System.out.println(resultSet.getString("Price"));//445.0000
        //next() kullanilirken cok dikkatli olmak gerekir
        //cunku nerede olursa olsun imleci bir sonraki elemente gecirir

        System.out.println("==============================LISTE====================================");
        //while loppta sonunu bilmesemde icine yazdigim true oldugu surece calisir>Bu yuzden while loop kullaniriz
        resultSet.absolute(0);
        int sira=1;
        while(resultSet.next()){
            System.out.println(sira+". kayit : "+resultSet.getString("Price"));
            sira++;
        }
        //tabloda kac satir oldugunu nasil buluruz?
        resultSet.last();
        System.out.println(resultSet.getRow());//416

    }
}
