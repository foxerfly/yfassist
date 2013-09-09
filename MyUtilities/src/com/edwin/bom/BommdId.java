package com.edwin.bom;
// Generated Sep 9, 2013 11:12:54 PM by Hibernate Tools 3.6.0



/**
 * BommdId generated by hbm2java
 */
public class BommdId  implements java.io.Serializable {


     private String md001;
     private String md002;

    public BommdId() {
    }

    public BommdId(String md001, String md002) {
       this.md001 = md001;
       this.md002 = md002;
    }
   
    public String getMd001() {
        return this.md001;
    }
    
    public void setMd001(String md001) {
        this.md001 = md001;
    }
    public String getMd002() {
        return this.md002;
    }
    
    public void setMd002(String md002) {
        this.md002 = md002;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BommdId) ) return false;
		 BommdId castOther = ( BommdId ) other; 
         
		 return ( (this.getMd001()==castOther.getMd001()) || ( this.getMd001()!=null && castOther.getMd001()!=null && this.getMd001().equals(castOther.getMd001()) ) )
 && ( (this.getMd002()==castOther.getMd002()) || ( this.getMd002()!=null && castOther.getMd002()!=null && this.getMd002().equals(castOther.getMd002()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getMd001() == null ? 0 : this.getMd001().hashCode() );
         result = 37 * result + ( getMd002() == null ? 0 : this.getMd002().hashCode() );
         return result;
   }   


}


