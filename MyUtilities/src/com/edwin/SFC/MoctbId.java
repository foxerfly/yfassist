package com.edwin.SFC;
// Generated Jun 13, 2013 1:39:36 PM by Hibernate Tools 3.6.0



/**
 * MoctbId generated by hbm2java
 */
public class MoctbId  implements java.io.Serializable {


     private String tb001;
     private String tb002;
     private String tb003;
     private String tb006;

    public MoctbId() {
    }

    public MoctbId(String tb001, String tb002, String tb003, String tb006) {
       this.tb001 = tb001;
       this.tb002 = tb002;
       this.tb003 = tb003;
       this.tb006 = tb006;
    }
   
    public String getTb001() {
        return this.tb001;
    }
    
    public void setTb001(String tb001) {
        this.tb001 = tb001;
    }
    public String getTb002() {
        return this.tb002;
    }
    
    public void setTb002(String tb002) {
        this.tb002 = tb002;
    }
    public String getTb003() {
        return this.tb003;
    }
    
    public void setTb003(String tb003) {
        this.tb003 = tb003;
    }
    public String getTb006() {
        return this.tb006;
    }
    
    public void setTb006(String tb006) {
        this.tb006 = tb006;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MoctbId) ) return false;
		 MoctbId castOther = ( MoctbId ) other; 
         
		 return ( (this.getTb001()==castOther.getTb001()) || ( this.getTb001()!=null && castOther.getTb001()!=null && this.getTb001().equals(castOther.getTb001()) ) )
 && ( (this.getTb002()==castOther.getTb002()) || ( this.getTb002()!=null && castOther.getTb002()!=null && this.getTb002().equals(castOther.getTb002()) ) )
 && ( (this.getTb003()==castOther.getTb003()) || ( this.getTb003()!=null && castOther.getTb003()!=null && this.getTb003().equals(castOther.getTb003()) ) )
 && ( (this.getTb006()==castOther.getTb006()) || ( this.getTb006()!=null && castOther.getTb006()!=null && this.getTb006().equals(castOther.getTb006()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTb001() == null ? 0 : this.getTb001().hashCode() );
         result = 37 * result + ( getTb002() == null ? 0 : this.getTb002().hashCode() );
         result = 37 * result + ( getTb003() == null ? 0 : this.getTb003().hashCode() );
         result = 37 * result + ( getTb006() == null ? 0 : this.getTb006().hashCode() );
         return result;
   }   


}


