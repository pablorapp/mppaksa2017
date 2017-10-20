/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programas;

import controladores.FeriadosControlador;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import modelos.Feriados;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author Pablo
 */
public class Formato {

    String Formato = "MDY";
//    public Formato() {
//        Conexion conn = new Conexion();
//        try {
//            ResultSet rs = conn.conexion.createStatement().executeQuery("Select CfgFormato From Configuracion");
//            if(rs.next()){
//                Formato = rs.getString("CfgFormato");
//            }else{
//                Formato = "MDY";
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error de Sistema", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    public String SetFormato(String numero){
    int conta = 0;
    int ban =0;
    String numero3;
    try{
    int numero2 = Integer.parseInt(GetFormato(numero));
    numero3 = numero2 +"";
    }catch(Exception e){
        numero3 = numero;
    }
    String numero4 = "";
    
    for(int i = numero3.length();i>0;i--){
        if (Character.isDigit(numero3.charAt(i-1))){
            //if(!(numero3.charAt(i-1)==0 && i == 1)){
                conta++;
                ban=1;
                if (conta%3==0 && i>1){
                    numero4 = numero4.trim() +numero3.charAt(i-1)+ ".";
                } else{
                    numero4 = numero4.trim() +numero3.charAt(i-1);
                }
            //}
        }
    } 
    numero3 = numero4;
    numero4 = "";
    for(int i = numero3.length();i>0;i--){
            numero4 = numero4.trim() +numero3.charAt(i-1);
    }  
    return numero4;
    }
    public String GetFormato(String numero){
        String numero4 = "";
        for(int i = numero.length();i>0;i--){
            if(Character.isDigit(numero.charAt(i-1))){
                numero4=numero4.trim() + numero.charAt(i-1);
            }
        }
        String numero2 = numero4;
        numero4="";
        for(int i = numero2.length();i>0;i--){
            
                numero4=numero4.trim() + numero2.charAt(i-1);
            
        }
        return numero4;
    }
    
    public String SetFomatoD(String Fecha){
        String Fecha2 = "";
        
        int conta= 0;
        for(int i = 0;i<Fecha.length();i++){
            if(Character.isDigit(Fecha.charAt(i))){
                conta++;
                
                Fecha2 = Fecha2.trim() + Fecha.charAt(i);
                if(conta == 2 || conta == 4){
                    if(Fecha.length()!=i+1){
                        Fecha2 = Fecha2.trim() + "/";
                    }
                    
                }
            }
        }
        return Fecha2;
    }
    
    public boolean VerifFecha(String Fecha) throws ParseException{
        
        boolean resp = true;
        SimpleDateFormat FDate = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar calendario = new GregorianCalendar();
        int diaC = Integer.parseInt(Fecha.substring(0, 2));
        int mesC = Integer.parseInt(Fecha.substring(3, 5));
        Date Fecha2 = FDate.parse(Fecha);
        calendario.setTime(Fecha2);
        int diaF = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        int anio = calendario.get(Calendar.YEAR);
        if(diaC > diaF || mesC > 12){
            JOptionPane.showMessageDialog(null, "Fecha Invalida");
            resp = false;
        } 
        if(mesC==2){
            if(calendario.isLeapYear(anio)){
                if(diaC > 29 || mesC > 12){
                    JOptionPane.showMessageDialog(null, "Fecha Invalida");
                    resp = false;
                }
            }else{
                if(diaC > 28 || mesC > 12){
                    JOptionPane.showMessageDialog(null, "Fecha Invalida");
                    resp = false;
                }
            }
        }
        return resp;
    }
    
    public static String Encriptar(String text){
        String textEncri="";
        String secretKey ="casadelostaladros";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = text.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            textEncri = new String(base64Bytes);
            
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex){
            JOptionPane.showMessageDialog(null, "error: " + ex.getMessage());
        }
        return textEncri;
    }
    
    public static String Desencriptar(String textoEncriptado) throws Exception {
 
        String secretKey = "casadelostaladros"; //llave para desenciptar datos
        String base64EncryptedString = "";
 
        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
 
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
 
            byte[] plainText = decipher.doFinal(message);
 
            base64EncryptedString = new String(plainText, "UTF-8");
 
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return base64EncryptedString;
    }
    public String formatearFecha(String fecha){
        String fecha2 = fecha.substring(3, 5)+"-"+fecha.substring(0,2)+"-20"+fecha.substring(6,8);
        if(Formato.equals("DMY")){
            fecha2 = fecha.substring(0,2)+"-"+fecha.substring(3,5)+"-20"+fecha.substring(6,8);
        }
        return fecha2;
    }
    public String formatearFechaDCC(String fecha){
        String fecha2 = fecha.substring(0, 2)+"-"+fecha.substring(3,5)+"-20"+fecha.substring(6,8);
        return fecha2;
    }
    public String formatearFechaDe10(String fecha){
        String fecha2;
        try{
            fecha2 = fecha.substring(3, 5)+"-"+fecha.substring(0,2)+"-"+fecha.substring(6,10);
            if(Formato.equals("DMY")){
                fecha2 = fecha.substring(0,2)+"-"+fecha.substring(3,5)+"-"+fecha.substring(6,10);
            }
        }catch(Exception e){
            fecha2 = fecha.substring(3, 5)+"-"+fecha.substring(0,2)+"-20"+fecha.substring(6,8);
            if(Formato.equals("DMY")){
                fecha2 = fecha.substring(0,2)+"-"+fecha.substring(3,5)+"-20"+fecha.substring(6,8);
            }
        }
        return fecha2;
    }
    public int formatearFechaDe10(String fecha,String tipo){
        int nro;
        if(tipo.equalsIgnoreCase("dia")){
            nro = Integer.parseInt(fecha.substring(3, 5));
        }else if(tipo.equalsIgnoreCase("mes")){
            nro = Integer.parseInt(fecha.substring(0,2))-1;
        }else{
            nro = Integer.parseInt(fecha.substring(6,10));
        }
        return nro;
    }
    public String FormatNroFac(String nroFac){
        String Nro = nroFac;
        String Nro2 = "";
        String Nro3 = "";
        int vuelta = 0;
        int largo;
        if(Nro.length()>6){
            for(int i = 0;Nro.length()>i;i++){
                if(Character.isDigit(Nro.charAt(i))){
                    vuelta ++;
                    Nro2 = Nro2 + Nro.charAt(i);
                    if(vuelta == 3 || vuelta == 6){
                        Nro2 = Nro2 + "-";
                    }
                }
            }
            largo = Nro2.length();
            switch(largo){
                case 9:
                    Nro2 = Nro2.substring(0,8)+ "000000" + Nro2.substring(8);
                break;
                case 10:
                    Nro2 = Nro2.substring(0,8)+ "00000" + Nro2.substring(8, 10);
                break;
                case 11:
                    Nro2 = Nro2.substring(0,8)+ "0000" + Nro2.substring(8, 11);
                break;
                case 12:
                    Nro2 = Nro2.substring(0,8)+ "000" + Nro2.substring(8, 12);
                break;
                case 13:
                    Nro2 = Nro2.substring(0,8)+ "00" + Nro2.substring(8, 13);
                break;
                case 14:
                    Nro2 = Nro2.substring(0,8)+ "0" + Nro2.substring(8, 14);
                break;
            }
        }else{
            Nro2=Nro;
        }
        
        return Nro2;
    }
    
    
    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    
    public static String FechaHoy(){
        String fecha;
        Calendar c2 = new GregorianCalendar();
        String dia;
        String mes;
        String ano;
        int uno = c2.get(Calendar.DAY_OF_MONTH);
        int dos = c2.get(Calendar.MONTH) + 1;
        if(uno<10){
            dia = "0"+c2.get(Calendar.DAY_OF_MONTH);
        }else{
            dia = c2.get(Calendar.DAY_OF_MONTH)+"";
        }
        if(dos<10){
            mes = "0"+(c2.get(Calendar.MONTH) + 1);
        }else{
            mes = ""+(c2.get(Calendar.MONTH) + 1);
        }
        ano = c2.get(Calendar.YEAR)+"";
        fecha = dia+"/"+mes+"/"+ano;
        return fecha;
    }
    
    public static String FechaHoy2(){
        String fecha;
        Calendar c2 = new GregorianCalendar();
        String dia;
        String mes;
        String ano;
        int uno = c2.get(Calendar.DAY_OF_MONTH);
        int dos = c2.get(Calendar.MONTH) + 1;
        if(uno<10){
            dia = "0"+c2.get(Calendar.DAY_OF_MONTH);
        }else{
            dia = c2.get(Calendar.DAY_OF_MONTH)+"";
        }
        if(dos<10){
            mes = "0"+(c2.get(Calendar.MONTH) + 1);
        }else{
            mes = ""+(c2.get(Calendar.MONTH) + 1);
        }
        ano = c2.get(Calendar.YEAR)+"";
        fecha = ano+"-"+mes+"-"+dia;
        return fecha;
    }
    
    public static String FechaHoy3(){
        String fecha;
        Calendar c2 = new GregorianCalendar();
        String dia;
        String mes;
        String ano;
        int uno = c2.get(Calendar.DAY_OF_MONTH);
        int dos = c2.get(Calendar.MONTH) + 1;
        if(uno<10){
            dia = "0"+c2.get(Calendar.DAY_OF_MONTH);
        }else{
            dia = c2.get(Calendar.DAY_OF_MONTH)+"";
        }
        if(dos<10){
            mes = "0"+(c2.get(Calendar.MONTH) + 1);
        }else{
            mes = ""+(c2.get(Calendar.MONTH) + 1);
        }
        ano = c2.get(Calendar.YEAR)+"";
        fecha = dia+"-"+mes+"-"+ano;
        return fecha;
    }
    
//    public static String FechaHoy2(String fec){
//        String fecha;
//        Calendar c2 = new GregorianCalendar();
//        String dia = fec.substring(0, 2);
//        String mes;
//        String ano;
//        int uno = c2.get(Calendar.DAY_OF_MONTH);
//        int dos = c2.get(Calendar.MONTH) + 1;
//        if(uno<10){
//            dia = "0"+c2.get(Calendar.DAY_OF_MONTH);
//        }else{
//            dia = c2.get(Calendar.DAY_OF_MONTH)+"";
//        }
//        if(dos<10){
//            mes = "0"+(c2.get(Calendar.MONTH) + 1);
//        }else{
//            mes = ""+(c2.get(Calendar.MONTH) + 1);
//        }
//        ano = c2.get(Calendar.YEAR)+"";
//        fecha = ano+"-"+mes+"-"+dia;
//        return fecha;
//    }
//    
    
    public static String ImporteALetras(String importe){
        String textImp="";
        String unidad[] = {" UNO"," DOS"," TRES"," CUATRO"," CINCO"," SEIS"," SIETE"," OCHO"," NUEVE"};
        String decena[] = {" DIEZ"," VEINTE"," TREINTA"," CUARENTA"," CINCUENTA"," SESENTA"," SETENTA"," OCHENTA"," NOVENTA"};
        String centena[] = {" CIEN"," DOSCIENTOS"," TRESCIENTOS"," CUATROCIENTOS"," QUINIENTOS"," SEISCIENTOS"," SETECIENTOS"," OCHOCIENTOS"," NOVECIENTOS"};
        System.out.println("importe " + importe);
        String imp = importe;
        int coma = imp.indexOf(".");
        
        int largo = imp.length();
        int pos = 0;
        int nro;
        int mil = 0;
        System.out.println("nro " + imp + " largo " + largo + " coma " + coma);
        if(coma>=0){
            int poscom = largo - coma;
            int agre;
            if(poscom!=3){
                agre = 1;
            }else{
                agre = 0;
            }
            try{
                for(int i = 0; i<largo;i++){
                        pos = largo - i + agre;
                    switch(pos){
                        case 1:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                if(largo>1 && Integer.parseInt(imp.charAt(i-1)+"")!=0){
                                    if(Integer.parseInt(imp.charAt(i-1)+"")==1 && nro <= 5){
                                        
                                    }else{
                                        textImp += " Y";
                                        textImp += unidad[nro-1] + " Ctvs.";
                                    }
                                }else{
                                    textImp += unidad[nro-1] + " Ctvs.";
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 2:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                try{
                                    if(nro>1){
                                        textImp += decena[nro-1];
                                        mil=1;
                                    }else if(nro==1){
                                    switch (Integer.parseInt(imp.charAt(i+1)+"")) {
                                        case 0:
                                            textImp += decena[nro-1];
                                            break;
                                        case 1:
                                            textImp += " ONCE Ctvs.";
                                            break;
                                        case 2:
                                            textImp += " DOCE Ctvs.";
                                            break;
                                        case 3:
                                            textImp += " TRECE Ctvs.";
                                            break;
                                        case 4:
                                            textImp += " CATORCE Ctvs.";
                                            break;
                                        case 5:
                                            textImp += " QUINCE Ctvs.";
                                            break;
                                        default:
                                            textImp += decena[nro-1];
                                            break;
                                        }
                                    }
                                }catch(Exception e){
                                    textImp += decena[nro-1];
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 3:
                            if(imp.substring(i).equals(".00") || imp.substring(i).equals(".0")){
                                textImp += "";
                            }else{
                                textImp += " CON";
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 4:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                if(i>0){
                                    if(Integer.parseInt(imp.charAt(i-1)+"") > 0){
                                        if(Integer.parseInt(imp.charAt(i-1)+"")==1&& nro<=5){
                                            
                                        }else{
                                            textImp += " Y";
                                        }
                                    }
                                }
                                if(i>0 && Integer.parseInt(imp.charAt(i-1)+"") == 1 && nro<=5){
                                }else{
                                    textImp += unidad[nro-1];
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 5:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += decena[nro-1];
                                mil=1;
                            }else if(nro==1){
                            switch (Integer.parseInt(imp.charAt(i+1)+"")) {
                                case 0:
                                    textImp += decena[nro-1];
                                    break;
                                case 1:
                                    textImp += " ONCE";
                                    break;
                                case 2:
                                    textImp += " DOCE";
                                    break;
                                case 3:
                                    textImp += " TRECE";
                                    break;
                                case 4:
                                    textImp += " CATORCE";
                                    break;
                                case 5:
                                    textImp += " QUINCE";
                                    break;
                                default:
                                    textImp += decena[nro-1];
                                    break;
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 6:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += centena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 7:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                
                                if( i > 0){
                                    
                                    if(Integer.parseInt(imp.charAt(i-1)+"") == 1 && nro <= 5){
                                            textImp += " MIL";
                                    }else{
                                        if(Integer.parseInt(imp.charAt(i-1)+"") > 0){
                                            textImp += " Y";
                                        }
                                        if(nro==1){
                                            textImp += " UN MIL";
                                        }else{
                                            textImp += unidad[nro-1];
                                             textImp += " MIL";
                                        }
                                    }
                                }else{
                                    if(nro==1){
                                        textImp += " MIL";
                                    }else{
                                        textImp += unidad[nro-1];
                                         textImp += " MIL";
                                    }
                                }
                                
                            }else{
                                if(mil==1){
                                    textImp += " MIL";
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 8:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += decena[nro-1];
                                mil=1;
                            }else if(nro==1){
                            switch (Integer.parseInt(imp.charAt(i+1)+"")) {
                                case 0:
                                    textImp += decena[nro-1];
                                    mil=1;
                                    break;
                                case 1:
                                    textImp += " ONCE";
                                    mil=1;
                                    break;
                                case 2:
                                    textImp += " DOCE";
                                    mil=1;
                                    break;
                                case 3:
                                    textImp += " TRECE";
                                    mil=1;
                                    break;
                                case 4:
                                    textImp += " CATORCE";
                                    mil=1;
                                    break;
                                case 5:
                                    textImp += " QUINCE";
                                    mil=1;
                                    break;
                                default:
                                    textImp += decena[nro-1];
                                    break;
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 9:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += centena[nro-1];
                                mil=1;
                            }
                            if(nro==1){
                                if(Integer.parseInt(imp.charAt(i+1)+"")==0){
                                    textImp += " CIEN";
                                    mil=1;
                                }else{
                                    textImp += " CIENTO";
                                    mil=1;
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 10:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                
                                if(largo+agre>7 && i > 0){
                                    
                                    if(Integer.parseInt(imp.charAt(i-1)+"") == 1 && nro <= 5){
                                        textImp += " MILLONES";
                                    }else{
                                        if(Integer.parseInt(imp.charAt(i-1)+"") > 0){
                                            textImp += " Y";
                                        }
                                        if(nro==1){
                                            textImp += " UN MILLON";
                                        }else{
                                            textImp += unidad[nro-1];
                                             textImp += " MILLONES";
                                        }
                                    }
                                }else{
                                    if(nro==1){
                                        textImp += " UN MILLON";
                                    }else{
                                        textImp += unidad[nro-1];
                                         textImp += " MILLONES";
                                    }
                                }
                                
                            }else{
                                textImp += " MILLONES";
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 11:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += decena[nro-1];
                                mil=1;
                            }else if(nro==1){
                            switch (Integer.parseInt(imp.charAt(i+1)+"")) {
                                case 0:
                                    textImp += decena[nro-1];
                                    mil=1;
                                    break;
                                case 1:
                                    textImp += " ONCE";
                                    mil=1;
                                    break;
                                case 2:
                                    textImp += " DOCE";
                                    mil=1;
                                    break;
                                case 3:
                                    textImp += " TRECE";
                                    mil=1;
                                    break;
                                case 4:
                                    textImp += " CATORCE";
                                    mil=1;
                                    break;
                                case 5:
                                    textImp += " QUINCE";
                                    mil=1;
                                    break;
                                default:
                                    textImp += decena[nro-1];
                                    break;
                                }
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                            
                        case 12:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += centena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                    }
                }
            }catch(Exception e){
                System.out.println("Error al Convertir importe a letras con coma " + e.getMessage());
            }
        }else{
            try{
                for(int i = 0; i<largo;i++){
                    pos = largo - i;
                    switch(pos){
                        case 1:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                if(largo>1){
                                    textImp += " Y";
                                }
                                textImp += unidad[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 2:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += decena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 3:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += centena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 4:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(largo>4&&nro>0){
                                textImp += " Y";
                            }
                            if(nro>1){
                                textImp += unidad[nro-1];
                            }
                            textImp +=" MIL";
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 5:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += decena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 6:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += centena[nro-1];
                            }
                            if(nro==1){
                                textImp += " CIENTO";
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 7:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                if(largo>7){
                                    textImp += " Y";
                                }
                                textImp += unidad[nro-1];
                                if(nro==1){
                                    textImp += " MILLON";
                                }else{
                                     textImp += " MILLONES";
                                }
                            }else{
                                textImp += " MILLONES";
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 8:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += decena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 9:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>1){
                                textImp += centena[nro-1];
                            }
                            if(nro==1){
                                textImp += " CIENTO";
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 10:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(largo>10){
                                textImp += " Y";
                            }
                            if(nro>1){
                                textImp += unidad[nro-1];
                            }
                            textImp +=" MIL";
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                        case 11:
                            nro = Integer.parseInt(imp.charAt(i)+"");
                            if(nro>0){
                                textImp += decena[nro-1];
                            }
                            System.out.println("texto " + textImp + " en pos " + pos);
                            break;
                    }
                }
            }catch(Exception e){
                System.out.println("Error al Convertir imprte a letras " + e.getMessage());
            }
        }
        System.out.println("Termino " + textImp);
        textImp += " .- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ";
        return textImp;
    }
    public static String[] dividirStr(int corte,String str){
        String monto[] = new String[2];
        String ch = "";
        while(" ".equals(ch)){
            ch=str.substring(corte,1);
            corte -= 1;
        }
        System.out.println("corte " + corte);
        monto[0] = str.substring(0, corte);
        System.out.println("monto 1 " + monto[0]);
        monto[1] = str.substring(corte);
        System.out.println("monto 2 " + monto[1]);
        return monto;
    }
    
    public static int calcDias(String fecha1, String fecha2){
        int dia = 0;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date facha = sdf.parse(fecha1);
            cal.setTime(facha);
            String f = "";
            while(!fecha2.equals(f)){
                cal.add(Calendar.DAY_OF_MONTH, 1);
                
                
                String diac;
                String mes;
                String ano;
                int uno = cal.get(Calendar.DAY_OF_MONTH);
                int dos = cal.get(Calendar.MONTH) + 1;
                if(uno<10){
                    diac = "0"+cal.get(Calendar.DAY_OF_MONTH);
                }else{
                    diac = cal.get(Calendar.DAY_OF_MONTH)+"";
                }
                if(dos<10){
                    mes = "0"+(cal.get(Calendar.MONTH) + 1);
                }else{
                    mes = ""+(cal.get(Calendar.MONTH) + 1);
                }
                ano = cal.get(Calendar.YEAR)+"";
                f = diac+"-"+mes+"-"+ano;
                Feriados fer = FeriadosControlador.recFer(f);
                if(fer==null){
                    if(cal.get(Calendar.DAY_OF_WEEK)>1&&cal.get(Calendar.DAY_OF_WEEK)<7){
                        dia++;
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Formato.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dia;
        
    }
    
}

