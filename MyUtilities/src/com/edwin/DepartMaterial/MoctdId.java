package com.edwin.DepartMaterial;
// Generated Jun 23, 2013 8:44:29 AM by Hibernate Tools 3.6.0



/**
 * MoctdId generated by hbm2java
 */
public class MoctdId  implements java.io.Serializable {


     private String td001;
     private String td002;
     private String td003;
     private String td004;

    public MoctdId() {
    }

    public MoctdId(String td001, String td002, String td003, String td004) {
       this.td001 = td001;
       this.td002 = td002;
       this.td003 = td003;
       this.td004 = td004;
    }
   
    public String getTd001() {
        return this.td001;
    }
    
    public void setTd001(String td001) {
        this.td001 = td001;
    }
    public String getTd002() {
        return this.td002;
    }
    
    public void setTd002(String td002) {
        this.td002 = td002;
    }
    public String getTd003() {
        return this.td003;
    }
    
    public void setTd003(String td003) {
        this.td003 = td003;
    }
    public String getTd004() {
        return this.td004;
    }
    
    public void setTd004(String td004) {
        this.td004 = td004;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MoctdId) ) return false;
		 MoctdId castOther = ( MoctdId ) other; 
         
		 return ( (this.getTd001()==castOther.getTd001()) || ( this.getTd001()!=null && castOther.getTd001()!=null && this.getTd001().equals(castOther.getTd001()) ) )
 && ( (this.getTd002()==castOther.getTd002()) || ( this.getTd002()!=null && castOther.getTd002()!=null && this.getTd002().equals(castOther.getTd002()) ) )
 && ( (this.getTd003()==castOther.getTd003()) || ( this.getTd003()!=null && castOther.getTd003()!=null && this.getTd003().equals(castOther.getTd003()) ) )
 && ( (this.getTd004()==castOther.getTd004()) || ( this.getTd004()!=null && castOther.getTd004()!=null && this.getTd004().equals(castOther.getTd004()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTd001() == null ? 0 : this.getTd001().hashCode() );
         result = 37 * result + ( getTd002() == null ? 0 : this.getTd002().hashCode() );
         result = 37 * result + ( getTd003() == null ? 0 : this.getTd003().hashCode() );
         result = 37 * result + ( getTd004() == null ? 0 : this.getTd004().hashCode() );
         return result;
   }   


}


