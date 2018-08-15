package com.fundation.search.model;
import com.fundation.search.controller.Criteria;
import org.junit.Before;
import org.junit.Test;
import org.hamcrest.SelfDescribing;

import java.io.File;
import java.nio.file.Files;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestSearch {

    private Search searcha;
    private Criteria criteria;
    private AssetFile assetFile;

    public TestSearch() {
        searcha = new Search();
        criteria = new Criteria();
        assetFile = new AssetFile();
    }

    @Before
    public void before () {
    }

    @Test
    public void testSearchPath() {
        System.out.println(System.getProperty("user.dir"));
        String testPath = System.getProperty("user.dir")+"//resources//";
        assetFile.setPath(testPath);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        assertEquals(criteria.getPath(),assetFile.getPath());
        assertTrue(searcha.getResult().size()>0);
    }

    @Test
    public void testSearchName() {
        System.out.println(System.getProperty("user.dir"));
        String nameFile = "test3";
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setFileName(nameFile);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        boolean aux = true;
        for (Asset i : searcha.getResult()) {
            if (!i.getFileName().contains(nameFile)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchFile() {
        System.out.println(System.getProperty("user.dir"));
        boolean folder = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setFolder(folder);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        boolean aux = true;
        for (Asset i : searcha.getResult()) {
            if (!new File(i.getPath()).isDirectory()) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchFileHidden() {
        System.out.println(System.getProperty("user.dir"));
        boolean folderHidden = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setHidden(folderHidden);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        boolean aux = true;
        for (Asset i : searcha.getResult()) {
            if (!i.isHidden()) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchKeySensitive() {
        System.out.println(System.getProperty("user.dir"));
        String nameFile = "test3";
        boolean checkKey = false;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setKeySensitive(checkKey);
        criteria.setFileName(nameFile);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        assertTrue(searcha.getResult().size()==1);
    }

    @Test
    public void testSearchFileReadOnly() {
        System.out.println(System.getProperty("user.dir"));
        boolean folderRead = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setReadOnly(folderRead);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchReadOnly(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            if (!i.isRealOnline()) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchContent() {
        boolean checkContent = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        String content = "cesar";
        criteria.setCheckContent(checkContent);
        criteria.setContent(content);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchContent(criteria,alis);
        boolean aux = true;
        for (Asset i : alis) {
            List<String> fl;
            boolean aux2 = false;
            try {
                fl = Files.readAllLines(new File(i.getPath()).toPath());
                for (String i2 : fl) {
                    if (i2.contains(criteria.getContent())) {
                        aux2 = true;
                        break;
                    }
                }

            }
            catch (Exception ex) {
            }
            if (!aux2) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchOwner() {
        boolean checkOwner = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        String owner = "admin-hp";
        criteria.setCheckOwner(checkOwner);
        criteria.setOwner(owner);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.owner(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            if (!i.getOwner().contains(owner)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchExtencion() {
        boolean checkExtencion = true;
        ArrayList<String> extencion = new ArrayList<>();
        extencion.add("pdf");
        extencion.add("ppt");
        String testPath = System.getProperty("user.dir") + "//resources//";
        String owner = "admin-hp";
        criteria.setExtensionEnable(checkExtencion);
        criteria.setExtencionAux(String.join(";",extencion));
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.extencion(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            String ext = i.getExtent().replaceAll(".","");
            if (!criteria.getExtencionAux().contains(ext)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchDateMod () throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("05/05/2016");
        long time = date.getTime();
        Timestamp a1 = new Timestamp(time);
        Date date2 = dateFormat.parse("04/08/2018");
        long time2 = date2.getTime();
        Timestamp a2 = new Timestamp(time2);

        boolean checkDateMod = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setCheckMod(checkDateMod);
        criteria.setIniModFile(a1);
        criteria.setFinModFile(a2);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchDateMod(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            try {
                Date f1 = new Date(criteria.getIniModFile().getTime());
                Date f2 = new Date(criteria.getFinModFile().getTime());
                Date f3 = new Date(i.getDateModi().getTime());
                if (!(f3.after(f1) && f3.before(f2))) {
                    aux = false;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchDateAccess () throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("05/05/2016");
        long time = date.getTime();
        Timestamp a1 = new Timestamp(time);
        Date date2 = dateFormat.parse("04/08/2018");
        long time2 = date2.getTime();
        Timestamp a2 = new Timestamp(time2);

        boolean checkDateAccess = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setChecAccess(checkDateAccess);
        criteria.setIniAccessFile(a1);
        criteria.setFinAccessFile(a2);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchDateAccess(alis, criteria);
        boolean aux = true;
        for (Asset i : alis) {
            try {
                Date f1 = new Date(criteria.getIniAccessFile().getTime());
                Date f2 = new Date(criteria.getFinAccessFile().getTime());
                Date f3 = new Date(i.getDateAccess().getTime());
                if (f3.after(f1) && f3.before(f2)) {
                    aux = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchDateCreation () throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("05/05/2016");
        long time = date.getTime();
        Timestamp a1 = new Timestamp(time);
        Date date2 = dateFormat.parse("04/08/2018");
        long time2 = date2.getTime();
        Timestamp a2 = new Timestamp(time2);
        boolean checkDateCreation = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setCheckCre(checkDateCreation);
        criteria.setIniCreationFile(a1);
        criteria.setFinCreationFile(a2);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchDateCreation(alis, criteria);
        boolean aux = true;
        for (Asset i : alis) {
            try {
                Date f1 = new Date(criteria.getIniCreationFile().getTime());
                Date f2 = new Date(criteria.getFinCreationFile().getTime());
                Date f3 = new Date(i.getDateCreacion().getTime());
                if (f3.after(f1) & f3.before(f2)) {
                    aux = false;

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSize () {
        boolean checkSize = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        String type = "<" ;
        String sign = "Mbytes";
        double cant = 1.0;
        criteria.setCheckSize(checkSize);
        criteria.setSignSize(sign);
        criteria.setTypeSize(type);
        criteria.setSize(cant);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchSze(alis, criteria);
        boolean aux = true;
        double aux2 = criteria.getSize();
        if (criteria.getSignSize().equals("Kbytes")) {
            aux2 = aux2 * 1000.0;
        }
        if (criteria.getSignSize().equals("Mbytes")) {
            aux2 = aux2 *  1000000.0;
        }
        for (Asset i : alis) {
            double n1 = aux2;
            double n2 = Double.parseDouble(String.valueOf(i.getSize()));
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            if (criteria.getType().equals("=")) {
                if (n2 != n1) {
                    aux = false;
                    break;
                }
            }
            if (criteria.getType().equals("<")) {
                if (!(n2 < n1)) {
                    aux = false;
                    break;
                }
            }
            if (criteria.getType().equals(">")) {
                if (!(n2 > n1)) {
                    aux = false;
                    break;
                }
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testSearchMultimedia() {
        boolean checkMulti = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setCheckMulti(checkMulti);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchSze(alis, criteria);
        boolean aux = true;
        for (Asset i : alis) {
            if (!i.isMultimedia()) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }


    @Test
    public void testSearcDuration () {
        boolean checkSize = true;
        String testPath = System.getProperty("user.dir") + "//resources//";
        String operator = ">" ;
        String scale = "M";
        double cant = 4.0;
        criteria.setCheckMulti(true);
        criteria.setCheckSize(checkSize);
        criteria.setScale(scale);
        criteria.setOperator(operator);
        criteria.setCantMulti(cant);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.searchSze(alis, criteria);
        boolean aux = true;
        double aux2 = criteria.getCantMulti();
        if (criteria.getScale().equals("H")) {
            aux2 = aux2 * 3600.0;
        }
        if (criteria.getScale().equals("M")) {
            aux2 = aux2 * 60.0;
        }
        for (Asset i : alis) {
            AssetMultimed asm = (AssetMultimed) i;
            double n1 = aux2;
            double n2 = asm.getDuracion();
            n1 = Math.round(n1 * 1000) / 1000;
            n2 = Math.round(n2 * 1000) / 1000;
            if (criteria.getOperator().equals("=")) {
                if (!(n2 == n1)) {
                    aux = false;
                    break;
                }
            }
            if (criteria.getOperator().equals("<")) {
                if (!(n2 < n1)) {
                    aux = false;
                    break;
                }
            }
            if (criteria.getOperator().equals(">")) {
                if (!(n2 > n1)) {
                    aux = false;
                    break;
                }
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testCheckMulti () {
        ArrayList<String> extencionMulti = new ArrayList<>();
        extencionMulti.add("MP3");
        extencionMulti.add("FLV");
        String testPath = System.getProperty("user.dir") + "//resources//";
        criteria.setCheckMulti(true);
        criteria.setFormatsMulti(extencionMulti);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.checkMulti(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            String aux2 = String.join(";",extencionMulti);
            String ext = i.getExtent().replaceAll(".","").toUpperCase();
            if (!aux2.contains(ext)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testCheckVideoCode () {
        String videoCode = "H264";
        String testPath = System.getProperty("user.dir") + "//resources//multi//";
        criteria.setCheckMulti(true);
        criteria.setVideoCode(videoCode);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.checkVideoCode(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getCodec());
            frame = frame.toUpperCase();
            if (!criteria.getVideoCode().equals(frame)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }

    @Test
    public void testCheckResolution () {
        String resolution = "1280x720";
        String testPath = System.getProperty("user.dir") + "//resources//multi//";
        criteria.setCheckMulti(true);
        criteria.setResolution(resolution);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.checkResolution(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getResolucion());
            if (!criteria.getResolution().equals(frame)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }


    @Test
    public void testCheckFrame () {
        String frame1 = "30";
        String testPath = System.getProperty("user.dir") + "//resources//multi//";
        criteria.setCheckMulti(true);
        criteria.setFrameRate(frame1);
        criteria.setPath(testPath);
        searcha.searchPath(criteria);
        ArrayList<Asset> alis = (ArrayList<Asset>) searcha.getResult();
        alis = searcha.checkFrame(alis,criteria);
        boolean aux = true;
        for (Asset i : alis) {
            AssetMultimed asm = (AssetMultimed) i;
            String frame = ((asm).getFrameRate());
            frame = frame.substring(0, frame.indexOf("/"));
            if (frame != null && !criteria.getFrameRate().equals(frame)) {
                aux = false;
                break;
            }
        }
        assertTrue(aux);
    }



}