package com.edwin.SFC;
// Generated Jun 13, 2013 1:39:36 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;

/**
 * Sfcta generated by hbm2java
 */
public class Sfcta  implements java.io.Serializable {


     private SfctaId id;
     private String company;
     private String creator;
     private String usrGroup;
     private String createDate;
     private String modifier;
     private String modiDate;
     private Short flag;
     private String ta004;
     private Character ta005;
     private String ta007;
     private String ta008;
     private String ta009;
     private BigDecimal ta010;
     private BigDecimal ta011;
     private BigDecimal ta012;
     private BigDecimal ta013;
     private BigDecimal ta014;
     private BigDecimal ta015;
     private BigDecimal ta016;
     private BigDecimal ta017;
     private String ta018;
     private BigDecimal ta019;
     private String ta020;
     private BigDecimal ta021;
     private Integer ta022;
     private Integer ta023;
     private String ta024;
     private Integer ta025;
     private BigDecimal ta026;
     private BigDecimal ta027;
     private Integer ta028;
     private BigDecimal ta029;
     private String ta030;
     private String ta031;
     private Character ta032;
     private Character ta033;
     private String ta034;
     private Integer ta035;
     private Integer ta036;
     private Short ta037;
     private BigDecimal ta038;
     private BigDecimal ta039;
     private BigDecimal ta040;
     private BigDecimal ta041;
     private BigDecimal ta042;
     private BigDecimal ta043;
     private BigDecimal ta044;
     private BigDecimal ta045;
     private Character ta046;
     private Character ta047;
     private BigDecimal ta048;
     private BigDecimal ta049;
     private Character ta050;
     private String ta051;
     private Character ta052;
     private Character ta053;
     private String ta054;
     private String ta055;
     private BigDecimal ta056;
     private BigDecimal ta057;
     private BigDecimal ta058;
     private BigDecimal ta059;
     private BigDecimal ta060;
     private String ta061;
     private String udf01;
     private String udf02;
     private String udf03;
     private String udf04;
     private String udf05;
     private String udf06;
     private BigDecimal udf51;
     private BigDecimal udf52;
     private BigDecimal udf53;
     private BigDecimal udf54;
     private BigDecimal udf55;
     private BigDecimal udf56;
     private String udf07;
     private String udf08;
     private String udf09;
     private String udf10;
     private String udf11;
     private String udf12;
     private BigDecimal udf57;
     private BigDecimal udf58;
     private BigDecimal udf59;
     private BigDecimal udf60;
     private BigDecimal udf61;
     private BigDecimal udf62;

    public Sfcta() {
    }

	
    public Sfcta(SfctaId id) {
        this.id = id;
    }
    public Sfcta(SfctaId id, String company, String creator, String usrGroup, String createDate, String modifier, String modiDate, Short flag, String ta004, Character ta005, String ta007, String ta008, String ta009, BigDecimal ta010, BigDecimal ta011, BigDecimal ta012, BigDecimal ta013, BigDecimal ta014, BigDecimal ta015, BigDecimal ta016, BigDecimal ta017, String ta018, BigDecimal ta019, String ta020, BigDecimal ta021, Integer ta022, Integer ta023, String ta024, Integer ta025, BigDecimal ta026, BigDecimal ta027, Integer ta028, BigDecimal ta029, String ta030, String ta031, Character ta032, Character ta033, String ta034, Integer ta035, Integer ta036, Short ta037, BigDecimal ta038, BigDecimal ta039, BigDecimal ta040, BigDecimal ta041, BigDecimal ta042, BigDecimal ta043, BigDecimal ta044, BigDecimal ta045, Character ta046, Character ta047, BigDecimal ta048, BigDecimal ta049, Character ta050, String ta051, Character ta052, Character ta053, String ta054, String ta055, BigDecimal ta056, BigDecimal ta057, BigDecimal ta058, BigDecimal ta059, BigDecimal ta060, String ta061, String udf01, String udf02, String udf03, String udf04, String udf05, String udf06, BigDecimal udf51, BigDecimal udf52, BigDecimal udf53, BigDecimal udf54, BigDecimal udf55, BigDecimal udf56, String udf07, String udf08, String udf09, String udf10, String udf11, String udf12, BigDecimal udf57, BigDecimal udf58, BigDecimal udf59, BigDecimal udf60, BigDecimal udf61, BigDecimal udf62) {
       this.id = id;
       this.company = company;
       this.creator = creator;
       this.usrGroup = usrGroup;
       this.createDate = createDate;
       this.modifier = modifier;
       this.modiDate = modiDate;
       this.flag = flag;
       this.ta004 = ta004;
       this.ta005 = ta005;
       this.ta007 = ta007;
       this.ta008 = ta008;
       this.ta009 = ta009;
       this.ta010 = ta010;
       this.ta011 = ta011;
       this.ta012 = ta012;
       this.ta013 = ta013;
       this.ta014 = ta014;
       this.ta015 = ta015;
       this.ta016 = ta016;
       this.ta017 = ta017;
       this.ta018 = ta018;
       this.ta019 = ta019;
       this.ta020 = ta020;
       this.ta021 = ta021;
       this.ta022 = ta022;
       this.ta023 = ta023;
       this.ta024 = ta024;
       this.ta025 = ta025;
       this.ta026 = ta026;
       this.ta027 = ta027;
       this.ta028 = ta028;
       this.ta029 = ta029;
       this.ta030 = ta030;
       this.ta031 = ta031;
       this.ta032 = ta032;
       this.ta033 = ta033;
       this.ta034 = ta034;
       this.ta035 = ta035;
       this.ta036 = ta036;
       this.ta037 = ta037;
       this.ta038 = ta038;
       this.ta039 = ta039;
       this.ta040 = ta040;
       this.ta041 = ta041;
       this.ta042 = ta042;
       this.ta043 = ta043;
       this.ta044 = ta044;
       this.ta045 = ta045;
       this.ta046 = ta046;
       this.ta047 = ta047;
       this.ta048 = ta048;
       this.ta049 = ta049;
       this.ta050 = ta050;
       this.ta051 = ta051;
       this.ta052 = ta052;
       this.ta053 = ta053;
       this.ta054 = ta054;
       this.ta055 = ta055;
       this.ta056 = ta056;
       this.ta057 = ta057;
       this.ta058 = ta058;
       this.ta059 = ta059;
       this.ta060 = ta060;
       this.ta061 = ta061;
       this.udf01 = udf01;
       this.udf02 = udf02;
       this.udf03 = udf03;
       this.udf04 = udf04;
       this.udf05 = udf05;
       this.udf06 = udf06;
       this.udf51 = udf51;
       this.udf52 = udf52;
       this.udf53 = udf53;
       this.udf54 = udf54;
       this.udf55 = udf55;
       this.udf56 = udf56;
       this.udf07 = udf07;
       this.udf08 = udf08;
       this.udf09 = udf09;
       this.udf10 = udf10;
       this.udf11 = udf11;
       this.udf12 = udf12;
       this.udf57 = udf57;
       this.udf58 = udf58;
       this.udf59 = udf59;
       this.udf60 = udf60;
       this.udf61 = udf61;
       this.udf62 = udf62;
    }
   
    public SfctaId getId() {
        return this.id;
    }
    
    public void setId(SfctaId id) {
        this.id = id;
    }
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }
    public String getCreator() {
        return this.creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    public String getUsrGroup() {
        return this.usrGroup;
    }
    
    public void setUsrGroup(String usrGroup) {
        this.usrGroup = usrGroup;
    }
    public String getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    public String getModifier() {
        return this.modifier;
    }
    
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    public String getModiDate() {
        return this.modiDate;
    }
    
    public void setModiDate(String modiDate) {
        this.modiDate = modiDate;
    }
    public Short getFlag() {
        return this.flag;
    }
    
    public void setFlag(Short flag) {
        this.flag = flag;
    }
    public String getTa004() {
        return this.ta004;
    }
    
    public void setTa004(String ta004) {
        this.ta004 = ta004;
    }
    public Character getTa005() {
        return this.ta005;
    }
    
    public void setTa005(Character ta005) {
        this.ta005 = ta005;
    }
    public String getTa007() {
        return this.ta007;
    }
    
    public void setTa007(String ta007) {
        this.ta007 = ta007;
    }
    public String getTa008() {
        return this.ta008;
    }
    
    public void setTa008(String ta008) {
        this.ta008 = ta008;
    }
    public String getTa009() {
        return this.ta009;
    }
    
    public void setTa009(String ta009) {
        this.ta009 = ta009;
    }
    public BigDecimal getTa010() {
        return this.ta010;
    }
    
    public void setTa010(BigDecimal ta010) {
        this.ta010 = ta010;
    }
    public BigDecimal getTa011() {
        return this.ta011;
    }
    
    public void setTa011(BigDecimal ta011) {
        this.ta011 = ta011;
    }
    public BigDecimal getTa012() {
        return this.ta012;
    }
    
    public void setTa012(BigDecimal ta012) {
        this.ta012 = ta012;
    }
    public BigDecimal getTa013() {
        return this.ta013;
    }
    
    public void setTa013(BigDecimal ta013) {
        this.ta013 = ta013;
    }
    public BigDecimal getTa014() {
        return this.ta014;
    }
    
    public void setTa014(BigDecimal ta014) {
        this.ta014 = ta014;
    }
    public BigDecimal getTa015() {
        return this.ta015;
    }
    
    public void setTa015(BigDecimal ta015) {
        this.ta015 = ta015;
    }
    public BigDecimal getTa016() {
        return this.ta016;
    }
    
    public void setTa016(BigDecimal ta016) {
        this.ta016 = ta016;
    }
    public BigDecimal getTa017() {
        return this.ta017;
    }
    
    public void setTa017(BigDecimal ta017) {
        this.ta017 = ta017;
    }
    public String getTa018() {
        return this.ta018;
    }
    
    public void setTa018(String ta018) {
        this.ta018 = ta018;
    }
    public BigDecimal getTa019() {
        return this.ta019;
    }
    
    public void setTa019(BigDecimal ta019) {
        this.ta019 = ta019;
    }
    public String getTa020() {
        return this.ta020;
    }
    
    public void setTa020(String ta020) {
        this.ta020 = ta020;
    }
    public BigDecimal getTa021() {
        return this.ta021;
    }
    
    public void setTa021(BigDecimal ta021) {
        this.ta021 = ta021;
    }
    public Integer getTa022() {
        return this.ta022;
    }
    
    public void setTa022(Integer ta022) {
        this.ta022 = ta022;
    }
    public Integer getTa023() {
        return this.ta023;
    }
    
    public void setTa023(Integer ta023) {
        this.ta023 = ta023;
    }
    public String getTa024() {
        return this.ta024;
    }
    
    public void setTa024(String ta024) {
        this.ta024 = ta024;
    }
    public Integer getTa025() {
        return this.ta025;
    }
    
    public void setTa025(Integer ta025) {
        this.ta025 = ta025;
    }
    public BigDecimal getTa026() {
        return this.ta026;
    }
    
    public void setTa026(BigDecimal ta026) {
        this.ta026 = ta026;
    }
    public BigDecimal getTa027() {
        return this.ta027;
    }
    
    public void setTa027(BigDecimal ta027) {
        this.ta027 = ta027;
    }
    public Integer getTa028() {
        return this.ta028;
    }
    
    public void setTa028(Integer ta028) {
        this.ta028 = ta028;
    }
    public BigDecimal getTa029() {
        return this.ta029;
    }
    
    public void setTa029(BigDecimal ta029) {
        this.ta029 = ta029;
    }
    public String getTa030() {
        return this.ta030;
    }
    
    public void setTa030(String ta030) {
        this.ta030 = ta030;
    }
    public String getTa031() {
        return this.ta031;
    }
    
    public void setTa031(String ta031) {
        this.ta031 = ta031;
    }
    public Character getTa032() {
        return this.ta032;
    }
    
    public void setTa032(Character ta032) {
        this.ta032 = ta032;
    }
    public Character getTa033() {
        return this.ta033;
    }
    
    public void setTa033(Character ta033) {
        this.ta033 = ta033;
    }
    public String getTa034() {
        return this.ta034;
    }
    
    public void setTa034(String ta034) {
        this.ta034 = ta034;
    }
    public Integer getTa035() {
        return this.ta035;
    }
    
    public void setTa035(Integer ta035) {
        this.ta035 = ta035;
    }
    public Integer getTa036() {
        return this.ta036;
    }
    
    public void setTa036(Integer ta036) {
        this.ta036 = ta036;
    }
    public Short getTa037() {
        return this.ta037;
    }
    
    public void setTa037(Short ta037) {
        this.ta037 = ta037;
    }
    public BigDecimal getTa038() {
        return this.ta038;
    }
    
    public void setTa038(BigDecimal ta038) {
        this.ta038 = ta038;
    }
    public BigDecimal getTa039() {
        return this.ta039;
    }
    
    public void setTa039(BigDecimal ta039) {
        this.ta039 = ta039;
    }
    public BigDecimal getTa040() {
        return this.ta040;
    }
    
    public void setTa040(BigDecimal ta040) {
        this.ta040 = ta040;
    }
    public BigDecimal getTa041() {
        return this.ta041;
    }
    
    public void setTa041(BigDecimal ta041) {
        this.ta041 = ta041;
    }
    public BigDecimal getTa042() {
        return this.ta042;
    }
    
    public void setTa042(BigDecimal ta042) {
        this.ta042 = ta042;
    }
    public BigDecimal getTa043() {
        return this.ta043;
    }
    
    public void setTa043(BigDecimal ta043) {
        this.ta043 = ta043;
    }
    public BigDecimal getTa044() {
        return this.ta044;
    }
    
    public void setTa044(BigDecimal ta044) {
        this.ta044 = ta044;
    }
    public BigDecimal getTa045() {
        return this.ta045;
    }
    
    public void setTa045(BigDecimal ta045) {
        this.ta045 = ta045;
    }
    public Character getTa046() {
        return this.ta046;
    }
    
    public void setTa046(Character ta046) {
        this.ta046 = ta046;
    }
    public Character getTa047() {
        return this.ta047;
    }
    
    public void setTa047(Character ta047) {
        this.ta047 = ta047;
    }
    public BigDecimal getTa048() {
        return this.ta048;
    }
    
    public void setTa048(BigDecimal ta048) {
        this.ta048 = ta048;
    }
    public BigDecimal getTa049() {
        return this.ta049;
    }
    
    public void setTa049(BigDecimal ta049) {
        this.ta049 = ta049;
    }
    public Character getTa050() {
        return this.ta050;
    }
    
    public void setTa050(Character ta050) {
        this.ta050 = ta050;
    }
    public String getTa051() {
        return this.ta051;
    }
    
    public void setTa051(String ta051) {
        this.ta051 = ta051;
    }
    public Character getTa052() {
        return this.ta052;
    }
    
    public void setTa052(Character ta052) {
        this.ta052 = ta052;
    }
    public Character getTa053() {
        return this.ta053;
    }
    
    public void setTa053(Character ta053) {
        this.ta053 = ta053;
    }
    public String getTa054() {
        return this.ta054;
    }
    
    public void setTa054(String ta054) {
        this.ta054 = ta054;
    }
    public String getTa055() {
        return this.ta055;
    }
    
    public void setTa055(String ta055) {
        this.ta055 = ta055;
    }
    public BigDecimal getTa056() {
        return this.ta056;
    }
    
    public void setTa056(BigDecimal ta056) {
        this.ta056 = ta056;
    }
    public BigDecimal getTa057() {
        return this.ta057;
    }
    
    public void setTa057(BigDecimal ta057) {
        this.ta057 = ta057;
    }
    public BigDecimal getTa058() {
        return this.ta058;
    }
    
    public void setTa058(BigDecimal ta058) {
        this.ta058 = ta058;
    }
    public BigDecimal getTa059() {
        return this.ta059;
    }
    
    public void setTa059(BigDecimal ta059) {
        this.ta059 = ta059;
    }
    public BigDecimal getTa060() {
        return this.ta060;
    }
    
    public void setTa060(BigDecimal ta060) {
        this.ta060 = ta060;
    }
    public String getTa061() {
        return this.ta061;
    }
    
    public void setTa061(String ta061) {
        this.ta061 = ta061;
    }
    public String getUdf01() {
        return this.udf01;
    }
    
    public void setUdf01(String udf01) {
        this.udf01 = udf01;
    }
    public String getUdf02() {
        return this.udf02;
    }
    
    public void setUdf02(String udf02) {
        this.udf02 = udf02;
    }
    public String getUdf03() {
        return this.udf03;
    }
    
    public void setUdf03(String udf03) {
        this.udf03 = udf03;
    }
    public String getUdf04() {
        return this.udf04;
    }
    
    public void setUdf04(String udf04) {
        this.udf04 = udf04;
    }
    public String getUdf05() {
        return this.udf05;
    }
    
    public void setUdf05(String udf05) {
        this.udf05 = udf05;
    }
    public String getUdf06() {
        return this.udf06;
    }
    
    public void setUdf06(String udf06) {
        this.udf06 = udf06;
    }
    public BigDecimal getUdf51() {
        return this.udf51;
    }
    
    public void setUdf51(BigDecimal udf51) {
        this.udf51 = udf51;
    }
    public BigDecimal getUdf52() {
        return this.udf52;
    }
    
    public void setUdf52(BigDecimal udf52) {
        this.udf52 = udf52;
    }
    public BigDecimal getUdf53() {
        return this.udf53;
    }
    
    public void setUdf53(BigDecimal udf53) {
        this.udf53 = udf53;
    }
    public BigDecimal getUdf54() {
        return this.udf54;
    }
    
    public void setUdf54(BigDecimal udf54) {
        this.udf54 = udf54;
    }
    public BigDecimal getUdf55() {
        return this.udf55;
    }
    
    public void setUdf55(BigDecimal udf55) {
        this.udf55 = udf55;
    }
    public BigDecimal getUdf56() {
        return this.udf56;
    }
    
    public void setUdf56(BigDecimal udf56) {
        this.udf56 = udf56;
    }
    public String getUdf07() {
        return this.udf07;
    }
    
    public void setUdf07(String udf07) {
        this.udf07 = udf07;
    }
    public String getUdf08() {
        return this.udf08;
    }
    
    public void setUdf08(String udf08) {
        this.udf08 = udf08;
    }
    public String getUdf09() {
        return this.udf09;
    }
    
    public void setUdf09(String udf09) {
        this.udf09 = udf09;
    }
    public String getUdf10() {
        return this.udf10;
    }
    
    public void setUdf10(String udf10) {
        this.udf10 = udf10;
    }
    public String getUdf11() {
        return this.udf11;
    }
    
    public void setUdf11(String udf11) {
        this.udf11 = udf11;
    }
    public String getUdf12() {
        return this.udf12;
    }
    
    public void setUdf12(String udf12) {
        this.udf12 = udf12;
    }
    public BigDecimal getUdf57() {
        return this.udf57;
    }
    
    public void setUdf57(BigDecimal udf57) {
        this.udf57 = udf57;
    }
    public BigDecimal getUdf58() {
        return this.udf58;
    }
    
    public void setUdf58(BigDecimal udf58) {
        this.udf58 = udf58;
    }
    public BigDecimal getUdf59() {
        return this.udf59;
    }
    
    public void setUdf59(BigDecimal udf59) {
        this.udf59 = udf59;
    }
    public BigDecimal getUdf60() {
        return this.udf60;
    }
    
    public void setUdf60(BigDecimal udf60) {
        this.udf60 = udf60;
    }
    public BigDecimal getUdf61() {
        return this.udf61;
    }
    
    public void setUdf61(BigDecimal udf61) {
        this.udf61 = udf61;
    }
    public BigDecimal getUdf62() {
        return this.udf62;
    }
    
    public void setUdf62(BigDecimal udf62) {
        this.udf62 = udf62;
    }




}


